@email

Feature: Email scenarios

  @email1
  Scenario: Validate Random email
    Given I open "registration" page
    When I type in new email field
    And I wait for 3 sec

  @email2
  Scenario: Validate email field-Happy path
    Given I open "registration" page
    When I type "abc" into first name filed
    And I type "xyz" into last name field
    When I type "abc123@gmail.com" into email field
    And I wait for 1 sec
    When I type "ABC" into group code field
    And I type "12345" into New Password field
    Then I type "12345" into Confirm New Password field
    Then I click on "Register Me" button
    And I wait for 1 sec
    Then "You have been Registered." page should appear
    And I wait for 1 sec

  @email3
  Scenario: Validate empty  email field
    Given I open "registration" page
    When I type "" into email field
    And I wait for 2 sec
    Then I click on "Register Me" button
    And I wait for 2 sec
    Then "This field is required" message should be displayed
    And I wait for 2 sec


  @email4
  Scenario Outline: Validate special character in email field and 64 char before@ and 65 char before@ and white space not allowed
    Given I open "registration" page
    When I type <email> into email field
    And I wait for 1 sec
    Then I click on "Register Me" button
    And I wait for 1 sec
    Then <expectedError> message should be displayed
    And I wait for 1 sec
    Examples:
      | email                                                                           | expectedError                     |
      | "abc#*'@gmail.com"                                                              | "Should be a valid email address" |
      | "ewhfdwuedgwndskfewfowjfadbsjbceidjasbdiewufdzxcgvhbjnkjybfshhajh@gmail.com"    | ""                                |
      | "ewhfdwuedgwndskfewfowjfadbsjbceidjasbdiewufdzxcgvhbjnkjybfshhajh567@gmail.com" | "Should be a valid email address" |
      | "abc  @gmail.com"                                                               | "Should be a valid email address" |










