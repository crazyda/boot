package com.demo.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

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
//		.authorizeRequests() //通过这个方法 来开始请求权限配置
//		.antMatchers("/product/**").hasRole("USER") //拥有user角色的可以访问
//		.antMatchers("/admin/**").hasRole("ADMIN")//拥有admin角色的可以访问
//		.anyRequest().authenticated()//其余所有请求都需要认证后登陆后才能访问
//		.and()
//		.formLogin() //定制登陆操作
//		.loginPage("") //定制登陆页面的访问地址
//		.defaultSuccessUrl("")//指定登陆成功后转向的页面
//		.failureUrl("")//登陆失败后转向的地址
//		.and()
//		.rememberMe()//开启cookie存储用户信息
//		.tokenValiditySeconds(100)// 指定cookie有效期 100s
//		.key("")//指定Cookie中的私钥
//		.and()
//		.logout()//定制注销行为
//		.logoutUrl("")//指定注销url路径
//		.logoutSuccessUrl("");//z指定注销成功后转向页面
		
		//
//		http.formLogin() 	// 通过formLogin 方法定制登录操作
//		.and()
//		.authorizeRequests() 	//通过 这个方法来开始请求权限配置
//		.anyRequest()	//其余所有的请求都需要认证后才能访问
//		.authenticated(); //用户登录后可以访问
//		http.csrf().disable();//关闭防跨域攻击功能，
		
		
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
