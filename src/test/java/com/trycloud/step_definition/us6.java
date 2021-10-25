package com.trycloud.step_definition;

import com.github.javafaker.Faker;
import com.trycloud.pages.US6Page;
import com.trycloud.utilities.BrowserUtil;
import com.trycloud.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class us6 {

    //us1
    US6Page us6Page = new US6Page();
    Faker faker = new Faker();
    //String NewlyAddedFile = "Java6";
    String NewlyAddedFile = faker.funnyName().name();    //file().fileName();


    @When("click {string} module") //
    public void clickModule(String Files) {
        us6Page.FilesMod.click();
        BrowserUtil.waitFor(3);

    }

    @When("click “New Folder”")
    public void click_new_folder() {
        us6Page.NewFolder.click();

    }

    @When("write a folder name")
    public void write_a_folder_name() {

        us6Page.FolderNameBox.sendKeys(NewlyAddedFile);

    }

    @When("click submit icon")
    public void click_submit_icon() {
        us6Page.FolderNameBox.submit();
        BrowserUtil.waitFor(3);

    }

    @Then("verify the folder is displayed on the page")
    public void verify_the_folder_is_displayed_on_the_page() {

         List<WebElement> allFiles = Driver.getDriver().findElements(By.xpath("//tbody[@id=\"fileList\"]/tr"));
       // int sizeAfter = allFiles.size();
       // Assert.assertEquals(sizeAfter,sizeBefore);
        for (WebElement eachFile : allFiles) {
            String fileName = eachFile.getAttribute("data-file");
            //System.out.println("fileName = " + fileName);
            if (fileName.equals(NewlyAddedFile)) {
                System.out.println("New file " + "'" + NewlyAddedFile + "'" + "is added  ");
                break;
            }

        }

    }


//scenario2 steps

    @And("click {string} And upload a file")
    public void clickUploadFileAndUploadAFile() {

        String FilePath = "/Users/mm/Desktop/Smoke_testing.pdf";
        us6Page.UploadFileBtn.sendKeys(FilePath); //file upload is failing

    }


}
