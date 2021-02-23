@larisaHomePage @smoke

Feature: Login Scenarios

  @smoke1
  Scenario Outline: Login HappyPath Teacher role
    Given I go to "ask"
    When I enter "ask_instr@aol.com" into email field
    And I enter "12345" into password field
    When I click "Sign In" button
    And I wait for 1 sec
    Then I verify that user is logged in at "home" page
    And I verify that "TEACHER" user role is displayed
    Then I go to the page <page> and validate page details
    And I wait for 1 sec

    Examples:
      | page                  |
      | "Submissions"         |
      | "Assignments"         |
      | "Quizzes"             |
      | "Management"          |
      | "Settings"            |


  @smoke2
  Scenario Outline: Login HappyPath Student role
    Given I go to "ask"
    When I enter "student1@test.com" into email field
    And I enter "12345" into password field
    When I click "Sign In" button
    And I wait for 1 sec
    Then I verify that user is logged in at "home" page
    And I verify that "STUDENT" user role is displayed
    Then I go to the page <page> and validate page details

    Examples:
      | page             |
      | "Assignments"    |
      | "Grades"         |
      | "Settings"       |
