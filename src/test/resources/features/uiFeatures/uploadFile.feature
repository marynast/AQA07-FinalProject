Feature: File upload

  Scenario: User uploads a file while creating a new test case
    Given browser is started
    * user is logged into TestRail
    * "Test project" is created
    * Dashboard page is opened
    When user clicks 'Test Cases' button in 'Test project' section
    * user clicks 'Add Test Case' button
    * user populates the 'Title' field with the text "Login to TestRail"
    * user populates the 'Steps' field with the text "Open link. Input credentials. Click 'Login' button."
    * user populates the 'Expected Result' field with the text "Dashboard page is displayed"
    * user clicks 'Add an image to this text field.' button
    * user clicks on the section 'Drop images here to embed, or click to browse.'
    * user selects the file 'file_name'
    * user clicks 'Add image' button
    * user clicks 'Add test case' button
    Then text "Successfully added the new test case." is displayed
    * 'file_name' is displayed in the 'Details' section in the right panel