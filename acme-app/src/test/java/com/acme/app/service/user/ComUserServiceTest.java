/*package com.acme.app.service.user;



import java.util.Iterator;
import java.util.List;

import org.junit.Test;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;












import com.acme.api.utils.DateUtils;
import com.acme.app.context.MySQLDBConfiguration;
import com.acme.app.context.MybatisConfig;
import com.acme.app.context.SpringRootConfig;
import com.acme.app.context.WebInitalizer;
import com.acme.app.dto.premission.CompanyUserPremissionDto;
import com.acme.app.model.premission.CompanyUserPremission;
import com.acme.app.model.user.CompanyUser;
import com.acme.app.model.user.User;
import com.acme.app.service.premission.ComUserServiceImpl;

public class ComUserServiceTest {
	static AnnotationConfigWebApplicationContext rootContext=new AnnotationConfigWebApplicationContext();
	ComUserServiceImpl comUserServiceImpl=rootContext.getBean(ComUserServiceImpl.class);
	static{
		rootContext.register(WebInitalizer.class);
		rootContext.register(SpringRootConfig.class);
		rootContext.register(MybatisConfig.class);
		rootContext.register(MySQLDBConfiguration.class);
		rootContext.refresh();
	}
	@Test
	public void testfindByUserKey() {
		List<CompanyUserPremissionDto> list=comUserServiceImpl.selectByUserKey("4adb78222d4635dfb863bf7f25bf727b");
		Iterator<CompanyUserPremissionDto> iterator=list.iterator();
		while(iterator.hasNext()){
			CompanyUserPremissionDto companyUserPremissionDto=iterator.next();
			System.out.println(companyUserPremissionDto.getId());
			
			System.out.println(companyUserPremissionDto.getCompanyUserUrl().toString());
		}
	}
	
	
	@Test
	public void testselectUrl() {
		CompanyUserPremission  companyUserPremission= comUserServiceImpl.selectUrlId("4adb78222d4635dfb863bf7f25bf727b", 1L, 1L);
		System.out.println(companyUserPremission.getUrlId());
	}
	

	@Test
	public void testInsert(){
		CompanyUserPremission user=new CompanyUserPremission();
		user.setUserKey("4adb78222d4635dfb863bf7f25bf727b");
		user.setCompanyUserId(1L);
		user.setUrlId(1L);
		user.setGmtCreate(DateUtils.getDate());
		user.setGmtModified(DateUtils.getDate());
		Long ssLong=comUserServiceImpl.insert(user);
		System.out.println(ssLong);
	}
}
*/