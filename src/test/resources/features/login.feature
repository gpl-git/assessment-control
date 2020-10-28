@login
  Feature: Login Scenarios

    Scenario Outline: Login and verify user role
      Given I open <url> page
      When I type <email> as Email
      And I type <password> as Password
      When I click <btnName> button
      And I wait for 2 sec
      Then I verify user role as <userRole>
      Examples:
        | url     | email            | password | btnName  | userRole  |
        | "login" | "test2@test.com" | "12345"  | "Sign In"| "STUDENT" |
        | "login" | "ask_instr@aol.com" | "12345"  | "Sign In"| "TEACHER" |


    Scenario Outline: Verification User Home page
      Given I open "login" page
      When I type <email> as Email
      And I type <password> as Password
      And I click "Sign In" button
      And I wait for 2 sec
      When I click <link> link
      And I wait for 2 sec
      Then I verify <page> page is open
      Examples:
       | email               | password | link      | page      |
       | "ask_instr@aol.com" | "12345"  |   "Quizzes" | "quizzes" |
       | "ask_instr@aol.com" | "12345"  |  "Assignments" | "assignments" |
       | "ask_instr@aol.com" | "12345"  |   "Settings" | "settings" |
       | "ask_instr@aol.com" | "12345"  |   "User's Management" | "users-management" |
       | "ask_instr@aol.com" | "12345"  |   "Submissions" | "submissions" |

