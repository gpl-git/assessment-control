@Test
  Feature: Registration

    Background:
    Given I go to "registration" page


  @case1
  Scenario: Verify that Group Code input field accepts Alphanumeric & Special characters

    When I type "John" into firstName field
    Then I type "Snow" into lastName field
    And I type "krkp@hiowaht.com" into emailReg field
    Then I type "ABC123$@" into groupCode field
    When I type "12345" into passwordReg field
    And I type "12345" into confirmPasswordReg field
    Then I click registration button
    Then I confirm "You have been Registered."

    @case2
    Scenario: Verify that error message is displayed when Group Code input field is empty

     When I type "John" into firstName field
     Then I type "Snow" into lastName field
     And I type "krkp@hiowaht.com" into emailReg field
     When I type "12345" into passwordReg field
     And I type "12345" into confirmPasswordReg field
     Then I click registration button
     Then error message "This field is required" should displayed

  @case3
  Scenario: Verify that Group Code input field must contain minimum 1 character

    When I type "John" into firstName field
    Then I type "Snow" into lastName field
    And I type "krkp@hiowaht.com" into emailReg field
    Then I type "@" into groupCode field
    When I type "12345" into passwordReg field
    And I type "12345" into confirmPasswordReg field
    Then I click registration button
    Then  I confirm "You have been Registered."


  @case4
  Scenario:  Verify that Group Code input field must contain maximum 10 characters

    When I type "John" into firstName field
    Then I type "Snow" into lastName field
    And I type "krkp@hiowaht.com" into emailReg field
    Then I type "123456789@" into groupCode field
    When I type "12345" into passwordReg field
    And I type "12345" into confirmPasswordReg field
    Then I click registration button
    Then I confirm "You have been Registered."

  @case5
  Scenario: Verify that error message "Should no more than 10 characters" should displayed when in Group Code input field entered more than 10 characters

   When I type "John" into firstName field
   Then I type "Snow" into lastName field
   And I type "krkp@hiowaht.com" into emailReg field
   Then I type "12345678910" into groupCode field
   When I type "12345" into passwordReg field
   And I type "12345" into confirmPasswordReg field
   Then I click registration button
   Then error message "Should no more than 10 characters" should displayed

    @case6
    Scenario: Verify that white spaces are not allowed in Group Code input field

     When I type "John" into firstName field
     Then I type "Snow" into lastName field
     And I type "krkp@hiowaht.com" into emailReg field
     Then I type " 123 5" into groupCode field
     When I type "12345" into passwordReg field
     And I type "12345" into confirmPasswordReg field
     Then I click registration button
     Then error message "White spaces are not allowed" should displayed





























