Feature: Password reset
  Scenario: User resets password
    Given browser is started
    * login page is opened
    When user clicks 'Forgot your password?' button
    * user inputs email "marina.int222222@gmail.com"
    * user clicks 'Reset Password' button
    Then text "Email sent successfully. Please check your email inbox for the reset password instructions." is displayed