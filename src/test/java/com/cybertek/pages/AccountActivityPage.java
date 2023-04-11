package com.cybertek.pages;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class AccountActivityPage {

    public AccountActivityPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }

    @FindBy(id = "aa_accountId")
    public WebElement showTransactionsAccount;

    @FindBy(xpath = "//thead/tr/th")
    public List<WebElement> accountColumnNames;


    public String selectedOption(){
        Select accountsDropDowns = new Select(showTransactionsAccount);
        return accountsDropDowns.getFirstSelectedOption().getText();

    }

    public List<WebElement> accountOptions(){
        Select accountsDropDowns = new Select(showTransactionsAccount);
        List<WebElement> options = accountsDropDowns.getOptions();
        return options;
    }

}
