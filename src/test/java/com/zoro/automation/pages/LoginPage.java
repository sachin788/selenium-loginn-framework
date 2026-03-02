package com.zoro.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;


public class LoginPage extends BasePage {
//	WebDriver driver;
	
	public LoginPage(WebDriver driver) {
		super(driver);
		}
	By usernameField = By.id("username");
	By passwordField = By.id("password");
	By loginButton =   By.cssSelector("button[type='submit']");
	By errorMessage = By.id("flash");
	
	
	public void enterUserPass(String username, String password) {
		waitForVisibility(usernameField);
		waitForVisibility(passwordField);
		driver.findElement(usernameField).sendKeys(username);
		driver.findElement(passwordField).sendKeys(password);
	}
	public void clickLogin() {
		waitForClickability(loginButton);
		driver.findElement(loginButton).click();
	}
	public String getErrorMessage() {
		waitForVisibility(errorMessage);
		return driver.findElement(errorMessage).getText();
	}
	public String getCurrentUrl() {
		  return driver.getCurrentUrl();
	  }
	
}