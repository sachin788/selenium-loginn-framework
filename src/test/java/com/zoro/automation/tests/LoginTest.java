package com.zoro.automation.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.zoro.automation.base.BaseTest;
import com.zoro.automation.pages.LoginPage;
import com.zoro.automation.pages.SecureAreaPage;
public class LoginTest extends BaseTest {
	 
	
	@Test
	public void testValidLogin() {
		navigateTo("baseUrl");
		LoginPage loginPage = new LoginPage();
		
		SecureAreaPage secureAreaPage = loginPage.login("tomsmith", "SuperSecretPassword!");
		secureAreaPage.flashMessage();
	    Assert.assertTrue(secureAreaPage.getCurrentUrl().contains("/secure"));
	    Assert.assertEquals(secureAreaPage.getHeaderText() ,"Secure Area");
	    Assert.assertTrue(secureAreaPage.flashMessage().contains("You logged into a secure area!"));
	    LoginPage returnedLoginPage = secureAreaPage.clickLogout();
	    Assert.assertTrue(returnedLoginPage.getCurrentUrl().contains("/login"));
	}
	@Test
	public void testInvalidLogin() {
		navigateTo("baseUrl");
		LoginPage loginPage = new LoginPage();
	    loginPage.login("invalidUser", "invalidPassword");
	    Assert.assertTrue(loginPage.getErrorMessage()
                .contains("Your username is invalid!"));
	}
	@Test
	public void testEmptyCredentials() {
		navigateTo("baseUrl");
		LoginPage loginPage = new LoginPage();
	    loginPage.login("", "");
	    Assert.assertTrue(loginPage.getErrorMessage()
                .contains("Your username is iinvalid!"));
	}
}
