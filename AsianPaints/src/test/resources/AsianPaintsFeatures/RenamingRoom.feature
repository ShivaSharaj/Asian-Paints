#Author: SHIVA-SHARAJ.H-N@CAPGEMINI.COM
Feature: Renaming Functionality

  Scenario: Renaming a room
    Given the user in on asian paints home page
    When the user clicks on Paint Budget Calculator link
    And the user clicks on Advanced Calculator Tab
    And the user clicks on the pen icon to rename room as "Living room"
    Then the user is able to see the renamed room
