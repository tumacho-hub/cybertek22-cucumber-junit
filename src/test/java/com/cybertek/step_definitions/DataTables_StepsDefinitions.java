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

public class DataTables_StepsDefinitions {

LibraryLoginPage libraryLoginPage = new LibraryLoginPage();
DropDownPage dropDownPage = new DropDownPage();



    @Given("User is on the dropdowns page of practice tool")
    public void user_is_on_the_dropdowns_page_of_practice_tool() {
        Driver.getDriver().get("http://practice.cybertekschool.com/dropdown");


    }

    @Then("User should see below info in month dropdown")
  //  public void user_should_see_below_info_in_month_dropdown(io.cucumber.datatable.DataTable dataTable) {
    public void user_should_see_below_info_in_month_dropdown(List<String> expectedList) {
        // 1. get the dropdown as a select object
        Select monthDropdown = new Select(dropDownPage.month);

        //2. Get all the options from the dropdown and store inside of a list
        List<WebElement> actualMonthsAsWebElement = monthDropdown.getOptions();

        Assert.assertEquals(expectedList, BrowserUtils.getElementsText(actualMonthsAsWebElement));


    }











    @Given("user is on the login page of library app")
    public void user_is_on_the_login_page_of_library_app() {
       String url = ConfigurationReader.getProperty("libraryUrl");
       Driver.getDriver().get(url);
    }

    @When("user enter username and password as below")
    public void user_enter_username_and_password_as_below(Map<String , String> loginInfo) {
        // Write code here that turns the phrase above into concrete actions
        // For automatic transformation, change DataTable to one of
        // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
        // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
        // Double, Byte, Short, Long, BigInteger or BigDecimal.
        //
        // For other transformations you can register a DataTableType.
        String username = loginInfo.get("username");

        libraryLoginPage.emailInput.sendKeys(username);
        libraryLoginPage.passwordInput.sendKeys(loginInfo.get("password"));
        libraryLoginPage.signIn.click();


    }
    @Then("user should see title is something")
    public void user_should_see_title_is_something() { //
        System.out.println("Title verification");

    }
        @Then("user should see below words displayed")
        public void user_should_see_below_words_displayed (List < String > listOfFruits) {
            //public void user_should_see_below_words_displayed(io.cucumber.datatable.DataTable dataTable) {
            // Write code here that turns the phrase above into concrete actions
            // For automatic transformation, change DataTable to one of
            // E, List<E>, List<List<E>>, List<Map<K,V>>, Map<K,V> or
            // Map<K, List<V>>. E,K,V must be a String, Integer, Float,
            // Double, Byte, Short, Long, BigInteger or BigDecimal.
            //
            // For other transformations you can register a DataTableType.
            // throw new io.cucumber.java.PendingException();

            System.out.println("listOfFruits = " + listOfFruits);
            System.out.println("listOfFruits.size() = " + listOfFruits.size());


        }


    @Then("user should see title is Library")
    public void userShouldSeeTitleIsLibrary() {
        String actualTitle = Driver.getDriver().getTitle();
        String expectedTitle = "Library";
    }
}


