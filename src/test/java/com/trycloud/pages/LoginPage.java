package com.trycloud.pages;

import com.trycloud.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {
    @FindBy(xpath = "//input[@id='user']")
    public WebElement userName;

    @FindBy(xpath = "//input[@id='password']")
    public WebElement password;

    @FindBy(xpath = "//input[@id='submit-form']")
    public WebElement loginButton;

    @FindBy(xpath = "//p[@class='warning wrongPasswordMsg']")
    public WebElement errorMessage;

    @FindBy(xpath = "//div[@id='settings']")
    public WebElement userBox;

    @FindBy(xpath = "//li[normalize-space(.) ='Log out']")
    public WebElement logoutBox;

    public LoginPage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }


}
