@show-stopper
Feature: Automating test set "Textual Question - Show-Stopper"

  Scenario: Verify that quiz has a show-stopper question
    Given I navigate to "login" page
    When I fill in "ask_instr@aol.com" into email field
    And I put "12345" into password field
    When I click on the "Sign In" button
    And I wait for 1 second
    Then I verify url as "home"
    When I click on the "Quizzes" tab
    And I wait for 1 second
    When I click on the "Create New Quiz" button
    And I wait for 1 second
    And I put "Textual Quiz - Show Stopper" as quiz title
    When I add a textual question
    And I select "Textual" question type
    When I type in question text "TQ Question" into "Q1"
    And I wait for 1 second
    And I select checkbox "Is Show-Stopper question?"
    And I wait for 1 second
    When I click "Save" button
    And I wait for 1 second
    Then the quiz "Textual Quiz - Show Stopper" should be displayed on the list of quizzes
    Then I click on "Questions" dropdown element
    And I click on the "Preview" button
    And I verify that quiz has a show-stopper question
    And I push on "Close" button
    And I delete quiz "Textual Quiz - Show Stopper" from list of quizzes