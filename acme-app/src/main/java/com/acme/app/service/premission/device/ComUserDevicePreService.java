/*package com.acme.app.service.premission.device;

import java.util.List;

import org.apache.ibatis.annotations.Update;

import com.acme.app.model.premission.UserDeviceSensorPremission;

public interface ComUserDevicePreService {
	*//**
	 * 插入一条userKey对于设备的权限
	 * @param UserDeviceSensorPremission
	 * @return Long   
	 * *//*  
	Long insert(UserDeviceSensorPremission userDeviceSensorPremission);
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
	 * 检查是否已存在记录,防止重写入重复数据
	 * *//*
	boolean isExst(UserDeviceSensorPremission userDeviceSensorPremission);
	void update(UserDeviceSensorPremission userDeviceSensorPremission);
	UserDeviceSensorPremission selectPre(String userKey,Long urlId);
}
*/