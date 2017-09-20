/*package com.acme.app.mapper.user;
import java.util.List;

import com.acme.app.model.user.CompanyUser;
import com.acme.app.model.user.User;
public interface CompanyUserMapper {
	*//**
	 * 通过email删除用户
	 * @param String
	 * *//*
	void deleteByEmail(String email);
	*//**
	 * 通过公司名称删除公司所有用户
	 * @param String
	 * *//*
	
	void deleteByCompany(String company);
	*//**
	 * 通过公司和部门名称删除该公司的部门
	 * @param String,String
	 * *//*
	void deleteByDepartment(String company,String department);
	*//**
	 * 通过用户的userKey删除用户信息
	 * *//*
	void deleteByUserKey(String userKey);
	*//**
	 * 插入企业用户
	 * @param CompanyUser
	 * @return Long
	 * *//*
	Long insert(CompanyUser companyUser);
	*//**
	 * 通过id查询用户信息
	 * @param Long
	 * @return CompanyUser
	 * *//*
	CompanyUser selectById(Long id);
	*//**
	 * 查找所有企业用户信息
	 * @return List<CompanyUser>
	 * *//*
	List<CompanyUser> getAllCompanyUser();
	*//**
	 * 通过email查询用户信息
	 * @param String
	 * @return CompanyUser
	 * *//*
	CompanyUser selectByEmail(String email);
	*//**
	 * 通过mobile查询用户信息
	 * @param String
	 * @return CompanyUser
	 * *//*
	CompanyUser selectByMobile(String mobile);
	*//**
	 * 通过mobile和passwrod查询用户信息
	 * @param String,String
	 * @return CompanyUser
	 * *//*
	CompanyUser selectByMobileAndPassword(String mobile,String password);
	*//**
	 * 通过email和passwrod查询用户信息
	 * @param String,String
	 * @return CompanyUser
	 * *//*
	CompanyUser selectByEmailAndPassword(String email,String password);
	*//**
	 * 通过公司名称查询该公司所有用户
	 * @param String
	 * @return List<CompanyUser>
	 * *//*
	List<CompanyUser> selectByCompany(String company);
	*//**
	 * 通过公司名称和部门名称查询该公司某部门所有用户
	 * @param String
	 * @return List<CompanyUser>
	 * *//*
	List<CompanyUser> selectByCompanyAndDepartment(String company,String department);
	*//**
	 * 通过userKey查询用户信息
	 * @param String
	 * *//*
	CompanyUser selectByUserKey(String userKey);
	 *//**
     * 根据id统计总记录数
     * @return Long
     * *//*
    Long getCompanyUserCount();
    *//**
     * 通过email修改用户密码
     * @param String mobile,String password
     * @return String mobile
     * 
     * *//*
    void updatePasswordByEmail(String email,String password);
    *//**
     * 通过id更新icon
     * @param Long id，String icon
     * *//*
    void updateIconById(Long id,String icon);
    *//**
	 * 通过id查询iconLong
	 * @return User
	 * @param 
	 * *//*
	CompanyUser selectIconById(Long id);
	
}
*/