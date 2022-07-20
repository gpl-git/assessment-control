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


    @QuizTQ1
    Scenario: Allow to create 100 questions total
      When I click button "Create New Quiz"
      And I wait for 1 sec
      When I type "00Test Quiz - Zhanna" as quiz title
      And I add a question
      And I add a question
      And I add a question
      And I add a question
      And I add a question
      And I add a question
      And I add a question
      And I add a question
      And I add a question
      And I add a question
      And I add a question
      And I add a question
      And I add a question
      And I add a question
      And I add a question
      And I add a question
      And I add a question
      And I add a question
      And I add a question
      And I add a question
      And I add a question
      And I add a question
      And I add a question
      And I add a question
      And I add a question
      And I add a question
      And I add a question
      And I add a question
      And I add a question
      And I add a question
      And I add a question
      And I add a question
      And I add a question
      And I add a question
      And I add a question
      And I add a question
      And I add a question
      And I add a question
      And I add a question
      And I add a question
      And I add a question
      And I add a question
      And I add a question
      And I add a question
      And I add a question
      And I add a question
      And I add a question
      And I add a question
      And I add a question
      And I add a question
      And I add a question
      And I add a question
      And I add a question
      And I add a question
      And I add a question
      And I add a question
      And I add a question
      And I add a question
      And I add a question
      And I add a question
      And I add a question
      And I add a question
      And I add a question
      And I add a question
      And I add a question
      And I add a question
      And I add a question
      And I add a question
      And I add a question
      And I add a question
      And I add a question
      And I add a question
      And I add a question
      And I add a question
      And I add a question
      And I add a question
      And I add a question
      And I add a question
      And I add a question
      And I add a question
      And I add a question
      And I add a question
      And I add a question
      And I add a question
      And I add a question
      And I add a question
      And I add a question
      And I add a question
      And I add a question
      And I add a question
      And I add a question
      And I add a question
      And I add a question
      And I add a question
      And I add a question
      And I add a question
      And I add a question
      And I add a question
      And I add a question
      And I add a question
      And I add a question
      Then element with xpath "//mat-panel-title[contains(text(),'Q100: new empty question')]" should be displayed


