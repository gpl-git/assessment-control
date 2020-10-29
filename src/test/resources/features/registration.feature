@registration
  Feature: Registration Email Scenarios


    @smoke1 @registration
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

    @smoke2 @registration
    Scenario: Registration Email Field must be filled 'This field is required'
      Given I open "registration" page
      When I type "Timo" as First Name
      And I type "Limo" as Last Name
      And I click "Register Me" button
      Then error message "This field is required" should be displayed



    @smoke3 @registration
    Scenario: Registration Email No special characters other than "@", "_","." are accepted
      Given I open "registration" page
      When I type "Timo" as First Name
      And I type "Limo" as Last Name
      And I type "tili#@example.com" as Email
      And I click "Register Me" button
      Then error message "Should be a valid email address" should be displayed


    @smoke4 @registration
    Scenario: Registration Email Email without a dot in domain part is not accepted
      Given I open "registration" page
      When I type "Timo" as First Name
      And I type "Limo" as Last Name
      And I type "tili#@examplecom" as Email
      And I click "Register Me" button
      Then error message "Should be a valid email address" should be displayed



    @smoke5 @registration
      Scenario: Registration Email Field - Maximum Number of Allowed Characters
      Given I open "registration" page
      When I type "Timo" as First Name
      And I type "Limo" as Last Name
      And I type "asdhbcvdhbdgdhdhdhdhdgdhdhdhdhdgdhdhdhdhdgdhdhdhdhdgdhdhdhdh1234@asdhbcvdhbdgdhdhdhdhdgdhdhdhdhdgdhdhdhdhdgdhdhdhdhdgdhdhdhdh123.asdhbcvdhbdgdhdhdhdhdgdhdhdhdhdgdhdhdhdhdgdhdhdhdhdgdhdhdhdh123" as Email
      And I type "LVB" as Group Code
      And I type "12345" as Password
      And I type "12345" as Confirm Password
      When I click "Register Me" button
      And I wait for 2 sec
      Then confirmation message "You have been Registered." should be displayed
#    The Scenario Fails due to a Bug TR-591 filed on 10/29/20.



    @smoke6 @registration
    Scenario: Registration Email Minimum Number of Allowed Characters
      Given I open "registration" page
      When I type "Timo" as First Name
      And I type "Limo" as Last Name
      And I type "a@b.com" as Email
      And I type "LVB" as Group Code
      And I type "12345" as Password
      And I type "12345" as Confirm Password
      When I click "Register Me" button
      And I wait for 2 sec
      Then confirmation message "You have been Registered." should be displayed



    @smoke7 @registration
    Scenario: Registration Email  Maximum Number of Allowed Characters before "@"  + 1.
      Given I open "registration" page
      When I type "Timo" as First Name
      And I type "Limo" as Last Name
      And I type "asdhbcvdhbdgdhdhdhdhdgdhdhdhdhdgdhdhdhdhdgdhdhdhdhdgdhdhdhdh12345@abc.com" as Email
      And I click "Register Me" button
      Then error message "Should be a valid email address" should be displayed
#    The Scenario Fails due to a Bug TR-592 filed on 10/29/20.


    @smoke8 @registration
    Scenario: Registration Email  Maximum Number of Allowed Characters after "@" but before "." + 1.
      Given I open "registration" page
      When I type "Timo" as First Name
      And I type "Limo" as Last Name
      And I type "abc@asdhbcvdhbdgdhdhdhdhdgdhdhdhdhdgdhdhdhdhdgdhdhdhdhdgdhdhdhdh1234.com" as Email
      And I click "Register Me" button
      Then error message "Should be a valid email address" should be displayed



    @smoke9 @registration
    Scenario: Registration Email  Maximum Number of Allowed Characters after "." + 1.
      Given I open "registration" page
      When I type "Timo" as First Name
      And I type "Limo" as Last Name
      And I type "abc@abc.asdhbcvdhbdgdhdhdhdhdgdhdhdhdhdgdhdhdhdhdgdhdhdhdhdgdhdhdhdh1234" as Email
      When I click "Register Me" button
      Then error message "Should be a valid email address" should be displayed




    @smoke10 @registration
    Scenario: Registration Email Field: No white spaces allowed
      Given I open "registration" page
      When I type "Timo" as First Name
      And I type "Limo" as Last Name
      And I type "ab c@abc.com" as Email
      When I click "Register Me" button
      Then error message "Should be a valid email address" should be displayed









