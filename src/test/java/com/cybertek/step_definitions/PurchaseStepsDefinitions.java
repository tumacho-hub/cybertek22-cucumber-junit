package com.cybertek.step_definitions;

import com.cybertek.pages.AdidasPage;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class PurchaseStepsDefinitions {

    AdidasPage adidasPage = new AdidasPage();
    int expectedPurchaseAmount = 0;


    @Given("User is on the home page")
    public void user_is_on_the_home_page() {
        Driver.getDriver().get(ConfigurationReader.getProperty("blaze"));

    }

    @When("User adds {string} from {string}")
    public void user_adds_from(String product, String category) {
        expectedPurchaseAmount += adidasPage.productAdder(category, product);
        System.out.println("expectedPurchaseAmount = " + expectedPurchaseAmount);
    }

    @When("User removes {string} from cart")
    public void user_removes_from_cart(String product) {
       expectedPurchaseAmount -= adidasPage.productRemover(product);
        System.out.println("expectedPurchaseAmount = " + expectedPurchaseAmount);


    }

    @When("User place order and capture logs purchase ID and Amount")
    public void user_place_order_and_capture_logs_purchase_id_and_amount() {
       adidasPage.cart.click();
       adidasPage.placeOrderButton.click();
       adidasPage.fillForm();
    }
    @Then("User verifies purchase amount equals expected")
    public void user_verifies_purchase_amount_equals_expected() {

        Assert.assertTrue(adidasPage.confirmationID().contains("Id:"));
        Assert.assertEquals(adidasPage.confirmationAmount(),700);





    }

}



