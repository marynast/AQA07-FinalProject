Feature: get Projects API
  Scenario: admin gets the list of Project via API
    Given api is set up
    When admin sends GET request to "/index.php?/api/v2/get_projects&"
    Then status code is 200
