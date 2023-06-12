@quiz_sample
Feature: Quiz Creation Sample
  Background:
    Given I go to "login" page
    When I type "ask_instr@aol.com" into email field
    And I type "12345" into password field
    When I click "Sign In" button
    And I wait for 1 sec
    And I click "Quizzes" menu item
    And I wait for 1 sec
    When I click "Create New Quiz" button
    And I wait for 2 sec
    
  @quiz_sample1
  Scenario: Create a quiz
    When I type "Quiz Sample" as quiz title
    And I add a question
    When I select "Single" question type
    And I type "Question 1" into question field of "Q1"
    When I type "Option 1" into "Option 1" option field of "Q1"
    And I type "Option 2" into "Option 2" option field of "Q1"
    When I select "Option 1" as a correct option in "Q1"
    And I click "Save" button
    And I wait for 1 sec
    Then "Quiz Sample" is displayed on the list of quizzes
    And I delete "Quiz Sample" from the list of quizzes
