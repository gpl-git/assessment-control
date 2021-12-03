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
  Scenario: Max allowed 15 option choices
    When I type "Question 1" into "Q1"
    When I type "Option 1" as "Option 1*" into "Q1"
    When I type "Option 2" as "Option 2*" into "Q1"
    When I add 13 new option to "Q1"
    And I wait for 2 sec
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
  Scenario: For Option 1: Settings-Move option up should be disabled
    When I type "Question 1" into "Q1"
    And I click on "settings" in "Option 1*" in question "Q1"
    Then element "Move option up" should be disabled
    And I wait for 2 sec

  @options6
  Scenario: For Option 2: Settings-Move option up should switch texts of option 1 and option 2
    When I type "Question 1" into "Q1"
    When I type "Option 1" as "Option 1*" into "Q1"
    When I type "Option 2" as "Option 2*" into "Q1"
    And I click on "settings" in "Option 2*" in question "Q1"
    And I wait for 2 sec
    And I click "Move option up" button
    And I wait for 2 sec
    Then The sample in "Option 1*" should have "Option 2" in "Q1"

  @options7
  Scenario: Options cannot be empty
    When I type "Question 1" into "Q1"
    And I select "Option 2*" as correct option in "Q1"
    When I click "Save" button
    And I wait for 2 sec
    Then The error message "Quiz is not completed." should be displayed

  @options8
  Scenario: Options cannot be filled only with white space
    When I type "Question 1" into "Q1"
    When I type " " as "Option 1*" into "Q1"
    When I type " " as "Option 2*" into "Q1"
    And I select "Option 2*" as correct option in "Q1"
    When I click "Save" button
    And I wait for 2 sec
    Then The error message "Quiz is not completed." should be displayed

