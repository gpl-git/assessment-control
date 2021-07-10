@smoke
Feature: Quiz total questions scenarios

  Background:
    Given I go to "login" page
    When I type "qa1@askproject.com" into email field
    And I type "12345" into password field
    When I click on "Sign In" button
    And I wait for 3 sec
    Then I verify current url as "home"
    When I click on "Quizzes" tab
    And I wait for 3 sec

  @smoke1
  Scenario: Create a single-choice quiz
    When I click on "Create New Quiz" button
    And I wait for 3 sec
    And I type "Sergey Quiz" as quiz title
    When I add a new question
    And I select "Single" question type
    When I type question text "Question 1" into "Q1"
    And I type "Option 1" as option "Option 1*" into "Q1"
    And I type "Option 2" as option "Option 2*" into "Q1"
    When I select "Option 2*" as correct option in "Q1"
    And I wait for 3 sec
    When I click on "Save" button
    And I wait for 3 sec
    And I verify the number of questions of "Sergey Quiz"
    Then quiz "Sergey Quiz" should be displayed on the list of quizzes
    And I delete "Sergey Quiz" from the list of quizzes

    @smoke2
    Scenario: Create a multiple-choice quiz
      When I click on "Create New Quiz" button
      And I wait for 3 sec
      And I type "Sergey Quiz" as quiz title
      When I add a new question
      And I select "Multiple" question type
      When I type question text "Question 1" into "Q1"
      And I type "Option 1" as option "Option 1*" into "Q1"
      And I type "Option 2" as option "Option 2*" into "Q1"
      When I click on "Add Option" button
      And I type "Option 3" as option "Option 3*" into "Q1"
      When I check "Option 3*" check-box as correct option in "Q1"
      When I click on "Save" button
      And I wait untill Quizzes page is fully loaded by "Create New Quiz" button
      And I verify the number of questions of "Sergey Quiz"
      Then quiz "Sergey Quiz" should be displayed on the list of quizzes
      And I delete "Sergey Quiz" from the list of quizzes
