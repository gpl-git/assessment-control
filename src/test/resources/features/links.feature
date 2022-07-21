Feature: Home page link Scenarios

  @links1
  Scenario: Verify links for teacher role
    Given I go to "login" page T
    When I type "ozartex@noisemails.com" into email field T
    And I enter "12345" as password T
    When I click button "Sign In" T
    And I wait for 2 sec
    And I verify role "TEACHER" on the side menu
    When I click "Home" menu item TT
    Then I verify current url contains "home"
    When I click "Submissions" menu item TT
    Then I verify current url contains "submissions"
    When I click "Assignments" menu item TT
    Then I verify current url contains "assignments"
    When I click "Quizzes" menu item
    Then I verify current url contains "quizzes"
    When I click "Users Management" menu item TT
    Then I verify current url contains "users-management"
    When I click "Settings" menu item TT
    Then I verify current url contains "settings"
    When I click "Log Out" menu item TT
    Then log out confirmation should be displayed
    When I click button "Log out" TT
    And I wait for 2 sec

  @links2
  Scenario: Verify links for student role 
    Given I go to "login" page T
    When I type "roman2185@mypend.fun" into email field T
    And I enter "12345" as password T
    When I click button "Sign In" T
    And I wait for 2 sec
    And I verify role "STUDENT" on the side menu TT
    When I click "Home" menu item TT
    Then I verify current url contains "home"
    When I click "My Assignments" menu item TT
    Then I verify current url contains "my-assignments"
    When I click "My Grades " menu item T
    Then I verify current url contains "my-grades"
    And I wait for 2 sec
    When I click "Settings" menu item TT
    Then I verify current url contains "settings"
    When I click "Log Out" menu item TT
    Then log out confirmation should be displayed
    When I click button "Log out" TT
    And I wait for 2 sec
    













