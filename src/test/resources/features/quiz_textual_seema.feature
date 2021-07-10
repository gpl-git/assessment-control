@quizTextualquiz
Feature: Quiz textual scenarios

  Scenario: Log in to site
    Given I open "login" page
    When I type "qa1@askproject.com" into my email field
    And I type "12345"as password
    And I wait for 2 sec
    When I click  "Sign In" button
    And I wait for 2 sec
    Then I verify opened current url as "home"
    When I click on tab "Quizzes"
    And I wait for2 sec
    When I click the "Create New Quiz" button
    And I wait for 4 sec
    When I type "seema quiz" as Quiz title
    And I wait for2 sec
    When I add question
    And I select "Textual" as question type
    And I wait for4 sec
    When I type text "Question1" into"Q1"
    And I wait for4 sec
    When I click on button "Save"
    And I wait for4 sec
    Then I verify "seema quiz" should be displayed in list of quizzes
    And I wait for2 sec
    Then I delete "seema quiz" from quizzes list

  @quiztextualquiz2
  Scenario: Create Random quiz title
    Given I open "login" page
    When I type "qa1@askproject.com" into my email field
    And I type "12345"as password
    And I wait for 2 sec
    When I click  "Sign In" button
    And I wait for 2 sec
    Then I verify opened current url as "home"
    When I click on tab "Quizzes"
    And I wait for2 sec
    When I click the "Create New Quiz" button
    And I wait for 4 sec
    When I create a quiz title
    And I wait for2 sec
    When I create quiz with number of question 5 SP









