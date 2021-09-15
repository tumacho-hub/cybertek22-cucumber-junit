package com.cybertek.pages;

import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import sun.awt.ConstrainableGraphics;

public class LibraryLoginPage {
    public LibraryLoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);

    }

    @FindBy(id = "inputEmail")
    public WebElement emailInput;
    @FindBy(id = "inputPassword")
    public WebElement passwordInput;
    @FindBy(xpath = "//button[.='Sign in']")
    public WebElement signIn;
/*
Login
 */
    public void login() {
        emailInput.sendKeys("username");
        passwordInput.sendKeys("password");
        signIn.click();
    }

    public void loginWithAdmin() {
        emailInput.sendKeys("admin");
        passwordInput.sendKeys("password");
        signIn.click();
    }

/*
Login method controlled from configuration.properties
 */
    public void loginWithConfiguration() {
        emailInput.sendKeys(ConfigurationReader.getProperty("username"));
        passwordInput.sendKeys(ConfigurationReader.getProperty("password"));
        signIn.click();
    }
    /*
    This method accepts arguments directly from the method
     */

    public void login(String username, String password){
        emailInput.sendKeys(username);
        passwordInput.sendKeys(password);
        signIn.click();
    }
}
