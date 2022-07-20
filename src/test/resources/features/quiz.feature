Feature:  Quiz Scenarios

  Background:
    Given I go to "login" page
    When I type "ask_instr@aol.com" into email field
    And I enter "12345" as password
    When I click button "Sign In"
    And I wait for 1 sec
    When I click "Quizzes" menu item
    And I wait for 2 sec
  @quiz1
  Scenario: Create a Quiz
    When I click button "Create New Quiz"
    And I wait for 1 sec
    When I type "00Test Quiz - Galina" as quiz title
    And I add a question
    And I wait for 1 sec
    When I select "Single" question type
    And I type "Question 1 Text" into "Q1"
    When I type "Option 1" as "Option 1*" into "Q1"
    And I type "Option 2" as "Option 2*" into "Q1"
    And I select "Option 1*" as correct option in "Q1"
    When I click button "Save"
    And I wait for 1 sec
    Then quiz "00Test Quiz - Galina" should be displayed on the list of quizzes
    And I wait for 2 sec
    And I delete "00Test Quiz - Galina"
