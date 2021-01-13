Feature: get all active projects API
  Scenario: admin gets the list of all active projects via API
    Given api is set up
    When admin sends GET request to get all active projects
    Then status code is 200