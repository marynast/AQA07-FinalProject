Feature: Project name length is 1-250 values

    Background:
      Given Browser is started
      * User is logged into TestRail
      * Dashboard page is opened

    Scenario: Leave 'Name' field empty
      When User clicks Add Project button
      * User leave field 'Name' empty and clicks Add Project button in the bottom of the page
      Then The project was not created

    Scenario: Input 1 value into the 'Name' field
      When  User clicks Add Project button
      * Information about the project in the database, where id = 2
      * User clicks Add Project button in the bottom of the page
      Then Text "Successfully added the new project." is displayed

    Scenario: Input 2 values into the 'Name' field
      When User clicks Add Project button
      * Information about the project in the database, where id = 3
      * User clicks Add Project button in the bottom of the page
      Then Text "Successfully added the new project." is displayed

    Scenario: Input 249 values into the 'Name' field
      When User clicks Add Project button
      * Information about the project in the database, where id = 4
      * User clicks Add Project button in the bottom of the page
      Then Text "Successfully added the new project." is displayed

    Scenario: Input 250 values into the 'Name' field
      When User clicks Add Project button
      * Information about the project in the database, where id = 5
      * User clicks Add Project button in the bottom of the page
      Then Text "Successfully added the new project." is displayed

    Scenario: Input 251 values into the 'Name' field
      When User clicks Add Project button
      * Information about the project in the database, where id = 6
      * User clicks Add Project button in the bottom of the page
      Then Text "Successfully added the new project." is displayed
      * the last value of the name is cropped
      * in the list of projects there is a project with name "251rper austor nique vitae temous qurm pellentesque nyc npm aliqaam sim it turtor ccnsequat ed parta nybh vinenatis ctas sid ftlis etet relit bliquet sagdttis sd cfnsectetur pueus dt favcibus pulbinar elsmentum intdger enfm ngque vblutpat ic tincrdun"