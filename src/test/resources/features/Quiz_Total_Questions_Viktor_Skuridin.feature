@quiz_total
Feature: Quiz Creation Sample
  Background:
    Given I navigate to "login" page
    When I type "cmatt9999@tearflakes.com" into email
    And I type "Viktor12345" into password
    When I click on "Sign In" button
    And I am wait for 1 sec
    And I click on "Quizzes" menu item
    And I am wait for 1 sec
    When I click on "Create New Quiz" button
    And I am wait for 1 sec

  @quiz_0
  Scenario: Create quiz with 0 questions
    When I type "Viktor automation quiz 0 questions" in quiz title
    And I click add a question
    And I click on "Save" button
    And I wait for 1 sec
    Then error message 'Quiz is not completed. Check highlighted with "red" areas ' must displayed
    And I wait for 5 sec

  @quiz_1
  Scenario: Create quiz with 1 questions
    When I type "Viktor automation quiz 1 question" in quiz title
    And I click add a question
    Then I select "Single" type question
    And I am type "Question 1" into question field of "Q1"
    And I am type "Option 1" into "Option 1" option field of "Q1"
    And I am type "Option 2" into "Option 2" option field of "Q1"
    And I am select "Option 1" as a correct option in "Q1"
    Then I click on "Save" button
    And I wait for 1 sec
    Then "Viktor automation quiz 1 question" is displayed on the list of quizzes page
    Then I click on "Viktor automation quiz 1 question"
    And I verify that "Viktor automation quiz 1 question" total question is "1" (same as it was created)
    Then I click on "Home" menu item
    And I open quizzes
    And I wait for 1 sec
    Then I am delete "Viktor automation quiz 1 question" from the list of quizzes
    And I wait for 1 sec

  @quiz_8
  Scenario: 1 Verify that total number of question in quiz displayed correctly in quizzes menu
    When I type "Viktor automation quiz 8 questions" in quiz title
    Then I add 8 Textual questions
    And I click on "Save" button
    And I wait for 1 sec
    Then "Viktor automation quiz 8 questions" is displayed on the list of quizzes page
    Then I click on "Viktor automation quiz 8 question"
    And I verify that "Viktor automation quiz 8 question" total question is "8" (same as it was created)
    Then I click on "Home" menu item
    And I open quizzes
    And I wait for 1 sec
    Then I am delete "Viktor automation quiz 8 questions" from the list of quizzes
    And I wait for 1 sec

  @quiz_50
  Scenario: Create quiz with 50 questions
    When I type "Viktor automation quiz 50 questions" in quiz title
    And I add 50 Textual questions
    And I click on "Save" button
    And I wait for 1 sec
    Then "Viktor automation quiz 50 questions" is displayed on the list of quizzes page
    And I click on "Viktor automation quiz 50 question"
    Then I verify that "Viktor automation quiz 50 question" total question is "50" (same as it was created)
    And I click on "Home" menu item
    And I open quizzes
    And I wait for 1 sec
    Then I am delete "Viktor automation quiz 50 questions" from the list of quizzes
    And I wait for 1 sec

  @quiz_51
  Scenario: Create quiz with 51 questions - error message is displayed
    When I type "Viktor automation quiz 51 questions" in quiz title
    Then I add 51 Textual questions
    And I click on "Save" button
    And I wait for 1 sec
    Then error message "Max 50 questions" is displayed
    Then I click on "Home" menu item
    And I open quizzes
    And I wait for 1 sec
    Then I am delete "Viktor automation quiz 51 questions" from the list of quizzes
    And I wait for 1 sec




