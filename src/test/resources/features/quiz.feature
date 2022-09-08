@quiz @smoke
Feature:  Quiz Scenarios

  Background:
    Given I go to "login" page
    When I type "ask_instr@aol.com" into email field
    And I type "12345" into password field
    When I click "Sign In" button
    And I wait for 1 sec
    When I click "Quizzes" menu item
    And I wait for 1 sec
  @quiz1
  Scenario: Create a Quiz
    When I click "Create New Quiz" button
    And I wait for 1 sec
    When I type "000 UI Automation - Galina" as quiz title
    And I add a question
    When I select "Single" question type
    When I enter "Question 1 Text" into "Q1"
    And I type "Option 1" as "Option 1*" into "Q1"
    And I type "Option2" as "Option 2*" into "Q1"
    When I select "Option 2*" as correct option in "Q1"
    When I click "Save" button
    And I wait for 1 sec
    Then I verify that "000 UI Automation - Galina" is displayed on the list of quizzes
    And I wait for 3 sec
    And I delete "000 UI Automation - Galina" from the list of quizzes
