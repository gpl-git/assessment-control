@quiztitle

Feature: Quiz Title
  Background:
    Given I go to "ask"
    When I enter "ask_instr@aol.com" into email field
    And I enter "12345" into password field
    When I click "Sign In" button
    And I wait for 1 sec

  @quiztitle1
  Scenario: Verify that Title field accepts Alphanumeric & Special characters
    When I click on "Quizzes" button
    And I wait for 1 sec
    When I click "Create New Quiz" button
    And I wait for 1 sec
    And I type "Aa12&{}*3" in the Title field
    Then I click "Add Question"
    And I wait for 1 sec
    Then quiz page should be displayed
    When I clear Title field
    And I wait for 1 sec
    Then error message "This field is required" is displayed
    And I wait for 1 sec
