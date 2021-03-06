package com.acme.app.service.user;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.acme.api.enums.AcmeResponseEnums;
import com.acme.api.exception.AcmeRuntimeException;
import com.acme.api.response.Page;
import com.acme.app.mapper.user.UserMapper;
import com.acme.app.model.user.User;

@Service("userQueryService")
public class UserQueryServiceImpl implements UserQueryService{
	@Resource
	private UserMapper userMapper;
	@Override
	public List<User> findUserList() {
		// TODO Auto-generated method stub
		return userMapper.findAllUsers();
	}

	@Override
	public User findById(Long id) {
		// TODO Auto-generated method stub
		User user=null;
		user=userMapper.selectByPrimaryKey(id);
		/*if(user==null){
			throw new AcmeRuntimeException(AcmeResponseEnums.NO_RECORD);
		}*/
		return user;
	}

	@Override
	public User findByMobile(String mobile) {
		// TODO Auto-generated method stub
		User user=null;
		user=userMapper.selectByMobile(mobile);
		/*if(user==null){
			throw new AcmeRuntimeException(AcmeResponseEnums.NO_RECORD);
		}*/
		return user;
	}

	@Override
	public Long getUserCount() {
		// TODO Auto-generated method stub
		return userMapper.getUserCount();
	}

	@Override
	public Page<User> findUserByPage(Page<User> page) {
		// TODO Auto-generated method stub
		return userMapper.findUserByPage(page.getPageIndex(),page.getPageSize());
	}

	@Override
	public User findByUserKey(String userKey) {
		// TODO Auto-generated method stub
		return userMapper.selectByUserKey(userKey);
	}

	@Override
	public User findByEmail(String email) {
		// TODO Auto-generated method stub
		User user=null;
		user=userMapper.selectByEmail(email);
		/*if(user==null){
			throw new AcmeRuntimeException(AcmeResponseEnums.NO_RECORD);
		}*/
		return user;
	}

	@Override
	public User selectByMobileAndPassword(String mobile, String password) {
		// TODO Auto-generated method stub
		User user=null;
		user=userMapper.selectByMobileAndPassword(mobile, password);
		if(user==null){
			throw new AcmeRuntimeException(AcmeResponseEnums.NOT_MATCH);
		}
		return user;
	}

	@Override
	public User selectIconById(Long id) {
		// TODO Auto-generated method stub
		User user=userMapper.selectIconById(id);
		return user;
	}

	

}
