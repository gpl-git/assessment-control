@registration_email
  Feature: Verify Registration Email field behavior

    Background:
      Given I go to "registration" page
      When I type "Snehal" in the First Name field
      When I type "Shaha" in the Last Name field
      When I type "abc" in the Group Code field
      When I type "12345" in the Password field
      When I type "12345" in the Confirm Password field

    @registration_email1
    Scenario: Email Field accepts valid Email
      When I type "abc@abc.com" in the Email field
      And I click on the "Register Me" button
      And I wait for 3 sec
      Then I verify that the user has been registered
      And I wait for 2 sec

    @registration_email2
    Scenario: Email allows alphanumeric and special characters
      When I type "abc123_!*&^%`~/+-=@xyz.org" in the Email field
      And I click on the "Register Me" button
      And I wait for 2 sec
      Then I verify that the user has been registered
      And I wait for 2 sec

    @registration_email3
    Scenario: Email field should not be blank
      When I clear the field with xpath "//input[@formcontrolname='email']"
      When I click on the "Register Me" button
      And I wait for 2 sec
      Then I verify that "This field is required" is displayed on the mat-form
      And I wait for 2 sec

    @registration_email4
    Scenario: Email field should not accept no characters in the prefix(before @ sign)
      When I type an email with 0 characters in the prefix
      And I click on the "Register Me" button
      And I wait for 2 sec
      Then I verify that "Should be a valid email address" is displayed on the mat-form

    @registration_email5
    Scenario: Email field accepts max 64 characters in the prefix
      When I type an email with 64 characters in the prefix
      And I click on the "Register Me" button
      And I wait for 2 sec
      Then I verify that the user has been registered

    @registration_email6
    Scenario: Email field should not accept more than 64 characters in the prefix
      When I type an email with 65 characters in the prefix
      And I click on the "Register Me" button
      And I wait for 2 sec
      Then I verify that "Should be a valid email address" is displayed on the mat-form

    @registration_email7
      # This Scenario shows a bug in the system
    Scenario: Email field should not accept only characters in the domain (no . symbol)
      When I type "test@test" in the Email field
      And I click on the "Register Me" button
      And I wait for 2 sec
      Then I verify that "Should be a valid email address" is displayed on the mat-form

    @registration_email8
    Scenario: Email field should accept max 63 characters in the domain
      When I type an email with 63 characters in the domain
      And I click on the "Register Me" button
      And I wait for 2 sec
      Then I verify that the user has been registered

    @registration_email9
    Scenario: Email field should not except more than 63 characters in the domain
      When I type an email with 64 characters in the domain
      And I click on the "Register Me" button
      And I wait for 2 sec
      Then I verify that "Should be a valid email address" is displayed on the mat-form

    @registartion_email10
    Scenario: Email without @ sign should not be allowed
      When I type "test$1.com" in the Email field
      And I click on the "Register Me" button
      And I wait for 2 sec
      Then I verify that "Should be a valid email address" is displayed on the mat-form

    @registration_email11
    Scenario: Email with no characters in the domain should not be allowed
      When I type an email with 0 characters in the domain
      And I click on the "Register Me" button
      And I wait for 2 sec
      Then I verify that "Should be a valid email address" is displayed on the mat-form

    @registration_email12
    Scenario: Email with whitespaces should not be allowed
      When I type "abc@abc. com" in the Email field
      And I click on the "Register Me" button
      And I wait for 2 sec
      Then I verify that "Should be a valid email address" is displayed on the mat-form
















