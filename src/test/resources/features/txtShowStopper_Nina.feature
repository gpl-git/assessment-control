@textshowstopper
  Feature: Textual question showstopper
    Background:
      Given I go to "login" page
      When I type "vtahajouha@tirtalayana.com" into email field
      And I type "M12345" into password field
      When I click "Sign In" button
      And I wait for 1 sec
      And I click on "Quizzes" link
      And I wait for 1 sec
    Scenario: Creating a quiz with a textual showstopper question
      When I click "Create New Quiz" button
      And I wait for 1 sec
      And I type "Nina Quiz" as quiz title
      When I add a question
      And I select "Textual" question type
      And I wait for 1 sec
      When I type "Question 1" into "Q1"
      And I check the checkbox Show-Stopper
      Then the question number "Q1" should contain the symbol *
      When I uncheck Show-Stopper
      Then the question number "Q1" should not contain the symbol *
      And I wait for 1 sec
      When I check the checkbox Show-Stopper
      And I click "Preview" button
      And I wait for 1 sec
      Then I should see a new window Preview Mode
      And I should see the label Show-Stopper Question
      When I click "Close" button
      And I click "Save" button
      And I wait for 1 sec
      Then quiz "Nina Quiz" should be displayed on the list of quizzes
      And I delete "Nina Quiz" from the list of quizzes