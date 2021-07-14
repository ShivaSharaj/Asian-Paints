#Author: SHIVA-SHARAJ.H-N@CAPGEMINI.COM
Feature: Finding Contractor based on Pincode

  Scenario Outline: Valid Pincode
    Given the user in on asian paints home page
    When the user clicks on Find A Contractor tab
    And the user enters the valid pincode as "<pincode>"
    And the user clicks on Search button
    Then the contractor details should be visible
    And user closes the browser

    Examples: 
      | pincode |
      |  560061 |
      |  560033 |

  Scenario Outline: Invalid Pincode
    Given the user in on asian paints home page
    When the user clicks on Find A Contractor tab
    And the user enters the invalid pincode as "<pincode>"
    And the user clicks on Search button
    Then the contractor details should not be visible
    And user closes the browser

    Examples: 
      | pincode |
      |   56006 |
      | 5600331 |
      
