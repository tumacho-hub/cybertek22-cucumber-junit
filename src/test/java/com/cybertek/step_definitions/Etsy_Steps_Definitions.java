package com.cybertek.step_definitions;

import com.cybertek.pages.EtsySearchPage;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class Etsy_Steps_Definitions {

    @Given("user is on the etsy landing page")
    public void user_is_on_the_etsy_landing_page() {
        String url = ConfigurationReader.getProperty("etsyUrl");
        Driver.getDriver().get(url);

    }
    @Then("user should see etsy title as expected")
    public void user_should_see_etsy_title_as_expected() {

        String expectedTitle = "Etsy - Shop for handmade, vintage, custom, and unique gifts for everyone";
        String actualTitle = Driver.getDriver().getTitle();

        Assert.assertTrue("Title is not as expected", actualTitle.equals(expectedTitle));


    }
        EtsySearchPage etsySearchPage = new EtsySearchPage();

    @When("user types Wooden Spoon in the search bar")
    public void user_types_wooden_spoon_in_the_search_bar() {
       etsySearchPage.searchBar.sendKeys("Wooden Spoon");

    }
    @When("user clicks to search button")
    public void user_clicks_to_search_button() {
        etsySearchPage.searchButton.click();

    }
    @Then("user sees title Wooden spoon | Etsy")
    public void user_sees_title_wooden_spoon_etsy() {
        String expectedTitle = "Wooden spoon - Etsy";
        String actualTitle = Driver.getDriver().getTitle();

        Assert.assertEquals("Title is not as ex pected!", actualTitle,expectedTitle);

    }



}
