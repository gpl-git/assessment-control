@quiz @MC_Options
Feature: Quiz - Multiple Choice Option Scenarios

  Background:
    Given I go to "login" page
    When I type "ask_instr@aol.com" into email field
    And I type "12345" into password field
    When I click "Sign In" button
    And I wait for 1 sec
    When I click "Quiz" menu item
    And I wait for 1 sec
    When I click "Create New Quiz" button
    And I wait for 1 sec

  @MC_Options1
  Scenario: Multiple Choice Question - "Option" field should not allow create more than 15 choices
    When I type "001 QA Quiz - Olga" as quiz title
    And I add a question
    Then I select "Multiple-Choice" question type
    Then I enter "What are the main components of bug report?" into "Q1"
    And I wait for 1 sec
    And I type "Priority" as "Option 1*" into "Q1"
    Then I click on checkbox of "Option 1*" as correct option in "Q1"
    And I type "Expected Result" as "Option 2*" into "Q1"
    Then I click on checkbox of "Option 2*" as correct option in "Q1"
    And I wait for 1 sec
    Then I click "Add Option" button
    And I type "Actual Result" as "Option 3*" into "Q1"
    Then I click on checkbox of "Option 3*" as correct option in "Q1"
    Then I click "Add Option" button
    And I type "Short Description" as "Option 4*" into "Q1"
    Then I click on checkbox of "Option 4*" as correct option in "Q1"
    Then I click "Add Option" button
    And I add up to 16 options to "Q1" ok
    When I click "Save" button
    And I wait for 1 sec
    Then error message "15" is displayed
    And I wait for 1 sec

  @MC_Options2
  Scenario: Multiple Choice Question - "Option" field allows 1000 characters max
    When I type "002 QA Quiz - Olga" as quiz title
    And I add a question
    Then I select "Multiple-Choice" question type
    Then I enter "What are the main components of bug report?" into "Q1"
    And I enter 1000 alphanumeric characters into "Option 1*" in "Q1" ok
    And I click on checkbox of "Option 1*" as correct option in "Q1"
    Then I type "Expected Result" as "Option 2*" into "Q1"
    And I click on checkbox of "Option 2*" as correct option in "Q1"
    When I click "Save" button
    And I wait for 1 sec
    Then I verify that "002 QA Quiz - Olga" is displayed on the list of quizzes
    And I wait for 1 sec
    Then I delete "002 QA Quiz - Olga" from the list of quizzes
    And I wait for 1 sec
    And I verify that "002 QA Quiz - Olga" is not present on the list of quizzes
    And I wait for 1 sec

  @MC_Options3
  Scenario: Multiple Choice Question - "Option" field can't allow white spaces only
    When I type "003 QA Quiz - Olga" as quiz title
    And I add a question
    Then I select "Multiple-Choice" question type
    Then I enter "What are the main components of bug report?" into "Q1"
    Then I type "    " as "Option 1*" into "Q1"
    Then I type "    " as "Option 2*" into "Q1"
    And I click on checkbox of "Option 2*" as correct option in "Q1"
    And I click "Save" button
    Then error message in snack-bar "Quiz is not completed" is displayed
    And I wait for 1 sec

  @MC_Options4
  Scenario: Multiple Choice Question - "Option" field is required
      When I type "004 QA Quiz - Olga" as quiz title
      And I add a question
      Then I select "Multiple-Choice" question type
      Then I enter "What are the main components of bug report?" into "Q1"
      And I wait for 1 sec
      And I click "Save" button
      And I wait for 1 sec
      Then error message "This field is required" is displayed
      And error message in snack-bar "Quiz is not completed" is displayed
      And I wait for 1 sec

  @MC_Options5
  Scenario: Multiple Choice Question - "Option" field should not allow more than 1000 characters max
      When I type "005 QA Quiz - Olga" as quiz title
      And I add a question
      Then I select "Multiple-Choice" question type
      Then I enter "What are the main components of bug report?" into "Q1"
      And I enter 1001 alphanumeric characters into "Option 1*" in "Q1" ok
      Then I type "Expected Result" as "Option 2*" into "Q1"
      And I click on checkbox of "Option 2*" as correct option in "Q1"
      When I click "Save" button
      Then error message in snack-bar "Quiz is not completed" is displayed
      Then error message "maximum" is displayed


  @MC_Options6
  Scenario: Multiple Choice Question - The user is able to delete the "Option" field
      When I type "006 QA Quiz - Olga" as quiz title
      And I add a question
      Then I select "Multiple-Choice" question type
      Then I enter "What are the main components of bug report?" into "Q1"
      And I wait for 1 sec
      And I type "Priority" as "Option 1*" into "Q1"
      Then I click on checkbox of "Option 1*" as correct option in "Q1"
      And I type "Expected Result" as "Option 2*" into "Q1"
      Then I click on checkbox of "Option 2*" as correct option in "Q1"
      Then I click "Add Option" button
      And I wait for 1 sec
      And I type "Actual Result" as "Option 3*" into "Q1"
      Then I click on settings on "Option 2*" of "Q1", wait 1 sec, and delete this option
      And I wait for 1 sec
      Then I verify that element "Expected Result" is not present

  @MC_Options7
  Scenario: Multiple Choice Question - The user is able to move down the "Option" field
    When I type "007 QA Quiz - Olga" as quiz title
    And I add a question
    Then I select "Multiple-Choice" question type
    Then I enter "What are the main components of bug report?" into "Q1"
    And I type "Priority" as "Option 1*" into "Q1"
    And I type "Expected Result" as "Option 2*" into "Q1"
    Then I click on settings on "Option 1*" of "Q1", wait 1 sec, and move option down
    Then I verify that "Priority" is located in "Option 2*"


  @MC_Options8
  Scenario: Multiple Choice Question - The user is able to move up the "Option" field
    When I type "008 QA Quiz - Olga" as quiz title
    And I add a question
    Then I select "Multiple-Choice" question type
    Then I enter "What are the main components of bug report?" into "Q1"
    And I type "Priority" as "Option 1*" into "Q1"
    And I type "Expected Result" as "Option 2*" into "Q1"
    Then I click on settings on "Option 2*" of "Q1", wait 1 sec, and move option up
    Then I verify that "Expected Result" is located in "Option 1*"

