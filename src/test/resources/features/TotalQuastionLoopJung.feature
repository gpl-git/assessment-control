@Quiz-Total-Questions
Feature: Quiz Total Questions
  Background:
    Given I go to the "login" page
    When I type the "ask_instr@aol.com" into email field
    And I enter the "12345" as  password
    When I click the button "Sign In"
    And I wait for 1 sec[s]
    When I click on the "Quizzes" menu item
    And I wait for 1 sec[s]

  @Quiz1
  Scenario: Create a quiz with one question
    And I click the button "Create New Quiz"
    And I wait for 1 sec[s]
    When I type the "Test Quiz - Jung" as quiz title
    And I add the question
    And I wait for 5 sec[s]
    When I select the "Q1" question and "Textual" question type
    When I type the "What is Software Testing?" into "Q1"
    And I wait for 2 sec[s]
    And I click button "Save"
    And I wait for 1 sec[s]
    Then I check the quiz "Test Quiz - Jung" displayed on the list of quizzes
    And I wait for 1 sec[s]
    And I delete the "Test Quiz - Jung"

  @Quiz2
  Scenario: Create a quiz without any question
    And I click the button "Create New Quiz"
    And I wait for 1 sec[s]
    When I type the "Test Quiz - Jung" as quiz title
    And I add the question
    And I wait for 5 sec[s]
    And I click button "Save"
    And I can see the "Quiz is not completed" message
    And I wait for 1 sec[s]

  @Quiz3
  Scenario: Create a quiz with a total maximum numbers of question - 50 per quiz
    And I click the button "Create New Quiz"
    And I wait for 1 sec[s]
    When I type the "Test Quiz - Jung" as quiz title
    And I add the question
    And I wait for 1 sec[s]
    And I add up to 50 questions
    And I click button "Save"
    And I wait for 3 sec[s]
    Then I check the quiz "Test Quiz - Jung" displayed on the list of quizzes
    And I wait for 1 sec[s]
    And I delete the "Test Quiz - Jung"

  @Quiz4
  Scenario: Create a quiz with a 51 questions
    And I click the button "Create New Quiz"
    And I wait for 1 sec[s]
    When I type the "Test Quiz - Jung" as quiz title
    And I add the question
    And I wait for 1 sec[s]
    And I add up to 51 questions
    And I click button "Save"
    And I wait for 3 sec[s]
    Then I check the quiz "Test Quiz - Jung" displayed on the list of quizzes
    And I wait for 1 sec[s]
    And I delete the "Test Quiz - Jung"

