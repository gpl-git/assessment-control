@texts
  Feature: Textual show stopper quiz
    Background:
      Given I navigate to "login" page KR
      When I enter "kimree@gamzwe.com" into email field KR
      And I enter "asdfg" into password field KR
      When I press "Sign In" button KR
      And I waited for 1 sec KR
      And I press "Quizzes" menu item KR
      And I waited for 2 sec KR
      When I press "Create New Quiz" button KR
      And I waited for 1 sec KR
    @texts1
    Scenario: Create a quiz with textual showstopper
      When I give "Krishna_textual_showstopper" as quiz title KR
      And I add question KR
      When I choose "Textual" question type for qn number 1 KR
      Then I waited for 1 sec KR
      And I enter "Describe Risk Analysis?" into field of "Q1" KR
      And I waited for 1 sec KR
      Then I click "Show-Stopper" checkbox for qn 1 KR
      And I waited for 1 sec KR
      And I press "Preview" button KR
      Then "Show-Stopper Question" label is displayed near the question KR
      And I waited for 1 sec KR
      And I press "Close" button KR
      Then I waited for 1 sec KR
      And I press "Save" button KR
      And I waited for 1 sec KR
      Then "Krishna_textual_showstopper" is displayed on the list KR
      And I waited for 1 sec KR
      And I remove "Krishna_textual_showstopper" from the list of quizzes KR
      @texts2
      Scenario: Verify only one show stopper per quiz
        When I give "textual_showstopper_krish" as quiz title KR
        And I add question KR
        When I choose "Textual" question type for qn number 1 KR
        Then I waited for 1 sec KR
        And I enter "What is Qa" into field of "Q1" KR
        And I waited for 1 sec KR
        Then I click "Show-Stopper" checkbox for qn 1 KR
        And I waited for 1 sec KR
        And I add question KR
        Then new panel for qn 2 is displayed KR
        When I choose "Textual" question type for qn number 2 KR
        Then I waited for 1 sec KR
        And I enter "What is Scrum" into field of "Q2" KR
        And I waited for 1 sec KR
        Then I click "Show-Stopper" checkbox for qn 2 KR
        And I waited for 1 sec KR
        Then I should check an asterisk displayed near only "Q2" KR
        And I waited for 1 sec KR