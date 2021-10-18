Feature: As a user, I should be able to access to Files module.

  Scenario: verify users can access to Files module
    Given user on the login page
    And login as a user
    When click action-icon from any file on the page
    And choose “Add to Favorites” option
    And click “Favorites” sub-module on the lest side
    Then verify the chosen file is listed on the table
