@multiple_question
Feature: Multiple question
  Scenario: Multiple choice question should contain 2-15 options
    Given I open "login"
    When I enter "tatiana.verovkina@gmail.com" as email
    And I enter "12345" as password
    When I click "Sign In" button
    And I wait for 1 sec
    Then I verify that user role is equal to "TEACHER"
    And I click "Quizzes" link
    And I wait for 2 sec
    When I click "Create New Quiz" button
    And I wait for 1 sec
    And I type "Multiple-choice Quiz5" as title
    When I add a question
    And I select question type "Multiple"
    And I wait for 2 sec
    When I type "Test" into question"Q1" as "Question *"
    And I wait for 2 sec
    And I type "Option 1" into question"Q1" as "Option 1*"
    When I mark "Option 1*" as correct in question "Q1"
    And I type "Option 2" into question"Q1" as "Option 2*"
    When I mark "Option 2*" as correct in question "Q2"
    And I click on settings
    And I verify the "Delete option" option is disabled
    And I wait for 1 sec
    And I create 16 options as "Option *" in the field "Option "
    And I wait for 3 sec
    And I click "Save" button
    And I wait for 2 sec
    And I click "Quizzes" in Menu
    Then I verify quiz "Multiple-choice Quiz5" with 16 options





