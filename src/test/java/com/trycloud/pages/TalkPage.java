package com.trycloud.pages;

import com.trycloud.utilities.BrowserUtil;
import com.trycloud.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class TalkPage {
    public TalkPage() {
        PageFactory.initElements(Driver.getDriver(), this);

    }

    @FindBy(css = ".app-navigation-search__input")
    public WebElement conversationBox;

    @FindBy(xpath = "//a[@id='commentsTabView']")
    public WebElement commentTab;

    @FindBy(xpath = "//div[@class='acli__content']")
    public List<WebElement> allUsers;

    @FindBy(xpath = "//button[@type='submit']")
    public WebElement submitButton;

    @FindBy(xpath = "//div[@role='textbox']")
    public WebElement messageBox;

    @FindBy(xpath = "(//span[contains(.,\"Today\")]/../..//div[@class='message__main__text'])")
    public List<WebElement> allMessages;

    @FindBy(xpath = "//*[@id='message_3427']/div/div[1]/div")
    public WebElement messageDisplay;

    public void navigateToModule(String moduleName){

        Driver.getDriver().findElement(By.xpath("//ul[@id='appmenu']//span[normalize-space(.)='"+moduleName+"']/..")).click();
    }

    public String checkMessage(int allMessages) {
        BrowserUtil.waitFor(3);
        return  Driver.getDriver().findElement(By.xpath("(//span[contains(.,'Today')]/../..//div[@class='message__main__text'])["+allMessages+"]")).getText();
    }
}
