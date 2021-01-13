Feature: get Projects API

  Scenario: admin gets the list of Projects via API
    Given api is set up
    When admin sends GET request to get the list of Projects
    Then status code is 200