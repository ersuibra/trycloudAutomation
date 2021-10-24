package com.trycloud.step_definition;

import com.trycloud.pages.DashboardPage;
import com.trycloud.pages.LoginPage;
import com.trycloud.utilities.BrowserUtil;
import com.trycloud.utilities.ConfigReader;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.List;

public class us2_DashboardStepDef {

    @When("user  log in with valid credentials")
    public void userLogInWithValidCredentials() {

       new LoginPage().login();
    }

    @Then("Verify the user see the following modules:")
    public void verify_the_user_see_the_following_modules(List<String> expectedModules) {

        List<String> actualModules = BrowserUtil.getElementsText(new DashboardPage().allModuleNames);

        Assert.assertEquals(expectedModules,actualModules);

    }


}
