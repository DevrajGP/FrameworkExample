package com.automation.utilities;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class BrowserFactory {

    public static WebDriver startApplication(WebDriver driver, String browserName, String url){

        if(browserName.equals("Chrome")){
            System.setProperty("webdriver.chrome.driver", "./Drivers/chromedriver");
            driver = new ChromeDriver();
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        } else {
            System.out.println("We do not support this browser");
        }
        driver.manage().window().maximize();
        driver.get(url);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        return driver;

    }

    public static void closeBrowser(WebDriver driver){
        driver.quit();

    }
}
