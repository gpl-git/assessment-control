Feature: Last Name

  Scenario: Last Name min 1 characters
    Given I go to "registration" page
    And I type "I" into firstName field
    And I type "L" into lastName field
    Then I type "123@test.com" into email field
    And I type "FEB23" into groupcode field
    Then I type "12345" into password field
    And I type "12345" into confirmpassword field
    Then I click "Register Me" button
    Then page with text "You have been Registered." is displayed
    And I wait for 2 sec

  Scenario: Last Name field required, can’t be empty
    Given I go to "registration" page
    And I type "I" into firstName field
    Then I type "123@test.com" into email field
    And I type "FEB23" into groupcode field
    Then I type "12345" into password field
    And I type "12345" into confirmpassword field
    Then I click "Register Me" button
    Then lastName error massage  should be displayed
    Then error massage "This field is required" should be displayed
    And I wait for 2 sec

  Scenario: White spaces are not allowed
    Given I go to "registration" page
    And I type "I" into firstName field
    And I type " " into lastName field
    Then I type "123@test.com" into email field
    And I type "FEB23" into groupcode field
    Then I type "12345" into password field
    And I type "12345" into confirmpassword field
    Then I click "Register Me" button
    Then LN error massage should be displayed
    Then lastName error massage "Whitespaces are not allowed" should be displayed
    And I wait for 2 sec


  Scenario: Max 254 characters (When the First name 1 char)
    Given I go to "registration" page
    And I type "I" into firstName field
    And I type 254 characters into lastName field
    When I type "123@test.com" into email field
    And I type "FEB23" into groupcode field
    Then I type "12345" into password field
    And I type "12345" into confirmpassword field
    Then I click "Register Me" button
    Then page with text "You have been Registered." is displayed
    And I wait for 2 sec


    Scenario: Max 255 characters (When the First name 1 char)
      Given I go to "registration" page
      And I type "I" into firstName field
      And I type 255 characters into lastName field
      When I type "123@test.com" into email field
      And I type "FEB23" into groupcode field
      Then I type "12345" into password field
      And I type "12345" into confirmpassword field
      Then I click "Register Me" button
 #     Then LastNameerror massage should be displayed
      And I wait for 2 sec
      Then data too long error massage "Data too long for column 'name' at row 1" should be displayed
      And I wait for 2 sec