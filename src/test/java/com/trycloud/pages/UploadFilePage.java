package com.trycloud.pages;


import com.github.javafaker.Faker;

import com.trycloud.utilities.BrowserUtil;
import com.trycloud.utilities.Driver;
import org.openqa.selenium.WebElement;


import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class UploadFilePage {


    //instance variables
    @FindBy(css = ".button.new")
    public WebElement addIcon;
    public String pathName="C:\\Users\\Canada\\Desktop\\Mevlam neyler neylerse guzel eyler\\HTML Projects\\trycloudAutomation\\src\\test\\resources\\files\\us_0"+BrowserUtil.randomNumber(1,9)+".png";


    @FindBy(xpath = "//input[@type='file']")
    //to be able to send keys tag nedd to be input and type attribute value needds to be "file"
    // in this website upload web elemt was hidden so in the source code i searched for:  //input[@type='file']
    public WebElement uploadOption;


    @FindBy(css = ".button.new")
    public List<WebElement> totalNumberOfFilesanFolders;






    //constructor

    public UploadFilePage(){

        PageFactory.initElements(Driver.getDriver(),this);
    }

    //actions usefull methods














}
