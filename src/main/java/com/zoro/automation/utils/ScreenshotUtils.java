package com.zoro.automation.utils;

import java.io.File;
import java.nio.file.Path;
import java.nio.file.Files;
import java.nio.file.StandardCopyOption;
import java.text.SimpleDateFormat;
import java.util.Date;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;


import com.zoro.automation.factory.DriverFactory;

public class ScreenshotUtils {

    public static void takeScreenshot(String testName) {
    	String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss_SSS").format(new Date());
    	String fileName = testName + "_" + timestamp + ".png";

        try {
            TakesScreenshot ts = (TakesScreenshot) DriverFactory.getDriver();
            File src = ts.getScreenshotAs(OutputType.FILE);

            // Create screenshots directory if not exists
            File folder = new File("screenshots");
            if (!folder.exists()) {
                folder.mkdirs();
            }

            Path destination = new File(folder, fileName).toPath();

            Files.copy(src.toPath(), destination, StandardCopyOption.REPLACE_EXISTING);

            System.out.println("Screenshot saved at: " + destination);

        } catch (Exception e) {
            System.out.println("Failed to capture screenshot: " + e.getMessage());
        }
    }
}