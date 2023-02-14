@predefined
 Feature: ASK Demo

  @predefined1
   Scenario: Registration Demo
    Given I open "registration" website
    When I type "" into firstname field
    And I type "Smith" into lastname field
    When I type "abc@efg.com" into email field
    And I type "111" into group code field
    When  I type "12345" into password field
    Then I verify the password is masked
    And I type "12345" into confirmPassword field
    When I click "Register Me" button
    And I wait for 1 sec
    Then "This field is required" error message should be displayed
#    Then "You have been Registered." confirmation message should be displayed
    And I wait for 5 sec

  @predefined2
   Scenario: Quiz Demo
    Given I open "login" website
    When I type "ask_instr@aol.com" into email field
    When  I type "12345" into password field
    And I click "Sign In" button
    And I wait for 1 sec
    When I click "Quizzes" menu item
    And I wait for 1 sec
    And I click "Create New Quiz" button
    And I wait for 1 sec
    When I type "000 Quiz Demo" as quiz title
    Then I add question
    When I select "Single" question type
    When I type "Question 1" into "Q1"
    And I type "Option 1" into "Q1" as "Option 1*"
    And I type "Option 2" into "Q1" as "Option 2*"
    When I select "Option 1*" as correct option in "Q1"
    When I click "Save" button
    And I wait for 1 sec
    Then title "000 Quiz Demo" should be displayed on the list of quizzes
    And I delete quiz  "000 Quiz Demo"
    And I wait for 3 sec