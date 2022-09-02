@quiz @SC-Options
Feature: Single Choice Option
  Background:
    Given I go to "login" page
    When I type "ask_instr@aol.com" into email field
    And I type "12345" into password field
    When I click "Sign In" button
    And I wait for 1 sec
    When I click "Quizzes" menu item
    And I wait for 1 sec
    When I click "Create New Quiz" button
    And I wait for 1 sec
    When I type "Single Choice Option Sandra" as quiz title
    And I add a question
    When I select "Single" question type
    And I wait for 5 sec
    When I enter "Question 1 Text" into "Q1"

  @SC-Options1
  Scenario: Check if 15 options are accepted
    And I type "1" as "Option 1*" into "Q1"
    And I type "2" as "Option 2*" into "Q1"
    And I add an option
    And I wait for 1 sec
    And I type "3" as "Option 3*" into "Q1"
    And I add an option
    And I wait for 1 sec
    And I type "4" as "Option 4*" into "Q1"
    And I add an option
    And I wait for 1 sec
    And I type "5" as "Option 5*" into "Q1"
    And I add an option
    And I type "6" as "Option 6*" into "Q1"
    And I add an option
    And I type "7" as "Option 7*" into "Q1"
    And I add an option
    And I type "8" as "Option 8*" into "Q1"
    And I add an option
    And I type "9" as "Option 9*" into "Q1"
    And I add an option
    And I type "10" as "Option 10*" into "Q1"
    And I add an option
    And I type "11" as "Option 11*" into "Q1"
    And I add an option
    And I type "12" as "Option 12*" into "Q1"
    And I add an option
    And I type "13" as "Option 13*" into "Q1"
    And I add an option
    And I type "14" as "Option 14*" into "Q1"
    And I add an option
    And I type "15" as "Option 15*" into "Q1"
    When I select "Option 2*" as correct option in "Q1"
    When I click "Save" button
    And I wait for 3 sec
    Then I verify that "Single Choice Option Sandra" is displayed on the list of quizzes
    And I wait for 5 sec
    And I delete "Single Choice Option Sandra" from the list of quizzes
  @SC-Options2
  Scenario: 16 options are not accepted
    When I type "1" as "Option 1*" into "Q1"
    And I type "2" as "Option 2*" into "Q1"
    When I select "Option 2*" as correct option in "Q1"
    And I add an option
    And I wait for 1 sec
    And I type "3" as "Option 3*" into "Q1"
    And I add an option
    And I wait for 1 sec
    And I type "4" as "Option 4*" into "Q1"
    And I add an option
    And I wait for 1 sec
    And I type "5" as "Option 5*" into "Q1"
    And I add an option
    And I type "6" as "Option 6*" into "Q1"
    And I add an option
    And I type "7" as "Option 7*" into "Q1"
    And I add an option
    And I type "8" as "Option 8*" into "Q1"
    And I add an option
    And I type "9" as "Option 9*" into "Q1"
    And I add an option
    And I type "10" as "Option 10*" into "Q1"
    And I add an option
    And I type "11" as "Option 11*" into "Q1"
    And I add an option
    And I type "12" as "Option 12*" into "Q1"
    And I add an option
    And I type "13" as "Option 13*" into "Q1"
    And I add an option
    And I type "14" as "Option 14*" into "Q1"
    And I add an option
    And I type "15" as "Option 15*" into "Q1"
    And "Add option" button is disabled
#    system accepts more then 15 options, it's a bug
    When I click "Save" button
    And I wait for 3 sec
    Then I verify that "Single Choice Option Sandra" is displayed on the list of quizzes
    And I wait for 5 sec
    And I delete "Single Choice Option Sandra" from the list of quizzes

  @SC-Option3
  Scenario: Minimum 2 options
    When I type "1" as "Option 1*" into "Q1"
    And I select "Option 1*" as correct option in "Q1"
    When I click "Save" button
    Then error message appear

  @SC-Option4
  Scenario: Maximum 1000 characters in option
    When I type "1" as "Option 1*" into "Q1"
    And I type "Test OP A while back I needed to count the amount of letters that a piece of text in an email template had (to avoid passing any character limits). Unfortunately, I could not think of a quick way to do so on my macbook and I therefore turned to the Internet.Test OP A while back I needed to count the amount of letters that a piece of text in an email template had (to avoid passing any character limits). Unfortunately, I could not think of a quick way to do so on my macbook and I therefore turned to the Internet.Test OP A while back I needed to count the amount of letters that a piece of text in an email template had (to avoid passing any character limits). Unfortunately, I could not think of a quick way to do so on my macbook and I therefore turned to the Internet.Test OP A while back I needed to count the amount of letters that a piece of text in an email template had (to avoid passing any character limits). Unfortunately, I could not think of a quick way to do so on my macbook and I t" as "Option 2*" into "Q1"
    When I select "Option 2*" as correct option in "Q1"
    When I click "Save" button
    And I wait for 3 sec
    Then I verify that "Single Choice Option Sandra" is displayed on the list of quizzes
    And I wait for 5 sec
    And I delete "Single Choice Option Sandra" from the list of quizzes

  @SC-Option4
  Scenario: 1001 characters for the option
    When I type "1" as "Option 1*" into "Q1"
    And I type "Test OP A while back I needed to count the amount of letters that a piece of text in an email template had (to avoid passing any character limits). Unfortunately, I could not think of a quick way to do so on my macbook and I therefore turned to the Internet.Test OP A while back I needed to count the amount of letters that a piece of text in an email template had (to avoid passing any character limits). Unfortunately, I could not think of a quick way to do so on my macbook and I therefore turned to the Internet.Test OP A while back I needed to count the amount of letters that a piece of text in an email template had (to avoid passing any character limits). Unfortunately, I could not think of a quick way to do so on my macbook and I therefore turned to the Internet.Test OP A while back I needed to count the amount of letters that a piece of text in an email template had (to avoid passing any character limits). Unfortunately, I could not think of a quick way to do so on my macbook and I to" as "Option 2*" into "Q1"
    When I select "Option 2*" as correct option in "Q1"
    When I click "Save" button
    Then error message appear
#    Bug again
  @SC-Option5
  Scenario: User can delete an option
    When I type "1" as "Option 1*" into "Q1"
    And I type "2" as "Option 2*" into "Q1"
    When I select "Option 2*" as correct option in "Q1"
    And I add an option
    And I type "3" as "Option 3*" into "Q1"
    And I wait for 2 sec
    And I delete "Option 3*" from the quiz
    And I check that "Option 2*" is present
    Then I check that "Option 1*" is present


