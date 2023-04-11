package com.cybertek.step_definitions;

import com.cybertek.pages.BasePage;
import com.cybertek.pages.ZeroBank;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;

import java.util.Locale;

public class ZeroBankLogInPage {
    ZeroBank zeroBank = new ZeroBank();
    BasePage basePage = new BasePage();

    @Given("User is on the login page")
    public void user_is_on_the_login_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("zeroUrl"));
        BrowserUtils.sleep(2);
        zeroBank.singInButton.click();

    }
    @Given("User logins with {string} and password {string}")
    public void user_logins_with_and_password(String args0, String args1) {
        zeroBank.landingOnAccountSummary(args0,args1);
    }
    @Then("The {string} page should be displayed")
    public void the_page_should_be_displayed(String pageName) {
      String currentTitle = Driver.getDriver().getTitle();
      String selectedTab = basePage.selectTab.getText();

      Assert.assertEquals("Page is not matching as expected",pageName,selectedTab);
      Assert.assertTrue("Title is not matching",currentTitle.toLowerCase().contains(pageName.toLowerCase(Locale.ROOT)));
    }

    @Then("Error message {string} should be displayed")
    public void error_message_should_be_displayed(String expectedError) {

      Assert.assertEquals("Error message does not match",expectedError,zeroBank.errorMessage.getText());

    }



    }



