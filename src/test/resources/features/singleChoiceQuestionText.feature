@smoke1
  Feature: Single choice question - Text


    Scenario: Single choice question - Text
      Given I open "login" page
      When I type "allanabyt555@gmail.com" into email field
      Then I type "Slava1" into password field
      And I push "Sign In" button
      When I click "Quizzes" link to open quizzes
      And I click "Create New Quiz" button to create new quiz
      When I type "ABCD" into title field
      And I wait for 2 sec

