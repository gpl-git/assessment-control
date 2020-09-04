@smoke
Feature: Textual Question Text

  Scenario: Textual Question: Text - The field is required
    Given I open "login" page
    When I login as Teacher with credentials "ask_instr@aol.com" and "12345"
    When I click "Sign In" button
    And I click "Quizzes" link
    And I wait for 2 sec
    And I click "Create New Quiz" button
    And I type "Test" in the Title of the quiz
    And I click to add Option
    Then I select "Textual" type
    When I click "Save" button to save quiz
    And I get error message "This field is required"

  Scenario: Textual Question: Text - Minimum 1 character
    Given I open "login" page
    When I login as Teacher with credentials "ask_instr@aol.com" and "12345"
    When I click "Sign In" button
    And I click "Quizzes" link
    And I wait for 2 sec
    And I click "Create New Quiz" button
    And I type "Test" in the Title of the quiz
    And I click to add Option
    Then I select "Textual" type
    When I type "s" in the Question field
    And I click "Save" button to save quiz
    And I wait for 3 sec
    Then "List of Quizzes" is displayed
    And I wait for 3 sec

