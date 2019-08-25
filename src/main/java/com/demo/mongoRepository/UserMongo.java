package com.demo.mongoRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Component;

import com.demo.entity.User;

@Component
public class UserMongo {
	
	@Autowired
	public MongoTemplate mongoTemplate;
	
	public void save(User user) {
		mongoTemplate.save(user);
	}
	
}
