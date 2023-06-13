@texts
  Feature: Textual show stopper quiz
    Background:
      Given I navigate to "login" page
      When I enter "kimree@gamzwe.com" into email field
      And I enter "asdfg" into password field
      When I press "Sign In" button
      And I waited for 1 sec
      And I press "Quizzes" menu item
      And I waited for 1 sec
      When I press "Create New Quiz" button
      And I waited for 1 sec
    @texts1
    Scenario: Create a quiz with textual showstopper
      When I give "Krishna_textual_showstopper" as quiz title
      And I add question
      When I choose "Textual" question type
      Then I waited for 1 sec
      And I enter "Describe Risk Analysis?" into field of "Q1"
      And I waited for 1 sec
      Then I click "Show-Stopper" checkbox
      And I waited for 1 sec
      And I press "Preview" button
      Then "Show-Stopper Question" is displayed near the question
      And I waited for 1 sec
      And I press "Close" button
      Then I waited for 1 sec
      And I press "Save" button
      And I waited for 1 sec
      Then "Krishna_textual_showstopper" is displayed on the list
