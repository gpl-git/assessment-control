@predefined
Feature: Multiple Choice Question - Options

  Background:
    Given I open "login" page
    When I type "ask_instr@aol.com" into email field
    And I type "12345" into the password field
    When I click "Sign In" button
    And I wait for 1 sec
    When I click on "Quizzes" menu
    And I wait for 1 sec
    And I check and delete existed quizzes with name "Dmitry K Multiple Choice Options Quiz"

  @predefined1
  Scenario: Multiple Choice Option Field Accepts 1000 characters (maximum)
    When I click "Create New Quiz" button
    And I wait for 2 sec
    When I type "Dmitry K Multiple Choice Options Quiz" as quiz title
    And I add a question
    When I select "Multiple-Choice" question type
    And I wait for 2 sec
    And I type "Multiple Choice Question 1" into "Q1"
    When I checked "Option 1"
    And I checked "Option 2"
    And Input test-data 1000 chars into field "Option 1"
    And Input test-data 1000 chars into field "Option 2"
    When I push button "Save"
    And I wait for 1 sec
    Then "Dmitry K Multiple Choice Options Quiz" is displayed on the list of quizzes
    And I wait for 1 sec
    And I delete "Dmitry K Multiple Choice Options Quiz" from the list of quizzes


  @predefined2
  Scenario: Multiple Choice Options Field Doesn't Accepts 1000+1 char (max char + 1)
    When I click "Create New Quiz" button
    And I wait for 2 sec
    When I type "Dmitry K Multiple Choice Options Quiz" as quiz title
    And I add a question
    When I select "Multiple-Choice" question type
    And I wait for 2 sec
    And I type "Multiple Choice Question 1" into "Q1"
    When I checked "Option 1"
    And I checked "Option 2"
    And Input test-data 1001 chars into field "Option 1"
    And Input test-data 1001 chars into field "Option 2"
    When I push button "Save"
    And I wait for 1 sec
    Then "Dmitry K Multiple Choice Options Quiz" is not displayed on the list of quizzes


