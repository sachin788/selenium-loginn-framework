package com.zoro.automation.base;

import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

import com.zoro.automation.factory.DriverFactory;
import com.zoro.automation.utils.ConfigReader;
import com.zoro.automation.utils.ScreenshotUtils;

public class BaseTest {

   
    
   
	private ConfigReader configReader;

	@Parameters("browser")
    @BeforeMethod
    public void setup(String browser) {

        configReader = new ConfigReader();

        if(browser == null) {
            browser = configReader.getProperty("browser");
        }

        DriverFactory.initDriver(browser);
        DriverFactory.getDriver().manage().window().maximize();
    }

	protected void navigateTo(String urlKey) {
	    String url = configReader.getProperty(urlKey);
	    DriverFactory.getDriver().get(url);
	}

	@AfterMethod
	public void tearDown(ITestResult result) {

	    if (result.getStatus() == ITestResult.FAILURE) {
	        ScreenshotUtils.takeScreenshot(result.getName());
	    }

	    DriverFactory.quitDriver();
	}
   
}
	

