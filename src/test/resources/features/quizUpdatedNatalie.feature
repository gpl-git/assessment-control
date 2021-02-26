@ask
Feature: Logging in ask application
  Background:
    Given I navigate to site "Ask"

  @ask1
  Scenario: Logging in with valid credentials
    When I enter "ask_instr@aol.com" into email field
    And I enter "12345" into password field
    And I click "Sign In" button NZ
    And I wait for 1 sec
    When I go to the page "Quizzes" and validate page details
    And I wait for 1 sec
    And I click "Create New Quiz" button NZ
    And I wait for 1 sec
    And I enter "QuizCreatedAt" into quiz title field
    And I add a question
    And I wait for 1 sec
    When I select "Textual" question
    And I wait for 1 sec
    When I type "ABC" into "Q1" question input field
    And I wait for 1 sec
    And I click "Save" button
    And I wait for 2 sec
    When I update "QuizCreatedAt" quiz NZ
    And I wait for 5 sec
    And I enter "Update" into quiz title field
    And I click "Save" button
    And I wait for 2 sec
    Then I verify "QuizCreatedAtUpdate" was updated NZ
    And I delete "QuizCreatedAtUpdate" quiz NZ




