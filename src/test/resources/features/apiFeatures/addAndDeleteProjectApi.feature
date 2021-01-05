Feature: Add project through API

  Scenario: admin adds a project via API
    Given api is set up
    When admin creates a project
    And admin gets the project
    Then admin deletes this project