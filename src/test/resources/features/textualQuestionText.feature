@smoke
Feature: Textual Question Text
  Background:
    Given I open "login" page
    When I login as Teacher with credentials "ask_instr@aol.com" and "12345"
    When I click "Sign In" button

  Scenario: Textual Question: Text - Alphanumeric&Special characters
    And I click "Quizzes" link
    And I wait for 2 sec
    And I click "Create New Quiz" button
    And I type "Test" in the Title of the quiz
    And I click to add Option
    Then I select "Textual" type
    When I type "abhjkk!@#$%^&*()" in the Question field
    And I click "Save" button to save quiz
    Then "List of Quizzes" is displayed

  Scenario: Textual Question: Text - The field is required
    And I click "Quizzes" link
    And I wait for 2 sec
    And I click "Create New Quiz" button
    And I type "Test" in the Title of the quiz
    And I click to add Option
    Then I select "Textual" type
    When I click "Save" button to save quiz
    And I get error message "This field is required"

  Scenario: Textual Question: Text - Minimum 1 character
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

  Scenario: Textual Question: Text - Maximum 1000 characters
    And I click "Quizzes" link
    And I wait for 2 sec
    And I click "Create New Quiz" button
    And I type "Test" in the Title of the quiz
    And I click to add Option
    Then I select "Textual" type
    When I type "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaghtytyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyttttt ty65 65y 65455 44 4t 654t 565t 65y yyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyyy  66666666666666666666666yyyy6666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666666" in the Question field
    And I click "Save" button to save quiz
    And I wait for 3 sec
    Then "List of Quizzes" is displayed
    And I wait for 3 sec




