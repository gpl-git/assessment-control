@multipleTest
  Feature: Multiple Choice Question Test Behavior
    Background:
      Given I navigate to "login" page
      When I type "ajskrim@teeenye.com" into email field
      And I enter "12345" as password
      When I click button "Sign In"
      And I wait for 1 sec
      When I click "Quizzes" menu item
      And I wait for 2 sec

    @multipleTest1
    Scenario: Create Multiple Choice Question Test
      When I click button "Create New Quiz"
      And I wait for 1 sec
      When I type "1 K 2" as quiz title
      And I add a question
      And I wait for 1 sec
      When I select "Multiple" question type
      And I type "The old capital of the U.S." into "Q1"
      When I type "Washington" as "Option 1*" into "Q1"
      And I type "New York" as "Option 2*" into "Q1"
      Then I add option
      Then I type "Philadelphia" as "Option 3*" into "Q1"
      And I add option
      Then I type "Boston" as "Option 4*" into "Q1"
      And I check "Option 3*" as correct option in "Q1"
      Then I select "Include "Other" text area option for this question?" as right option in "Q1"
      When I click button "Save"
      And I wait for 1 sec
      Then quiz "1 K 2" should be shown on the list of quizzes
      And I preview "1 K 2" quiz it shows the "Other" option
      And I wait for 1 sec
      Then I go back to "1 K 2"
      When I remove the "1 K 2" quiz
      And I wait for 1 sec


