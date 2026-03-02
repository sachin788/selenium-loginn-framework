package com.zoro.automation.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class SecureAreaPage extends BasePage {
//      WebDriver driver;
      public SecureAreaPage(WebDriver driver) {
		  super(driver);
	  }
      By secureAreaHeader = By.cssSelector(".example h2");
      By flashMessage = By.id("flash");
      By logoutButton = By.cssSelector("a.button.secondary.radius");
      public String getHeaderText(){
    	  return driver.findElement(secureAreaHeader).getText();
    	  
      }
      public String getCurrentUrl() {
		  return driver.getCurrentUrl();
	  }
      public String flashMessage() {
    	  waitForVisibility(flashMessage);
		  return driver.findElement(flashMessage).getText();
	  }
      public void clickLogout(){
    	  waitForClickability(logoutButton);
    	  driver.findElement(logoutButton).click();
      }
      
}
