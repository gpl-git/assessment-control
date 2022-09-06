@quiz @SC-Options
Feature: Single Choice Option
  Background:
    Given I go to "login" page
    When I type "ask_instr@aol.com" into email field
    And I type "12345" into password field
    When I click "Sign In" button
    And I wait for 1 sec
    When I click "Quizzes" menu item
    And I wait for 1 sec
    When I click "Create New Quiz" button
    And I wait for 1 sec
    When I type "Single Choice Option Sandra" as quiz title
    And I add a question
    When I select "Single" question type
    And I wait for 5 sec
    When I enter "Question 1 Text" into "Q1"

  @SC-Options1
  Scenario: Check if 15 options are accepted
    And I type "1" as "Option 1*" into "Q1"
    When I select "Option 1*" as correct option in "Q1"
    And I type "2" as "Option 2*" into "Q1"
    And I add up to 15 options into "Q1"
    When I click "Save" button
    And I wait for 3 sec
    Then I verify that "Single Choice Option Sandra" is displayed on the list of quizzes
    And I wait for 5 sec
    And I delete "Single Choice Option Sandra" from the list of quizzes
  @SC-Options2
  Scenario: 16 options are not accepted
    When I type "1" as "Option 1*" into "Q1"
    And I type "2" as "Option 2*" into "Q1"
    When I select "Option 2*" as correct option in "Q1"
    And I add an option
    And I add up to 15 options into "Q1"
    And "Add option" button is disabled
#    system accepts more then 15 options, it's a bug. https://jira.portnov.com/browse/JUL22-831
    When I click "Save" button
    And I wait for 3 sec
    Then I verify that "Single Choice Option Sandra" is displayed on the list of quizzes
    And I wait for 5 sec
    And I delete "Single Choice Option Sandra" from the list of quizzes

  @SC-Option3
  Scenario: Minimum 2 options
    When I type "1" as "Option 1*" into "Q1"
    And I select "Option 1*" as correct option in "Q1"
    When I click "Save" button
    Then error message appear
    And error message contains text "This field is required"

  @SC-Option4
  Scenario: Maximum 1000 characters in option
    When I type "1" as "Option 1*" into "Q1"
    And I type 1000 alphanumeric characters as "Option 2*" into "Q1"
    When I select "Option 2*" as correct option in "Q1"
    When I click "Save" button
    And I wait for 7 sec
    Then I verify that "Single Choice Option Sandra" is displayed on the list of quizzes
    And I wait for 5 sec
    And I delete "Single Choice Option Sandra" from the list of quizzes

  @SC-Option5
  Scenario: 1001 characters for the option
    When I type "1" as "Option 1*" into "Q1"
    And I wait for 5 sec
    And I type 1001 alphanumeric characters as "Option 2*" into "Q1"
    When I select "Option 2*" as correct option in "Q1"
    When I click "Save" button
    Then error message appear
#    Bug again. 1001 characters should not be allowed. Bug report for the textual question
#    with the same issue https://jira.portnov.com/browse/JUL22-644
  @SC-Option6
  Scenario: User can delete an option
    When I type "1" as "Option 1*" into "Q1"
    And I type "2" as "Option 2*" into "Q1"
    When I select "Option 2*" as correct option in "Q1"
    And I add an option
    And I type "3" as "Option 3*" into "Q1"
    And I wait for 2 sec
    And I delete "Option 3*" from the question
    And I check that "Option 2*" is present
    Then I check that "Option 1*" is present


