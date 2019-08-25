package com.demo.service.impl;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.demo.entity.User;
import com.demo.service.UserService;


@Service
public class CustmUserDetailsService implements UserDetailsService{

	@Autowired
	private UserService userService;

	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		//1 查询用户
		System.out.println(username);
		User user = userService.findOneByLogin(username);
		if(user == null) {
			throw new UsernameNotFoundException("User"+username+" was not found in db");
		}
		//2 设置角色
		Collection<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();
		GrantedAuthority grantedAuthority = new SimpleGrantedAuthority(user.getRole());
		grantedAuthorities.add(grantedAuthority);
		
		return new org.springframework.security.core.userdetails.User(username, user.getPassword(), grantedAuthorities);
	}
	
	

}
