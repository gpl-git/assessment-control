@smoke

Feature: Registration Scenarios
  Background: Navigate to Registration page
    Given I open "registration" page.

  @smoke
  Scenario: Registration Happy Path
    When I type "First" into firstName field.
    And I type "Last" into lastName field.
    And I type "test@test.com" into email field.
    And I type "ABC" into group field.
    And I type "12345" into password field.
    And I type "12345" into confirmPassword field.
    When I click "Register Me" button.
    Then confirmation message "You have been Registered." is displayed.

