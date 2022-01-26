@automatedTestCase2.7

Feature: AutomatedTestCase2.7 Scenarios
  Background:
    Given I go to "login"
    Then I type "zimmko@sepican.club" into email field
    Then I type "12345" into password field
    Then  I click "Sign In" button
    And I wait for 1 sec


