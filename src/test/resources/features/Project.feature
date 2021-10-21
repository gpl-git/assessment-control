@predefined
  Feature: Quiz
    Background:
      Given I navigate to sign in "quiz" page
      Then I should see page title contains "Assessment Control @ Portnov"
      Then I log in as a teacher with valid credentials where email is "uamitfo@filevino.com" and password is"v1111"
      And I will click "Sign In" button
      And I will wait for 2 sec
      When I click on "Quizzes" menu in a left corner of the screen
      And I will wait for 2 sec
      And I will click "Create New Quiz" button
      And I will wait for 2 sec

    @predefined1
    Scenario: Allowable characters: Alphanumeric & Sp. characters
      And I type "Title of the Quiz" in a quiz title field

    @predefined2
    Scenario: The field is required
      And I enter "Title of the Quiz"







