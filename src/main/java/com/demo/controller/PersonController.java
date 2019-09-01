package com.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.demo.dao.PersonRepository;
import com.demo.entity.Person;
/**
 * 测试用
 * @ClassName: PersonController
 * @Description: 
 * @Author Crazy
 * @DateTime 2019年9月1日 下午4:31:15
 */
@RestController
@RequestMapping("/person")
public class PersonController {
	@Autowired
	PersonRepository personRepository;
	
	@RequestMapping(method = RequestMethod.GET,produces = {MediaType.APPLICATION_JSON_VALUE} )
	public List<Person> findAll(){
		return personRepository.findAll();
	}

}
