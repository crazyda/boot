package com.demo.configuration;

import org.springframework.security.crypto.password.PasswordEncoder;

//https://blog.csdn.net/Michael_HM/article/details/79913542
//java.lang.IllegalArgumentException: There is no PasswordEncoder mapped for the id 账号密码为空 
public class MyPasswordEncoder implements  PasswordEncoder  {

	public String encode(CharSequence charSequence) {
		// TODO Auto-generated method stub
		return charSequence.toString();
	}

	public boolean matches(CharSequence charSequence, String encodedPassword) {
		// TODO Auto-generated method stub
		return encodedPassword.equals(charSequence.toString());
	}

}
