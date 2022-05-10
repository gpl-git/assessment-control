@MCOptions
Feature: Options

  Background:
    Given I navigate to "login" page A.F.
    Then I enter "nadia111@lompikachi.com" into email field A.F.
    And I enter "12345" into password field A.F.
    And I click button "Sign In" A.F.
    And I wait for 1 sec A.F.
    When I click "Quizzes" link A.F.
    And I wait for 2 sec A.F.
    Then I click button "Create New Quiz" A.F.
    And I wait for 1 sec A.F.
    And I enter "Multiple-Choice Question: Options" as quiz "name" A.F.
    And I click on Add Question A.F.
    When I select "Multiple" question type A.F.
    And I enter "Question" as quiz "question" A.F.
    And I wait for 2 sec A.F.

  @MCoption
  Scenario: Multiple-choice options are required
    When I click button "Save" A.F.
    Then error message for "Option 1*" and "Option 2*" should be displayed A.F.

  @MCoption1
  Scenario: Max 1000 characters accepted in MC_options fields
#   input 1000 characters
    When I type in "Option 1*" field positive test
#   input 1001 characters
    Then I type in "Option 2*" field negative test
#   Known issue bug number MAR22-537
    And error message "Max length is 1000 characters" should be displayed A.F.

  @MCoption2
  Scenario: Add option to multiple-choice question
    When I click button "Add Option" A.F.
    Then "Option 3*" is displayed
    And I wait for 2 sec A.F.

  @MCoption3
  Scenario: Verify that MC_options fields does not accepts whitespaces only
    When I enter in "Option 2*" whitespaces "   " only
    And I wait for 2 sec A.F.

  @MCoption4
  Scenario: Move option up in a multiple-choice question
    When I fill out "Option 1*" and "Option 2*" fields
    Then I click on settings in "Option 2*"
    And I wait for 2 sec A.F.
    And I click on "Move option up"
    And I wait for 2 sec A.F.

  @MCoption5
  Scenario: Move option down in a multiple-choice question
    When I fill out "Option 1*" and "Option 2*" fields
    Then I click on settings in "Option 1*"
    And I wait for 2 sec A.F.
    And I click on "Move option down"
    And I wait for 2 sec A.F.

  @MCoption6
  Scenario: Delete option from a multiple-choice question
    When I click button "Add Option" A.F.
    Then I click on settings in "Option 3*"
    And I wait for 2 sec A.F.
    And I click on "Delete Option"
    And I wait for 2 sec A.F.

  @MCoption7
  Scenario: Close option settings menu
    Then I click on settings in "Option 2*"
    And I wait for 2 sec A.F.
    And I click on "Close Menu"
    And I wait for 2 sec A.F.

  @MCoption8
  Scenario: Select options for the correct answers
    When I click button "Add Option" A.F.
    And I click button "Add Option" A.F.
    Then I fill out "Option 1*" and "Option 2*" fields
    And I fill out "Option 3*" and "Option 4*" fields
    When I click button "Save" A.F.
    And I wait for 2 sec A.F.
    Then error message is displayed A.F.
    When I choose "Option 1*" as a correct answer
    And I choose "Option 3*" as a correct answer
    And I wait for 2 sec A.F.
#     Then error message is not displayed A.F.

  @MCoption9
  Scenario: Verify that more than 15 options cannot be added to multiple-choice question
    When I fill out "Option 1*" and "Option 2*" fields
    Then I add up to 16 options to multiple-choice question A.F.
#   Known issue bug number MAR22-533
    And I wait for 2 sec A.F.
    And I delete question A.F.
    And I wait for 2 sec A.F.
    And I back to quizzes list A.F.
    And I wait for 2 sec A.F.