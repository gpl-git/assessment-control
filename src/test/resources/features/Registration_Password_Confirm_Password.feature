@registration_password
Feature: Registartion Password/Confirm Password Scenarios

  Background:
    Given I open "login" page
    And I wait for 1 sec
    Given I Navigate to "Register Now" button
    When I type "Katya" into first name filed
    And I type "Surla" into last name field
    When I type new email
    Then I type "KK" into group code field

  @registration_password1
  Scenario: Allowable characters: Alphanumeric & Special characters
    And I type "11111" into password field
    And I type "11111" into confirm password field
    Then I click register me button
    And I wait for 2 sec
    And "You have been Registered." message should appear

  @registration_password2
  Scenario Outline: Not Allowable characters: error messages
    And I type <password> into password field
    And I type <confirmPassword> into confirm password field
    And I wait for 2 sec
    Then I click register me button
    And I wait for 2 sec
    And error <errormsg> should appear
    Examples:
      | password                            | confirmPassword                                 | errormsg                                          |
      | ""                                  | ""                                              | "This field is required"                          |
      | "2"                                 | ""                                              | "Too short. Should be at least 5 characters"      |
      | "2222"                              | ""                                              | "Too short. Should be at least 5 characters"      |
      | "hgfjkdhgkfdjhgkjfdhgjkfdhgjkgfgfg" | ""                                              | "Too long. Should be no more than 32 characters"  |
      | "dd ff"                             | ""                                              | "Whitespaces are not allowed"                     |
      | "abc123"                            | "abc321"                                        | "Entered passwords should match"                  |


  @registration_password3
  Scenario Outline: Allowable characters: Alphanumeric & Special characters
    And I type <password> into password field
    And I type <confirmPassword> into confirm password field
    Then I click register me button
    And I wait for 2 sec
    And <registrationmsg> message should appear
    Examples:
      | password                            | confirmPassword                               | registrationmsg             |
      | "hgfjkdhgkfdjhgkjfdhgjkfdhgjkgfgf"  | "hgfjkdhgkfdjhgkjfdhgjkfdhgjkgfgf"            | "You have been Registered." |
      | "abc123"                            | "abc123"                                      | "You have been Registered." |
      | "abc123!"                           | "abc123!"                                     | "You have been Registered." |



