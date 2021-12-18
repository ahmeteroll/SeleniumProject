package com.gittigidiyor.step_definitions;

import com.gittigidiyor.utilities.Driver;
import io.cucumber.java.Scenario;
import org.apache.log4j.PropertyConfigurator;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.util.concurrent.TimeUnit;

public class Hooks {

    @Before
    public void beforeTest(){
        PropertyConfigurator.configure("src/test/resources/log4j2.properties");
        Driver.get().manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
    };

    @After
    public void afterTest(Scenario scenario){
        if(scenario.isFailed()){
            final byte[] screenshot = ((TakesScreenshot) Driver.get()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot,"image/png", "screenshot");
        }
        Driver.closeDriver();
    }
}
