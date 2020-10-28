@login
  Feature: Login Scenarios

    Scenario Outline: Login and verify user role
      Given I open <url> page
      When I type <email> as Email
      Then I verify user role as <userRole>
      When I click <btnName> button
      And I wait for 2 sec
      Then I verify user role as <userRole>
      Examples:
        | url     | email            | password | btnName  | userRole  |
        | "login" | "test2@test.com" | "12345"  | "Sign In"| "STUDENT" |
        | "login" | "ask_instr@aol.com" | "12345"  | "Sign In"| "TEACHER" |
