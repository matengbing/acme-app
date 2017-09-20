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
import com.acme.app.service.device.DeviceService;
import com.acme.app.service.url.DeviceUrlService;
import com.acme.app.service.url.DeviceUrlServiceImpl;

public class DeviceUrlServiceTest {
	static AnnotationConfigWebApplicationContext rootContext=new AnnotationConfigWebApplicationContext();
	DeviceUrlService deviceUrlService=rootContext.getBean(DeviceUrlServiceImpl.class);
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
		deviceSensorUrl.setPath("device/modify");
		deviceSensorUrl.setGmtCreate(DateUtils.getDate());
		deviceSensorUrl.setGmtModified(DateUtils.getDate());
		deviceUrlService.insert(deviceSensorUrl);
	}
	@Test
	public void deleteTest(){
		deviceUrlService.deleteById(1L);
	}
	@Test
	public void getCountTest(){
		Long count=deviceUrlService.getCount();
		System.out.println(count);
	}
	@Test
	public void getAllTest(){
		List<DeviceSensorUrl> list=deviceUrlService.selectAll();
		System.out.println(list.toString());
	}
	@Test
	public void updateTest(){
		
		DeviceSensorUrl deviceSensorUrl2=deviceUrlService.selectById(2L);
		System.out.println(deviceSensorUrl2.getId());
		deviceSensorUrl2.setGmtModified(DateUtils.getDate());
		deviceSensorUrl2.setPath("device/check");
		deviceUrlService.update(deviceSensorUrl2);
		
	}
	@Test
	public void selectByIdTest(){
		DeviceSensorUrl deviceSensorUrl2=deviceUrlService.selectById(2L);
		System.out.println(deviceSensorUrl2.toString());
		
		
	}
}
*/