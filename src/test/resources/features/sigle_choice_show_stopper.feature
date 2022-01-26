@quiz @single_choice_show_stopper

Feature: Single-Choice Show-Stopper
  Background:
    Given I go to "login" page
    When I type "ask_instr@aol.com" into email field
    And I type "12345" into password field
    When  I click "Sign In" button
    And I wait for 1 sec
    When I click "Quizzes" link
    And I wait for 1 sec

  @quiz @smoke
  Scenario: Creating a Single-Choice question type of quiz with Show-Stopper
    When I click "Create New Quiz" button
    And I wait for 1 sec
    And I type "Sergei Test Quiz" as the quiz title
    When I add a question
    And I select "Single" question type
    When I type "Question 1" into "Q1"
    And I type"Option 1" as "Option 1*" into "Q1"
    And I type"Option 2" as "Option 2*" into "Q1"
    And I select "Option 1*" as correct option in "Q1"
    And I check a Show-Stopper question checkbox in "Q1"
    When I click "Save" button
    And I wait for 1 sec
    Then quiz "Sergei Test Quiz" should be displayed on the list of quizzes
    And I wait for 2 sec
    And I click on Preview of "Sergei Test Quiz"
    Then Show-Stopper Question should be displayed in preview
    And I click close
    And I delete my "Sergei Test Quiz"