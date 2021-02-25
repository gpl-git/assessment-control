@quizname @smoke
  Feature: Assignment Quiz Name Scenarios
    Background:
      Given I navigate to the page "ask"
      When I enter "ask_instr@aol.com" into the email field
      And I enter "12345" into the password field
      And I wait for  the 2 seconds
      And I click on the "Sign In" button
      And I wait for  the 2 seconds

      @quizname1
      Scenario: Validate that Teacher can give an Assignment to one Student
        Then I go to the "Assignment" page
        And I wait for  the 2 seconds
        Then I push the "Create New Assignment" button
        Then I select "Select Quiz To Assign" element
        And I wait for  the 2 seconds
        Then I choose "Quiz Name Test" quiz
        And I choose "Student"
        And I wait for  the 3 seconds
        Then I click the "Give Assignment" button
        And I wait for  the 2 seconds
        Then I logout from teacher acoount
        And confirm logout
        And I wait for  the 2 seconds
        Then I enter "student7@test.com" into the email field
        And I enter "12345" into the password field
        And I click on the "Sign In" button
        And I wait for  the 2 seconds
        Then I go to my assignments
        And I wait for  the 2 seconds
        And verify that I have "Quiz Name Test" assignment
        And I wait for  the 2 seconds
        Then I logout from teacher acoount
        And confirm logout
        And I wait for  the 2 seconds
        Given I navigate to the page "ask"
        When I enter "ask_instr@aol.com" into the email field
        And I enter "12345" into the password field
        And I wait for  the 2 seconds
        And I click on the "Sign In" button
        And I wait for  the 2 seconds
        Then I go to the "Assignment" page
        And I wait for  the 2 seconds
        Then I click on the button near Quiz Name Test assignment
        And I delete Quiz Name Test assignment
        And I wait for  the 2 seconds
        And I confirm that I want to delete assignment
        And I wait for  the 2 seconds







        
