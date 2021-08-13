@registrationEmail
Feature: Registration Email field

  Background:
    Given I open "registration" page
    When I type "Sofia" in the first name field
    When I type "Naidina" in the last name field
    When I type "FLEX" in the group code field
    When I type "12345" into the password field
    When I type "12345" into the confirm password field

  @registrationEmail1
  Scenario: JUL-131 User can be registered with Email containing alphabetic, numeric and special characters
    When I type "test.`-_!#$%^&*+?/|'@gmail.com" into the email field
    When click on the "Register Me" button
    And I wait for 2 sec
    Then I verify that a "You have been Registered." message is displayed
    And I wait for 2 sec

  @registrationEmail2
  Scenario: JUL-193 User can be registered with Email containing alphabetic, numeric and special character ","
    When I type "test,@gmail.com" into the email field
    When click on the "Register Me" button
    And I wait for 2 sec
    Then I verify that a "You have been Registered." message is displayed
    And I wait for 2 sec

     #fails - bug JUL-263

  @registrationEmail3
  Scenario: JUL-194 User can be registered with Email containing alphabetic, numeric and special character "}"
    When I type "test}@gmail.com" into the email field
    When click on the "Register Me" button
    And I wait for 2 sec
    Then I verify that a "You have been Registered." message is displayed
    And I wait for 2 sec

  @registrationEmail4
  Scenario: JUL-137 Verify that Email field is required
    When click on the "Register Me" button
    Then I verify that a "This field is required" error message is displayed


