@registrationGroupCode
  Feature: Validation Group Code
    Background:
      Given navigate to "http://ask-qa.portnov.com"

    @registration
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

    @groupCodeValidation
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
