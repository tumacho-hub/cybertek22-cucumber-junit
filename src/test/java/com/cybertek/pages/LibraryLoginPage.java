package com.cybertek.pages;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LibraryLoginPage {

    public LibraryLoginPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//input[@id='inputEmail']")
    public WebElement emailAddressBox;

    @FindBy(xpath = "//input[@id='inputPassword']")
    public WebElement passwordBox;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement signInButton;

    // method below is dynamic and accepts two arguments with this method we are refactoring our code
    public void login(String username, String password){
        emailAddressBox.sendKeys(username);
        passwordBox.sendKeys(password);
        signInButton.click();

    }

}
