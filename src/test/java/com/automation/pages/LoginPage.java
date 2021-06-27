package com.automation.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

    WebDriver driver;

    public LoginPage(WebDriver lDriver){
        this.driver = lDriver;
    }

    @FindBy(name = "email") WebElement user;
    @FindBy(name = "password") WebElement pwd;

    public void loginToSite(String userName, String password){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
        }
        user.sendKeys(userName);
        pwd.sendKeys(password);
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
        }
    }
}
