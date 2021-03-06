/*package com.acme.app.service.user;



import java.util.Iterator;
import java.util.List;

import org.junit.Test;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;






import com.acme.api.utils.UserValidateUtils;
import com.acme.app.context.MySQLDBConfiguration;
import com.acme.app.context.MybatisConfig;
import com.acme.app.context.SpringRootConfig;
import com.acme.app.context.WebInitalizer;
import com.acme.app.model.user.User;




public class UserServiceTest {
	static AnnotationConfigWebApplicationContext rootContext=new AnnotationConfigWebApplicationContext();
	static{
		rootContext.register(WebInitalizer.class);
		rootContext.register(SpringRootConfig.class);
		rootContext.register(MybatisConfig.class);
		rootContext.register(MySQLDBConfiguration.class);
		rootContext.refresh();
	}
	@Test
	public void testGetUserCount(){
		UserQueryService userQueryService=rootContext.getBean(UserQueryServiceImpl.class);
		Long countLong=	userQueryService.getUserCount();
		System.out.println(countLong);
		
	}
	@Test
	public void testfindUserById(){
		UserQueryService userQueryService=rootContext.getBean(UserQueryServiceImpl.class);
		User user=userQueryService.findById(1L);
		System.out.println(user.getId());
		
	}
	@Test
	public void testfindUserList(){
		UserQueryService userQueryService=rootContext.getBean(UserQueryServiceImpl.class);
		List<User> users=userQueryService.findUserList();
		Iterator<User> iterator=users.iterator();
		while(iterator.hasNext()){
			System.out.println(iterator.next().toString());
		}
	}
	
	@Test
	public void testupdateUserById(){
		UserService userService=rootContext.getBean(UserServiceImpl.class);
		UserQueryService userQueryService=rootContext.getBean(UserQueryServiceImpl.class);
		User user=userQueryService.findById(1L);
		if(user!=null){
			user.setGender("女");
			userService.updateUserById(user);
		}else {
			System.out.println("不存在");
		}
		
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
	public void testUpdatePasswordByMobile(){
		UserService userService=rootContext.getBean(UserServiceImpl.class);
		userService.updatePasswordByMobile("1", "231234");
		
	}
	@Test
	public void testCreateUser(){
		UserService userService=rootContext.getBean(UserServiceImpl.class);
		User user=new User();
		user.setAddr("");
		user.setEmail("2344@qq.com");
		user.setGender("男");
		user.setIcon("");
		user.setMobile("13434565332");
		user.setName("王五");
		user.setPassword("123456");
		user.setUserKey("333");
		user.setSignature("sdsf");
		user.setUserType(0);
		user.setDeviceNumber(200);
		Long ssLong=userService.createUser(user);
		System.out.println(ssLong);
	}
}
*/