package com.cybertek.step_definitions;

import com.cybertek.pages.DropDownPage;
import com.cybertek.pages.LibraryLoginPage;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class DataTableStepsDefinitions {
    DropDownPage dropDownPage = new DropDownPage();

    @Given("User is on the dropdowns page of practice tool")
    public void user_is_on_the_dropdowns_page_of_practice_tool() {
        Driver.getDriver().get("http://practice.cybertekschool.com/dropdown");
    }
    @Then("User should see below info in month dropdown")
    public void user_should_see_below_info_in_month_dropdown(List<String> expectedList) {
        /*
        for this example we needed to create new implementation in our BrowserUtils Package
        for future re-usability revise the BrowserUtils package
         */
        //1- Get the dropdown as SELECT OBJECT
        Select monthDropDown = new Select(dropDownPage.month);


       //2- Get all the options from the dropdown and store inside a list
        List<WebElement> monthDropDownOptions = monthDropDown.getOptions();


        Assert.assertEquals(expectedList, BrowserUtils.getElementsText(monthDropDownOptions));
//        //3- Convert from List<WebElement> to List<String>
//        List<String> actualMonthAsString = new ArrayList<>();
//        for (WebElement eachMonthDropDownOption : monthDropDownOptions) {
//            actualMonthAsString.add(eachMonthDropDownOption.getText());
//        }
//        Assert.assertEquals(expectedList,actualMonthAsString);





    }











    @Then("user should see below words displayed")
    public void user_should_see_below_words_displayed(List<String> listOfFruits) {
        System.out.println("listOfFruits.size() = " + listOfFruits.size());
        System.out.println("listOfFruits = " + listOfFruits);


    }

    @Given("user is on the login page library app")
    public void user_is_on_the_login_page_library_app() {
        String url = ConfigurationReader.getProperty("libraryUrl");
        Driver.getDriver().get(url);

    }
    LibraryLoginPage libraryLoginPage = new LibraryLoginPage();

    //below line has on example with MAP!
    @When("user enter username and password as below")
    public void user_enter_username_and_password_as_below(Map<String, String> loginInfo) {

        libraryLoginPage.emailAddressBox.sendKeys(loginInfo.get("username"));
        libraryLoginPage.passwordBox.sendKeys(loginInfo.get("password"));
        libraryLoginPage.signInButton.click();

    }
    @Then("user should see title is something")
    public void user_should_see_title_is_something() {
        System.out.println("title verification");;
    }


    @Then("user should see title is Library")
    public void userShouldSeeTitleIsLibrary() {
      String actualTitle =  Driver.getDriver().getTitle();
      String expectedTitle = "Login - Library";

        Assert.assertEquals(expectedTitle,actualTitle);

    }
}
