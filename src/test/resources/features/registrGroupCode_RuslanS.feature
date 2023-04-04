@registrationGroupCode
  Feature: Validation Group Code
    Background:
      Given navigate to "http://ask-qa.portnov.com"

    @registration1
    Scenario: Registration
      When I click on "Register Now" button
      And I wait 1 sec
      Then I type "Zack" into "First Name" field
      Then I type "Greene" into "Last Name" field
      Then I type "reihanreihan@54.mk" into "Email" field
      Then I type "GHJ" into "Group Code" field
      Then I type "12345" into "Password" field
      Then I type "12345" into "Confirm Password" field
      And I wait 1 sec
      Then I press "Register Me" button
      And I wait 3 sec

    @registration2
    Scenario Outline: Registration outlined
      When I click on "Register Now" button
      And I wait 1 sec
      Then I type <keyText> into "First Name" field
      Then I type <keyText1> into "Last Name" field
      Then I type <keyText2> into "Email" field
      Then I type <keyText3> into "Group Code" field
      Then I type <keyText4> into "Password" field
      Then I type <keyText4> into "Confirm Password" field
      And I wait 1 sec
      Then I press "Register Me" button
      And I wait 1 sec
      Examples:
        | keyText |  keyText1 |  keyText2              |  keyText3         |  keyText4 |
        | "Zack"  |  "Greene" |  "reihanreihan@54.mk1" |  "GHJ"            |  "12345"  |
        | "John"  |  "Greene" |  "reihanreihan@54.mk2" |  "G"              |  "12345"  |
        | "Jack"  |  "Greene" |  "reihanreihan@54.mk3" |  "ASDFGHJKLP"     |  "12345"  |
        | "Sam"   |  "Greene" |  "reihanreihan@54.mk4" |  "1234567890A"    |  "12345"  |
        | "Don"   |  "Greene" |  "reihanreihan@54.mk4" |  ""    |  "12345"  |
        | "Micah"   |  "Greene" |  "reihanreihan@54.mk4" |  "   "    |  "12345"  |


    @groupCodeValidation1
    Scenario: Validate group code and delete user
      When I type "ask_instr@aol.com" into "Email *" field
      And I type "12345" into "Password *" field
      And I wait 1 sec
      Then I press "Sign In" button
      And I wait 1 sec
      Then I press "Users Management" menu item
      And I wait 1 sec
      Then I press "Zack Greene" in student list
      And I wait 1 sec
      Then Group should contain "GHJ" code
      Then I press option button
      And I wait 1 sec
      Then I press delete user menu item
      And I wait 3 sec

    @groupCodeValidation2
    Scenario Outline: Validate group code and delete user
      When I type "ask_instr@aol.com" into "Email *" field
      And I type "12345" into "Password *" field
      And I wait 1 sec
      Then I press "Sign In" button
      And I wait 1 sec
      Then I press "Users Management" menu item
      And I wait 1 sec
      Then I press <usName> in student list
      And I wait 1 sec
      Then Group should contain <grCode> code
      Then I press option button
      And I wait 1 sec
      Then I press delete user menu item
      And I wait 3 sec
      Examples:
        | usName        | grCode |
        | "Zack Greene" | "GHJ"  |
        | "John Greene" |  "G"              |
        | "Jack Greene" |  "ASDFGHJKLP"     |
        | "Sam Greene"  |  "1234567890A"    |
        | "Don Greene" |    ""    |
        | "Micah Greene" |   "   "  |
