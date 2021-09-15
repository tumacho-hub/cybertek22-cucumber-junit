package com.cybertek.pages;

import com.cybertek.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class EtsySearchPage {

    public EtsySearchPage(){ // constructor
        PageFactory.initElements(Driver.getDriver(),this);

    }
    // below we are creating our locators
@FindBy(id = "global-enhancements-search-query")
    public WebElement searchbar;

    @FindBy(xpath = "//button[@value='Search']")
    public WebElement searchButton;


}
