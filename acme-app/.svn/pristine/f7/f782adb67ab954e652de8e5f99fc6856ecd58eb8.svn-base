package com.acme.app.controller.reptile;

import java.math.BigDecimal;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.acme.api.enums.AcmeResponseEnums;
import com.acme.api.response.ResponseBean;
import com.acme.app.dto.device.IndexSiteDataDto;
import com.acme.app.dto.device.SiteDataChart;
import com.acme.app.dto.device.SiteDataDto;
import com.acme.app.dto.device.SiteSearchDto;
import com.acme.app.dto.device.SiteWatershed;
import com.acme.app.model.reptile.SiteData;
import com.acme.app.service.device.DeviceQueryService;

/**
 * APP数据提供接口
 * @author YL.Z
 *
 * @date 2017年4月3日 下午3:36:51
 */
@RestController
@RequestMapping(value={"/reptile"})
public class ReptileController {
	
	@Resource
	private DeviceQueryService deviceQueryService;
	//根据定位获取到离用户最近的的站点
	@RequestMapping(value={"/index"},method=RequestMethod.GET)
	@ResponseBody
	public ResponseBean<IndexSiteDataDto> index(BigDecimal lat,BigDecimal lng){
		return new ResponseBean<>(true,deviceQueryService.findSiteData(lat,lng));
	}
	//统计也获取统计的数据
	@RequestMapping(value={"/summary"},method=RequestMethod.GET)
	@ResponseBody
	public ResponseBean<List<SiteData>> summary(String waterplace){
		return new ResponseBean<List<SiteData>>(true, deviceQueryService.findSiteDataList(waterplace, 4));
	}
	
	@RequestMapping(value={"/querySiteWatershed"},method=RequestMethod.GET)
	@ResponseBody
	public ResponseBean<List<SiteWatershed>> findSiteWatershed(){
		
		return new ResponseBean<>(true,deviceQueryService.findSiteWatershed());
	}
	//查询历史api
	@RequestMapping(value={"/queryHistory"},method=RequestMethod.GET)
	@ResponseBody
	public ResponseBean<List<SiteData>> querySiteData(String waterplace)
	{
		
		return new ResponseBean<>(true,deviceQueryService.findSiteDataList(waterplace,null));
	}
	//获取流域站点api
	@RequestMapping(value={"/queryAllStation"})
	@ResponseBody
	public ResponseBean<List<SiteDataDto>> queryAllStation(@RequestParam("riverId") Long riverId)
	{
		return new ResponseBean<List<SiteDataDto>>(true,deviceQueryService.findSiteDataList(riverId));
	}
	
	//获取图表数据api
	@RequestMapping(value={"/getChartData"},method=RequestMethod.GET)
	@ResponseBody
	public ResponseBean<SiteDataChart> getChartData(String waterplace)
	{
		return new ResponseBean<>(true, deviceQueryService.findSiteDataChart(waterplace)
				,AcmeResponseEnums.REQUEST_SUUCESS);
	}
	
	//站点的模糊查询
	@RequestMapping(value={"/querySite"},method=RequestMethod.GET)
	@ResponseBody
	public ResponseBean<List<SiteSearchDto>> querySite(@RequestParam("waterplace") String waterpalce)
	{
		
		return new ResponseBean<>(true, deviceQueryService.findSiteList(waterpalce)
				,AcmeResponseEnums.REQUEST_SUUCESS);
	}
	
	
	
	
}
