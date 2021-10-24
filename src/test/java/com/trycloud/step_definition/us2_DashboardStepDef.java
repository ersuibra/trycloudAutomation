package com.trycloud.step_definition;


import com.trycloud.pages.DashboardPage;
import com.trycloud.pages.LoginPage;
import com.trycloud.utilities.BrowserUtil;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

public class us2_DashboardStepDef {
    LoginPage loginPage = new LoginPage();
    DashboardPage dashboardPage = new DashboardPage();

    @When("login as a user")
    public void login_as_a_user() {
        loginPage.login();
    }

    @Then("verify that user see the following modules")
    public void verify_that_user_see_the_following_modules(List<String> expectedModules) {
        List<String> actualModules = BrowserUtil.getElementsText(dashboardPage.allModules);
        Assert.assertEquals(expectedModules,actualModules );

    }
}
