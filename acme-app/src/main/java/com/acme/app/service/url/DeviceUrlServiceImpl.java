/*package com.acme.app.service.url;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.acme.api.utils.DateUtils;
import com.acme.app.mapper.url.DeviceUrlMapper;
import com.acme.app.model.url.DeviceSensorUrl;
@Service("deviceUrlService")
public class DeviceUrlServiceImpl  implements DeviceUrlService{
	@Resource
	private DeviceUrlMapper deviceUrlMapper;

	@Override
	public void insert(DeviceSensorUrl deviceSensorUrl) {
		// TODO Auto-generated method stub
		deviceSensorUrl.setGmtCreate(DateUtils.getDate());
		deviceSensorUrl.setGmtModified(DateUtils.getDate());
		deviceUrlMapper.insert(deviceSensorUrl);
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		deviceUrlMapper.deleteById(id);
	}

	@Override
	public void update(DeviceSensorUrl deviceSensorUrl) {
		// TODO Auto-generated method stub
		deviceSensorUrl.setGmtModified(DateUtils.getDate());
		deviceUrlMapper.update(deviceSensorUrl);
	}

	@Override
	public List<DeviceSensorUrl> selectAll() {
		// TODO Auto-generated method stub
		return deviceUrlMapper.selectAll();
	}

	@Override
	public Long getCount() {
		// TODO Auto-generated method stub
		return deviceUrlMapper.getCount();
	}

	@Override
	public DeviceSensorUrl selectByPath(String path) {
		// TODO Auto-generated method stub
		return deviceUrlMapper.selectByPath(path);
	}

	@Override
	public List<DeviceSensorUrl> VagueSelectByPath(String path) {
		// TODO Auto-generated method stub
		return deviceUrlMapper.VagueSelectByPath(path);
	}

	@Override
	public DeviceSensorUrl selectById(Long id) {
		// TODO Auto-generated method stub
		return deviceUrlMapper.selectById(id);
	}
}
*/