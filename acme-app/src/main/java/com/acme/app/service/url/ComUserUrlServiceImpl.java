/*package com.acme.app.service.url;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.acme.api.utils.DateUtils;
import com.acme.app.mapper.url.ComUserUrlMapper;
import com.acme.app.model.url.CompanyUserUrl;

@Service
public class ComUserUrlServiceImpl implements ComUserUrlService{
	@Resource
	private ComUserUrlMapper comUserUrlMapper;
	@Override
	public void insert(CompanyUserUrl companyUserUrl) {
		// TODO Auto-generated method stub
		companyUserUrl.setGmtCreate(DateUtils.getDate());
		companyUserUrl.setGmtModified(DateUtils.getDate());
		comUserUrlMapper.insert(companyUserUrl);
	}

	@Override
	public void deleteById(Long id) {
		// TODO Auto-generated method stub
		comUserUrlMapper.deleteById(id);
	}

	@Override
	public void update(CompanyUserUrl companyUserUrl) {
		// TODO Auto-generated method stub
		companyUserUrl.setGmtModified(DateUtils.getDate());
		comUserUrlMapper.update(companyUserUrl);
	}

	@Override
	public List<CompanyUserUrl> selectAll() {
		// TODO Auto-generated method stub
		return comUserUrlMapper.selectAll();
	}

	@Override
	public Long getCount() {
		// TODO Auto-generated method stub
		return comUserUrlMapper.getCount();
	}

	@Override
	public CompanyUserUrl selectById(Long id) {
		// TODO Auto-generated method stub
		return comUserUrlMapper.selectById(id);
	}

	@Override
	public CompanyUserUrl selectByPath(String path) {
		// TODO Auto-generated method stub
		return comUserUrlMapper.selectByPath(path);
	}

	@Override
	public List<CompanyUserUrl> VagueSelectByPath(String path) {
		// TODO Auto-generated method stub
		return comUserUrlMapper.VagueSelectByPath(path);
	}
	
}
*/