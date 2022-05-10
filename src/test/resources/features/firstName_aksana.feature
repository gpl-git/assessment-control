@firstname
Feature: First Name Registration

  Background:
    Given I go to "registration" page
    And I type "T" into last name field
    And I type "hornylou@gasss.us" into email field
    And I type "1234" into group code field
    And I type "12345" into password field
    And I type "12345" into confirm password field


  @smoke
  Scenario: Registration First Name
    When I type "Aksana" into first name field
    Then I click button "Register Me"
    And I wait for 2 sec
    Then confirmation message "You have been Registered" should be displayed


  @firstname1
  Scenario Outline: First Name accepts Alphanumeric & Special characters
    When I type <firstname> into first name field
    Then I click button "Register Me"
    And I wait for 2 sec
    Then confirmation message "You have been Registered" should be displayed
    Examples:
      | firstname |
      | "ABC"     |
      | "12345"   |
      | "@#$%^"   |


  @firstname2
  Scenario: First Name Required Field
    When I click button "Register Me"
    And I wait for 2 sec
    Then error message "This field is required" should be displayed


  @firstname3
  Scenario: First Name White Space is Not Allowed
    When I type "A k" into first name field
    Then I click button "Register Me"
    And I wait for 2 sec
    Then error message "Whitespaces are not allowed" should be displayed


  @firstname4
  Scenario: First name accepts max 254 characters
    When I enter 254 characters into first name field
    Then I click button "Register Me"
    And I wait for 2 sec
    Then confirmation message "You have been Registered" should be displayed


  @firstname5
  Scenario: First Name accepts min 1 character
    When I type "A" into first name field
    Then I click button "Register Me"
    And I wait for 2 sec
    Then confirmation message "You have been Registered" should be displayed


  @firstname6
  Scenario: First Name doesn't accept 254+1 characters
    When I enter 255 characters into first name field
    Then I click button "Register Me"
    And I wait for 2 sec
    Then warning message "Data too long for column 'name' at row 1" should be displayed





