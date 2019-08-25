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
@EnableWebSecurity //会加载WebSecurityConfiguration类,而WebSecurityConfiguration类中就有创建springSecurityFilterChain这个Filter的代码
public class SecurtityConfiguration extends WebSecurityConfigurerAdapter {

	@Autowired
	CustmUserDetailsService userDetailsService;
	
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		/**
		 * authorizeRequests() 定义那些url 需要被保护,那些不需要
		 * formLogin() 定义当需要用户登录的时候 转到登录页面
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
//		http.formLogin() 	// 定义当需要用户登录的时候,跳转到登陆页面
//		.and()
//		.authorizeRequests() 	//定义那些URL 需要被保护,那些不需要被保护
//		.anyRequest()	//任何请求 登录后可以访问
//		.authenticated();
		http.csrf().disable();//关闭防跨域攻击功能，使用 http.csrf().disable()：
		
		
	}

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
//		auth
//		.inMemoryAuthentication()
//		.passwordEncoder(new MyPasswordEncoder()) //主要是处理密码 暗文和明文的问题
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
