@smoke1
  Feature: Single choice question - Text


    Scenario: Single choice question - Text Happy pass
      Given I open "login" page
      When I type "allanabyt555@gmail.com" into email field
      Then I type "Slava1" into password field
      And I click "Sign In" button
      When I click "Quizzes" link to open quizzes
      And I click "Create New Quiz" button to create new quiz
      When I type "ABCD" into title field
      And I click "Add Question" button to add question
      When I click "Single-Choice" button to create single choice quiz
      And I type "What is your name?" into question field
      When I type "Alla" into optionOne field
      And I type "Alina" into optionTwo field
      When I click "radio button one" to choose first option
      And I click "Save" button to save new quiz
      And I wait for 2 sec



