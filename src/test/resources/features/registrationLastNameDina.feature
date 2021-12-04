@registration @regression @lastName

Feature: Registration - Last Name

  Background:
    Given I go to "registration" page
    When I type "M" into First Name field
    And I type "kaym2507@gmail.com" into email field
    And I type "abc" into Group Code field
    When I input "12345" into password field
    And I input "12345" into confirm password field

  @registrationLastName
  Scenario: Last Name field accepts Alphanumeric
    When I type "Kay" into the Last Name field
    And I click into "Register Me" button
    Then I switch to new window
    Then I validate that message "You have been Registered" is displayed
    And I wait for 2 sec

  @registrationLastName1
  Scenario: Last name field accepts Special characters
    When I clear the Last Name field
    And I type "$@%" into the Last Name field
    And I click into "Register Me" button
    Then I switch to new window
    Then I validate that message "You have been Registered" is displayed
    And I wait for 2 sec

  @registrationLastname2
  Scenario: White spaces are not allowed
    When I clear the Last Name field
    And I type "  " into the Last Name field
    And I click into "Register Me" button
    And I wait for 2 sec
    Then I validate that message "Whitespaces are not allowed" is displayed

  @registrationlastname3
  Scenario: Last Name field required, can’t be empty
    When I clear the Last Name field
    And I type "" into the Last Name field
    And I click into "Register Me" button
    And I wait for 2 sec
    Then I validate Last Name field displays error message "This field is required"

  @registrationlastname4
  Scenario: Last Name field accepts Min 1 characters
    When I clear the Last Name field
    And I type "a" into the Last Name field
    And I click into "Register Me" button
    And I wait for 2 sec
    Then I switch to new window
    Then I validate that message "You have been Registered" is displayed
    And I wait for 2 sec

  @registrationlastname5
  Scenario: Last name field accepts Max 254 characters (When the First name 1 char)
    When I type Alpha Numeric Characters 254 into the Last Name field
    And I click "Register Me" button
    And I switch to a new window
    And I wait for 2 sec
    Then confirmation message "You have been Registered" should be displayed
    And I wait for 2 sec

  @registrationlastname6
  Scenario: Last Name field does not accept 254+1 characters
    When I type Alpha Numeric Characters 255 into the Last Name field
    And I click "Register Me" button
    And I wait for 1 sec
    And an alert message "Data too long for column 'name' at row 1 " should be displayed
    And I wait for 2 sec

  @registrationlastname7
  Scenario Outline: Last Name field accepts Alphanumeric & Special characters - Scenario outline
    When I type <lastname> into the Last Name field
    And I click into "Register me" button
    And I switch to a new window
    And I wait for 2 sec
    Then confirmation message "You have been Registered" should be displayed
    Examples:
      | lastname |
      | "Kay"    |
      | "ABCD"   |
      | "1234"   |
      | "*$%@^$" |








