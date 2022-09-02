@quiz @smoke
Feature: Quiz Scenarios
  @quiz1
  Scenario: Verify Registration First name
    Given I open "registration" page
    When I type "chen" into first name field
    Then I click the "register me" button
    And I wait for 2 sec
    When I clear first name file
    Then error message "This field is required" is displayed

