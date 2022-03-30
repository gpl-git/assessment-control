@Quiz-Show-Stopper
Feature: Quiz-Show-Stopper Scenarios
  Background:
#    Background: Create quiz with one question
    Given I go to the login "http://ask-qa.portnov.com/#/login" page
    When I type "daniil7142@gmail.com" to the email
    And I type "ask1!" to the password
    When I click to the "Sign In" button
    When I click to the "Quizzes" button
    And I click to the "Create New Quiz" button
    When I type "Show-Stopper-Quiz" to the quiz title
#    next step Add Questions
    Then I click to the "add_circle" button
#        Then I pick question type by clicking on type: Textual,Single-Choice,Multiple-Choice
    And I select question type "Single-Choice" for question 1
#    Then I click "Single-Choice" button
    When I type to the "Q1" text of question "Question 1"
    And I type to the question number "Q1" for option number "Option 1*"   question answer "Answer1"
    And I type to the question number "Q1" for option number "Option 2*"   question answer "Answer2"
    Then I select from question number "Q1" option number "Option 1*" as correct option
#    mark and assert "Show-Stopper"
    Then I mark "Q1" as "Show-Stopper"
    And  I assert if question marked as Show-Stopper


  Scenario: Create a One Question Quiz  Show-Stopper
    And I click to the "Save" button
    When assert that quiz title "Show-Stopper-Quiz" displayed on list of quizzes
    Then I click on title "Show-Stopper-Quiz"
    Then I Preview "Show-Stopper-Quiz" quiz
    And I assert that question in quiz marked as "Show-Stopper Question"
    And I click to the "Close" button
    And I delete the quiz "Show-Stopper-Quiz"
#    Then I assert that quiz title "Show-Stopper-Quiz" NOT displayed on list of quizzes

  Scenario: Two Questions cannot be  Show-Stopper at the same time
    #    next step Add Questions
    Then I click to the "add_circle" button
    #        Then I pick question type by clicking on type: Textual,Single-Choice,Multiple-Choice
    And I select question type "Single-Choice" for question 2
#    Then I click "Single-Choice" button
    When I type to the "Q2" text of question "Question 2"
    And I type to the question number "Q2" for option number "Option 1*"   question answer "Answer1"
    And I type to the question number "Q2" for option number "Option 2*"   question answer "Answer2"
    Then I select from question number "Q2" option number "Option 1*" as correct option
#    mark and assert "Show-Stopper"
    Then I mark "Q2" as "Show-Stopper"
    Then I navigate back to "Q1"
#  I verify that @class for unchecked show stopper option are present
    And I verify Qone is not checked as show stopper
    And I click to the "Save" button
    And I wait for 2 sec
    When assert that quiz title "Show-Stopper-Quiz" displayed on list of quizzes
    Then I click on title "Show-Stopper-Quiz"
    Then I Preview "Show-Stopper-Quiz" quiz
    And I assert that question in quiz marked as "Show-Stopper Question"
    And I click to the "Close" button
    And I delete the quiz "Show-Stopper-Quiz"
