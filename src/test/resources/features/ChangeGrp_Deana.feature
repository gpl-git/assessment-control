@User's_management_ChangUser'sGroup
Feature: Change User's Group

  Background:
    Given I go to "login" page -DA
    When I type "Elladam@hotmail.red" into email field -DA
    And I type "Hi1234" into password field -DA
    When I click "Sign In" button -DA
    And I wait for 1 sec -DA
    And I click "Users Management" menu item -DA
    And I wait for 1 sec -DA

    @User'management_[S]
  Scenario: Change User's Group for Student.
    When I Select a student name "Dina Aldawi" from the list of Students
    And I Click on "Options" button
    And I wait for 2 sec -DA
    And I select "Change User's Group" from list
    And I wait for 2 sec -DA
    When I clear User's Group filed
    When I type "May 23" into  User's Group filed
    Then I Click on "Change" Button -DA
    And I wait for 2 sec -DA
    Then "NewUsrGrP" is displayed on the user-details page

   @User'management[S]-boundaryconditions
  Scenario Outline: Change User's Group for Student.
    When I Select a student name "Dina Aldawi" from the list of Students
    And I Click on "" button
    And I wait for 2 sec -DA
    And I select "Options" from list
    And I wait for 2 sec -DA
    When I clear User's Group filed
    When I type <NewGrp> into  User's Group filed
    Then I Click on "Change" Button -DA
    And I wait for 2 sec -DA
    Then "NewUsrGrP" is displayed on the user-details page
    Examples:
      | NewGrp   |
      | "ABCDEFGHIJ" |
      | "A" |
      | "ABCDEFGHIJK" |
      | "" |

