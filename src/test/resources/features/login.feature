@login @smoke

  Feature: Login Scenarios

    @smoke
    Scenario: Login HappyPath
      Given I go to "ask"
      When I enter "ask_instr@aol.com" into email field
      And I enter "12345" into password field
      When I click "Sign In" button
      And I wait for 1 sec
      Then I verify that user is logged in at "home" page
      And  I verify that "TEACHER" user role is displayed
      Then I



