@forgotPassword
Feature: Forgot Password Scenarios

  Scenario: Valid email / ACT-314
    Given I navigate to "https://generator.email" page
    Then I copy randomly generated email string
    And I navigate to "http://ask-qa.portnov.com/#/login" page
    And I wait for 1 seconds
    And I click button with text "Register Now"
    And I wait for 1 seconds
    And I enter "TestFirstName" into the field with xpath "//input[@placeholder='First Name']"
    And I enter "TestLastName" into the field with xpath "//input[@placeholder='Last Name']"
    And I wait for 1 seconds
    And I enter randomly generated email into the field with xpath "//input[@placeholder='Email']"
    And I wait for 1 seconds
    And I enter "BOX" into the field with xpath "//input[@placeholder='Group Code']"
    And I enter "abcdefg" into the field with xpath "//input[@placeholder='Password']"
    And I enter "abcdefg" into the field with xpath "//input[@placeholder='Confirm Password']"
    And I wait for 3 seconds
    And I click button with text "Register Me"
    And I navigate to "https://generator.email" page
    And I refresh email generator page
    And I wait for 1 seconds
    And I click a link with text "Confirm email address"
    And I navigate to "http://ask-qa.portnov.com/#/login" page
    And I click a link with text "I forgot my password"
    And I enter randomly generated email into the field with xpath "//input[@formcontrolname='email']"
    And I wait for 1 seconds
    And I click button with text "Request Password Reset"
    And I navigate to "https://generator.email" page
    And I click button with text "Refresh"
    And I wait for 2 seconds
    And I click to open Reset your password email
    And I wait for 2 seconds
    And I click a link with text "Reset Password"
    And I enter "123456" into the field with xpath "//input[@placeholder='New Password']"
    And I enter "123456" into the field with xpath "//input[@placeholder='Confirm New Password']"
    And I click button with text "Reset"
    And I wait for 1 seconds
    Then element with text "Your Password was Changed" is present