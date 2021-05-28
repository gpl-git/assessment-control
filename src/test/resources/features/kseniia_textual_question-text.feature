@quiz
  Feature: Quiz Scenarios

   Background:
      Given I open "login" page
      When I type "qa@ask.com" into email field
      And I type "12345" into password field
      When I click "Sign In" button
      And I wait for 1 sec
      And I click on "Quizzes" link
      And I wait for 1 sec
      When I click "Create New Quiz" button
      And I wait for 1 sec

   @quiz1
   Scenario: Create a quiz with MC question
     Given I type "Quiz title Sample" as quiz title
     When I add a question
     And I select "Multiple" question type
     When I type "Text 1" as question "Q1" text field "Question *"
     And I type "Option 1" as question "Q1" option field "Option 1*"
     And I type "Option 2" as question "Q1" option field "Option 2*"
     And I wait for 1 sec
     When I check "Option 1*" as correct answer in "Q1"
     And I check "Option 2*" as correct answer in "Q1"
     And I wait for 1 sec
     And I click "Save" button
     And I wait for 1 sec
     Then quiz "Quiz title Sample" should be displayed on the list of quizzes
     And I delete "Quiz title Sample" from the list of quizzes
     And I wait for 3 sec

   @quiz2
   Scenario: Verify data inputs using allowable characters: Alphanumeric & Sp. characters
     Given I type "Textual Question Test" as quiz title
     When I add a question
     And I select "Textual" question type
     When I type "Abcd 123 = ,<>?@3%bhyt hjki&" as question "Q1" text field "Question *"
     And I click "Save" button
     And I wait for 1 sec
     Then quiz "Textual Question Test" should be displayed on the list of quizzes
     And I delete "Textual Question Test" from the list of quizzes
     And I wait for 3 sec

    @quiz3
    Scenario: Verify data inputs using min 1 character
      Given I type "Textual Question Test" as quiz title
      When I add a question
      And I select "Textual" question type
      When I type "F" as question "Q1" text field "Question *"
      And I click "Save" button
      And I wait for 1 sec
      Then quiz "Textual Question Test" should be displayed on the list of quizzes
      And I delete "Textual Question Test" from the list of quizzes
      And I wait for 3 sec

   @quiz4
   Scenario: Verify when the field is required
     Given I type "Textual Question Test" as quiz title
     When I add a question
     And I select "Textual" question type
     When I type "" as question "Q1" text field "Question *"
     And I click "Save" button
     And I wait for 1 sec
     Then "Quiz is not completed. Check highlighted with 'red' areas" error message should be displayed
     And I wait for 3 sec

   @quiz5
   Scenario: Verify data inputs using only spaces
     Given I type "Textual Question Test" as quiz title
     When I add a question
     And I select "Textual" question type
     When I type "            " as question "Q1" text field "Question *"
     And I click "Save" button
     And I wait for 1 sec
     Then "Question field is not accepted spaces characters" error message should be displayed
      #Expected result: "Question field is not accepted spaces characters" error message should be displayed
      #Actual result: Application allow to save Quiz Title using only spaces
      #Bug number SA-469 is reported
     And I wait for 3 sec

   @quiz6
   Scenario: Verify data inputs using max 1000 characters
      Given I type "Textual Question Test" as quiz title
      When I add a question
      And I select "Textual" question type
      When I type 1000 as question "Q1" text field "Question *"
      And I click "Save" button
      And I wait for 1 sec
      Then quiz "Textual Question Test" should be displayed on the list of quizzes
      And I delete "Textual Question Test" from the list of quizzes
      And I wait for 3 sec



    @quiz7
    Scenario: Verify data inputs using 1001 characters
      Given I type "Textual Question Test" as quiz title
      When I add a question
      And I select "Textual" question type
      When I type max+1 as question "Q1" text field "Question *"
      And I click "Save" button
      And I wait for 1 sec
      Then "Question field is accepted max 1000 characters" error message should be displayed
      #Expected result: "Question field is accepted max 1000 characters" error message should be displayed
      #Actual result: Application allow to save Quiz Title with more than 1000 characters
      #Bug number SA-346 is reported
      And I wait for 3 sec
