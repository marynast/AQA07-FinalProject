Feature: Project name length is 1-250 values

  Background:
    Given Browser is started
    And User is logged into TestRail
    And Dashboard page is opened

  Scenario: Leave 'Name' field empty
    When User clicks Add Project button
    And User leave field 'Name' empty and clicks Add Project button in the bottom of the page
    Then The project was not created

  Scenario: Input 1 value into the 'Name' field
    When  User clicks Add Project button
    And Information about the project in the database, where id = 2
    And User clicks Add Project button in the bottom of the page
    Then Text "Successfully added the new project." is displayed

  Scenario: Input 2 values into the 'Name' field
    When User clicks Add Project button
    And Information about the project in the database, where id = 3
    And User clicks Add Project button in the bottom of the page
    Then Text "Successfully added the new project." is displayed

  Scenario: Input 249 values into the 'Name' field
    When User clicks Add Project button
    And Information about the project in the database, where id = 4
    And User clicks Add Project button in the bottom of the page
    Then Text "Successfully added the new project." is displayed

  Scenario: Input 250 values into the 'Name' field
    When User clicks Add Project button
    And Information about the project in the database, where id = 5
    And User clicks Add Project button in the bottom of the page
    Then Text "Successfully added the new project." is displayed


  Scenario: Input 251 values into the 'Name' field
    When User clicks Add Project button
    And Information about the project in the database, where id = 6
    And User clicks Add Project button in the bottom of the page
    Then  The last value is cropped and the project name has 250 characters
