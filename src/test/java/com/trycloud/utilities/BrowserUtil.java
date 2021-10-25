package com.trycloud.utilities;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class BrowserUtil {
    public static void waitFor(int seconds) {
        try {
            Thread.sleep(seconds*1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
    }

    public static boolean checkVisibilityOfElement(By locator,int seconds ) {
        boolean hasLocated = false;

        WebDriverWait wait = new WebDriverWait(com.trycloud.utilities.Driver.getDriver(), seconds);
        try {
            wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
            System.out.println("Element was found.");
            hasLocated = true;
        } catch (TimeoutException e) {
            System.out.println("No Such element was found!");
        }
        return hasLocated;
    }

    public static List<String> getAllText(List<WebElement> lstOfWebElements ){

        List<String> allTextLst = new ArrayList<>();
        for (WebElement eachElement : lstOfWebElements) {
            allTextLst.add(  eachElement.getText()  );
        }

        return  allTextLst ;

    }

    public static int randomNumber(int a, int b) {
        return new Faker().number().numberBetween(a, b);
    }
}
