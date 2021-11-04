@us1
Feature: As a user, I should be able to login to TryCloud app

  Background:
    Given user on the login page

  Scenario Outline: Login with valid credentials
    When user use username "<username>" and passcode "<password>"
    And user click login button
    Then verify user launched to the dashboard

    Examples:
      | username | password    |
      | user1    | Userpass123 |
      | user31   | Userpass123 |
      | user61   | Userpass123 |
      | user91   | Userpass123 |

  Scenario Outline: Login fail with invalid credentials
    When user enter valid "<username>" and "<password>"
    And  user click login button
    Then "<message>" message should be displayed

    Examples:
      | username | password    | message                     |
      | User9    | Wrong       | Wrong username or password. |
      | Wrong    | Userpass123 | Wrong username or password. |
      | Wrong    | Wrong       | Wrong username or password. |

