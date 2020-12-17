@singlechoice
Feature: Single Choice Question - Show-Stopper

  @showstopper
  Scenario: Verify Quiz is created as Show-stopper
    Given I open "login"
    When I enter "ask_instr@aol.com" as email
    And I enter "12345" as password
    When I click "Sign In" button
    And I wait for 3 sec
    Then I verify that user role is equal to "TEACHER"
    And I click "Quizzes" link
    And I wait for 4 sec
    When I click "Create New Quiz" button
    And I wait for 4 sec
    And I type "Quiz_Shilpa" as title
    When I add a question
    And I select question type "Single"
    And I wait for 2 sec
    When I type "Select option 1" into question"Q1" as "Question *"
    And I wait for 3 sec
    And I type "Option 1" into question"Q1" as "Option 1*"
    And I type "Option 2" into question"Q1" as "Option 2*"
    When I check "Option 1*" as correct in question "Q1"
    And I wait for 3 sec
    When I select the Show-stopper question checkbox
    And I wait for 3 sec
    Then "*" should be displayed on the question
    And I wait for 5 sec
    And I click "Save" button
    And I wait for 4 sec
    Then List of Quizzes should be displayed
    And "Quiz_Shilpa" question should be displayed in the list of quizzes
    When I select "Quiz_Shilpa" from the list
    And I click the Preview button
    And I wait for 4 sec
    Then  "Show-Stopper Question" text should be displayed













