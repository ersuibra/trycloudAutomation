Feature: As a user, I should be able to access to Talks module.

  Background:
    Given user on the login page
    And login as a user
    When click Talks module

  Scenario: verify users can access to Talks module
    Then verify the page tile is Talks module’s tile

  Scenario: verify users can send message
    And search a user from search box on the left
    And write a message
    And click submit button
    Then verify the message is displayed on the conversation log
