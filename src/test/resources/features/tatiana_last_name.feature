@quizReistration

Feature: Last Name Scenarios
  Background:
    Given I go to "registration" page T
    When I type "Tatiana" into "First Name" field T
    And I type "erc.tatiana+9@gmail.com" into "Email" field T
    And I type "123" into "Group Code" field T
    And I type "12345" into "Password" field T
    And I type "12345" into "Confirm Password" field T
    And I wait for 2 sec T

  @registrLastName1
  Scenario: Allowable characters: Alphanumeric & Special characters
    And I type "qwertyui1!" into "Last Name" field T
    When I click button "Register Me" T
    And I wait for 2 sec T
    Then message "You have been Registered." should be displayed T
    When I click button "Back to Login Page" T
    When I type "erc.tatiana+1@gmail.com" into email field T
    And I enter "Newlife1" as password T
    And I click button "Sign In" T
    And I wait for 1 sec T
    When I click on "Users Management" menu item T
    And I wait for 2 sec T
    When I delete "Tatiana qwertyui1!" user T
    And I wait for 2 sec T

  @registrLastName2
  Scenario: Last Name field is required, can’t be empty
    When I click button "Register Me" T
    Then message "This field is required" should be displayed T
    And I wait for 2 sec T

  @registrLastName3
  Scenario: Min 1 characters
    And I type "a" into "Last Name" field T
    When I click button "Register Me" T
    And I wait for 2 sec T
    Then message "You have been Registered." should be displayed T
    When I click button "Back to Login Page" T
    When I type "erc.tatiana+1@gmail.com" into email field T
    And I enter "Newlife1" as password T
    And I click button "Sign In" T
    And I wait for 1 sec T
    When I click on "Users Management" menu item T
    And I wait for 2 sec T
    When I delete "Tatiana a" user T
    And I wait for 2 sec T

  @registrLastName4
  Scenario: Max=254+1characters
    And I type "uu7777777798777777777777vvvvvvvvvvvvvvvv77777777777777$$$$$$$$$$$$$$$$$$FFFDDDDSSSAAQQQWQWQWQWWQWQWQWQWQWQWQWQWQWQWQuuytuuyttutuytuytytutuytuytytututuytutututuytuytutuytutuyt564646546465464654646465646546544654654654654654654654654654654665444445566546666" into "Last Name" field T
    When I click button "Register Me" T
    And I wait for 2 sec T
    Then message "Data too long for column 'name' at row 1" should be displayed TE
    And I wait for 2 sec T

  @registrLastName5
  Scenario: White spaces are not allowed
    And I type "6 iuyt n" into "Last Name" field T
    When I click button "Register Me" T
    And I wait for 2 sec T
    Then message "Whitespaces are not allowed." should be displayed TD
    And I wait for 2 sec T



