@changeUserRole

  Feature: Verify Student's role can be changed to Teacher
    Background:
      Given I go to "login" page
      When I type "2tvhrtjhvrtc@dallassalons.com" into email field
      And I type "12345" into password field
      When I click "Sign In" button
      And I wait for 1 sec
      And I click on "Users Management" link
      And I wait for 1 sec

    @changeRole1
    Scenario: Student's role can be changed to Teacher
      When I choose "julia E"
      Then I click on Options button
      And I wait for 2 sec
      And I select Change User's Role option
      And message "User will become a TEACHER and have access to all ADMIN features. Are you sure want to change ROLE for this user?" should be displayed
      And I click on "Change Role"
      And I wait for 2 sec
      Then I validate that "TEACHER" is displayed
      And I wait for 2 sec

    @changeRole2
    Scenario: Teacher's role can be changed to Student
      When I click on "Teachers" tab
      And I wait for 2 sec
      When I choose "julia E"
      Then I click on Options button
      And I wait for 2 sec
      And I select Change User's Role option
      And message "User will become a STUDENT and lose access to all ADMIN features. Are you sure want to change ROLE for this user?" should be displayed
      And I click on "Change Role"
      And I wait for 2 sec
      Then I validate that "STUDENT" is displayed
      And I wait for 2 sec