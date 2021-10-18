
Feature: As a user, I should be able to login.
  Background:
    Given user on the login page

  Scenario: verify user login with valid credentials
    When user enter valid username and password
    And user click login button
    Then verify user launched to the dashboard

  Scenario: verify user login fail with invalid credentials
    When user enter invalid credentials
    And click login button
    Then “Wrong username or password.” message should be displayed

  Scenario Outline: Login with valid credentials
    When user use username "<username>" and passcode "<password>"
    And user click login button
    Then verify user launched to the dashboard

    Examples:
      | username|password|
      | user1 | Userpass123 |
      | user31| Userpass123 |
      | user61| Userpass123 |
      | user91| Userpass123 |