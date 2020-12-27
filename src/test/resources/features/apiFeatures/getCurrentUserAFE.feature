Feature: get Current user API
  Scenario: admin gets the current user name via API
    Given api is set up
    When admin sends GET request to "/index.php?/api/v2/get_current_user"
    Then status code is 200
    * user name equals to "AQA"