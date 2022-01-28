@registration_password
  Feature: Registration Password and Confirm Password

    Background:
      Given I navigate to registration page
      When I type "Abc" into first name field
      And I type "Student" into last name field
      And I type "denisxdenis@filerr.site" into email field
      And I type "123" into group code field

    @registration_password1
    Scenario: Password and Confirm Password Field Verification
      And I click on register me button
      Then "This field is required" error message should be displayed
      And I type "Student 123" into password field
      Then "Whitespaces are not allowed" error message should be displayed
      When I clear password field
      And I type "12" into password field
      And I click on register me button
      Then "Should be at least 5 characters" error message should be displayed
      And I wait for 2 sec
      When I clear password field
      And I type "Ab1#%" into password field
      And I wait for 2 sec
      When I type "Ab1@*2" into confirm password field
      Then "Entered passwords should match" error message should be displayed
      And I wait for 2 sec
      When I clear confirm password field
      And I type "Ab1#%" into confirm password field
      And I click on register me button
      And I wait for 2 sec
      Then registration confirmation page should be displayed

    @registration_password2
    Scenario Outline: Alphanumeric & Special characters in Password field - Outline
      When I type <textPass> into the password field
      And I type <textConfPass> into the confirm password field
      And I click on register me button
      And I wait for 3 sec
      Then registration confirmation page should be displayed
      Examples:
        | textPass   | textConfPass |
        | "ABCabc"   | "ABCabc"     |
        | "Ab123"    | "Ab123"      |
        | "Ab123#"   | "Ab123#"     |
        | "aBc%123*" | "aBc%123*"   |

    @registration_password3
    Scenario Outline: Password and Confirm Password Input Fields Characters Limits - Outline
      When I type <password> into password field
      And I type <confirmPass> into confirm password field
      And I click on register me button
      And I wait for 3 sec
      Then registration confirmation page should be displayed
      Examples:
        | password                             | confirmPass                       |
        | "12345"                              | "12345"                           |
        | "123456"                             | "123456"                          |
        | "12345678912345678912345678901234"   | "12345678912345678912345678901234"|
        | "1234567891234567891234567890123"    | "1234567891234567891234567890123" |

    @registration_password4
    Scenario Outline: Password and Confirm Password Error Messages
      When I type <password> into password field
      And I type <confirmPass> into confirm password field
      And I click on register me button
      Then <message> error message should be displayed
      Examples:
        | password                           | confirmPass                        | message                               |
        | ""                                 | ""                                 | "This field is required"              |
        | "12"                               | "12"                               | "Should be at least 5 characters"     |
        | " "                                | " "                                | "Whitespaces are not allowed"         |
      #  | "123456789123456789123456789012345"| "123456789123456789123456789012345"| "Should be no more than 32 characters"|

      #Known issue: reported bug DEC-437
      #Then "Should be no more than 32 characters" error message should be displayed.










