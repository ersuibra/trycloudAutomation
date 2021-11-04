package com.trycloud.step_definition;

import com.trycloud.pages.DashboardPage;
import com.trycloud.pages.FilesPage;
import com.trycloud.utilities.BrowserUtil;
import com.trycloud.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;

public class Us4_FilesFavoriteStepDefs {
    DashboardPage dashboardPage = new DashboardPage();
    FilesPage filesPage = new FilesPage();
    String nameOfFile;

    @When("click action-icon from any file on the page")
    public void click_action_icon_from_any_file_on_the_page() {
        dashboardPage.getModule("Files");
        filesPage.removeFaves();
        Driver.getDriver().navigate().refresh();
        int randomNumber = BrowserUtil.randomNumber(1, filesPage.itemNames.size());
        nameOfFile = Driver.getDriver().findElement(By.xpath("(//span[@class='innernametext'])[" + randomNumber + "]")).getText();
        Driver.getDriver().findElement(By.xpath("(//a[@class='action action-menu permanent'])[" + randomNumber + "]")).click();

    }

    @When("choose “Add to Favorites” option")
    public void choose_add_to_favorites_option() {
        filesPage.addToFavorites.click();
    }

    @When("click “Favorites” sub-module on the lest side")
    public void click_favorites_sub_module_on_the_lest_side() {
        filesPage.favoriteTab.click();
        BrowserUtil.waitFor(1);
    }

    @Then("verify the chosen file is listed on the table")
    public void verify_the_chosen_file_is_listed_on_the_table() {
        Assert.assertEquals(nameOfFile, Driver.getDriver().findElement(By.xpath("//td[1]//span[@class='innernametext']")).getText());
    }


}
