
@textual
Feature: Jira task DEC-733 Verify Textual Question - Text in Quiz
 Background:
    Given I go to "login" page
    When I type "andrewdocksey@ecallen.com" into email field
    And I type "password" into password field
    When  I click "Sign In" button
    And I wait for 2 sec
    When I click "Quizzes" link
    And I wait for 3 sec

  @textual1
  Scenario: Creating a Quiz - Textual question - Happy path
    When I click "Create New Quiz" button
    And I wait for 1 sec
    And I type "OBQuiz" as the quiz title
    And I add a question
    And I select "Textual" question type
    When I type "What's your name?" into "Q1"
    And I wait for 3 sec
    And I click "Save" button
    And I wait for 2 sec
    Then quiz "OBQuiz" should be displayed on the list of quizzes
    And I delete "OBQuiz"

    @textual2
    Scenario: To verify that Alphanumeric & Special Characters can be entered in the “Question” input text field.
    When I click "Create New Quiz" button
    And I wait for 1 sec
    And I type "OBQuiz" as the quiz title
    And I add a question
    And I select "Textual" question type
    When I type "What is QA qa123 #@&%?" into "Q1"
    And I wait for 3 sec
    And I click "Save" button
    And I wait for 2 sec
    Then quiz "OBQuiz" should be displayed on the list of quizzes
    And I delete "OBQuiz"

    @textual3
      Scenario: Verify that min 1 Character can be entered in the “Question” input text field
      When I click "Create New Quiz" button
      And I wait for 1 sec
      And I type "OBQuiz" as the quiz title
      And I add a question
      And I select "Textual" question type
      When I type "A" into "Q1"
      And I wait for 3 sec
      And I click "Save" button
      And I wait for 2 sec
      Then quiz "OBQuiz" should be displayed on the list of quizzes
      And I delete "OBQuiz"

     @textual4
     Scenario: Verify Error Message "The field is required" pops up if user leaves “Question” input text field blank
       When I click "Create New Quiz" button
       And I wait for 1 sec
       And I type "OBQuiz" as the quiz title
       And I add a question
       And I select "Textual" question type
       When I type "" into "Q1"
       And I wait for 3 sec
       And I click "Save" button
       Then Error message "This field is required" should be displayed
       And I wait for 2 sec


     @textual5
     Scenario: Verify that Max 1000,  characters can be entered in the “Question” input text
       When I click "Create New Quiz" button
       And I wait for 1 sec
       And I type "OBQuiz" as the quiz title
       And I add a question
       And I select "Textual" question type
       And I wait for 3 sec
       When I  enter 1000 alphanumeric characters into "Q1"
       And I wait for 3 sec
       And I click "Save" button
       And I wait for 2 sec
       Then quiz "OBQuiz" should be displayed on the list of quizzes
       And I delete "OBQuiz"

      @textual6
      Scenario: Verify that Max 1001,  characters can be entered in the “Question” input text
        When I click "Create New Quiz" button
        And I wait for 1 sec
        And I type "OBQuiz" as the quiz title
        And I add a question
        And I select "Textual" question type
        And I wait for 3 sec
        When I  enter 1001 alphanumeric characters into "Q1"
        And I wait for 3 sec
        And I click "Save" button
        And I wait for 2 sec
        Then quiz "OBQuiz" should be displayed on the list of quizzes
        And I delete "OBQuiz"

#       Known  Bug DEC-407

  @textual7
  Scenario: Verify that Error Message "This field is required" pops up if user only enters a white space in “Question” input text field
    When I click "Create New Quiz" button
    And I wait for 1 sec
    And I type "OBQuiz" as the quiz title
    And I add a question
    And I select "Textual" question type
    And I wait for 3 sec
    When I enter " " characters into "Q1"
    And I wait for 3 sec
    And I click "Save" button
    And I wait for 2 sec
    Then quiz "OBQuiz" should be displayed on the list of quizzes
    And I delete "OBQuiz"


