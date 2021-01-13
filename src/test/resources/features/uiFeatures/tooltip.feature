Feature: Tooltip is displayed when the mouse is hovered over the text

  Scenario: Hover the mouse over the text '14 days'
    Given Browser is started
    And User is logged into TestRail
    And Dashboard page is opened
    When User hovers the mouse over the text 14 days
    Then Text "Change the time frame for the chart." is present