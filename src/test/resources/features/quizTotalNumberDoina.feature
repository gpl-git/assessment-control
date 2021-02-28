@quizTotalNumberDoina @somke

  Feature: Quiz Total Number  Of Questions Scenarios
    Background:
      Given I go to "ask"
      When I enter "doina.qa922@gmail.com" into email field
      And I enter "Password123" into password field
      When  I click "Sign In" button
      And I wait for 1 sec
      Then I verify that user is logged in at "home" page
      And I verify that "Quizzes" button is present
      Then I click on "Quizzes" button byDI
      Then I wait for 1 sec


    @smoke1
       Scenario: Quiz Total Number Of Questions Happy Path
          And I click "Create New Quiz" button
          Then I wait for 1 sec
          Then I type "Total  Number of questions " into quiz title
          And I wait for 2 sec
          When I add 50 Textual questions
          Then I wait for 3 sec
          And I click "Save" byAK
          And I wait for 1 sec to see what's on the page
          Then I should see my quiz "Total  Number of questions" in the page
          Then I will click on quiz name
          And I delete "Total  Number of questions" quiz
          Then I confirm the deletion


    @smoke2
       Scenario: Quiz Total Number +1 Of Questions
         And I click "Create New Quiz" button
         And I wait for 1 sec
         Then I type "Total  Number of questions+1" into quiz title
         And I wait for 2 sec
         When I add 51 Textual questions
         Then I wait for 3 sec
         And I click "Save" byAK
         Then I should see the snak-bar

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
          And I click on "Assignments" button byDI
          Then I wait for 3 sec
          And I click "Create New Assignment" button
          Then I wait for 3 sec
          Then I choose a Student
          And I wait for 2 sec
          Then I select "Select Quiz To Assign"
          Then I select quiz  "Graded automatically"
          And I wait for 2 sec
          And  I click "Give Assignment" byDI
          Then I click on "Log Out" button byDI
          And I wait for 2 sec
          Then I click to "Log Out"
          And I wait for 3 sec
          When I enter "student1@test.com" into email field
          And I enter "12345" into password field
          When I click "Sign In" button
          And I wait for 1 sec
          Then I verify that user is logged in at "home" page
          And   I click on "My Assignments" button byDI
          When I choose "My Assignments"

          @smoke4
          Scenario: Delete Quiz
            And I wait for 1 sec to see what's on the page
            Then I should see my quiz "Total  Number of questions+1" in the page
            Then I will click on quiz name
            And I delete "Total  Number of questions+1" quiz
            Then I confirm the deletion











