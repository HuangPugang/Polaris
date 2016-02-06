package com.hpg.demo.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.hpg.demo.bean.User;
import com.hpg.demo.dao.UserMapper;
import com.hpg.demo.service.UserService;

@Service("userServiceImpl")
public class UserServiceImpl implements UserService {

	@Resource(name = "userMapper")
	private UserMapper userMapper;

	public User isUserNameExists(String userName) {
		User user = userMapper.findUserByUserName(userName);
		if (user != null) {
			return user;
		} else {
			return null;
		}
	}

	public void insertUser(User user) {
		// TODO Auto-generated method stub
		userMapper.save(user);

	}

	public User findUserByUserName(String userName) {
		// TODO Auto-generated method stub
		return userMapper.findUserByUserName(userName);
	}

	public User isUernameMatchPassword(String userName, String password) {
		User user = userMapper.findUserByUserNameAndPassword(userName, password);
		return user;
	}

	public void updateUserInfo(String userName, int sex, String profiles) {
		// TODO Auto-generated method stub
		userMapper.updateUserInfo(userName, sex, profiles);
	}

}
