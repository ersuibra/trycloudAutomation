package com.trycloud.step_definition;

import com.trycloud.pages.LoginPage;
import com.trycloud.utilities.BrowserUtil;
import com.trycloud.utilities.ConfigReader;
import com.trycloud.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class us1_LoginStepDefs {
    LoginPage loginPage = new LoginPage();

    @Given("user on the login page")
    public void user_on_the_login_page() {
        Driver.getDriver().get(ConfigReader.read("url"));
    }

    @When("user enter valid {string} and {string}")
    public void user_enter_valid_and(String username, String password) {
        loginPage.login(username, password);

    }

    @When("user click login button")
    public void user_click_login_button() {
        loginPage.loginButton.click();
    }

    @Then("verify user launched to the dashboard")
    public void verify_user_launched_to_the_dashboard() {
        Assert.assertEquals("Dashboard - Trycloud", Driver.getDriver().getTitle());
    }

    @When("user enter invalid credentials")
    public void user_enter_invalid_credentials() {
        loginPage.usernameBox.sendKeys(ConfigReader.read("wuser1"));
        loginPage.passwordBox.sendKeys(ConfigReader.read("wpassword"));
    }

    @Then("{string} message should be displayed")
    public void wrong_username_or_password_message_should_be_displayed(String message) {
        Assert.assertEquals(message, loginPage.warningMessage.getText());
    }

    @When("user use username {string} and passcode {string}")
    public void user_use_username_and_passcode(String username, String password) {
        loginPage.usernameBox.sendKeys(username);
        loginPage.passwordBox.sendKeys(password);
    }


}
