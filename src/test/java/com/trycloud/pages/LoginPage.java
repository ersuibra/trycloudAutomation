package com.trycloud.pages;

import com.trycloud.utilities.ConfigReader;
import com.trycloud.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    @FindBy(id = "user")
    public WebElement usernameBox;

    @FindBy(id = "password")
    public WebElement passwordBox;

    @FindBy(id = "submit-form")
    public WebElement loginButton;

    @FindBy(xpath = "//p[@class='warning wrongPasswordMsg']")
    public WebElement warningMessage;

    @FindBy(xpath = "//div[@id='settings']")
    public WebElement userBox;

    @FindBy(xpath = "//li[normalize-space(.) ='Log out']")
    public WebElement logoutBox;

    public LoginPage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }


    public void goTo() {
        Driver.getDriver().navigate().to(ConfigReader.read("url"));
    }

    public void login() {
        usernameBox.sendKeys(ConfigReader.read("user1"));
        passwordBox.sendKeys(ConfigReader.read("password"));
        loginButton.click();
    }

    public void login(String username, String password) {

        usernameBox.sendKeys(username);
        passwordBox.sendKeys(password);
        loginButton.click();
    }

}
