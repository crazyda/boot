package com.demo.controller;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo.entity.User;

/**
 * 	主要是restful 风格类型的接口
 * @author Crazy
 *
 */
@RestController
@RequestMapping("/api/student/")
public class RestfulController {

	@RequestMapping(method = RequestMethod.GET)
	public String Get() {
		User user = new User();
		user.setId("100");
		user.setLogin("getLogin");
		return user.toString();
	}
	
//	@RequestMapping(method = RequestMethod.POST)
	@PostMapping
	public String Post(User user) {
		user.setId("200");
		user.setLogin("putLogin");
		return user.toString();
	}
	
	 @RequestMapping(method = RequestMethod.PUT)
	 public String Put() {
	  return "{\"id\":\"3\",\"name\":\"3333333333\"}";
	 }
	 
	 @RequestMapping(method = RequestMethod.DELETE)
	 public String DELETE() {
	  return "{\"id\":\"4\",\"name\":\"4444444444\"}";
	 }
	 
	 @RequestMapping(value = "/{id}",method = RequestMethod.GET)
	 public String Get(@PathVariable("id") Integer id) {
	  return "{\"id\":\""+id+"\",\"name\":\"get path variable id\"}";
	 }
}
