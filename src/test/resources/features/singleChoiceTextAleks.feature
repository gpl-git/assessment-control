@singeChoiceText

Feature: Single choice question text
  Background:
    Given I go to "ask"
    When I enter "ask_instr@aol.com" into email field
    And I enter "12345" into password field
    When I click "Sign In" button
    And I wait for 1 sec
  Scenario: Single choice Question - text: accepts Alphanumeric & Special character
    And I go to the page "Quizzes" and validate page details
    And I wait for 1 sec
    When I click "Create New Quiz" button
    And I wait for 2 sec
    And I enter "Single Choice Text automation" into quiz title field
    When I add a question
    And I wait for 1 sec
    Then I select "Single-Choice" question
    And I wait for 1 sec
    And I type "Qwerty@#$@!$#221" into "Q1" question input field
    And I wait for 1 sec
    And I click on "option 1" radiobutton for correct answer
    And I type "bla&^%#$" into "Option 1" text field
    And I type "alb@!@#$%" into "Option 2" text field
    And I click on "Save" button






















