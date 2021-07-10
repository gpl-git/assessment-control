@scqst
Feature: Test set for single choice question with showstopper
#This feature was made by Vladimir Borisov and is related to ASKJ-648 issue
#All TCs were written to be as close to their originals as possible

  @scqst1
  Scenario: Verify we can create a "Single Choice Question - Show-Stopper"
    Given I go to "login" page
    When I type "qa@ask.com" into email field
    And I type "12345" into password field
    When I click on "Sign In" button
    And I wait for 1 sec
    When I click on "Quizzes" tab
    And I wait for 1 sec
    Then I click on "Create New Quiz" button
    And I wait for 1 sec
    Then I type "SCQST1 Quiz" as quiz title
    When I add a question
    And I select "Single" question type using Vlad's method
    Then I type question text "2+2=?" into "Q1"
    And I type "5" as option "Option 1*" into "Q1"
    And I type "4" as option "Option 2*" into "Q1"
    Then I select "Option 2*" as correct option in "Q1"
    And I check "Show-Stopper" checkbox in 1 question
#    Use "Show-Stopper" or "text area", depending on which checkbox you need
    Then I wait for 2 sec


  @scqst2
  Scenario: Verify if show-stopper works in a different way through the preview button
    Given I go to "login" page
    When I type "qa@ask.com" into email field
    And I type "12345" into password field
    When I click on "Sign In" button
    And I wait for 1 sec
    When I click on "Quizzes" tab
    And I wait for 1 sec
    Then I click on "Create New Quiz" button
    And I wait for 1 sec
    Then I type "SCQST2 Quiz" as quiz title
    When I add a question
    And I select "Single" question type
    Then I type question text "2+2=?" into "Q1"
    And I type "5" as option "Option 1*" into "Q1"
    And I type "4" as option "Option 2*" into "Q1"
    Then I select "Option 2*" as correct option in "Q1"
    And I check "Show-Stopper" checkbox in 1 question
    When I click on "Save" button
    And I wait for 1 sec
    Then quiz "SCQST2 Quiz" should be displayed on the list of quizzes
    And I delete "SCQST2 Quiz" from the list of quizzes
#    deletion step was added to ensure DB is not cluttered with multiple clones of the same quiz
    Then I wait for 2 sec

  @scqst3
  Scenario: Verify  what you can add to the quiz using the Single Choice question.
#  ...Multiple Choice Question and set Show-Stopper to Single-Choice, then click the Move Question Up button to swap questions.
    Given I go to "login" page
    When I type "qa@ask.com" into email field
    And I type "12345" into password field
    When I click on "Sign In" button
    And I wait for 1 sec
    When I click on "Quizzes" tab
    And I wait for 1 sec
    Then I click on "Create New Quiz" button
    And I wait for 1 sec
    Then I type "SCQST3 Quiz" as quiz title
    When I add a question
    And I select "Single" question type
    Then I type "2+2=?" into title of the 1 question
    And I add extra option to the 1 question
    And I type "0" as option number 1 into question number 1
    And I type "4" as option number 2 into question number 1
    And I type "5" as option number 3 into question number 1
    Then I select option number 2 as the correct option of the 1 question
    And I click "Show-Stopper" checkbox in 1 question
    When I add a question
    Then I select "Multiple" question type
    And I type "Which of these is fruit?" into title of the 2 question
    Then I add extra option to the 2 question
    And I add extra option to the 2 question
    And I add extra option to the 2 question
    Then I type "Apple" as option number 1 into question number 2
    And I type "Orange" as option number 2 into question number 2
    And I type "Parrot" as option number 3 into question number 2
    And I type "Mango" as option number 4 into question number 2
    And I type "Potato" as option number 5 into question number 2
    Then I select option number 1 as the correct option of the 2 question
    And I select option number 2 as the correct option of the 2 question
    And I select option number 4 as the correct option of the 2 question
    And I move question number 2 "Up"
#    Use "Up" or "Down" depending on your need
    And I wait for 3 sec
