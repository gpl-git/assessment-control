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
    When I type "Q11" as question title
    And I type "Option 1*" in field Option 1
    And I type "Option 2*" in field Option 2
    And I wait for 2 sec
    And I click "Add Option" button contains text
    And I type "Option 3*" in field Option 3
    And I click to add Option
    And I type "Option 4*" in field Option 4
    And I wait for 2 sec

    Then I check "Option 1*" as correct answer in question "Q11"
    Then I check "Option 2*" as correct answer in question "Q11"
    And I wait for 2 sec
    Then I click "Save" button contains text







