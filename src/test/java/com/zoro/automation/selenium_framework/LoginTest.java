package com.zoro.automation.selenium_framework;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class LoginTest {

	
		// TODO Auto-generated method stub
		@Test
		public void openWebsite() {
			// Code to open the website
			WebDriver driver = new ChromeDriver();
			driver.get("https://the-internet.herokuapp.com/login");
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
			driver.findElement(By.id("username")).sendKeys("tomsmith");
			 driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
			 driver.findElement(By.cssSelector("button[type='submit']")).click();
			 driver.quit();
		}
		@Test
		public void WrongUsername() {
			// Code to open the website
			WebDriver driver = new ChromeDriver();
			driver.get("https://the-internet.herokuapp.com/login");
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
			driver.findElement(By.id("username")).sendKeys("tomsmith1");
			 driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
			 driver.findElement(By.cssSelector("button[type='submit']")).click();
			 Assert.assertTrue(driver.findElement(By.id("flash")).getText().contains("Your username is invalid!"));
			 driver.quit();
		}
		@Test
		public void WrongPassword() {
			// Code to open the website
			WebDriver driver = new ChromeDriver();
			driver.get("https://the-internet.herokuapp.com/login");
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

			wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("username")));
			driver.findElement(By.id("username")).sendKeys("tomsmith");
			 driver.findElement(By.id("password")).sendKeys("SuperSecretPassword");
			 driver.findElement(By.cssSelector("button[type='submit']")).click();
			 Assert.assertTrue(driver.findElement(By.id("flash")).getText().contains("Your password is invalid!"));
			 driver.quit();
		}
		
	}


