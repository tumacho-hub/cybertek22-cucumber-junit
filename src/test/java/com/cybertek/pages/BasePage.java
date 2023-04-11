package com.cybertek.pages;

import com.cybertek.utilities.BrowserUtils;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class BasePage {
    public BasePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }
    @FindBy(className = "active")
    public WebElement selectTab;


    public void getTab(String menu){
        String menuLocator = "//a[.='" + menu + "']";
        Driver.getDriver().findElement(By.xpath(menuLocator)).click();
        BrowserUtils.sleep(1);
    }
}
