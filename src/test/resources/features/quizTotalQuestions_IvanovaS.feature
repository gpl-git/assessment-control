@totalQuestions
  Feature: Quiz-Total Questions
    Background:
      Given I go to "login" page
      When I type "ask_instr@aol.com" into email field
      And I type "12345" into password field
      When I click "Sign In" button
      And I wait for 1 sec
      When I click "Quizzes" menu item
      And I wait for 1 sec
      And I click "Create New Quiz" button
      And I wait for 1 sec

    @totalQuestions1
    Scenario: Quiz allows up to 50 questionsg
      When I type "RS test Quiz 1 (49)" in title field
      Then I create 49 questions
      And I click "Save" button
      And I wait for 2 sec
      Then title "RS test Quiz 1 (49)" is displayed on the list of quizzes and have 49 total questions
      And I wait for 3 sec
      And I delete "RS test Quiz 1 (49)"


      


      
      

