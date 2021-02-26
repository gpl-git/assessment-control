@quizTotalNumberDoina @somke

  Feature: Quiz Total Number  Of Questions Scenarios

    @smoke1
       Scenario: Quiz Total Number Of Questions Happy Path
         Given I go to "ask"
         When I enter "doina.qa922@gmail.com" into email field
         And I enter "Password123" into password field
         When  I click "Sign In" button
         And I wait for 1 sec
         Then I verify that user is logged in at "home" page
         And I verify that "Quizzes" button is present
         Then I click on "Quizzes" button
         Then I wait for 1 sec
         And I click "Create New Quiz" button
         And I wait for 1 sec
         Then I type "Total  Number of questions " into quiz title
         And  I click on the plus button 50
         Then I wait for 5 sec
         Then I verify that "Q50" is displayed


       @smoke2
       Scenario: Quiz Total Number +1 Of Questions
         Given I go to "ask"
         When I enter "doina.qa922@gmail.com" into email field
         And I enter "Password123" into password field
         When  I click "Sign In" button
         And I wait for 3 sec
         Then I verify that user is logged in at "home" page
         And I verify that "Quizzes" button is present
         Then I click on "Quizzes" button
         Then I wait for 3 sec
         And I click "Create New Quiz" button
         And I wait for 1 sec
         Then I type "Total  Number of questions " into quiz title
         And  I click on the plus button 51
         Then I wait for 5 sec
         Then I should see error message "Should contain no more then 50 Questions"
         #Nowing bug I should see error message "Should contain no more then 50 Questions"
         # Jira Bug https://jira.portnov.com/browse/AS-525

        @smoke3
        Scenario: Graded Automatically
          Given I go to "ask"
          When I enter "doina.qa922@gmail.com" into email field
          And I enter "Password123" into password field
          When  I click "Sign In" button
          And I wait for 3 sec
          Then I verify that user is logged in at "home" page
          Then I verify that "Assignments" button is present
          And I click on "Assignments" button
          Then I wait for 3 sec
          And I click "Create New Assignment" button
          Then I wait for 3 sec
          Then I choose a Student
          And I wait for 2 sec
          Then I select "Select Quiz To Assign"
          Then I select quiz  "Graded automatically"
          And I wait for 2 sec
          And  I click "Give Assignment"
          Then I click on "Log Out" button
          And I wait for 2 sec
          Then I click to "Log Out"
          And I wait for 3 sec
          When I enter "student1@test.com" into email field
          And I enter "12345" into password field
          When I click "Sign In" button
          And I wait for 1 sec
          Then I verify that user is logged in at "home" page
          And   I click on "My Assignments" button
          When I choose "My Assignments"









