@registration
Feature: Registration Scenarios

  @smoke @registration
  Scenario: Registration Happy Tree
    Given I open "registration" page
    When I type "Test" as First Name
    And I type "QA" as Last Name
    And I type "test49@example.com" as Email
    And I type "ABC" as Group Code
    And I type "12345" as Password
    Then  confirmation message "You have been Registered." should be displayed
    When I click "Register Me" button
    And I wait for 2 sec
    Then  confirmation message "You have been Registered." should be displayed

