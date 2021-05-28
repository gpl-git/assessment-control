@quiz
  Feature: Quiz Scenarios

   Background:
      Given I open "login" page
      When I type "ask_instr@aol.com" into email field
      And I type "12345" into password field
      When I click "Sign In" button
      And I wait for 1 sec
      And I click on "Quizzes" link
      And I wait for 1 sec
      When I click "Create New Quiz" button
      And I wait for 2 sec

    @testcase1
    Scenario: Create a quiz with SC question
      Given I type "Test SC Quiz" as quiz title
      When I add a question
      And I select "Single" question type
      When I click "Save" button
      And I wait for 2 sec
      When I type "Question1" as question "Q1" text field "Question *"
      And I type "var1" as question "Q1" option field "Option 1*"
      And I type "var2" as question "Q1" option field "Option 2*"
      And I wait for 2 sec
      When I check "Option 1*" as correct answer in "Q1"
      And I wait for 2 sec
      When I click "Save" button
      And I wait for 3 sec
      Then quiz "Test SC Quiz" should be displayed on the list of quizzess
      And I delete "Test SC Quiz" from the list of quizzes
      And I wait for 2 sec

    @testcase2
    Scenario: Single Choice Question - Option: Max 1000 characters
      Given I type "Test SC option" as quiz title
      When I add a question
      And I select "Single" question type
      And I wait for 2 sec
      When I type "Question1" as question "Q1" text field "Question *"
      And I type "var1" as question "Q1" option field "Option 1*"
      And I type "var2" as question "Q1" option field "Option 2*"
      And I wait for 2 sec
      When I click "Save" button
      And I wait for 2 sec
      Then quiz "Test SC option" should be displayed on the list of quizzess
      When I delete "Test SC option" from the list of quizzes
      And I wait for 1 sec

    @testcase3
    Scenario: Single Choice Question - Option: Max 15 choice
      Given I type "15 Test SC option" as quiz title
      When I add a question
      And I select "Single" question type
      And I wait for 2 sec
      When I type "Question1" as question "Q1" text field "Question *"
      And I type "var1" as question "Q1" option field "Option 1*"
      And I type "var1" as question "Q1" option field "Option 2*"
      And I wait for 2 sec
      And I check "Option 1*" as correct answer in "Q1"
      When I add options in "Q1" up to 15
      When I click "Save" button
      And I wait for 4 sec
      Then quiz "15 Test SC option" should be displayed on the list of quizzess
      And I wait for 1 sec

      @testcase4
      Scenario: Single Choice Question - Option: Max 1000 characters +1
        Given I type "Test SC option" as quiz title
        When I add a question
        And I select "Single" question type
        And I wait for 2 sec
        When I type "Question1" as question "Q1" text field "Question *"
        And I type "var1" as question "Q1" opt field "Option 1*"
        And I type "var1" as question "Q1" opt field "Option 1*"
        And I wait for 2 sec
        And I check "Option 1*" as correct answer in "Q1"
        When I click "Save" button
        And I wait for 2 sec
        Then quiz "Test SC option" shouldn`t be displayed on the list of quizzess
        And I wait for 1 sec

      @testcase5
      Scenario: Single Choice Question - Option: Max 15 choice +1
        Given I type "16 Test SC option" as quiz title
        When I add a question
        And I select "Single" question type
        And I wait for 2 sec
        When I type "Question1" as question "Q1" text field "Question *"
        And I type "var1" as question "Q1" option field "Option 1*"
        And I type "var1" as question "Q1" option field "Option 2*"
        And I wait for 2 sec
        And I check "Option 1*" as correct answer in "Q1"
        When I add options in "Q1" more than 16
        When I click "Save" button
        And I wait for 4 sec
        Then quiz "16 Test SC option" shouldn`t be displayed on the list of quizzess
        And I wait for 1 sec

      @testcase6
      Scenario: Single Choice Question - Option: Cannot be empty
        Given I type "Test SC option" as quiz title
        When I add a question
        And I select "Single" question type
        And I wait for 2 sec
        When I type "Question1" as question "Q1" text field "Question *"
        And I type "var1" as question "Q1" option field "Option 1*"
        And I wait for 2 sec
        And I check "Option 1*" as correct answer in "Q1"
        And I click "Save" button
        And I wait for 2 sec
        Then "error message" should appear

      @testcase7
      Scenario: Single Choice Question - Option: Min 1 character
        Given I type "Test SC option" as quiz title
        When I add a question
        And I select "Single" question type
        And I wait for 2 sec
        When I type "Question1" as question "Q1" text field "Question *"
        And I type "var1" as question "Q1" option "Option 1*"
        And I type "var1" as question "Q1" option "Option 2*"
        And I wait for 2 sec
        And I check "Option 1*" as correct answer in "Q1"
        And I click "Save" button
        And I wait for 2 sec
        Then quiz "Test SC option" should be displayed on the list of quizzess
        When I delete "Test SC option" from the list of quizzes
        And I wait for 1 sec

      @testcase8
      Scenario: Single Choice Question - Option: Min 2 choices
        Given I type "Test SC option" as quiz title
        When I add a question
        And I select "Single" question type
        And I wait for 2 sec
        When I type "Question1" as question "Q1" text field "Question *"
        And I type "var1" as question "Q1" option field "Option 1*"
        And I type "var1" as question "Q1" option field "Option 2*"
        And I wait for 3 sec
        And I check "Option 1*" as correct answer in "Q1"
        And I click "Save" button
        And I wait for 2 sec
        Then quiz "Test SC option" should be displayed on the list of quizzess
        When I delete "Test SC option" from the list of quizzes
        And I wait for 1 sec