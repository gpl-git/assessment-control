@quiztotalquestions
Feature: Quiz -Total Questions

  Background:
    Given I start measuring the execution time
    When I set title for quiz as "AS-647: Quiz - Total Questions"
    And I go to "login" page
    And I wait for 2 seconds
    And I type "rocoy88862@ateampc.com" into Email field and "647647" into Password field
    And I click on "Sign In" button
    And I wait for 2 seconds
    Then menu with the item "Home" should be appear
    And I sure that I logged as a "TEACHER"

  @quiztotalquestions1
  Scenario: Maximum number of questions (50), according to AS-106 and AS-259
    When I click on menu item "Quizzes"
    And I wait for 2 seconds
    And I click on "Create New Quiz" button
    And I wait for 2 seconds
    And I type "titleGiven" into field Title Of The Quiz
    And I wait for 2 seconds
    And I create 51 "Single" questions with two options
    And I click on "Save" button
      #Bug AS-251 - Teacher creates a quiz with more then 50 questions and saves it and works.
    Then List of Quizzes should not be appear

  @quiztotalquestions2
  Scenario: Minimum number of questions (1), according to AS-258
    When I click on menu item "Quizzes"
    And I wait for 1 seconds
    And I click on "Create New Quiz" button
    And I wait for 1 seconds
    And I type "titleGiven" into field Title Of The Quiz
    And I wait for 1 seconds
    And I create 1 "Single" questions with two options
    And I click on "Save" button
    And I wait for 2 seconds
    Then List of Quizzes should be appear

  @quiztotalquestions3
  Scenario: List of quizzes: number of questions, according AS-324  and Expansion indicator: quiz, according AS-325
    When I click on menu item "Quizzes"
    And I wait for 1 seconds
    Then List of Quizzes should be appear
    And I wait for 1 seconds
    And quiz "titleGiven" should be in the list
    And I wait for 1 seconds
    When I expand row clicking by "titleGiven"
    And I wait for 1 seconds
    Then number of question in row is equal number in the expanded area for "titleGiven"

  @quiztotalquestions4
  Scenario: Delete quiz after testing
    When I delete all instances of "titleGiven"
    Then I get total execution time
#    And I stop here to analyse
    And I wait for 3 seconds

