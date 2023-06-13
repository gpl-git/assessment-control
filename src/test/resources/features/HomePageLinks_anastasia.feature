@HomePageLinks
Feature: Home page

  @HomePageLinks1
  Scenario: Verify if Teacher Home Page links works
    Given I go to "login" page AP
    When I type "ask_instr@aol.com" into email field AP
    And I type "12345" into password field AP
    When I click "Sign In" button AP
    When I click "Submissions" menu item AP
    And I wait for 2 sec
    When I click "Assignments" menu item AP
    And I wait for 2 sec
    When I click "Quizzes" menu item AP
    And I wait for 2 sec
    When I click "Users Management" menu item AP
    And I wait for 2 sec
    When I click "Settings" menu item AP
    And I wait for 2 sec
    When I click "Home" menu item AP
    And I wait for 2 sec
    When I click "Go To Submissions" home page button AP
    And I wait for 2 sec
    When I click "Home" menu item AP
    And I wait for 2 sec
    When I click "Go To Assignments" home page button AP
    And I wait for 2 sec
    When I click "Home" menu item AP
    And I wait for 2 sec
    When I click "Go To Users Management" home page button AP
    And I wait for 2 sec
    When I click "Log Out" menu item AP
    And I wait for 2 sec

  @HomePageLinks2
  Scenario: Verify if Student Home Page links works
    Given I go to "login" page AP
    When I type "student1@test.com" into email field AP
    And I type "ABC123" into password field AP
    When I click "Sign In" button AP
    When I click "My Assignments" menu item AP
    And I wait for 2 sec
    When I click "My Grades" menu item AP
    And I wait for 2 sec
    When I click "Settings" menu item AP
    And I wait for 2 sec
    When I click "Home" menu item AP
    And I wait for 2 sec
    When I click "Go To My Assignments" home page button AP
    And I wait for 2 sec
    When I click "Home" menu item AP
    And I wait for 2 sec
    When I click "Go To My Grades" home page button AP
    And I wait for 2 sec
    When I click "Log Out" menu item AP
    And I wait for 2 sec

