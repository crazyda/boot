package com.demo.service;

import com.demo.entity.User;


public interface UserService {
	
	public User findOneByLogin(String login);

}
