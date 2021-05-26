@quiz
  Feature: Multiple Choice Quiz

    @quiz1
    Scenario: Create a  Multiple Choice Text Question
      Given I navigate "login" page
      When I enter email "azizarozi@gmail.com"
      And I enter password "12345"
      Then I click sign in
      And I wait for 2 sec
      And I click on "Quizzes"
      And I wait for 2 sec
      And I click "Create New Quiz"
      And I wait for 1 sec
      When I type "Aziza Multiple Choice" as the title
      And I click add a question
      And I wait for 1 sec
      And I select "Textual" question
      And I wait for 1 sec
      When I type "Aziza's Test Question" as "Q1" text field "Question *"
      And I wait for 1 sec
      And I check box for "Show Stopper" question
      And I wait for 1 sec
      Then I press "Save" button
      And I wait for 2 sec

