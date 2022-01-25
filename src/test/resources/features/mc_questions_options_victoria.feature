@multiple_choice

Feature: Multiple Choice Question Scenarios
  Background:
    Given I go to "login" page
    When I type "ask_instr@aol.com" into email field
    And I type "12345" into password field
    When  I click "Sign In" button
    And I wait for 1 sec
    When I click "Quizzes" link
    And I wait for 1 sec

  @multiple_choice @smoke
  Scenario: Multiple Choice Question - Add Options
    When I click "Create New Quiz" button vk
    And I wait for 1 sec
    And I type "MC Question - Add Option" as the quiz title vk
    And I add a question vk
    And I wait for 10 sec
    And I select "Multiple-Choice" question type
    And I type "What is the name of the smallest country in the world?" as a question title vk
    And I type "San Marino" as an option 1 vk
    And I type "Monaco" as an option 2 vk
    And I type "Vatican City" as an option 3 vk
    And I select "Vatican City" as a correct option vk
    And I click on "Save" vk
    Then I verify that I am on the Quizzes page vk
    When I search for quiz by quiz title vk
    And I click on quiz to expand it vk
    And I click on "Preview" vk
    Then I verify that 3 quiz options are displayed vk







