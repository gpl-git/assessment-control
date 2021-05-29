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
      And I wait for 1 sec

   @quiz1
   Scenario: Create a quiz with MC question
     Given I type "Quiz title Sample" as quiz title
     When I add a question
     And I select "Multiple" question type
     When I type "Text 1" as question "Q1" text field "Question *"
     And I type "Option 1" as question "Q1" option field "Option 1*"
     And I type "Option 2" as question "Q1" option field "Option 2*"
     And I wait for 1 sec
     When I check "Option 1*" as correct answer in "Q1"
     And I check "Option 2*" as correct answer in "Q1"
     And I wait for 1 sec
     And I click "Save" button
     And I wait for 1 sec
     Then quiz "Quiz title Sample" should be displayed on the list of quizzes
     And I delete "Quiz title Sample" from the list of quizzes
     And I wait for 3 sec
     @quiz2
     Scenario: Create a quiz with Texual question
       Given I type "Textual Test" as quiz title
       And I add a question
       And I select "Textual" question type

