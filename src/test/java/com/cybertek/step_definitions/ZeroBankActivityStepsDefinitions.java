package com.cybertek.step_definitions;

import com.cybertek.pages.AccountSummaryPage;
import com.cybertek.utilities.BrowserUtils;
import io.cucumber.java.en.Then;
import org.junit.Assert;

import java.util.List;

public class ZeroBankActivityStepsDefinitions {
    AccountSummaryPage accountSummaryPage = new AccountSummaryPage();

    @Then("Account Summary page should have the following account types")
    public void account_summary_page_should_have_the_following_account_types(List<String> expectedAccount) {
        List<String> actualAccounts = BrowserUtils.getElementsText(accountSummaryPage.accountTypes);
        Assert.assertEquals(expectedAccount,actualAccounts);

    }
    @Then("Credit Accounts table must have these columns")
    public void credit_accounts_table_must_have_these_columns(List<String> expectedColumns) {
        List<String> actualColumns = BrowserUtils.getElementsText(accountSummaryPage.actualColumnNames);

        Assert.assertEquals(expectedColumns,actualColumns);
    }
}
