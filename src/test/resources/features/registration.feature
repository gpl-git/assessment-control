@smoke
Feature: Registration Scenarios

  @smoke
  Scenario: Registration Happy Path
    Given I open "registration" page
    And I wait for 5 sec
    When I type "First" into firstName field
    And I type "Last" into lastName field
    And I type "test@test.com" into email field
    When I type "ABC" into group field
    And I type "12345" into password field
    When I type "12345" into confirmPassword field
    And I wait for 3 sec
    When I click "Register Me" button contains text
    When I wait for 10 sec
    Then confirmation message "You have been Registered." is displayed
    And I wait for 3 sec









  