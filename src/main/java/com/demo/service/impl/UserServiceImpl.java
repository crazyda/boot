package com.demo.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.demo.entity.User;
import com.demo.mapper.UserInfoMapper;
import com.demo.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserInfoMapper userInfoMapper;
	
	public User findOneByLogin(String login) {
//		User user = userInfoMapper.findOneByLogin(login);
		User user = new User();
		return user;
	}
	
}	
