@quiz
  Feature: Quiz Scenarios

   Background:
      Given I open "login" page
      When I type "ask_instr@aol.com" into email field
      And I type "12345" into password field
      When I click "Sign In" button
      And I wait for 1 sec
      And I click on "Quizzes" link
      And I wait for 1 sec
      When I click "Create New Quiz" button
      And I wait for 2 sec

    @testcase1
    Scenario: Create a quiz with SC question
      Given I type "Test SC Quiz" as quiz title
      When I add a question
      And I select "Single" question type
      When I click "Save" button
      And I wait for 2 sec
      When I type "Question1" as question "Q1" text field "Question *"
      And I type "var1" as question "Q1" option field "Option 1*"
      And I type "var2" as question "Q1" option field "Option 2*"
      And I wait for 2 sec
      When I check "Option 1*" as correct answer in "Q1"
      And I wait for 2 sec
      When I click "Save" button
      And I wait for 3 sec
      Then quiz "Test SC Quiz" should be displayed on the list of quizzess
      And I delete "Test SC Quiz" from the list of quizzes
      And I wait for 2 sec