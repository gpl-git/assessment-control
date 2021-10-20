@predefined
  Feature: Quiz Builder
    @predefined1
    Scenario: Sample Quiz
      Given I open "login" page
      When I type "ask_instr@aol.com" into email field
      And I type "12345" into the password field
      When I click "Sign In" button
      And I wait for 1 sec
      When I click on "Quizzes" menu
      And I wait for 1 sec
      And I click "Create New Quiz" button
      And I wait for 1 sec
      When I type "Test Quiz Predefined" as quiz title
      And I add a question
      And I wait for 1 sec
      When I select "Single" question type
      And I wait for 1 sec
      And I type "Question 1 text" into "Q1"
      When I type "Option 1" as "Option 1*" into "Q1"
      When I type "Option 2" as "Option 2*" into "Q1"
      And I select "Option 1*" as correct option in "Q1"
      When I click "Save" button
      And I wait for 1 sec
      Then "Test Quiz Predefined" is displayed on the list of quizzes
      And I wait for 2 sec
      And I delete "Test Quiz Predefined" from the list of quizzes

      
      


