package com.demo.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.NamedQuery;

@Entity //1 注解知名这个一个和数据库映射的实体类
//定义查询方法,一个名称映射一个查询语句
//@NamedQuery(name = "Person.withNameAndAddressNamedQuery",query = "select p from Person p where p.name=?1 and address=?2")
public class Person {
	@Id //2	指明这个属性映射数据的主键
	@GeneratedValue //3	默认使用主键生成方式为 自增,
	private Long id;
	
	private String name;
	
	private Integer age;
	
	private String address;
	
	
	
	public Person() {
		super();
	}
	public Person(Long id, String name, Integer age, String address) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.address = address;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Integer getAge() {
		return age;
	}
	public void setAge(Integer age) {
		this.age = age;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}


}
