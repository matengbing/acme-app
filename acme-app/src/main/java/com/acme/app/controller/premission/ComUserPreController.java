/*package com.acme.app.controller.premission;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.acme.api.enums.AcmeResponseEnums;
import com.acme.api.response.ResponseBean;
import com.acme.app.model.premission.CompanyUserPremission;
import com.acme.app.service.premission.ComUserService;

@Transactional
@Controller
@RequestMapping(value="/user/premission",method=RequestMethod.POST)
public class ComUserPreController {
	@Autowired
	private ComUserService comUserService;
	@RequestMapping(value="addPre")
	public ResponseBean<Long> addPremission(CompanyUserPremission companyUserPremission){
		return new ResponseBean<Long>(true, comUserService.insert(companyUserPremission));
	}
	@RequestMapping(value="deletePre")
	public ResponseBean<String> deletePre(CompanyUserPremission companyUserPremission){
		comUserService.deletePre(companyUserPremission.getUserKey(), companyUserPremission.getCompanyUserId(), companyUserPremission.getUrlId());
		return new ResponseBean<>(true,AcmeResponseEnums.SUCCESS_OPTION);
	}
	@RequestMapping(value="delPreByUrlId")
	public ResponseBean<String> deleteByUrlId(@RequestParam("id") Long urlId){
		comUserService.deleteByUrlId(urlId);
		return new ResponseBean<>(true, AcmeResponseEnums.SUCCESS_OPTION);
	}
	@RequestMapping(value="delPreByUserId")
	public ResponseBean<String> delPreByUserId(@RequestParam("id") Long userId){
		comUserService.deleteByUserId(userId);
		return new ResponseBean<>(true, AcmeResponseEnums.SUCCESS_OPTION);
	}
	@RequestMapping(value="delPreByUserKey")
	public ResponseBean<String> delPreByUserKey(@RequestParam("userKey") String userKey){
		comUserService.deleteByUserKey(userKey);
		return new ResponseBean<>(true, AcmeResponseEnums.SUCCESS_OPTION);
	}
	@RequestMapping(value="updatePre")
	public ResponseBean<String> updatePreById(CompanyUserPremission companyUserPremission){
		comUserService.update(companyUserPremission);
		return new ResponseBean<>(true, AcmeResponseEnums.SUCCESS_OPTION);
	}
	@RequestMapping(value="selectPre")
	public ResponseBean<CompanyUserPremission> selectPre(CompanyUserPremission companyUserPremission){
		CompanyUserPremission companyUserPremission2=comUserService.selectPre(companyUserPremission.getUserKey(), companyUserPremission.getCompanyUserId(), companyUserPremission.getUrlId());
		if(companyUserPremission2==null){
			return new ResponseBean<CompanyUserPremission>(false, AcmeResponseEnums.NO_RECORD);
		}
		return new ResponseBean<>(true,companyUserPremission2);
	}
	@RequestMapping(value="selectPreByUrlId")
	public ResponseBean<?> selectPreByUrlId(@RequestParam("id") Long urlId){
		List<CompanyUserPremission> list=comUserService.selectByUrlId(urlId);
		if(list==null){
			return new ResponseBean<CompanyUserPremission>(false, AcmeResponseEnums.NO_RECORD);
		}
		return new ResponseBean<List<CompanyUserPremission>>(true,list);
	}
	@RequestMapping(value="selectPreByUserId")
	public ResponseBean<?> selectPreByUserId(@RequestParam("id") Long userId){
		List<CompanyUserPremission> list=comUserService.selectByComUserId(userId);
		if(list==null){
			return new ResponseBean<CompanyUserPremission>(false, AcmeResponseEnums.NO_RECORD);
		}
		return new ResponseBean<List<CompanyUserPremission>>(true,list);
	}
	@RequestMapping(value="selectPreByUserKey")
	public ResponseBean<?> selectPreByUserKey(@RequestParam("userKey") String userKey){
		List<CompanyUserPremission> list=comUserService.selectByUserKey(userKey);
		if(list==null){
			return new ResponseBean<CompanyUserPremission>(false, AcmeResponseEnums.NO_RECORD);
		}
		return new ResponseBean<List<CompanyUserPremission>>(true,list);
	}
}
*/