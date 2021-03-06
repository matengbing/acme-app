/*package com.acme.app.service.premission;

import java.util.List;

import com.acme.api.enums.AcmeResponseEnums;
import com.acme.api.exception.AcmeRuntimeException;
import com.acme.app.mapper.premission.ComUserPremissionMapper;
import com.acme.app.model.premission.CompanyUserPremission;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;


@Service
public class ComUserServiceImpl implements ComUserService{
	@Resource
	private ComUserPremissionMapper comUserPremission;

	@Override
	public Long insert(CompanyUserPremission companyUserPremission) {
		// TODO Auto-generated method stub
		boolean flag=isExit(companyUserPremission);
		if(flag){
			throw new AcmeRuntimeException(AcmeResponseEnums.REPEAT_RECORD);
		}
		return comUserPremission.insert(companyUserPremission);
	}

	@Override
	public void update(CompanyUserPremission companyUserPremission) {
		// TODO Auto-generated method stub
		boolean flag=isExit(companyUserPremission);
		if(flag){
			throw new AcmeRuntimeException(AcmeResponseEnums.REPEAT_RECORD);
		}
		comUserPremission.update(companyUserPremission);
	}
	@Override
	public void deleteByUserKey(String userKey) {
		// TODO Auto-generated method stub
		comUserPremission.deleteByUserKey(userKey);
	}

	@Override
	public void deleteByUserId(Long userId) {
		// TODO Auto-generated method stub
		comUserPremission.deleteByUserId(userId);
	}

	@Override
	public void deleteByUrlId(Long urlId) {
		// TODO Auto-generated method stub
		comUserPremission.deleteByUrlId(urlId);
	}

	@Override
	public void deletePre(String userKey, Long UserId, Long urlId) {
		// TODO Auto-generated method stub
		comUserPremission.deletePre(userKey, UserId, urlId);
	}

	@Override
	public List<CompanyUserPremission> selectByUserKey(String userKey) {
		// TODO Auto-generated method stub
		return comUserPremission.selectByUserKey(userKey);
	}

	@Override
	public CompanyUserPremission selectById(Long id) {
		// TODO Auto-generated method stub
		return comUserPremission.selectById(id);
	}

	@Override
	public List<CompanyUserPremission> selectByUrlId(Long urlId) {
		// TODO Auto-generated method stub
		return comUserPremission.selectByUrlId(urlId);
	}

	@Override
	public List<CompanyUserPremission> selectByComUserId(Long userId) {
		// TODO Auto-generated method stub
		return comUserPremission.selectByComUserId(userId);
	}

	@Override
	public CompanyUserPremission selectPre(String userKey, Long userId,
			Long urlId) {
		// TODO Auto-generated method stub
		return comUserPremission.selectPre(userKey, userId, urlId);
	}

	@Override
	public boolean isExit(CompanyUserPremission companyUserPremission) {
		// TODO Auto-generated method stub
		CompanyUserPremission cPremission=selectPre(companyUserPremission.getUserKey(), companyUserPremission.getCompanyUserId(), companyUserPremission.getUrlId());
		if(cPremission!=null){
			return true;
		}
		return false;
	}

	@Override
	public CompanyUserPremission selectPreByUKAndUrlId(String userKey,
			Long urlId) {
		// TODO Auto-generated method stub
		return comUserPremission.selectPreByUKAndUrlId(userKey, urlId);
	}
	
}
*/