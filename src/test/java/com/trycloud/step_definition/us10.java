package com.trycloud.step_definition;

import com.trycloud.pages.FilesPage;
import com.trycloud.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.WebElement;

public class us10 {
    FilesPage filesPage = new FilesPage();
    String passStorage;

    @When("click Settings on the left bottom corner")
    public void click_settings_on_the_left_bottom_corner() {
        filesPage.settingsButton.click();
    }

    @Then("verify user can click any buttons.")
    public void verify_user_can_click_any_buttons() {
        for (WebElement checkBox : filesPage.checkBoxes) {
            boolean beforeClick = checkBox.isSelected();
            checkBox.click();
            boolean afterClick = checkBox.isSelected();
            Assert.assertNotEquals(!beforeClick, afterClick);
        }
    }

    @When("check the current storage usage")
    public void check_the_current_storage_usage() {
        String storageBefore = filesPage.storageUsage.getText();

        storageBefore = storageBefore.substring(0, (storageBefore.indexOf(" ")));

        System.out.println("storageBefore = " + storageBefore);
        passStorage = storageBefore;

    }

    @When("refresh the page")
    public void refresh_the_page() {
        Driver.getDriver().navigate().refresh();

    }

    @Then("verify the storage usage is increased")
    public void verify_the_storage_usage_is_increased() {

        String storageCurrent = filesPage.storageUsage.getText();

        storageCurrent = storageCurrent.substring(0, (storageCurrent.indexOf(" ")));

        Assert.assertTrue(Double.parseDouble(storageCurrent) > Double.parseDouble(passStorage));

    }


}
