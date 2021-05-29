@Email
  Feature: Email scenarios

    Scenario: Validate email field
      Given I open "registration" page
      When I type in new email field
      And I wait for 3 sec
@email2
    Scenario: Validate email field
      Given I open "registration" page
      When I type "abc123@gmail.com" into email field
     And I wait for 1 sec
      Then I click on "Register me " button
      And I wait for 1 sec
      Then "Should be a valid email address" message should not be displayed
      And I wait for 2 sec


@email3
    Scenario: Validate special character in email field
    Given I open "registration" page
    When I type "abc#*'@gmail.com" into email field
    And I wait for 2 sec
    Then I click on "Register me" button
    And I wait for 2 sec
    Then "Should be a valid email address" message should be displayed
    And I wait for 2 sec
@eamil4
    Scenario Outline: Validate special character in email field and 64 char before@ and 65 char before@ and white space not allowed
      Given I open "registration" page
      When I type <email> into email field
      And I wait for 1 sec
      Then I click on "Register Me" button
      And I wait for 1 sec
      Then <expectedError> message should be displayed
      And I wait for 1 sec
      Examples:
         | email              | expectedError                     |
         | "abc#*'@gmail.com" |   "Should be a valid email address" |
         | "ewhfdwuedgwndskfewfowjfadbsjbceidjasbdiewufdzxcgvhbjnkjybfshhajh@gmail.com" |   "" |
         | "ewhfdwuedgwndskfewfowjfadbsjbceidjasbdiewufdzxcgvhbjnkjybfshhajh567@gmail.com" |   "Should be a valid email address" |
         | "abc  @gmail.com" |   "Should be a valid email address" |
         | "" |   "Should be a valid email address" |
         | "abc123" |   "Should be a valid email address" |








