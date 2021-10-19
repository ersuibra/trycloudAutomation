@ui @us5
Feature: As a user, I should be able to access to Files module.

  Background:
    Given user on the login page
    And login as a user

  Scenario: verify users can remove a file from favorites.
    When click action-icon from any file on the page
    And click “Remove from Favorites” option
    Then verify that the file is removed from Favorites sub-module’s table.

  Scenario: verify users can upload a file directly to the homepage

    When click the “+” icon on top
    And click “upload file"
    And upload a file
    Then verify the file is displayed on the page
