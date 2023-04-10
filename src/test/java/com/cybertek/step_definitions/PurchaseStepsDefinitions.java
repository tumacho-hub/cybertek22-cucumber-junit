package com.cybertek.step_definitions;

import com.cybertek.pages.AdidasPage;
import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import io.cucumber.java.bs.A;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;

import java.util.List;

public class PurchaseStepsDefinitions {

    AdidasPage adidasPage = new AdidasPage();
    int expectedPurchaseAmount = 0;
    int listPrice;
    int addingPrice;
    int cartPrice;


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

        adidasPage.confirmationID();
        adidasPage.confirmationAmount();


    }

    @Then("Under {string} category user should see the list of products")
    public void under_category_user_should_see_the_list_of_products(String category, List<String> expectedProducts) {

        Driver.getDriver().findElement(By.xpath(("//a[.='" + category + "']"))).click();
        BrowserUtils.sleep(2);
        List<String> actualProducts = BrowserUtils.getElementsTexts(adidasPage.products);

        System.out.println("actualProducts = " + actualProducts);
        System.out.println("expectedProducts = " + expectedProducts);

        Assert.assertEquals("Verifying list of products failed", expectedProducts, actualProducts);


    }

    @When("User adds {string} from {string} tp see price")
    public void user_adds_from_tp_see_price(String products, String category) {
        String locator = "//a[.='" + products + "']/../../h5";
        listPrice = Integer.parseInt(Driver.getDriver().findElement(By.xpath(locator)).getText().substring(1));
        addingPrice = adidasPage.productAdder(category,products);

    }
    @And("User removes {string} from cart to verify the price")
    public void user_removes_from_cart_to_verify_the_price(String products) {
        cartPrice = adidasPage.productRemover(products);

    }
    @Then("User verifies list and cart price are same and they are equal to {string}")
    public void user_verifies_list_and_cart_price_are_same_and_they_are_equal_to(String priceString) {
        int expectedPrice = Integer.parseInt(priceString);
        Assert.assertEquals(expectedPrice,listPrice);
        Assert.assertEquals(addingPrice,cartPrice);

    }
}



