@registrationAnzhela
Feature: Registration
  Background:
    Given I go to "login" page
    When I click button "Register Now"

  @registration1Anzhela
  Scenario: Registration: Last Name empty field
    Then I A type "" into lastName field
    And I click button "Register Me"
    Then A error message "This field is required" is displayed
    And I wait for 2 sec

  @registration2Anzhela
  Scenario: Registration: Last Name white spaces not allowed
    Then I A type " " into lastName field
    And I click button "Register Me"
    Then A error message "Whitespaces are not allowed" is displayed
    And I wait for 2 sec

  @registration3Anzhela
  Scenario: Registration: Last Name Min 1 character
    When I A enter "AB" into First Name field
    Then I A type "A" into lastName field
    And I A enter "ab@gmail.com" into Email field
    And I A enter "AB" into Group Code
    When I A type "tester" in the Password field
    And  I A type "tester" in the Confirm Password field
    And I wait for 2 sec
    And I click button "Register Me"
#    Then error message "This field is required" is not displayed
    And I A see verification message "You have been Registered"
    And I wait for 2 sec

  @registration4Anzhela
  Scenario: Registration: Last Name Alphanumeric & Special characters is allowed
    Then I A type "rt456%^" into lastName field
    And I click button "Register Me"
#    Then error message "This field is required" is not displayed
    And I wait for 2 sec

  @registration5Anzhela
  Scenario: Registration: Last Name Max 254 characters allowed
    Then I A type "dfgjjkklllkjghjdghdfgfggjhkhjkghjfghdfghdfghdfghdfghdfghdfghdfghdgfhjghjfghjgfhjfghjfghjfghjfghjfghjdyjtyjgfjfghjfhkghjkghjkghjkfghjfghjdgfhdthdhjgjgfhjfhkjjrjfghdfghdfghjtjjdghdfghdfjfjyjdghjdtyjtyjtyjyukikyjdhdyhytjyjyujujujkkikiktukukkukukukyukryujrty" into lastName field
    And I click button "Register Me"
#    Then error message "This field is required" is not displayed
    And I wait for 2 sec

  @registration6Anzhela
  Scenario: Registration: Last Name Max 255 characters not allowed
    Then I A type "Adfgjjkklllkjghjdghdfgfggjhkhjkghjfghdfghdfghdfghdfghdfghdfghdfghdgfhjghjfghjgfhjfghjfghjfghjfghjfghjdyjtyjgfjfghjfhkghjkghjkghjkfghjfghjdgfhdthdhjgjgfhjfhkjjrjfghdfghdfghjtjjdghdfghdfjfjyjdghjdtyjtyjtyjyukikyjdhdyhytjyjyujujujkkikiktukukkukukukyukryujrty" into lastName field
    And I click button "Register Me"
    Then A error message "Max 254 characters" is not displayed
    And I wait for 2 sec
