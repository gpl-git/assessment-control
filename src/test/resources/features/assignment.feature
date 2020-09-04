Feature: Assignment Scenarios


  Scenario: Teacher creates a Quiz and assigns it to all students
    Given I open "login" page
    When  I type "ask_instr@aol.com" into email field
    And I type "12345" into password field
    When I click "Sign In" button
    And I wait for 1 sec
    Then I click "Quizzes" link
    And I wait for 3 sec
    When I click "Create New Quiz" button
    And I wait for 1 sec
    Then I type "Task for all students" as quiz title
    And I add a question
    And I wait for 1 sec
    When I select "Textual" type
    And I wait for 2 sec
    When I type "Question 1" as question "Q1" option "Question *"
    And I wait for 1 sec
    When I click "Save" button
    And I wait for 2 sec
    When I click "Assignments" link
    And I click "Create New Assignment" button
    And I wait for 3 sec
    Then I select quiz "Task for all students"
    And I wait for 2 sec
    And I select "ABC" group
    When I click "Select All" button
    And I wait for 2 sec
    Then I click "Give Assignment" button
  
  Scenario: Teacher creates a Quiz and assigns it to 5 individual students
    Given I open "login" page
    When  I type "ask_instr@aol.com" into email field
    And I type "12345" into password field
    When I click "Sign In" button
    And I wait for 1 sec
    Then I click "Quizzes" link
    And I wait for 3 sec
    When I click "Create New Quiz" button
    And I wait for 1 sec
    Then I type "Task for 5 students" as quiz title
    And I add a question
    And I wait for 1 sec
    When I select "Textual" type
    And I wait for 2 sec
    When I type "Question 1" as question "Q1" option "Question *"
    And I wait for 1 sec
    When I click "Save" button
    And I wait for 2 sec
    When I click "Assignments" link
    And I click "Create New Assignment" button
    And I wait for 3 sec
    Then I select quiz "Task for 5 students"
    And I wait for 2 sec
    And I select "ABC" group
    When I select 5 students
    And I wait for 2 sec
    Then I click "Give Assignment" button