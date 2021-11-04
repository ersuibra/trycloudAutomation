package com.trycloud.step_definition;


import com.trycloud.pages.FilesPage;
import com.trycloud.pages.FolderFilePage;
import com.trycloud.utilities.BrowserUtil;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import java.util.List;

public class Us7_FolderDeleteStepDefs {

    FolderFilePage folderFilePage = new FolderFilePage();

    FilesPage filesPage = new FilesPage();

    List<String> actualDeletedFileNames = BrowserUtil.getElementsText(folderFilePage.deletedFilesList);


    // us4 us4 = new us4();
    // String ExpectedDeletedFileName =us4.nameOfFile;

    @When("choose “delete files” option")
    public void choose_delete_files_option() {
        folderFilePage.DeleteTab.click();
        BrowserUtil.waitFor(3);
    }

    @When("click deleted files on the left bottom corner")
    public void click_deleted_files_on_the_left_bottom_corner() {
        folderFilePage.DeletedFilesTab.click();
        BrowserUtil.waitFor(3);
    }

    @Then("verify the deleted file is displayed no the page.")
    public void verify_the_deleted_file_is_displayed_no_the_page() {
        List<String> actualDeletedFileNames = BrowserUtil.getElementsText(folderFilePage.deletedFilesList);
        System.out.println("Item size in deleted items list After deletion = " + actualDeletedFileNames.size());

        //System.out.println("Items in Deleted Files: " +"" + BrowserUtil.getAllText(folderFilePage.deletedFilesList));

        //   Assert.assertTrue(actualDeletedFileNames.contains(ExpectedDeletedFileName));


    }


}
