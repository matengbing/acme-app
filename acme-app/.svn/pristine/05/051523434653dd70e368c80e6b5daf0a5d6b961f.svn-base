package com.acme.app.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.acme.api.enums.AcmeResponseEnums;
import com.acme.api.response.ResponseBean;
import com.acme.api.utils.CacheUtils;
import com.acme.api.utils.CookieUtils;
import com.acme.api.utils.ResponseUtils;
import com.acme.app.model.user.User;
import com.alibaba.fastjson.JSONObject;

/**
 * 
 * @author YL.Z
 *
 * @date 2017年3月28日 下午8:13:36
 */
@Controller
public class TestController {

	
	@RequestMapping(value={"test"})
	@ResponseBody
	public ResponseBean<String> test(){
		System.out.println("访问到了！");
		return new ResponseBean<>(false,"失败!");
	}
	
	
	@RequestMapping(value={"login"})
	@ResponseBody
	public ResponseBean<String> login(HttpServletResponse response){
		User user= new User();
		user.setUserKey("test");
		CookieUtils.addCookie(response, user);
		return new ResponseBean<String>(true, "登录成功！");
	}
	
	@RequestMapping(value={"logut"})
	@ResponseBody
	public ResponseBean<String> login(String userKey){
		CacheUtils.getInstance().deleteString(userKey);
		return new ResponseBean<String>(true, "退出成功！");
	}
	
	@RequestMapping(value="jsonp")
	public void jsonp(@RequestParam("id") Long id,HttpServletRequest request,HttpServletResponse response) throws IOException{
		User user=new User();
		user.setEmail("2841874042@qq.com");
		ResponseBean<User> responseBean=new ResponseBean<>(true,user,AcmeResponseEnums.SUCCESS_OPTION);
		ResponseUtils.print(response, request, responseBean);
	}
	
}
