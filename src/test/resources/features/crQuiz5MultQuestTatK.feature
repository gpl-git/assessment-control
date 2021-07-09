@quiz @regression
Feature: Quiz Scenarios with 5 Multiple-Choice questions

  Background:
    Given I go to "login" page
    When I type "zhossam@ardesy.com" into email field
    And I type "123456" into password field
    When I click on "Sign In" button
    And I wait for 1 sec
    Then I verify current url as "home"
    When I click on "Quizzes" tab
    And I wait for 1 sec

  @regression
  Scenario: Create a quiz with 5 Multiple-Choice questions
    When I click on "Create New Quiz" button
    And I wait for 1 sec
    And I type "TatianaK Quiz" as quiz title
    When I add a question
    And I select "Multiple-Choice" question type
    And I wait for 3 sec
    When I type question text "Question1" into "Q1"
    And I type "Option 1" as option "Option 1*" into "Q1"
    And I type "Option 2" as option "Option 2*" into "Q1"
    And I wait for 3 sec
    When I select "Option 2*" as a correct option in "Q1"
    And I wait for 3 sec
    When I click on "Save" button
    And I wait for 3 sec
    Then quiz "TatianaK Quiz" should be displayed on the list of quizzes
    And I wait for 1 sec
    And I delete "TatianaK Quiz" from the list of quizzes

  @quiz @regression
  Scenario: Quiz with 5 Multiple-Choice questions using loop
    When I click on "Create New Quiz" button
    And I wait for 3 sec
    And I create quiz title
    And I wait for 2 sec
    When I create quiz with 5 Multiple-Choice questions
    And I wait for 2 sec

