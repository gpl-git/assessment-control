@quizTitle
  Feature: Quiz Title Scenarios
    Background:
      Given I open "login" website
      When I type "gnwjdu@gotcertify.com" into email field
      When  I type "12345" into password field
      And I click "Sign In" button
      And I wait for 1 sec
      When I click "Quizzes" menu item
      And I wait for 1 sec
      And I click "Create New Quiz" button
      And I wait for 1 sec

    @quizTitle1 @regression
    Scenario: Quiz Title: Happy Path
      When I type "What is SQL?" as quiz title
      Then I add question
      When I select "Single" question type
      When I type "Question 1" into "Q1"
      And I type "Option 1" into "Q1" as "Option 1*"
      And I type "Option 2" into "Q1" as "Option 2*"
      When I select "Option 1*" as correct option in "Q1"
      When I click "Save" button
      And I wait for 2 sec
      Then title "What is SQL?" should be displayed on the list of quizzes
      And I wait for 2 sec
      And I delete quiz  "What is SQL?"
      And I wait for 2 sec

    @quizTitle2
    Scenario: Quiz Title: Allowable characters: Alphanumeric & Sp. characters
      When I type "123qwe!@#" as quiz title
      Then I add question
      When I select "Single" question type
      When I type "Question 1" into "Q1"
      And I type "Option 1" into "Q1" as "Option 1*"
      And I type "Option 2" into "Q1" as "Option 2*"
      When I select "Option 1*" as correct option in "Q1"
      When I click "Save" button
      And I wait for 2 sec
      Then title "123qwe!@#" should be displayed on the list of quizzes
      And I wait for 2 sec
      And I delete quiz  "123qwe!@#"
      And I wait for 2 sec

  @quizTitle3
  Scenario: Quiz Title: Error Message "The field is required"
    When I click Title Of The Quiz field
    And I click outside of the title field
    And I wait for 1 sec
    Then error-message "This field is required" should be displayed
    And I wait for 1 sec
    When I type "123" as quiz title
    Then I clear quiz title
    And I wait for 1 sec
    Then error-message "This field is required" should be displayed
    And I wait for 1 sec

  @quizTitle4
  Scenario: Quiz Title: Min 1 Character
    When I type "A" as quiz title
    Then I add question
    When I select "Single" question type
    When I type "Question 1" into "Q1"
    And I type "Option 1" into "Q1" as "Option 1*"
    And I type "Option 2" into "Q1" as "Option 2*"
    When I select "Option 1*" as correct option in "Q1"
    When I click "Save" button
    And I wait for 2 sec
    Then title "A" should be displayed on the list of quizzes
    And I wait for 2 sec
    And I delete quiz  "A"
    And I wait for 2 sec

  @quizTitle5
  Scenario: Quiz Title: text field accepts space as a MIN 1 character
    When I type " " as quiz title
    And I wait for 1 sec
    Then error-message "Min 1 Characters" should be displayed
    And I wait for 1 sec
#  Known issue JAN23-530 (duplicated JAN23-415)

  @quizTitle6
    Scenario: Quiz Title: Accepts space as min 1 characters on List of Quizzes
    When I type " " as quiz title
    Then I add question
    When I select "Single" question type
    When I type "Question 1" into "Q1"
    And I type "Option 1" into "Q1" as "Option 1*"
    And I type "Option 2" into "Q1" as "Option 2*"
    When I select "Option 1*" as correct option in "Q1"
    When I click "Save" button
    And I wait for 2 sec
    Then title " " should be displayed on the list of quizzes
    And I wait for 2 sec
    And I delete quiz  " "
    And I wait for 2 sec
#Need bug report


  @quizTitle7
  Scenario: Quiz Title: Max 1000 Characters
    When I type 1000 characters as "Quiz title"
    Then I add question
    When I select "Single" question type
    When I type "Question 1" into "Q1"
    And I type "Option 1" into "Q1" as "Option 1*"
    And I type "Option 2" into "Q1" as "Option 2*"
    When I select "Option 1*" as correct option in "Q1"
    When I click "Save" button
    And I wait for 2 sec
    Then title with 1000 characters should be displayed on the list of quizzes
    And I wait for 2 sec
    And I delete quiz with 1000 characters
    And I wait for 2 sec
    And I wait for 2 sec


  @quizTitle8
  Scenario: Quiz Title: Max 1000+1 characters
    When I type 1001 characters as "Quiz Title"
    Then error-message "Max 1000 characters" should be displayed
    And I wait for 2 sec
#   Known issue JAN23-432

  @quizTitle9
  Scenario: Quiz Title: Leading and trailing space characters to be eliminated when Quiz is saved in the List of Quizzes
    When I type "   What is your background ?  " as quiz title
    Then I add question
    When I select "Single" question type
    When I type "Question 1" into "Q1"
    And I type "Option 1" into "Q1" as "Option 1*"
    And I type "Option 2" into "Q1" as "Option 2*"
    When I select "Option 1*" as correct option in "Q1"
    When I click "Save" button
    And I wait for 1 sec
    Then title "   What is your background ?  " should be displayed on the list of quizzes
    And I wait for 3 sec
#    Then I "how to verify that is no spaces on created quiz title"
#    Known Issues JAN23-433






