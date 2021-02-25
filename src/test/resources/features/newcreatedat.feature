@newcreatedat @smoke
Feature: Automate test set

  @newcreatedat1
  Scenario: Quiz - Created at
    Given I go to "ask"
    When I type "ask_instr@aol.com" email
    Then I type "12345" in the password field
    Then I click on "Sign in" button
    And I wait 3 seconds
    Then I click on "Quizzes" btn
    And I wait 4 seconds
    Then I click on "Create New Quiz"
    And I wait 4 seconds
    Then I type into Title field "QUIZ #20"
    And I wait 1 second
    Then I add a question in QUIZ#20
    And I wait 1 second
    Then I click on radio button "Textual"
    And I wait 1 second
    And I type "What is the release?" into "Q1" field
    And I wait 1 second
    Then on the right side I click on "Save"
    And I wait 1 second
    Then title "Quiz #20"  is displayed on the list of quizzes
    And I wait 4 seconds
    Then I click on "Quiz #20" in quiz list
    And I wait 3 seconds
    Then title "Quiz #20" should contain text "Created At:"
    And I wait 4 seconds