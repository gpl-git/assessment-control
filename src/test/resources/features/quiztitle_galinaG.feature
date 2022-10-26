@questiontext
Feature: Quiz Scenarios
  Background:
    Given I navigate to "login" page ASK
    When I type email "veraforest@otpku.com" for teacher user
    And I type password "12345"
    When I click the "Sign In" button
    And I wait for 1 sec
    Then the ASK "home" page should be displayed
    When I click on "Quizzes" from menu
    And I wait for 1 sec

  @questiontext1
  Scenario: Question text field accepts Alphanumeric & Sp. characters
    When I click on "Create New Quiz" button
    And I wait for 1 sec
    When I type the title of the Quiz "Test_GalinaG - Automation"
    And I add the Question
    When I choose "Single-Choice" question
    And I wait for 1 sec
    When I type the question title "What is the correct answer 1 or 2?"
    And I type "1" as "Option 1*"
    And I type "2" as "Option 2*"
    Then I choose the "Option 2*" as the correct answer
    And I click on the "Save" button
    And I wait for 1 sec
    Then quiz "Test_GalinaG - Automation" is present on the list of quizzes
    And I wait for 2 sec
    And I delete the quiz "Test_GalinaG - Automation"

  @questiontext2
  Scenario: Question text field accepts min 1 character
    When I click on "Create New Quiz" button
    And I wait for 1 sec
    When I type the title of the Quiz "Test_GalinaG - Automation"
    And I add the Question
    When I choose "Single-Choice" question
    And I wait for 1 sec
    When I enter 1 of alphanumeric characters as title of the Question
    And I type "1" as "Option 1*"
    And I type "2" as "Option 2*"
    Then I choose the "Option 2*" as the correct answer
    And I click on the "Save" button
    And I wait for 1 sec
    Then quiz "Test_GalinaG - Automation" is present on the list of quizzes
    And I wait for 1 sec
    And I delete the quiz "Test_GalinaG - Automation"

  @questiontext3
  Scenario: Question text field accepts 1000 characters
    When I click on "Create New Quiz" button
    And I wait for 1 sec
    When I type the title of the Quiz "Test_GalinaG - Automation1"
    And I add the Question
    When I choose "Single-Choice" question
    And I wait for 1 sec
    When I enter 1000 of alphanumeric characters as title of the Question
    And I type "1" as "Option 1*"
    And I type "2" as "Option 2*"
    Then I choose the "Option 2*" as the correct answer
    And I click on the "Save" button
    And I wait for 1 sec
    Then quiz "Test_GalinaG - Automation1" is present on the list of quizzes
    And I wait for 1 sec
    And I delete the quiz "Test_GalinaG - Automation1"

  @questiontext4
  Scenario: Question text field accepts 1001 characters
    When I click on "Create New Quiz" button
    And I wait for 1 sec
    When I type the title of the Quiz "Test_GalinaG - Automation2"
    And I add the Question
    When I choose "Single-Choice" question
    And I wait for 1 sec
    When I enter 1001 of alphanumeric characters as title of the Question
    And I wait for 3 sec
    And I type "1" as "Option 1*"
    And I type "2" as "Option 2*"
    Then I choose the "Option 2*" as the correct answer
    And I wait for 2 sec
    And I click on the "Save" button
    And I wait for 1 sec
# This is a known issue
    Then the error message "The field does not accepts more than 1001 characters" should be displayed


  @questiontext5
  Scenario: Question text field is required
    When I click on "Create New Quiz" button
    And I wait for 1 sec
    When I type the title of the Quiz "Test_GalinaG - Automation2"
    And I add the Question
    When I choose "Single-Choice" question
    And I wait for 1 sec
    When I enter 0 of alphanumeric characters as title of the Question
    And I wait for 3 sec
    And I type "1" as "Option 1*"
    And I type "2" as "Option 2*"
    Then I choose the "Option 2*" as the correct answer
    And I wait for 2 sec
    And I click on the "Save" button
    Then the error message should be displayed
    Then the error message "This field is required" should be displayed
    And I wait for 1 sec

