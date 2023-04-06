package com.cybertek.pages;

import com.cybertek.utilities.ConfigurationReader;
import com.cybertek.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class AmazonSearch {

    Driver driver;

    public AmazonSearch() {
        PageFactory.initElements(Driver.getDriver(), this);

    }

    @FindBy(xpath = "//a[@class='nav-a  ']")
    public List<WebElement> tabs;

    @FindBy(xpath = "//input[@id='twotabsearchtextbox']")
    public WebElement searchButton;

    @FindBy(xpath = "//input[@id='nav-search-submit-button']")
    public WebElement searchClick;

    @FindBy(xpath = "//a[@id='nav-logo-sprites']")
    public WebElement amazonHome;

    @FindBy(xpath = "(//div[@class='a-section aok-relative s-image-tall-aspect'])[1]")
    public WebElement firstHat;

    @FindBy(xpath = "//select[@name='quantity']")
    public WebElement quantityItem;

    @FindBy(xpath = "//input[@id='add-to-cart-button']")
    public WebElement addToCart;

    @FindBy(xpath = "(//a[@class='a-button-text'])[3]")
    public WebElement goToCart;

    @FindBy(xpath = "//span[@id='sc-subtotal-label-buybox']")
    public WebElement subTotalQuantity;

    @FindBy(xpath = "(//span[@class='a-size-medium a-color-base sc-price sc-white-space-nowrap'])[2]")
    public WebElement price;



    public WebElement selectTab (String tabName){
        String locator = "(//a[.=\"" + tabName + "\"])"; //a[.="Customer Service"] + [2]
        return Driver.getDriver().findElement(By.xpath(locator));
    }

    public WebElement clickNow(String name){
        String newLocator = "(//a[.=\"Customer Service\"])[2]";
        return Driver.getDriver().findElement(By.xpath(newLocator));
    }

    public void SearchForHats(String nameOfItem){

        String searchAmazon = nameOfItem;
        searchButton.click();
        searchButton.sendKeys(searchAmazon);
        searchClick.click();


    }

    public void selectQuantity(String number){
        Select select = new Select(quantityItem);
        select.selectByVisibleText(number);
    }


}

