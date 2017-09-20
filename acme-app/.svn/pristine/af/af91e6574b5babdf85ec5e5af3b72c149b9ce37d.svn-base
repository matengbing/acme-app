package com.acme.app.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.acme.api.response.Page;
import com.acme.api.response.ResponseBean;
import com.acme.app.dto.device.DataPointDto;
import com.acme.app.dto.device.DeviceDto;
import com.acme.app.dto.device.SensorDto;
import com.acme.app.request.device.DataPointRequest;
import com.acme.app.service.device.DeviceQueryService;

@RestController
@RequestMapping(value="/device")
public class DeviceQueryController {
	
	@Resource
	DeviceQueryService deviceQueryService;
	
	@RequestMapping(value={"/queryDevice"},method=RequestMethod.GET)
	@ResponseBody
	public ResponseBean<List<DeviceDto>> queryDevice(String userKey){
		List<DeviceDto> findDeviceList = deviceQueryService.findDeviceList(userKey);
		return new ResponseBean<List<DeviceDto>>(true,findDeviceList);
	}
	
	@RequestMapping(value={"/queryOneDevice/{id}"},method=RequestMethod.GET)
	@ResponseBody
	public ResponseBean<DeviceDto> queryOneDevice(@PathVariable("id") Long id){
		DeviceDto device = deviceQueryService.findDeviceById(id);
		return new ResponseBean<DeviceDto>(true, device);
	}
	
	@RequestMapping(value={"/sensor/queryOne/{id}"},method=RequestMethod.GET)
	@ResponseBody
	public ResponseBean<SensorDto> queryOne(@PathVariable("id") Long id){
		return new ResponseBean<SensorDto>(true,deviceQueryService.findSensor(id));
	}
	
	@RequestMapping(value={"/sensor/querySensor/{deviceId}"},method=RequestMethod.GET)
	@ResponseBody
	public ResponseBean<List<SensorDto>> querySensor(@PathVariable("deviceId") Long deviceId){
		return new ResponseBean<List<SensorDto>>(true,deviceQueryService.findSensorList(deviceId));
	}
	
	@RequestMapping(value={"/sensor/datapointList"},method=RequestMethod.POST)
	@ResponseBody
	public ResponseBean<Page<List<DataPointDto>>> dataPointList(@RequestBody Page<DataPointRequest> page){
		return new ResponseBean<Page<List<DataPointDto>>>(true,deviceQueryService.findDataPointBy(page));
		
	}
	
}
