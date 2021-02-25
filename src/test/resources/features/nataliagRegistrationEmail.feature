@nataliagRegistrationEmail

  Feature: Registration Scenarios

    Background:
      Given I navigate to "Registration page"

      @nataliagRegistrationEmail
      Scenario: Behavior of the Email field with a valid email
        When I enter "1a@d.cc" into email field
        And I push "Register me" button
        Then I verify that error message for Email field is not displayed

      @nataliagRegistrationEmail1
      Scenario Outline: Behavior of the Email field with a not valid email
        When I enter <email> into email field
        And I push "Register me" button
        Then I verify that error message <message> for Email field is displayed

        Examples:
        |email|message|
        |   ""         | "This field is required"          |
        |   "a"        | "Should be a valid email address" |
        |   "a@"       | "Should be a valid email address" |
        |   "a@b"      | "Should be a valid email address" |
        |   "a@b."     | "Should be a valid email address" |
        |   "a@b.c"    | "Should be a valid email address" |
        |   "a@1b.c"   | "Should be a valid email address" |
        |   "1a@1b.c"  | "Should be a valid email address" |
        |   "1a@1b.cc" | "Should be a valid email address" |



