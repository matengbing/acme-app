package com.acme.app.mapper.device;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.acme.api.response.Page;
import com.acme.app.dto.device.DataPointDto;
import com.acme.app.model.device.DataPoint;
import com.acme.app.request.device.DataPointRequest;

public interface DataPointMapper {
    int deleteByPrimaryKey(Long id);

    int insert(DataPoint record);

    int insertSelective(DataPoint record);

    DataPoint selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(DataPoint record);

    int updateByPrimaryKey(DataPoint record);
    
    /**
     * 批量删除数据节点
     * @param ids id
     * @return
     */
    int deleteByIds(Long[] ids);
    /**
     * 删除某一个传感器下的所有的数据
     * @param ids
     * @return
     */
    int deleteBySensor(Long[] ids);
    /**
     * 翻页查询出某个传感器下的所有的数据节点，
     * @param page
     * @param queryBean 封装的查询对象
     * @return
     */
    List<DataPoint> findAllDataPointBySensor(@Param("page") Page<List<DataPointDto>> page
    		,@Param("queryBean")DataPointRequest queryBean);
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
    
}