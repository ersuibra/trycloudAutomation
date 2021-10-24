package com.trycloud.step_definition;

import com.trycloud.pages.LoginPage;
import com.trycloud.utilities.ConfigReader;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class us2 {
    LoginPage loginPage = new LoginPage();

    @When("login as a user")
    public void login_as_a_user() {
        loginPage.userName.sendKeys(ConfigReader.read("user1"));
        loginPage.password.sendKeys(ConfigReader.read("password"));
        loginPage.loginButton.click();

    }

    @Then("verify that user see the following modules {string}")
    public void verify_that_user_see_the_following_modules(String moduleName) {

    }
}
