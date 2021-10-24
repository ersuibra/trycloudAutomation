package com.trycloud.step_definition;

import com.github.javafaker.Faker;
import com.trycloud.pages.DashboardPage;
import com.trycloud.pages.LoginPage;
import com.trycloud.pages.FavoritesPage;
import com.trycloud.pages.UploadFilePage;
import com.trycloud.utilities.BrowserUtil;
import com.trycloud.utilities.ConfigReader;
import com.trycloud.utilities.Driver;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.interactions.Actions;

public class us5 {

    int totalFilesAndFolders;

    UploadFilePage upload=new UploadFilePage();

    DashboardPage modules=new DashboardPage();

    FavoritesPage removeFav=new FavoritesPage();

    @When("click “Remove from Favorites” option")
    public void click_remove_from_favorites_option() {

      //  Actions actions=new Actions(Driver.getDriver());
       // actions.moveToElement(removeFav.filesModule).click().perform();//on the File Page
      //from us 4 @When("click action-icon from any file on the page")
        //    public void click_action_icon_from_any_file_on_the_page() :  we are on the File Page

        removeFav.favoritesTab.click();//on the favorites page
       BrowserUtil.waitFor(1);

        if (removeFav.sizeOfFavListBeforeRemove()>0){
            removeFav.selectFirstFile.click();
            removeFav.removeFromFavoritesBtn.click();
        }

    }

    @Then("verify that the file is removed from Favorites sub-module’s table.")
    public void verify_that_the_file_is_removed_from_favorites_sub_module_s_table() {
        Driver.getDriver().navigate().refresh();
        Assert.assertEquals(removeFav.sizeOfFavListBeforeRemove(),removeFav.sizeOfFavListAfterRemove()+1);

        totalFilesAndFolders=upload.totalNumberOfFilesanFolders.size();

    }

    @When("click the “+” icon on top")
    public void click_the_icon_on_top() {
        modules.getModule("Files");
        BrowserUtil.waitFor(2);
        upload.addIcon.click();




    }

    @When("click “upload file\"")
    public void click_upload_file() {



    }

    @When("upload a file")
    public void upload_a_file() {
   upload.uploadOption.sendKeys(upload.pathName);
   BrowserUtil.waitFor(2);

    }

    @Then("verify the file is displayed on the page")
    public void verify_the_file_is_displayed_on_the_page() {

        Assert.assertTrue(upload.totalNumberOfFilesanFolders.size()==totalFilesAndFolders+1);

    }


}
