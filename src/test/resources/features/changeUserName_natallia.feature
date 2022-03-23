@changeUserName

  Feature: Change User Name Scenarios
    Background:
      Given I navigate to "login" page
      Then I type "codyhyre@jobstoknow.com" into email input field
      And I type "12345" into password input field
      Then I click on "Sign In" button
      And I wait for 2 sec
      And I pick "Users Management" menu item
      Then I wait for 2 sec

    @changeUserNameStudent
    Scenario: Change student name
      And I click on "Students" tab
      And I wait for 2 sec
      Then I click on "Alena Alena1" name
      And I wait for 1 sec
      And I click on "Options"
      And I wait for 5 sec
      Then I click on "Change User's Name" from settings menu
      And I wait for 5 sec
      Then I erase full "name" field
      And I wait for 2 sec
      Then I type "Alena Alena12" in full name field
      And I click on "Change" button
      And I wait for 2 sec
      Then I verify that a new name "Alena Alena12" displays

    @changeUserNameTeacher
    Scenario: Change teacher name
      And I click on "Teachers" tab
      And I wait for 2 sec
      Then I click on "Alena Natallia1" name
      And I wait for 1 sec
      And I click on "Options"
      And I wait for 5 sec
      Then I click on "Change User's Name" from settings menu
      And I wait for 5 sec
      Then I erase full "name" field
      And I wait for 2 sec
      Then I type "Alena Natallia12" in full name field
      And I click on "Change" button
      And I wait for 2 sec
      Then I verify that a new name "Alena Natallia12" displays