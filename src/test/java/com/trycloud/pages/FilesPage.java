package com.trycloud.pages;

import com.trycloud.utilities.BrowserUtil;
import com.trycloud.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class FilesPage {

    @FindBy(xpath = "//a[@data-action='Favorite']")
    public WebElement favoriteOption;

    @FindBy(xpath = "(//a[@class='action action-menu permanent'])[1]")
    public WebElement actionIcon;

    @FindBy(xpath = "//span[@class='innernametext']")
    public List<WebElement> itemNames;

    @FindBy(xpath = "//td[1]//span[@class='innernametext']")
    public List<WebElement> favoriteItems;

    @FindBy(xpath = "//li[@data-id='favorites']/a")
    public WebElement favoriteTab;

    @FindBy(css = "th[id='headerSelection'][class='column-selection']")
    //@FindBy(xpath = "(//th/input[@type='checkbox'])[1]")
    public WebElement selectAllBox;

    @FindBy(css = "[class='icon icon-starred']")
    public List<WebElement> allFaves;

    //Allows for Clicking
    @FindBy(xpath = "//tr/td[@class='selection']")
    public List<WebElement> allCheckboxes2;

    //Allow for isSelected MEthods
    @FindBy(xpath = "//tr/td[@class='selection']/input")
    public List<WebElement> allCheckboxes;

    //Comment element for files
    @FindBy(xpath = "//li/a[@id='commentsTabView']")
    public WebElement commentTab;

    //Comment message area
    @FindBy(xpath = "//div[@id='commentsTabView']/div/form/div[@class='message']")
    public WebElement commentMessage;

    //comment submit button
    @FindBy(xpath = "//div[@id='commentsTabView']/div/form/input[@type='submit']")
    public WebElement commentSubmit;

    //comment message check
    @FindBy(xpath = "//div/ul/li/div[@class='message']")
    public WebElement commentArea;

    //settings button locator on files module
    @FindBy(css = ".settings-button")
    public WebElement settingsButton;

    //check box elements
    @FindBy(xpath = "//div[@id='app-settings-content']//label[contains(.,'Show')]")
    public List<WebElement> checkBoxes;

    //storage WebElement
    @FindBy(id = "quota")
    public WebElement storageUsage;


    public FilesPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public void removeFaves() {
        if (allFaves.size() == 0) {
            return;
        }
        for (int i = 0; i < allFaves.size(); i++) {
            actionIcon.click();
            BrowserUtil.waitFor(1);
            DashboardPage dashboardPage = new DashboardPage();
            dashboardPage.moveToAndClickElement("//a[@data-action='Favorite']");
        }
    }


}
