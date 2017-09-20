package com.acme.app.dto.premission;

import java.util.Date;
import java.util.List;

import com.acme.app.model.url.CompanyUserUrl;

public class CompanyUserPremissionDto {
	private Long id;
	private String userKey;
	private Long companyUserId;
	private List<Long> companyUserIds;   //用于批量插入某个userKey对某些companyUserId的权利
	private Long urlId;
	private List<Long> urlIds;           //用于批量插入某个userKey对某个companyUserId的urlid
	private CompanyUserUrl companyUserUrl; //关联一个CompanyUserUrl,以便关联查询url地址
	private Date gmtCreate;
	private Date gmtModified;
	public Date getGmtCreate() {
		return gmtCreate;
	}
	public void setGmtCreate(Date gmtCreate) {
		this.gmtCreate = gmtCreate;
	}
	public Date getGmtModified() {
		return gmtModified;
	}
	public void setGmtModified(Date gmtModified) {
		this.gmtModified = gmtModified;
	}
	public CompanyUserUrl getCompanyUserUrl() {
		return companyUserUrl;
	}
	public void setCompanyUserUrl(CompanyUserUrl companyUserUrl) {
		this.companyUserUrl = companyUserUrl;
	}
	private Date gmt_create;
	private Date gmt_modified;
	public Long getCompanyUserId() {
		return companyUserId;
	}
	public List<Long> getCompanyUserIds() {
		return companyUserIds;
	}
	public Date getGmt_create() {
		return gmt_create;
	}
	public Date getGmt_modified() {
		return gmt_modified;
	}
	public Long getId() {
		return id;
	}
	public Long getUrlId() {
		return urlId;
	}
	public List<Long> getUrlIds() {
		return urlIds;
	}
	public String getUserKey() {
		return userKey;
	}
	public void setCompanyUserId(Long companyUserId) {
		this.companyUserId = companyUserId;
	}
	public void setCompanyUserIds(List<Long> companyUserIds) {
		this.companyUserIds = companyUserIds;
	}
	public void setGmt_create(Date gmt_create) {
		this.gmt_create = gmt_create;
	}
	public void setGmt_modified(Date gmt_modified) {
		this.gmt_modified = gmt_modified;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public void setUrlId(Long urlId) {
		this.urlId = urlId;
	}
	public void setUrlIds(List<Long> urlIds) {
		this.urlIds = urlIds;
	}
	public void setUserKey(String userKey) {
		this.userKey = userKey;
	}
	@Override
	public String toString() {
		return "CompanyUserPremissionDto [id=" + id + ", userKey=" + userKey
				+ ", companyUserId=" + companyUserId + ", companyUserIds="
				+ companyUserIds + ", urlId=" + urlId + ", urlIds=" + urlIds
				+ ", companyUserUrl=" + companyUserUrl + ", gmtCreate="
				+ gmtCreate + ", gmtModified=" + gmtModified + ", gmt_create="
				+ gmt_create + ", gmt_modified=" + gmt_modified + "]";
	}
	
	
}
