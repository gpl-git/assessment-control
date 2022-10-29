@quizTotal
Feature: Quiz - total questions'

  Background:
    Given I open "login" page
    When I type "nata@getnada.com" for teacher user
    And I type "12345" as password
    When I click "Sign In" button
    And I wait for 2 sec
    Then "home" page will be displayed
    When I click on "Quizzes" menu item
    And I wait for 1 sec

  @quizTotal1
  Scenario: Create a quiz with 0 questions
    When I click "Create New Quiz" button
    And I wait for 1 sec
    When I type "Total Questions Quiz Automation" as quiz title
    And I add a question
    And I click "Save" button
    Then error message "Quiz is not completed" should be displayed

  @quizTotal2
  Scenario: Create a quiz with 1 question
    When I click "Create New Quiz" button
    And I wait for 1 sec
    When I type "Total Questions Quiz Automation" as quiz title
    And I add a question
    When I select "Textual" question
    And I wait for 1 sec
    When I type "Question 1 text" into "Q1"
    And I click "Save" button
    And I wait for 1 sec
    Then quiz "Total Questions Quiz Automation" is displayed on the list of quizzes
    When I click on quiz name "Total Questions Quiz Automation"
    Then Total Questions in quiz "Total Questions Quiz Automation" should be equal to 1
    When I click on quiz name "Total Questions Quiz Automation"
    And I delete quiz "Total Questions Quiz Automation"

  @quizTotal3
  Scenario Outline: Create a quiz with several question outline
    When I click "Create New Quiz" button
    And I wait for 1 sec
    When I type "Total Questions Quiz Automation" as quiz title
    And I add <numbQuestions> questions
    And I click "Save" button
    And I wait for 2 sec
    Then quiz "Total Questions Quiz Automation" is displayed on the list of quizzes
    When I click on quiz name "Total Questions Quiz Automation"
    Then Total Questions in quiz "Total Questions Quiz Automation" should be equal to <numbQuestions>
    When I click on quiz name "Total Questions Quiz Automation"
    And I delete quiz "Total Questions Quiz Automation"
    Examples:
      | numbQuestions |
      | 4             |
      | 49            |
      | 50            |

  @quizTotal4
  Scenario Outline: Create a quiz with different single-choice questions outline
    When I click "Create New Quiz" button
    And I wait for 1 sec
    When I type "Total Questions Quiz Automation" as quiz title
    And I add <numbQuestions> single-choice questions
    And I click "Save" button
    And I wait for 2 sec
    Then quiz "Total Questions Quiz Automation" is displayed on the list of quizzes
    When I click on quiz name "Total Questions Quiz Automation"
    Then Total Questions in quiz "Total Questions Quiz Automation" should be equal to <numbQuestions>
    When I click on quiz name "Total Questions Quiz Automation"
    And I delete quiz "Total Questions Quiz Automation"
    Examples:
      | numbQuestions |
      | 4             |
      | 49            |
      | 50            |


  @quizTotal5
  Scenario: Create a quiz with 1 multiple choice question
    When I click "Create New Quiz" button
    And I wait for 1 sec
    When I type "Total Questions Quiz Automation" as quiz title
    And I add a question
    When I select "Multiple-Choice" question in "Q1"
    And I wait for 1 sec
    When I type "Question 1 text" into "Q1"
    And I type "Option 1" as "Option 1*" in "Q1"
    And I type "Option 2" as "Option 2*" in "Q1"
    And I click "Add Option" button on "Q1"
    And I type "Option 3" as "Option 3*" in "Q1"
    And I select "Option 1*" as correct multi-choice option in "Q1"
    And I select "Option 3*" as correct multi-choice option in "Q1"
    And I include Other text area option for "Q1" question
    And I click "Save" button
    And I wait for 1 sec
    Then quiz "Total Questions Quiz Automation" is displayed on the list of quizzes
    When I click on quiz name "Total Questions Quiz Automation"
    Then Total Questions in quiz "Total Questions Quiz Automation" should be equal to 1
    When I click on quiz name "Total Questions Quiz Automation"
    And I delete quiz "Total Questions Quiz Automation"

  @quizTotal6
  Scenario Outline: Create a quiz with several different multiple-choice questions
    When I click "Create New Quiz" button
    And I wait for 1 sec
    When I type "Total Questions Quiz Automation" as quiz title
    And I add <numbQuestions> multiple-choice questions
    And I click "Save" button
    And I wait for 2 sec
    Then quiz "Total Questions Quiz Automation" is displayed on the list of quizzes
    When I click on quiz name "Total Questions Quiz Automation"
    Then Total Questions in quiz "Total Questions Quiz Automation" should be equal to <numbQuestions>
    When I click on quiz name "Total Questions Quiz Automation"
    And I delete quiz "Total Questions Quiz Automation"
    Examples:
      | numbQuestions |
      | 3             |
      | 49            |
      | 50            |

  @quizTotal7
    #Known issue SEP22-155, Quiz allows more then 50 questions
  Scenario: Create a quiz with 51 question
    When I click "Create New Quiz" button
    And I wait for 1 sec
    When I type "Total Questions Quiz Automation" as quiz title
    And I add 51 questions
    And I click "Save" button
    Then error message "Quiz allows up to 50 questions" should be displayed