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
    When I type "Demo Quiz Automation - 0 questions" as quiz title
    And I add a question
    And I click "Save" button
    Then error message "Quiz is not completed" should be displayed

  @quizTotal2
  Scenario: Create a quiz with 1 question
    When I click "Create New Quiz" button
    And I wait for 1 sec
    When I type "Demo Quiz Automation - 1 questions" as quiz title
    And I add a question
    When I select "Textual" question
    And I wait for 1 sec
    When I type "Question 1 text" into "Q1"
    And I click "Save" button
    And I wait for 1 sec
    Then quiz "Demo Quiz Automation - 1 questions" is displayed on the list of quizzes
    When I click on quiz name "Demo Quiz Automation - 1 questions"
    Then Total Questions in quiz "Demo Quiz Automation - 1 questions" should be equal to 1
    When I click on quiz name "Demo Quiz Automation - 1 questions"
    And I delete quiz "Demo Quiz Automation - 1 questions"

  @quizTotal3
  Scenario: Create a quiz with 2 question
    When I click "Create New Quiz" button
    And I wait for 1 sec
    When I type "Demo Quiz Automation - 2 questions" as quiz title
    And I add a question
    When I select "Textual" question in "Q1"
    And I wait for 1 sec
    When I type "Question 1 text" into "Q1"
    And I add a question
    When I select "Textual" question in "Q2"
    When I type "Question 2 text" into "Q2"
    And I click "Save" button
    And I wait for 2 sec
    Then quiz "Demo Quiz Automation - 2 questions" is displayed on the list of quizzes
    When I click on quiz name "Demo Quiz Automation - 2 questions"
    Then Total Questions in quiz "Demo Quiz Automation - 2 questions" should be equal to 2
    When I click on quiz name "Demo Quiz Automation - 2 questions"
    And I delete quiz "Demo Quiz Automation - 2 questions"

  @quizTotal4
  Scenario: Create a quiz with 6 question
    When I click "Create New Quiz" button
    And I wait for 1 sec
    When I type "Demo Quiz Automation - 6 questions" as quiz title
    And I add 6 questions
    And I click "Save" button
    And I wait for 2 sec
    Then quiz "Demo Quiz Automation - 6 questions" is displayed on the list of quizzes
    When I click on quiz name "Demo Quiz Automation - 6 questions"
    Then Total Questions in quiz "Demo Quiz Automation - 6 questions" should be equal to 6
    When I click on quiz name "Demo Quiz Automation - 6 questions"
    And I delete quiz "Demo Quiz Automation - 6 questions"

  @quizTotal5
  Scenario: Create a quiz with 50 question
    When I click "Create New Quiz" button
    And I wait for 1 sec
    When I type "Demo Quiz Automation - 50 questions" as quiz title
    And I add 50 questions
    And I click "Save" button
    And I wait for 2 sec
    Then quiz "Demo Quiz Automation - 50 questions" is displayed on the list of quizzes
    When I click on quiz name "Demo Quiz Automation - 50 questions"
    Then Total Questions in quiz "Demo Quiz Automation - 50 questions" should be equal to 50
    When I click on quiz name "Demo Quiz Automation - 50 questions"
    And I delete quiz "Demo Quiz Automation - 50 questions"

  @quizTotal6
    #Known issue SEP22-155, Quiz allows more then 50 questions
  Scenario: Create a quiz with 51 question
    When I click "Create New Quiz" button
    And I wait for 1 sec
    When I type "Demo Quiz Automation - 51 questions" as quiz title
    And I add 51 questions
    And I click "Save" button
    Then error message "Quiz allows up to 50 questions" should be displayed