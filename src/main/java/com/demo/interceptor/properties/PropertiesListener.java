package com.demo.interceptor.properties;

 
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.event.ApplicationStartedEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

/**
 * 配置文件监听器，用来加载自定义配置文件
 */
@Component
public class PropertiesListener implements ApplicationListener<ApplicationStartedEvent> {

	private   Logger logger = LoggerFactory.getLogger(PropertiesListener.class);
	
    private String[] propertyFileName;

    public PropertiesListener(String[] propertyFileName) {
        this.propertyFileName = propertyFileName;
    }

    @Override
    public void onApplicationEvent(ApplicationStartedEvent event) {
    	logger.info("PropertiesListener propertyFileName :"+propertyFileName);
        PropertiesListenerConfig.loadAllProperties(propertyFileName);
    }
}