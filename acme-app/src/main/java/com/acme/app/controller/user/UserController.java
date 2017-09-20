package com.acme.app.controller.user;


import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.acme.api.enums.AcmeResponseEnums;
import com.acme.api.response.ResponseBean;
import com.acme.api.utils.Constant;
import com.acme.api.utils.IDCode;
import com.acme.api.utils.MD5;
import com.acme.api.utils.SendEmail;
import com.acme.api.utils.UserType;
import com.acme.app.dto.user.UserDto;
import com.acme.app.model.user.User;
import com.acme.app.service.user.UserQueryService;
import com.acme.app.service.user.UserService;
@Controller
@RequestMapping(value="/user",method=RequestMethod.POST)
@Transactional
public class UserController {
	@Autowired
	private UserService userService;
	
	@Autowired
	private UserQueryService userQueryService;
	
	@RequestMapping(value="/create")
	@ResponseBody
	public ResponseBean<?> createUser(User user,HttpServletRequest request,@RequestParam("IDCode") String IDCode,HttpSession session){
		String session_idcode=(String) session.getAttribute(UserType.IDCODE);
		String email=(String) session.getAttribute(UserType.EMAIL);
		if(!IDCode.equals(session_idcode)){
			return new ResponseBean<Object>(true,AcmeResponseEnums.ERROR_IDCODE);
		}
		if(!user.getEmail().equals(email)){
			return new ResponseBean<Object>(true,AcmeResponseEnums.BAD_REQUEST);
		}
		return new ResponseBean<Long>(true, userService.createUser(user),AcmeResponseEnums.SUCCESS_OPTION);
	}
	
	
	@RequestMapping(value="/modify")
	@ResponseBody
	public ResponseBean<Long> updateUser(User user,HttpServletRequest request){
		return new ResponseBean<Long>(true, userService.updateUserById(user),AcmeResponseEnums.SUCCESS_OPTION);
	}
	@RequestMapping(value="/check")
	@ResponseBody
	public ResponseBean<User> checkUser(@RequestParam("id") Long id){
		User user=userQueryService.findById(id);
		if(user==null){
			return new ResponseBean<User>(true,AcmeResponseEnums.NO_RECORD);
		}
		return new ResponseBean<User>(true,user,AcmeResponseEnums.SUCCESS_OPTION);
	}
	
	@RequestMapping(value="/checkByUK")
	@ResponseBody
	public ResponseBean<User> checkByUserKey(@RequestParam("userKey") String userKey){
		User user=userQueryService.findByUserKey(userKey);
		if(user==null){
			return new ResponseBean<User>(true,AcmeResponseEnums.NO_RECORD);
		}
		return new ResponseBean<User>(true,user,AcmeResponseEnums.SUCCESS_OPTION);
	}
	@RequestMapping(value="/delete")
	@ResponseBody
	public ResponseBean<?> deleteUser(@RequestParam("IDCode") String IDCode,HttpSession session){
		String session_idcode=(String) session.getAttribute(UserType.IDCODE);
		String email=(String) session.getAttribute(UserType.EMAIL);
		if(IDCode.equals(session_idcode)){
			userService.deleteUserByEmail(email);
			session.removeAttribute(UserType.EMAIL);
			session.removeAttribute(UserType.IDCODE);
		}
		else {
			return new ResponseBean<Object>(true,AcmeResponseEnums.ERROR_IDCODE);
		}
		
		return new ResponseBean<Object>(true,AcmeResponseEnums.SUCCESS_OPTION);
	}
	@RequestMapping(value="/login")
	@ResponseBody
	public ResponseBean<?> login(User user,HttpSession session){
		User user_temp=userQueryService.selectByMobileAndPassword(user.getMobile(), MD5.encodePassword(user.getPassword()));
		if(user_temp!=null){
			/**
			 * 将用户的id，userKey，用户类型，等级封装成UserDto保存在session中*/
			UserDto userDto=new UserDto(user_temp.getId(), user_temp.getUserKey(), UserType.USER,"");
			session.setAttribute(UserType.SESSIONUSER, userDto);
			return new ResponseBean<String>(true,AcmeResponseEnums.LOGIN_SUCCESS);
		}else {
			return new ResponseBean<String>(true,AcmeResponseEnums.NOT_MATCH);
		}
		
	}
	@RequestMapping(method=RequestMethod.POST,value="/logout")
	@ResponseBody
	public ResponseBean<?> logout(HttpSession session){
		session.removeAttribute(UserType.SESSIONUSER);
		return new ResponseBean<String>(true,AcmeResponseEnums.LOGOUT_SUCCESS);
	}
	@RequestMapping(method=RequestMethod.POST,value="/editPwd/email")
	@ResponseBody
	public ResponseBean<?> editPwdByEmail(String password,String IDCode,HttpSession session){
		
		String email=(String) session.getAttribute(UserType.EMAIL);
		String session_idcode=(String) session.getAttribute(UserType.IDCODE);
		if(IDCode.equals(session_idcode)){
			userService.updateUserByEmail(email, password);
			session.removeAttribute(UserType.EMAIL);
			session.removeAttribute(UserType.IDCODE);
		}else {
			return new ResponseBean<String>(true,AcmeResponseEnums.ERROR_IDCODE);
		}
		
		return new ResponseBean<String>(true,AcmeResponseEnums.EDITPWD_SUCCESS);
	}
	/**
	 * 向指定邮箱发送验证码,将邮箱地址和验证码保存在缓存中
	 * */
	@RequestMapping(value="/sendEmail")
	@ResponseBody
	public ResponseBean<?> sendEmail(String email,HttpSession session){
		String idcode=IDCode.getIdCode();
		SendEmail.sendMail(email, idcode);
		session.setAttribute(UserType.IDCODE, idcode);
		session.setAttribute(UserType.EMAIL, email);
		return new ResponseBean<String>(true,AcmeResponseEnums.SENDEMAIL_SUCCESS);
	}
	
	
	
	/*@RequestMapping(value="/fileupload")
	@ResponseBody
	public ResponseBean<?> fileUpload(CommonsMultipartFile file,HttpServletRequest request,HttpSession session) throws IllegalStateException, IOException{
		if(file!=null){
			
			Long id=-1L;
			String string=(String) session.getAttribute(Constant.ACTIVE_USER);
			id=Long.getLong(string);
			if(id==-1L){
				return new ResponseBean<String>(true,AcmeResponseEnums.NOLOGIN);
			}
			//String path=FileUpload.upload(file, request);
			userService.updateIconById(id, path);
		}else {
			return new ResponseBean<String>(true,AcmeResponseEnums.No_FileSELECT);
		}
		return new ResponseBean<String>(true,AcmeResponseEnums.FILEUPLOAD_SUCCESS);
	}*/
	
	
}
