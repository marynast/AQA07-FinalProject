Feature: Project name length is 1-250 values

  Background:
    Given Browser is started
    * User is logged into TestRail
    * Dashboard page is opened

  Scenario: Leave 'Name' field empty
    When User clicks Add Project button
    * user selects 'Name' field
    * user leaves 'Name' field empty
    * user clicks Add Project button in the bottom of the page
    Then Text "Field Name is a required field." is displayed

  Scenario: Input 1 value into the 'Name' field
    When  User clicks Add Project button
    * user selects 'Name' field
    * user inputs "A" into the 'Name' field
    * user clicks Add Project button in the bottom of the page
    Then Text "Successfully added the new project." is displayed

    Scenario: Input 2 values into the 'Name' field
      When User clicks Add Project button
      * user selects 'Name' field
      * user inputs "Ab" into the 'Name' field
      * user clicks Add Project button in the bottom of the page
      Then Text "Successfully added the new project." is displayed

    Scenario: Input 249 values into the 'Name' field
      When User clicks Add Project button
      * user selects 'Name' field
      * user inputs "249per auctor neque vitae tempus quam pellentesque nec nam aliquam sem et tortor consequat id porta nibh venenatis cras sed felis eget velit aliquet sagittis id consectetur purus ut faucibus pulvinar elementum integer enim neque volutpat ac tincidun" into the 'Name' field
      * user clicks Add Project button in the bottom of the page
      Then Text "Successfully added the new project." is displayed

    Scenario: Input 250 values into the 'Name' field
      When User clicks Add Project button
      * user selects 'Name' field
      * user inputs "250per auctor neque vitae tempus quam pellentesque nec nam aliquam sem et tortor consequat id porta nibh venenatis cras sed felis eget velit aliquet sagittis id consectetur purus ut faucibus pulvinar elementum integer enim neque volutpat ac tincidunt" into the 'Name' field
      * user clicks Add Project button in the bottom of the page
      Then Text "Successfully added the new project." is displayed

    Scenario: Input 251 values into the 'Name' field
      When User clicks Add Project button
      * user selects 'Name' field
      * user inputs "251rper austor nique vitae temous qurm pellentesque nyc npm aliqaam sim it turtor ccnsequat ed parta nybh vinenatis ctas sid ftlis etet relit bliquet sagdttis sd cfnsectetur pueus dt favcibus pulbinar elsmentum intdger enfm ngque vblutpat ic tincrdunt" into the 'Name' field
      * user clicks Add Project button in the bottom of the page
      Then Text "Successfully added the new project." is displayed
      * the last value of the name is cropped
      * in the list of projects there is a project with name "251rper austor nique vitae temous qurm pellentesque nyc npm aliqaam sim it turtor ccnsequat ed parta nybh vinenatis ctas sid ftlis etet relit bliquet sagdttis sd cfnsectetur pueus dt favcibus pulbinar elsmentum intdger enfm ngque vblutpat ic tincrdun"