package com.cybertek.step_definitions;

import com.cybertek.utilities.Driver;
import io.cucumber.java.*;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {
    //import from io.cucumber.java
    @Before
    public void setupScenario(){
    System.out.println("--Setting up browser with further details");
    }

    @After
    public void tearDownScenario(Scenario scenario){
        // if my scenario fails take a screen shoot

         //scenario.isFailed();--> if scenario fails it returns true
        if (scenario.isFailed()) {
            // command to take an screen shoot make sure to downcast to get the screen shoot code line
            byte[] screenShot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenShot, "image/png", scenario.getName());
        }
        System.out.println("--Teardown steps are being applied");
       // Driver.closeDriver();

    }
    @BeforeStep
    public void setupStep(){
        System.out.println("---setup applying for each step");
    }
    @AfterStep
    public void afterStep(){
    System.out.println("---Teardown applying for each step");
}
}