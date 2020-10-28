
  @quiz
    Feature: Quiz Scenarios

      Scenario: Create Quiz
        Given I open "login" page
        When I type "ask_instr@aol.com" as Email
        And I type "12345" as Password
        And I click "Sign In" button
        And I wait for 2 sec
        When I click "Quizzes" link
        And I wait for 1 sec
        When I click "Create New Quiz" button
        And I wait for 2 sec
        And I enter "bnbnbn" as quiz title
        Then I add question
        And I select "Single" question type
        And I wait for 2 sec
        When I type "some question" into "Q1" as "Question *"
        And I wait for 2 sec
        When I type "some question" into "Q1" as "Option 1*" question option
        And I wait for 1 sec
        When I type "some question" into "Q1" as "Option 2*" question option
        And I wait for 1 sec
        And I check "Option 1*" as correct  in question "Q1"
        And I wait for 1 sec
#        And I click "Add Option" button

        Then I click "Save" button
        And I wait for 5 sec
        


        


