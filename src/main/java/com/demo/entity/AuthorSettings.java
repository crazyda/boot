package com.demo.entity;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component
@ConfigurationProperties //ͨ����ȡ�����ļ���ֵ,Ȼ��ע��ʹ�� ����:ѡ�������������ļ�
public class AuthorSettings {
	private String name;
	private Long age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public Long getAge() {
		return age;
	}
	public void setAge(Long age) {
		this.age = age;
	}
	

}
