/*package com.acme.app.service.premission.device;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.acme.api.enums.AcmeResponseEnums;
import com.acme.api.exception.AcmeRuntimeException;
import com.acme.app.mapper.premission.SensorPremissionMapper;
import com.acme.app.model.premission.UserDeviceSensorPremission;
@Service("comUserSensorPreService")
public class ComUserSensorPreServiceImpl implements ComUserDevicePreService{
	@Resource
	private SensorPremissionMapper sensorPremissionMapper;
	@Override
	public Long insert(UserDeviceSensorPremission userDeviceSensorPremission) {
		// TODO Auto-generated method stub
		boolean flag=isExst(userDeviceSensorPremission);
		if(flag){
			throw new AcmeRuntimeException(AcmeResponseEnums.REPEAT_RECORD);
		}
		sensorPremissionMapper.insert(userDeviceSensorPremission);
		return userDeviceSensorPremission.getId();
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		sensorPremissionMapper.deleteById(id);
	}

	@Override
	public void deleteByUserKey(String userKey) {
		// TODO Auto-generated method stub
		sensorPremissionMapper.deleteByUserKey(userKey);
	}

	@Override
	public void deleteByUrlId(Long urlId) {
		// TODO Auto-generated method stub
		sensorPremissionMapper.deleteByUrlId(urlId);
	}

	@Override
	public void deleteByUKAndUrlIdAndDeviceId(String userKey, Long urlId,
			Long deviceId) {
		// TODO Auto-generated method stub
		sensorPremissionMapper.deleteByUKAndUrlIdAndDeviceId(userKey, urlId, deviceId);
	}

	@Override
	public List<UserDeviceSensorPremission> selectByUserKey(String userKey) {
		// TODO Auto-generated method stub
		return sensorPremissionMapper.selectByUserKey(userKey);
	}

	@Override
	public UserDeviceSensorPremission selectById(Long id) {
		// TODO Auto-generated method stub
		return sensorPremissionMapper.selectById(id);
	}

	@Override
	public List<UserDeviceSensorPremission> selectByUrlId(Long urlId) {
		// TODO Auto-generated method stub
		return sensorPremissionMapper.selectByUrlId(urlId);
	}

	@Override
	public List<UserDeviceSensorPremission> selectByDeviceId(Long deviceId) {
		// TODO Auto-generated method stub
		return sensorPremissionMapper.selectByDeviceId(deviceId);
	}

	@Override
	public UserDeviceSensorPremission selectByUKAndUrlIdAndDeviceId(
			String userKey, Long urlId, Long deviceId) {
		// TODO Auto-generated method stub
		return sensorPremissionMapper.selectByUKAndUrlIdAndDeviceId(userKey, urlId, deviceId);
	}

	@Override
	public boolean isExst(UserDeviceSensorPremission userDeviceSensorPremission) {
		// TODO Auto-generated method stub
		UserDeviceSensorPremission uPremission=selectByUKAndUrlIdAndDeviceId(userDeviceSensorPremission.getUserKey(),userDeviceSensorPremission.getUrlId(), userDeviceSensorPremission.getDeviceSensorId());
		if(uPremission!=null){
			return true;
		}
		return false;
	}

	@Override
	public void update(UserDeviceSensorPremission userDeviceSensorPremission) {
		// TODO Auto-generated method stub
		sensorPremissionMapper.update(userDeviceSensorPremission);
	}

	@Override
	public UserDeviceSensorPremission selectPre(String userKey, Long urlId) {
		// TODO Auto-generated method stub
		return sensorPremissionMapper.selectPre(userKey, urlId);
	}
	
}
*/