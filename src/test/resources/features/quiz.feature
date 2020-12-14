Feature: Quiz Scenarios

  Scenario: Quiz Single Choice Question
    Given I open "login"
    When I enter "ask_instr@aol.com" as email
    And I enter "12345" as password
    When I click "Sign In" button
    And I wait for 1 sec
    Then I verify that user role is equal to "TEACHER"
    And I click "Quizzes" link
    And I wait for 2 sec
    When I click "Create New Quiz" button
    And I wait for 1 sec
    And I type "Test Quiz Title" as title
    When I add a question
    And I select question type "Single"
    And I wait for 2 sec
    When I type "Question Test" into question"Q1" as "Question *"
    And I wait for 3 sec
    And I type "Option 1" into question"Q1" as "Option 1*"
    And I type "Option 2" into question"Q1" as "Option 2*"
    When I check "Option 2*" as correct in question "Q1"
    And I wait for 3 sec