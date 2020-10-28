@registration
  Feature: Registration Email


    @smoke @registration
      Scenario: Registration Email Happy Path
      Given I open "registration" page
      When I type "Timo" as First Name
      And I type "Limo" as Last Name
      And I type "tili1@example.com" as Email
      And I type "LVB" as Group Code
      And I type "12345" as Password
      And I type "12345" as Confirm Password
      When I click "Register Me" button
      And I wait for 2 sec
      Then confirmation message "You have been Registered." should be displayed



    @smoke @registration
    Scenario: Registration Email Happy Path
      Given I open "registration" page
      When I type "Timo" as First Name
      And I type "Limo" as Last Name
      And I type "tili#@example.com" as Email
      And I type "LVB" as Group Code
      And I type "12345" as Password
      And I type "12345" as Confirm Password
      When I click "Register Me" button
      And I wait for 2 sec
      Then




