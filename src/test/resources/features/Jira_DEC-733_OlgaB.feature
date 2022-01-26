
@textual
Feature: Jira task DEC-733 Verify Textual Question in Quizzes
 Background:
    Given I go to "login" page
    When I type "andrewdocksey@ecallen.com" into email field
    And I type "password" into password field
    When  I click "Sign In" button
    And I wait for 2 sec
    When I click "Quizzes" link
    And I wait for 3 sec

  @textual1
  Scenario: Creating a Quiz
    When I click "Create New Quiz" button
    And I wait for 1 sec
    And I type "OBQuiz" as the quiz title
    And I add a question
    And I select "Textual" question type
    When I type "What's your name?" into "Q1"
    And I wait for 3 sec
    And I click "Save" button
    And I wait for 2 sec
    Then quiz "OBQuiz" should be displayed on the list of quizzes
    And I delete "OBQuiz"
