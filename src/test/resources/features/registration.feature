@smoke
Feature: Registration Scenarios
  @smoke
  Scenario: Registration Happy Path
    Given I open "registration" page
    When I type "First" into firstName field
    And I type "Last" into lastName field
    And I type "test@test.com" into email field
    When I type "ABC" into group field
    And I type "12345" into password field
    When I type "12345" into confirmPassword field
    When I click "Register Me" button
    Then confirmation message "You have been Registered." is displayed







  