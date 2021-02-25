@homePageLinks @smoke

Feature: Login Scenarios

  @smoke1
  Scenario Outline: Home page links from Teacher
    Given I go to "ask"
    When I enter "gyoung.c@ramagerealty.com" into email field
    And I enter "12345" into password field
    When I click "Sign In" button
    And I wait for 1 sec
    Then I verify that user is logged in at "home" page
    And I verify that "TEACHER" user role is displayed
    Then I go to the page <page> and validate page details
    And I wait for 1 sec
    Then I go to back on Home page
    Then I verify that user is logged in at "home" page


    Examples:
      | page                  |
      | "Submissions"         |
      | "Assignments"         |
      | "Quizzes"             |
      | "Management"          |
      | "Settings"            |


  @smoke2
  Scenario Outline: Home page links from Student
    Given I go to "ask"
    When I enter "student1@test.com" into email field
    And I enter "12345" into password field
    When I click "Sign In" button
    And I wait for 1 sec
    Then I verify that user is logged in at "home" page
    And I verify that "STUDENT" user role is displayed
    Then I go to the page <page> and validate page details
    And I wait for 1 sec
    Then I go to back on Home page
    Then I verify that user is logged in at "home" page
    Examples:
      | page             |
      | "Assignments"    |
      | "Grades"         |
      | "Settings"       |
