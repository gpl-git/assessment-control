@quizTest
  Feature: Quiz Scenarios
    Background:
      Given First I open "login" page
      When I type email "jetta36@zubairnews.com" for teacher
      And I type "1234A" password
      When I click "Sign In"
      And I wait for 2 Sec
      Then "home" page displayed
      When I click on "Quizzes" menu
      And I wait for 2 Seconds

      @quiz1
      Scenario: Create a quiz
        When I click "Create New Quiz" button
        And I wait for 1 Seconds
        When I type context "Demo Quiz - -Automation" as quiz title
        And I add question
        When I select "Single" question type
        When I wait for 1 Sec
        When I enter "Question 1 text" into "Q1"
        And I type "Option 1" as "Option 1*" in "Q1" question
        And I type "Option 2" as "Option 2*" in "Q1" question
        Then I select "Option 1*" as correct in option "Q1"
        And I click "Save" button
        And I wait for 1 Seconds
        Then qiiz "Demo Quiz - -Automation" is displayed on the list of quizzes
        And  I delete quiz  "Demo Quiz - -Automation"