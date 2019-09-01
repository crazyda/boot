package com.demo.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.demo.dao.PersonRepository;
import com.demo.entity.Person;
import com.demo.service.DemoService;

@Service
public class DemoServiceImpl implements DemoService {

	@Autowired
	PersonRepository personRepository;
	
	@Override
	@Transactional(rollbackFor= {IllegalArgumentException.class}) // 使用注解rollbackFor 属性,指定特定异常时,数据回滚
	public Person savePersonWithRollBack(Person person) {
		Person p = personRepository.save(person);
		if(person.getName().equals("达")) {
			throw new IllegalArgumentException("飞已经存在 ,数据回滚");
		}
		return p;
	}

	@Override
	@Transactional(noRollbackFor= {IllegalArgumentException.class})
	public Person savePersonWithoutRollBack(Person person) {
		Person p = personRepository.save(person);
		if(person.getName().equals("达")) {
			throw new IllegalArgumentException("飞已经存在 ,数据回滚");
		}
		return p;
	}

}
