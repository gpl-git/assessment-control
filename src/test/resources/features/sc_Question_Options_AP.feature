@sc_options
Feature: Single Choice Question - Options - AP

  Background: Login as a teacher
    Given I open "login" page
    When I type "ask_instr@aol.com" into email input field
    And I type"12345" into password field
    When I click "Sign In" button
    And I wait for 1 sec

  @sc_options1
  Scenario: Verify that Single Choice question can contain up to 15 choices - AP
    When I click "Quizzes" menu item
    And I wait for 1 sec
    When I click "Create New Quiz" button
    And I wait for 1 sec
    When I enter "Single Choice question auto test" as quiz title
    And I add a question
    When I select "Single" question
    And I wait for 2 sec
    And I click "Add Option" button 13 time(s) - AP
#        The question will already have 2 choices added by default
    And I wait for 2 sec
    Then question should have 15 options in total  - AP
    And I wait for 2 sec

  @sc_options2
  Scenario: Verify that Single Choice question cannot contain more than 15 choices - AP
    When I click "Quizzes" menu item
    And I wait for 1 sec
    When I click "Create New Quiz" button
    And I wait for 1 sec
    When I enter "Single Choice question auto test" as quiz title
    And I add a question
    When I select "Single" question
    And I wait for 2 sec
    And I click "Add Option" button 14 time(s) - AP
#        The question will already have 2 choices added by default
    And I wait for 2 sec
    Then option 16 should not be present on the page  - AP
#          Known issue: The system does allow to add more than 15 choices. BugID: NOV-130 and NOV-185
    And I wait for 2 sec

  @sc_options3
  Scenario: Verify that Single Choice question can contain only 1 correct choice - AP
    When I click "Quizzes" menu item
    And I wait for 1 sec
    When I click "Create New Quiz" button
    And I wait for 1 sec
    When I enter "Single Choice question auto test" as quiz title
    And I add a question
    When I select "Single" question
    And I wait for 2 sec
#            The question will already have 2 choices added by default
    And I click "Add Option" button 1 time(s) - AP
#            To add 3rd choice
    When I select "Option 1*" as correct option in "Q1"
    Then "Option 1*" should be checked - AP
    And "Option 2*" should be unchecked - AP
    And "Option 3*" should be unchecked - AP
    When I select "Option 2*" as correct option in "Q1"
    Then "Option 2*" should be checked - AP
    And "Option 1*" should be unchecked - AP
    And "Option 3*" should be unchecked - AP
    When I select "Option 3*" as correct option in "Q1"
    Then "Option 3*" should be checked - AP
    And "Option 1*" should be unchecked - AP
    And "Option 2*" should be unchecked - AP

  @sc_options4
  Scenario: Verify that Single Choice question cannot contain empty choices - AP
    When I click "Quizzes" menu item
    And I wait for 1 sec
    When I click "Create New Quiz" button
    And I wait for 1 sec
    When I enter "Single Choice question auto test" as quiz title
    And I add a question
    When I select "Single" question
    And I wait for 2 sec
    When I type "Question 1" into "Q1" textarea
    And I type "" into "Option 1*" field in "Q1"
    And I type "Option 2" into "Option 2*" field in "Q1"
    When I select "Option 2*" as correct option in "Q1"
    When I click "Save" button
    And I wait for 1 sec
    Then SnackBar element with the message "Quiz is not completed. Check highlighted with \"red\" areas " should appear - AP
    And error message "This field is required" is displayed under "Option 1*" field in "Q1" - AP
    And I wait for 1 sec

  @sc_options5
  Scenario: Verify that Single Choice question cannot be saved or previewed before a correct option is chosen - AP
    When I click "Quizzes" menu item
    And I wait for 1 sec
    When I click "Create New Quiz" button
    And I wait for 1 sec
    When I enter "Single Choice question auto test" as quiz title
    And I add a question
    When I select "Single" question
    And I wait for 2 sec
    When I type "Question 1" into "Q1" textarea
    And I type "Option 1" into "Option 1*" field in "Q1"
    And I type "Option 2" into "Option 2*" field in "Q1"
    When I click "Save" button
    And I wait for 1 sec
    Then SnackBar element with the message "Quiz is not completed. Check highlighted with \"red\" areas " should appear - AP
    And error message "*Choose correct answer" is displayed underneath options - AP
    And I wait for 1 sec

  @sc_options6
  Scenario: Verify that Single Choice question can have any choice selected as the correct choice - AP
    When I click "Quizzes" menu item
    And I wait for 1 sec
    When I click "Create New Quiz" button
    And I wait for 1 sec
    When I enter "Single Choice question auto test" as quiz title
    And I add a question
    When I select "Single" question
    And I wait for 2 sec
