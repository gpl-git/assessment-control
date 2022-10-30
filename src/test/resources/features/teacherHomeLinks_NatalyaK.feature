@homeLinksTeacher
Feature: Check all links on home page as teacher

  Background:
    Given I open "login" page
    When I type "nata@getnada.com" for teacher user
    And I type "12345" as password
    When I click "Sign In" button
    And I wait for 2 sec
    Then "home" page will be displayed

  @teacherLink1
      #known issue SEP22-105 Link "Go To Submissions" on the Home page doesn’t work
  Scenario: Submissions home page link
    When I click on "Go To Submissions" link
    Then page with header "Submissions" should open

  @teacherLink2
  Scenario: Assignment Statistic home page link
    When I click on "Go To Assignments" link
    Then page with header "List of Assignments" should open

  @teacherLink3
  Scenario: Users Management home page link
    When I click on "Go To Users Management" link
    #Ask how to check page name as "User's Management"
    Then page with header "Management" should open

  @teacherMainLinks
  Scenario Outline: Check main menu links on home page as teacher
    When I click on the <menuButtonText> button on the menu
    And I wait for 1 sec
    Then page with header <pageHeader> should open
    When I click on the "Home" button on the menu
    Then I should land on page with url "http://ask-qa.portnov.com/#/home"
    Examples:
      | menuButtonText     | pageHeader            |
      | "Submissions"      | "Submissions"         |
      | "Assignments"      | "List of Assignments" |
      | "Quizzes"          | "List of Quizzes"     |
      | "Users Management" | "Management"          |
      | "Settings"         | "Settings"            |

  @teacherLogOut
  Scenario: Check Log Out button functionality as teacher
    When I click on the "Log Out" button on the menu
    Then pop-up with "Confirmation" name should be displayed
    #Selenium unable to locate. How to check pop-up disappear"
#      When I click on the "No, Thanks" button
#      Then pop-up with "Confirmation" name should not be displayed
    And I click on the "Log Out" button
    And I wait for 1 sec
    Then I should land on page with url "http://ask-qa.portnov.com/#/login"