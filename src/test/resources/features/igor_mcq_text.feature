@mcq_text
Feature: MCQ Text

  Background:
    Given Igor go to "http://ask-qa.portnov.com/#/login"
    When Igor type "cynster6@baanr.com" into Email field
    And Igor type "12345" into Password field
    And Igor click button "Sign In"
    And Igor wait for 2 seconds
    And Igor click button "Quizzes"
    And Igor click button "Create New Quiz"
    And Igor type "0IgorQ" as quiz title
    And Igor add a question
    And Igor select "Multiple-Choice" question type
    And Igor type "O1" as "Option 1*" into "Q1"
    And Igor type "O2" as "Option 2*" into "Q1"
    When Igor select "Option 1*" as correct option in "Q1"
    And Igor wait for 2 seconds

  @smoke_mcq_text1
  Scenario: MCQ Text field allows Alphanumeric & Sp. characters
    When Igor type "qwertyuiopasdfghjklzxcvbnm1234567890~!@#$%^&?;:-=`[]{}',<.>/?_+" into "Q1"
    And Igor click button "Save"
    And Igor wait for 2 seconds
    Then quiz "0IgorQ" gets up on the List of Quizzes
    And Igor delete quiz "0IgorQ"

  @smoke_mcq_text2
  Scenario: MCQ Text field is required
    When Igor type "" into "Q1"
    And Igor click button "Save"
    Then error message should be displayed

  @smoke_mcq_text3
  Scenario: MCQ Text field allows Min 1 Character
    When Igor type "Q" into "Q1"
    And Igor click button "Save"
    And Igor wait for 2 seconds
    Then quiz "0IgorQ" gets up on the List of Quizzes
    And Igor delete quiz "0IgorQ"

  @smoke_mcq_text4
  Scenario: MCQ Text field allows 1000 Character
    When Igor type "Qqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqq" into "Q1"
    And Igor click button "Save"
    And Igor wait for 2 seconds
    Then quiz "0IgorQ" gets up on the List of Quizzes
    And Igor delete quiz "0IgorQ"

  @smoke_mcq_text5
  Scenario: MCQ Text field allows 1001 Character
    When Igor type "QQqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqq" into "Q1"
    And Igor click button "Save"
    And Igor wait for 2 seconds
    Then quiz "0IgorQ" gets up on the List of Quizzes
    And Igor delete quiz "0IgorQ"

