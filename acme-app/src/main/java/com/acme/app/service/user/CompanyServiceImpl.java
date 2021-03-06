/*package com.acme.app.service.user;

import java.io.File;
import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.acme.api.enums.AcmeResponseEnums;
import com.acme.api.exception.AcmeRuntimeException;
import com.acme.api.utils.AcmeUtils;
import com.acme.api.utils.DateUtils;
import com.acme.api.utils.MD5;
import com.acme.api.utils.UserValidateUtils;
import com.acme.app.mapper.user.CompanyUserMapper;
import com.acme.app.model.user.CompanyUser;

@Service
public class CompanyServiceImpl implements CompanyService{
	@Resource
	private CompanyUserMapper companyUserMapper;
	@Override
	public void deleteByEmail(String email) {
		// TODO Auto-generated method stub
		companyUserMapper.deleteByEmail(email);
	}

	@Override
	public void deleteByCompany(String company) {
		// TODO Auto-generated method stub
		companyUserMapper.deleteByCompany(company);
	}

	@Override
	public void deleteByDepartment(String company, String department) {
		// TODO Auto-generated method stub
		companyUserMapper.deleteByDepartment(company, department);
	}

	@Override
	public void deleteByUserKey(String userKey) {
		// TODO Auto-generated method stub
		companyUserMapper.deleteByUserKey(userKey);
	}

	@Override
	public Long insert(CompanyUser companyUser) {
		// TODO Auto-generated method stub
		isEffect(companyUser);
		uniqueCheck(companyUser);
		companyUser.setPassword(MD5.encodePassword(companyUser.getPassword()));
		companyUser.setUserKey(AcmeUtils.getUserkey(companyUser.getMobile()));
		companyUser.setGmtCreate(DateUtils.getDate());
		companyUser.setGmtModified(DateUtils.getDate());
		companyUserMapper.insert(companyUser);
		return companyUser.getId();
	}

	@Override
	public CompanyUser selectByEmail(String email) {
		// TODO Auto-generated method stub
		CompanyUser companyUser=companyUserMapper.selectByEmail(email);
		return companyUser;
	}

	@Override
	public CompanyUser selectByMobile(String mobile) {
		// TODO Auto-generated method stub
		CompanyUser companyUser=companyUserMapper.selectByMobile(mobile);
		return companyUser;
	}

	@Override
	public CompanyUser selectByMobileAndPassword(String mobile,String password) {
		// TODO Auto-generated method stub
		CompanyUser companyUser=companyUserMapper.selectByMobileAndPassword(mobile, password);
		return companyUser;
	}

	@Override
	public CompanyUser selectByEmailAndPassword(String email, String password) {
		// TODO Auto-generated method stub
		CompanyUser companyUser=companyUserMapper.selectByEmailAndPassword(email, password);
		return companyUser;
	}

	@Override
	public List<CompanyUser> selectByCompany(String company) {
		// TODO Auto-generated method stub
		List<CompanyUser> companyUsers=companyUserMapper.selectByCompany(company);
		return companyUsers;
	}

	@Override
	public List<CompanyUser> selectByCompanyAndDepartment(String company,
			String department) {
		// TODO Auto-generated method stub
		List<CompanyUser> companyUsers=companyUserMapper.selectByCompanyAndDepartment(company, department);
		return companyUsers;
	}

	@Override
	public CompanyUser selectByUserKey(String userKey) {
		// TODO Auto-generated method stub
		CompanyUser companyUser=companyUserMapper.selectByUserKey(userKey);
		return companyUser;
	}

	@Override
	public void isEffect(CompanyUser companyUser) {
		// TODO Auto-generated method stub
		if(companyUser==null){
			throw new AcmeRuntimeException(AcmeResponseEnums.BAD_REQUEST);
		}
		if(!UserValidateUtils.isMObile(companyUser.getMobile())){
			throw new AcmeRuntimeException(AcmeResponseEnums.INVALID_MOBILE);
		}
		if(!UserValidateUtils.isEmail(companyUser.getEmail())){
			throw new AcmeRuntimeException(AcmeResponseEnums.INVALID_EMAIL);
		}
		if(!UserValidateUtils.isGender(companyUser.getGender())){
			throw new AcmeRuntimeException(AcmeResponseEnums.INVALID_GENDER);
		}
	}

	@Override
	public void uniqueCheck(CompanyUser companyUser) {
		// TODO Auto-generated method stub
		if(isExistUserKey(companyUser.getUserKey())){
			throw new AcmeRuntimeException(AcmeResponseEnums.REPEAT_USERKEY);
		}
		if(isExistMobile(companyUser.getMobile())){
			throw new AcmeRuntimeException(AcmeResponseEnums.REPEAT_MOBILE);
		}
		if(isExistEmail(companyUser.getEmail())){
			throw new AcmeRuntimeException(AcmeResponseEnums.REPEAT_EMAIL);
		}
	}

	@Override
	public boolean isExistUserKey(String userKey) {
		// TODO Auto-generated method stub
		CompanyUser companyUser=null;
		companyUser=selectByUserKey(userKey);
		return companyUser==null?false:true;
	}

	@Override
	public boolean isExistMobile(String mobile) {
		// TODO Auto-generated method stub
		CompanyUser companyUser=null;
		companyUser=selectByMobile(mobile);
		return companyUser==null?false:true;
		
	}

	@Override
	public boolean isExistEmail(String email) {
		// TODO Auto-generated method stub
		CompanyUser companyUser=null;
		companyUser=selectByEmail(email);
		return companyUser==null?false:true;
	}

	@Override
	public Long getCompanyUserCount() {
		// TODO Auto-generated method stub
		return companyUserMapper.getCompanyUserCount();
	}

	@Override
	public void updatePasswordByEmail(String email, String password) {
		// TODO Auto-generated method stub
		companyUserMapper.updatePasswordByEmail(email, MD5.encodePassword(password));
	}

	@Override
	public void updateIconById(Long id, String icon) {
		// TODO Auto-generated method stub
		CompanyUser companyUser=selectIconById(id);
		companyUserMapper.updateIconById(id, icon);
		*//**
		 * 不为空时需要删除对应文件夹*//*
		if(!"".equals(companyUser.getIcon())){
			File file=new File(companyUser.getIcon());
			file.deleteOnExit();
		}
		
	}

	@Override
	public CompanyUser selectIconById(Long id) {
		// TODO Auto-generated method stub
		return companyUserMapper.selectIconById(id);
	}

	@Override
	public List<CompanyUser> getAllCompanyUser() {
		// TODO Auto-generated method stub
		return companyUserMapper.getAllCompanyUser();
	}

	@Override
	public CompanyUser selectById(Long id) {
		// TODO Auto-generated method stub
		return companyUserMapper.selectById(id);
	}
	
}
*/