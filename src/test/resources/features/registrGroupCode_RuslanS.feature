@registrationGroupCode
  Feature: Validation Group Code
    Background:
      Given navigate to "http://ask-qa.portnov.com"

    @registration1
#      In this scenario I realize happy path for creating new user
#      with some preset group code
    Scenario: Registration Happy Path
      When I click on "Register Now" button
      And I wait 1 sec
      And I type "Adam" into "First Name" field
      And I type "Greene" into "Last Name" field
      And I fill Email field with random generated email
      And I type "ABC" into "Group Code" field
      And I type "12345" into "Password" field
      And I type "12345" into "Confirm Password" field
      And I wait 1 sec
      And I press "Register Me" button
      And I wait 1 sec
      Then I verify that "You have been Registered." message displayed


    @groupCodeVerification1
#      In this scenario i verify group code that was created during
#      happy path scenario and deleting user
    Scenario: Verificate group code and delete user
      When I type "ask_instr@aol.com" into "Email *" field
      And I type "12345" into "Password *" field
      And I wait 1 sec
      And I press "Sign In" button
      And I wait 1 sec
      And I press "Users Management" menu item
      And I wait 1 sec
      Then I press "Adam Greene" in student list
      And I wait 1 sec
      Then Group should contain "ABC" code
      And I press option button
      And I wait 1 sec
      And I press delete user menu item
      And I wait 3 sec


    @registration2
#      In this scenario I validate functional specification about group code
#      by creating bunch of new users with different group codes
    Scenario Outline: Registration With Different Group Codes
      When I click on "Register Now" button
      And I wait 1 sec
      And I type <userName> into "First Name" field
      And I type <userLastName> into "Last Name" field
      And I fill Email field with random generated email
      And I type <gropCode> into "Group Code" field
      And I type "12345" into "Password" field
      And I type "12345" into "Confirm Password" field
      And I wait 1 sec
      And I press "Register Me" button
      And I wait 1 sec
      Then I verify that "You have been Registered." message displayed
      Examples:
        | userName | userLastName  | gropCode     |
        | "Zack"   | "Greene"      | "!@#$%"      |
        | "John"   | "Greene"      | "123"        |
        | "Jack"   | "Greene"      | "ASD321"     |
        | "Sam"    | "Greene"      | "1234567890" |
        | "Don"    | "Greene"      | "   "        |


    @groupCodeVerification2
#      In this scenario i verify group code that was created during
#      scenario with multiply group code created
    Scenario Outline: Verify group code and delete user
      When I type "ask_instr@aol.com" into "Email *" field
      And I type "12345" into "Password *" field
      And I wait 1 sec
      Then I press "Sign In" button
      And I wait 1 sec
      Then I press "Users Management" menu item
      And I wait 1 sec
      Then I press <usFullName> in student list
      And I wait 1 sec
      Then Group should contain <grCode> code
      Then I press option button
      And I wait 1 sec
      Then I press delete user menu item
      And I wait 3 sec
      Examples:
        | usFullName     | grCode       |
        | "Zack Greene"  | "!@#$%"      |
        | "John Greene"  | "123"        |
        | "Jack Greene"  | "ASD321"     |
        | "Sam Greene"   | "1234567890" |
        | "Don Greene"   | "   "        |
