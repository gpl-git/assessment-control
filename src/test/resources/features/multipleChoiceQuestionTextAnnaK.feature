@multiplechoiceQuestionText
Feature: Multiple Choice Question - Text

  Background:
    Given I navigate to the "login" page
    When I type "anna.e.kirakosyan@gmail.com" into the email field
    And I type "Ayc8686" into the password field
    When I click on the "Sign In" button
    And I wait for 2 sec
    And I click on the "Quizzes" link
    And I wait for 2 sec

  @MultiplechoiceQuestionText1
  Scenario: Allowable characters: Alphanumeric & Sp. characters
    And I click on the "Create New Quiz" button
    And I wait for 2 sec
    And I type "ask1201" as my quiz title
    And I wait for 2 sec
    When I add the question
    And I wait for 2 sec
    And I select the "Multiple-Choice" question type
    And I wait for 2 sec
    When I type "AB?" into the "Q1"
    And I wait for 2 sec
    When I type "Option A*" as "Option 1*" into the "Q1"
    When I type "Option B*" as "Option 2*" into the "Q1"
    And I wait for 2 sec
    And I select "Option 1*" as correct option in the "Q1"
    And I wait for 2 sec
    When I click on the "Save" button
    And I wait for 2 sec
    Then the quiz "ask1201" should be displayed on the list of quizzes
    And I wait for 2 sec
    Then I delete "ask1201" from list of quizzes

  @MultiplechoiceQuestionText2
  Scenario: The field is required
    And I click on the "Create New Quiz" button
    And I wait for 2 sec
    And I type "ask1201" as my quiz title
    And I wait for 2 sec
    When I add the question
    And I wait for 2 sec
    And I select the "Multiple-Choice" question type
    And I wait for 2 sec
    When I click on the "Save" button
    And I wait for 2 sec
    Then error message "Quiz is not completed." should be displayed
    And I wait for 2 sec

  @MultiplechoiceQuestionText3
  Scenario: Min 1 Characters
    And I click on the "Create New Quiz" button
    And I wait for 2 sec
    And I type "ask1201" as my quiz title
    And I wait for 2 sec
    When I add the question
    And I wait for 2 sec
    And I select the "Multiple-Choice" question type
    And I wait for 2 sec
    When I type "A" into the "Q1"
    And I wait for 2 sec
    When I type "b" as "Option 1*" into the "Q1"
    When I type "c" as "Option 2*" into the "Q1"
    And I wait for 2 sec
    And I select "Option 1*" as correct option in the "Q1"
    And I wait for 2 sec
    When I click on the "Save" button
    And I wait for 2 sec
    Then the quiz "ask1201" should be displayed on the list of quizzes
    And I wait for 2 sec
    Then I delete "ask1201" from list of quizzes

  @MultiplechoiceQuestionText4
  Scenario: Max 1000 characters
    And I click on the "Create New Quiz" button
    And I wait for 2 sec
    And I type "ask1201" as my quiz title
    And I wait for 2 sec
    When I add the question
    And I wait for 2 sec
    And I select the "Multiple-Choice" question type
    And I wait for 2 sec
    When I type in question field max characters
    When I type in the first option max characters
    When I type in the second option max characters
    And I wait for 2 sec
    And I select "Option 1*" as correct option in the "Q1"
    When I click on the "Save" button
    And I wait for 3 sec
    Then the quiz "ask1201" should be displayed on the list of quizzes
    And I wait for 2 sec
    Then I delete "ask1201" from list of quizzes

  @MultiplechoiceQuestionText5
#known issue Jira -  ASK_Online(10/25/2021)OCT-352
  Scenario:  Max 1000 + 1 characters
    And I click on the "Create New Quiz" button
    And I wait for 2 sec
    And I type "ask1201" as my quiz title
    And I wait for 2 sec
    When I add the question
    And I wait for 2 sec
    And I select the "Multiple-Choice" question type
    And I wait for 2 sec
    When I type in question field more than max characters
    When I type in the first option more than max characters
    When I type in the second option more than characters
    And I wait for 1 sec
    And I select "Option 1*" as correct option in the "Q1"
    And I wait for 2 sec
    When I click on the "Save" button
    And I wait for 2 sec
    Then the quiz "ask1201" should be displayed on the list of quizzes
    And I wait for 2 sec
    Then I delete "ask1201" from list of quizzes
















