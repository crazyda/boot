package com.demo;

import org.apache.catalina.Context;
import org.apache.catalina.connector.Connector;
import org.apache.tomcat.util.descriptor.web.SecurityCollection;
import org.apache.tomcat.util.descriptor.web.SecurityConstraint;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.DataSourceTransactionManagerAutoConfiguration;
import org.springframework.boot.web.embedded.tomcat.TomcatServletWebServerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;

//��Spring Boot��Ŀ�ĺ���ע��,��ҪĿ���ǿ����Զ�����,	exclude�ر��ض����Զ�����
@SpringBootApplication(exclude = { DataSourceAutoConfiguration.class, DataSourceTransactionManagerAutoConfiguration.class })
@ComponentScan //指定扫描的包 ({"com.demo.configuration","com.demo.controller","com.demo.entity","com.demo.mapper","com.demo.mongoRepository","com.demo.service"
//,"com.demo.utils"})
public class DemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoApplication.class, args);
	}
	
//	 @Bean  
//	    public ConfigurationCustomizer configurationCustomizer() {  
//	        return new ConfigurationCustomizer() {  
//	  
//	            public void customize(org.apache.ibatis.session.Configuration configuration) {  
//	                configuration.setMapUnderscoreToCamelCase(true);//�����շ���������  
//	            }  
//	        }; 
//	 }
	 
	 /**
	  * ��������������� Http ������˿�Ϊ 8081���������� 8081 �����󣬽����Զ��ض��� 8080 ��� https �Ķ˿���
	  * Spring Boot ��֧��ͬʱ���� HTTP �� HTTPS ��Ϊ�˽��������⣬���������������һ������ת�������û����� HTTP ����ʱ���Զ�ת���� HTTPS ��
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
//		
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
