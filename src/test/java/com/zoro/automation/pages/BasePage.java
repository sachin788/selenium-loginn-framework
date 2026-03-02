package com.zoro.automation.pages;

import java.time.Duration;
import com.zoro.automation.factory.DriverFactory;
import com.zoro.automation.utils.WaitUtils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BasePage {

    protected WebDriver driver;
    protected WebDriverWait wait;

    public BasePage() {
        this.driver = DriverFactory.getDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    protected WebElement getElement(By locator) {
        return driver.findElement(locator);
    }
    protected void click(By locator) {
    	 WaitUtils.waitForClickability(locator, 10);
    	 getElement(locator).click();
    }
    protected void type(By locator, String text) {
		 WaitUtils.waitForVisibility(locator, 10);
		 WebElement element = getElement(locator);
	     element.clear();
	     element.sendKeys(text);
	}
    protected String getText(By locator) {
        WaitUtils.waitForVisibility(locator, 10);
        return getElement(locator).getText();
    }

    protected boolean isDisplayed(By locator) {
        try {
            WaitUtils.waitForVisibility(locator, 5);
            return getElement(locator).isDisplayed();
        } catch (Exception e) {
            return false;
        }
    }
    protected void waitForVisibility(By locator) {
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    protected void waitForClickability(By locator) {
        wait.until(ExpectedConditions.elementToBeClickable(locator));
    }
}