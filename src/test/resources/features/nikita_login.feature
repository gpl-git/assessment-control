@login
Feature: Login Scenario

  Scenario: Login with right credentials
    Given I go to "Login" page N.R.
    When I type "6jemo@byrnewear.com" into email field N.R.
    And I type "12345" into password field N.R.
    When I click on "Sign In" button N.R.
    And I wait for 1 sec
    Then I verify current url as "home" N.R.


  Scenario Outline: Login with wrong functional specification  credentials
    Given I go to "Login" page N.R.
    When I type <email> into email field N.R.
    And I type <pwd> into password field N.R.
    When I click on <btnName> button N.R.
    And I wait for <sec> sec
    Then I verify current url as <curUrl> N.R.
    Examples:
      | email                 | pwd                                      |
      | "6jemo@byrnewear.com" | "  "                                     |
      | "6jemo@byrnewear.com" | "1234"                                   |
      | "6jemo@byrnewear.com" | "12345jjjjjjjjjjjjjjjjjjjjjjjj293133,36" |
      | "    @   "            | "1234"                                   |
      | "6jemo@byrnewe r.com" | "12345"                                  |


