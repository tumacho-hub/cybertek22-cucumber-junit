package com.cybertek.step_definitions;

import com.cybertek.utilities.Driver;
import io.cucumber.java.*;
import io.cucumber.plugin.event.Node;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

public class Hooks {

    @Before
    public void setupScenario(){
        System.out.println("Setting browser with further details");
    }

    @After
    public void tearDownScenario(Scenario scenario){
       // scenario.isFailed();
        if (scenario.isFailed()){
            byte [] screenshot = ((TakesScreenshot)Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot,"image/png", scenario.getName());
        }  {

        }



        System.out.println("Tear-down steps are being applied");
        Driver.closeDriver();
    }
    @BeforeStep
    public void setupSteps(){
        System.out.println("");
    }

    @AfterStep
    public void afterStep(){
        System.out.println("Teardown applying for each step");
    }



}
