package com.zoro.automation.factory;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import io.github.bonigarcia.wdm.WebDriverManager;

public class DriverFactory {
//	WebDriver driver;
	private static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
	public static void initDriver(String browser) {
		
		if (browser.equalsIgnoreCase("chrome")) {
			 WebDriverManager.chromedriver().setup();
		     driver.set(new ChromeDriver());
		} else if (browser.equalsIgnoreCase("firefox")) {
			WebDriverManager.firefoxdriver().setup();
	        driver.set(new FirefoxDriver());
		} else if (browser.equalsIgnoreCase("edge")) {
			System.setProperty("webdriver.edge.driver", "drivers/msedgedriver.exe");
		     driver.set(new EdgeDriver());
		} else {
			throw new RuntimeException("Unsupported browser: " + browser);
		}	 
	}
	public static void quitDriver() {
        driver.get().quit();
        driver.remove();
    }
	public static WebDriver getDriver() {
		return driver.get();
	}
}
