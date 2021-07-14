#Author: SHIVA-SHARAJ.H-N@CAPGEMINI.COM
Feature: Exterior Wall Paints products

  Scenario: Viewing Apex products
    Given the user in on asian paints home page
    When the user clicks on Paints and Textures tab
    And the user clicks on Exterior walls
    And the user clicks on Wall paints
    And the user clicks on Apex
    Then the user should be able to see apex products
    And user closes the browser
