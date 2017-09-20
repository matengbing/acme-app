package com.acme.app.mapper.device;

import java.util.List;

import com.acme.app.model.device.Sensor;

public interface SensorMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Sensor record);

    int insertSelective(Sensor record);

    Sensor selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(Sensor record);

    int updateByPrimaryKey(Sensor record);
    
    /**
     * 查看某个设备下的传感器
     * @param deviceId
     * @return
     */
    List<Sensor> findSensorByDevice(Long deviceId);
    /**
     * 删除某个设备下的传感器
     * @param deviceId
     * @return
     */
    int deleteByDeviceId(Long deviceId);
    /**
     * 根据id删除多个传感器
     * @param ids
     * @return
     */
    int deleteByIds(Long[] ids);
}