@quiz
  Feature: Quiz Scenarios
    Background:
      Given I open "login" page
      When I type "ask_instr@aol.com" for teacher user
      And I type "12345" as password
      When I click "Sign In" button
      And I wait for 1 sec
      Then "home" page will be displayed
      When I click on "Quizzes" menu item
      And I wait for 1 sec


    @quiz1
    Scenario: Create a quiz
      When I click "Create New Quiz" button
      And I wait for 1 sec
      When I type "Demo Quiz - Automation" as quiz title
      And I add a question
      When I select "Single" question
      And I wait for 1 sec
      When I type "Question 1 text" into "Q1"
      And I type "Option 1" as "Option 1*" in "Q1"
      And I type "Option 2" as "Option 2*" in "Q1"
      Then I select "Option 1*" as correct option in "Q1"
      And I click "Save" button
      And I wait for 1 sec
      Then quiz "Demo Quiz - Automation" is displayed on the list of quizzes
      And I delete quiz "Demo Quiz - Automation"

