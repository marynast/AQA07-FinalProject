Feature: Adding a new project

  Scenario: User adds a new project
    Given browser is started
    * user is logged into TestRail
    * Dashboard page is opened
    * project info from db where project id = 7
    When user clicks Add Project button
    Then text "Successfully added the new project." is displayed
