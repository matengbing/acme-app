package com.acme.app.service.user;

import com.acme.app.model.user.User;

/**
 * 用户接口服务
 * @author YL.Z
 *
 * @date 2017年3月31日 下午4:09:45
 */
public interface UserService {

	
	/**
	 * 检查mobile是否已经存在
	 * 防止重复注册手机号
	 * @param String
	 * @return boolean
	 * */
	boolean isExistMobile(String mobile);
	/**
	 * 检查email是否已经存在
	 * 防止重复注册邮箱，导致通过邮箱修改密码时出现问题
	 * @param String
	 * @return boolean
	 * */
	boolean isExistEmail(String email);
	/**
	 * 检查userKey是否已存在
	 * @param String
	 * @return boolean
	 * */
	boolean isExistUserKey(String userKey);
	/**
	 * 通过手机号修改用户信息
	 * @param User
	 * @return String
	 * */
	String updateUserByMobile(User user);
	/**
	 * 通过id修改用户信息
	 * @param User
	 * @return Long
	 * */
	/**
	 * 通过email修改用户信息
	 * @param User
	 * @return String
	 * */
	String updateUserByEmail(String email,String password);
	
	
	Long updateUserById(User user);
	/**
	 * 通过id更新icon路径
	 * @param Long，String
	 * */
	void updateIconById(Long id,String icon);
	/**
	 * 通过id删除用户信息
	 * @param Long
	 * */
	void deleteUserById(Long id);
	/**
	 * 删除用户信息
	 * @param Long
	 * */
	
	void deleteUser(String userKey,String mobile,String password);
	/**
	 * 通过手机号删除用户信息
	 * @param String
	 * @return String
	 * */
	String deleteUserByMobile(String mobile);
	/**
	 * 添加用户信息
	 * @param User
	 * @return Long
	 * */
	Long createUser(User user);
	/**
	 * 通过mobile更新密码
	 * */
	String updatePasswordByMobile(String mobile,String password);
	/**
	 * 检查用户信息的gender合理性，mobile是否为有效的mobile，email是否为有效的email
	 * 
	 * */
	boolean createUserCheck(String gender);
	
	
	
	void isEffect(User user);
	/**
	 * 检查插入,修改的用户的mobile,userKey,email是否已经存在,防止影响唯一性约束
	 * @param User 
	 * */
	void uniqueCheck(User user);
	/**
	 * 通过邮箱删除用户
	 * 发送验证码到用户填入的邮箱，验证正确则可以删除
	 * @param String
	 * @return String
	 * */
	String deleteUserByEmail(String email);

	
	
}
