@multiple
Feature: Multiple Choice Question - Option

  Background:
    Given I go to "login" page
    When I type "ask_instr@aol.com" into email field
    And I type "12345" into password field
    When I click on "Sign In" button
    And I wait for 1 sec
    Then I verify current url as "home"
    When I click on "Quizzes" tab
    And I wait for 1 sec

  @multiple1
  Scenario: Verify that max 1000 characters allowed in Question
    When I click on "Create New Quiz" button
    And I wait for 1 sec
    And I type quiz title "Olena Quiz"
    When I add a question
    And I select "Multiple" question type
    When I type question text "hbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgc" into "Q1"
    And I wait for 2 sec
    And I type "Option 1" as option "Option 1*" into "Q1"
    And I wait for 2 sec
    And I type "Option 2" as option "Option 2*" into "Q1"
    And I wait for 2 sec
    And I select correct option in "Q1" as "Option 1*"
    And I wait for 1 sec
    When I click on "Save" button
    And I wait for 1 sec
    Then quiz "Olena Quiz" should be displayed on the list of quizzes
    And I delete "Olena Quiz" from the list of quizzes

  @multiple2
  Scenario: Verify that max 1000 characters allowed in Option
    When I click on "Create New Quiz" button
    And I wait for 1 sec
    And I type quiz title "Olena Quiz"
    When I add a question
    And I select "Multiple" question type
    When I type question text "Text question is here" into "Q1"
    And I wait for 2 sec
    And I type "hbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgc" as option "Option 1*" into "Q1"
    And I wait for 2 sec
    And I type "hbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgc" as option "Option 2*" into "Q1"
    And I wait for 2 sec
    And I select correct option in "Q1" as "Option 1*"
    And I wait for 1 sec
    When I click on "Save" button
    And I wait for 1 sec
    Then quiz "Olena Quiz" should be displayed on the list of quizzes
    And I delete "Olena Quiz" from the list of quizzes

  @multiple3
  Scenario: Verify error message for max +1 characters in Question
    When I click on "Create New Quiz" button
    And I wait for 1 sec
    And I type quiz title "Olena Quiz"
    When I add a question
    And I select "Multiple" question type
    When I type question text "shbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgc" into "Q1"
    And I wait for 2 sec
    And I type "Option 1" as option "Option 1*" into "Q1"
    And I wait for 2 sec
    And I type "Option 2" as option "Option 2*" into "Q1"
    And I wait for 2 sec
    And I select correct option in "Q1" as "Option 1*"
    And I wait for 1 sec
    When I click on "Save" button
    And I wait for 1 sec
#      Known issus max+1 characters ASKJ-
    Then I verify that error message contains "Max 1000 characters allowed"

  @multiple4
  Scenario: Verify error message for max +1 characters in Option
    When I click on "Create New Quiz" button
    And I wait for 1 sec
    And I type quiz title "Olena Quiz"
    When I add a question
    And I select "Multiple" question type
    When I type question text "Text question is here" into "Q1"
    And I wait for 2 sec
    And I type "shbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgc" as option "Option 1*" into "Q1"
    And I wait for 2 sec
    And I type "shbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgcshbvlsvhydvgc" as option "Option 2*" into "Q1"
    And I wait for 2 sec
    And I select correct option in "Q1" as "Option 1*"
    And I wait for 1 sec
    When I click on "Save" button
    And I wait for 1 sec
#      Known issus max+1 characters ASKJ-
    Then I verify that error message contains "Max 1000 characters allowed"

  @multiple5
  Scenario: Verify that max 15 choices allowed
    When I click on "Create New Quiz" button
    And I wait for 1 sec
    And I type quiz title "Olena Quiz"
    When I add a question
    And I select "Multiple" question type
    When I create a MC question with 15 choices
    And I wait for 1 sec
    When I click on "Save" button
    And I wait for 1 sec
    Then quiz "Olena Quiz" should be displayed on the list of quizzes
    And I delete "Olena Quiz" from the list of quizzes

  @multiple6
  Scenario: Verify error message for max +1 choices
    When I click on "Create New Quiz" button
    And I wait for 1 sec
    And I type quiz title "Olena Quiz"
    When I add a question
    And I select "Multiple" question type
    When I create a MC question with 16 choices
    And I wait for 1 sec
    When I click on "Save" button
    And I wait for 1 sec
#      Known issus max+1 characters ASKJ-
    Then I verify that error message contains "Max 15 choices allowed"

