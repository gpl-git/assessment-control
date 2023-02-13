@predefined

Feature: Single-Choice Questions- Options

  Background:
    Given I open "login" website
    When I type "nila21@gatamala.com" into email field
    When  I type "11111" into password field
    And I click "Sign In" button
    And I wait for 1 sec
    When I click "Quizzes" menu item
    And I wait for 1 sec
    And I click "Create New Quiz" button
    And I wait for 1 sec
    When I type "0Quiz Demo by Max" as quiz title
    Then I add question
    When I select "Single" question type

  @predefined1
  Scenario: Max 1000 ch in option text field
    When I type "Question 1" into "Q1"
    When I type 1000 characters into "Q1" as "Option 1*"
    And I type "Option 2" into "Q1" as "Option 2*"
    When I select "Option 1*" as correct option in "Q1"
    When I click "Save" button
    And I wait for 10 sec
    Then title "0Quiz Demo by Max" should be displayed on the list of quizzes
    And I delete quiz  "0Quiz Demo by Max"
    And I wait for 3 sec

  @predefined2
  Scenario: Max 1000+1 ch in option text field
    When I type "Question 1" into "Q1"
    When I type 1001 characters into "Q1" as "Option 1*"
    Then "No more than 1000 characters allowed" error message should be displayed
    #Know issue JAN23-172

  @predefined3
  Scenario: Max 15 options
    When I type "Question 1" into "Q1"
    And I type "Option 1" into "Q1" as "Option 1*"
    And I type "Option 2" into "Q1" as "Option 2*"
    When I select "Option 1*" as correct option in "Q1"
    And I add up to 15 options in "Q1"
    And I wait for 5 sec
    When I click "Save" button
    And I wait for 10 sec
    Then title "0Quiz Demo by Max" should be displayed on the list of quizzes
    And I delete quiz  "0Quiz Demo by Max"
    And I wait for 3 sec

  @predefined4
  Scenario: Max 15+1 options
    When I type "Question 1" into "Q1"
    And I type "Option 1" into "Q1" as "Option 1*"
    And I type "Option 2" into "Q1" as "Option 2*"
    When I select "Option 1*" as correct option in "Q1"
    And I add up to 16 options in "Q1"
    And I wait for 5 sec
    Then "No more that 15 choices allowed" error message should be displayed
    #Know issue JAN23-437


  @predefined5
  Scenario: Includes "Others" text area option
    When I type "Question 1" into "Q1"
    And I type "Option 1" into "Q1" as "Option 1*"
    And I type "Option 2" into "Q1" as "Option 2*"
    When I select "Option 1*" as correct option in "Q1"
    Then I add Other text area
    And I wait for 1 sec
    When I click "Save" button
    And I wait for 10 sec
    Then title "0Quiz Demo by Max" should be displayed on the list of quizzes
    And I delete quiz  "0Quiz Demo by Max"
    And I wait for 3 sec

  @predefined6
  Scenario: Verify an error message, if do not put the content for the option
    When I type "Question 1" into "Q1"
    And I type "Option 1" into "Q1" as "Option 1*"
    When I select "Option 1*" as correct option in "Q1"
    When I click "Save" button
    And I wait for 5 sec
    Then "This field is required" error message should be displayed



  @predefined7
  Scenario: Verify an error message, if do not check the correct answer for single choice question
    When I type "Question 1" into "Q1"
    And I type "Option 1" into "Q1" as "Option 1*"
    And I type "Option 2" into "Q1" as "Option 2*"
    When I click "Save" button
    And I wait for 5 sec
    Then "*Choose correct answer" error message should be displayed on webpage




