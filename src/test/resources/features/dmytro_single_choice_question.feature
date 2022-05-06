@singleChoiceQuestion
Feature: Single Choice Question Options

  @first
  Scenario: Create a quiz
    Given I go to "login" page
    When I type "fstewart1990@sewce.com" into email field
    And I type "dmytro123" into password field
    When I click button "Sign In"
    And I wait for 1 sec
    When I click "Quizzes" menu item
    And I wait for 2 sec
    When I click button "Create New Quiz"
    And I wait for 1 sec
    When I type "Dmytro Single Choice Quiz" as quiz title

    And I add a question
    When I select single question type on "Q1"
    When I type "5 + 5 = ???" into "Q1"
    And I type "10" as "Option 1*" into "Q1"
    And I type "20" as "Option 2*" into "Q1"
    And I wait for 1 sec
    Then I select "Option 1*"  as correct option in "Q1"

    And I add a question
    When I select single question type on "Q2"
    And I wait for 1 sec
    When I type "2 + 2 = ???" into "Q2"
    And I type "5" as "Option 1*" into "Q2"
    And I type "4" as "Option 2*" into "Q2"
    And I wait for 1 sec
    Then I select "Option 2*"  as correct option in "Q2"
    Then I mark "Q2" as a show-stopper

    And I add a question
    And I wait for 1 sec
    When I select single question type on "Q3"
    And I wait for 1 sec
    When I type "1 + 1 = ???" into "Q3"
    And I type "2" as "Option 1*" into "Q3"
    And I type "3" as "Option 2*" into "Q3"
    And I wait for 1 sec
    Then I select "Option 1*"  as correct option in "Q3"
    Then I mark "Q3" as a other_text
    And I wait for 1 sec

    And I add a question
    And I wait for 1 sec
    When I select single question type on "Q4"
    And I wait for 1 sec
    When I type "15 - 5 = ???" into "Q4"
    And I type "10" as "Option 1*" into "Q4"
    And I type "5" as "Option 2*" into "Q4"
    And I add a new option for "Q4"
    And I wait for 1 sec
    And I type "20" as "Option 3*" into "Q4"
    And I wait for 1 sec
    Then I select "Option 1*"  as correct option in "Q4"

    And I add a question
    And I wait for 1 sec
    When I select single question type on "Q5"
    And I wait for 1 sec
    When I type "10 - 5 = ???" into "Q5"
    And I type "5" as "Option 1*" into "Q5"
    And I type "10" as "Option 2*" into "Q5"
    And I add a new option for "Q5"
    And I wait for 1 sec
    And I type "15" as "Option 3*" into "Q5"
    And I wait for 1 sec
    And I delete the option "Option 3*" on question "Q5"
    And I wait for 1 sec
    Then I select "Option 1*"  as correct option in "Q5"

    When I click button "Save"
    And I wait for 5 sec
    Then quiz "Dmytro Single Choice Quiz" is displayed on the list of quizzes
    And I wait for 1 sec
    And I delete quiz "Dmytro Single Choice Quiz"

  @second
  Scenario: 15 choices on a question
    Given I go to "login" page
    When I type "fstewart1990@sewce.com" into email field
    And I type "dmytro123" into password field
    When I click button "Sign In"
    And I wait for 1 sec
    When I click "Quizzes" menu item
    And I wait for 2 sec
    When I click button "Create New Quiz"
    And I wait for 1 sec
    When I type "Dmytro Single Choice Quiz" as quiz title

    And I add a question
    When I select single question type on "Q1"
    When I type "1 + 5 = ???" into "Q1"
    And I type "6" as "Option 1*" into "Q1"
    Then I select "Option 1*"  as correct option in "Q1"
    And I type "123" as "Option 2*" into "Q1"

    And I add a new option for "Q1"
    And I type "123" as "Option 3*" into "Q1"

    And I add a new option for "Q1"
    And I type "123" as "Option 4*" into "Q1"

    And I add a new option for "Q1"
    And I type "123" as "Option 5*" into "Q1"

    And I add a new option for "Q1"
    And I type "123" as "Option 6*" into "Q1"

    And I add a new option for "Q1"
    And I type "123" as "Option 7*" into "Q1"

    And I add a new option for "Q1"
    And I type "123" as "Option 8*" into "Q1"

    And I add a new option for "Q1"
    And I type "123" as "Option 9*" into "Q1"

    And I add a new option for "Q1"
    And I type "123" as "Option 10*" into "Q1"

    And I add a new option for "Q1"
    And I type "123" as "Option 11*" into "Q1"

    And I add a new option for "Q1"
    And I type "123" as "Option 12*" into "Q1"

    And I add a new option for "Q1"
    And I type "123" as "Option 13*" into "Q1"

    And I add a new option for "Q1"
    And I type "123" as "Option 14*" into "Q1"

    And I add a new option for "Q1"
    And I type "123" as "Option 15*" into "Q1"

    When I click button "Save"
    And I wait for 5 sec
    Then quiz "Dmytro Single Choice Quiz" is displayed on the list of quizzes
    And I wait for 1 sec
    And I delete quiz "Dmytro Single Choice Quiz"