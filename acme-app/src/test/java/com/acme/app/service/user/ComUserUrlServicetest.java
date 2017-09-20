/*package com.acme.app.service.user;

import java.util.List;

import org.junit.Test;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;

import com.acme.api.utils.DateUtils;
import com.acme.app.context.MySQLDBConfiguration;
import com.acme.app.context.MybatisConfig;
import com.acme.app.context.SpringRootConfig;
import com.acme.app.context.WebInitalizer;
import com.acme.app.model.url.CompanyUserUrl;
import com.acme.app.model.url.DeviceSensorUrl;
import com.acme.app.model.user.CompanyUser;
import com.acme.app.service.url.ComUserUrlService;
import com.acme.app.service.url.ComUserUrlServiceImpl;
import com.acme.app.service.url.DeviceUrlService;
import com.acme.app.service.url.DeviceUrlServiceImpl;

public class ComUserUrlServicetest {
	static AnnotationConfigWebApplicationContext rootContext=new AnnotationConfigWebApplicationContext();
	ComUserUrlService comUserUrlService=(ComUserUrlService) rootContext.getBean(ComUserUrlServiceImpl.class);
	static{
		rootContext.register(WebInitalizer.class);
		rootContext.register(SpringRootConfig.class);
		rootContext.register(MybatisConfig.class);
		rootContext.register(MySQLDBConfiguration.class);
		rootContext.refresh();
	}
	@Test
	public void insertTest(){
		CompanyUserUrl	companyUserUrl=new CompanyUserUrl();
		companyUserUrl.setPath("user/modify");
		companyUserUrl.setGmtCreate(DateUtils.getDate());
		companyUserUrl.setGmtModified(DateUtils.getDate());
		comUserUrlService.insert(companyUserUrl);
	}
	@Test
	public void deleteTest(){
		comUserUrlService.deleteById(5L);
	}
	@Test
	public void getCountTest(){
		Long count=comUserUrlService.getCount();
		System.out.println(count);
	}
	@Test
	public void getAllTest(){
		List<CompanyUserUrl> list=comUserUrlService.selectAll();
		System.out.println(list.toString());
	}
	@Test
	public void updateTest(){
		
		CompanyUserUrl companyUserUrl=comUserUrlService.selectById(4L);
		
		companyUserUrl.setGmtModified(DateUtils.getDate());
		companyUserUrl.setPath("device/check");
		comUserUrlService.update(companyUserUrl);
		
	}
}
*/