@predefined
   Feature: 

     @predefined1
  Scenario: Home Page links T Demo
     Given I open "login" website
       When I type "gnwjdu@gotcertify.com" into email field
       When I type "12345" into password field
       And I click "Sign In" button
       And I wait for 2 sec
       When I click on the "Submissions" button
       And I wait for 2 sec
       When I click on "Assignments" button
       And I wait for 2 sec
       When I click button "Quizzes"
       And I wait for 2 sec
       When I click "Users Management"
       And I wait for 2 sec
       When I click on "Settings"
       And I wait for 2 sec
       When I click on the "Home"
       And I wait for 2 sec
       When I "Log Out"

   @predefined2
   Scenario: Home Page links S Demo
     Given I open "login" website
     When I type "student5@gmail.com" into email field
     When I type "12345" into password field
     And I click "Sign In" button
     And I wait for 2 sec
     When I click "My Assignments" button OR
     And I wait for 2 sec
     When I click "My Grades" button O
     And I wait for 2 sec
     When I click "Settings" button R
     And I wait for 2 sec
     When I click on "Home" button OR
     And I wait for 2 sec
     When I click "Log Out" button LO
     And I wait for 2 sec
     When I click "Log Out" button L





