package com.zoro.automation.pages;

import org.openqa.selenium.By;


public class SecureAreaPage extends BasePage {
      public SecureAreaPage() {
		  super();
	  }
      By secureAreaHeader = By.cssSelector(".example h2");
      By flashMessage = By.id("flash");
      By logoutButton = By.cssSelector("a.button.secondary.radius");
      public String getHeaderText(){
    	  return getText(secureAreaHeader);
    	  
      }
      public String getCurrentUrl() {
		  return driver.getCurrentUrl();
	  }
      public String flashMessage() {
    	  return getText(flashMessage);
	  }
      public LoginPage clickLogout(){
    	 click(logoutButton);
    	 return new LoginPage();
      }
      
}
