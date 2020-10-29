@quiz-tq
Feature: Quiz-Total Questions Scenarios

  Background:
    Given I navigate to "Sign In" page
    When I "Sign In" with email: "ask_instr@aol.com" and password: "12345"
    Then I check that the "Home" page is open
    And I check user role as "teacher"
    When I click "Quizzes" link
    Then I check that the "List of Quizzes" is displayed
    When I click "Create New Quiz" button
    Then I check that the "Title Of The Quiz" is visible
    When I enter "Types of testing" with timestamp as a quiz title
    And I add question
    Then I check that the "new empty question" is visible

  @quiz-tq1
  Scenario Outline: 1/25/50/51 Textual/Single/Multiple Question Submitted
    When I create <questionsNumber> question as a <type> question type with a question title: "What is regression testing?" and with an answer for Option1: "regression 1", answer for Option2: "regression 2"
    And I click "Save" button
    Then I check that the "List of Quizzes" is displayed
    And I check that the created quiz with timestamp is visible in the List of Quizzes
    When I expand my quiz
    Then I compare the number of Total Questions to the number of questions we have created
    And I check that it is not possible to create more than 50 questions in one quiz as per current requirements
    When I click "Delete" button on my quiz

    Examples:
      | questionsNumber | type       |
      | 1               | "Textual"  |
      | 25              | "Textual"  |
      | 50              | "Textual"  |
      | 51              | "Textual"  |
      | 1               | "Single"   |
      | 25              | "Single"   |
      | 50              | "Single"   |
      | 51              | "Single"   |
      | 1               | "Multiple" |
      | 25              | "Multiple" |
      | 50              | "Multiple" |
      | 51              | "Multiple" |