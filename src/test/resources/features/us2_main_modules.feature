@us2
Feature: As a user, I should be access all the main modules of the app.

  Scenario: verify users access to the main modules
    Given user on the login page
    When login as a user
    Then verify that user see the following modules
      | Dashboard |
      | Files     |
      | Photos    |
      | Activity  |
      | Talk      |
      | Contacts  |
      | Circles   |
      | Calendar  |
      | Deck      |
      | More      |
