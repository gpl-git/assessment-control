@login
  Feature: Login Scenarios

    @smoke
    Scenario: Login as Teacher
      Given I open "login" page
      When  I type "qa@ask.com" into email filed
      And I type "12345" into password field
      When  I click "Sign In" button
      And I wait for 1 sec
      Then I verify user role as "TEACHER"
      And I wait for 2 sec


   @regression
    Scenario: Login as Student
      Given I open "login" page
      When  I type "student1@test.com" into email filed
      And I type "12345" into password field
      When  I click "Sign In" button
      And I wait for 1 sec
      Then I verify user role as "STUDENT"
      And I wait for 2 sec

  Scenario: Login valid email and invalid password
    Given I open "login" page
    When  I type "student1@test.com" into email filed
    And I type "12345vv" into password field
    When  I click "Sign In" button
    And I wait for 1 sec
    Then message "Authentication failed. " is displayed


  Scenario: Login - Password field Error messages verification
    Given I open "login" page
    When  I type "student1@test.com" into email filed
    And I type "" into password field
    When  I click "Sign In" button
    And I wait for 1 sec
    Then message "This field is required" should be displayed


    Scenario Outline: Login - Password field Error messages verification
      Given I open "login" page
      When  I type "student1@test.com" into email filed
      And I type <pwd> into password field
      When  I click "Sign In" button
      Then message <message> should be displayed
      Examples:
      | pwd |  message                  |
      | ""  | "This field is required"  |
      | "12 34"  | "Whitespaces are not allowed"  |
      | "123455555555555555555555555555555555555555555555555"  | "Too long. Should be no more than 32 characters"  |

    Scenario: Login Password is masked and copy/passed disabled
      Given I open "login" page
      When  I type "student1@test.com" into email filed
      And I type "12345" into password field
      Then password is masked and copy and cut disabled

