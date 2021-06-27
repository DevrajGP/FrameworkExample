package com.automation.testCases;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class TestCaseWithoutFramework {

    @Test
    public void Test1() throws InterruptedException
    {
        System.setProperty("webdriver.chrome.driver", "./Drivers/chromodriver");

        WebDriver driver = new ChromeDriver();

        driver.get("");

        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        driver.findElement(By.name("username")).sendKeys("");

        driver.findElement(By.name("password")).sendKeys("");

    }
}
