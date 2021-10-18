Feature: As a user, I should be able to access to Files module.

  Background:
    Given user on the login page
    And login as a user

  Scenario: verify users can change the app Settings.
    When click Settings on the left bottom corner
    Then verify user can click any buttons.

  Scenario: verify users see the app storage usage
    When check the current storage usage
    And upload a file
    And refresh the page
    Then verify the storage usage is increased