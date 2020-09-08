@smoke
Feature: Multiple choice question - Options

  Scenario: Multiple Choice question Happy Path
    Given I open "login" page
    When I type "ttv250971@gmail.com" into email field
    And I type "Valenok" into password field
    Then I click "Sign In" button contains text
    And I wait for 2 sec
    
    When I Click "Quizzes" link
    And I wait for 2 sec
    And I click "Create New Quiz" button contains text
    And I wait for 1 sec
    Then I type "Automation Quiz Proba TW" as quiz title
    And I wait for 1 sec
    Then I add a question
    Then I select "Multiple" type
    And I wait for 1 sec

    When I type "Question 1" as question
    And I type "Option 1*" in field Option 1
    And I wait for 1 sec
    And I type "Option 2*" in field Option 2
    And I wait for 1 sec
    Then I check "Option 1*" as correct answer in question "Q1"
    Then I check "Option 2*" as correct answer in question "Q1"

    And I click "Add Option" button contains text
    And I type "Option 3*" in field Option 3
    And I click "Add Option" button contains text
    And I type "Option 4*" in field Option 4
    And I wait for 2 sec
    Then I click "Save" button contains text




  Scenario: Multiple Choice question - Validate to Create 15 Options
    Given I open "login" page
    When I type "ttv250971@gmail.com" into email field
    And I type "Valenok" into password field
    Then I click "Sign In" button contains text
    And I wait for 1 sec

    When I Click "Quizzes" link
    And I wait for 1 sec
    And I click "Create New Quiz" button contains text
    And I wait for 1 sec
    Then I type "Automation Quiz Proba TW" as quiz title
    And I wait for 1 sec
    Then I add a question
    Then I select "Multiple" type
    And I wait for 1 sec

    When I type "Question 1" as question
    And I type "Option 1*" in field Option 1
    And I type "Option 2*" in field Option 2
    And I wait for 1 sec
    Then I check "Option 1*" as correct answer in question "Q1"
    Then I check "Option 2*" as correct answer in question "Q1"
    And I wait for 1 sec

    When I add 13 options to question
    And I wait for 5 sec
    Then I click "Save" button contains text

  Scenario: Multiple Choice question - Validate that 16 options cannot be created
    Given I open "login" page
    When I type "ttv250971@gmail.com" into email field
    And I type "Valenok" into password field
    Then I click "Sign In" button contains text
    And I wait for 1 sec

    When I Click "Quizzes" link
    And I wait for 1 sec
    And I click "Create New Quiz" button contains text
    And I wait for 1 sec
    Then I type "Automation Quiz Proba TW" as quiz title
    And I wait for 1 sec
    Then I add a question
    Then I select "Multiple" type
    And I wait for 1 sec

    When I type "Question 1" as question
    And I type "Option 1*" in field Option 1
    And I type "Option 2*" in field Option 2
    And I wait for 1 sec
    Then I check "Option 1*" as correct answer in question "Q1"
    Then I check "Option 2*" as correct answer in question "Q1"
    And I wait for 1 sec

    When I add 14 options to question
    And I wait for 3 sec
    Then I click "Save" button contains text
    Then message "Only 15" is displayed
    And I wait for 1 sec










