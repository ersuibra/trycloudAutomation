package com.trycloud.pages;

import com.trycloud.utilities.Driver;
import org.junit.Before;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FolderModificationsPage {
    //@FindBy(xpath = "//input[@id='user']")
    @FindBy(xpath = "(//li[@data-id=\"files\"])[1]")
    public WebElement FilesMod;

    @FindBy(xpath = "//span[@class='icon icon-add']")
    public WebElement PlusIcon;

    @FindBy(xpath = "//a[@data-templatename='New folder']")
    public WebElement NewFolder;

    @FindBy(xpath = "//input[@id='view13-input-folder']")
    public WebElement FolderNameBox;

    @FindBy(xpath = "(//input[@type='submit'])[2]")
    public WebElement Submit;

    //AC2
    @FindBy(xpath ="//span[.='Upload file']")
    public WebElement UploadFileBtn;

    @FindBy(css = "#file_upload_start")
    public WebElement uploadFileHidden;

    @FindBy(xpath ="//td[@class='selection']") //uploaded file attribute
    public WebElement AllCheckBoxes;

    @FindBy(xpath ="//span[.='Selenium_methods']") //uploaded file attribute
    public WebElement UploadedFile;

    @FindBy(xpath = "(//span[@class='innernametext'])[1]")
    public WebElement VerifyUpload;

    public FolderModificationsPage(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
}
