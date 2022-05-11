@quiz
Feature: Quiz

  Background:
    Given I go to "login" page
    When I type "ask_instr@aol.com" into email field
    And I type "12345" into password field
    When I click button "Sign In"
    And I wait for 1 sec
    When I click "Quizzes" menu item
    And I wait for 2 sec

  @smoke
  Scenario: Create a quiz
    When I click button "Create New Quiz"
    And I wait for 1 sec
    When I type "00 Galina Demo Quiz" as quiz title
    And I add a question
    When I select "Single" question type
    When I type "Question 1" into "Q1"
    And I type "Option 1" as "Option 1*" into "Q1"
    And I type "Option 2" as "Option 2*" into "Q1"
    Then I select "Option 1*"  as correct option in "Q1"
    When I click button "Save"
    And I wait for 1 sec
    Then quiz "00 Galina Demo Quiz" is displayed on the list of quizzes
    And I delete quiz "00 Galina Demo Quiz"