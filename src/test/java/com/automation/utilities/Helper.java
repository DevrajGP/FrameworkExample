package com.automation.utilities;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.io.FileHandler;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Helper {

    // Screen shot, alerts, frames, windows, sync issue, javascript executor
    public static String captureScreenshot(WebDriver driver){
        File src  = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String screenshotPath = "./Screenshots/" + getCurrentDateTime() + "Login.png";

        try {
            FileHandler.copy(src, new File(screenshotPath));
            System.out.println("Screenshot captured");
        } catch (IOException e) {
            System.out.println("Unable to capture Screenshots" + e.getMessage());
        }
        return screenshotPath;
    }

    public static String getCurrentDateTime(){
        DateFormat dateFormat = new SimpleDateFormat("MM_dd_yyyy_HH_mm_ss");
        Date date = new Date();
        return dateFormat.format(date);
    }
}
