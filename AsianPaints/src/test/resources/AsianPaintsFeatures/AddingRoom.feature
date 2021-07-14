#Author: SHIVA-SHARAJ.H-N@CAPGEMINI.COM
Feature: Adding room

  Scenario: Addition of room for Budget Calculation
    Given the user in on asian paints home page
    When the user clicks on Paint Budget Calculator link
    And the user clicks on Advanced Calculator Tab
    And the user clicks on Add room button
    Then an extra room should be added
    And user closes the browser
