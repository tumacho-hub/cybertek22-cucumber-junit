package com.cybertek.utilities;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.util.concurrent.TimeUnit;

public class Driver {
    private Driver(){
    }
    private static ThreadLocal<WebDriver> driverPool = new ThreadLocal<>();

    private static WebDriver driver;
    // creating re-usable utility method that will return same driver instance everytime we call it.
    public static WebDriver getDriver() {
        if (driverPool.get() == null) {

            synchronized (Driver.class) {


// we read our browser type from configuration.properties file using
// .getProperty method we creating in configurationReader class.
                String browserType = ConfigurationReader.getProperty("browser");
// depending on the browser type our switch statement will determine to open specific type of browser/driver
                switch (browserType) {
                    case "chrome":
                        WebDriverManager.chromedriver().setup();
                        driverPool.set(new ChromeDriver());
                        driverPool.get().manage().window().maximize();
                        driverPool.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                        break;
                    case "firefox":
                        WebDriverManager.firefoxdriver().setup();
                        driverPool.set(new FirefoxDriver());
                        driverPool.get().manage().window().maximize();
                        driverPool.get().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
                        break;
                }
            }

        }
        // same driver instance will be returned every time we call driver.getDriver(); method
        return driverPool.get();


    }
    /*
    this method make sure we have some form of driver session or driver id has.
    Either null or not null it must exist.
     */
    public static void closeDriver(){
        if (driverPool.get()!=null){
            driverPool.get().quit();
            driverPool.remove();
        }
    }
}


