package com.acme.app.service.user;

import java.util.List;




import com.acme.api.response.Page;
import com.acme.app.model.user.User;


public interface UserQueryService {
	/**
	 * 查询所有用户信息
	 * @return List<User>
	 * */
	List<User> findUserList();
	/**
	 * 通过id查询用户信息
	 * @param Long id
	 * @return User
	 * */
	User findById(Long id);
	/**
	 * 通过mobile查询用户信息
	 * @param String
	 * @return User
	 * */
	User findByMobile(String mobile);
	/**
	 * 通过userKey查询用户信息
	 * @param String
	 * @return User
	 * */
	User findByUserKey(String userKey);
	/**
	 * 通过userKey查询用户信息
	 * @param String
	 * @return User
	 * */
	User findByEmail(String email);
	/**
	 * 统计User表记录总数
	 * @return Long
	 * */
	Long getUserCount();
	/**
	 * 传入一个分页工具类，查询后返回拥有新数据的分页工具类
	 * @param Page<User>
	 * @return Page<User>
	 * */
	Page<User> findUserByPage(Page<User> page);
	
	User selectByMobileAndPassword(String mobile,String password);
	/**
	 * 通过id查询icon路径
	 * @param Long
	 * @return User
	 * */
	User selectIconById(Long id);
}
