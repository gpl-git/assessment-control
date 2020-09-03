@smoke
  Feature: Registration First Name

    Scenario: First Name Alphanumeric & Special characters
      Given I open "registration" page
      When I type "abc@#$" into firstName field
      And I type "Last" into lastName field
      And I type "test@test.com" into email field
      When I type "ABC" into group field
      And I type "12345" into password field
      When I type "12345" into confirmPassword field
      When I click "Register Me" button
      Then confirmation message "You have been Registered." is displayed

   Scenario: First name field is required
     Given I open "registration" page
     When I type "" into firstName field
     And I type "Last" into lastName field
     And I type "test@test.com" into email field
     When I type "ABC" into group field
     And I type "12345" into password field
     When I type "12345" into confirmPassword field
     When I click "Register Me" button
     And I wait for 2 sec
     Then error message "This field is required" is displayed
     And I wait for 2 sec

   Scenario: Max 254 characters (When the Last name 1 char)
     Given I open "registration" page
     When I type "tttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttttt" into firstName field
     And I type "L" into lastName field
     And I type "test1@test.com" into email field
     When I type "ABC" into group field
     And I type "12345" into password field
     When I type "12345" into confirmPassword field
     When I click "Register Me" button
     And I wait for 2 sec
     Then confirmation message "You have been Registered." is displayed
     And I wait for 3 sec

    Scenario: Min 1 characters
      Given I open "registration" page
      When I type "F" into firstName field
      And I type "Last" into lastName field
      And I type "test@test.com" into email field
      When I type "ABC" into group field
      And I type "12345" into password field
      When I type "12345" into confirmPassword field
      When I click "Register Me" button
      Then confirmation message "You have been Registered." is displayed

    Scenario: White spaces are not allowed
      Given I open "registration" page
      When I type " " into firstName field
      And I type "Last" into lastName field
      And I type "test3@test.com" into email field
      When I type "ABC" into group field
      And I type "12345" into password field
      When I type "12345" into confirmPassword field
      When I click "Register Me" button
      Then error "Whitespaces are not allowed" is displayed