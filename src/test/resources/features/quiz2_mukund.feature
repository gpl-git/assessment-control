@quiz2_sample
Feature: Quiz Sample Creation
  Background:
    Given I go to "login" page m
    When I type "muksw@hotmail.com" into email field m
    And I type "12345" into password field m
    When I click "Sign In" button m
    And I wait for 1 sec
    And I click "Quizzes" menu item m
    And I wait for 1 sec
    When I click "Create New Quiz" button
    And I wait for 2 sec

  @quiz2_sample
  Scenario: Creation of quiz
    When I type "Quiz Sample" as quiz title m
    And I add a question m
    When I select "Single" question type m
    And I type "Question 1" into question field of "Q1" m
    When I type "Option 1" into "Option 1" option field of "Q1" m
    When I type "Option 2" into "Option 2" option field of "Q1" m
    When I select "Option 1" as a correct option in "Q1" m
    And I click "Save" button m
    And I wait for 1 sec
    Then "Quiz Sample" is displayed on the list of quizzes m
    And I delete "Quiz Sample" from the list of quizzes m
