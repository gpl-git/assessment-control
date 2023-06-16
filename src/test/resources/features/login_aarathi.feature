@login
Feature: login
  Background:
    Given I go to "login" page

  @login1
  Scenario Outline: login positive
    When I type <email> into email field
    And I type <password> into password field
    When I click "Sign In" button
    And I wait for 1 sec
    Then I should be on home page AaR
    And I wait for 2 sec
    Examples:
      | email               | password |
      | "ask_instr@aol.com" | "12345"  |
      | "ASK_INSTR@AOL.com" | "12345"  |

  @login2
  Scenario: login2
    Given I go to "login" page
    When I type "12345" into password field
    Then I should see password is masked AaR

  @login3
  Scenario Outline: login3 - leading and trailing white space in email, empty email or password,case sensitive password
    When I type <email> into email field
    And I type <password> into password field
    When I click "Sign In" button
    And I wait for <sec> sec
    Then <message> should be displayed AaR
    And I wait for <sec1> sec
    Examples:
      | email                      | password | sec | message                           | sec1 |
      | "  orpheusiv@youinweb.xyz" | "abcde"  | 3   | "Should be a valid email address" | 1    |
      |"orpheusiv@youinweb.xyz   " | "abcde"  | 3   | "Should be a valid email address" | 1    |
      |          ""                | "abcde"  | 3   | "This field is required"          | 1    |
      | "ask_instr@aol.com"        | ""       | 3   | "This field is required"          | 1    |
      | "orpheusiv@youinweb.xyz"   | "ABCDE"  | 3   |"Authentication failed."           | 1    |
      | "ask_instr@aol.com"        | "1234"   |  3 | "Authentication failed."          | 1    |
      | "ask_instr123@aol.com"     | "12345"  |  3  | "Authentication failed."          | 1    |




