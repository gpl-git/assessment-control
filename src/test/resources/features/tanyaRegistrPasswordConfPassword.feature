@RegistrationPasswordConfPassword

  # !!!! There are three scenarios that fail in this feature in build 1.0.1. !!!!
  # Two scenarios for a max length of the Password and Confirm Password fields ("Password should be no more than 32 characters"). Bug report FEB23-261
  # One scenario for Confirm Password error message check (Entered passwords should match)

Feature: [Registration] Password/Confirm password

  Background:
    Given I go to "registration" page
    When I type "Tanya" into "First Name" field in the Registration form
    And  I type "Danny" into "Last Name" field in the Registration form
    And I type "Tanya@gmail.com" into "Email" field in the Registration form
    And I type "321" into "Group Code" field in the Registration form

  @passwordConfPassword
  Scenario Outline: Password and Confirm Password input check
    And I type <input> into <fieldName> field in the Registration form
    And I type <input1> into <fieldName1> field in the Registration form
    Then error message for the Register form should not be present
    And I wait for 3 sec
#    And I click <btnName> button
#    And I wait for <sec> sec
#    Then message @You have been Registered.@ should be the displayed
    Examples:
      | input                             | fieldName  | input1                           | fieldName1         | btnName       | sec |
      | "12345"                           | "Password" | "12345"                          | "Confirm Password" | "Register Me" | 2   |
      | "QWErtugidfhodkfj1234567890!@$%#&"| "Password" |"QWErtugidfhodkfj1234567890!@$%#&"| "Confirm Password" | "Register Me" | 2   |
      | "ASDFGHhdhhd"                     | "Password" | "ASDFGHhdhhd"                    | "Confirm Password" | "Register Me" | 1   |
      | "!@#$%^&*()_+{}:?><,./';[]\`~"    | "Password" | "!@#$%^&*()_+{}:?><,./';[]\`~"   | "Confirm Password" | "Register Me" | 1   |
      | "@Adfg234%^&"                     | "Password" | "@Adfg234%^&"                    | "Confirm Password" | "Register Me" | 1   |

  @PasswordError
  Scenario Outline: Password error message check
    And I type <input> into <fieldName> field in the Registration form
    And I click on the element with XPath "//mat-card[@class='mat-card']"
    Then error message <expErrorMessage> should be displayed
    And I wait for 3 sec
    Examples:
      | input                              | fieldName  |  expErrorMessage                  |
      | "1234"                             | "Password" |  "Should be at least 5 characters"|
      | " "                                | "Password" |  "Whitespaces are not allowed"    |
      | ""                                 | "Password" |  "This field is required"         |
      | "QWErtugidfhodkfj1234567890!@$%#&e"| "Password" |  "Password should be no more than 32 characters"|
  @ConfirmPasswordError
  Scenario Outline: Confirm Password error message check
    And I type <input> into <fieldName> field in the Registration form
    And I type <input1> into <fieldName1> field in the Registration form
    And I click on the element with XPath "//mat-card[@class='mat-card']"
    Then error message <expErrorMessage> should be displayed
    And I wait for 3 sec
    Examples:
      | input   | fieldName  | input1 | fieldName1         |  expErrorMessage                   |
      | "123456"| "Password" | "12345"| "Confirm Password" |  "Entered passwords should match"  |
      | "12345" | "Password" | ""     | "Confirm Password" |  "This field is required"          |
      | "12345" | "Password" | " "    | "Confirm Password" |  "Whitespaces are not allowed"     |
      | "1234"  | "Password" | "1234" | "Confirm Password" |  "Should be at least 5 characters" |
      |"QWErtugidfhodkfj1234567890!@$%#&e"|"Password"|"QWErtugidfhodkfj1234567890!@$%#&e"|"Confirm Password" |"Password should be no more than 32 characters" |

    #additional test for Confirm Password field. Bug report FEB23-394 and FEB23-119
  @ConfirmPasswordErrorAddition
  Scenario: Confirm Password error message check.Entered passwords should match
    And I type "12345" into "Password" field in the Registration form
    And I type "12345" into "Confirm Password" field in the Registration form
    And I type "67" into "Password" field in the Registration form
    And I click on the element with XPath "//mat-card[@class='mat-card']"
    Then error message "Entered passwords should match" should be displayed
    And I wait for 3 sec
