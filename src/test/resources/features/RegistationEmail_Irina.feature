@registrationEmail

Feature: Registration Email Field

  Background:
    Given I open "registration" website
    When I type "Irina" into firstname field
    And I type "Zhevner" into lastname field
    And I type "888" into group code field
    When  I type "12345" into password field
    And I type "12345" into confirmPassword field

  @registrationEmail1
  Scenario:Email field does not accept special chars other than "@", "_" and "." (Positive)
    When I type "a.b_c@efg.com" into email field
    And I click "Register Me" button
    Then "You have been Registered." confirmation message should be displayed
    And I wait for 2 sec

  @registrationEmail2
  Scenario Outline: Email field error message (Negative scenarios)
    When I type <email> into email field
    And I click "Register Me" button
    And I wait for 2 sec
    Then <expectedError> error message should be displayed

    Examples:
      | email                  | expectedError
      | "!bc@efg.com"          | "Should be a valid email address"
#      Known issue
      | ""                     | "This field is required"
      | "student11 @gmail.com" | "Should be a valid email address"
      | "student11@ gmail.com" | "Should be a valid email address"
      | "student11@gmail. com" | "Should be a valid email address"
      | "+bc@efg.com"          | "Should be a valid email address"
#      Known issue
      | "$bc@efg.com"          | "Should be a valid email address"
#      Known issue
      | "$bc@efg"              | "Should be a valid email address"
#         Known issues Jan23-460



  @registrationEmail3
  Scenario: Email Field allows Max 128 characters
    When I type "irinairinairinairinairinairinairinairinairinairinairinairinairinairinairinairinairinairinairinairinairinairinairinairi@gmail.com" into email field
    And I click "Register Me" button
    And I wait for 2 sec
    Then "You have been Registered." confirmation message should be displayed

  @registrationEmail4
  Scenario: Email Field allows Max 128 characters (129,negative)
    When I type "irinairinairinairinairinairinairinairinairinairinairinairinairinairinairinairinairinairinairinairinairinairinairinairin@gmail.com" into email field
    And I click "Register Me" button
    Then  "Should be a valid email address" error message should be displayed
    And I wait for 2 sec



