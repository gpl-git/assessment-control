@multiple
Feature: Multiple Choice Question - Option

  Background:
    Given I go to "login" page
    When I type "ask_instr@aol.com" into email field
    And I type "12345" into password field
    When I click on "Sign In" button
    And I wait for 1 sec
    Then I verify current url as "home"
    When I click on "Quizzes" tab
    And I wait for 1 sec

  @multiple1
  Scenario: Max 1000 characters allowed
    When I click on "Create New Quiz" button
    And I type "Quiz" as quiz title
    When I add a question
    And I select "Multiple" question type
    When I type question text "hbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgc" into "Q1"
    And I wait for 1 sec
    And I type "Option 1" as option "Option 1*" into "Q1"
    And I type "Option 2" as option "Option 2*" into "Q1"
    When I select "Option 2*" as correct option in "Q1"
    And I wait for 4 sec
