package com.zoro.automation.utils;

import java.io.InputStream;
import java.util.Properties;

public class ConfigReader {
  Properties properties;
  public ConfigReader() {
	  properties = new Properties();
	  try {
		  InputStream inputStream = getClass().getClassLoader().getResourceAsStream("config.properties");
		  if(inputStream == null) {
			  throw new RuntimeException("config.properties file not found in classpath");
		  }
		  properties.load(inputStream);
	  } catch (Exception e) {
		  throw new RuntimeException("Failed to load config.properties file",e);
	  }
  }
  public String getProperty(String key) {
	  return properties.getProperty(key);
  }
  
}
