package com.trycloud.pages;

import com.trycloud.utilities.Driver;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;

import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class FavoritesPage {

    //instance variables


    @FindBy(xpath = "(//span[normalize-space(.)='Files'])[1]")
    public WebElement filesModule;

    @FindBy(xpath = "//a[.='Favorites']")
    public WebElement favoritesTab;




    @FindBy(xpath = "//td[@class=\"filename\"]")
    public List<WebElement> favoritesFiles;

    @FindBy(xpath = "(//td[@class=\"filename\"])[1]//a[@class=\"action action-menu permanent\"]")
    public WebElement selectFirstFile;

    @FindBy(xpath = "//span[.='Remove from favorites']")
    public WebElement removeFromFavoritesBtn;


    //constructor
    public FavoritesPage() {
        PageFactory.initElements(Driver.getDriver(), this);

    }

    //methods
    //logic I created list of Web Elemnt for the Favorites list,
    //to assert 1 file is removed i will use list.size-1


    public int sizeOfFavListBeforeRemove() {

        return favoritesFiles.size();

    }

    public int sizeOfFavListAfterRemove() {

        return favoritesFiles.size() - 1;

    }
    //Assert.assertTrue(sizeOfFavListBeforeRemove()-1,sizeOfFavListAfterRemove() )


    LoginPage loginPage = new LoginPage();

    public void login(String user, String pass) {


        loginPage.usernameBox.sendKeys(user);
        loginPage.passwordBox.sendKeys(pass);
        loginPage.loginButton.click();

    }

    public void getModule(String moduleName) {
        Actions actions = new Actions(Driver.getDriver());
        String element = "//li[@tabindex]/a//span[normalize-space(.)='" + moduleName + "']";
        actions.moveToElement(Driver.getDriver().findElement(By.xpath(element))).click().perform();
    }

    public void clickToModule(String moduleName) {

        Driver.getDriver().findElement(By.xpath("//ul[@id='appmenu']//span[normalize-space(.)='" + moduleName + "']/..")).click();
    }


}
