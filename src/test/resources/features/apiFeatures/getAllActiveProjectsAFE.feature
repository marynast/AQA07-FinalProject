Feature: get all active projects API
  Scenario: admin gets the list of all active projects via API
    Given api is set up
    When admin sends GET request to "/index.php?/api/v2/get_projects&is_completed=0"
    Then status code is 200
    * user name equals to "AQA"
    * project with id "1234" is present