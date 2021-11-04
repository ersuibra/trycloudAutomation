@us13
Feature: As a user, I should be able to access to Contacts module.

  Scenario: verify users can see all the contact names on the contact list
    Given user on the login page
    And login as a user
    When click “Contacts” module
    Then verify the contact names are in the list
