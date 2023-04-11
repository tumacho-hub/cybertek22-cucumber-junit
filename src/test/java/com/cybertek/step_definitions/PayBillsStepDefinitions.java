package com.cybertek.step_definitions;

import com.cybertek.pages.PayBillsPage;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.eo.Se;
import org.junit.Assert;
import org.openqa.selenium.support.ui.Select;

import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Random;

public class PayBillsStepDefinitions {

    Random random = new Random();
    PayBillsPage payBillsPage = new PayBillsPage();
    @When("Learn Date and DateFormat")
    public void learnDateAndDateFormat() {

        DateFormat dateFormat = new SimpleDateFormat("yy-MM-dd");
        DateFormat dateFormat1 = new SimpleDateFormat("yy-MM-dd hh:mm:ss");
        Date date = new Date();

        System.out.println(dateFormat.format(date));
    }

    @When("user completes a successful Pay operation")
    public void userCompletesASuccessfulPayOperation() {
        Select payeeOptions = new Select(payBillsPage.payeeOptions);
        int rand = random.nextInt(payeeOptions.getOptions().size());
        payeeOptions.selectByIndex(rand);

        Select accountOptions = new Select(payBillsPage.accountOptions);
        int rand2 = random.nextInt(accountOptions.getOptions().size());
        accountOptions.selectByIndex(rand2);

        int ammountRandom = random.nextInt(10000);
        payBillsPage.amountInput.sendKeys(ammountRandom + "");

        DateFormat dateFormat = new SimpleDateFormat("yy-MM-dd");
        Date date = new Date();
        payBillsPage.dateInput.sendKeys(dateFormat.format(date));
        payBillsPage.descriptionInput.sendKeys("asta la vista");
        payBillsPage.payButton.click();



    }


    @Then("{string} alert should be displayed")
    public void alertShouldBeDisplayed(String expectedMessage) {
        if (expectedMessage.contains("success")){
            Assert.assertTrue("Alert box is not displayed",payBillsPage.alertMessageBox.isDisplayed());
            String actualMessage = payBillsPage.alertMessageBox.getText();
            Assert.assertEquals(expectedMessage,actualMessage);
        }else{
            if (payBillsPage.amountInput.getAttribute("value").isEmpty()){
                String actualMessage = payBillsPage.amountInput.getAttribute("validationMessage");
                Assert.assertEquals(expectedMessage,actualMessage);
            }else{
                String actualMessage = payBillsPage.dateInput.getAttribute("validationMessage");
                Assert.assertEquals(expectedMessage,actualMessage);
            }
        }

    }

    @When("User tries to make a payment without entering the amount or date")
    public void userTriesToMakeAPaymentWithoutEnteringTheAmountOrDate() {

        int dateOrAmount = random.nextInt(2) + 1;
        Select payeeOptions = new Select(payBillsPage.payeeOptions);
        int rand = random.nextInt(payeeOptions.getOptions().size());
        payeeOptions.selectByIndex(rand);

        Select accountOptions = new Select(payBillsPage.accountOptions);
        int rand2 = random.nextInt(accountOptions.getOptions().size());
        accountOptions.selectByIndex(rand2);

        if (dateOrAmount==1){
            int amountRandom = random.nextInt(10000);
            payBillsPage.amountInput.sendKeys(amountRandom + "");
        }else{
            DateFormat dateFormat = new SimpleDateFormat("yy-MM-dd");
            Date date = new Date();
            payBillsPage.dateInput.sendKeys(dateFormat.format(date));
        }
        payBillsPage.descriptionInput.sendKeys("enjoy");
        payBillsPage.payButton.click();


    }
}
