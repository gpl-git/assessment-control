@createQuiz
Feature: Quiz - Total Questions

  @totalQuestions1
  Scenario: Minimum number of questions in the quiz
    Given I Go to login page
    When I sign in with credential email:"frinsk@noisemails.com", password:"Par0l"
    And I create new quiz "Minimum number of questions in the quiz" with 1 "single-choice" questions
    And I save the quiz
    And I wait for 1 sec
    Then quiz "Minimum number of questions in the quiz" should be displayed on the list of quizzes
    Then I delete the quiz "Minimum number of questions in the quiz"
    And I wait for 1 sec

  @totalQuestions2
  Scenario: Maximum number of questions in the quiz
    Given I Go to login page
    When I sign in with credential email:"frinsk@noisemails.com", password:"Par0l"
    And I create new quiz "Maximum number of questions in the quiz" with 50 "single-choice" questions
    And I save the quiz
    And I wait for 1 sec
    Then quiz "Maximum number of questions in the quiz" should be displayed on the list of quizzes

  @totalQuestions3
  Scenario: Maximum +1 number of questions in the quiz
    Given I Go to login page
    When I sign in with credential email:"frinsk@noisemails.com", password:"Par0l"
    And I find the quiz "Maximum number of questions in the quiz" and push Edit button
    And I add 1 "multiple-choice" question
    And I save the quiz
    And I wait for 1 sec
    Then error message "Accept only 50 questions" should be displayed

  @totalQuestions4
  Scenario: To delete questions
    Given I Go to login page
    When I sign in with credential email:"frinsk@noisemails.com", password:"Par0l"
    And I find the quiz "Maximum number of questions in the quiz" and push Edit button
    And I delete question number 1
    And I save the quiz
    And I wait for 1 sec
    Then quiz "Maximum number of questions in the quiz" should be displayed on the list of quizzes
    Then I delete the quiz "Maximum number of questions in the quiz"
    And I wait for 1 sec
