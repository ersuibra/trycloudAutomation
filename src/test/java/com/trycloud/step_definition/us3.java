package com.trycloud.step_definition;

import com.trycloud.pages.DashboardPage;
import com.trycloud.pages.FilesPage;
import com.trycloud.utilities.BrowserUtil;
import com.trycloud.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class us3 {
    DashboardPage dashboardPage = new DashboardPage();
    FilesPage filesPage = new FilesPage();

    @Then("verify the page tile is “Files - Trycloud”")
    public void verify_the_page_tile_is_files_trycloud() {
        dashboardPage.getModule("Files");
        Assert.assertEquals("Files - Trycloud", Driver.getDriver().getTitle());
    }

    @When("user click the top left checkbox of the table")
    public void user_click_the_top_left_checkbox_of_the_table() {
        dashboardPage.getModule("Files");
        filesPage.selectAllBox.click();
        BrowserUtil.waitFor(1);

    }

    @Then("assert all the files are selected")
    public void assert_all_the_files_are_selected() {
        System.out.println("filesPage.allCheckboxes.size() = " + filesPage.allCheckboxes.size());

        Assert.assertTrue(BrowserUtil.getIsCheck(filesPage.allCheckboxes));

    }


}
