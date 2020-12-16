Feature: Quiz Total Questions
  Scenario: Happy path
    Given I open "login"
    When I enter "ask_instr@aol.com" as email
    And I enter "12345" as password
    When I click "Sign In" button
    And I wait for 1 sec
    Then I verify that user role is equal to "TEACHER"
    And I click "Quizzes" link
    And I wait for 2 sec
    When I click "Create New Quiz" button
    And I wait for 1 sec
    And I type "Bohdan Lypko44" as title
    When I add a question
    And I wait for 2 sec
    Then I type "Test" in question text field and create "Textual" questions
    Then I type "Test" in question text field and create 3 "Textual" questions
    And I wait for 1 sec
    Then I save my quiz
    And I wait for 1 sec
    Then I verify 3 created question with quizz name "Bohdan Lypko44"



    Scenario: 51 question with requirements of 50
      Given I open "login"
      When I enter "ask_instr@aol.com" as email
      And I enter "12345" as password
      When I click "Sign In" button
      And I wait for 1 sec
      Then I verify that user role is equal to "TEACHER"
      And I click "Quizzes" link
      And I wait for 2 sec
      When I click "Create New Quiz" button
      And I wait for 1 sec
      And I type "Bohdan Lypko122223" as title
      When I add a question
      And I wait for 2 sec
      Then I type "Test" in question text field and create "Textual" questions
      Then I type "Test" in question text field and create 51 "Textual" questions
      And I wait for 1 sec
      Then I save my quiz
      And I wait for 1 sec
      Then I verify 51 created question with quizz name "Bohdan Lypko122223"





