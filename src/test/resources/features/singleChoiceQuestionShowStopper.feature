@questions
  Feature: Single Questions Scenarios
    Background: 
      Given I go to the page "ask"
      And I enter "student4@test.com" into email field
      And I enter "12345" into password field
      When I click "Sign in" button
      And I wait for 1 sec