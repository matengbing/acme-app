package com.acme.app.mapper.device;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.acme.app.dto.device.SiteDataAverage;
import com.acme.app.model.reptile.SiteData;
import com.acme.app.model.reptile.StationInfo;

public interface SiteDataMapper {
	//SELECT * FROM site_data WHERE waterplace='渭南潼关吊桥'  ORDER BY wpubdate DESC LIMIT 0,1;
	
	/**
	 * 最新的一个点
	 * @param waterPlace
	 * @return
	 */
	SiteData findSiteDate(String waterPlace);
	
	
	List<StationInfo> findStationList(String wally);
	
	/**
	 * 查看历史数据
	 * 自行这数据量大小，
	 * 该方法可用于统计最近一个月的的各项指标
	 * @param waterplace
	 * @param limit
	 * @return
	 */
	List<SiteData> findSiteDataList(@Param("waterplace")String waterplace,@Param("limit")Integer limit);
	
	/**
	 * 获取某一个站点几周前的数据
	 * @param waterplace
	 * @param limit  
	 * @return
	 */
	SiteDataAverage findSiteDataAverage(@Param("waterplace")String waterplace,@Param("limit")Integer limit);
	
	
	
}
