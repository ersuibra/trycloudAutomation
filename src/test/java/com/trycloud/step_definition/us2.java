package com.trycloud.step_definition;

import com.trycloud.pages.DashboardPage;
import com.trycloud.pages.LoginPage;
import com.trycloud.utilities.BrowserUtil;
import com.trycloud.utilities.ConfigReader;
import com.trycloud.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class us2 {
    LoginPage loginPage = new LoginPage();
    DashboardPage dashboardPage = new DashboardPage();

    @When("login as a user")
    public void login_as_a_user() {
        loginPage.userName.sendKeys(ConfigReader.read("user1"));
        loginPage.password.sendKeys(ConfigReader.read("password"));
        loginPage.loginButton.click();

    }

    @Then("verify that user see the following modules {string}")
    public void verify_that_user_see_the_following_modules(String moduleName) {
        Actions actions = new Actions(Driver.getDriver());
        String element = "//li[@tabindex]/a//span[normalize-space(.)='"+moduleName+"']";
        actions.moveToElement(Driver.getDriver().findElement(By.xpath(element))).perform();

        Assert.assertEquals(moduleName,Driver.getDriver().findElement(By.xpath(element)).getText());

    }
}
