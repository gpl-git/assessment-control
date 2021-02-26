@question

  Feature: Single Choice Question Scenarios

    Background:
      Given I open "ask" page

    @question1
    Scenario: Verify '*' symbol is displayed when creating show stopper single question quiz
      When I type "qa@ask.com" into email field
      And I type "12345" into password field
      When I click "Sign in" btn
      And I wait for 1 sec
      Then I verify that user role "TEACHER" is displayed
      When I go to "Quizzes" section
      And I wait for 1 sec
      Then I click button "Create New Quiz"
      And I wait for 2 sec
      And I type "Single Choice Question - Show-Stopper - test2" into title field
      And I click on "Add Question" btn
      And I wait for 2 sec
      And I click radio-button "Single-Choice"
      Then I check "Show-Stopper" checkbox
      And I verify that "Q1*: new empty question" present
      And I wait for 2 sec

    @question2
    Scenario: Verify that 'show stopper' on preview
      When I type "qa@ask.com" into email field
      And I type "12345" into password field
      When I click "Sign in" btn
      And I wait for 1 sec
      Then I verify that user role "TEACHER" is displayed
      When I go to "Quizzes" section
      And I wait for 1 sec
      Then I click button "Create New Quiz"
      And I wait for 2 sec
      And I type "Single Choice Question - Show-Stopper - test2" into title field
      And I click on "Add Question" btn
      And I wait for 2 sec
      And I click radio-button "Single-Choice"
      And I wait for 1 sec
      Then I type "Choose a" into text field
      And I wait for 1 sec
      And I type "a" into option field
      And I type "b" into field
      And I wait for 2 sec
      Then I check "Option 1*" radio-button
      And I check "Show-Stopper" checkbox
      And I wait for 2 sec
      And I click on Preview button
      When I verify that "Show-Stopper Question" displayed

    @question3
    Scenario: Verify 'Show stopper sign' is displayed when student start the quiz
      When I type "qa@ask.com" into email field
      And I type "12345" into password field
      When I click "Sign in" btn
      And I wait for 1 sec
      Then I verify that user role "TEACHER" is displayed
      When I go to "Assignments" part
      And I click on "Create New Assignment" mat-button
      And I wait for 2 sec
      Then I choose group "ABC"
      And I wait for 1 sec
      And I choose quiz DONT DELETE
      And I wait for 2 sec
      And I check "Student Four"
      And I wait for 2 sec
      And I click on the "Give Assignment"
      And I wait for 2 sec
      When I log out
      And I confirm logging out
      Then I type student email "student5@test.com" into email field
      And I type "12345" into password field
      When I click "Sign in" btn
      And I wait for 1 sec
      Then I verify that student role "STUDENT" is displayed
      When I click on Go To My Assignments
      And I click on Go To Assessment
      And I wait for 2 sec
      When I verify that "Show-Stopper Question" displayed











