package com.acme.app.controller;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.acme.api.enums.AcmeResponseEnums;
import com.acme.api.response.ResponseBean;
import com.acme.app.model.device.Device;
import com.acme.app.model.device.Sensor;
import com.acme.app.request.device.DatapointCreate;
import com.acme.app.service.device.DeviceService;

/**
 * 设备http接口
 * @author YL.Z
 *
 * @date 2017年4月1日 下午3:36:51
 */
@RestController
@RequestMapping(value={"/device"},method=RequestMethod.POST)
public class DeviceController{
	
	
	@Resource
	DeviceService deviceService;
	
	/**
	 * 创建设备接口
	 * @param device
	 * @return
	 */
	@RequestMapping(value={"/create"})
	@ResponseBody
	public ResponseBean<Long> createDevice(@RequestBody Device device){
		Long create = deviceService.create(device);
		return new ResponseBean<Long>(true, create,AcmeResponseEnums.SUCCESS_OPTION);
	}
	/**
	 * 设备信息修改接口
	 * @param device
	 * @return
	 */
	@RequestMapping(value={"/update"})
	@ResponseBody
	public ResponseBean<Long> updateDevice(@RequestBody Device device){
		deviceService.updateDevice(device);
		return new ResponseBean<Long>(true,AcmeResponseEnums.SUCCESS_OPTION);
	}
	/**
	 * 删除设备信息接口
	 * @param id
	 * @return
	 */
	@RequestMapping(value={"/delete/{id}"})
	@ResponseBody
	public ResponseBean<String> delete(@PathVariable("id") Long id){
		deviceService.deleteDeviceById(id);
		return new ResponseBean<>(true,AcmeResponseEnums.SUCCESS_OPTION);
	}
	/**
	 * 添加设备传感器接口
	 * @param sensor
	 * @return
	 */
	@RequestMapping(value={"/sensor/create"})
	@ResponseBody
	public ResponseBean<Long> sensorCreate(@RequestBody Sensor sensor){
		Long id=deviceService.createSensor(sensor);
		return new ResponseBean<>(true,id,AcmeResponseEnums.SUCCESS_OPTION);
	}
	/**
	 * 修改设备传感器的接口
	 * @param sensor
	 * @return
	 */
	@RequestMapping(value={"/sensor/update"})
	@ResponseBody
	public ResponseBean<String> sensorUpdate(@RequestBody Sensor sensor){
		deviceService.updateSensor(sensor);
		return new ResponseBean<>(true,AcmeResponseEnums.SUCCESS_OPTION);
	}
	/**
	 * 删除传感器的设备接口
	 * @param ids
	 * @return
	 */
	@RequestMapping(value={"/sensor/delete"})
	@ResponseBody
	public ResponseBean<String> sensorDelete(@RequestParam("ids[]")Long[] ids){
		deviceService.deleteSensor(ids);
		return new ResponseBean<>(true, AcmeResponseEnums.SUCCESS_OPTION);
	}
	/**
	 * 为防止数据被篡改，将userKey直接放入请求头体中。
	 * @param dataPoint
	 * @return
	 */
	@RequestMapping(value={"/sensor/datapoint/create"})
	@ResponseBody
	public ResponseBean<Long> dataPointCreate(@RequestBody DatapointCreate datapoint
			,HttpServletRequest request){
		//获取到设备的userkey;
		String userKey = request.getHeader("userKey");
		deviceService.createDataPoint(datapoint,userKey);
		return new ResponseBean<>(true, AcmeResponseEnums.SUCCESS_OPTION);
	}
	/**
	 * 删除数据节点接口
	 * @param ids
	 * @return
	 */
	@RequestMapping(value={"/sensor/datapoint/delete"})
	@ResponseBody
	public ResponseBean<String> deleteDataPoint(@RequestParam("ids[]") Long[] ids){
		deviceService.deleteDataPoint(ids);
		return new ResponseBean<>(true, AcmeResponseEnums.SUCCESS_OPTION);
	}

}
