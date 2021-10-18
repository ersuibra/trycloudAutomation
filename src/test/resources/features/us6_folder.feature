
Feature: As a user, I should be able to access to Files module.

  Background:
    Given user on the login page
    And login as a user

  Scenario: verify users can create a folder
    When click the “+” icon on top
    And click “New Folder”
    And write a folder name
    And click submit icon
    Then verify the folder is displayed on the page

  Scenario: verify users can upload a file inside a folder

    And choose a folder from the page
    When click the “+” icon on top
    And click “upload file"
    And upload a file
    Then verify the file is displayed on the page


