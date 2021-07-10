@singleChoice
  Feature: Single Choice Question Options

    Background:
      Given I go to "login" page
      When I type "ask_instr@aol.com" into email field
      And I type "12345" into password field
      When I click on "Sign In" button
      And I wait for 1 sec
      Then I verify current url as "home"
      When I click on "Quizzes" tab
      And I wait for 1 sec

      @singleChoice1
      Scenario: Create Single Choice Quiz
        When I click on "Create New Quiz" button
        And I wait for 1 sec
        And I type "Juno" as quiz title
        When I add a question
        And I select "Single" question type
        When I type question text "Question1" into "Q1"
        And I type "Option 1" as option "Option 1*" into "Q1"
        And I type "Option 2" as option "Option 2*" into "Q1"
        When I select "Option 2*" as correct option in "Q1"
        And I wait for 2 sec
        When I click on "Save" button
        And I wait for 1 sec
        Then quiz "Juno" should be displayed on the list of quizzes
        And I delete "Juno" from the list of quizzes

        @singleChoice2
        Scenario: Single Choice Quiz Total Number of Options
          When I click on "Create New Quiz" button
          And I wait for 1 sec
          And I type "Juno" as quiz title
          When I add a question
          And I select "Single" question type
          When I type question text "Question1" into "Q1"
          And I type "Option 1" as option "Option 1*" into "Q1"
          When I select "Option 1*" as correct option in "Q1"
          And I add 10 Options in "Q1"
          And I wait for 2 sec
          Then quiz "Juno" should be displayed on the list of quizzes
          And I delete "Juno" from the list of quizzes

#          Issue : Max 15 options but possible to create more and no Error Message






