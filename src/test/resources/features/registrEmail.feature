@registrEmail
  Feature: Registration - Email
    Background:
      Given I go to "registration" page

    @registrEmail1
    Scenario: Allowable characters: Alphanumeric & Special characters
      When I type "TestFirst" into "First Name" field
      And I type "TestLast" into "Last Name" field
      And I type "test_1@test.com" into "Email" field
      And I type "TestGroup" into "Group Code" field
      And I type "12345" into "Password" field
      And I type "12345" into "Confirm Password" field
      When I click button "Register Me"
      And I wait for 2 sec
      Then message "You have been Registered." should be displayed
      When I go to "login" page
      When I type "ask_instr@aol.com" into email field
      And I enter "12345" as  password
      And I click button "Sign In"
      And I wait for 1 sec
      When I click on "Users Management" menu item
      And I wait for 1 sec
      When I delete "TestFirst TestLast" user

    @registrEmail2
    Scenario: Email field required, can’t be empty
      When I type "TestFirst" into "First Name" field
      And I type "TestLast" into "Last Name" field
      And I type "TestGroup" into "Group Code" field
      And I type "12345" into "Password" field
      And I type "12345" into "Confirm Password" field
      When I click button "Register Me"
      And I wait for 2 sec
      Then message "This field is required" should be displayed

    @registrEmail3
    Scenario: White spaces are not allowed
      When I type "TestFirst" into "First Name" field
      And I type "TestLast" into "Last Name" field
      And I type "test_1@ test.com" into "Email" field
      And I type "TestGroup" into "Group Code" field
      And I type "12345" into "Password" field
      And I type "12345" into "Confirm Password" field
      When I click button "Register Me"
      And I wait for 2 sec
      Then message "Should be a valid email address" should be displayed

    @registrEmail4
    Scenario: Max 64 characters on the left of @ domain
      When I type "TestFirst" into "First Name" field
      And I type "TestLast" into "Last Name" field
      And I type "bjdkvsb12khednvmlwejknsfkvrh_jfnsjhidnfkjdvbjsdmnvdukfsh_nklefof@test.com" into "Email" field
      And I type "TestGroup" into "Group Code" field
      And I type "12345" into "Password" field
      And I type "12345" into "Confirm Password" field
      When I click button "Register Me"
      And I wait for 2 sec
      Then message "You have been Registered." should be displayed
      When I go to "login" page
      When I type "ask_instr@aol.com" into email field
      And I enter "12345" as  password
      And I click button "Sign In"
      And I wait for 1 sec
      When I click on "Users Management" menu item
      And I wait for 1 sec
      When I delete "TestFirst TestLast" user

    @registrEmail5
    Scenario: Max 64 + 1 characters on the left of @ domain
      When I type "TestFirst" into "First Name" field
      And I type "TestLast" into "Last Name" field
      And I type "bjdkvsb12khednvmlwejknsfkvrh_jfnsjhidnfkjdvbjsdmnvdukfsh_nklef4ag@test.com" into "Email" field
      And I type "TestGroup" into "Group Code" field
      And I type "12345" into "Password" field
      And I type "12345" into "Confirm Password" field
      When I click button "Register Me"
      And I wait for 2 sec
      Then message "Should be a valid email address" should be displayed

    @registrEmail6
    Scenario: Max 63 characters on the right of @ domain before top-level domain
      When I type "TestFirst" into "First Name" field
      And I type "TestLast" into "Last Name" field
      And I type "test@dana123krutovtestdatahhmj.kjlknvjhyu1hjbjhjhjkjgukgjbhu15bkjhtg.com" into "Email" field
      And I type "TestGroup" into "Group Code" field
      And I type "12345" into "Password" field
      And I type "12345" into "Confirm Password" field
      When I click button "Register Me"
      And I wait for 2 sec
      Then message "You have been Registered." should be displayed
      When I go to "login" page
      When I type "ask_instr@aol.com" into email field
      And I enter "12345" as  password
      And I click button "Sign In"
      And I wait for 1 sec
      When I click on "Users Management" menu item
      And I wait for 1 sec
      When I delete "TestFirst TestLast" user

    @registrEmail7
    Scenario: Max 63 + 1 characters on the right of @ domain before top-level domain
      #Known issue #FEB-346 - 63 +1 characters are accepted
      When I type "TestFirst" into "First Name" field
      And I type "TestLast" into "Last Name" field
      And I type "test@dana123krutovtestdaatahhmj.kjlknvjhyu1hjbjhjhjkjgukgjbhu15bkjhtg.com" into "Email" field
      And I type "TestGroup" into "Group Code" field
      And I type "12345" into "Password" field
      And I type "12345" into "Confirm Password" field
      When I click button "Register Me"
      And I wait for 2 sec
      Then message "Should be a valid email address" should be displayed

    @registrEmail8
    Scenario: Email without top-level domain
      #Known issue #FEB-663 - email without top level domain allowed
      When I type "TestFirst" into "First Name" field
      And I type "TestLast" into "Last Name" field
      And I type "test_1@test" into "Email" field
      And I type "TestGroup" into "Group Code" field
      And I type "12345" into "Password" field
      And I type "12345" into "Confirm Password" field
      When I click button "Register Me"
      And I wait for 2 sec
      Then message "Should be a valid email address" should be displayed

    @registrEmail9
    Scenario: Max 128 characters
      When I type "TestFirst" into "First Name" field
      And I type "TestLast" into "Last Name" field
      And I type "jdkvsb12khednvmlwejknsfkvrh_jfnsjhidnfkjdvbjsdmnvdukfsh_nklefofd@jdkvsb12khednvmlwejknsfkvrhjfnsjhidnfkjdvbjsdmnvdukfshnklef.com" into "Email" field
      And I type "TestGroup" into "Group Code" field
      And I type "12345" into "Password" field
      And I type "12345" into "Confirm Password" field
      When I click button "Register Me"
      And I wait for 2 sec
      Then message "You have been Registered." should be displayed
      When I go to "login" page
      When I type "ask_instr@aol.com" into email field
      And I enter "12345" as  password
      And I click button "Sign In"
      And I wait for 1 sec
      When I click on "Users Management" menu item
      And I wait for 1 sec
      When I delete "TestFirst TestLast" user

    @registrEmail10
    Scenario: Max 128  + 1 characters on the left of @ domain
      When I type "TestFirst" into "First Name" field
      And I type "TestLast" into "Last Name" field
      And I type "jdkvsb12khednvmlwejknsfkvrh_jfnsjhidnfkjdvbjsdmnvdukfsh_nklefhofd@jdkvsbjhkhednvmlwejknsfkvrhjfnsjhidnfkjdvbjsdmnvdukfshnklef.com" into "Email" field
      And I type "TestGroup" into "Group Code" field
      And I type "12345" into "Password" field
      And I type "12345" into "Confirm Password" field
      When I click button "Register Me"
      And I wait for 2 sec
      Then message "Should be a valid email address" should be displayed

    @registrEmail11
    Scenario: Max 128 + 1 characters on the right of @ domain
      #Known issue #FEB-357 - misleading error message
      When I type "TestFirst" into "First Name" field
      And I type "TestLast" into "Last Name" field
      And I type "jdkvsb12khednvmlwejknsfvrh_jfnsjhidnfkjdvbjsdmnvdukfsh_nklefhofd@jdkvsb12khednvmlwejknsfkvrhjfnsjhihdnfkjdvbjsdmnvdukfshnklef.com" into "Email" field
      And I type "TestGroup" into "Group Code" field
      And I type "12345" into "Password" field
      And I type "12345" into "Confirm Password" field
      When I click button "Register Me"
      And I wait for 2 sec
      Then message "Should be a valid email address" should be displayed

    @registrEmail12
      Scenario: The @ domain is missing
      And I type "TestLast" into "Last Name" field
      And I type "TestLast" into "Last Name" field
      And I type "test.com" into "Email" field
      And I type "TestGroup" into "Group Code" field
      And I type "12345" into "Password" field
      And I type "12345" into "Confirm Password" field
      When I click button "Register Me"
      And I wait for 2 sec
      Then message "Should be a valid email address" should be displayed

    @registrEmail13
    Scenario: Email without domain after the @ symbol and before the top-level domain
      When I type "TestFirst" into "First Name" field
      And I type "TestLast" into "Last Name" field
      And I type "test_1@.com" into "Email" field
      And I type "TestGroup" into "Group Code" field
      And I type "12345" into "Password" field
      And I type "12345" into "Confirm Password" field
      When I click button "Register Me"
      And I wait for 2 sec
      Then message "Should be a valid email address" should be displayed
