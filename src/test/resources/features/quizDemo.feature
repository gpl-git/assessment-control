@demo
  Feature: Quiz Demo

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
    @quiz1
    Scenario: Create a Quiz
      When I type "Demo Quiz 03.30.23" in title field
      And I add question
      Then I select "Single" question type
      When I type "Question 1" into textarea of "Q1"
      And I type "Option 1" into "Option 1*" field in "Q1"
      And I type "Option 2" into "Option 2*" field in "Q1"
      Then I select "Option 1*" as correct option in "Q1"
      And I click "Save" button
      And I wait for 2 sec
      Then title "Demo Quiz 03.30.23" is displayed on the list of quizzes
      And I delete "Demo Quiz 03.30.23" from the list of quizzes
      And I wait for 2 sec





