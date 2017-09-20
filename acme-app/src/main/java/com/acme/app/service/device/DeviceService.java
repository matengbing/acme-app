package com.acme.app.service.device;

import com.acme.app.model.device.DataPoint;
import com.acme.app.model.device.Device;
import com.acme.app.model.device.Sensor;
import com.acme.app.request.device.DatapointCreate;

/**
 * 用户自定义设备服务接口
 * @author YL.Z
 *
 * @date 2017年3月29日 下午12:21:32
 */
public interface DeviceService {
	/**设备操作*/
	
	/**
	 * 创建一个设备。并且返回设备的id
	 * 创建设备时应该判断创建设备的用户类型，限制用户的设备数量
	 * 企业用户创建自己的设备数量：30
	 * 个人用户创建自己的设备数量为：10
	 * @param device 有关设备的基本数据，一个设备对象
	 * @return
	 */
	Long create(Device device);
	/**
	 * 修改设备信息
	 * @param device设备对象
	 */
	void updateDevice(Device device);
	/**
	 * 删除用户所属的设备
	 * @param id 设备的id
	 */
	void  deleteDeviceById(Long id);
	
	
	/**传感器操作**/
	
	/**
	 * 给设备新增一个传感器，
	 * @param sensor 传感器对象
	 * @return
	 */
	Long createSensor(Sensor sensor);
	/**
	 * 修改传感器的基本信息
	 * @param sensor
	 */
	void updateSensor(Sensor sensor);
	/**
	 * 根据id删除传感器对象
	 * @param ids 传感器的id
	 */
	void deleteSensor(Long[] ids);
	
	/**数据节点判断*/
	
	/**
	 * 传感器上传数据节点
	 * @param create  传感器的数据封装对象
	 * @param userKey 用户的唯一标识码
	 */
	void createDataPoint(DatapointCreate create,String userKey);
	
	/**
	 * 删除数据节点
	 * @param ids
	 */
	void deleteDataPoint(Long[] ids);
	
	
	
	
	
	
	
	
	
	
	
	
}
