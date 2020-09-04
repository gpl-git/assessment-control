Feature: Quiz Scenarios

  Scenario: Quiz-Questions Number
    Given I open "login" page
    When  I type "ask_instr@aol.com" into email field
    And I type "12345" into password field
    When I click "Sign In" button
    And I wait for 1 sec
    Then I click "Quizzes" link
    And I wait for 1 sec
    When I click "Create New Quiz" button
    And I wait for 1 sec
    Then I type "Quiz Total Questions" as quiz title
    And I add a question
    And I wait for 1 sec
    When I select "Textual" type
    And I wait for 2 sec
    When I type "Question 1" as question "Q1" option "Question *"
    And I wait for 1 sec
    When I add up to 5 questions
    And I wait for 5 sec
    When I click "Back To Quizzes List" button
    And I wait for 2 sec
    Then I click "No, Thanks" button
    And I wait for 2 sec

  Scenario: Quiz - Save Quiz
    Given I open "login" page
    When  I type "ask_instr@aol.com" into email field
    And I type "12345" into password field
    When I click "Sign In" button
    And I wait for 1 sec
    Then I click "Quizzes" link
    And I wait for 1 sec
    When I click "Create New Quiz" button
    And I wait for 1 sec
    Then I type "Quiz_Save" as quiz title
    And I add a question
    And I wait for 1 sec
    When I select "Textual" type
    And I wait for 2 sec
    When I type "Question 1" as question "Q1" option "Question *"
    And I wait for 1 sec
    When I add up to 5 questions
    And I wait for 1 sec
    When I click "Save" button
    And I wait for 2 sec
    Then "Quiz_Save" is displayed on the list of quizzes

  Scenario: Multiple Choice - 15 options
    Given I open "login" page
    When  I type "ask_instr@aol.com" into email field
    And I type "12345" into password field
    When I click "Sign In" button
    And I wait for 1 sec
    Then I click "Quizzes" link
    And I wait for 5 sec
    When I click "Create New Quiz" button
    And I wait for 1 sec
    Then I type "MC Question" as quiz title
    And I add a question
    And I wait for 1 sec
    When I select "Multiple" type
    And I wait for 1 sec
    When I type "Question 1" as question "Q1" option "Question *"
    And I wait for 1 sec
    And I type "Option 1" as question "Q1" option "Option 1*"
    When I type "Option 2" as question "Q1" option "Option 2*"
    Then I check "Option 1*" as correct answer in question "Q1"
    And I wait for 1 sec
    Then I add 13 more options to "Q1"
    And I wait for 5 sec

  Scenario: Quiz - Single Choice
    Given I open "login" page
    When  I type "ask_instr@aol.com" into email field
    And I type "12345" into password field
    When I click "Sign In" button
    And I wait for 1 sec
    Then I click "Quizzes" link
    And I wait for 1 sec
    When I click "Create New Quiz" button
    And I wait for 1 sec
    Then I type "Quiz_Test_SingleChoice" as quiz title
    And I add a question
    And I wait for 1 sec
    When I select "Single" type
    And I wait for 2 sec
    When I type "Question 1" as question "Q1" option "Question *"
    And I wait for 1 sec
    And I type "Option 1" as question "Q1" option "Option 1*"
    When I type "Option 2" as question "Q1" option "Option 2*"
    And I wait for 5 sec
    Then I select radio button "Option 2*" as correct answer in question "Q1"
    And I wait for 5 sec
