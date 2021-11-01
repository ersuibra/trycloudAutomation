package com.trycloud.pages;

import com.trycloud.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class FolderFilePage {


    @FindBy(xpath = "(//div//li[starts-with(@class, ' action')])[6]")
    public WebElement DeleteTab;

    @FindBy(xpath = "//a[.='Deleted files']")
    public WebElement DeletedFilesTab;

    @FindBy(xpath = "//span[@class='nametext extra-data']/span[@class='innernametext']")
    public List<WebElement> deletedFilesList;





    public FolderFilePage(){
        PageFactory.initElements(Driver.getDriver(), this);
    }
}
