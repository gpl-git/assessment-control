@quiz_total
Feature: Quiz Creation Sample
  Background:
    Given I navigate to "login" page VS
    When I type "cmatt9999@tearflakes.com" into email VS
    And I type "Viktor12345" into password VS
    When I click on "Sign In" button VS
    And I am wait for 1 sec VS
    And I click on "Quizzes" menu item VS
    And I am wait for 1 sec VS
    When I click on "Create New Quiz" button VS
    And I am wait for 1 sec VS

  @quiz_0
  Scenario: Create quiz with 0 questions
    When I type "Viktor automation quiz 0 questions" in quiz title VS
    And I click add a question
    And I click on "Save" button VS
    And I am wait for 1 sec VS
    Then error message 'Quiz is not completed. Check highlighted with "red" areas ' must displayed
    And I am wait for 5 sec VS

  @quiz_1
  Scenario: Create quiz with 1 questions
    When I type "Viktor automation quiz 1 question" in quiz title VS
    And I click add a question VS
    Then I select "Single" type question VS
    And I am type "Question 1" into question field of "Q1" VS
    And I am type "Option 1" into "Option 1" option field of "Q1" VS
    And I am type "Option 2" into "Option 2" option field of "Q1" VS
    And I am select "Option 1" as a correct option in "Q1" VS
    Then I click on "Save" button VS
    And I am wait for 1 sec VS
    Then "Viktor automation quiz 1 question" is displayed on the list of quizzes page VS
    Then I click on "Viktor automation quiz 1 question" VS
    And I verify that "Viktor automation quiz 1 question" total question is "1" (same as it was created) VS
    Then I click on "Home" menu item VS
    And I open quizzes VS
    And I am wait for 1 sec VS
    Then I am delete "Viktor automation quiz 1 question" from the list of quizzes VS
    And I am wait for 1 sec VS

  @quiz_8
  Scenario: 1 Verify that total number of question in quiz displayed correctly in quizzes menu
    When I type "Viktor automation quiz 8 questions" in quiz title VS
    Then I add 8 Textual questions VS
    And I click on "Save" button VS
    And I am wait for 1 sec VS
    Then "Viktor automation quiz 8 questions" is displayed on the list of quizzes page VS
    Then I click on "Viktor automation quiz 8 question" VS
    And I verify that "Viktor automation quiz 8 question" total question is "8" (same as it was created) VS
    Then I click on "Home" menu item VS
    And I open quizzes VS
    And I am wait for 1 sec VS
    Then I am delete "Viktor automation quiz 8 questions" from the list of quizzes VS
    And I am wait for 1 sec VS

  @quiz_50
  Scenario: Create quiz with 50 questions
    When I type "Viktor automation quiz 50 questions" in quiz title VS
    And I add 50 Textual questions VS
    And I click on "Save" button VS
    And I am wait for 1 sec VS
    Then "Viktor automation quiz 50 questions" is displayed on the list of quizzes page VS
    And I click on "Viktor automation quiz 50 question" VS
    Then I verify that "Viktor automation quiz 50 question" total question is "50" (same as it was created) VS
    And I click on "Home" menu item VS
    And I open quizzes VS
    And I am wait for 1 sec VS
    Then I am delete "Viktor automation quiz 50 questions" from the list of quizzes VS
    And I am wait for 1 sec VS

  @quiz_51
  Scenario: Create quiz with 51 questions - error message is displayed
    When I type "Viktor automation quiz 51 questions" in quiz title VS
    Then I add 5 Textual questions VS
    And I click on "Save" button VS
    And I am wait for 1 sec VS
    Then error message "Max 50 questions" is displayed VS
    Then I click on "Home" menu item VS
    And I open quizzes VS
    And I am wait for 1 sec VS
    Then I am delete "Viktor automation quiz 51 questions" from the list of quizzes VS
    And I am wait for 1 sec VS




