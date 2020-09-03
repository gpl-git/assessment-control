Feature: Textual Question Text
  Scenario: Textual Question Text
    Given I open "login" page
    When I login as Teacher with credentials "ask_instr@aol.com" and "12345"
    When I click "Sign In" button
    And I click "Quizzes" link
    And I click "Create New Quiz" button
    And I type "Test" in the Title of the quiz

