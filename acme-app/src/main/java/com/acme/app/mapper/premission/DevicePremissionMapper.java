/*package com.acme.app.mapper.premission;

import java.util.List;

import com.acme.app.model.premission.UserDeviceSensorPremission;

public interface DevicePremissionMapper {
	*//**
	 * 插入一条userKey对于设备的权限
	 * @param UserDeviceSensorPremission
	 * *//*
	void insert(UserDeviceSensorPremission userDeviceSensorPremission);
	*//**
	 * 根据id删除对于设备的权限
	 * @param Long
	 * *//*
	void deleteById(Long id);
	*//**
	 * 删除userKey对于设备的权限,主要用于删除用户前先删除该用户对于所有设备的权限
	 * @param String
	 * *//*
	void deleteByUserKey(String userKey);
	*//**
	 * 删除某条url的所有权限
	 * @param Long
	 * *//*
	void deleteByUrlId(Long urlId);
	*//**
	 * 根据userKey,urlId,deviceId删除一条记录
	 * 主要用于删除某用户对于某设备的具体权限，和更改用户对设备的权限
	 * @param String userKey,Long urlId,Long deviceId
	 * *//*
	void deleteByUKAndUrlIdAndDeviceId(String userKey,Long urlId,Long deviceId);
	*//**
	 * 通过userKey查找某个userKey的设备的所有权限
	 * @param String
	 * @return List<UserDeviceSensorPremission>
	 * *//*
	List<UserDeviceSensorPremission> selectByUserKey(String userKey);
	*//**
	 * 通过id查找记录
	 * @param Long
	 * @return UserDeviceSensorPremission
	 * *//*
	UserDeviceSensorPremission selectById(Long id);
	*//**
	 * 通过urlId查找记录
	 * @param Long
	 * @return List<UserDeviceSensorPremission>
	 * *//*
	List<UserDeviceSensorPremission> selectByUrlId(Long urlId);
	*//**
	 * 通过deviceId查找记录
	 * @param Long
	 * @return List<UserDeviceSensorPremission>
	 * *//*
	List<UserDeviceSensorPremission> selectByDeviceId(Long deviceId);
	*//**
	 * 根据userKey,urlId,deviceId查找一条记录
	 * 主要用于查找某用户对于某设备的具体权限
	 * @param String userKey,Long urlId,Long deviceId
	 * *//*
	UserDeviceSensorPremission selectByUKAndUrlIdAndDeviceId(String userKey,Long urlId,Long deviceId);
	*//**
	 * 更新一条记录
	 * @param UserDeviceSensorPremission
	 * *//*
	void update(UserDeviceSensorPremission userDeviceSensorPremission);
	UserDeviceSensorPremission selectPre(String userKey,Long urlId);
}
*/