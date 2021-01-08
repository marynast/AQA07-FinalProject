Feature: Adding a new project

  Scenario: User adds a new project
    Given Browser is started
    * User is logged into TestRail
    * Dashboard page is opened
    * Information about the project in the database, where id = 7
    When User clicks Add Project button
    Then The project was created
