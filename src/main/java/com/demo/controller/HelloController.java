package com.demo.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.demo.entity.User;
import com.demo.mongoRepository.UserMongo;
import com.demo.service.UserService;

@Controller
public class HelloController {
	
	private static  Logger logger = LoggerFactory.getLogger(HelloController.class);
	
	
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
	@RequestMapping("/hello")
	@ResponseBody
	public String hello1() {
		User user = userService.findOneByLogin("admin1");
		try {
			System.out.println(1/0);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			logger.info("捕获异常");
			logger.info(e.toString());
		}
		
		return "spring security :"+user.toString();
	}
	
}