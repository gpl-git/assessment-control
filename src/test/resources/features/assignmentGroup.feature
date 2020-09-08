@smoke
  Feature: Assignment - Group

@smoke1
Scenario: Teacher can assign quiz to all students by searching students by group code
  Given I open "login" page
  When I type "lubchek@yahoo.com" into email field
  And I type "12345" into login password field
  Then I click "Sign In" button
  And I wait for 2 sec
  When I navigate to "Assignments" page
  And I wait for 3 sec
  And I click "Create New Assignment" button for new assignment
  And I select "ABC" from Group Filter menu
  And I wait for 1 sec
  And I select "ESL Level 1" from Quiz to assign menu
  And I click "Select All" button
  Then I click "Give Assignment" button
  And I wait for 2 sec

@smoke2
#Scenario: Teacher can assign quiz to individual student by searching students by group code
#  Given I open "login" page
#  When I type "lubchek@yahoo.com" into email field
#  And I type "12345" into login password field
#  Then I click "Sign In" button
#  And I wait for 2 sec
#  When I navigate to "Assignments" page
#  And I wait for 3 sec
#  And I click "Create New Assignment" button for new assignment
#  And I select "ABC" from Group Filter menu
#  And I wait for 1 sec
#  And I select "ESL Level 1" from Quiz to assign menu
#  Then I select "1" student
  