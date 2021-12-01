@quiz @regression
Feature: Quiz Scenarios

  Background:
    Given I go to "login" page
    When I type "ask_instr@aol.com" into email field
    And I type "12345" into password field
    When I click "Sign In" button
    And I wait for 1 sec
    And I click on "Quizzes" link
    And I wait for 1 sec

  Scenario: Create a quiz
    When I click "Create New Quiz" button
    And I wait for 1 sec
    And I type "Galina Quiz" as quiz title
    When I add a question
    And I select "Single" question type
    And I wait for 1 sec
    When I type "Question 1" into "Q1"
    When I type "Option 1" as "Option 1*" into "Q1"
    When I type "Option 2" as "Option 2*" into "Q1"
    And I select "Option 2*" as correct option in "Q1"
    When I click "Save" button
    And I wait for 2 sec
    Then quiz "Galina Quiz" should be displayed on the list of quizzes
    And I delete "Galina Quiz" from the list of quizzes

