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
