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