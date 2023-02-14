@predefined
Feature: Password and confirm password field

  @predefined1
  Scenario: Allowable characters: Alphanumeric & Special characters for password and confirm password field
    Given I open "Registration" Page.
    When I type "dhjfdshj374?&*%^" into First Name
    And I type "dshgfsgy45437?($^*" into Last Name
    When I type "prometeyb@cashbackr.com" into Email
    And I type "123" into Group Code
    When I type "dgf4657!?<" into Password
    And I type "dgf4657!?<" into Confirm Password
    When I click "Register" button
    And I wait for 5 sec
    Then "You have been Registered." confirmation message should be displayed


  @predefined2
  Scenario: Password field is required - cannot be empty
    Given I open "Registration" Page.
    When I type "dhjfdshj374?&*%^" into First Name
    And I type "dshgfsgy45437?($^*" into Last Name
    When I type "prometeyb@cashbackr.com" into Email
    And I type "123" into Group Code
    When I type "" into Password
    And I type "dgf4657!?<" into Confirm Password
    When I click "Register" button
    Then error message "This field is required" should be displayed.
    Then error message "Entered passwords should match" should be display too.
    And I wait for 5 sec

  @predefined3
  Scenario: Minimum (5) characters
    Given I open "Registration" Page.
    When I type "dhjfdshj374?&*%^" into First Name
    And I type "dshgfsgy45437?($^*" into Last Name
    When I type "prometeyb@cashbackr.com" into Email
    And I type "123" into Group Code
    When I type "DD33" into Password
    And I type "DD33" into Confirm Password
    When I click "Register" button
    Then error message "Should be at least 5 characters" should be display
    And error message "Should be at least 5 characters" should be display
    #Question: the two elements displayed message same but xpath=1 and xpath=2, how to identify this?
    And I wait for 10 sec

  @predefined4
  Scenario: Maximum (32) + 1 characters
    Given I open "Registration" Page.
    When I type "dhjfdshj374?&*%^" into First Name
    And I type "dshgfsgy45437?($^*" into Last Name
    When I type "prometeyb@cashbackr.com" into Email
    And I type "123" into Group Code
    When I type "dsgrgrgeary5u5ur4durru6uhgfdhftjj" into Password
    And I type "dsgrgrgeary5u5ur4durru6uhgfdhftjj" into Confirm Password
    When I click "Register" button
    #Then error message "Too long. Should be at least 5 to 32 characters" should be display. sj
    #And error message "Too long. Should be at least 5 to 32 characters" should be display.
    And I wait for 10 sec
    #bug report:JAN23-450


  @predefined5
  Scenario: White spaces are not allowed
    Given I open "Registration" Page.
    When I type "dhjfdshj374?&*%^" into First Name
    And I type "dshgfsgy45437?($^*" into Last Name
    When I type "prometeyb@cashbackr.com" into Email
    And I type "123" into Group Code
    When I type "12 45 " into Password
    And I type "12 45 " into Confirm Password
    When I click "Register" button
    Then error message "Whitespaces are not allowed" should be display. sj
    And error message "Whitespaces are not allowed" should be display. sj
    And I wait for 10 sec


  @predefined6
  Scenario: Password must match Confirm Password
    Given I open "Registration" Page.
    When I type "dhjfdshj374?&*%^" into First Name
    And I type "dshgfsgy45437?($^*" into Last Name
    When I type "prometeyb@cashbackr.com" into Email
    And I type "123" into Group Code
    When I type "DDD33" into Password
    And I type "GDD33" into Confirm Password
    When I click "Register" button
    Then error message "Entered passwords should match" should be display. sj


  @predefined7
  Scenario Outline: Password/Confirm Password should be masked
    Given I open <url> Page.
    When I type <first_name> into First Name
    And I type <last_name> into Last Name
    When I type <email> into Email
    And I type <Code> into Group Code
    When I type <password> into Password
    And I type <confirm_pw> into Confirm Password
    Then I verified the password is masked
    Examples:
      | url            | first_name         | last_name            | email                     | Code  | password     | confirm_pw   |
      | "Registration" | "dhjfdshj374?&*%^" | "dshgfsgy45437?($^*" | "prometeyb@cashbackr.com" | "123" | "dgf4657!?<" | "dgf4657!?<" |

