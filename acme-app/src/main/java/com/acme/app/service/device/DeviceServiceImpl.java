package com.acme.app.service.device;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.acme.api.enums.AcmeResponseEnums;
import com.acme.api.enums.DeviceType;
import com.acme.api.exception.AcmeRuntimeException;
import com.acme.api.utils.CacheUtils;
import com.acme.api.utils.DateUtils;
import com.acme.app.mapper.device.DataPointMapper;
import com.acme.app.mapper.device.DeviceMapper;
import com.acme.app.mapper.device.SensorMapper;
import com.acme.app.mapper.user.UserMapper;
import com.acme.app.model.device.DataPoint;
import com.acme.app.model.device.Device;
import com.acme.app.model.device.Sensor;
import com.acme.app.model.user.User;

import com.acme.app.request.device.DatapointCreate;

@Service
public class DeviceServiceImpl implements DeviceService{

	@Resource
	private DeviceMapper deviceMapper;
	@Resource
	private SensorMapper sensorMapper;
	@Resource
	private DataPointMapper dataPintMapper;
	@Resource
	private UserMapper userMapper;

	private static final Boolean obj=true;
	@Override
	public Long create(Device device) {
		checkUserType(device.getUserKey());
		checkDeviceType(device.getType());
		device.setGmtCreate(DateUtils.getDate());
		deviceMapper.insert(device);
		return device.getId();
	}
	@Override
	public void updateDevice(Device device) {
		checkDevice(device.getId());
		checkDeviceType(device.getType());
		device.setGmtModified(DateUtils.getDate());
		deviceMapper.updateByPrimaryKeySelective(device);
	}

	@Transactional
	@Override
	public void deleteDeviceById(Long id) {
		checkDevice(id);
		//查询出相应的所有传感器：
		List<Sensor> sensors = sensorMapper.findSensorByDevice(id);
		if(sensors!=null&&sensors.size()>0){
			Long[] dataIds=new Long[sensors.size()];
			for (int i=0;i<sensors.size();i++) {
				dataIds[i]=sensors.get(i).getId();
			}
			//删除对应的数据节点
			dataPintMapper.deleteBySensor(dataIds);
			////删除对应的传感器
			sensorMapper.deleteByDeviceId(id);
		}
		//删除对应的设备
		deviceMapper.deleteByPrimaryKey(id);
	}

	@Override
	public Long createSensor(Sensor sensor) {
		checkDevice(sensor.getDeviceId());
		checkDeviceType(Integer.parseInt(sensor.getType()));
		sensor.setGmtCreate(DateUtils.getDate());
		sensorMapper.insert(sensor);
		return sensor.getId();
	}

	@Override
	public void updateSensor(Sensor sensor) {
		checkDeviceType(Integer.parseInt(sensor.getType()));
		sensor.setGmtModified(DateUtils.getDate());
		sensorMapper.updateByPrimaryKeySelective(sensor);
	}
	@Transactional
	@Override
	public void deleteSensor(Long[] ids) {
		if(ids!=null&&ids.length>0){
			//删除数据节点
			dataPintMapper.deleteBySensor(ids);
			//删除传感器信息
			sensorMapper.deleteByIds(ids);
		}
	}
	@Override
	public  void createDataPoint(DatapointCreate dataPoint,String userKey) {
		//检查userKey
		User user = userMapper.selectByUserKey(userKey);
		if(user==null){
			throw new AcmeRuntimeException(AcmeResponseEnums.NO_PERMISSION);
		}
		//检查用户相关的设备是否一致：
		Device device = deviceMapper.findDevicebyId(userKey, dataPoint.getDeviceId());
		if(device==null){
			throw new AcmeRuntimeException(AcmeResponseEnums.BAD_REQUEST);
		}
		Sensor sensor=checkSensor(dataPoint.getDeviceId(),dataPoint.getSensorId());
		
		DataPoint point=new DataPoint();
		point.setDeviceId(dataPoint.getDeviceId());
		point.setSensorId(dataPoint.getSensorId());
		point.setValue(dataPoint.getValue());
		point.setDataType(Integer.parseInt(sensor.getType()));
		point.setGmtCreate(DateUtils.getDate());
		dataPintMapper.insertSelective(point);
	}
	@Override
	public void deleteDataPoint(Long[] ids) {
		if(ids!=null&&ids.length>0){
			dataPintMapper.deleteByIds(ids);
		}
	}
	/**
	 * 防止设备id伪造后数据库被破坏
	 * @param id 传入的设备的id
	 */
	private void checkDevice(Long id){
		if(deviceMapper.selectByPrimaryKey(id)==null)
			throw new AcmeRuntimeException(AcmeResponseEnums.DEVICE_NOT_EXISTS);
	}
	/**
	 * 防止传感器id被伪造
	 * @param deviceId 传入的设备的id
	 * @param sensorId 传入的传感器的id
	 * @return 
	 */
	private Sensor checkSensor(Long deviceId,Long sensorId){
		checkDevice(deviceId);
		Sensor sensor = sensorMapper.selectByPrimaryKey(sensorId);
		if(sensor==null){
			throw new AcmeRuntimeException(AcmeResponseEnums.SENSOR_NOT_EXISTS);
		}
		return sensor;

	}
	/**
	 * 验证设备类型是否正确
	 * @param code
	 */
	private void checkDeviceType(int code){
		if(DeviceType.getType(code)==null||code!=1&&code!=2){
			throw new AcmeRuntimeException(AcmeResponseEnums.BAD_REQUEST_TYPE);
		}
	}

	private void checkUserType(String userKey){
		User user = CacheUtils.getInstance().getObject(userKey);
		if(user!=null){
			//获取到用户的类型；
			int a=10;
			int b=30;
			//检查用户的身份：一般用户还是企业用户
			//用户分为：一般用户
			/**
			 * 一、企业用户：
			 * 
			 * 										企业：（最高级管理员）
			 * 								（这里就是跟普通的用户一样放在用户表上，标识为企业用户）
			 * 										 | 				
			 * 										 |
			 * 		----------------------------------------------------------
			 * 		|      |         |         |        |         |           |
			 * 	     普通用户	   普通用户	        普通用户	      普通用户	       普通用户               普通用户                 普通用户
			 * 		
			 * 
			 * 	
			 * 
			 * 	注：可以关联的设备是可定的企业用户本身的角色跟普通的用户已经区分开。
			 * 	       企业内部的用户信息都要跟企业本身信息相互关联，互不干涉。
			 * 	   
			 * 
			 * 二、普通用户：
			 * 	标识为个人用户：
			 * 	可以关联的设备是可定的
			 * 
			 *  这在每次的关联设备操作时都要检查用户的身份，
			 *  
			 *  
			 *  
			 */
			List<Device> deviceList = deviceMapper.findDeviceByCondition(userKey);
			if(deviceList!=null&&deviceList.size()>0){
				if(deviceList.size()>30){

				}else{

				}
			}
			//
		}
		throw new AcmeRuntimeException(AcmeResponseEnums.NOLOGIN);

	}







}
