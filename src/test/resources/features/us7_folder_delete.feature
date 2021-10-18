Feature: As a user, I should be able to access to Files module.


  Scenario: verify users can delete a file/folder.
    Given user on the login page
    And login as a user
    When click action-icon from any file on the page
    And choose “delete files” option
    And click deleted files on the left bottom corner
    Then verify the deleted file is displayed no the page.