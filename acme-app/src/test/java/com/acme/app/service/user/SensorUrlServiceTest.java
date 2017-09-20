/*package com.acme.app.service.user;

import java.util.List;

import org.junit.Test;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

import com.acme.api.utils.DateUtils;
import com.acme.app.context.MySQLDBConfiguration;
import com.acme.app.context.MybatisConfig;
import com.acme.app.context.SpringRootConfig;
import com.acme.app.context.WebInitalizer;
import com.acme.app.model.url.DeviceSensorUrl;
import com.acme.app.service.url.DeviceUrlService;
import com.acme.app.service.url.SensorUrlServiceImpl;

public class SensorUrlServiceTest {
	static AnnotationConfigWebApplicationContext rootContext=new AnnotationConfigWebApplicationContext();
	DeviceUrlService senDeviceUrlService=rootContext.getBean(SensorUrlServiceImpl.class);
	static{
		rootContext.register(WebInitalizer.class);
		rootContext.register(SpringRootConfig.class);
		rootContext.register(MybatisConfig.class);
		rootContext.register(MySQLDBConfiguration.class);
		rootContext.refresh();
	}
	@Test
	public void insertTest(){
		DeviceSensorUrl	deviceSensorUrl=new DeviceSensorUrl();
		deviceSensorUrl.setPath("sensor/modify");
		deviceSensorUrl.setGmtCreate(DateUtils.getDate());
		deviceSensorUrl.setGmtModified(DateUtils.getDate());
		senDeviceUrlService.insert(deviceSensorUrl);
	}
	@Test
	public void deleteTest(){
		senDeviceUrlService.deleteById(1L);
	}
	@Test
	public void getCountTest(){
		Long count=senDeviceUrlService.getCount();
		System.out.println(count);
	}
	@Test
	public void getAllTest(){
		List<DeviceSensorUrl> list=senDeviceUrlService.selectAll();
		System.out.println(list.toString());
	}
	@Test
	public void updateTest(){
		
		DeviceSensorUrl deviceSensorUrl2=senDeviceUrlService.selectById(2L);
		System.out.println(deviceSensorUrl2.getId());
		deviceSensorUrl2.setGmtModified(DateUtils.getDate());
		deviceSensorUrl2.setPath("device/check");
		senDeviceUrlService.update(deviceSensorUrl2);
		
	}
}
*/