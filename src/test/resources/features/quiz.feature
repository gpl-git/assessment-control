@quiz
  Feature: Quiz Builder Scenarios

    Background:
      Given I open "login" page
      When I type "ask_instr@aol.com" into email field
      And I type "12345" into password field
      When click on "Sign In" button
      And I wait for 1 sec
      Then I click "Quizzes" link
      And I wait for 1 sec
      And click on "Create New Quiz" button
      And I wait for 2 sec

    @quiz1
    Scenario: Create a Quiz
      Then I verify that current url contains "quiz-builder"
      When I type "Quiz Test" as a quiz title
      And I add a question
      When I select "Textual" question in question "Q1"
      And I type "Test Question" as question text into question "Q1"
      And I wait for 1 sec
      When click on "Save" button
      And I wait for 1 sec
      Then "Quiz Test" should be displayed on the list of quizzes
      And I delete "Quiz Test" from the list of quizzes
      And I wait for 2 sec
      
