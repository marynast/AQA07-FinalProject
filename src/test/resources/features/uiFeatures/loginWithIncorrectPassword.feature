Feature: Login with invalid data
  Scenario: User inputs incorrect password and logins
    Given browser is started
    * login page is opened
    When user inputs username "marina.int2@gmail.com" and password "incorrectpassword"
    * user clicks 'Log In' button
    Then text "Email/Login or Password is incorrect. Please try again." is displayed