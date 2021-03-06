Feature: Add a test case

  Scenario: User uploads a file while creating a new test case
    Given Browser is started
    And User is logged into TestRail
    And Information about the project in the database, where id = 7
    And User clicks Add Project button
    And The project was created
    And Administration page is opened and user click button Dashboard
    When user clicks on project Test project
    And user selects TEST CASES TAB
    And user clicks Add Test Case button
    And user populates the Title field with the text "Login to TestRail"
    And user populates the Steps field with the text "Open link. Input credentials. Click Login button."
    And user populates the Expected Result field with the text "Dashboard page is displayed"
    And user adds an image
    And user clicks Save test case button
    Then test case is saved and text "Successfully added the new test case." is present
    And attachment is displayed