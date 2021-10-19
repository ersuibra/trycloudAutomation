@ui @us3
Feature: As a user, I should be able to access to Files module.
  Background:
    Given user on the login page
    And login as a user

  Scenario: verify users can access to Files module
    Then verify the page tile is “Files - Trycloud”

  Scenario: verify users can select all the uploaded files from the page
    When user click the top left checkbox of the table
    Then assert all the files are selected
