
package com.trycloud.pages;

import com.github.javafaker.Faker;
import com.trycloud.utilities.Driver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class ContactsModulePage {

    // constructor

    public ContactsModulePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }

    //instances variables

    @FindBy(xpath = "//*[@id='appmenu']/li[6]")
    public WebElement contactsModule;

    @FindBy(xpath = "//*[@id='appmenu']/li[5]")
    public WebElement talksModule;

    @FindBy(xpath = "/html/head/title")
    public WebElement title;

    @FindBy(id = "new-contact-button")
    public WebElement newContactBtn;


    // fill out the form
    @FindBy(id = "contact-fullname")
    public WebElement fullNameBtn;

    @FindBy(xpath = "//input[@class='property__value'][1]")
    public WebElement phoneBtn;

    @FindBy(xpath = "//input[@class='property__value'][2]")
    public WebElement emailBtn;

    @FindBy(xpath = "//input[@class='property__value'][3]")
    public WebElement postOfficeBtn;

    @FindBy(xpath = "//input[@class='property__value'][4]")
    public WebElement addressBtn;

    @FindBy(xpath = "//input[@class='property__value'][5]")
    public WebElement extendedAdsBtn;

    @FindBy(xpath = "//input[@class='property__value'][6]")
    public WebElement postalCodeBtn;

    @FindBy(xpath = "//input[@class='property__value'][7]")
    public WebElement cityBtn;

    @FindBy(xpath = "//input[@class='property__value'][8]")
    public WebElement stateOrProvinceBtn;

    @FindBy(xpath = "//input[@class='property__value'][9]")
    public WebElement countryBtn;

    @FindBy(id = "#everyone")
    public List<WebElement> allContacts;


    // useful methods/actions

    public void getModule(String moduleName) {
        Actions actions = new Actions(Driver.getDriver());
        String element = "//li[@tabindex]/a//span[normalize-space(.)='"+moduleName+"']";
        actions.moveToElement(Driver.getDriver().findElement(By.xpath(element))).click().perform();
    }

    public void getModuleName(String moduleName) {
        Actions actions = new Actions(Driver.getDriver());
        String element = "//*[@id='appmenu']/li[6]";
        actions.moveToElement(Driver.getDriver().findElement(By.xpath(element))).click().perform();
    }


    public void fillOutContactInfo(){
        Faker faker = new Faker();

        fullNameBtn.sendKeys(faker.name().fullName());
        emailBtn.sendKeys(faker.name().firstName().concat("@").concat("gmail.com"));
        postOfficeBtn.sendKeys(faker.numerify("#####-###"));
        addressBtn.sendKeys(faker.address().streetAddress());
        extendedAdsBtn.sendKeys(faker.address().fullAddress());
        postalCodeBtn.sendKeys(faker.address().zipCode());
        cityBtn.sendKeys(faker.address().cityName());
        stateOrProvinceBtn.sendKeys(faker.address().state());
        countryBtn.sendKeys(faker.country().name());
        System.out.println("Contact information form is filled");

    }


    // create list of elements for each before/after adding the new contact into the list
    // assert that after adding a new contact the size.List()+1; is increased by one.


}