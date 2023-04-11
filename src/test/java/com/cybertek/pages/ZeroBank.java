package com.cybertek.pages;

import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

public class ZeroBank {

    public ZeroBank() {
        PageFactory.initElements(Driver.getDriver(), this);

    }

        @FindBy(id = "signin_button")
        public WebElement singInButton;

        @FindBy(id = "user_login")
        public WebElement loginBox;

        @FindBy(id = "user_password")
        public WebElement passwordBox;

        @FindBy(xpath = "//input[@class='btn btn-primary']")
        public WebElement signInBox;

        @FindBy(id = "account_activity_link")
        public WebElement checkingAccount;

        @FindBy(id = "account_summary_tab")
        public WebElement accountSummary;

        @FindBy(xpath = "//div[@class='alert alert-error']")
        public WebElement errorMessage;



        public void loginAgain(){
            Driver.getDriver().get("http://zero.webappsecurity.com/");
        }


        public void landingOnAccountSummary(String username, String password){
            loginBox.sendKeys("username");
            passwordBox.sendKeys("password");
            signInBox.click();

            loginAgain();
            BrowserUtils.sleep(2);
            checkingAccount.click();
            BrowserUtils.sleep(2);
            accountSummary.click();
        }


}
