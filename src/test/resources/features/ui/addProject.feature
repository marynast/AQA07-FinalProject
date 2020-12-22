Feature: User adds a new project

  Scenario: Add a new project
    Given browser is started
    * user is logged into TestRail
    * Dashboard page is opened
    When user clicks Add Project button
    * user selects 'Name' field and inputs "Test project"
    * user selects 'Announcement' field and inputs "Marina and Natasha created this project"
    * user selects the checkbox 'Show the announcement on the overview page'
    * user selects radio button 1 'Use a single repository for all cases'
    * user clicks Add Project button in the bottom of the page
    Then text "Successfully added the new project." is displayed
    * project "Test project" is displayed in the list pf projects
