package com.acme.app.service.device;

import java.math.BigDecimal;
import java.util.List;

import com.acme.api.response.Page;
import com.acme.app.dto.device.DataPointDto;
import com.acme.app.dto.device.DeviceDto;
import com.acme.app.dto.device.IndexSiteDataDto;
import com.acme.app.dto.device.SensorDto;
import com.acme.app.dto.device.SiteDataDto;
import com.acme.app.dto.device.SiteSearchDto;
import com.acme.app.dto.device.SiteDataChart;
import com.acme.app.dto.device.SiteWatershed;
import com.acme.app.model.reptile.SiteData;
import com.acme.app.request.device.DataPointRequest;

/**
 * 数据查询接口。此接口只提供数据的查询，
 * 不做任何的数据修改操作
 * @author YL.Z
 *
 * @date 2017年3月30日 下午9:37:14
 */
public interface DeviceQueryService {
	/**
	 * 查看某个用户所有的设备列表
	 * @param userKey  用户的标识密钥
	 * @return
	 */
	List<DeviceDto> findDeviceList(String userKey);
	/**
	 * 根据id查询看设备的详细信息
	 * @param id 设备的id
	 * @return
	 */
	DeviceDto findDeviceById(Long id);
	/**
	 * 查看一个传感器的基本信息
	 * @param id
	 * @return
	 */
	SensorDto findSensor(Long id);
	/**
	 * 查看某个设备下的全部的传感器
	 * @param deviceId
	 * @return
	 */
	List<SensorDto> findSensorList(Long deviceId);
	/**
	 * 根据不同的添加获取某个设备或者传感器的数据节点
	 * @param page
	 * @return
	 */
	Page<List<DataPointDto>> findDataPointBy(Page<DataPointRequest> page);
	
	/**
	 * 首页加载时获取定位位置的数据并且返回给客户端：该方法找的是该站点的
	 * 最近的数据。
	 * @return
	 */
	IndexSiteDataDto findSiteData(BigDecimal lat,BigDecimal lng);
	
	List<SiteWatershed> findSiteWatershed();
	
	/**
	 * 查看历史数据
	 * @param waterplace
	 * @param size 获取的数据大小
	 * @return
	 */
	List<SiteData> findSiteDataList(String waterplace,Integer size);
	
	/**
	 * 加载地图上需要的全部站点
	 * @param riverId 流域的id
	 * @return
	 */
	List<SiteDataDto> findSiteDataList(Long riverId);
	/**
	 * 获取站点下的历史数据的曲线图所需要的数据
	 * @param waterplace
	 * @return
	 */
	SiteDataChart findSiteDataChart(String waterplace);
	
	/**
	 * 根据站点的名称模糊查询站点信心
	 * @param waterplace
	 * @return
	 */
	List<SiteSearchDto> findSiteList(String waterplace);
}
