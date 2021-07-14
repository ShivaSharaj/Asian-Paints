#Author: SHIVA-SHARAJ.H-N@CAPGEMINI.COM
Feature: Filtering the contractors

  Scenario: Filtering Contractors on basis of Ratings and Category
    Given the user in on asian paints home page
    When the user clicks on Find A Contractor tab
    And the user enters the valid pincode
    Then the user selects the category
    And the user selects the Ratings and reviews
    Then the Contractors should be filtered.
