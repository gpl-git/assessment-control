@quiz_m_o
  Feature: Multiple Choice Questions - Options

    Background:
      Given I go to the website "ask"
      When I enter valid "ask_instr@aol.com" into email field
      Then I enter valid "12345" into password field
      And I click the "Sign In" button
      And I wait for 2 sec
      Then I go to "Quizzes" page
      And I wait for 2 sec
      And I click the "Create New Quiz" button
      And I wait for 2 sec
      Then I enter title "Multiple-Choice question" into quiz field
      And I click button to add a question
      And I wait for 2 sec
      Then I choose "Multiple-Choice" question
      And I wait for 2 sec


    @quiz_m_o1
    Scenario: Verify Multiple-Choice question has 2 options
      Then I type question "Multiple-Choice question has 2 options" into "Q1" question field
      And I wait for 2 sec
      Then I verify that question "Q1" has 2 options
      And I wait for 2 sec
      Then I select first and last correct option from 2 option "Q1" question 
      Then I click the "Save" button

    @quiz_m_o2
    Scenario: Verify Multiple-Choice question has 15 options
      Then I type question "Multiple-Choice question has 15 options" into "Q1" question field
      And I wait for 2 sec
      Then I click "Add Option" button and add 15 options
      And I wait for 2 sec
      Then I verify that question "Q1" has 15 options
      And I wait for 2 sec
      Then I select first and last correct option from 15 option "Q1" question
      Then I click the "Save" button

    @quiz_m_o3
    Scenario: Verify Multiple-Choice question has MAX 15 options
      Then I type question "Multiple-Choice question has MAX 15 options" into "Q1" question field
      And I wait for 2 sec
      Then I click "Add Option" button and add 16 options
      And I wait for 2 sec
      Then I verify that question "Q1" has 16 options
      And I wait for 2 sec
      Then I select first and last correct option from 16 option "Q1" question
      Then I click the "Save" button
      And I wait for 2 sec
      Then I verify the error message "Max number of options is 15"

    @quiz_m_o4
    Scenario: Verify Multiple-Choice question has 15 options and "Other" text area
      Then I type question "Multiple-Choice question has 15 options and 'Other' text area" into "Q1" question field
      And I wait for 2 sec
      Then I click "Add Option" button and add 15 options
      And I wait for 2 sec
      Then I verify that question "Q1" has 15 options
      And I wait for 2 sec
      Then I select first and last correct option from 15 option "Q1" question
      Then I include Other text area option for this question

    @quiz_m_o5***
    Scenario: Verify Multiple-Choice question is added/saved when option(s) text field has input(s)
      Then I type question "Multiple-Choice question is added/saved when option(s) text field has input(s)" into "Q1" question field
      And I wait for 2 sec
      Then I verify that question "Q1" has 2 options
      And I wait for 2 sec
      Then I select first and last correct option from 2 option "Q1" question
      Then I click the "Save" button
      And I wait for 2 sec
      Then I verify that the quiz "Multiple-Choice question" is saved and question "Multiple-Choice question is added/saved when option(s) text field has input(s)" is displayed

    @quiz_m_o6
    Scenario: Verify error message is displayed if Multiple-Choice question option text field has no input
      Then I type question "Multiple-Choice question option text field has no input" into "Q1" question field
      Then I click "Save" button
      And I wait for 2 sec
      Then I verify the error message "Quiz is not completed"

    @quiz_m_o7
    Scenario: Verify Multiple-Choice question option text field doesn't accept spaces(white spaces) as input
      Then I type question "Multiple-Choice question option text field doesn't accept white spaces as input" into "Q1" question field
      Then I enter white spaces into 2 default options field of "Q1"
      And I wait for 2 sec
      Then I click "Save" button
      And I wait for 2 sec
      Then I verify the error message "Quiz is not completed"








