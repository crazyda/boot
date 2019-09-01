package com.demo;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.WebApplicationContext;

import com.demo.dao.PersonRepository;
import com.demo.entity.Person;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringJUnit4ClassRunner.class)
//@SpringApplicationConfiguration(classes = DemoApplication.class)
@SpringBootTest
@WebAppConfiguration
@Transactional // 确保每次测试后的数据都将被回滚
public class DemoApplicationTest {
	@Autowired
	PersonRepository personRepository;
	
	MockMvc mvc;
	
	@Autowired 
	WebApplicationContext webApplicationContext;
	
	String expectedJson;
	
	@Before //3 测试开始钱进行一些初始化工作
	public void setUp() throws JsonProcessingException{ 
		Person p1 = new Person("cc");
//		Person p2 = new Person("wisely");
		personRepository.save(p1);
//		personRepository.save(p2);
		
		expectedJson =Obj2Json(personRepository.findAll()); //4 获得期待返回的json字符串
		mvc = MockMvcBuilders.webAppContextSetup(webApplicationContext).build();
		
		
	}
	
	protected String Obj2Json(Object obj) throws JsonProcessingException{//5 将对象转换成json
		ObjectMapper mapper = new ObjectMapper();
		return mapper.writeValueAsString(obj);
	}
	
	@Test
	public void testPersonController() throws Exception {
		String uri="/person";
		MvcResult result = mvc.perform(MockMvcRequestBuilders.get(uri).accept(MediaType.APPLICATION_JSON))
																.andReturn(); //6 获得执行结果
		int status = result.getResponse().getStatus(); //7 获得执行结果抓过你太
		String content = result.getResponse().getContentAsString(); //8获得request执行结果内容
		
		Assert.assertEquals("错误，正确的返回值为200",200, status); //9 将预期状态值和返回状态值比较
		Assert.assertEquals("错误，返回值和预期返回值不一致", expectedJson,content); //10 将预期字符串和返回字符串比较
	}

}
