@logIn
  Feature: Log In Test Set

    @logIn1 @regression
    Scenario: Valid Email and Valid Password Combination, Lets User In
      Given I open "login" page ER
      When I type "aleks8940@viophos.store" into email field ER
      When I type "12345" into password field ER
      And I click "Sign In" button ER
      And I wait for 1 seconds ER
      Then Home page should be displayed ER

    @logIn2 @regression
    Scenario: Invalid Email and Valid Password Combination: Will Be Rejected
      Given I open "login" page ER
      When I type "invalid@gmail.com" into email field ER
      When I type "12345" into password field ER
      And I click "Sign In" button ER
      And I wait for 1 seconds ER
      Then "Authentication failed. User not found or password does not match" error message will be displayed ER

    @logIn3 @regression
    Scenario: Valid Email and Invalid Password Combination: Will Be Rejected
      Given I open "login" page ER
      When I type "aleks8940@viophos.store" into email field ER
      When I type "0000" into password field ER
      And I click "Sign In" button ER
      And I wait for 1 seconds ER
      Then "Authentication failed. User not found or password does not match" error message will be displayed ER

    @logIn4 @regression
    Scenario: Invalid Combination of Email and Password in Log In Form: Will Be Rejected
      Given I open "login" page ER
      When I type "invalid@gmail.com" into email field ER
      When I type "0000" into password field ER
      And I click "Sign In" button ER
      And I wait for 1 seconds ER
      Then "Authentication failed. User not found or password does not match" error message will be displayed ER

    @logIn5 @regression
    Scenario: Password Field Displays Input in Bullets
      Given I open "login" page ER
      When I type "0000" into password field ER
      Then Password field must be masked ER

    @logIn6 @regression
    Scenario: Leading and Trailing Spaces are Not Allowed in "Email" Field
      Given I open "login" page ER
      When I type "aleks8940@viophos.store    " into email field ER
      And I wait for 1 seconds ER
      Then "Should be a valid email address" error message will be displayed ER

    @logIn7 @regression
    Scenario: Leading and Trailing Spaces are Not Allowed in "Password" Field
      Given I open "login" page ER
      When I type "    " into password field ER
      And I wait for 2 seconds ER
      Then "Whitespaces are not allowed" error message will be displayed ER

    @logIn8 @regression
    Scenario: Valid Email and Valid Password Combination, Lets User In
      Given I open "login" page ER
      When I type "Aleks8940@viophos.store" into email field ER
      When I type "12345" into password field ER
      And I click "Sign In" button ER
      And I wait for 1 seconds ER
      Then Home page should be displayed ER

