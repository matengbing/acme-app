package com.acme.app.service.device;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.acme.api.enums.DeviceType;
import com.acme.api.response.Page;
import com.acme.api.utils.CacheUtils;
import com.acme.app.dto.device.DataPointDto;
import com.acme.app.dto.device.DeviceDto;
import com.acme.app.dto.device.IndexSiteDataDto;
import com.acme.app.dto.device.SensorDto;
import com.acme.app.dto.device.SiteDataAverage;
import com.acme.app.dto.device.SiteDataChart;
import com.acme.app.dto.device.SiteDataDto;
import com.acme.app.dto.device.SiteSearchDto;
import com.acme.app.dto.device.SiteWatershed;
import com.acme.app.dto.device.SuperSiteDto;
import com.acme.app.mapper.device.DataPointMapper;
import com.acme.app.mapper.device.DeviceMapper;
import com.acme.app.mapper.device.SensorMapper;
import com.acme.app.mapper.device.SiteDataMapper;
import com.acme.app.mapper.device.StationInfoMapper;
import com.acme.app.mapper.river.AcmeRiverChildMapper;
import com.acme.app.model.device.DataPoint;
import com.acme.app.model.device.Device;
import com.acme.app.model.device.Sensor;
import com.acme.app.model.reptile.SiteData;
import com.acme.app.model.reptile.StationInfo;
import com.acme.app.model.river.AcmeRiverChild;
import com.acme.app.request.device.DataPointRequest;

@Service
public class DeviceQueryServiceImpl implements DeviceQueryService{

	@Resource
	private DeviceMapper deviceMapper;

	@Resource
	private SensorMapper sensorMapper;

	@Resource
	private DataPointMapper dataPointMapper;

	@Resource
	private SiteDataMapper siteDataMapper;

	@Resource
	private StationInfoMapper stationInfoMapper;

	@Resource
	private AcmeRiverChildMapper riverChildMapper;

	@Override
	public List<DeviceDto> findDeviceList(String userKey) {
		List<DeviceDto> deviceDtos=new ArrayList<>();
		List<Device> devices = deviceMapper.findDeviceByCondition(userKey);
		DeviceDto deviceDto=null;
		if(devices!=null&&devices.size()>0){
			for (Device device : devices) {
				deviceDto=new DeviceDto();
				BeanUtils.copyProperties(device, deviceDto,"type");
				deviceDto.setType(DeviceType.getType(device.getType()));
				deviceDtos.add(deviceDto);
			}
		}
		return deviceDtos;
	}

	@Override
	public DeviceDto findDeviceById(Long id) {
		Device device = deviceMapper.selectByPrimaryKey(id);
		if(device!=null){
			DeviceDto deviceDto=new DeviceDto();
			BeanUtils.copyProperties(device, deviceDto,"type");
			deviceDto.setType(DeviceType.getType(device.getType()));
			return deviceDto;
		}
		return null;
	}

	@Override
	public SensorDto findSensor(Long id) {
		Sensor sensor = sensorMapper.selectByPrimaryKey(id);
		if(sensor!=null){
			SensorDto dto=new SensorDto();
			BeanUtils.copyProperties(sensor, dto);
			Device device = deviceMapper.selectByPrimaryKey(sensor.getDeviceId());
			dto.setDeviceName(device.getTitle());
			return dto;
		}
		return null;
	}

	@Override
	public List<SensorDto> findSensorList(Long deviceId) {
		Device device = deviceMapper.selectByPrimaryKey(deviceId);
		List<Sensor> sensors = sensorMapper.findSensorByDevice(deviceId);
		List<SensorDto> dtos=new ArrayList<>();
		if(sensors!=null&&sensors.size()>0&&device!=null){
			SensorDto dto=null;
			for (Sensor sensor : sensors) {
				dto = new SensorDto();
				BeanUtils.copyProperties(sensor, dto);
				dto.setDeviceName(device.getTitle());
				dtos.add(dto);
			}
		}
		return dtos;
	}

