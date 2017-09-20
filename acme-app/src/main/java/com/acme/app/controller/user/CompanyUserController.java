/*package com.acme.app.controller.user;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.jboss.netty.handler.codec.http.HttpRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.acme.api.enums.AcmeResponseEnums;
import com.acme.api.response.ResponseBean;
import com.acme.api.utils.UserType;
import com.acme.app.dto.user.UserDto;
import com.acme.app.model.premission.CompanyUserPremission;
import com.acme.app.model.url.CompanyUserUrl;
import com.acme.app.model.user.CompanyUser;
import com.acme.app.service.premission.ComUserService;
import com.acme.app.service.url.ComUserUrlService;
import com.acme.app.service.user.CompanyService;

@Controller
@RequestMapping(value="/companyUser",method=RequestMethod.POST)
@Transactional
public class CompanyUserController {
	@Autowired
	private CompanyService companyService;
	@Autowired
	private ComUserService comUserService;
	@Autowired
	private ComUserUrlService comUserUrlService;
	@RequestMapping(value="/create")
	@ResponseBody
	public ResponseBean<Long> createCompanyUser(CompanyUser companyUser,HttpServletRequest request){
		boolean t=isCompanyUser(request);
		if(!t){
			//不是企业用户
			return new ResponseBean<Long>(true, AcmeResponseEnums.NO_PERMISSION);
		}
		String path=request.getServletPath();
		HttpSession session=request.getSession();
		UserDto userDto=(UserDto) session.getAttribute(UserType.SESSIONUSER);
		Long url_id=getUrlId(path);
		CompanyUserUrl companyUserUrl=comUserUrlService.selectByPath(path);
		if(companyUserUrl!=null){
			CompanyUserPremission companyUserPremission=comUserService.selectPreByUKAndUrlId(userDto.getUserKey(), url_id);
			if(companyUserPremission!=null){
				return new ResponseBean<Long>(true, companyService.insert(companyUser),AcmeResponseEnums.SUCCESS_OPTION);
			}
		}
		return new ResponseBean<Long>(true, AcmeResponseEnums.NO_PERMISSION);
	}
	@RequestMapping(value="/check")
	@ResponseBody
	public ResponseBean<?> checkCompanyUser(@RequestParam("id") Long id,HttpServletRequest request){
		return new ResponseBean<CompanyUser>(true,companyService.selectById(id));
	}
	@RequestMapping(value="/delete")
	@ResponseBody
	public ResponseBean<?> deleteUser(@RequestParam("userKey") String userKey){
		*//**
		 * 鉴权在拦截器中，能通过拦截器则直接删除
		 * 先删除权限表中的权限记录
		 * 应先删除设备权限，传感器权限，用户权限
		 * *//*
		comUserService.deleteByUserKey(userKey);         //从user权限表删除权限信息
		companyService.deleteByUserKey(userKey);
		return new ResponseBean<Object>(true,AcmeResponseEnums.SUCCESS_OPTION);
	}
	@RequestMapping(value="login")
	@ResponseBody
	public ResponseBean<?> login(CompanyUser companyUser,HttpSession session){
		CompanyUser companyUser2=companyService.selectByMobileAndPassword(companyUser.getMobile(), companyUser.getPassword());
		if(companyUser2!=null){
			*//**
			 * 登录时将封装的userDto存储在session中
			 * *//*
			UserDto userDto=new UserDto(companyUser2.getId(), companyUser2.getUserKey(), UserType.COMPANY_USER, companyUser2.getGrade());
			session.setAttribute(UserType.SESSIONUSER,userDto);
			return new ResponseBean<Object>(true,AcmeResponseEnums.LOGIN_SUCCESS);
		}else {
			return new ResponseBean<Object>(true,AcmeResponseEnums.NOT_MATCH);
		}
	}
	
	@RequestMapping(value="logout")
	@ResponseBody
	public ResponseBean<?> logout(HttpSession session){
			session.removeAttribute(UserType.SESSIONUSER);
			return new ResponseBean<Object>(true,AcmeResponseEnums.BAD_REQUEST.LOGOUT_SUCCESS);
		
	}
	*//**
	 * 根据session中的信息判断用户是否已经登录
	 * @return boolean
	 * *//*
	public boolean isLogin(HttpServletRequest request){
		HttpSession session=request.getSession();
		UserDto userDto=(UserDto) session.getAttribute(UserType.SESSIONUSER);
		if(userDto!=null){
			return true;
		}
		return false;
	}
	*//**
	 * 判断登录用户是否是企业用户
	 * @return boolean
	 * *//*
	public boolean isCompanyUser(HttpServletRequest request){
		HttpSession session=request.getSession();
		UserDto userDto=(UserDto) session.getAttribute(UserType.SESSIONUSER);
		if(userDto!=null){
			if(userDto.getType().equals(UserType.COMPANY_USER)){
				return true;
			}
		}
		return false;
	}
	*//**
	 * 从企业用户权限表中查询用户是否具有此url操作此用户的权限
	 * *//*
	public boolean isPre(String userKey,Long userId,Long urlId){
	
		CompanyUserPremission companyUserPremission=comUserService.selectPre(userKey, userId, urlId);
		if(companyUserPremission!=null){
			return true;
		}
		return false;
	}
	public Long getUrlId(String url){
		CompanyUserUrl companyUserUrl=comUserUrlService.selectByPath(url);
		return companyUserUrl.getId();
	}
}










*/