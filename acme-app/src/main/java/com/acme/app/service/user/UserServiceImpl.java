package com.acme.app.service.user;

import java.io.File;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.acme.api.enums.AcmeResponseEnums;
import com.acme.api.enums.Gender;
import com.acme.api.exception.AcmeRuntimeException;
import com.acme.api.utils.AcmeUtils;
import com.acme.api.utils.DateUtils;
import com.acme.api.utils.MD5;
import com.acme.api.utils.UserValidateUtils;
import com.acme.app.mapper.user.UserMapper;
import com.acme.app.model.user.User;
@Service
public class UserServiceImpl implements UserService{
	@Resource
	private UserMapper userMapper;
	@Resource
	private UserQueryService userQueryService;

	@Override
	public boolean isExistMobile(String mobile) {
		// TODO Auto-generated method stub
		User user=userQueryService.findByMobile(mobile);
		return user==null?false:true;
	}
	
	@Override
	public String updateUserByMobile(User user) {
		// TODO Auto-generated method stub
		if(user==null){
			return null;
		}
		User user_temp=userMapper.selectByMobile(user.getMobile());
		isEffect(user_temp);
		user.setGmtModified(DateUtils.getDate());
		//user.setPassword(MD5.encodePassword(user.getPassword()));
	    userMapper.updateUserByMobile(user);
	    return user.getMobile();
	}
	/**
	 * 修改密码独立于修改信息
	 * */
	@Override
	public Long updateUserById(User user) {
		// TODO Auto-generated method stub
		isEffect(user);
		user.setGmtModified(DateUtils.getDate());
		user.setUserKey(AcmeUtils.getUserkey(user.getMobile()));
		//user.setPassword(MD5.encodePassword(user.getPassword()));
		if(user.getUserType()==1){
			user.setDeviceNumber(200);
		}
		userMapper.updateByPrimaryKey(user);
		return user.getId();
	}

	@Override
	public void deleteUserById(Long id) {
		// TODO Auto-generated method stub
		userMapper.deleteByPrimaryKey(id);
	}

	@Override
	public String deleteUserByMobile(String mobile) {
		// TODO Auto-generated method stub
		return userMapper.deleteUserByMobile(mobile);
	}
	
	@Override
	public Long createUser(User user) {
		// TODO 已经修改
		isEffect(user);
		uniqueCheck(user);
		user.setPassword(MD5.encodePassword(user.getPassword()));
		user.setUserKey(AcmeUtils.getUserkey(user.getMobile()));
		user.setGmtCreate(DateUtils.getDate());
		user.setGmtModified(DateUtils.getDate());
		if(user.getUserType()==1){
			user.setDeviceNumber(200);
		}
		userMapper.insert(user);
		return user.getId();
	}

	@Override
	public String updatePasswordByMobile(String mobile, String password) {
		// TODO Auto-generated method stub
		userMapper.updatePasswordByMobile(mobile, MD5.encodePassword(password),DateUtils.getDate());
		return mobile;
	}

	

	@Override
	public void deleteUser(String userKey, String mobile, String password) {
		// TODO Auto-generated method stub
		userMapper.deleteUser(userKey,mobile,MD5.encodePassword(password));
	}

	@Override
	public void isEffect(User user) {
		// TODO Auto-generated method stub
		if(user==null){
			throw new AcmeRuntimeException(AcmeResponseEnums.BAD_REQUEST);
		}
		if(!UserValidateUtils.isMObile(user.getMobile())){
			throw new AcmeRuntimeException(AcmeResponseEnums.INVALID_MOBILE);
		}
		if(!UserValidateUtils.isEmail(user.getEmail())){
			throw new AcmeRuntimeException(AcmeResponseEnums.INVALID_EMAIL);
		}
		if(!createUserCheck(user.getGender())){
			throw new AcmeRuntimeException(AcmeResponseEnums.INVALID_GENDER);
		}
		
	}


	@Override
	public boolean isExistUserKey(String userKey) {
		// TODO Auto-generated method stub
		User user=null;
		user=userQueryService.findByUserKey(userKey);
		return user==null?false:true;
	}

	@Override
	public boolean isExistEmail(String email) {
		// TODO Auto-generated method stub
		User user=null;
		user=userQueryService.findByEmail(email);
		return user==null?false:true;
	}

	@Override
	public boolean createUserCheck(String gender) {
		// TODO Auto-generated method stub
		return UserValidateUtils.isGender(gender);
	}

	@Override
	public void uniqueCheck(User user) {
		// TODO Auto-generated method stub
		if(isExistUserKey(user.getUserKey())){
			throw new AcmeRuntimeException(AcmeResponseEnums.REPEAT_USERKEY);
		}
		if(isExistMobile(user.getMobile())){
			throw new AcmeRuntimeException(AcmeResponseEnums.REPEAT_MOBILE);
		}
		if(isExistEmail(user.getEmail())){
			throw new AcmeRuntimeException(AcmeResponseEnums.REPEAT_EMAIL);
		}
	}

	@Override
	public String deleteUserByEmail(String email) {
		// TODO Auto-generated method stub
		userMapper.deleteUserByEmail(email);
		return email;
	}

	@Override
	public String updateUserByEmail(String email, String password) {
		// TODO Auto-generated method stub
		userMapper.updatePasswordByEmail(email, MD5.encodePassword(password));
		return email;
	}

	@Override
	public void updateIconById(Long id, String icon) {
		// TODO Auto-generated method stub
		User user=userMapper.selectIconById(id);
		userMapper.updateIconById(id, icon);
		/**
		 * 不为空时需要删除对应文件夹*/
		if(!"".equals(user.getIcon())){
			File file=new File(user.getIcon());
			file.deleteOnExit();
		}
		
	}
	

	
	
}
