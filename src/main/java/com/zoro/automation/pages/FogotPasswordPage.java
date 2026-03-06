package com.zoro.automation.pages;

import org.openqa.selenium.By;
//import org.testng.annotations.Test;

public class FogotPasswordPage extends BasePage {
	By emailField = By.id("email");
	By retrieveButton = By.id("form_submit");
	
	public FogotPasswordPage() {
		super();
	}

   public void testForgotPassword() {
	   
	   type(emailField, "montisimmi1@gmail.com");
	   click(retrieveButton);
	   
   }
  
}
