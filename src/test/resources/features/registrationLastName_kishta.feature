@registrationLastName
Feature: Registration - Last name

  @registrationLastName1
  Scenario: Allowable characters Alphanumeric & Special characters
    Given KB I navigate to "registration" page
    When KB I type "A" into first name field
    And KB I type "Ab1!" into last name field
    And KB I type "abc@zxc.vbn" into email field
    And KB I type "AAA" into group code field
    And KB I type "12345" into password field
    And KB I type "12345" into confirm password field
    Then KB I click "Register Me" button
    And KB I wait for 2 sec

  @registrationLastName2
  Scenario: Last Name field required, can’t be empty
    Given KB I navigate to "registration" page
    When KB I type "A" into first name field
    And KB I type "" into last name field
    And KB I type "abc@zxc.vbn" into email field
    And KB I type "AAA" into group code field
    And KB I type "12345" into password field
    And KB I type "12345" into confirm password field
    Then KB I click "Register Me" button
    And KB I wait for 2 sec

  @registrationLastName3
  Scenario: Max 254 characters (When the First name 1 char)
    Given KB I navigate to "registration" page
    When KB I type "A" into first name field
    And KB I type "Qaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" into last name field
    And KB I type "abc@zxc.vbn" into email field
    And KB I type "AAA" into group code field
    And KB I type "12345" into password field
    And KB I type "12345" into confirm password field
    Then KB I click "Register Me" button
    And KB I wait for 2 sec

  @registrationLastName4
  Scenario: Min 1 characters
    Given KB I navigate to "registration" page
    When KB I type "ASfdf" into first name field
    And KB I type "A" into last name field
    And KB I type "abc@zxc.vbn" into email field
    And KB I type "AAA" into group code field
    And KB I type "12345" into password field
    And KB I type "12345" into confirm password field
    Then KB I click "Register Me" button
    And KB I wait for 2 sec

  @registrationLastName5
  Scenario: White spaces are not allowed
    Given KB I navigate to "registration" page
    When KB I type "A" into first name field
    And KB I type " Ab1!" into last name field
    And KB I type "abc@zxc.vbn" into email field
    And KB I type "AAA" into group code field
    And KB I type "12345" into password field
    And KB I type "12345" into confirm password field
    Then KB I click "Register Me" button
    And KB I wait for 2 sec




