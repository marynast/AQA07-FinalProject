Feature: get Current user API

  Scenario: admin gets the current user name via API
    Given api is set up
    When admin sends GET request to get the current user
    Then user name equals to "ThisNameDoesNotExist"