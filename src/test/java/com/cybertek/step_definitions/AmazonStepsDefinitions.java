package com.cybertek.step_definitions;

import com.cybertek.pages.AmazonSearch;
import com.cybertek.utilities.Driver;
import com.cybertek.utilities.OfficeHoursUtils;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Set;

public class AmazonStepsDefinitions {

    AmazonSearch amazonSearch = new AmazonSearch();
    WebDriverWait wait = new WebDriverWait(Driver.getDriver(),10);
    double singlePriceForHat;
    Select select;

    @Given("User is on Amazon Home Page")
    public void user_is_on_amazon_home_page() {
        Driver.getDriver().get("https://www.amazon.com");
    }
    @When("User search for hats for man")
    public void user_search_for_hats_for_man() {
        amazonSearch.SearchForHats("hats for men");
    }
    @When("User adds the first  hat appearing to the cart with quantity two")
    public void user_adds_the_first_hat_appearing_to_the_cart_with_quantity_two() {

        wait.until(ExpectedConditions.elementToBeClickable(amazonSearch.firstHat)).click();
        select = new Select(amazonSearch.quantityItem);
        select.selectByVisibleText("2");
        amazonSearch.addToCart.click();
        String priceText = amazonSearch.price.getText();
        singlePriceForHat = OfficeHoursUtils.priceConverter(priceText);



    }
    @Then("The total price and quantity should be correct")
    public void the_total_price_and_quantity_should_be_correct() {
        amazonSearch.goToCart.click();




    }
    @When("User reduce the quantity from two to one")
    public void user_reduce_the_quantity_from_two_to_one() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }
    @Then("Total price and quantity has been correctly changed")
    public void total_price_and_quantity_has_been_correctly_changed() {
        // Write code here that turns the phrase above into concrete actions
        throw new io.cucumber.java.PendingException();
    }

}
