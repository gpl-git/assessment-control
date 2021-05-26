@quizTotalQuestions
  Feature: Automate test set "Quiz - Total Questions". Verify "Total Questions" number in a quiz card represents the number of questions in the quiz
    Background:
      Given I open "login" page
      When I type "avictoralvespall@pisalak.com" into email field
      And I type "12345" into password field
      When I click "Sign In" button
      And I wait for 1 sec
      And I click on "Quizzes" link
      And I wait for 1 sec
      When I click "Create New Quiz" button
      And I wait for 1 sec

    @quizTotalQuestions1
    Scenario: Verify a quiz with 1 question has the quiz card with 1 "Total Questions"
      Given I created a quiz with 1 total question
      When I wait for 2 sec
      When I click on the quiz card
      Then I verify the quiz card has "1 Question(s)" in the title
      Then I verify the `Total Question` row has value "1"
      When I open the preview of the quiz
      Then I verify the string "Question 1 / 1" is displayed in the preview mode
      When I delete the quiz

    @quizTotalQuestions2
    Scenario: Verify a quiz with 50 question has the quiz card with 50 "Total Questions"
      Given I created a quiz with 50 total question
      When I wait for 2 sec
      When I click on the quiz card
      Then I verify the quiz card has "50 Question(s)" in the title
      Then I verify the `Total Question` row has value "50"
      When I open the preview of the quiz
      Then I verify the string "Question 1 / 50" is displayed in the preview mode
      When I delete the quiz

