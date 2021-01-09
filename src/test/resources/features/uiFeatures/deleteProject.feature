Feature: Delete a project

  Scenario: User deletes an existing project
    Given Browser is started
    * User is logged into TestRail
    * "Test project" is created
    * Administration Projects page is opened
    When user clicks 'delete' on the right from the project name
    * and selects the checkbox 'Yes, delete this project (cannot be undone)'
    * and clicks 'OK' button
    Then Text "Successfully deleted the project." is displayed