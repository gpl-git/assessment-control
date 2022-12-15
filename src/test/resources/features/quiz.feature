@quiz
  Feature: Quiz Demo
    Background:
      Given I open "login" page
      When I type "ask_instr@aol.com" into email input field
      And I type"12345" into password field
      When I click "Sign In" button
      And I wait for 1 sec
      
    @quiz1
    Scenario: Create a quiz
      When I click "Quizzes" menu item
      And I wait for 1 sec
      When I click "Create New Quiz" button
      And I wait for 1 sec
      When I enter "Demo Quiz Galina 12/14/22" as quiz title
      And I add a question
      When I select "Single" question
      When I type "Question 1" into "Q1" textarea
      And I type "Option 1" into "Option 1*" field in "Q1"
      And I type "Option 2" into "Option 2*" field in "Q1"
      When I select "Option 1*" as correct option in "Q1"
      When I click "Save" button
      And I wait for 1 sec
      Then quiz "Demo Quiz Galina 12/14/22" is displayed on the list of quizzes
      And I wait for 1 sec
      And I delete quiz "Demo Quiz Galina 12/14/22"