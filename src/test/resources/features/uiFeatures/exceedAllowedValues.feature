Feature: Maximum 250 characters are allowed in the Project Name field
  Scenario: User creates a new project and inputs 252 characters into the 'Name' field
    Given browser is started
    * user is logged into TestRail
    * Dashboard page is opened
    When user clicks Add Project button
    * user selects 'Name' field and inputs "Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live the blind texts. Separated they live in Bookmarksgrove right at the coast of the Semantics, a large language ocean. A small river named Duden flows into"
    Then the last 2 characters are cropped
    * text "Far far away, behind the word mountains, far from the countries Vokalia and Consonantia, there live the blind texts. Separated they live in Bookmarksgrove right at the coast of the Semantics, a large language ocean. A small river named Duden flows in" is displayed in the field 'Name'