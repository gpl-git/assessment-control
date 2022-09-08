  @quizTQ-Text @smoke
  Feature: Textual Question - Text

    Background:
      Given I go to "login" page ss
      When I type "ask_instr@aol.com" into email field ss
      And I type "12345" into  password field ss
      When I click "Sign In" button ss
      And I wait 3 sec ss
      When I click "Quizzes" menu item ss
      And I wait 1 sec ss
      When I click "Create New Quiz" button ss
      And I wait 1 sec ss
      When I type "000 UI Automation - Svetlana5" as quiz title ss
      And I add a question ss
      When I select "Textual" question type ss

    @quizTQ-Text1
      Scenario: Create a Quiz (Happy Path)
      When I enter "Question Text 1" into "Q1" ss
      When I click "Save" button ss
      And I wait 1 sec ss
      Then I verify that "000 UI Automation - Svetlana5" is displayed on the list of quizzes ss
      And I wait 3 sec ss
      And I delete "000 UI Automation - Svetlana5" from the list of quizzes ss

    @quizTQ-Text2
      Scenario: Verify TQ field accepts alphanumeric & special characters
      When I enter "*&2^%^&**&&755" into "Q1" ss
      When I click "Save" button ss
      And I wait 1 sec ss
      Then I verify that "000 UI Automation - Svetlana5" is displayed on the list of quizzes ss
      And I wait 3 sec ss
      And I delete "000 UI Automation - Svetlana5" from the list of quizzes ss

    @quizTQ-Text3
      Scenario: Verify TQ field is required and can not be empty
      When I click "Save" button ss
      And I wait 1 sec ss
      Then error message "This field is required" is displayed ss

    @quizTQ-Text4
      Scenario: Verify TQ field allows minimum 1 character
      When I enter "Q" into "Q1" ss
      When I click "Save" button ss
      And I wait 2 sec ss
      Then I verify that "000 UI Automation - Svetlana5" is displayed on the list of quizzes ss
      And I wait 3 sec ss
      And I delete "000 UI Automation - Svetlana5" from the list of quizzes ss

    @quizTQ-Text5
      Scenario: Verify TQ field allows max 1000  characters
       When I type 1000 alphanumeric characters into "Q1" ss
       When I click "Save" button ss
       And I wait 3 sec ss
       Then I verify that "000 UI Automation - Svetlana5" is displayed on the list of quizzes ss
       And I wait 3 sec ss
       And I delete "000 UI Automation - Svetlana5" from the list of quizzes ss

    @quizTQ-Text6
    Scenario: Verify TQ field does not allow 1001  characters
      When I type 1001 alphanumeric characters into "Q1" ss
      When I click "Save" button ss
      And I wait 3 sec ss
#    Bug: because accepts 1001 characters, quiz must not be displayed in the list of quizzes
      Then I verify that "000 UI Automation - Svetlana5" is not displayed on the list of quizzes ss
      And I wait 3 sec ss
      And I delete "000 UI Automation - Svetlana5" from the list of quizzes ss

    @quizTQ-Text7
    Scenario: Textual Question shouldn't accept an empty space as minimum 1 character
      When I enter an empty space " " into "Q1" ss
      When I click "Save" button ss
      And I wait 1 sec ss
#      Bug: because accepts an empty space,and quiz must not be displayed in the list of quizzes
      Then I verify that "000 UI Automation - Svetlana5" is not displayed on the list of quizzes ss
      And I wait 3 sec ss
      And I delete "000 UI Automation - Svetlana5" from the list of quizzes ss







