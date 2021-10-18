package com.trycloud.step_definition;

import com.trycloud.utilities.Driver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.util.concurrent.TimeUnit;

public class Hooks {


    @Before("@ui")
    public void setupDriver(){
        //setupImplicit Wait
        Driver.getDriver().manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        Driver.getDriver().manage().window().maximize();

    }

    @After("@ui")
    public void tearDown(Scenario scenario){
        // check if scenario failed or not
        if(scenario.isFailed() ){
            // this is how we take screenshot in selenium
            TakesScreenshot ts = (TakesScreenshot) Driver.getDriver();
            byte[] screenshot = ts.getScreenshotAs(OutputType.BYTES);

            scenario.attach(screenshot, "image/png",scenario.getName());

        }

        Driver.closeDriver();

    }
}
