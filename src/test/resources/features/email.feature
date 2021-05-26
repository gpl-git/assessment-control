@registration
  Feature: Email scenarios

    Scenario: Validate email field
      Given I open "registration" page
      When I type in new email field
      And I wait for 3 sec
@email1
    Scenario: Validate email error
      Given I open "registration" page
      When I type "abc" into email field
     And I wait for 1 sec
      Then I click on "Register me " button
      And I wait for 1 sec
      Then "Should be a valid email address" message should be displayed
      And I wait for 2 sec
@email2
    Scenario: Validate empty email field
      Given I open "registration" page
      When I type "" into email field
      And I wait for 1 sec
      Then I click on "Register me " button
      And I wait for 1 sec
      Then  "This field is required" message should be displayed
      And I wait for 1 sec

