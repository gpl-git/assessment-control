@QuizTotalQuestion
  Feature:
    Background:
      Given I go to "login" page
      When I type "ask_instr@aol.com" into email field
      And I enter "12345" as password
      When I click button "Sign In"
      And I wait for 1 sec
      When I click "Quizzes" menu item
      And I wait for 3 sec


    @QuizTQ1 @smoke
    Scenario: Allow to create 51 questions total
      When I click button "Create New Quiz"
      And I wait for 1 sec
      When I type "QA Questions" as quiz title
      When I add up to 51 questions
      Then element with xpath "//mat-panel-title[contains(text(),'Q51: new empty question')]" should be displayed

    @QuizTQ2
    Scenario: Total Questions should not be 0
      When I click button "Create New Quiz"
      And I wait for 1 sec
      When I type "QA Questions" as quiz title
      When I add a question
      And I wait for 2 sec
      And I click button 'Save'
      Then element with xpath "//*[contains(text(),'Quiz is not completed')]" should be displayed
      



