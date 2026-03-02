package com.zoro.automation.utils;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.zoro.automation.factory.DriverFactory;

public class WaitUtils {
     private static WebDriver getDriver() {
    	 return DriverFactory.getDriver();
     }
     public static void waitForVisibility(By locator,int timeout) {
		 WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
		 wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	 }
     public static void waitForClickability(By locator,int timeout) {
		 WebDriverWait wait = new WebDriverWait(getDriver(), Duration.ofSeconds(10));
		 wait.until(ExpectedConditions.elementToBeClickable(locator));
	 }
     
}
