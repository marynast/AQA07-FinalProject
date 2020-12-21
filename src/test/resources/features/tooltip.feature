Feature: Tooltip is displayed when the mouse is hovered over the text

  Background:
    Given browser is started
    * user is logged into TestRail
    * Dashboard page is opened

  Scenario: Hover the mouse over the text '14 days'
    When user hovers the mouse over the text '14 days'
    Then tooltip is displayed
    * text "Change the time frame for the chart."" is present