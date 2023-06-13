@quiz-user_management
  Feature: User Management Steps
    Scenario: Change user
      Given I move to "login" page
      And I wait for 2 sec
      When I input "muksw@hotmail.com" into email field
      And I input "12345" into password field
      And I press "Sign In" button
      And I wait for 2 sec
      Then "MUKUND" is displayed on the screen
      And I click "Users Management" on side menu
      And I wait for 1 sec
      And I click "Mukund Wable" mat list item
      And I wait for 1 sec
      Then user role is "STUDENT"
      When I tap Options button
      And I wait for 1 sec
      And I change users role
      And I confirm "Change Role"
      And I wait for 1 sec
      Then user role is "TEACHER"
      And I wait for 1 sec
      When I tap Options button
      And I wait for 1 sec
      And I change users role
      And I confirm "Change Role"
      And I wait for 1 sec
      Then user role is "STUDENT"

