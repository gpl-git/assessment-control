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
      And I will wait for 2 sec
      And I Delete "Title of the Quiz" title of the quiz in input field
      And I click on plus sign "Add Quiz" on a page
      And I will wait for 2 sec
      And error message "This field is required" should be displayed

    @predefined3
    Scenario: 1000 alphanumeric characters
      When I enter 1000 alphanumeric characters
      And I click on plus sign "Add Quiz" on a page

    @predefined4
    Scenario: 1000+1 character
      When I type 1001 alphanumeric characters
      And I click on plus sign "Add Quiz" on a page
      And error message "Max length 1000 characters" should be displayed on a screen

    @predefined5
    Scenario: Space instead of input in quiz of title
      When I leave " " in title field
      And I click on plus sign "Add Quiz" on a page
      And  error message "Title can not be empty" should be displayed on a screen under input field

    @predefined6
    Scenario: happy path for Tile of the Quiz input field
      When I type "Q" into title quiz field
      And I click on plus sign "Add quiz" on a page














