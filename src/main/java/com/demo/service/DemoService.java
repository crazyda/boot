package com.demo.service;

import com.demo.entity.Person;

public interface DemoService {

		public Person savePersonWithRollBack(Person person);
		public Person savePersonWithoutRollBack(Person person);
}
