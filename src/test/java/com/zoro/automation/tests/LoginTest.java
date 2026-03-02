package com.zoro.automation.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.zoro.automation.base.BaseTest;
import com.zoro.automation.pages.LoginPage;
import com.zoro.automation.pages.SecureAreaPage;
public class LoginTest extends BaseTest {
	 
	
	@Test
	public void testValidLogin() {

		SecureAreaPage secureAreaPage = new SecureAreaPage(driver);
		LoginPage loginPage = new LoginPage(driver);
	    loginPage.enterUserPass("tomsmith", "SuperSecretPassword!");
	    loginPage.clickLogin();
	    Assert.assertTrue(secureAreaPage.getCurrentUrl().contains("/secure"));
	    Assert.assertEquals(secureAreaPage.getHeaderText() ,"Secure Area");
	    Assert.assertTrue(secureAreaPage.flashMessage().contains("You logged into a secure area!"));
	    secureAreaPage.clickLogout();
	    Assert.assertTrue(loginPage.getCurrentUrl().contains("/login"));
//	    driver.quit();
	}
//	@Test
//	public void testInvalidLogin() {
//	    driver.get("https://the-internet.herokuapp.com/login");
//		LoginPage loginPage = new LoginPage(driver);
//	    loginPage.enterUsername("&*)$&");
//	    loginPage.enterPassword("SuperSecretPassword! ");
//	    loginPage.clickLogin();
//	    Assert.assertTrue(loginPage.getErrorMessage()
//                .contains("Your username is invalid!"));
//	    driver.quit();
//	}
//	@Test
//	public void testEmptyCredentials() {
//	    driver.get("https://the-internet.herokuapp.com/login");
//		LoginPage loginPage = new LoginPage(driver);
//	    loginPage.enterUsername("");
//	    loginPage.enterPassword("");
//	    loginPage.clickLogin();
//	    Assert.assertTrue(loginPage.getErrorMessage()
//                .contains("Your username is invalid!"));
//	    driver.quit();
//	}
}
