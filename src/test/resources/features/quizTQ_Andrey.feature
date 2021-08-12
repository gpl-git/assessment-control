@quizTQ
Feature: Quiz - Total Questions Scenarios
#  Automation Test Set JUL-128


  Background:
    Given I open "login" page
    When I type "ask_instr@aol.com" into email field
    And I type "12345" into password field
    When click on "Sign In" button
    And I wait for 1 sec
    Then I click "Quizzes" link
    And I wait for 1 sec
    And click on "Create New Quiz" button
    And I wait for 2 sec

  @quizTQ1
  Scenario: JUL-129. Verify the Quiz with minimum number of questions (1) can be created
    When I type "! Quiz1" as a quiz title
    And I add a question
    When I select "Textual" question in question "Q1"
    And I type "Question 1" as question text into question "Q1"
    And I wait for 1 sec
    When click on "Save" button
    And I wait for 1 sec
    Then "! Quiz1" should be displayed on the list of quizzes
    And I delete "! Quiz1" from the list of quizzes

  @quizTQ2
  Scenario: JUL-132. Verify the Quiz with number of questions 5 can be created
    When I type "! Quiz2" as a quiz title
    Then I am creating 5 "Textual" questions
    And click on "Save" button
    And I wait for 1 sec
    Then "! Quiz2" should be displayed on the list of quizzes
    And I delete "! Quiz2" from the list of quizzes

  @quizTQ3
  Scenario: JUL-133. Verify the Quiz with number of questions 50 can be created
    When I type "! Quiz3" as a quiz title
    Then I am creating 50 "Textual" questions
    And click on "Save" button
    And I wait for 2 sec
    Then "! Quiz3" should be displayed on the list of quizzes
    And I delete "! Quiz3" from the list of quizzes

  @quizTQ4 @ignore
  Scenario: JUL-135. Verify the Quiz with number of questions 51 cannot be created
#    Opened bug JUL-180
    When I type "! Quiz4" as a quiz title
    Then I am creating 51 "Textual" questions
    And click on "Save" button
    And I wait for 2 sec
    Then "! Quiz4" should be displayed on the list of quizzes
    And I delete "! Quiz4" from the list of quizzes

  @quizTQ5
  Scenario: JUL-138. Verify the total number of Questions is displayed on Preview Mode page while creating a new Quiz
    When I type "! Quiz5" as a quiz title
    Then I am creating 3 "Textual" questions
    And click on "Preview" button
    And I wait for 2 sec
    Then Question 3 should be displayed on the list of preview mode
    And click on "Close" button
    And click on "Save" button
    And I wait for 1 sec
    And I delete "! Quiz5" from the list of quizzes

  @quizTQ6
  Scenario: JUL-140. Verify the total number of Questions is displayed in the List of Quizzes next to the Quiz Title
    When I type "! Quiz6" as a quiz title
    Then I am creating 3 "Textual" questions
    And click on "Save" button
    And I wait for 1 sec
    Then 3 total number of Questions for "! Quiz6" should be displayed on the list of quizzes
    And I delete "! Quiz6" from the list of quizzes