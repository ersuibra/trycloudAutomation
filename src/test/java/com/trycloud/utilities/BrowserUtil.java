package com.trycloud.utilities;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class BrowserUtil {
    //Performs a pause
    public static void waitFor(int seconds) {
        try {
            Thread.sleep(seconds * 1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //Waits for element matching the locator to be visible on the page
    public static boolean checkVisibilityOfElement(By locator, int seconds) {

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
    // return a list of string from a list of elements

    public static List<String> getAllText(List<WebElement> lstOfWebElements) {

        List<String> allTextLst = new ArrayList<>();
        for (WebElement eachElement : lstOfWebElements) {
            allTextLst.add(eachElement.getText());
        }

        return allTextLst;

    }


    // Switches to new window by the exact title. Returns to original window if target title not found

    public static void switchToWindow(String targetTitle) {
        String origin = Driver.getDriver().getWindowHandle();
        for (String handle : Driver.getDriver().getWindowHandles()) {
            Driver.getDriver().switchTo().window(handle);
            if (Driver.getDriver().getTitle().equals(targetTitle)) {
                return;
            }
        }
        Driver.getDriver().switchTo().window(origin);
    }

    //Scrolls down to an element using JavaScript
    public static void scrollToElement(WebElement element) {
        ((JavascriptExecutor) Driver.getDriver()).executeScript("arguments[0].scrollIntoView(true);", element);
    }

    //Given Select element, Selects with visibleText
    public static void selectByVisibleText(WebElement elementDropdown, String visibleText) {
        Select dropdown = new Select(elementDropdown);
        dropdown.selectByVisibleText(visibleText);

    }

    //Checks element is displayed
    public static boolean elementIsDisplayed(List<WebElement> elements) {

        for (WebElement element : elements) {
            if (!element.isDisplayed()) {
                System.err.println(element.getText() + " is not displayed");
                return false;
            }
        }
        return true;
    }

    //returns random number between a to b (Used for any element situations)
    public static int randomNumber(int a, int b) {
        return new Faker().number().numberBetween(a, b);
    }

    //checks if all elements are checked
    public static boolean getIsCheck(List<WebElement> allCheckboxes) {
        boolean flag = true;
        for (WebElement checkbox : allCheckboxes) {
            if (!checkbox.isSelected()) {
                flag = false;
                break;
            }
        }
        return flag;
    }

    //checks if all elements are checked on Multiple Pages
    public static boolean getIsCheckMultiplePage(List<WebElement> allCheckboxes, WebElement nextButton) {

        boolean flag = true;

        String str = "";

        do {

            str = Driver.getDriver().getCurrentUrl();


            for (WebElement checkbox : allCheckboxes) {
                if (!checkbox.isSelected()) {
                    flag = false;
                    break;
                }
            }


            nextButton.click();
            BrowserUtil.waitFor(2);

        } while (!Driver.getDriver().getCurrentUrl().equals(str));

        return flag;
    }

}
