@quizAZ
Feature: Quiz Demo
  Background:
    Given I navigate to "login" page
    When I start typing "ask_instr@aol.com" into email input field
    And I start typing "12345" into password field
    When I click "Sign In" button AZ
    And I wait for 1 sec AZ

  @quizAZ1
  Scenario: Adding a show stopper question
    When I click on Quizzes on left side bar
    And I wait for 2 sec AZ
    Then I click "Create New Quiz" button AZ
    And I wait for 2 sec AZ
    Then I enter title "Anna Quiz" for a quiz
    And I add a question AZ
    When I select "Single" question AZ
    And I wait for 2 sec AZ
    When I type "Question 1" into "Q1" textarea AZ
    And I type "Option 1" into "Option 1*" field in "Q1" AZ
    And I type "Option 2" into "Option 2*" field in "Q1" AZ
    Then I select Show Stopper
    And I wait for 2 sec AZ
    Then I verify "Q1*" is is present
    When I select "Option 1*" as correct option in "Q1"
    When I click "Save" button
    And I wait for 2 sec


  @quizAZ2
  Scenario: Single Choice Question - Show-Stopper Preview
    When I click on Quizzes on left side bar
    And I wait for 2 sec AZ
    Then I click on "Anna Quiz"
    And I wait for 2 sec AZ
    And I preview "Anna Quiz"
    Then "Show-Stopper Question" is displayed

  @quizAZ3
  Scenario: No More than one Show stopper question
    When I click on Quizzes on left side bar
    And I wait for 2 sec
    Then I click on "Anna Quiz"
    And I wait for 2 sec AZ
    And I edit "Anna Quiz"
    And I add a question AZ
    And I wait for 2 sec AZ
    When I again select "Textual" question AZ
    And I wait for 2 sec AZ
    Then I select Show Stopper again
    And I verify only "Q2*" is present
    And I verify that "Q1*" is not present
    And I type "Question" into the "Question *"
    And I click "Save" button
    And I wait for 2 sec AZ
    Then I click on "Anna Quiz"
    And I wait for 2 sec AZ
    And I preview "Anna Quiz"
    And I verify Show-Stopper is present next to Question two
    Then I click "Close" button
    And I wait for 2 sec AZ
    And I again edit "Anna Quiz"
    And I delete question in "Anna Quiz"
    And I click "Save" button




