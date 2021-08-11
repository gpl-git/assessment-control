@login
  Feature: Login Scenarios

    @smoke
    Scenario: Login - Happy Path Teacher
      Given I open "login" page
      When I type "ask_instr@aol.com" into email field
      And I type "12345" into password field
      When click on "Sign In" button
      And I wait for 1 sec
      Then I verify that current url contains "home"
      Then I verify that user role is "Teacher"
      And I wait for 2 sec

    @smoke
    Scenario Outline: Login - Happy Path Teacher with parameters
      Given I open "login" page
      When I type <email> into email field
      And I type <password> into password field
      When click on "Sign In" button
      And I wait for 1 sec
      Then I verify that current url contains "home"
      Then I verify that user role is <role>
      And I wait for 2 sec
      Examples:
         | email               | password |   role      |
        | "ask_instr@aol.com" | "12345"  |   "Teacher" |
        | "student2@test.com" | "12345"  |   "Student" |