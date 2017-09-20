/*package com.acme.app.service.url;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.acme.api.utils.DateUtils;
import com.acme.app.mapper.url.SensorUrlMapper;
import com.acme.app.model.url.DeviceSensorUrl;
@Service("sensorUrlService")
public class SensorUrlServiceImpl implements DeviceUrlService{
	@Resource
	private SensorUrlMapper sensorUrlMapper;
	@Override
	public void insert(DeviceSensorUrl deviceSensorUrl) {
		// TODO Auto-generated method stub
		deviceSensorUrl.setGmtCreate(DateUtils.getDate());
		deviceSensorUrl.setGmtModified(DateUtils.getDate());
		sensorUrlMapper.insert(deviceSensorUrl);
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		sensorUrlMapper.deleteById(id);
	}

	@Override
	public void update(DeviceSensorUrl deviceSensorUrl) {
		// TODO Auto-generated method stub
		deviceSensorUrl.setGmtModified(DateUtils.getDate());
		sensorUrlMapper.update(deviceSensorUrl);
	}

	@Override
	public List<DeviceSensorUrl> selectAll() {
		// TODO Auto-generated method stub
		return sensorUrlMapper.selectAll();
	}

	@Override
	public Long getCount() {
		// TODO Auto-generated method stub
		return sensorUrlMapper.getCount();
	}

	@Override
	public DeviceSensorUrl selectByPath(String path) {
		// TODO Auto-generated method stub
		return sensorUrlMapper.selectByPath(path);
	}

	@Override
	public DeviceSensorUrl selectById(Long id) {
		// TODO Auto-generated method stub
		return sensorUrlMapper.selectById(id);
	}

	@Override
	public List<DeviceSensorUrl> VagueSelectByPath(String path) {
		// TODO Auto-generated method stub
		return sensorUrlMapper.VagueSelectByPath(path);
	}

}
*/