@quiz @regression
Feature: Testing 'Settings - Change Your Password' feature

  Background:
    Given I go to "login" page
    When I type "mordashov_artem@hotmail.com" into email field
    And I type "QA123" into password field
    When I click "Sign In" button
    And I wait for 1 sec

  @passwordCorrect
  Scenario: Check with correct password

    When I click on "Settings" link
    Then I click "Change Your Password" button
    And I wait for 1 sec
    Then I type "QA123" into Password area in popup window
    And I type "QA123" into New Password area in popup window
    Then I type "QA123" into Confirm New Password area in popup window
    And I wait for 1 sec
    Then I click on "Change" button
    And I wait for 1 sec

   @passwordWrong
   Scenario: Check with incorrect password

     When I click on "Settings" link
     Then I click "Change Your Password" button
     And I wait for 1 sec
     Then I type "QA125" into Password area in popup window
     And I type "QA123" into New Password area in popup window
     Then I type "QA123" into Confirm New Password area in popup window
     And I wait for 1 sec
     Then I click on "Change" button
     And I wait for 2 sec
     Then I check that the error message "Authentication failed. User not found or password" is present

     @passwordCorrect
     Scenario: Check with correct password but new password is left blank

       When I click on "Settings" link
       Then I click "Change Your Password" button
       And I wait for 1 sec
       Then I type "QA123" into Password area in popup window
       And I type "" into New Password area in popup window
       Then I type "" into Confirm New Password area in popup window
       Then the message "This field is required" is present

  @passwordCorrect
  Scenario: Check with correct password but new password is white space

    When I click on "Settings" link
    Then I click "Change Your Password" button
    And I wait for 1 sec
    Then I type "QA123" into Password area in popup window
    And I type " " into New Password area in popup window
    Then I type " " into Confirm New Password area in popup window
    Then the message "Whitespaces are not allowed" is present

  @passwordCorrect
  Scenario Outline: Check with correct password but new password is less than 5 characters long

    When I click on "Settings" link
    Then I click "Change Your Password" button
    And I wait for <sec> sec
    Then I type <password> into Password area in popup window
    And I type <newPassword> into New Password area in popup window
    Then I type <confirmNewPassword> into Confirm New Password area in popup window
    Then the message <errorMessage> is present
    Examples:
     | sec | password | newPassword | confirmNewPassword | errorMessage                      |
     | 1   | "QA123"  | "1"         | "1"                | "Should be at least 5 characters" |
     | 1   | "QA123"  | "12"        | "12"               | "Should be at least 5 characters" |
     | 1   | "QA123"  | "123"       | "123"              | "Should be at least 5 characters" |
     | 1   | "QA123"  | "1234"      | "1234"             | "Should be at least 5 characters" |

  @passwordCorrect
  Scenario Outline: Check with correct password but new password is 32+1 characters long
    #it shouldn't really accept 32+1 characters, the bug report is in jira

    When I click on "Settings" link
    Then I click "Change Your Password" button
    And I wait for <sec> sec
    Then I type <password> into Password area in popup window
    And I type <newPassword> into New Password area in popup window
    Then I type <confirmNewPassword> into Confirm New Password area in popup window
    Then the message <errorMessage> is present
    Examples:
      | sec | password | newPassword                         | confirmNewPassword                   | errorMessage   |
      | 1   | "QA123"  | "123456789"                         | "123456789"                          | ""             |
      | 1   | "QA123"  | "1234567890"                        | "1234567890"                         | ""             |
      | 1   | "QA123"  | "12345678901234567890"              | "12345678901234567890"               | ""             |
      | 1   | "QA123"  | "12345678901234567890123456789012"  | "12345678901234567890123456789012"   | ""             |
      | 1   | "QA123"  | "Im_33_character_long_&_still_work" | "Im_33_character_long_&_still_work"  | ""             |



  @passwordCorrect
  Scenario: Check that password is hidden with bullets

    When I click on "Settings" link
    Then I click "Change Your Password" button
    And I wait for 1 sec
    Then I type "QA123" into Password area in popup window
    And I type "QA123" into New Password area in popup window
    Then I type "QA123" into Confirm New Password area in popup window
    Then the password in password field is hidden

