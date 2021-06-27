package com.automation.testCases;

import com.automation.pages.BaseClass;
import com.automation.pages.LoginPage;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;

public class LoginTestCase extends BaseClass {

    @Test
    public void loginApp(){
        logger = report.createTest("Login Page");

        LoginPage loginPage = PageFactory.initElements(driver, LoginPage.class);

        logger.info("Starting the application");

        loginPage.loginToSite(
                excel.getStringData("Login", 0, 0), excel.getStringData("Login", 0, 1));

        logger.pass("Login page loaded");
    }
}
