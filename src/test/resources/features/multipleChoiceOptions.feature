@smoke
Feature: Multiple choice question - Options

  Scenario: Multiple Choice question Happy Path
    Given I open "login" page
    When I type "ttv250971@gmail.com" into email field
    And I type "Valenok" into password field
    Then I click "Sign In" button

    When I Click "Quizzes" link
    And I click "Create New Quiz" button
    And I type "Automation Quiz Test TanyaW" in Title of the Quiz
    And I wait for 2 sec
#    And I click "Add Question" button
#    And I click "Add Question" button contains text
    And I click  button to add Question

    Then I select "Multiple" type
    When I type "What's your favorite color?" as question title
    And I type "blue" in field Option 1
    And I type "red" in field Option 2
    And I wait for 2 sec
    And I click "Add Option" button contains text
    And I type "black" in field Option 3
    And I click to add Option
    And I type "white" in field Option 4
    And I wait for 2 sec
#    Then I check "blue" as correct answer in question "What's your favorite color?"
#    Then I check "red" as correct answer in question "What's your favorite color?"
#    And I wait for 2 sec
#    Then I click "Save" button contains text
#    And I wait for 2 sec






