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


  @QuizTotalQuestionsTextualPositive
  Scenario: Max 50 questions (textual only)
    When I type "quiz_textual_test_50" as quiz title
    And I add "3" of "Textual" questions with "test_question" text AK
    And I click "Save" button
    And I wait for 2 sec
    Then title "quiz_textual_test_50" should be displayed on the list of quizzes
    And I delete quiz  "quiz_textual_test_50"

#  error is not implemented
  @Failing
  @QuizTotalQuestionsTextualNegative
  Scenario: Max 51 questions (textual only)
    When I type "quiz_textual_test_51" as quiz title
    And I add "51" of "Textual" questions with "test_question" text AK
    And I click "Save" button
    And I wait for 2 sec
    Then "number of questions exceeded" error message should be displayed AK

  @QuizTotalQuestionsSingleChoicePositive
  Scenario: Max 50 questions (single-choice only)
    When I type "quiz_single_choice_test_50" as quiz title
    And I add "50" of "Single-Choice" questions with "test_question" text AK
    And I click "Save" button
    And I wait for 2 sec
    Then title "quiz_single_choice_test_50" should be displayed on the list of quizzes
    And I delete quiz  "quiz_single_choice_test_50"


  #  error is not implemented
  @Failing
  @QuizTotalQuestionsSingleChoiceNegative
  Scenario: Max 51 questions (single-choice only)
    When I type "quiz_single_choice_test_51" as quiz title
    And I add "50" of "Single-Choice" questions with "test_question" text AK
    And I click "Save" button
    And I wait for 2 sec
    Then "number of questions exceeded" error message should be displayed AK



  @QuizTotalQuestionsMultChoicePositive
  Scenario: Max 50 questions (multiple-choice only)
    When I type "quiz_multiple_choice_test_50" as quiz title
    And I add "50" of "Multiple-Choice" questions with "test_question" text AK
    And I click "Save" button
    And I wait for 2 sec
    Then title "quiz_multiple_choice_test_50" should be displayed on the list of quizzes
    And I delete quiz  "quiz_multiple_choice_test_50"


  #  error is not implemented
  @Failing
  @QuizTotalQuestionsMultiChoiceNegative
  Scenario: Max 51 questions (multiple-choice only)
    When I type "quiz_multiple_choice_test_51" as quiz title
    And I add "51" of "Multiple-Choice" questions with "test_question" text AK
    And I click "Save" button
    And I wait for 2 sec
    Then "number of questions exceeded" error message should be displayed AK


  @QuizTotalQuestionsMultiTypePositive
  Scenario: Max 50 questions (multiple-type)
    When I type "quiz_multi_type_test_50" as quiz title
    And I add "4" of "MultiType" questions with "test_question" text AK
    And I click "Save" button
    And I wait for 2 sec
    Then title "quiz_multi_type_test_50" should be displayed on the list of quizzes
    And I delete quiz  "quiz_multi_type_test_50"



  #  error is not implemented
  @Failing
  @QuizTotalQuestionsMultiTypePositive
  Scenario: Max 51 questions (multiple-type)
    When I type "quiz_multi_type_test_51" as quiz title
    And I add "51" of "MultiType" questions with "test_question" text AK
    And I click "Save" button
    And I wait for 2 sec
    Then "number of questions exceeded" error message should be displayed AK
