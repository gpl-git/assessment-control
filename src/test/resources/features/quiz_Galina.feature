@quiz
  Feature: Quiz Scenarios
    Background:
      Given I open "login" page
      When  I type "qa@ask.com" into email filed
      And I type "12345" into password field
      When  I click "Sign In" button
      And I wait for 1 sec

    Scenario: Quiz Title
      When I click on "Quizzes" link
      And I wait for 1 sec
      Then I click "Create New Quiz" button
      And I wait for 1 sec
      When I type "Test Quiz Galina" into quiz title field
      And I add a question
      Then I select "Multiple" question
      When  I type "Question 1 text" into "Q1" input field "Question *"
      When  I type " Option1  text" into "Q1" input field "Option 1*"
      When  I type " Option2  text" into "Q1" input field "Option 2*"
      And I check "Option 1*" as correct in question "Q1"
      When I click "Save" button
      And I wait for 1 sec
      Then "Test Quiz Galina" is displayed on the list of quizzes
      And I wait for 1 sec
      And I click "Test Quiz Galina" and "Delete" in the list of quizzes
