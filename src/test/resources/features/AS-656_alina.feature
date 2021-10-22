@predefined
Feature: Home Page - Links

  @predefined1
  Scenario: Home Page - Links
    Given I navigate to "login" page
    When I print "ask_instr@aol.com" into email field
    And I input "12345" into the password field
    When I will click "Sign In" button
    And I will wait for 3 sec
    When I click on "Submissions" menu
    And I wait for 3 sec
    When I click on "Assignments" menu
    And I wait for 3 sec
    When I will click on "Quizzes" menu
    And I wait for 3 sec
    When I click on "Users Management" menu
    And I wait for 3 sec
    When I click on "Settings" menu
    And I wait for 3 sec
    Given I open "Log Out" page