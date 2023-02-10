@QuizTotalQuestions
Feature: QuizTotalQuestions
  Background: QuizTotalQuestionsCommon
    Given I open "login" website
    When I type "ask_instr@aol.com" into email field
    When  I type "12345" into password field
    And I click "Sign In" button
    And I wait for 1 sec
    When I click "Quizzes" menu item
    And I wait for 1 sec
    And I click "Create New Quiz" button
    And I wait for 1 sec

    @QuizTotalQuestions
    Scenario: Max 50 questions (textual only)
      When I type "quiz_textual_test_50" as quiz title
      And I add "50" of "Textual" questions with "test_question" text AK
      And I click "Save" button
      And I wait for 2 sec
      Then title "quiz_textual_test" should be displayed on the list of quizzes

  @QuizTotalQuestions
  Scenario: Max 50+1 questions (textual only)
    When I type "quiz_textual_test_51" as quiz title
    And I add "51" of "Textual" questions with "test_question" text AK
    And I click "Save" button
    And I wait for 2 sec
    Then "number of questions exceeded" error message should be displayed AK

  @QuizTotalQuestions
  Scenario: Max 50 questions (single-choice only)
    When I type "quiz_single_choice_test_test_50" as quiz title
    And I add "50" of "Single-Choice" questions with "test_question" text AK
    And I click "Save" button
    And I wait for 2 sec
    Then title "quiz_textual_test" should be displayed on the list of quizzes

  @QuizTotalQuestions
  Scenario: Max 51 questions (single-choice only)
    When I type "quiz_single_choice_test_test_51" as quiz title
    And I add "50" of "Single-Choice" questions with "test_question" text AK
    And I click "Save" button
    And I wait for 2 sec
    Then "number of questions exceeded" error message should be displayed AK
