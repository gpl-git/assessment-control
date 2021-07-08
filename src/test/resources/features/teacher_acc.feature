@teacher_acc
  Feature: Teacher Account Creation Scenarios

    Scenario: Create Teacher's account
      Given I go to "registration" page
      And I wait for 1 sec
      When I type "Bill" into First Name field
      And I type "M" into Last Name field
      When I type "5mus@txtee.site" into email field
      And I type "ABC" into Group Code field
      And I type "123456" into password field
      And I type "123456" into Confirm password field
      When I click on "Register Me" button
      And I wait for 3 sec
      When I click on "Back to Login Page" button
      Then I type "zhossam@ardesy.com" into email field
      And I type "123456" into password field
      And I click on "Sign In" button
      Then I wait for 1 sec
      Then I verify current url as "home"
      When I click on "User's Management" tab option







