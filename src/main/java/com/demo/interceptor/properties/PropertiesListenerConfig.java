package com.demo.interceptor.properties;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeansException;
import org.springframework.core.io.support.PropertiesLoaderUtils;


public class PropertiesListenerConfig {
	
	public static Map<String, Object> propertiesMap = new HashMap<>();
    
	private static  Logger logger = LoggerFactory.getLogger(PropertiesListenerConfig.class);
	public static void loadAllProperties(String[] propertyFileName) {
		try {
			logger.info("PropertiesListenerConfig propertyFileName :"+propertyFileName);
			for(String filename: propertyFileName) {
				Properties properties = PropertiesLoaderUtils.loadAllProperties(filename);
				processProperties(properties);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static void processProperties(Properties props) throws BeansException {
		for (Object key : props.keySet()) {
			String keyStr = key.toString();
			try {
				String val=new String(props.getProperty(keyStr).getBytes("ISO-8859-1"), "utf-8");
				//logger.info("PropertiesListenerConfig processProperties value :"+val);
				// PropertiesLoaderUtils的默认编码是ISO-8859-1,在这里转码一下
				propertiesMap.put(keyStr, val);
			} catch (UnsupportedEncodingException e) {
				e.printStackTrace();
			} catch (java.lang.Exception e) {
				e.printStackTrace();
			}
		}
	}
	/*
	 * public static String getKey(String name) { Object value =
	 * propertiesMap!=null?propertiesMap.get(name.trim()):"";
	 * 
	 * return value!=null?value.toString():""; }
	 */
	 public static String getProperty(String name) {
		 Object val=propertiesMap.get(name); 
		 if(val!=null) { 
			 return String.valueOf(val); 
		  }
		  return ""; 
     }
	
	public static Map<String, Object> getAllProperty() { return propertiesMap; }
}