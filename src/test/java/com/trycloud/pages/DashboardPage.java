package com.trycloud.pages;

import com.trycloud.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class DashboardPage {
    @FindBy(xpath = "//ul[@id='appmenu']//span")
    public List<WebElement> allModules;

    public DashboardPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public void getModule(String moduleName) {
        Actions actions = new Actions(Driver.getDriver());
        String element = "//li[@tabindex]/a//span[normalize-space(.)='"+moduleName+"']";
        actions.moveToElement(Driver.getDriver().findElement(By.xpath(element))).click().perform();
    }

    public void moveToAndClickElement(String xPathName) {
        Actions actions = new Actions(Driver.getDriver());
        actions.moveToElement(Driver.getDriver().findElement(By.xpath(xPathName))).click().perform();
    }
    
    public void navigateToModule(String moduleName){

        Driver.getDriver().findElement(By.xpath("//ul[@id='appmenu']//span[normalize-space(.)='"+moduleName+"']/..")).click();
    }



}
