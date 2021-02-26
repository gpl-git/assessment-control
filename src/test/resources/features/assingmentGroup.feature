@assignmentGroup
  Feature: Assignment - Group

    Background:
      Given I go to this page ask
      Then I enter "qa@ask.com" into email field
      And I enter "12345" into password field
      And I click "Sign In" button
      And I wait for 2 sec
      Then I click on Assignments
      And I click Create New Assignment button

    @assignmentGroup1
    Scenario: Validate quiz assignment by group - Positive TC
      Then I click to see the list of groups
      And I choose group "ABC"
      And I click to see the list of quizzes
      And I wait for 2 sec
      And I choose "BDD" quiz
      And I click Select All button
      And I click Give Assignment button
      And I wait for 2 sec
      Then quiz "BDD" is displayed on the list of assignments
      Then I delete assignment with quiz "BDD"

    @assignmentGroup2
    Scenario: Validate quiz assignment by group - Can't assign without selecting a quiz
      Then I click to see the list of groups
      And I choose group "ABC"
      And I click Select All button
      And I click Give Assignment button
      Then I should see this error message "Select Quiz To Assign"

    @assignment3
      Scenario: Validate quiz assignment by group - Can't assign without selecting at least 1 student
        Then I click to see the list of groups
        And I choose group "ABC"
        And I click to see the list of quizzes
        And I choose "BDD" quiz
        And I click Give Assignment button
        Then I should see this error message "Select at least one Student"

