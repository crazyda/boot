package com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.demo.mapper.UserInfoMapper;
import com.demo.service.UserService;

@Controller
@RequestMapping("/product")
public class ProductTestController {
	
	@Autowired
	UserService userService;
	
//	@Autowired
//	UserInfoMapper userInfoMapper;
	
	@RequestMapping("/info")
	@ResponseBody
	public String productInfo() {
		
		String user = userService.findOneByLogin("admin1").getLogin();
		Object principl = SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();
		if(principl instanceof UserDetails) {
			user = ((UserDetails) principl).getUsername();
		}else {
			user = principl.toString();
		}
		return "some product info,user is :"+ user;
	}
	
	
}