Feature: Delete a project

  Scenario: User deletes an existing project
    Given Browser is started
    And User is logged into TestRail
    And Select an already-existing project
    When User clicks delete button on the right from the project name
    And Selects the checkbox
    And Clicks OK button
    Then Project successfully deleted