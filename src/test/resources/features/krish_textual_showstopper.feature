@texts
  Feature: Textual show stopper quiz
    Background:
      Given I navigate to "login" page
      When I enter "kimree@gamzwe.com" into email field
      And I enter "asdfg" into password field
      When I press "Sign In" button
      And I waited for 1 sec
      And I press "Quizzes" menu item
      And I waited for 2 sec
      When I press "Create New Quiz" button
      And I waited for 1 sec
    @texts1
    Scenario: Create a quiz with textual showstopper
      When I give "Krishna_textual_showstopper" as quiz title
      And I add question
      When I choose "Textual" question type for qn number 1
      Then I waited for 1 sec
      And I enter "Describe Risk Analysis?" into field of "Q1"
      And I waited for 1 sec
      Then I click "Show-Stopper" checkbox for qn 1
      And I waited for 1 sec
      And I press "Preview" button
      Then "Show-Stopper Question" label is displayed near the question
      And I waited for 1 sec
      And I press "Close" button
      Then I waited for 1 sec
      And I press "Save" button
      And I waited for 1 sec
      Then "Krishna_textual_showstopper" is displayed on the list
      And I waited for 1 sec
      And I remove "Krishna_textual_showstopper" from the list of quizzes
      @texts2
      Scenario: Verify only one show stopper per quiz
        When I give "textual_showstopper_krish" as quiz title
        And I add question
        When I choose "Textual" question type for qn number 1
        Then I waited for 1 sec
        And I enter "What is Qa" into field of "Q1"
        And I waited for 1 sec
        Then I click "Show-Stopper" checkbox for qn 1
        And I waited for 1 sec
        And I add question
        Then new panel for qn 2 is displayed
        When I choose "Textual" question type for qn number 2
        Then I waited for 1 sec
        And I enter "What is Scrum" into field of "Q2"
        And I waited for 1 sec
        Then I click "Show-Stopper" checkbox for qn 2
        And I waited for 1 sec
        Then I should check an asterisk displayed near only "Q2"
        And I waited for 1 sec