/*package com.acme.app.service.user;



import java.util.Iterator;
import java.util.List;

import org.junit.Test;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;








import com.acme.app.context.MySQLDBConfiguration;
import com.acme.app.context.MybatisConfig;
import com.acme.app.context.SpringRootConfig;
import com.acme.app.context.WebInitalizer;
import com.acme.app.model.user.CompanyUser;
import com.acme.app.model.user.User;

public class CompanyServiceTest {
	static AnnotationConfigWebApplicationContext rootContext=new AnnotationConfigWebApplicationContext();
	CompanyServiceImpl companyServiceImpl=rootContext.getBean(CompanyServiceImpl.class);
	static{
		rootContext.register(WebInitalizer.class);
		rootContext.register(SpringRootConfig.class);
		rootContext.register(MybatisConfig.class);
		rootContext.register(MySQLDBConfiguration.class);
		rootContext.refresh();
	}
	@Test
	public void testGetUserCount() {
		Long countLong=	companyServiceImpl.getCompanyUserCount();
		System.out.println(countLong);
		
	}
	@Test
	public void testfindUserById(){
		//UserQueryService userQueryService=rootContext.getBean(UserQueryServiceImpl.class);
		CompanyUser companyUser= companyServiceImpl.selectById(1L);
		if(companyUser!=null){
			System.out.println(companyUser.toString());
		}
		
		
	}
	@Test
	public void testfindUserList(){
		List<CompanyUser> companyUsers=companyServiceImpl.getAllCompanyUser();
		Iterator<CompanyUser> iterator=companyUsers.iterator();
		while(iterator.hasNext()){
			System.out.println(iterator.next().toString());
		}
	}
	@Test
	public void testfindByCompany(){
		List<CompanyUser> companyUsers=companyServiceImpl.selectByCompany("联通");
		Iterator<CompanyUser> iterator=companyUsers.iterator();
		while(iterator.hasNext()){
			System.out.println(iterator.next().toString());
		}
	}
	@Test
	public void testupdateUserById(){
		
	}
	
	
	@Test
	public void testupdateUserByMobile(){
		UserService userService=rootContext.getBean(UserServiceImpl.class);
		UserQueryService userQueryService=rootContext.getBean(UserQueryServiceImpl.class);
		User user=userQueryService.findByMobile("13434565332");
		user.setAddr("上海");
		userService.updateUserByMobile(user);
		
	}
	
	@Test
	public void testUpdatePasswordByEmail(){
		companyServiceImpl.updatePasswordByEmail("2344@qq.com", "654321");
		
	}
	@Test
	public void testCreateUser(){
		CompanyUser user=new CompanyUser();
		user.setEmail("2344@qq.com");
		user.setGender("男");
		user.setIcon("");
		user.setMobile("18829282929");
		user.setName("wangwu");
		user.setPassword("123456");
		user.setUserKey("333");
		user.setCompany("联通");
		user.setDepartment("信息化");
		user.setCreateUser(-1L);
		user.setGrade("1");;
		Long ssLong=companyServiceImpl.insert(user);
		System.out.println(ssLong);
	}
}
*/