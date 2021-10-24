package com.trycloud.pages;

import com.trycloud.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.FindBys;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class FilesModulePage {

    public FilesModulePage() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    @FindBy(xpath = "//*[@id='appmenu']/li[2]/a")    // (//ul/li/a[@class='active'])[1]         (//ul/li[@data-id='files'])[1]
    public WebElement files;

    @FindBy(css = "#headerSelection > label")     //   id = "select_all_files"   //
    public WebElement topLeftCheckBox;

    @FindBy(xpath = "//td[@class='selection']/input")     //      //td/input[@type='checkbox']     td/input[@class='selectCheckBox checkbox']
    public List<WebElement> allCheckBoxes;            //td[@class='selection']

    @FindBy(xpath = "(//td/label/span[@class='hidden-visually'])[5]")
    public WebElement oneCheckBox;

    public boolean checkAllBoxVerify(List<WebElement> allBoxes){
        for (WebElement eachBox : allBoxes) {
            if(!eachBox.isSelected()){
                return false;
            }
        }
        return true;
    }


}
