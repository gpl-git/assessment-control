@SingleCOption

Feature: Single choice Options Scenarios
  Background:
    Given I go to "login" page MB
    When I type "pearlie868@zipeq.site" into email field MB
    And I enter "Qwerty" as  password MB
    When I click button "Sign In" MB
    And I wait for 1 sec MB
    When I click on "Quizzes" menu item MB
    And I wait for 1 sec MB

  @SingleCOption1
  Scenario: Create a Quiz with Single Choice question
    And I click button "Create New Quiz" MB
    And I wait for 1 sec MB
    When I type "Test Quiz - Single" as quiz title MB
    And I add a question MB
    When I select "Single" question type MB
    When I type "Question 1" into "Q1" MB
    And I type "Option 1" as "Option 1*" into "Q1" MB
    And I type "Option 2" as "Option 2*" into "Q1" MB
    When I select "Option 1*" as correct option in "Q1" MB
    And I click button "Save" MB
    And I wait for 1 sec MB
    Then quiz "Test Quiz - Single" should be displayed on the list of quizzes MB
    And I wait for 1 sec MB
    And I delete "Test Quiz - Single" MB

  @SingleCOption2
  Scenario: Leave all fields empty and min 1 character
    And I click button "Create New Quiz" MB
    And I wait for 1 sec MB
    When I type "Test Quiz - Single" as quiz title MB
    And I add a question MB
    When I select "Single" question type MB
    And I click button "Save" MB
    Then error message "This field is required" should be displayed MB
    When I type "Question 1" into "Q1" MB
    And I type "1" as "Option 1*" into "Q1" MB
    And I type "2" as "Option 2*" into "Q1" MB
    And I wait for 2 sec MB
    When I select "Option 1*" as correct option in "Q1" MB
    And I click button "Save" MB
    And I wait for 2 sec MB
    Then quiz "Test Quiz - Single" should be displayed on the list of quizzes MB
    And I wait for 1 sec MB
    And I delete "Test Quiz - Single" MB

  @SingleCOption3
  Scenario: Allowable characters: Alphanumeric & Sp. character
    And I click button "Create New Quiz" MB
    And I wait for 1 sec MB
    When I type "Test Quiz - Single" as quiz title MB
    And I add a question MB
    When I select "Single" question type MB
    When I type "Question 1" into "Q1" MB
    And I type "Aa123456789!`*$%@" as "Option 1*" into "Q1" MB
    And I type "Option 2" as "Option 2*" into "Q1" MB
    When I select "Option 1*" as correct option in "Q1" MB
    And I click button "Save" MB
    And I wait for 1 sec MB
    Then quiz "Test Quiz - Single" should be displayed on the list of quizzes MB
    And I wait for 1 sec MB
    And I delete "Test Quiz - Single" MB

  @SingleCOption4
  Scenario:  min 2 answers choice should be present
    And I click button "Create New Quiz" MB
    And I wait for 1 sec MB
    When I type "Test Quiz - Single" as quiz title MB
    And I add a question MB
    When I select "Single" question type MB
    When I type "Question 1" into "Q1" MB
    And I type "Aa123456789!`*$%@" as "Option 1*" into "Q1" MB
    And I type "Option 2" as "Option 2*" into "Q1" MB
    When I select "Option 1*" as correct option in "Q1" MB
    And I click icon "settings" MB
    Then element "Delete Option" should be disabled MB
    And I wait for 3 sec MB
    When I click button "Close Menu" MB
    And I click button "Save" MB
    And I wait for 1 sec MB
    Then quiz "Test Quiz - Single" should be displayed on the list of quizzes MB
    And I wait for 1 sec MB
    And I delete "Test Quiz - Single" MB

  @SingleCOption5
  Scenario: Change the options
    And I click button "Create New Quiz" MB
    And I wait for 1 sec MB
    When I type "Test Quiz - Single" as quiz title MB
    And I add a question MB
    When I select "Single" question type MB
    When I type "Question 1" into "Q1" MB
    And I type "Option 1" as "Option 1*" into "Q1" MB
    And I type "Option 2" as "Option 2*" into "Q1" MB
    And I click icon "settings" MB
    And I wait for 5 sec MB
    And I click button "Move option down" MB
    And I wait for 3 sec MB
    When I select "Option 1*" as correct option in "Q1" MB
    And I click button "Save" MB
    And I wait for 3 sec MB
    Then quiz "Test Quiz - Single" should be displayed on the list of quizzes MB
    And I wait for 1 sec MB
    And I delete "Test Quiz - Single" MB

  @SingleCOption6
  Scenario: Max 15 answer choices
    And I click button "Create New Quiz" MB
    And I wait for 1 sec MB
    When I type "Test Quiz - Single" as quiz title MB
    And I add a question MB
    When I select "Single" question type MB
    When I type "Question 1" into "Q1" MB
    And I type "Option 1" as "Option 1*" into "Q1" MB
    And I type "Option 2" as "Option 2*" into "Q1" MB
    When I select "Option 2*" as correct option in "Q1" MB
    And I add up to 15 options to"Q1" MB
    And I wait for 3 sec
    And I click button "Save" MB
    And I wait for 2 sec MB
    Then quiz "Test Quiz - Single" should be displayed on the list of quizzes MB
    And I wait for 1 sec MB
    And I delete "Test Quiz - Single" MB


  @SingleCOption7
  Scenario: Max 1000 characters
    And I click button "Create New Quiz" MB
    And I wait for 1 sec MB
    When I type "Test Quiz - Single" as quiz title MB
    And I add a question MB
    When I select "Single" question type MB
    When I type "Question 1" into "Q1" MB
    When I enter 1000 alphanumeric characters as "Option 1*" into "Q1" MB
    And I wait for 3 sec
    And I type "Option 2" as "Option 2*" into "Q1" MB
    When I select "Option 2*" as correct option in "Q1" MB
    And I click button "Save" MB
    And I wait for 3 sec MB
    Then quiz "Test Quiz - Single" should be displayed on the list of quizzes MB
    And I wait for 1 sec MB
    And I delete "Test Quiz - Single" MB