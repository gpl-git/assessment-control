@homeLinksStudent
Feature: Check all links on home page as student

  Background:
    Given I open "login" page
    When I type "student1@vomoto.com" for student user
    And I type "12345" as password
    When I click "Sign In" button
    And I wait for 2 sec
    Then "home" page will be displayed

  @studentAssignmentsLink
  Scenario: Check Assignment link on home page as student
    When I click on the "Go To My Assignments" button
    Then "my-assignments" page will be displayed

  @studentGradesLink
  Scenario: Check Grades link on home page as student
    When I click on the "Go To My Grades" button
    Then "my-grades" page will be displayed

  @studentMainLinks
  Scenario Outline: Check main menu links on home page as student
    When I click on the <menuButtonText> button on the menu
    And I wait for 1 sec
    Then <expectedUrl> page will be displayed
    When I click on the "Home" button on the menu
    Then I should land on page with url "http://ask-qa.portnov.com/#/home"
    Examples:
      | menuButtonText   | expectedUrl      |
      | "My Assignments" | "my-assignments" |
      | "My Grades"      | "my-grades"      |
      | "Settings"       | "settings"       |

  @studentLogOut
  Scenario: Check Log Out button functionality as student
    When I click on the "Log Out" button on the menu
    Then pop-up with "Confirmation" name should be displayed
    #Selenium unable to locate. How to check pop-up disappear"
#      When I click on the "No, Thanks" button
#      Then pop-up with "Confirmation" name should not be displayed
    And I click on the "Log Out" button
    And I wait for 1 sec
    Then I should land on page with url "http://ask-qa.portnov.com/#/login"