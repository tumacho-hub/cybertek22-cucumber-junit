package com.cybertek.step_definitions;

import com.cybertek.pages.AccountActivityPage;
import com.cybertek.pages.BasePage;
import com.cybertek.utilities.BrowserUtils;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import javax.sql.rowset.BaseRowSet;
import java.util.List;

public class ZeroBankAccountActivityStepsPage {
    BasePage basePage = new BasePage();
    AccountActivityPage accountActivityPage = new AccountActivityPage();

    @Given("The user navigates to {string} menu")
    public void the_user_navigates_to_menu(String tab) {
        basePage.getTab(tab);

    }
    @And("Account drop down should have {string} selected")
    public void account_drop_down_should_have_selected(String expectedAccount) {
        Assert.assertEquals(expectedAccount,accountActivityPage.selectedOption());

    }
    @Then("Account drop down should have the following options")
    public void account_drop_down_should_have_the_following_options(List<String> expectedOptions) {
        List<String> actualOptions = BrowserUtils.getElementsText(accountActivityPage.accountOptions());
        Assert.assertEquals(expectedOptions,actualOptions);

    }
    @Then("Transaction table should have column names")
    public void transaction_table_should_have_column_names(List<String> expectedColumns) {
        List<String> actualColumns = BrowserUtils.getElementsText(accountActivityPage.accountColumnNames);
        Assert.assertEquals(expectedColumns,actualColumns);


    }

}
