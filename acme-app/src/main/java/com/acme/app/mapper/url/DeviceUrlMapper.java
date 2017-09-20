/*package com.acme.app.mapper.url;
import java.util.List;

import com.acme.app.model.url.DeviceSensorUrl;
public interface DeviceUrlMapper {
	*//**
	 * 插入一条记录
	 * @param DeviceSensorUrl
	 * *//*
	void insert(DeviceSensorUrl deviceSensorUrl);
	*//**
	 * 通过id删除一条记录,删除记录时应该先删除对应权限表中的记录，否则会因破坏关联关系导致删除失败
	 * @param Long
	 * *//*
	void deleteById(Long id);
	*//**
	 * 更新表中记录
	 * @param DeviceSensorUrl
	 * *//*
	void update(DeviceSensorUrl deviceSensorUrl);
	*//**
	 * 查询表中所有记录
	 * @return List<DeviceSensorUrl>
	 * *//*
	List<DeviceSensorUrl> selectAll();
	*//**
	 * 获取表中总记录数
	 * @return Long
	 * *//*
	Long getCount();
	*//**
	 * 通过id返回一条记录,精确查询
	 * @param String
	 * @return DeviceSensorUrl
	 * *//*
	DeviceSensorUrl selectById(Long id);
	*//**
	 * 通过path返回一条记录,精确查询
	 * @param String
	 * @return DeviceSensorUrl
	 * *//*
	DeviceSensorUrl selectByPath(String path);
	*//**
	 * 通过path返回记录,模糊查询
	 * @param String
	 * @return List<DeviceSensorUrl>
	 * *//*
	List<DeviceSensorUrl> VagueSelectByPath(String path);
	
}
  */