package com.trycloud.step_definition;

import com.trycloud.pages.LoginPage;
import com.trycloud.utilities.BrowserUtil;
import com.trycloud.utilities.ConfigReader;
import com.trycloud.utilities.Driver;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class us1 {
    LoginPage loginPage = new LoginPage();

    @Given("user on the login page")
    public void user_on_the_login_page() {
        Driver.getDriver().get(ConfigReader.read("url"));
    }

    @When("user enter valid username and password")
    public void user_enter_valid_username_and_password() {
    loginPage.userName.sendKeys(ConfigReader.read("user1"));
    loginPage.password.sendKeys(ConfigReader.read("password"));
    }

    @When("user click login button")
    public void user_click_login_button() {
        loginPage.loginButton.click();
    }

    @Then("verify user launched to the dashboard")
    public void verify_user_launched_to_the_dashboard() {
        Assert.assertTrue( Driver.getDriver().getTitle().startsWith("Dashboard"));
    }

    @When("user enter invalid credentials")
    public void user_enter_invalid_credentials() {
        loginPage.userName.sendKeys(ConfigReader.read("wuser1"));
        loginPage.password.sendKeys(ConfigReader.read("wpassword"));
    }

    @Then("“Wrong username or password.” message should be displayed")
    public void wrong_username_or_password_message_should_be_displayed() {

        Assert.assertEquals("Wrong username or password.", loginPage.errorMessage.getText());

    }

    @When("user use username {string} and passcode {string}")
    public void user_use_username_and_passcode(String username, String password) {
        loginPage.userName.sendKeys(username);
        loginPage.password.sendKeys(password);

    }


}
