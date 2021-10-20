@predefined
  Feature: Password
    Background:
      Given I navigate to "registration" page
      Then I see "Registration" form

    @predefined1
    Scenario: Registration - Password/Confirm Password
      Then I enter passworrd "1"
      And I wait for 3 sec
      Then error message "Should be at least 5 characters"
      And I wait for 1 sec

    @predefined2
    Scenario Outline: Registration - Password error messages - Outline
      Then I enter passworrd <pas>
      And I wait for 1 sec
      Then error message <error>
      And I wait for 2 sec
      Examples:
        | pas | error                             |
        | "" | "This field is required" |
        | " " | "Whitespaces are not allowed" |
        | "1234" | "Should be at least 5 characters" |
        | "abcd" | "Should be at least 5 characters" |
        | "erfgdgbfvgbcgzbgbxvgbhzdfgdfq2GFF" | "Should be no more then 32 characters" |

    @predefined3
    Scenario: v
      Then I enter Confirm password "1"
      And I wait for 1 sec
      Then error message "Should be at least 5 characters"
      And I wait for 1 sec
    @predefined4
    Scenario Outline: Registration - Confirm Password - Outline
      Then I enter Confirm password <confpass>
      And I wait for 1 sec
      Then error message <error>
      And I wait for 2 sec
      Examples:
        | confpass  | error                             |
        | "" | "This field is required" |
        | " " | "Whitespaces are not allowed" |
        | "1234" | "Should be at least 5 characters" |
        | "abcd" | "Should be at least 5 characters" |
        | "erfgdgbfvgbcgzbgbxvgbhzdfgdfq2GFF" | "Should be no more then 32 characters" |



    @predefined5
    Scenario: Registration - Password must match Confirm Password
      Then I enter passworrd "Za!12"
      Then I enter Confirm password "Za!21"
      And I wait for 2 sec
      Then the error message "Entered passwords should match" is displayed
      And I wait for 2 sec

    @predefined6
    Scenario: Registration - Password is masked
      Then password input field should have attribute "type" as "password"

    @predefined7
    Scenario: Registration - Password
      Then I enter first name "Il"
      Then I enter last name "Ne"
      Then I enter email "m@m.e"
      Then I enter group "123"
      Then I enter passworrd "Za!12"
      Then I enter Confirm password "Za!12"
      Then I click Register Me
      And I wait for 2 sec
      Then page with message "You have been Registered." opened
      And I wait for 2 sec

    @predefined8
    Scenario Outline: Registration - Password - Outline
      Then I enter first name "Il"
      Then I enter last name "Ne"
      Then I enter email "m@m.e"
      Then I enter group "123"
      Then I enter passworrd <pas>
      Then I enter Confirm password <confpass>
      Then I click Register Me
      And I wait for 2 sec
      Then page with message <registered> opened
      And I wait for 2 sec
      Examples:
        | pas     | confpass  | registered                            |
        | "Za!12" | "Za!12"   | "Your registration is completed now." |
        | "!@#$%^&*(" | "!@#$%^&*("| "Your registration is completed now." |
        | "ZXCVBNM" | "ZXCVBNM"   | "Your registration is completed now." |
        | "zxcvbnm" | "zxcvbnm"   | "Your registration is completed now." |
        | "123456!@#$%^&*()ZAQWSXfvgbcgzbgb" | "123456!@#$%^&*()ZAQWSXfvgbcgzbgb"   | "Your registration is completed now." |







