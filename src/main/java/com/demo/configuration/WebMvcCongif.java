package com.demo.configuration;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * @Configuration
 * @ClassName: WebMvcCongif
 * @Description:	通过配置类 和继承该类  实现 保留springboot 的mvc 默认配置 又新增自己的配置 
 * @Author Crazy
 * @DateTime 2019年8月31日 上午10:44:29
 */
//@Configuration
public class WebMvcCongif extends WebMvcConfigurerAdapter{

	@Override
	public void addViewControllers(ViewControllerRegistry registry) {
		registry.addViewController("/xx").setViewName("/xx");
	}
	
}
