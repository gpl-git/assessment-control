@predefined
  Feature: Single-choice Question

   @predefined1
    Scenario: Single-choice question text
     Given I open "login" website
     When I type "zakarpoghosyan@gmail.com" into email field
     When  I type "12345" into password field
     And I click "Sign In" button
     And I wait for 1 sec
     When I click "Quizzes" menu item
     And I wait for 1 sec
     And I click "Create New Quiz" button
     And I wait for 1 sec
     When I type "Test Quiz by Zakar" as quiz title
     Then I add question
     When I select "Single" question type
     When I type "Question 1" into "Q1"
     And I type "Option 1" into "Q1" as "Option 1*"
     And I type "Option 2" into "Q1" as "Option 2*"
     When I select "Option 1*" as correct option in "Q1"
     When I click "Save" button
     And I wait for 2 sec
     Then title "Test Quiz by Zakar" should be displayed on the list of quizzes
     And I delete quiz  "Test Quiz by Zakar"
     And I wait for 3 sec