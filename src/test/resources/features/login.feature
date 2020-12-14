Feature: Login Scenarios

  Scenario: Login as a teacher
    Given I open "login"
    When I enter "ask_instr@aol.com" as email
    And I enter "12345" as password
    When I click "Sign In" button
    And I wait for 1 sec
    Then I verify that user role is equal to "TEACHER"
    And I click "Settings" link
    And I wait for 2 sec



  Scenario: Login as a student
    Given I open "login"
    When I enter "test5@test.com" as email
    And I enter "12345" as password
    When I click "Sign In" button
    And I wait for 3 sec
    Then I verify that user role is equal to "STUDENT"

  Scenario Outline: Login
    Given I open <url>
    When I enter <email> as email
    And I enter <pwd> as password
    When I click <btnName> button
    And I wait for <sec> sec
    Then I verify that user role is equal to <userRole>
    Examples:
      | url     | email               | pwd     | btnName   | sec | userRole  |
      | "login" | "ask_instr@aol.com" | "12345" | "Sign In" | 3   | "TEACHER" |
      | "login" | "test5@test.com" | "12345" | "Sign In" | 3   | "STUDENT" |

