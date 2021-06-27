package com.automation.pages;

import com.automation.utilities.BrowserFactory;
import com.automation.utilities.ConfigReader;
import com.automation.utilities.ExcelDataProvider;
import com.automation.utilities.Helper;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.reporter.ExtentHtmlReporter;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.Reporter;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;

import java.io.File;
import java.io.IOException;

public class BaseClass {

    public WebDriver driver;
    public ExcelDataProvider excel;
    public ConfigReader configReader;
    public ExtentReports report;
    public ExtentTest logger;

    @BeforeSuite
    public void setUpSuite(){
        excel = new ExcelDataProvider();
        configReader = new ConfigReader();

        ExtentHtmlReporter extentHtmlReporter = new ExtentHtmlReporter(new File("./Reports/Framework.html"));
        report = new ExtentReports();
        report.attachReporter(extentHtmlReporter);

    }

    @BeforeClass
    public void setUp(){
        driver = BrowserFactory.startApplication(driver, configReader.getBrowser(), configReader.getUrl());
    }

    @AfterClass
    public void tearDown(){
        BrowserFactory.closeBrowser(driver);
    }

    @AfterMethod
    public void tearDownMethod(ITestResult result) throws IOException {
        if(result.getStatus()==ITestResult.FAILURE){
            Helper.captureScreenshot(driver);
            logger.fail("test failed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
        } else if(result.getStatus()==ITestResult.SUCCESS) {
            logger.pass("test passed", MediaEntityBuilder.createScreenCaptureFromPath(Helper.captureScreenshot(driver)).build());
        }
        report.flush();
        Reporter.log("Report created", true);
    }
}
