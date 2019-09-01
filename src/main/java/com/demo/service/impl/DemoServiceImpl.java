package com.demo.service.impl;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
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

	@Override
	@CachePut(value = "people",key="#person.id") // 缓存新增或更新的数据到缓存,缓存名称为欸 people 数据的key是person 的id
	public Person save(Person person) {
		Person p = personRepository.save(person);
		System.out.println("缓存id:"+p.getId());
		return p;
	}

	@Override
	@CacheEvict(value = "people")// 从缓存中删除key 为id 的数据
	public void remove(Long id) {
		System.out.println("删除id key 为:"+id+"的数据缓存");
		
	}

	@Override
	@Cacheable(value = "people", key = "#person.id")//3 缓存key为person的id 数据到People 中
	public Person findOne(Person person) {
		Person p = personRepository.findOne(person.getId());
		System.out.println("为id、key为:"+p.getId()+"数据做了缓存");
		return p;
	}

}
