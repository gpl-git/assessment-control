@olesyashowstopper
  Feature: Single Choice Question - Showstopper
    @olesyashowstopper1
    Scenario: Verifying Single Choice Question - Showstopper
      Given I navigate to "login" page
      When I enter "ask_instr@aol.com" into email field
      And I enter "12345" into the password field
      When I push "Sign In" button
      And I wait for 2 sec
      Then I verify my role as "TEACHER"
      When I click on "Quizzes" menu
      And I wait for 3 sec
      And I click "Create New Quiz" button
      And I wait for 1 sec
      When I write "Single Choice ShowstopperO" as quiz title
      And I add a question
      And I wait for 1 sec
      When I select "Single" question type
      And I type "text1" into "Q1"
      When I type "Option 1" as "Option 1*" into "Q1"
      When I type "Option 2" as "Option 2*" into "Q1"
      And I select "Option 1*" as correct option in "Q1"
      And I wait for 1 sec
      And I select Show Stopper option
      Then question "Q1*" is marked with asterisk
      When I click "Save" button
      And I wait for 5 sec
      Then "Single Choice ShowstopperO" is displayed on the list of quizzes
      And I wait for 5 sec
#    And I click on "Single Choice ShowstopperO" quizz name
#    And I wait for 10 sec
      #When I click "Preview" button
      And I expand "Single Choice ShowstopperO" and click button "Preview"
      Then "Show-Stopper Question" label is displayed
      And I click "Close" button
