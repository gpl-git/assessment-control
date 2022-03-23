@quiz

  Feature: Quiz Scenarios
    Background:
      Given I go to "login" page
      When I type "pearlie868@zipeq.site" into email field
      And I enter "Qwerty" as  password
      When I click button "Sign In"
      And I wait for 1 sec
      When I click on "Quizzes" menu item
      And I wait for 1 sec

    Scenario: Create a Quiz with Single Choice question
      And I click button "Create New Quiz"
      And I wait for 1 sec
      When I type "Test Quiz - Single" as quiz title
      And I add a question
      When I select "Single" question type
      When I type "Question 1" into "Q1"
      And I type "Option 1" as "Option 1*" into "Q1"
      And I type "Option 2" as "Option 2*" into "Q1"
      When I select "Option 1*" as correct option in "Q1"
      And I click button "Save"
      And I wait for 1 sec
      Then quiz "Test Quiz - Single" should be displayed on the list of quizzes
      And I wait for 1 sec
      And I delete "Test Quiz - Single"

    Scenario: Leave all fields empty and min 1 character
      And I click button "Create New Quiz"
      And I wait for 1 sec
      When I type "Test Quiz - Single" as quiz title
      And I add a question
      When I select "Single" question type
      And I click button "Save"
      Then error message "This field is required" should be displayed
      When I type "Question 1" into "Q1"
      And I type "1" as "Option 1*" into "Q1"
      And I type "2" as "Option 2*" into "Q1"
      And I wait for 2 sec
      When I select "Option 1*" as correct option in "Q1"
      And I click button "Save"
      And I wait for 2 sec
      Then quiz "Test Quiz - Single" should be displayed on the list of quizzes
      And I wait for 1 sec
      And I delete "Test Quiz - Single"

    Scenario: Allowable characters: Alphanumeric & Sp. character
      And I click button "Create New Quiz"
      And I wait for 1 sec
      When I type "Test Quiz - Single" as quiz title
      And I add a question
      When I select "Single" question type
      When I type "Question 1" into "Q1"
      And I type "Aa123456789!`*$%@" as "Option 1*" into "Q1"
      And I type "Option 2" as "Option 2*" into "Q1"
      When I select "Option 1*" as correct option in "Q1"
      And I click button "Save"
      And I wait for 1 sec
      Then quiz "Test Quiz - Single" should be displayed on the list of quizzes
      And I wait for 1 sec
      And I delete "Test Quiz - Single"

    Scenario:  min 2 answers choice
      And I click button "Create New Quiz"
      And I wait for 1 sec
      When I type "Test Quiz - Single" as quiz title
      And I add a question
      When I select "Single" question type
      When I type "Question 1" into "Q1"
      And I type "Aa123456789!`*$%@" as "Option 1*" into "Q1"
      And I type "Option 2" as "Option 2*" into "Q1"
      When I select "Option 1*" as correct option in "Q1"
      And I click icon "settings"
      Then element "Delete Option" should be disabled
      And I wait for 3 sec
      When I click button "Close Menu"
      And I click button "Save"
      And I wait for 1 sec
      Then quiz "Test Quiz - Single" should be displayed on the list of quizzes
      And I wait for 1 sec
      And I delete "Test Quiz - Single"

    Scenario: Max 15 answer choices
      And I click button "Create New Quiz"
      And I wait for 1 sec
      When I type "Test Quiz - Single" as quiz title
      And I add a question
      When I select "Single" question type
      When I type "Question 1" into "Q1"
      And I type "Option 1" as "Option 1*" into "Q1"
      And I type "Option 2" as "Option 2*" into "Q1"
      When I click button "Add Option"
      And I type "Option 3" as "Option 3*" into "Q1"
      When I click button "Add Option"
      And I type "Option 4" as "Option 4*" into "Q1"
      When I click button "Add Option"
      And I type "Option 5" as "Option 5*" into "Q1"
      When I click button "Add Option"
      And I type "Option 6" as "Option 6*" into "Q1"
      When I click button "Add Option"
      And I type "Option 7" as "Option 7*" into "Q1"
      When I click button "Add Option"
      And I type "Option 8" as "Option 8*" into "Q1"
      When I click button "Add Option"
      And I type "Option 9" as "Option 9*" into "Q1"
      When I click button "Add Option"
      And I type "Option 10" as "Option 10*" into "Q1"
      When I click button "Add Option"
      And I type "Option 11" as "Option 11*" into "Q1"
      When I click button "Add Option"
      And I type "Option 12" as "Option 12*" into "Q1"
      When I click button "Add Option"
      And I type "Option 13" as "Option 13*" into "Q1"
      When I click button "Add Option"
      And I type "Option 14" as "Option 14*" into "Q1"
      When I click button "Add Option"
      And I type "Option 15" as "Option 15*" into "Q1"
      When I click button "Add Option"
      And I type "Option 16" as "Option 16*" into "Q1"
      And I wait for 2 sec
      When I select "Option 3*" as correct option in "Q1"
      And I click button "Save"
      And I wait for 2 sec
      Then quiz "Test Quiz - Single" should be displayed on the list of quizzes
      And I wait for 1 sec
      And I delete "Test Quiz - Single"
