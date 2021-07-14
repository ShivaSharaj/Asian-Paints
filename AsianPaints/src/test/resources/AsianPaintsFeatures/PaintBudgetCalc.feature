#Author: SHIVA-SHARAJ.H-N@CAPGEMINI.COM
Feature: Paint Budget Calculator

  Scenario Outline: Valid Carpet Area
    Given the user in on asian paints home page
    When the user clicks on Paint Budget Calculator link
    And the user selects the type of project as "<project>"
    And the user selects the space as "<space>"
    And the user selects the size of home as "<size>"
    And the user enters the carpet area as "<area>"
    And the user clicks on Calculate now button
    Then the user should be able to see the recommended product
    And user closes the browser

    Examples: 
      | project        | space    | size | area |
      | Fresh Painting | Interior |    1 | 1200 |
      | Fresh Painting | Interior |    2 | 5000 |
      | Fresh Painting | Interior |    3 | 1750 |
      | Fresh Painting | Exterior |    0 | 1300 |
      | Re-painting    | Interior |    1 | 2000 |
      | Re-painting    | Interior |    2 | 3000 |
      | Re-painting    | Interior |    3 | 1100 |
      | Re-painting    | Exterior |    0 | 6600 |

  Scenario Outline: Inalid Carpet Area
    Given the user in on asian paints home page
    When the user clicks on Paint Budget Calculator link
    And the user selects the type of project as "<project>"
    And the user selects the space as "<space>"
    And the user selects the size of home as "<size>"
    And the user enters the carpet area as "<area>"
    And the user clicks on Calculate now button
    Then the user should be able to see the recommended product
    And user closes the browser

    Examples: 
      | project        | space    | size | area |
      | Fresh Painting | Interior |    1 | aaa  |
      | Fresh Painting | Interior |    2 | $$   |
      | Fresh Painting | Interior |    3 | bbb  |
      | Re-painting    | Interior |    3 | **3  |
      | Re-painting    | Exterior |    0 | abc  |
