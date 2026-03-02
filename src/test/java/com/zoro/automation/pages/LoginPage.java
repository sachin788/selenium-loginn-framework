package com.zoro.automation.pages;

import org.openqa.selenium.By;

public class LoginPage extends BasePage {
	
	public LoginPage() {
		super();
		}
	By usernameField = By.id("username");
	By passwordField = By.id("password");
	By loginButton =   By.cssSelector("button[type='submit']");
	By errorMessage = By.id("flash");
	
	
	public SecureAreaPage login(String username, String password) {
		type(usernameField, username);
		type(passwordField, password);
		click(loginButton);
		return new SecureAreaPage();
		
	}
	
	public String getErrorMessage() {
		waitForVisibility(errorMessage);
		return driver.findElement(errorMessage).getText();
	}
	
	public String getCurrentUrl() {
		  return driver.getCurrentUrl();
	  }
	
}