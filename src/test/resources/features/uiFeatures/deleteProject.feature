Feature: Delete a project

  Scenario: User deletes an existing project
    Given Browser is started
    * User is logged into TestRail
    * Select an already-existing project
    When User clicks delete button on the right from the project name
    * Selects the checkbox
    * Clicks OK button
    Then Project successfully deleted