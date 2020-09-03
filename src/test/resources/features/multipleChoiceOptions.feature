@smoke
Feature: Multiple choice question - Options

  Scenario: Multiple Choice question Happy Path
    Given I open "login" page
    When I type "ttv250971@gmail.com" into email field
    And I type "Valenok" into password field
#    Then I click "Sign In" button
    And I click "Sing In" button and Sing in as a teacher

    When I click "Quiz" button to open List of Quizzes
    And I click "Create New Quiz" button
    And I type "Automation Quiz Test TanyaW" in Title of the Quiz
    And I click  button to add Question
#    And I click button Multiple Choice
    Then I select "Single" type
  And I wait 2 sec

#
#    When  I type "What's your favorite color?" into Question field
#    And I type "blue" in field Option 1
#    And I type "red" in field Option 2
##    And I click "Add Option" button
#    And I click to add Option
#    And I type "black" in field Option 3
#    And I click to add Option
#    And I type "white" in field Option 4

#    Then I click button to choose right Option





