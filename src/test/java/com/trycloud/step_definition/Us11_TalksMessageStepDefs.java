package com.trycloud.step_definition;

import com.trycloud.pages.TalkPage;
import com.trycloud.utilities.BrowserUtil;
import com.trycloud.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import static org.junit.Assert.assertEquals;

public class Us11_TalksMessageStepDefs {
    TalkPage talkPage = new TalkPage();

    @When("click Talk module")
    public void click_talks_module() {
        String moduleName="Talk";
     talkPage.navigateToModule(moduleName);
    }

    @Then("verify the page tile is Talks module’s tile")
    public void verify_the_page_tile_is_talks_module_s_tile() {
        String expectedResult = "Talk - Trycloud QA";
        assertEquals(expectedResult, Driver.getDriver().getTitle());
    }

    @When("search a user from search box on the left")
    public void search_a_user_from_search_box_on_the_left() {
        talkPage.conversationBox.sendKeys("User172");
        talkPage.allUsers.get(0).click();
    }

    @When("write a message")
    public void write_a_message() {
        talkPage.messageBox.sendKeys("4 Testing");
        BrowserUtil.waitFor(2);
    }

    @When("click submit button")
    public void click_submit_button() {
        talkPage.submitButton.click();
    }

    @Then("verify the message is displayed on the conversation log")
    public void verify_the_message_is_displayed_on_the_conversation_log() {

        String expected = "4 Testing";
        String actualMessage = talkPage.messageDisplay.getAttribute("innerHTML");

        System.out.println("actualMessage = " + actualMessage);

        assertEquals(expected, actualMessage);
    }


}
