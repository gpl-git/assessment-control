@password @confirmPassword @regression

Feature: Password and Confirm password
  Background:
    Given I navigate to "registration" page
    When I type "Ana" into First Name field
    Then I type "Mary" into Last Name field
    Then I type "anamary@gmail.com" into Email field
    Then I type "ABC" into Group Code field

  @password1
  Scenario: Password field is required
    When I click on "Register Me" button
    Then I validate password field displays error message "This field is required"
    And I wait for 2 sec

  @confirmPassword2
  Scenario: Confirm Password field is required
    When I type "12345" into Password field
    Then I click on "Register Me" button
    Then I validate confirm password field displays error message "This field is required"
    And I wait for 2 sec

  @password3
  Scenario: Validate if error message will be displayed in password field when min characters are entered
    When I type "12" into Password field
    Then I click on "Register Me" button
    Then I validate password field displays error message "Too short. Should be at least 5 characters"
    And I wait for 2 sec

  @password4
  Scenario: Validate if white space is not allowed in password field
    When I type "12 " into Password field
    Then I click on "Register Me" button
    Then I validate password field displays error message "Whitespaces are not allowed"
    And I wait for 2 sec

  @confirmPassword5
  Scenario: Validate if error message will be displayed in confirm password field when min characters are entered
    When I type "12" into Confirm Password field
    Then I click on "Register Me" button
    Then I validate confirm password field displays error message "Too short. Should be at least 5 characters"
    And I wait for 2 sec

  @confirmPassword6
  Scenario: Validate if white space is not allowed in confirm password field
    When I type "12 " into Confirm Password field
    Then I click on "Register Me" button
    Then I validate confirm password field displays error message "Whitespaces are not allowed"
    And I wait for 2 sec

  @confirmPassword7
  Scenario: Validate if error message will be displayed when password and confirm password doesn't match
    When I type "12345" into Password field
    Then I type "12345678" into Confirm Password field
    Then I click on "Register Me" button
    Then I validate confirm password field displays error message "Entered passwords should match"
    And I wait for 2 sec

  @password8 @confirmPassword8
  Scenario: Validate the behavior of the password and confirm password fields when they are matched
    When I type "12345" into Password field
    Then I type "12345" into Confirm Password field
    Then I click on "Register Me" button
    Then I switch to new window
    Then I validate that message "You have been Registered." is displayed
    And I wait for 3 sec






















