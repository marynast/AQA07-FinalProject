Feature: Password reset
  Scenario: User resets password
    Given Browser is started
    When user clicks Forgot your password? button
    And user inputs not existing email "marina.int222222@gmail.com" to reset password
    And user clicks Reset Password button
    Then success text "Email sent successfully. Please check your email inbox for the reset password instructions." is displayed