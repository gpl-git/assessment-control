@tetmihtest @quiztm

Feature: Automate end-to-end test case 2.7 (Component Design)

  Background:
    Given I go to "login" page
    When I type "ask_instr@aol.com" into email field
    And I type "12345" into password field
    When I click "Sign In" button
    And I wait for 1 sec
    When I click "Quizzes" link
    And I wait for 2 sec

  @tetmihtest @quiztm
  Scenario: Creating a QuizTM
    When I click "Create New Quiz" button
    And I wait for 1 sec
    And I type "Tetmih Quiz" as the quiz title
    When I add a question
    And I select "Single-Choice" question type
    When I type "Question 1" into "Q1"
    And I type"Option 1" as "Option 1*" into "Q1"
    And I type"Option 2" as "Option 2*" into "Q1"
    And I select "Option 1*" as correct option in "Q1"
    When I click "Save" button
    And I wait for 1 sec
    Then quiz "Tetmih Quiz" should be displayed on the list of quizzes
    And I click "Assignments" link
    Then I click "Create New Assignment" button
    And I wait for 2 sec
    And I click "Select Quiz To Assign" field
    Then I wait for 2 sec
    Then I select "Tetmih Quiz" quiz
    And I wait for 2 sec
    Then I click on “Student One” in the student list


    When I click "Log Out" link
    Then "Confirmation Window" should be present
    Then I click "Log Out" option
    Given I go to "login" page
    And I wait for 2 sec
    When I type "student1@test.com" into email field
    And I type "12345" into password field
    When I click "Sign In" button
    And I wait for 1 sec
    When I click "My Assignments" link
    And I click "Go To Assignment" button
    And I wait for 2 sec


    


      
