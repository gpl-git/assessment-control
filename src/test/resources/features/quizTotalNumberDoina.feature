@quizTotalNumberDoina @somke

  Feature: Quiz Total Number Scenarios

    @smoke
       Scenario: Quiz Total Number Happy Path
         Given I go to "ask"
         When I enter "doina.qa922@gmail.com" into email field
         And I enter "Password123" into password field
         When  I click "Sign In" button
         And I wait for 1 sec
         Then I verify that user is logged in at "home" page
         And I verify that "Quizzes" button is present
         Then I click on "Quizzes" button
         Then  I wait for 1 sec
         And I verify that Quizzes "mat-card" is displayed
         And I click on "Create New quiz" tab


