@nataliagRegistrationEmail

  Feature: Registration Scenarios

    Background:
      Given I navigate to "Registration page"

      @nataliagRegistrationEmail1
      Scenario: Behavior of the Email field with a valid email
        When I fill all fields except the Email field
        And I enter valid email into Email field
        And I push "Register me" button
        Then I wait for 2 sec
        And I verify that message "You have been Registered." is displayed

      @nataliagRegistrationEmail2

        # The application does not meet the requirements for the length of the email field (this is a bug)
        # The actual total length of the email field is 128 characters (including @ and dot)
        # The last part of the domain (after dot) cannot be more than five characters long
        # All characters are accepted only in lower case

      Scenario: Email field having 64 alphanumeric characters to the left of the @, 63 alphabetic characters between @ and dot, and 63 alphabetic characters in the last part of the domain (lowercase only allow)
        When I fill all fields except the Email field
        And I enter the maximum number of characters allowed in the Email field
        Then I wait for 2 sec
        When I push "Register me" button
        Then I wait for 2 sec
        And I verify that message "You have been Registered." is displayed

      @nataliagRegistrationEmail3

         # I enter an email address with a total length of 128 characters (including @ and a period) whose last domain part is 5 characters long.
      Scenario: Email field having total length 128 characters (including @ and dot)
        When I fill all fields except the Email field
        And I enter an email address with a total length of 128 characters whose last domain part is 5 characters long.
        Then I wait for 2 sec
        When I push "Register me" button
        Then I wait for 2 sec
        And I verify that message "You have been Registered." is displayed

      @nataliagRegistrationEmail4
      Scenario Outline: Behavior of the Email field with a not valid email
        When I fill all fields except the Email field
        And I enter <email> into email field
        And I push "Register me" button
        Then I wait for 2 sec
        And I verify that error message <message> for Email field is displayed

        Examples:
        |email         |message                            |
        |   ""         | "This field is required"          |
        |   "a"        | "Should be a valid email address" |
        |   "a@"       | "Should be a valid email address" |
        |   "a@b"      | "Should be a valid email address" |
        |   "a@b."     | "Should be a valid email address" |
        |   "a@b.c"    | "Should be a valid email address" |
        |   "a@1b.c"   | "Should be a valid email address" |
        |   "a@b.1c"   | "Should be a valid email address" |
        |   "1a@1b.c"  | "Should be a valid email address" |
        |   "1a@1b.cc" | "Should be a valid email address" |
        |   "a#@b.cc"  | "Should be a valid email address" |
        |   "a@b>.cc"  | "Should be a valid email address" |
        |   "a@b.c&"   | "Should be a valid email address" |
        |   "a a@b.cc" | "Should be a valid email address" |
        |   "a@b b.cc" | "Should be a valid email address" |
        |   "a@b.c c"  | "Should be a valid email address" |
        | "a@b.cccccc" | "Should be a valid email address" |



