@options @regression
Feature: Single Choice Questions Options

  Background:
    Given I go to "login" page
    When I type "2tvhrtjhvrtc@dallassalons.com" into email field
    And I type "12345" into password field
    When I click "Sign In" button
    And I wait for 1 sec
    And I click on "Quizzes" link
    And I wait for 1 sec
    When I click "Create New Quiz" button
    And I wait for 1 sec
    And I type "Aslanbek Quiz" as quiz title
    When I add a question
    And I select "Single" question type
    And I wait for 1 sec

  @options1
  Scenario: Max 15 choices
    When I type "Question 1" into "Q1"
    When I type "Option 1" as "Option 1*" into "Q1"
    When I type "Option 2" as "Option 2*" into "Q1"
    When I add 13 new option to "Q1"
    And I wait for 2 sec
    When I type "Option 3" as "Option 3*" into "Q1"
    When I type "Option 4" as "Option 4*" into "Q1"
    When I type "Option 5" as "Option 5*" into "Q1"
    When I type "Option 6" as "Option 6*" into "Q1"
    When I type "Option 7" as "Option 7*" into "Q1"
    When I type "Option 8" as "Option 8*" into "Q1"
    When I type "Option 9" as "Option 9*" into "Q1"
    When I type "Option 10" as "Option 10*" into "Q1"
    When I type "Option 11" as "Option 11*" into "Q1"
    When I type "Option 12" as "Option 12*" into "Q1"
    When I type "Option 13" as "Option 13*" into "Q1"
    When I type "Option 14" as "Option 14*" into "Q1"
    When I type "Option 15" as "Option 15*" into "Q1"
    And I select "Option 2*" as correct option in "Q1"
    When I click "Save" button
    And I wait for 2 sec
    Then quiz "Aslanbek Quiz" should be displayed on the list of quizzes
    And I delete "Aslanbek Quiz" from the list of quizzes

  @options2
  Scenario: Options exceeding maximum limit not accepted
    When I type "Question 1" into "Q1"
    When I type "Option 1" as "Option 1*" into "Q1"
    When I type "Option 2" as "Option 2*" into "Q1"
    When I add 14 new option to "Q1"
    And I wait for 2 sec
    When I type "Option 3" as "Option 3*" into "Q1"
    When I type "Option 4" as "Option 4*" into "Q1"
    When I type "Option 5" as "Option 5*" into "Q1"
    When I type "Option 6" as "Option 6*" into "Q1"
    When I type "Option 7" as "Option 7*" into "Q1"
    When I type "Option 8" as "Option 8*" into "Q1"
    When I type "Option 9" as "Option 9*" into "Q1"
    When I type "Option 10" as "Option 10*" into "Q1"
    When I type "Option 11" as "Option 11*" into "Q1"
    When I type "Option 12" as "Option 12*" into "Q1"
    When I type "Option 13" as "Option 13*" into "Q1"
    When I type "Option 14" as "Option 14*" into "Q1"
    When I type "Option 15" as "Option 15*" into "Q1"
    When I type "Option 16" as "Option 16*" into "Q1"
    And I select "Option 2*" as correct option in "Q1"
    When I click "Save" button
    And I wait for 2 sec
    Then quiz "Aslanbek Quiz" should not be displayed on the list of quizzes
    And I delete "Aslanbek Quiz" from the list of quizzes


  @options3
  Scenario: Minimum 2 options
    When I type "Question 1" into "Q1"
    When I type "Option 1" as "Option 1*" into "Q1"
    When I type "Option 2" as "Option 2*" into "Q1"
    And I select "Option 2*" as correct option in "Q1"
    When I click "Save" button
    And I wait for 2 sec
    Then quiz "Aslanbek Quiz" should be displayed on the list of quizzes
    And I delete "Aslanbek Quiz" from the list of quizzes


  @options4
  Scenario: Need to choose at least one correct answer
    When I type "Question 1" into "Q1"
    When I type "Option 1" as "Option 1*" into "Q1"
    When I type "Option 2" as "Option 2*" into "Q1"
    When I add 1 new option to "Q1"
    When I type "Option 3" as "Option 3*" into "Q1"
    When I click "Save" button
    And I wait for 1 sec
    Then The error message "Quiz is not completed." should be displayed

  @options5
  Scenario: Option 1: Settings-Move option up
    When I type "Question 1" into "Q1"
    And I click on "settings" in "Option 1*" in question "Q1"
    Then element "Move option up" should be disabled
    And I wait for 2 sec

  @options6
  Scenario: Option 2: Settings-Move option up
    When I type "Question 1" into "Q1"
    When I type "Option 1" as "Option 1*" into "Q1"
    When I type "Option 2" as "Option 2*" into "Q1"
    And I click on "settings" in "Option 2*" in question "Q1"
    And I wait for 2 sec
    And I click on "Move option up" button
    And I wait for 2 sec
