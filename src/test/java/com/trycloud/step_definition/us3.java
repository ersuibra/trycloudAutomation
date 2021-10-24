package com.trycloud.step_definition;

import com.trycloud.pages.LoginPage;
import com.trycloud.pages.US3_Page_FilesModule;
import com.trycloud.pages.DashboardPage;
import com.trycloud.pages.FilesPage;
import com.trycloud.utilities.BrowserUtil;
import com.trycloud.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import java.util.ArrayList;
import java.util.List;

public class us3 {

    US3_Page_FilesModule us3_page_filesModule = new US3_Page_FilesModule();

    @Then("verify the page tile is “Files - Trycloud”")
    public void verify_the_page_tile_is_files_trycloud() {

        us3_page_filesModule.files.click();
        BrowserUtil.waitFor(1);
        String currentTitle = Driver.getDriver().getTitle();
        System.out.println("currentTitle = " + currentTitle);
        String expectedTitle = "Files - Trycloud";
        System.out.println("expectedTitle = " + expectedTitle);
      
        Assert.assertEquals(expectedTitle, currentTitle);

    }

    @When("user click the top left checkbox of the table")
    public void user_click_the_top_left_checkbox_of_the_table() {
        us3_page_filesModule.files.click();
        BrowserUtil.waitFor(1);
        us3_page_filesModule.topLeftCheckBox.click();

    }

    @Then("assert all the files are selected")
    public void assert_all_the_files_are_selected() {

        BrowserUtil.waitFor(1);
        Assert.assertTrue(BrowserUtil.checkAllBoxVerify(us3_page_filesModule.allCheckBoxes));

    }
}
