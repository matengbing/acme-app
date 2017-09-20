/*package com.acme.app.service.premission;

import org.springframework.beans.factory.annotation.Autowired;

import com.acme.app.model.premission.CompanyUserPremission;

public class UserPreInterceptorService {
	@Autowired
	private ComUserService comUserService;
	
	public boolean hasPremission(String userKey,Long UserId,Long urlId){
		*//**
		 * 如果是创建企业用户，则需要判断已登录用户的等级，是否具有创建该用户等级的权限
		 * *//*
		CompanyUserPremission companyUserPremission=comUserService.selectUrlId(userKey, UserId, urlId);
		if(companyUserPremission!=null){
			return true;
		}
		return false;
	}
}
*/