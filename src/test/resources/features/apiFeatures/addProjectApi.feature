Feature: Add project API
  Scenario: admin adds a project via API
    Given api is set up
    When admin sends POST request to "index.php?/api/v2/add_project"
    Then status code is 200