@predefined
Feature: Test set automation
  @predefined1
  Scenario: Change your password test set2
    Given I navigate to "login" page
    And I wait for 1 sec
    When I enter "jon.dijon@mustard.com" into email field
    And I wait for 1 sec
    And I enter "123456780" into password field
    When I press "Sign In" button
    And I wait for 1 sec
    When I press on "Settings" menu
    And I wait for 1 sec
    When I press on "Change Your Password" button
    And I wait for 1 sec
    And I enter "123456780" as old password
    And I wait for 1 sec
    And I enter "123456781" as new password
    And I wait for 1 sec
    And I confirm "123456781" as new password
    And I hit "Change" button
    And I wait for 1 sec

    @predefined2
    Scenario: New password must match Confirm New Password
      Given I navigate to "login" page
      And I wait for 1 sec
      When I enter "teacher1@gmail.com" into email field
      And I wait for 1 sec
      And I enter "12345Abc" into password field
      When I press "Sign In" button
      And I wait for 1 sec
      When I press on "Settings" menu
      And I wait for 1 sec
      And I enter "12345Abc" as old password
      And I wait for 1 sec
      And I enter "12345" as new password
      And I wait for 1 sec
      And I confirm "12345" as new password
      And I wait for 1 sec

@predefined3
Scenario: Password field required
  Given I navigate to "login" page
  And I wait for 1 sec
  When I enter "teacher1@gmail.com" into email field
  And I wait for 1 sec
  And I enter "12345Abc" into password field
  When I press "Sign In" button
  And I wait for 1 sec
  When I press on "Settings" menu
  And I wait for 1 sec
  And I enter "asd124!" as new password
  And I wait for 1 sec
  And I confirm "asd124!" as new password
  And I hit "Change" button
  Then message "This field is required" can be observed on the screen

  @predefined4
  Scenario: Max+1 characters
    Given I navigate to "login" page
    And I wait for 1 sec
    When I enter "teacher1@gmail.com" into email field
    And I wait for 1 sec
    And I enter "12345Abc" into password field
    When I press "Sign In" button
    And I wait for 1 sec
    When I press on "Settings" menu
    And I wait for 1 sec
    And I enter "12345Abc" as old password
    And I wait for 1 sec
    And I enter "PasswordPasswordPassword!@#123456" as new password
    And I wait for 1 sec
    And I confirm "PasswordPasswordPassword!@#123456" as new password
    And I wait for 1 sec
    Then "Change" button is not active
    And I wait for 1 sec

    #SUCESS!!!

