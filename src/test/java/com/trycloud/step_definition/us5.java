package com.trycloud.step_definition;

import com.trycloud.pages.LoginPage;
import com.trycloud.pages.RemovingFileFromFavoritesPage;
import com.trycloud.utilities.BrowserUtil;
import com.trycloud.utilities.ConfigReader;
import com.trycloud.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.interactions.Actions;

public class us5 {

    RemovingFileFromFavoritesPage removeFav=new RemovingFileFromFavoritesPage();
    LoginPage loginPage=new LoginPage();


    @When("click “Remove from Favorites” option")
    public void click_remove_from_favorites_option() {
        removeFav.login(ConfigReader.read("user1"),ConfigReader.read("password"));
        BrowserUtil.waitFor(2);

        Actions actions=new Actions(Driver.getDriver());
        actions.moveToElement(removeFav.filesModule).click().perform();
       // removeFav.filesModule.click();

        removeFav.favoritesTab.click();
        BrowserUtil.waitFor(2);

        //li[@data-id="files"]
        removeFav.selectFirstFile.click();
        removeFav.removeFromFavoritesBtn.click();


    }

    @Then("verify that the file is removed from Favorites sub-module’s table.")
    public void verify_that_the_file_is_removed_from_favorites_sub_module_s_table() {
        Driver.getDriver().navigate().refresh();
        Assert.assertEquals(removeFav.sizeOfFavListBeforeRemove(),removeFav.sizeOfFavListAfterRemove()+1);
    }

    @When("click the “+” icon on top")
    public void click_the_icon_on_top() {

    }

    @When("click “upload file\"")
    public void click_upload_file() {

    }

    @When("upload a file")
    public void upload_a_file() {

    }

    @Then("verify the file is displayed on the page")
    public void verify_the_file_is_displayed_on_the_page() {

    }


}
