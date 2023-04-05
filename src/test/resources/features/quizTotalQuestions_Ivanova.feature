# Automate Test-Set FEB23-151 Quiz-Total Questions
@totalQuestions
Feature: Quiz-Total Questions
  Background:
    Given I go to "login" page
    When I type "ask_instr@aol.com" into email field
    And I type "12345" into password field
    When I click "Sign In" button
    And I wait for 1 sec
    When I click "Quizzes" menu item
    And I wait for 1 sec
    And I click "Create New Quiz" button
    And I wait for 1 sec

#    Create Textual or Single-Choice quiz with 1 question and verify Total number of question in quiz card
  @totalQuestions1
  Scenario Outline: Quiz allows 1 question
    When I type <title> in title field
    Then I create <numOfQuestion> <questionType> questions with text <questionText>
    And I click "Save" button
    And I wait for 2 sec
    Then title <title> is displayed on the list of quizzes
    And quiz <title> should have <qnum> total questions
    And I delete <title>

    Examples:
      | title                                   | numOfQuestion | questionType    | questionText | qnum |
      | "RS Quiz with 1 Textual question"       | 1             | "Textual"       | "Question "  | "1"  |
#      | "RS Quiz with 1 SC question"            | 1             | "Single-Choice" | "Question "  | "1"  |


#  Create Textual or Single-Choise quiz with 50 questions and verify Total number of questions in quiz card
  @totalQuestions2
  Scenario Outline: Quiz allows 50 questions
    When I type <title> in title field
    Then I create <numOfQuestion> <questionType> questions with text <questionText>
    And I wait for 2 sec
    And I click <btnName> button
    And I wait for 2 sec
    Then title <title> is displayed on the list of quizzes
    And quiz <title> should have <qnum> total questions
    And I wait for 2 sec
    And I delete <title>
    Examples:
      | title                             | numOfQuestion  | questionType    |  questionText   | btnName | qnum  |
      | "Quiz with 50 SC Questions"       | 50             | "Single-Choice" | "QuestionName " | "Save"  | "50"  |
#      | "Quiz with 50 Textual Questions"  | 50             | "Textual"       | "QuestionName " | "Save"  | "50"  |



#  Error-message after click on button Add Question to add 51st question "No more than 50 questions"
  @totalQuestions4
  Scenario: Quiz doesn't allow 51 questions
    When I type "Quiz with 51 question" in title field
    Then I create 50 "Textual" questions with text "Question "
    Then I click button Add Question
    And I wait for 2 sec
    And error-message should be displayed "No more than 50 Questions"
    And I wait for 3 sec
    
    
    
  







