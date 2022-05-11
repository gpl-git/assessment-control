@mcq_other
Feature: Multiple Choice Question - Other

  Background:
    Given I go to "login" page
    When I type "ask_instr@aol.com" into email field
    And I type "12345" into password field
    When I click button "Sign In"
    And I wait for 1 sec
    When I click "Quizzes" menu item
    And I wait for 2 sec

  @mcq_other
  Scenario: Include "Other" text area option
    When I click button "Create New Quiz"
    And I wait for 1 sec
    When I type "00 Galina Demo Quiz" as quiz title
    And I add quiz question
    When I click "Multiple-Choice" question type
    When I type "Question 1" into "Q1"
    And I type "Option 1" as "Option 1*" into "Q1"
    And I type "Option 2" as "Option 2*" into "Q1"
    And I wait for 2 sec
    And I check "Option 2*" as correct  in question "Q1"
    And I click  Include other option
    When I click button "Save"
    And I wait for 2 sec
    Then quiz "00 Galina Demo Quiz" is displayed on the list of quizzes
    And I wait for 2 sec
    And I preview quiz "00 Galina Demo Quiz"
    And I wait for 2 sec
    And The option  "other" will be displayed
    And I close quiz
    And I delete quiz title "00 Galina Demo Quiz"
    And I wait for 2 sec
    





