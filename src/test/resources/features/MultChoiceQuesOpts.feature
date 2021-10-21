@predefined
Feature: Multiple Choice Question - Options

  Background:
    Given I open "login" page
    When I type "ask_instr@aol.com" into email field
    And I type "12345" into the password field
    When I click "Sign In" button
    And I wait for 1 sec
    When I click on "Quizzes" menu
    And I wait for 1 sec
    And I check and delete existed quizzes with name "Dmitry K Multiple Choice Options Quiz"

  @predefined1
  Scenario: Multiple Choice Option Field Accepts 1000 characters (maximum)
    When I click "Create New Quiz" button
    And I wait for 2 sec
    When I type "Dmitry K Multiple Choice Options Quiz" as quiz title
    And I add a question
    When I select "Multiple-Choice" question type
    And I wait for 2 sec
    And I type "Multiple Choice Question 1" into "Q1"
    When I checked "Option 1"
    And I checked "Option 2"
    When Input test-data 1000 chars into field "Option 1"
    And Input test-data 1000 chars into field "Option 2"
    When I push button "Save"
    And I wait for 1 sec
    Then "Dmitry K Multiple Choice Options Quiz" is displayed on the list of quizzes
    And I wait for 2 sec
    And I delete "Dmitry K Multiple Choice Options Quiz" from the list of quizzes

  @predefined2
  Scenario: Multiple Choice Options Field Doesn't Accepts 1000+1 char (max char + 1)
    When I click "Create New Quiz" button
    And I wait for 2 sec
    When I type "Dmitry K Multiple Choice Options Quiz" as quiz title
    And I add a question
    When I select "Multiple-Choice" question type
    And I wait for 2 sec
    And I type "Multiple Choice Question 1" into "Q1"
    When I checked "Option 1"
    And I checked "Option 2"
    When Input test-data 1001 chars into field "Option 1"
    And Input test-data 1001 chars into field "Option 2"
    When I push button "Save"
    And I wait for 2 sec
    Then "Dmitry K Multiple Choice Options Quiz" is not displayed on the list of quizzes

  @predefined3
  Scenario: Multiple Choice Options Field accepts 1 character (minimum number of characters)
    When I click "Create New Quiz" button
    And I wait for 2 sec
    When I type "Dmitry K Multiple Choice Options Quiz" as quiz title
    And I add a question
    When I select "Multiple-Choice" question type
    And I wait for 2 sec
    And I type "Multiple Choice Question 1" into "Q1"
    When I checked "Option 1"
    And I checked "Option 2"
    When Input test-data 1 chars into field "Option 1"
    And Input test-data 1 chars into field "Option 2"
    When I push button "Save"
    And I wait for 1 sec
    Then "Dmitry K Multiple Choice Options Quiz" is displayed on the list of quizzes
    And I wait for 2 sec
    And I delete "Dmitry K Multiple Choice Options Quiz" from the list of quizzes

  @predefined4
  Scenario: Multiple Choice Options Field accepts 2 characters (minimum + 1)
    When I click "Create New Quiz" button
    And I wait for 2 sec
    When I type "Dmitry K Multiple Choice Options Quiz" as quiz title
    And I add a question
    When I select "Multiple-Choice" question type
    And I wait for 2 sec
    And I type "Multiple Choice Question 1" into "Q1"
    When I checked "Option 1"
    And I checked "Option 2"
    When Input test-data 2 chars into field "Option 1"
    And Input test-data 2 chars into field "Option 2"
    When I push button "Save"
    And I wait for 1 sec
    Then "Dmitry K Multiple Choice Options Quiz" is displayed on the list of quizzes
    And I wait for 2 sec
    And I delete "Dmitry K Multiple Choice Options Quiz" from the list of quizzes

  @predefined5
  Scenario: Multiple Choice Options Field is empty
    When I click "Create New Quiz" button
    And I wait for 2 sec
    When I type "Dmitry K Multiple Choice Options Quiz" as quiz title
    And I add a question
    When I select "Multiple-Choice" question type
    And I wait for 2 sec
    And I type "Multiple Choice Question 1" into "Q1"
    When I checked "Option 1"
    And I checked "Option 2"
    When Clear the field "Option 1"
    And Clear the field "Option 2"
    When I push button "Save"
    Then Alert message below "Option 1" field is displayed
    And Alert message below "Option 2" field is displayed

  @predefined6
  Scenario: Multiple Choice Question Type accepts 15 choices (max number of choices)
    When I click "Create New Quiz" button
    And I wait for 2 sec
    When I type "Dmitry K Multiple Choice Options Quiz" as quiz title
    And I add a question
    When I select "Multiple-Choice" question type
    And I wait for 2 sec
    And I type "Multiple Choice Question 1" into "Q1"
    When I add a question 15 times
    And I wait for 1 sec
    When I fill out all fields "Option" with text "Akjh234^%&O"
    And I checked "Option 1"
    And I checked "Option 2"
    When I push button "Save"
    And I wait for 1 sec
    Then "Dmitry K Multiple Choice Options Quiz" is displayed on the list of quizzes
    And I wait for 2 sec
    And I delete "Dmitry K Multiple Choice Options Quiz" from the list of quizzes

  @predefined7
  Scenario: Multiple Choice Question Type Doesn't Accepts 16 Choices (max number + 1)
    When I click "Create New Quiz" button
    And I wait for 2 sec
    When I type "Dmitry K Multiple Choice Options Quiz" as quiz title
    And I add a question
    When I select "Multiple-Choice" question type
    And I wait for 1 sec
    And I type "Multiple Choice Question 1" into "Q1"
    When I add a question 16 times
    When I fill out all fields "Option" with text "Akjh234^%&O"
    And I checked "Option 1"
    And I checked "Option 2"
    When I push button "Save"
    And I wait for 1 sec
    Then "Dmitry K Multiple Choice Options Quiz" is not displayed on the list of quizzes
    When I wait for 1 sec
    And I delete "Dmitry K Multiple Choice Options Quiz" from the list of quizzes

  @predefined8
  Scenario: Multiple Choice Options Field doesn't accept a space bar without a text (empty field)
    When I click "Create New Quiz" button
    And I wait for 2 sec
    When I type "Dmitry K Multiple Choice Options Quiz" as quiz title
    And I add a question
    When I select "Multiple-Choice" question type
    And I wait for 2 sec
    And I type "Multiple Choice Question 1" into "Q1"
    When I checked "Option 1"
    And I checked "Option 2"
    When I type " " as "Option 1*" into "Q1"
    And I type " " as "Option 2*" into "Q1"
    When I push button "Save"
    And I wait for 2 sec
    Then "Dmitry K Multiple Choice Options Quiz" is not displayed on the list of quizzes
    When I wait for 1 sec
    And I delete "Dmitry K Multiple Choice Options Quiz" from the list of quizzes

  @predefined9
  Scenario: Multiple Choice Question Options doesn't let to save the question without selecting at least 1 correct answer
    When I click "Create New Quiz" button
    And I wait for 2 sec
    When I type "Dmitry K Multiple Choice Options Quiz" as quiz title
    And I add a question
    When I select "Multiple-Choice" question type
    And I wait for 2 sec
    And I type "Multiple Choice Question 1" into "Q1"
    When I type "Test option1" as "Option 1*" into "Q1"
    And I type "Test option 2" as "Option 2*" into "Q1"
    When I push button "Save"
    And I wait for 1 sec
    Then The overlay warning window with warning
    And Alert message with text "*Choose at least one correct answer" should be displayed

  @predefined10
  Scenario: Multiple Choice Options Field accepts 2 characters (minimum + 1)
    When I click "Create New Quiz" button
    And I wait for 2 sec
    When I type "Dmitry K Multiple Choice Options Quiz" as quiz title
    And I add a question
    When I select "Multiple-Choice" question type
    And I wait for 2 sec
    And I type "Multiple Choice Question 1" into "Q1"
    When I checked "Option 1"
    And I checked "Option 2"
    When Input test-data 10 chars into field "Option 2"
    When I push button "Save"
    And I wait for 1 sec
    Then "Dmitry K Multiple Choice Options Quiz" is not displayed on the list of quizzes
    And Alert message with text "This field is required" should be displayed
    And I wait for 2 sec
    And I delete "Dmitry K Multiple Choice Options Quiz" from the list of quizzes