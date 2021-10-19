@ui @us9
Feature: As a user, I should be able to access to Files module.


  Scenario: verify users can write comments to files/folders.
    Given user on the login page
    And login as a user
    When click action-icon from any file on the page
    And click details
    And write a comment inside to the input box
    And click the submit button to post it
    Then verify the comment is displayed in the comment section.
