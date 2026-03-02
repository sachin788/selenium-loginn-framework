package com.zoro.automation.base;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;

import com.zoro.automation.factory.DriverFactory;
import com.zoro.automation.utils.ConfigReader;

public class BaseTest {

   
    private String browser;
    private String baseUrl;
    private ConfigReader configReader;
   
    @BeforeMethod
    public void setup() {
    	
    	configReader = new ConfigReader();
    	browser = configReader.getProperty("browser");
    	baseUrl = configReader.getProperty("baseUrl");
    	DriverFactory.initDriver(browser);
    	DriverFactory.getDriver().manage().window().maximize();
    	DriverFactory.getDriver().get(baseUrl);
    }

    @AfterMethod
    public void tearDown() {
    	 DriverFactory.quitDriver();
        
    }
   
}
	

