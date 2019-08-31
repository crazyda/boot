package com.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.Configuration;

@SpringBootApplication(exclude = {
        DataSourceAutoConfiguration.class
})
@ServletComponentScan
@Configuration
@EnableAutoConfiguration
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
//	 @Bean  
//	    public ConfigurationCustomizer configurationCustomizer() {  
//	        return new ConfigurationCustomizer() {  
//	  
//	            public void customize(org.apache.ibatis.session.Configuration configuration) {  
//	                configuration.setMapUnderscoreToCamelCase(true);//配置tomcat
//	            }  
//	        }; 
//	 }
	 
	/**
	 * 	
	 * @Title: tomcatServletWebServerFactory
	 * @Description: https  请求 转发未 http 
	 * @Author Crazy
	 * @DateTime 2019年8月31日 上午9:46:39
	 * @return
	 */
//	 @Bean
//	 public TomcatServletWebServerFactory tomcatServletWebServerFactory() {
//			TomcatServletWebServerFactory factory = new TomcatServletWebServerFactory () {
//
//				@Override
//				protected void postProcessContext(Context context) {
//					SecurityConstraint constraint = new SecurityConstraint();
//					constraint.setUserConstraint("CONFIDENTIAL");
//					SecurityCollection collection = new SecurityCollection();
//					collection.addPattern("/*");
//					constraint.addCollection(collection);
//					context.addConstraint(constraint);
//				}
//				
//			};
//			factory.addAdditionalTomcatConnectors(createTomcatConnector());
//			return factory;
//		} 
		
//		private Connector createTomcatConnector() {
//			Connector connector = new 
//					Connector("org.apache.coyote.http11.Http11NioProtocol");
//			connector.setScheme("http");
//			connector.setPort(8080);
//			connector.setSecure(false);
//			connector.setRedirectPort(8081);
//			return connector;
//			
//		}
}
