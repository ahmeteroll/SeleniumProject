package com.gittigidiyor.utilities;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BrowserUtility {
    public static void waitForPageToLoad(long timeOutWithSeconds){
        ExpectedCondition<Boolean> expectation = new ExpectedCondition<Boolean>() {

            public Boolean apply(WebDriver driver) {
                return ((JavascriptExecutor)driver).executeScript("return document.readyState").equals("complete");
            }
        };
        try {
            Thread.sleep(1000);
            WebDriverWait wait = new WebDriverWait(Driver.get(),timeOutWithSeconds);
            wait.until(expectation);
        }catch (Throwable error){
            error.printStackTrace();
        }
    }

    public static void waitForClickElement(WebElement element){
        WebDriverWait wait = new WebDriverWait(Driver.get(),90);
        wait.until(ExpectedConditions.elementToBeClickable(element));
    }
}
