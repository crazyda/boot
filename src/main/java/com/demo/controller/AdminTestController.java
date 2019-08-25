package com.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/admin")
public class AdminTestController {
	
	
	@RequestMapping(value="/home")
	@ResponseBody
	public String productInfo() {
		return "admin home page";
	}
	
	
}