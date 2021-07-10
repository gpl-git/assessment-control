@quizsingle @regression1
Feature: Quiz Single Scenarios

  Background:
    Given I navigate to "login" page av
    When I type "qa1@askproject.com" in the email field av
    And I type "12345" in the password field av
    When I click on the button "Sign In" av
    Then I wait for 1 second av
    And I verify "home" as current url av
    Then I click on the "Quizzes" av
    And I wait for 2 second av

  @regression2
  Scenario: Create a Single Choice Text Quiz av
    When I click on the button "Create New Quiz" av
    And I wait for 2 second av
    Then I type "Ash Quiz" as the quiz title av
    When I add the question av
    Then I select "Single" type question av
    When I type question text as "Functional testing" into "Q1" av
    And I type "Load" as option "Option 1*" into the "Q1" av
    And I type "Smoke" as option "Option 2*" into the "Q1" av
    Then I select "Option 2*" as the correct option in "Q1" av
    And I wait for 3 second av
    When I click on the button "Save" av
    And I wait for 1 second av
    Then quiz "Ash Quiz" should be displayed on the list of quizzes av
    And I delete "Ash Quiz" from the list of quizzes av

  @regression3
  Scenario Outline: Quiz Random Title for question parameterised av
    When I click on the button "Create New Quiz" av
    And I wait for 2 second av
    And I type "AS Quiz SC" as quiz title
    And I wait for 2 second av
    When I add the question av
    Then I select "Single" type question av
    When I type <intQ> characters as question text into <qNum> av
    And I type "Option 1" as option "Option 1*" into the "Q1" av
    And I type "Option 2" as option "Option 2*" into the "Q1" av
    Then I select "Option 2*" as the correct option in "Q1" av
    And I click on the button "Save" av
    And I wait for 2 second av
    #And I validate that the element "conMess" is present av
    And I wait for 2 second av
    Then quiz "AS Quiz SC" should be displayed on the list of quizzes av
    #Then quiz "QuizTitle" should be displayed on the list of quizzes av
    And I delete "AS Quiz SC" from the list of quizzes av
    Examples:
      | intQ | qNum |
      | 1000 | "Q1" |
      | 1    | "Q1" |
      | 999  | "Q1" |
    # issue Max+1  too long characters but throws no error message
      | 1001 | "Q1" |


  @regression4
  Scenario Outline: Quiz Random Title for question and option parameterised av
    When I click on the button "Create New Quiz" av
    And I wait for 2 second av
    When I create quiz title av
    And I wait for 2 second av
    When I add the question av
    Then I select "Single" type question av
    When I type <intQ> characters as question text into <qNum> av
    And I type <intOp1> characters as option "Option 1*" into the "Q1" av
    And I type <intOp2> characters as option "Option 2*" into the "Q1" av
    Then I select "Option 2*" as the correct option in "Q1" av
    And I wait for 2 second av
    When I click on the button "Save" av

    And I wait for 1 second av
    Examples:
      | intQ | qNum | intOp1 | intOp2 |
      | 40   | "Q1" | 30     | 20     |
      | 1    | "Q1" | 20     | 30     |
      | 1001 | "Q1" | 1001   | 10     |
      | 1    | "Q1" | 1      | 1      |
      | 499  | "Q1" | 499    | 499    |

  @regression5
  Scenario: Quiz Random Title av
    When I click on the button "Create New Quiz" av
    And I wait for 2 second av
    When I create quiz title av
    And I wait for 2 second av
    When I add the question av
    Then I select "Single" type question av
    When I type question text as "" into "Q1" av
    And I type "Option 1" as option "Option 1*" into the "Q1" av
    And I type "Option 2" as option "Option 2*" into the "Q1" av
    Then I select "Option 2*" as the correct option in "Q1" av
    And I wait for 2 second av
    Then message with the "This field is required" should be displayed av
    And I wait for 2 second av
    

