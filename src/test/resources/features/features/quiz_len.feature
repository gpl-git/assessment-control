@quiz
  Feature: Quiz

    Background:
    Given I go to "registration" page

  @smock
  Scenario: Verify that Group Code input field accepts Alphanumeric & Special characters
    When I type "John" into firstName field
    Then I type "Snow" into lastName field
    And I type "krkp@hiowaht.com" into emailReg field
    Then I type "ABC123$@" into groupCode field
    When I type "12345" into passwordReg field
    And I type "12345" into confirmPasswordReg field
    Then I click registration button



