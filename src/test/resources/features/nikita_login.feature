@login
  Feature: Login Scenario

    Scenario: Login with right credentials
      Given I go to "Login" page N.R.
      When I type "6jemo@byrnewear.com" into email field N.R.
      And I type "12345" into password field N.R.
      When I click on "Sign In" button N.R.
      And I wait for 1 sec
      Then I verify current url as "home" N.R.