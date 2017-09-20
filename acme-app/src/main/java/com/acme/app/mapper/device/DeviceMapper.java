package com.acme.app.mapper.device;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.acme.app.model.device.Device;

public interface DeviceMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Device record);

    int insertSelective(Device record);

    Device selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Device record);

    int updateByPrimaryKey(Device record);
    /**
     * 查询某个用户的设备
     * @param userKey
     * @return
     */
    List<Device> findDeviceByCondition(String userKey);
    /**
     * 检查userKey以及device是否匹配
     * @param userKey
     * @param deviceId
     * @return
     */
    Device findDevicebyId(@Param("userKey") String userKey,@Param("deviceId") Long deviceId);
}