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

  @User'management_[S]1
  Scenario: Verify Modal Window with Specific Text

    When I Select a student name "Dina Aldawi" from the list of Students
    And I Click on "Options" button at mat-card -DA
    And I wait for 2 sec -DA
    And I select "Change User's Group" from list
    And I wait for 2 sec -DA
    Then I should see modal window with "Change Your Group" -DA
#  This is known issue JIRA MAY23-400

  @User'management_[S]2
  Scenario: Verify Input Field Placeholder

    When I Select a student name "Dina Aldawi" from the list of Students
    And I Click on "Options" button at mat-card -DA
    And I wait for 2 sec -DA
    And I select "Change User's Group" from list
    And I wait for 2 sec -DA
    When I clear User's Group filed
    Then I should see input field placeholder as "Group Code" -DA
    #  This is known issue JIRA MAY23-292
#  Fixed in Build Number: 1.0.7

  @Testrequairments1
  Scenario Outline: Verify input field requirement for Group code.

    When I Select a student name "Dina Aldawi" from the list of Students
    And I Click on "Options" button at mat-card -DA
    And I wait for 2 sec -DA
    And I select "Change User's Group" from list
    And I wait for 2 sec -DA
    When I clear User's Group filed
    When I type <NewGrp> into  User's Group filed
    And I click on "change" button -DA
    And I wait for 2 sec -DA
    Then <NewGrp> is displayed on the user-details page
    And I wait for 4 sec -DA
    Examples:
      | NewGrp          |
#      Max 10 characters.
      | "ABCDEFGHIJ"    |
#      Min 1 character.
      | "A"             |
#      More than 10 characters.
      | "ABCDEFGHIJK"   |
#      Alphanumeric & Special characters
      | "7h@ckM3!_P@ss" |

  @Testrequairments2
  Scenario:Verify White spaces are not allowed

    When I Select a student name "Dina Aldawi" from the list of Students
    And I Click on "Options" button at mat-card -DA
    And I wait for 2 sec -DA
    And I select "Change User's Group" from list
    And I wait for 2 sec -DA
    And I clear User's Group filed
    When I type "May 23" into  User's Group filed
    And I wait for 2 sec -DA
    And I click on "change" button -DA
    Then "May 23" is not displayed on the user-details page -DA
#  This is known issue JIRA MAY23-621

  @Testrequairments3
  Scenario:Verify Group code field required, can’t be empty

    When I Select a student name "Dina Aldawi" from the list of Students
    And I Click on "Options" button at mat-card -DA
    And I wait for 2 sec -DA
    And I select "Change User's Group" from list
    And I wait for 2 sec -DA
    And I clear and backspace User's Group filed  -DA
    And I wait for 4 sec -DA
    And error message "This field is required" shold be displayed -DA
    Then "" is not displayed on the user-details page -DA


  @User'management_[T]
  Scenario: verify that Teacher can not Change User's Group for him self.
    When I click on the "Teacher" tap
    And I wait for 2 sec -DA
    And I Select a Teacher name "Deana Teacher" from the list of Students
    And I Click on "Options" button at mat-card -DA
    And I wait for 2 sec -DA
    And I select "Change User's Group" from list
    And I wait for 2 sec -DA
    Then I should see "Notification" window -DA
    And I wait for 2 sec -DA


