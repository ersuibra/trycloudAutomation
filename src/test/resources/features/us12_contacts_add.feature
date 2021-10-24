@ui @us12
Feature: As a user, I should be able to access to Contacts module.

  Background:
    Given user on the login page
    And login as a user
    When click “Contacts” module


  Scenario: verify users can access to Talks module
    Then verify the page tile is Contents module’s tile

  Scenario: verify users can send message
    And click “New Contact” button
    And fill out the contact info like : Title, Phone, email, address , etc
    Then verify the contact name is added to the contact list

