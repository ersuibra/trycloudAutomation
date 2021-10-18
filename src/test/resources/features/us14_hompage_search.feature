Feature: As a user, I should be able to access search any item/ users from the homepage.


  Scenario: verify users can see all the contact names on the contact list
    Given user on the login page
    And login as a user
    When click magnifier icon on the right top
    And search any existing file,folder,user name
    Then verify the app displays the expected result option
