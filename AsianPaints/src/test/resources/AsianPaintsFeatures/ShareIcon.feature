#Author: SHIVA-SHARAJ.H-N@CAPGEMINI.COM
Feature: Sharing Contractor details dropdown 

Scenario: Verifying Share icon functionality
Given the user in on asian paints home page
When the user clicks on Find A Contractor tab
And the user enters the pincode
And the user clicks on Search button
Then the contractor details should be visible
And the user clicks on Share icon to see the dropdown menu