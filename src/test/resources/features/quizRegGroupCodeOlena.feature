@quizReistration

Feature: Quiz Scenarios
  Background:
    Given I go to "registration" page
    When I type "FirstTest_Olena" into "First Name" field
    And I type "LastTest_Olena" into "Last Name" field
    And I type "test_123@test.com" into "Email" field
    And I type "12345" into "Password" field
    And I type "12345" into "Confirm Password" field
    When I click button "Register Me"
    And I wait for 2 sec

  @registrGroupCode1
  Scenario: Allowable characters: Alphanumeric & Special characters
    And I type "qwertyui1!" into "Group Code" field
    When I click button "Register Me"
    And I wait for 2 sec
    Then message "You have been Registered." should be displayed
    When I go to "login" page
    When I type "kallen925@twsh.us" into email field
    And I enter "1598414" as  password
    And I click button "Sign In"
    And I wait for 1 sec
    When I click on "Users Management" menu item
    And I wait for 2 sec
    When I delete "FirstTest_Olena LastTest_Olena" user

  @registrGroupCode2
  Scenario: Group Code field is required, can’t be empty
    Then message "This field is required" should be displayed

  @registrGroupCode3
  Scenario: Min 1 characters
    And I type "q" into "Group Code" field
    When I click button "Register Me"
    And I wait for 2 sec
    Then message "You have been Registered." should be displayed
    When I go to "login" page
    When I type "kallen925@twsh.us" into email field
    And I enter "1598414" as  password
    And I click button "Sign In"
    And I wait for 1 sec
    When I click on "Users Management" menu item
    And I wait for 2 sec
    When I delete "FirstTest_Olena LastTest_Olena" user

  @registrGroupCode4
  Scenario: Max 10 characters
    And I type "qwertyuiopas" into "Group Code" field
    When I click button "Register Me"
    And I wait for 2 sec
    Then message "Should no more than 10 characters" should be displayed

  @registrGroupCode1
  Scenario: White spaces are not allowed
    And I type "qwerty 1!1" into "Group Code" field
    When I click button "Register Me"
    And I wait for 2 sec
    Then message "You have been Registered." should be displayed
    When I go to "login" page
    When I type "kallen925@twsh.us" into email field
    And I enter "1598414" as  password
    And I click button "Sign In"
    And I wait for 1 sec
    When I click on "Users Management" menu item
    And I wait for 2 sec
    When I delete "FirstTest_Olena LastTest_Olena" user
