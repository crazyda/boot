package com.demo.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.demo.service.UserService;
import com.demo.service.impl.CustmUserDetailsService;

@Configuration
@EnableWebSecurity //这里启用了 Web 安全
public class SecurtityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	CustmUserDetailsService userDetailsService;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		/**
		 * authorizeRequests() ������Щurl ��Ҫ������,��Щ����Ҫ
		 * formLogin() ���嵱��Ҫ�û���¼��ʱ�� ת����¼ҳ��
		 */
//		http
//		.authorizeRequests()
//		.antMatchers("/product/**").hasRole("USER")
//		.antMatchers("/admin/**").hasRole("ADMIN")
//		.anyRequest().authenticated()
//		.and()
//		.formLogin().and()
//		.httpBasic();
		
		//
//		http.formLogin() 	// 通过formLogin 方法定制登录操作
//		.and()
//		.authorizeRequests() 	//通过 这个方法来开始请求权限配置
//		.anyRequest()	//其余所有的请求都需要认证后才能访问
//		.authenticated(); //用户登录后可以访问
		http.csrf().disable();//关闭防跨域攻击功能，
		
		
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth
//		.inMemoryAuthentication()
//		.passwordEncoder(new MyPasswordEncoder()) //继承springSecurtity的密码,自定义密码
//		.withUser("admin1")
//		.password("admin1")
//		.roles("ADMIN","USER")
//		.and()
//		.passwordEncoder(new MyPasswordEncoder())
//		.withUser("user1")
//		.password("user1")
//		.roles("USER");
//		auth.userDetailsService(CustomUserService())
//		.passwordEncoder(passwordEncoder());
	}
	
	UserDetailsService CustomUserService() {
		 return new CustmUserDetailsService();
	}
	
//	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	

}
