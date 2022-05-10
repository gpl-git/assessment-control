@RegEmail
Feature: Re1

  Background:
    Given I go to "registration" page
    @1
    Scenario: I fill out registration form
          When I type "testuser1" into firstName field
          And I type "tester" into lastName field
          When I type "tester2@test.com" into email field
          And I type "012" into groupCode field
          And I type "12345" into password field
          And I type "12345" into confirmPassword field
          When I click button "Register Me"
          And I wait for 2 sec
          Then I confirm "You have been Registered."
          And I wait for 3 sec
    @2
    Scenario: Email cannot be empty
      When I type "testuser2" into firstName field
      And I type "tester" into lastName field
      And I type "012" into groupCode field
      And I type "12345" into password field
      And I type "12345" into confirmPassword field
      When I click button "Register Me"
      Then I confirm "This field is required" for email

      @3
      Scenario: White space not allowed before email
        When I type "testuser2" into firstName field
        And I type "tester" into lastName field
        When I type " tester2@test.com" into email field
        And I type "012" into groupCode field
        And I type "12345" into password field
        And I type "12345" into confirmPassword field
        When I click button "Register Me"
        Then I confirm "Should be a valid email address" for email

  @4
  Scenario Outline: special characters, white space, invalid length not allowed in email
    When I type "testuser2" into firstName field
    And I type "tester" into lastName field
    When I type <email> into email field
    And I type "012" into groupCode field
    And I type "12345" into password field
    And I type "12345" into confirmPassword field
    When I click button "Register Me"
    Then I confirm "Should be a valid email address" for email
    Examples:
      | email         |
      | "(abc@abc.com" |
      | ")abc@abc.com" |
      | "\abc@abc.com" |
      | ",abc@abc.com" |
      | "<abc@abc.com" |
      | ">abc@abc.com" |
      | ",abc@abc.com" |
      | "abc @abc.com" |
      | "abc@ abc.com" |
      | "abc@abc .com" |
      | "abc@abc. com" |
      | "abc@abc.com " |
      | "abcabc.com" |
      | "ronch66ronch66ronch66ronch66ronch66ronch66ronch66ronch66ronch666r@ch66ronch66ronch66ronch66ronch66ronch66ronch66ronch66eevvdd.com" |
      | "qwq23dfdfqwq23dfdfqwq23dfdfqwq23dfdfqwq23dfdfqw2q23dfdffqwq23dfdf@bagislan.org" |
      | "reliza@qwq23dfdfqwq23dfd1fqwq23dfdfqwq23dfdfqwq23dfdfqwq23dfdffqwq23dfd.org" |
      | "reliza@bagislan.qwq23dfdfqwq23dfdfqwwq23dfdfqwq23dfdfqwq23dfdfqwq23dfdffqwq23dfd" |
  @5
#    This email gets registered always. Possible Bug.
  Scenario: I verify the length of email for 128 characters
    When I type "testuser1" into firstName field
    And I type "tester" into lastName field
    When I type "ronch66ronch66ronch66ronch66ronch66ronch66ronch66ronch66ronch67r@ch66ronch66ronch66ronch66ronch66ronch66ronch66ronch66eevvdd.com" into email field
    And I type "012" into groupCode field
    And I type "12345" into password field
    And I type "12345" into confirmPassword field
    When I click button "Register Me"
    And I wait for 2 sec
    Then I confirm "You have been Registered."
    And I wait for 3 sec

#  Generate random email
  @6
  Scenario: I register using random email
    When I type "testuser1" into firstName field
    And I type "tester" into lastName field
    When I use "randomEmail" into email field
    And I wait for 3 sec
    And I type "012" into groupCode field
    And I type "12345" into password field
    And I type "12345" into confirmPassword field
    When I click button "Register Me"
    And I wait for 2 sec
    Then I confirm "You have been Registered."
    And I wait for 3 sec





