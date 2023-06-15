@Anil
Feature: Student Settings - Change Password

  Background:
    Given I go to the "Login" page - Anil
    Then I type "welox77154@onlcool.com" into the email field - Anil
    And I type "12345" into the password field - Anil
    And I click on the "Sign In" button - Anil
    And I will wait 1 sec - Anil
    Then I will see my name "Anil" on the header - Anil
    And I go to the "Settings" page - Anil
    And I click on the "Change Password" button - Anil
    And I will wait 1 sec - Anil

  @Empty_1
  Scenario: Empty password field
    Given I leave the "password" field empty - Anil
    And I type "12345" into the new password field - Anil
    And I type "12345" into the confirm password field - Anil
    Then I should see "This field is required" message under the "password" field - Anil

  @Empty_2
  Scenario: Empty new password field
    Given I leave the "new password" field empty - Anil
    And I type "12345" into the password field - Anil
    And I type "12345" into the confirm password field - Anil
    Then I should see "This field is required" message under the "new password" field - Anil

  @Empty_3
  Scenario: Empty confirm password field
    Given I leave the "confirm password" field empty - Anil
    And I type "12345" into the password field - Anil
    And I type "12345" into the new password field - Anil
    Then I should see "This field is required" message under the "confirm password" field - Anil

  @4Characters_1
  Scenario: Password field has less than 5 characters
    Given I enter a short password into the "password" field - Anil
    And I type "12345" into the new password field - Anil
    And I type "12345" into the confirm password field - Anil
    Then I should see "Should be at least 5 characters" message under the "password" field - Anil

  @4Characters_2
  Scenario: New Password field has less than 5 characters
    Given I enter a short password into the "new password" field - Anil
    And I type "12345" into the password field - Anil
    And I type "12345" into the confirm password field - Anil
    Then I should see "Should be at least 5 characters" message under the "new password" field - Anil

  @4Characters_3
  Scenario: Confirm Password field has less than 5 characters
    Given I enter a short password into the "confirm password" field - Anil
    And I type "12345" into the password field - Anil
    And I type "12345" into the new password field - Anil
    Then I should see "Should be at least 5 characters" message under the "confirm password" field - Anil

  @33Characters_1
  Scenario: Password field has more than 32 characters
    Given I enter a long password into the "password" field - Anil
    And I type "12345" into the new password field - Anil
    And I type "12345" into the confirm password field - Anil
    #Known bug MAY23-316 Password field accepts more than 23 characters
    Then I should see "Can be max 32 characters" message under the "password" field - Anil

  @33Characters_2
  Scenario: New Password field has more than 32 characters
    Given I enter a long password into the "new password" field - Anil
    And I type "12345" into the password field - Anil
    And I type "12345" into the confirm password field - Anil
    #Known bug MAY23-316 Password field accepts more than 23 characters
    Then I should see "Can be max 32 characters" message under the "password" field - Anil

  @33Characters_3
  Scenario: Password field has more than 32 characters
    Given I enter a long password into the "confirm password" field - Anil
    And I type "12345" into the password field - Anil
    And I type "12345" into the new password field - Anil
    #Known bug MAY23-316 Password field accepts more than 23 characters
    Then I should see "Can be max 32 characters" message under the "password" field - Anil

  @WhiteSpace_1
  Scenario: White space error message for password field
    Given I enter a white space into the "password" field - Anil
    And I type "12345" into the new password field - Anil
    And I type "12345" into the confirm password field - Anil
    Then I should see "Whitespaces are not allowed" message under the "password" field - Anil

  @WhiteSpace_2
  Scenario: White space error message for new password field
    Given I enter a white space into the "new password" field - Anil
    And I type "12345" into the password field - Anil
    And I type "12345" into the confirm password field - Anil
    Then I should see "Whitespaces are not allowed" message under the "new password" field - Anil

  @WhiteSpace_3
  Scenario: White space error message for confirm password field
    Given I enter a white space into the "confirm password" field - Anil
    And I type "12345" into the password field - Anil
    And I type "12345" into the new password field - Anil
    Then I should see "Whitespaces are not allowed" message under the "confirm password" field - Anil

  @PasswordMatch
  Scenario: White space error message for password field
    Given I type "12345" into the password field - Anil
    And I type "12345" into the confirm password field - Anil
    And I type "ABCDE" into the new password field - Anil
    Then I should see "Entered passwords should match" message under the "confirm password" field - Anil

  @HappyPath
  Scenario: Password will be changed successfully
    Given I type "12345" into the password field - Anil
    And I type "12345" into the new password field - Anil
    And I type "12345" into the confirm password field - Anil
    And I click on the "Change" button - Anil
    #"Password is updated successfully" message doesn't appear
