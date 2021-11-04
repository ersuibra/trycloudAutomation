package com.trycloud.step_definition;

import com.github.javafaker.Faker;
import com.trycloud.pages.FolderModificationsPage;
import com.trycloud.utilities.BrowserUtil;
import com.trycloud.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;


public class Us6_FolderStepDefs {

    //us1
    FolderModificationsPage folderModificationsPage = new FolderModificationsPage();
    Faker faker = new Faker();
    //String NewlyAddedFile = "Java6";
    String NewlyAddedFile = faker.funnyName().name();    //file().fileName();


    @When("click {string} module") //
    public void clickModule(String Files) {
        folderModificationsPage.FilesMod.click();
        BrowserUtil.waitFor(3);

    }

    @When("click “New Folder”")
    public void click_new_folder() {
        folderModificationsPage.NewFolder.click();

    }

    @When("write a folder name")
    public void write_a_folder_name() {

        folderModificationsPage.FolderNameBox.sendKeys(NewlyAddedFile);

    }

    @When("click submit icon")
    public void click_submit_icon() {
        folderModificationsPage.FolderNameBox.submit();
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
        folderModificationsPage.UploadFileBtn.sendKeys(FilePath); //file upload is failing

    }


}