	@Override
	public Page<List<DataPointDto>> findDataPointBy(Page<DataPointRequest> page) {

		Page<List<DataPointDto>> returnPage=new Page<>();
		returnPage.setPageIndex(page.getPageIndex());
		returnPage.setPageSize(page.getPageSize());
		returnPage.setOrderName(page.getOrderName());
		returnPage.setSortOrder(page.getSortOrder());

//		String cacheKey="page:"+page.getPageIndex();
//		String listKey="data:"+page.getPageIndex();

		Device device = deviceMapper.selectByPrimaryKey(page.getData().getDeviceId());

		List<DataPoint> dataList = dataPointMapper.findAllDataPointBySensor(returnPage, page.getData());

		Map<String,Sensor> sensorMap=new HashMap<>();
		List<DataPointDto> dList=null;

		if(device!=null&&dataList!=null&&dataList.size()>0){
			DataPointDto dto=null;
			dList = new ArrayList<>();
			for(DataPoint point:dataList){
				dto=new DataPointDto();
				BeanUtils.copyProperties(point, dto);
				dto.setDataType(DeviceType.getType(point.getDataType()));
				dto.setDeviceName(device.getTitle());
				String key="sensor:"+point.getSensorId();
				Sensor sensor ;
				if (!sensorMap.containsKey(key)) {
					sensor=sensorMapper.selectByPrimaryKey(point.getSensorId());
					sensorMap.put(key, sensor);
				}else {
					sensor=sensorMap.get(key);
				}
				dto.setSensorName(sensor.getTitle());
				dList.add(dto);
			}
		}
		returnPage.setData(dList);
		return returnPage;
	}

	@Override
	public IndexSiteDataDto findSiteData(BigDecimal lat,BigDecimal lng) {
		String waterPlace=getWaterpace(lat, lng);
		SiteData siteData = siteDataMapper.findSiteDate(waterPlace);
		AcmeRiverChild child = riverChildMapper.findRiverId(waterPlace);
		IndexSiteDataDto siteDataDto=new IndexSiteDataDto();
		if(siteData!=null&&child!=null){
			BeanUtils.copyProperties(siteData, siteDataDto);
			siteDataDto.setRiverId(child.getRiverId());
			setScore(siteDataDto, siteData);
			//计算历史评分：
			List<SiteData> list = siteDataMapper.findSiteDataList(waterPlace, 12);
			if(list!=null&&list.size()>0){
				List<Integer> historyScore=new ArrayList<>();
				SuperSiteDto siteDto=null;
				for (SiteData site : list) {
					siteDto=new SuperSiteDto();
					setScore(siteDto, site);
					historyScore.add(siteDto.getScore());
				}
				siteDataDto.setHistoryScore(historyScore);
			}
		}
		return siteDataDto; 
	}
	@Override
	public List<SiteWatershed> findSiteWatershed() {
		List<StationInfo> findsiteWater = stationInfoMapper.getWaterPlace("11");
		//站点
		Set<String> set=new HashSet<>();
		List<SiteWatershed> list=new ArrayList<>();
		for(StationInfo s:findsiteWater){
			set.add(s.getValley());
		}
		for(String s:set){
			SiteWatershed watershed=new SiteWatershed();
			watershed.setVally(s);
			List<StationInfo> result=new ArrayList<>();
			for(StationInfo s1:findsiteWater){
				if(s1.getValley().equals(s)){
					result.add(s1);
				}
			}
			watershed.setSite(result);
			list.add(watershed);
		}
		return list;
	}

	@Override
	public List<SiteData> findSiteDataList(String waterplace,Integer size) {
		return siteDataMapper.findSiteDataList(waterplace,size);
	}

	@Override
	public SiteDataChart findSiteDataChart(String waterplace) {
		String key="acme_waterpalce:"+waterplace;
		List<SiteData> list = CacheUtils.getInstance().getList(key);
		if(list==null){
			list= siteDataMapper.findSiteDataList(waterplace, 12);
			CacheUtils.getInstance().setList(key, list, 60*60);
		}
		SiteDataChart chart=null;
		if(list!=null&&list.size()>0){
			List<Double> codmn=new ArrayList<>();
			List<Double> ph=new ArrayList<>();
			List<Double> wdo=new ArrayList<>();
			List<Double> nhthn=new ArrayList<>();
			List<Integer> historyScore=new ArrayList<>();
			for (SiteData siteData : list) {
				codmn.add(Double.parseDouble(siteData.getCodmn()));
				ph.add(Double.parseDouble(siteData.getWph()));
				wdo.add(Double.parseDouble(siteData.getWdo()));
				nhthn.add(Double.parseDouble(siteData.getNhthn()));
				SuperSiteDto siteDto=new SuperSiteDto();
				setScore(siteDto, siteData);
				historyScore.add(siteDto.getScore());
			}
			chart=new SiteDataChart(codmn, ph, wdo, nhthn);
			chart.setHistoryScore(historyScore);
		}
		return chart;
	}

