@quiz
Feature: Quiz Scenarios

  Background:
    Given I open "login" page
    When I type "ask_instr@aol.com" into email field
    And I type "12345" into password field
    When I click "Sign In" button
    And I wait for 1 sec
    And I click on "Quizzes" link
    And I wait for 1 sec
    When I click "Create New Quiz" button
    And I wait for 1 sec


  @test1
  Scenario: Verify that Title of the Quiz field accepts Alphanumeric & Sp. characters
    Given I add text "Quiz123!@#$" as title of the quiz
    And I click add question button
    And I wait for 2 sec
    Then next page has "Title of The Quiz" in the string with no error message


  @test2
  Scenario: Verify that Quiz Title field accepts Min 1 character
    Given I add text "d" as title of the quiz
    And I click add question button
    And I wait for 2 sec
    Then next page has "Title of The Quiz" in the string with no error message

  @test3
  Scenario: Verify that Quiz Title field accepts Max 1000 characters
    Given I add text with "1000 characters" as title of the quiz
    And I click add question button
    And I wait for 2 sec
    Then next page has "Title of The Quiz" in the string with no error message


  @test4
  Scenario: Verify error message appears when title is more than 1001 characters
    Given I type "1001 characters" in the field Title of the Quiz
    And I click add question button
    Then next page has error message "No more than 10001 characters"
    And I wait for 2 sec
#  No error message is displayed for this test case. This is a known issue. Please refer to the bug SA-242

  @test5
  Scenario: Leading and Tracing spaces are eliminated in the title in the list of quizzes
    Given I type "    Test     Leading and      trailing space" as title of the quiz
    And I click add question button
    And I wait for 2 sec
    And I select "textual" question option
    And I wait for 1 sec
    When I type "Text 1" as question "Q1" text field "Question *"
    And I wait for 2 sec
    And I click "Save" button
    And I wait for 2 sec
    Then quiz "Test Leading and trailing space" should be displayed on the list of quizzes
    And I wait for 2 sec
    And title of the quiz "Test Leading and trailing space" should not have leading spaces


  @test6
  Scenario: Verify that Quiz Title field is required
    Given I add text "d" as title of the quiz
    And I wait for 2 sec
    And I delete letter "d" from title
    And I wait for 2 sec
    And I click add question button
    And I wait for 1 sec
    Then error message "This field is required" is displayed



