package com.zoro.automation.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.zoro.automation.base.BaseTest;
import com.zoro.automation.pages.FogotPasswordPage;


public class ForgotPasswordTest extends BaseTest {
	
    
	@Test
	public void testForgotPassword() {
		navigateTo("forgotPasswordUrl");
		FogotPasswordPage forgotPasswordPage = new FogotPasswordPage();
		forgotPasswordPage.testForgotPassword();
		Assert.assertTrue(forgotPasswordPage.getCurrentUrl().contains("/email_sent"));
	}
}