	@Override
	public List<SiteDataDto> findSiteDataList(Long riverId) {
		String key="site:"+riverId;
		CacheUtils instance = CacheUtils.getInstance();
		int timeout=60*60;
		List<SiteDataDto> list=instance.getList(key);
		if(list==null){
			List<AcmeRiverChild> findList = riverChildMapper.findList(riverId);
			list=new ArrayList<>();
			for(AcmeRiverChild child:findList){
				SiteData siteData = siteDataMapper.findSiteDate(child.getChildName());
				SiteDataDto dataDto=new SiteDataDto();
				if(siteData!=null){
					SiteDataAverage average = siteDataMapper.findSiteDataAverage(child.getChildName(), 4);
					List<SiteData> findSiteDataList = siteDataMapper.findSiteDataList(child.getChildName(), 4);
					BeanUtils.copyProperties(siteData, dataDto);
					dataDto.setLat(child.getLat());
					dataDto.setLng(child.getLng());
					//计算水质评分的平均数
					average.setScore(score(findSiteDataList, dataDto));
					dataDto.setAverage(average);
					setScore(dataDto,siteData);
					list.add(dataDto);
				}
			}
			instance.setList(key, list, timeout);
		}
		return list;
	}
	
	
	@Override
	public List<SiteSearchDto> findSiteList(String waterplace) {
		List<StationInfo> station = stationInfoMapper.findStationByLike(waterplace);
		List<SiteSearchDto> dtos=new ArrayList<>();
		if(station != null){
			SiteSearchDto dto;
			for (StationInfo stationInfo : station) {
				dto=new SiteSearchDto();
				dto.setId(Long.parseLong(stationInfo.getId()));
				dto.setWaterplace(stationInfo.getWaterplace());
				SiteDataChart chart = this.findSiteDataChart(stationInfo.getWaterplace());
				dto.setChart(chart);
				dtos.add(dto);
			}
		}
		return dtos;
	}
	/**
	 * 计算历史评分平均指数
	 * @param list
	 * @param dataDto
	 * @return
	 */
	private int score(List<SiteData> list,SiteDataDto dataDto){
		int sum=0;
		for (SiteData siteData : list) {
			setScore(dataDto, siteData);
			sum+=dataDto.getScore();
		}
		return sum/4;
	}
	/**
	 * 计算水质等级以及评分
	 * @param siteDataDto
	 */
	private void setScore(SuperSiteDto siteDataDto,SiteData siteData){
		String[] str={"Ⅰ","Ⅱ","Ⅲ","Ⅳ","Ⅴ","劣Ⅴ","★"};
		int[] score={100,90,80,70,60,50,40};
		for(int i=0;i<str.length;i++){
			if(siteData.getThewlevel().equals(str[i])){
				siteDataDto.setScoreLevel(i+1);
				siteDataDto.setScore(score[i]);
			}
		}
	}
	/**
	 * 
	 * {
	 * 	code:[1,2,3,33,34],
	 * 	do:[1,2,3,3,3,33,4]
	 * 	codmn:[1,2.3,33.3,33]
	 * 	ph:[1,2,22,2.3.3]
	 * }
	 * 
	 * 根据坐标找到最近的站点
	 * @param lat
	 * @param lng
	 * @return
	 */
	private String getWaterpace(BigDecimal lat,BigDecimal lng){
		String waterplace="";
		List<AcmeRiverChild> findList = riverChildMapper.findList(null);
		List<Distance> distances=new ArrayList<>();
		double[] dList = null;
		if(findList!=null&&findList.size()>0){
			dList=new double[findList.size()];
			for (int i=0;i<findList.size(); i++) {
				BigDecimal x = new BigDecimal(findList.get(i).getLat());
				BigDecimal y = new BigDecimal(findList.get(i).getLng());
				BigDecimal xd = x.subtract(lat).abs();//取绝对值
				BigDecimal yd = y.subtract(lng).abs();
				//计算距离Math.sqrt(x*x + y*y);
				double sqrt = Math.sqrt(xd.multiply(xd).doubleValue()+yd.multiply(yd).doubleValue());
				distances.add(new Distance(sqrt, findList.get(i)));
				dList[i]=sqrt;
			}
		}
		//找到最小的值；
		Arrays.sort(dList);
		double min=dList[0];
		for(Distance distance:distances){
			if(distance.getDistance()==min){
				waterplace=distance.getChild().getChildName();
				break;
			}
		}
		return waterplace;
	}

	private class Distance{
		private double distance;
		private AcmeRiverChild child;

		public Distance(double distance, AcmeRiverChild child) {
			this.distance = distance;
			this.child = child;
		}
		public double getDistance() {
			return distance;
		}
		public AcmeRiverChild getChild() {
			return child;
		}
	}
}
