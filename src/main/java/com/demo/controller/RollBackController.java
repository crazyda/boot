package com.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.entity.Person;
import com.demo.service.DemoService;

/**
 * 	测试数据回滚
 * @ClassName: RollBackController
 * @Description: 
 * @Author Crazy
 * @DateTime 2019年9月1日 上午9:34:04
 */
@RestController
public class RollBackController {
	
	@Autowired
	DemoService demoService;
	
	@RequestMapping("/rollback")
	public Person rollback(Person person){ //1 回滚
		
		return demoService.savePersonWithRollBack(person);
	}
	
	@RequestMapping("/norollback")
	public Person noRollback(Person person){//2  不回滚
		
		return demoService.savePersonWithoutRollBack(person);
		
		
	}
	
}
