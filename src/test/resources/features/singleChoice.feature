@predefined
 Feature: Single-Choice question

 Background:
  Given I open "login" website
  When I type "zakarpoghosyan@gmail.com" into email field
  When  I type "12345" into password field
  And I click "Sign In" button
  And I wait for 1 sec
  When I click "Quizzes" menu item
  And I wait for 1 sec
  And I click "Create New Quiz" button
  And I wait for 1 sec
  When I type "Quiz Demo by Zakar" as quiz title
  Then I add question
  When I select "Single" question type

  @predefined1
   Scenario: The field is required
    When I select "Option 1*" as correct option in "Q1"
    And I type "Option 1" into "Q1" as "Option 1*"
    And I type "Option 2" into "Q1" as "Option 2*"
    When I click "Save" button
    Then "This field is required" error message should be displayed

  @predefined2
   Scenario: Alphanumeric & special characters
    When I type "Abc!@#$%^&*’()-_=+;:,<.>/?123" into "Q1"
    When I select "Option 1*" as correct option in "Q1"
    And I type "Option 1" into "Q1" as "Option 1*"
    And I type "Option 2" into "Q1" as "Option 2*"
    When I click "Save" button
    And I wait for 2 sec
    Then title "Quiz Demo by Zakar" should be displayed on the list of quizzes
    And I delete quiz  "Quiz Demo by Zakar"

  @predefined3
   Scenario: Min 1 characters
    When I type 1 characters into "Q1"
    When I select "Option 1*" as correct option in "Q1"
    And I type "Option 1" into "Q1" as "Option 1*"
    And I type "Option 2" into "Q1" as "Option 2*"
    When I click "Save" button
    And I wait for 2 sec
    Then title "Quiz Demo by Zakar" should be displayed on the list of quizzes
    And I delete quiz  "Quiz Demo by Zakar"

  @predefined4
   Scenario: Max 1000 characters
    When I type 1000 characters into "Q1"
    When I select "Option 1*" as correct option in "Q1"
    And I type "Option 1" into "Q1" as "Option 1*"
    And I type "Option 2" into "Q1" as "Option 2*"
    When I click "Save" button
    And I wait for 2 sec
    Then title "Quiz Demo by Zakar" should be displayed on the list of quizzes
    And I delete quiz  "Quiz Demo by Zakar"

  @predefined5
   Scenario: Max plus 1 character (Bug: JAN23-616)
    When I type 1001 characters into "Q1"
    When I select "Option 1*" as correct option in "Q1"
    And I type "Option 1" into "Q1" as "Option 1*"
    And I type "Option 2" into "Q1" as "Option 2*"
    Then "Max 1000 characters are allowed" error message should be displayed

  @predefined6
   Scenario: Max 15 options
    When I type 1 characters into "Q1"
    When I select "Option 1*" as correct option in "Q1"
    And I type "Option 1" into "Q1" as "Option 1*"
    And I type "Option 2" into "Q1" as "Option 2*"
    And I add up to 15 options in "Q1"
    When I click "Save" button
    And I wait for 2 sec
    Then title "Quiz Demo by Zakar" should be displayed on the list of quizzes
    And I delete quiz  "Quiz Demo by Zakar"

  @predefined7
   Scenario: Max plus 1 option (Bug: JAN23-179)
    When I type 1 characters into "Q1"
    When I select "Option 1*" as correct option in "Q1"
    And I type "Option 1" into "Q1" as "Option 1*"
    And I type "Option 2" into "Q1" as "Option 2*"
    And I add up to 16 options in "Q1"
    Then "Max 15 options are allowed" error message should be displayed