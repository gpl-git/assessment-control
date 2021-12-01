@trivia_shweta
  Feature: Trivia By Shweta Scenarios

  Background:
    Given I "login"
    When I enter login "email"
    Then I enter password "password"
    And I wait for 2 sec
    When I click on "Sign In" button
    And I wait for 2 sec

  @trivia_shweta1
  Scenario: Automate Quiz with Multiple Choice Questions
    Given I click "Quiz" link
    And I wait for 2 sec
    When I click on "Create New Quiz" button
    Then I wait for 1 sec
    Then I type in quiz tile as "Trivia By Shweta"
    And I click add question
    Then I select question type as "Multiple-Choice"
    Then I type into Question field "Question here !"
    And I type "option ONE" in first option
    And I type "option TWO" in second option
    Then I click on "Add Option" button
    And I wait for 2 sec
    And I type "option Three" in third option
    Then I select "option TWO" and "option Three" correct choices
    Then I wait for 2 sec
    And I click on "Save" button
    Then I wait for 2 sec


