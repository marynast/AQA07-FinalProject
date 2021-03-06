Feature: Login to TestRail

  Scenario: User enters invalid password when logins
    Given Browser is started
    When user inputs email "marina.int2@gmail.com"
    And invalid password "qwerty123"
    And clicks login button
    Then error text "Email/Login or Password is incorrect. Please try again." is displayed