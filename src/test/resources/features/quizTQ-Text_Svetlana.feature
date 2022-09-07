  @quizTQ-Text @smoke
  Feature: Textual Question - Text

    Background:
      Given I go to "login" page
      When I type "ask_instr@aol.com" into email field
      And I type "12345" into  password field
      When I click "Sign In" button
      And I wait 3 sec
      When I click "Quizzes" menu item
      And I wait 1 sec
      When I click "Create New Quiz" button
      And I wait 1 sec
      When I type "000 UI Automation - Svetlana5" as quiz title
      And I add a question
      When I select "Textual" question type

    @quizTQ-Text1
      Scenario: Create a Quiz (Happy Path)
      When I enter "Question Text 1" into "Q1"
      When I click "Save" button
      And I wait 1 sec
      Then I verify that "000 UI Automation - Svetlana5" is displayed on the list of quizzes
      And I wait 3 sec
      And I delete "000 UI Automation - Svetlana5" from the list of quizzes

    @quizTQ-Text2
      Scenario: Verify TQ field accepts alphanumeric & special characters
      When I enter "*&2^%^&**&&755" into "Q1"
      When I click "Save" button
      And I wait 1 sec
      Then I verify that "000 UI Automation - Svetlana5" is displayed on the list of quizzes
      And I wait 3 sec
      And I delete "000 UI Automation - Svetlana5" from the list of quizzes

    @quizTQ-Text3
      Scenario: Verify TQ field is required and can not be empty
      When I click "Save" button
      And I wait 1 sec
      Then error message "This field is required" is displayed

    @quizTQ-Text4
      Scenario: Verify TQ field allows minimum 1 character
      When I enter "Q" into "Q1"
      When I click "Save" button
      And I wait 1 sec
      Then I verify that "000 UI Automation - Svetlana5" is displayed on the list of quizzes
      And I wait 3 sec
      And I delete "000 UI Automation - Svetlana5" from the list of quizzes

    @quizTQ-Text5
      Scenario: Verify TQ field allows max 1000  characters
       When I type 1000 alphanumeric characters into "Q1"
       When I click "Save" button
       And I wait 3 sec
       Then I verify that "000 UI Automation - Svetlana5" is displayed on the list of quizzes
       And I wait 3 sec
       And I delete "000 UI Automation - Svetlana5" from the list of quizzes

    @quizTQ-Text6
    Scenario: Verify TQ field does not allow 1001  characters
      When I type 1001 alphanumeric characters into "Q1"
      When I click "Save" button
      And I wait 3 sec
#    Bug: because accepts 1001 characters, quiz must not be displayed in the list of quizzes
      Then I verify that "000 UI Automation - Svetlana5" is not displayed on the list of quizzes
      And I wait 3 sec
      And I delete "000 UI Automation - Svetlana5" from the list of quizzes

    @quizTQ-Text7
    Scenario: Textual Question shouldn't accept an empty space as minimum 1 character
      When I enter an empty space " " into "Q1"
      When I click "Save" button
      And I wait 1 sec
#      Bug: because accepts an empty space,and quiz must not be displayed in the list of quizzes
      Then I verify that "000 UI Automation - Svetlana5" is not displayed on the list of quizzes
      And I wait 3 sec
      And I delete "000 UI Automation - Svetlana5" from the list of quizzes







