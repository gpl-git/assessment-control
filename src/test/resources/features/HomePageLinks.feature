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
       Then current url should contain "Submissions"
       When I click on "Assignments" button
       Then current url should contain "Assignments"
       And I wait for 2 sec
       When I click button "Quizzes"
       Then current url should contain "Quizzes"
       And I wait for 2 sec
       When I click "Users Management"
       Then current url should contain "Management"
       And I wait for 2 sec
       When I click on "Settings"
       Then current url should contain "Settings"
       And I wait for 2 sec
       When I click on the "Home"
       Then current url should contain "Home"
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
     Then current url should contain "Assignments"
     And I wait for 2 sec
     When I click "My Grades" button O
     Then current url should contain "Grades"
     And I wait for 2 sec
     When I click "Settings" button R
     Then current url should contain "Settings"
     And I wait for 2 sec
     When I click on "Home" button OR
     Then current url should contain "Home"
     And I wait for 2 sec
     When I click "Log Out" button LO
     And I wait for 2 sec
     When I click "Log Out" button L