#            The question will already have 2 choices added by default
    And I click "Add Option" button 1 time(s) - AP
#            To add 3rd choice
    When I select "Option 1*" as correct option in "Q1"
    Then "Option 1*" should be checked - AP
    And "Option 2*" should be unchecked - AP
    And "Option 3*" should be unchecked - AP
    When I select "Option 2*" as correct option in "Q1"
    Then "Option 2*" should be checked - AP
    And "Option 1*" should be unchecked - AP
    And "Option 3*" should be unchecked - AP
    When I select "Option 3*" as correct option in "Q1"
    Then "Option 3*" should be checked - AP
    And "Option 1*" should be unchecked - AP
    And "Option 2*" should be unchecked - AP

  @sc_options7
  Scenario: Verify that "Delete option" is disabled when only 2 options are listed - AP
    When I click "Quizzes" menu item
    And I wait for 1 sec
    When I click "Create New Quiz" button
    And I wait for 1 sec
    When I enter "Single Choice question auto test" as quiz title
    And I add a question
    When I select "Single" question
    And I wait for 2 sec
#            The question will already have 2 choices added by default
    When I press the settings (gear) button near Option 2 field - AP
    Then choice option settings menu should be displayed - AP
    And I wait for 2 sec
    And choice option settings "Delete Option" item should be disabled - AP

  @sc_options8
  Scenario: Verify that "Move option up" is disabled in the setting for the first option - AP
    When I click "Quizzes" menu item
    And I wait for 1 sec
    When I click "Create New Quiz" button
    And I wait for 1 sec
    When I enter "Single Choice question auto test" as quiz title
    And I add a question
    When I select "Single" question
    And I wait for 2 sec
#            The question will already have 2 choices added by default
    When I press the settings (gear) button near Option 1 field - AP
    Then choice option settings menu should be displayed - AP
    And I wait for 2 sec
    And choice option settings "Move option up" item should be disabled - AP

  @sc_options9
  Scenario: Verify that "Move option down" is disabled in the setting for the last option - AP
    When I click "Quizzes" menu item
    And I wait for 1 sec
    When I click "Create New Quiz" button
    And I wait for 1 sec
    When I enter "Single Choice question auto test" as quiz title
    And I add a question
    When I select "Single" question
    And I wait for 2 sec
#            The question will already have 2 choices added by default
    When I press the settings (gear) button near Option 2 field - AP
    Then choice option settings menu should be displayed - AP
    And I wait for 2 sec
    And choice option settings "Move option down" item should be disabled - AP

  @sc_options10
  Scenario: Verify that "Delete option" is enabled when more than 2 options are listed - AP
    When I click "Quizzes" menu item
    And I wait for 1 sec
    When I click "Create New Quiz" button
    And I wait for 1 sec
    When I enter "Single Choice question auto test" as quiz title
    And I add a question
    When I select "Single" question
    And I wait for 2 sec
#            The question will already have 2 choices added by default
    And I click "Add Option" button 1 time(s) - AP
    When I press the settings (gear) button near Option 1 field - AP
    Then choice option settings menu should be displayed - AP
    And I wait for 2 sec
    And choice option settings "Delete Option" item should be enabled - AP
    And I click on the choice option settings item "Close Menu" - AP
    When I press the settings (gear) button near Option 2 field - AP
    Then choice option settings menu should be displayed - AP
    And I wait for 2 sec
    And choice option settings "Delete Option" item should be enabled - AP
    And I click on the choice option settings item "Close Menu" - AP
    When I press the settings (gear) button near Option 3 field - AP
    Then choice option settings menu should be displayed - AP
    And I wait for 2 sec
    And choice option settings "Delete Option" item should be enabled - AP
    And I click on the choice option settings item "Close Menu" - AP

  @sc_options11
  Scenario: Verify that "Close Menu" item in the option settings is functioning - AP
    When I click "Quizzes" menu item
    And I wait for 1 sec
    When I click "Create New Quiz" button
    And I wait for 1 sec
    When I enter "Single Choice question auto test" as quiz title
    And I add a question
    When I select "Single" question
    And I wait for 2 sec
