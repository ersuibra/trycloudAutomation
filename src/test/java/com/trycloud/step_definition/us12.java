package com.trycloud.step_definition;

import com.trycloud.pages.ContactsModulePage;
import com.trycloud.utilities.BrowserUtil;
import com.trycloud.utilities.Driver;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;


public class us12 {
    ContactsModulePage contactsModulePage = new ContactsModulePage();


    int sizeBeforeAddNewContact;


    @When("click “Contacts” module")
    public void click_contacts_module() {

        contactsModulePage.contactsModule.click();

        String text = contactsModulePage.numOfContacts.getText();
        Integer a = Integer.parseInt(text);
        sizeBeforeAddNewContact=a;




    }

    @Then("verify the page tile is Contents module’s tile")
    public void verify_the_page_tile_is_contents_module_s_tile() {
        String title = Driver.getDriver().getTitle();
        Assert.assertEquals("Contacts - Trycloud", title);


    }

    @When("click “New Contact” button")
    public void click_new_contact_button() {

        contactsModulePage.newContactBtn.click();
        BrowserUtil.waitFor(4);



    }

    @When("fill out the contact info like : Title, Phone, email, address , etc")
    public void fill_out_the_contact_info_like_title_phone_email_address_etc() {
        contactsModulePage.fullNameBtn.clear();

        contactsModulePage.fillOutContactInfo();
        BrowserUtil.waitFor(2);



    }

    @Then("verify the contact name is added to the contact list")
    public void verify_the_contact_name_is_added_to_the_contact_list() {
        BrowserUtil.waitFor(2);
        String text2 = contactsModulePage.numOfContacts.getText();
        Integer sizeAfterAddNewContact = Integer.parseInt(text2);

        System.out.println("sizeBeforeAddNewContact = " + sizeBeforeAddNewContact);
        System.out.println("sizeAfterAddNewContact = " + sizeAfterAddNewContact);

        Assert.assertTrue(sizeBeforeAddNewContact == sizeAfterAddNewContact - 1);


    }


}
