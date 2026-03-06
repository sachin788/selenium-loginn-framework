package com.zoro.listeners;

import org.testng.ITestListener;
import org.testng.ITestResult;
import com.aventstack.extentreports.*;

import com.zoro.automation.utils.ExtentManager;

public class TestListener implements ITestListener {

    ExtentReports extent = ExtentManager.getExtentReport();
    ExtentTest test;

    public void onTestStart(ITestResult result) {
        test = extent.createTest(result.getMethod().getMethodName());
    }

    public void onTestSuccess(ITestResult result) {
        test.pass("Test Passed");
    }

    public void onTestFailure(ITestResult result) {
        test.fail(result.getThrowable());
    }

    public void onFinish(org.testng.ITestContext context) {
        extent.flush();
    }
}