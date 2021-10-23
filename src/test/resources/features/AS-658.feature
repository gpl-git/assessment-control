@password
Feature: Change Password Functionality Check

  Background:
    Given I navigate to "login" page
    And I wait for 1 sec

  @password1
  Scenario: Change your password test set2 @password_happy_path
    When I enter "jon.dijon@mustard.com" into email field
    And I wait for 1 sec
    And I enter "123456781" into password field
    When I press "Sign In" button
    And I wait for 1 sec
    When I press on "Settings" menu
    And I wait for 1 sec
    When I press on "Change Your Password" button
    And I wait for 1 sec
    And I enter "123456781" as old password
    And I wait for 1 sec
    And I enter "123456781" as new password
    And I wait for 1 sec
    And I confirm "123456781" as new password
    And I hit "Change" button
    And I wait for 1 sec

  @password2
  Scenario: New password must match Confirm New Password @password_confirm
    When I enter "jon.dijon@mustard.com" into email field
    And I wait for 1 sec
    And I enter "123456781" into password field
    When I press "Sign In" button
    And I wait for 1 sec
    When I press on "Settings" menu
    And I wait for 1 sec
    When I press on "Change Your Password" button
    And I wait for 1 sec
    And I enter "123456781" as old password
    And I wait for 1 sec
    And I enter "12345" as new password
    And I wait for 1 sec
    And I confirm "12345" as new password
    And I wait for 1 sec
    Then "Change" button is active

  @password3
  Scenario: Password field required @password_field_required
    When I enter "jon.dijon@mustard.com" into email field
    And I wait for 1 sec
    And I enter "123456781" into password field
    When I press "Sign In" button
    And I wait for 1 sec
    When I press on "Settings" menu
    And I wait for 1 sec
    When I press on "Change Your Password" button
    And I enter "asd124!" as new password
    And I wait for 1 sec
    And I confirm "asd124!" as new password
    And I hit "Change" button
    Then message "This field is required" can be observed on the screen

  @password4
  Scenario: Max+1 characters @max+1
    When I enter "jon.dijon@mustard.com" into email field
    And I wait for 1 sec
    And I enter "123456781" into password field
    When I press "Sign In" button
    And I wait for 1 sec
    When I press on "Settings" menu
    And I wait for 1 sec
    When I press on "Change Your Password" button
    And I wait for 1 sec
    And I enter "123456781" as old password
    And I wait for 1 sec
    And I enter "PasswordPasswordPassword!@#123456" as new password
    And I wait for 1 sec
    And I confirm "PasswordPasswordPassword!@#123456" as new password
    And I wait for 1 sec
    Then "Change" button is not active
    And I wait for 1 sec
  # known bug --- https://jira.portnov.com/browse/AS-286



