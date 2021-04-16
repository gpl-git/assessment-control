@registration
Feature: Registration Group Code

  @registration1
  Scenario: Registration Group Code Alpha Numerics allowed
    Given I open "registration" page
    When  I type "Tester" into First Name field
    When I type "Junior" into Last Name field
    And I type new email into email field
    And I type "1!@%a" into group code field
    And I type "12345" into password field
    And I type "12345" into Confirm password field
    When I click "Register Me" button
    And I wait for 2 sec
    Then I see message "You have been Registered."

  @registrtion2
  Scenario: Registration Group Code can not be empty
    Given I open "registration" page
    When  I type "Tester" into First Name field
    When I type "Junior" into Last Name field
    And I type "test0002@gmail.com" into email field
    And I type "" into group code field
    And I type "12345" into password field
    And I type "12345" into Confirm password field
    When I click "Register Me" button
    And I wait for 2 sec
    Then I see error message "This field is required"

  @registration3
  Scenario: Registration Group Code min 1 char allowed
    Given I open "registration" page
    When  I type "Tester" into First Name field
    When I type "Junior" into Last Name field
    And I type new email into email field
    And I type "z" into group code field
    And I type "12345" into password field
    And I type "12345" into Confirm password field
    When I click "Register Me" button
    And I wait for 2 sec
    Then I see message "You have been Registered."

  @registration4
  Scenario: Registration Group Code max 6 char allowed
    Given I open "registration" page
    When  I type "Tester" into First Name field
    When I type "Junior" into Last Name field
    And I type new email into email field
    And I type "zzxxyy" into group code field
    And I type "12345" into password field
    And I type "12345" into Confirm password field
    When I click "Register Me" button
    And I wait for 2 sec
    Then I see message "You have been Registered."

  @registration5
  Scenario: Registration Group Code more than 6 char not allowed
    Given I open "registration" page
    When  I type "Tester" into First Name field
    When I type "Junior" into Last Name field
    And I type new email into email field
    And I type "zzxxyy77sgfdsfgfdsdfgfds" into group code field
    And I type "12345" into password field
    And I type "12345" into Confirm password field
    When I click "Register Me" button
    And I wait for 2 sec
    Then I see message "Too long. Should be no more than 6 characters"

  @registration6
  Scenario: Registration Group Code white spaces not allowed
    Given I open "registration" page
    When  I type "Tester" into First Name field
    When I type "Junior" into Last Name field
    And I type new email into email field
    And I type "z z" into group code field
    And I type "12 45" into password field
    And I type "12 45" into Confirm password field
    When I click "Register Me" button
    And I wait for 2 sec
    Then I see error message "Whitespaces are not allowed"