#            The question will already have 2 choices added by default
    When I press the settings (gear) button near Option 1 field - AP
    Then choice option settings menu should be displayed - AP
    And I wait for 2 sec
    And I click on the choice option settings item "Close Menu" - AP
    And I wait for 1 sec
    Then choice option settings menu should NOT be displayed - AP

  @sc_options12
  Scenario: Verify that option field accepts up to 1000 characters - AP
    When I click "Quizzes" menu item
    And I wait for 1 sec
    When I click "Create New Quiz" button
    And I wait for 1 sec
    When I enter "Single Choice question auto test" as quiz title
    And I add a question
    When I select "Single" question
    And I wait for 2 sec
#            The question will already have 2 choices added by default
    And I type "Question 1" into "Q1" textarea
    And I type 1000 alphanumeric characters into "Option 1*" field in "Q1" - AP
    And I type "Option 2" into "Option 2*" field in "Q1"
    And I select "Option 2*" as correct option in "Q1"
    When I click "Preview" button
    And I wait for 2 sec
    Then Preview Mode dialog should be displayed - AP
    And Option 1 in the question with the title "Question 1" should contain text that has 1000 characters - AP
    And I wait for 2 sec

  @sc_options13
  Scenario: Verify that option field accepts not more than 1000 characters - AP
    When I click "Quizzes" menu item
    And I wait for 1 sec
    When I click "Create New Quiz" button
    And I wait for 1 sec
    When I enter "Single Choice question auto test" as quiz title
    And I add a question
    When I select "Single" question
    And I wait for 2 sec
#            The question will already have 2 choices added by default
    And I type "Question 1" into "Q1" textarea
    And I type 1001 alphanumeric characters into "Option 1*" field in "Q1" - AP
    And I type "Option 2" into "Option 2*" field in "Q1"
    And I select "Option 2*" as correct option in "Q1"
    When I click "Preview" button
    And I wait for 2 sec
    Then Preview Mode dialog should be displayed - AP
    And Option 1 in the question with the title "Question 1" should contain text that has 1000 characters - AP
#     Known issue: The system does allow to add more than 1000 characters in the option field. BugID: NOV-395
    And I wait for 2 sec

  @sc_options14
  Scenario: Verify that "Delete Option" command deletes only one option (the desired one) - AP
    When I click "Quizzes" menu item
    And I wait for 1 sec
    When I click "Create New Quiz" button
    And I wait for 1 sec
    When I enter "Single Choice question auto test" as quiz title
    And I add a question
    When I select "Single" question
    And I wait for 2 sec
#            The question will already have 2 choices added by default
    And I click "Add Option" button 1 time(s) - AP
#            To add 3rd choice
    And I type "Test question" into "Q1" textarea
    When I type "Option 1" into "Option 1*" field in "Q1"
    And I type "Option 2" into "Option 2*" field in "Q1"
    And I type "Option 3" into "Option 3*" field in "Q1"
    When I press the settings (gear) button near Option 1 field - AP
    And I click on the choice option settings item "Delete Option" - AP
    Then Option 3 in Question 1 should not be displayed - AP
    When I select "Option 1*" as correct option in "Q1"
    And I click "Preview" button
    And I wait for 2 sec
    Then Option 1 in the question with the title "Test question" should contain text as "Option 2" - AP
    And Option 2 in the question with the title "Test question" should contain text as "Option 3" - AP
#    Known issue: When option 1 is deleted, option 2 and option 3 both start showing the same text as option 3,
  #    but the Preview page will show the correct values. BugID: NOV-397
    And I wait for 2 sec
