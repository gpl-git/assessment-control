@quiz @smoke
  Feature: Quiz Scenarios
    Background: 
      Given I go to "ask"
      When I enter "ask_instr@aol.com" into email field
      And I enter "12345" into password field
      When I click "Sign In" button
      And I wait for 1 sec
    
    @quiz1
    Scenario: Quiz Happy Path
      When I go to the page "Quizzes" and validate page details
      And I wait for 1 sec
      When I click "Create New Quiz" button
      And I wait for 1 sec
      And I enter "Test Quiz Galina" into quiz title field
      When I add a question
      And I wait for 1 sec
      Then I select "Textual" question
      And I wait for 1 sec
      And I type "Question 1 Test" into "Q1" question input field
      And I wait for 1 sec
      When I click "Save" button
      And I wait for 1 sec
      Then title "Test Quiz Galina" is displayed on the list of quizzes
      And I delete "Test Quiz Galina" quiz
      