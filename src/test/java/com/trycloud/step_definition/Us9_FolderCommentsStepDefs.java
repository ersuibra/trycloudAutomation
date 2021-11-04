package com.trycloud.step_definition;

import com.github.javafaker.Faker;
import com.trycloud.pages.DashboardPage;
import com.trycloud.pages.FilesPage;
import com.trycloud.utilities.BrowserUtil;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;

public class Us9_FolderCommentsStepDefs {
    DashboardPage dashboardPage = new DashboardPage();
    FilesPage filesPage = new FilesPage();
    Faker faker = new Faker();

    @When("click details")
    public void click_details() {
        BrowserUtil.checkVisibilityOfElement(By.xpath("//div/ul/li[4]/a[@data-action='Details' ]"), 5);
        dashboardPage.moveToAndClickElement("//div/ul/li[4]/a[@data-action='Details' ]");
        //a[starts-with(@class,'action') and contains(@data-action, 'menu')    ]
    }

    @When("write a comment inside to the input box")
    public void write_a_comment_inside_to_the_input_box() {
        filesPage.commentTab.click();
        filesPage.commentMessage.sendKeys("a" + faker.chuckNorris().fact());
        //li/a[@id='commentsTabView']
        //div[@id='commentsTabView']/div/form/div[@class='message']

    }

    @When("click the submit button to post it")
    public void click_the_submit_button_to_post_it() {
        //div[@id='commentsTabView']/div/form/input[@type='submit']
        filesPage.commentSubmit.click();

    }

    @Then("verify the comment is displayed in the comment section.")
    public void verify_the_comment_is_displayed_in_the_comment_section() {
        //div/ul/li/div[@class='message'].getText assertTrue
        Assert.assertNotNull(filesPage.commentArea.getText());
    }


}
