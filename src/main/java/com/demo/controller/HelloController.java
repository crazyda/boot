package com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.demo.entity.User;
import com.demo.mongoRepository.UserMongo;
import com.demo.service.UserService;

@Controller
public class HelloController {
	
	@Autowired
	public UserService userService;
	
	@Autowired
	UserMongo userMongo;
	
	
	@RequestMapping("/insecurity")
	@ResponseBody
	public String hello() {
		User user = userService.findOneByLogin("admin1");
//		userMongo.save(user);
		return "spring security :"+user.toString();
	}
	
	
}