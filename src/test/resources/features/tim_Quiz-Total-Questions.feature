@Quiz-Total-Questions
Feature: Quiz Total Questions

  Background:
    Given I go to "login" page TN
    When I enter "qa.sofi@gmail.com" into Email text field **TN
    And I enter "12345" into Password text field **TN
    Then I click on button with text "Sign In" **TN
    And I do nothing for 5 sec **TN

  @NOV-203
  Scenario: 0 questions in the Quiz are NOT allowed
    When I click on menu item with text "Quizzes" from left-side menu **TN
    And I do nothing for 5 sec **TN
    Then I click on button with text "Create New Quiz" **TN
    And I do nothing for 5 sec **TN
    Then I enter Quiz title as "!0 Questions Quiz" into quiz title text field **TN
    And I click on Add Question **TN
    Then I click on button with text "Save" **TN
    And Error message should be displayed **TN
    And I do nothing for 5 sec **TN

  @NOV-296
  Scenario: 1 question in the Quiz is allowed
    When I click on menu item with text "Quizzes" from left-side menu **TN
    And I do nothing for 5 sec **TN
    Then I click on button with text "Create New Quiz" **TN
    And I do nothing for 5 sec **TN
    Then I enter Quiz title as "!Lets_Try_1" into quiz title text field **TN
    And I click on Add Question **TN
    Then I click on "Textual"question type **TN
    And I enter question "Some Question" into question text field
    Then I click on button with text "Save" **TN
    And I do nothing for 5 sec **TN
    And I should see quiz with name "!Lets_Try_1" in the list of quizzes
    Then I delete created quiz "!Lets_Try_1" **TN
    And hold for 1 sec **TN

  @NOV-299
  Scenario: 25 questions in the Quiz are allowed
    When I click on menu item with text "Quizzes" from left-side menu **TN
    Then I click on button with text "Create New Quiz" **TN
    And I do nothing for 5 sec **TN
    And I enter Quiz title as "!Lets_Try_25" into quiz title text field **TN
    And I create 9 Textual questions "What if.. ?" **TN
    And I create 8 Single Choice questions "Can fish swim?" with Option 1 as "No"; Option 2 as "Yes". And correct answer is Option 2 **TN
    And I create 8 Multiple Choice questions "What is Kiwi" with Option 1 as "Fruit"; Option 2 as "Bird"; Option 3 as "Both". And correct answer is Option 3 **TN
    And I print total questions number **TN
    Then I click on button with text "Save" **TN
    And hold for 2 sec **TN
    When I click on menu item with text "Quizzes" from left-side menu **TN
    And I should see quiz with name "!Lets_Try_25" in the list of quizzes
    Then I delete created quiz "!Lets_Try_25" **TN
    And hold for 1 sec **TN

  @NOV-297
  Scenario: 50 questions in the Quiz are allowed
    When I click on menu item with text "Quizzes" from left-side menu **TN
    Then I click on button with text "Create New Quiz" **TN
    And I do nothing for 5 sec **TN
    And I enter Quiz title as "!Lets_Try_50" into quiz title text field **TN
    And I create 20 Textual questions "What if.. ?" **TN
    And I create 15 Single Choice questions "Can fish swim?" with Option 1 as "No"; Option 2 as "Yes". And correct answer is Option 2 **TN
    And I create 15 Multiple Choice questions "What is Kiwi" with Option 1 as "Fruit"; Option 2 as "Bird"; Option 3 as "Both". And correct answer is Option 3 **TN
    And I print total questions number **TN
    Then I click on button with text "Save" **TN
    And hold for 2 sec **TN
    When I click on menu item with text "Quizzes" from left-side menu **TN
    And I should see quiz with name "!Lets_Try_50" in the list of quizzes
    Then I delete created quiz "!Lets_Try_50" **TN
    And hold for 1 sec **TN

  @NOV-298
  Scenario: 51 questions in the Quiz are allowed
    When I click on menu item with text "Quizzes" from left-side menu **TN
    Then I click on button with text "Create New Quiz" **TN
    And I do nothing for 5 sec **TN
    And I enter Quiz title as "!Lets_Try_51" into quiz title text field **TN
    And I create 21 Textual questions "What if.. ?" **TN
    And I create 15 Single Choice questions "Can fish swim?" with Option 1 as "No"; Option 2 as "Yes". And correct answer is Option 2 **TN
    And I create 15 Multiple Choice questions "What is Kiwi" with Option 1 as "Fruit"; Option 2 as "Bird"; Option 3 as "Both". And correct answer is Option 3 **TN
    And I print total questions number **TN
    Then I click on button with text "Save" **TN
    And hold for 2 sec **TN
    When I click on menu item with text "Quizzes" from left-side menu **TN
    And I should see quiz with name "!Lets_Try_51" in the list of quizzes
    Then I delete created quiz "!Lets_Try_51" **TN
    And hold for 1 sec **TN

  @NOV-300
  Scenario: 55 questions in the Quiz are allowed
    When I click on menu item with text "Quizzes" from left-side menu **TN
    Then I click on button with text "Create New Quiz" **TN
    And I do nothing for 5 sec **TN
    And I enter Quiz title as "!Lets_Try_55" into quiz title text field **TN
    And I create 23 Textual questions "What if.. ?" **TN
    And I create 16 Single Choice questions "Can fish swim?" with Option 1 as "No"; Option 2 as "Yes". And correct answer is Option 2 **TN
    And I create 16 Multiple Choice questions "What is Kiwi" with Option 1 as "Fruit"; Option 2 as "Bird"; Option 3 as "Both". And correct answer is Option 3 **TN
    And I print total questions number **TN
    Then I click on button with text "Save" **TN
    And hold for 2 sec **TN
    When I click on menu item with text "Quizzes" from left-side menu **TN
    And I should see quiz with name "!Lets_Try_55" in the list of quizzes
    Then I delete created quiz "!Lets_Try_55" **TN
    And hold for 1 sec **TN



















     

