@optionTesting
Feature: Single Choise Question options automation

  Background:
    Given I open "login" page
    When I type "shamdag@24hinbox.com" for teacher user
    And I type "qazwsxedc" as password
    When I click "Sign In" button
    And I wait for 1 sec
    Then "home" page will be displayed
    When I click on "Quizzes" menu item
    And I wait for 1 sec


  @optionTesting1
  Scenario: [SEP22-414] Option text field accepts 1000 characters (Assertion Passed)
    Then I click "Create New Quiz" button
    And I wait for 1 sec
    Then I type "111Maksym Demo Quiz - Automation" as quiz title
    And I add a question
    Then I select "Single" question
    And I wait for 1 sec
    Then I type " This is a Question 1" into "Q1"
    Then I wait for 3 sec
    And I enter 1000 alphanumeric characters to "Option 1*" in "Q1"
    And I enter 1000 alphanumeric characters to "Option 2*" in "Q1"
    Then I select "Option 1*" as correct option in "Q1"
    Then I wait for 2 sec
    Then question "Q1" option "Option 1*" should contain 1000 characters ASSERTION
    Then question "Q1" option "Option 2*" should contain 1000 characters ASSERTION
    And I click "Save" button
    And I wait for 3 sec
    Then quiz "111Maksym Demo Quiz - Automation" is displayed on the list of quizzes
    And I delete quiz "Demo Quiz - Automation"


  @optionTesting2
  Scenario: [SEP22-416] Option text field doesn't accept 1001 characters (Assertion Passed)
    Then I click "Create New Quiz" button
    And I wait for 1 sec
    Then I type "111Maksym Demo Quiz - Automation" as quiz title
    And I add a question
    Then I select "Single" question
    And I wait for 1 sec
    Then I type " This is a Question 1" into "Q1"
    And I enter 1001 alphanumeric characters to "Option 1*" in "Q1"
    And I enter 1001 alphanumeric characters to "Option 2*" in "Q1"
    Then I select "Option 1*" as correct option in "Q1"
    Then I wait for 2 sec
    Then question "Q1" option "Option 1*" should contain 1001 characters ASSERTION
    Then question "Q1" option "Option 2*" should contain 1001 characters ASSERTION
    Then the error message "No more than 1001 characters required" should be displayed
#    [Bug Report: https://jira.portnov.com/browse/SEP22-706  ]
#  
#

  @optionTesting3
  Scenario: [SEP22-419] Option text field accepts 1 character (Assertion Passed)
    And I wait for 1 sec
    Then I click "Create New Quiz" button
    And I wait for 1 sec
    Then I type "111Maksym Demo Quiz - Automation" as quiz title
    And I add a question
    Then I select "Single" question
    And I wait for 1 sec
    Then I type " This is a Question 1" into "Q1"
    And I type "1" as "Option 1*" in "Q1"
    And I type "1" as "Option 2*" in "Q1"
    Then I select "Option 1*" as correct option in "Q1"
    Then I wait for 2 sec
    Then question "Q1" option "Option 1*" should contain "1" Assertion
    And I click "Save" button
    And I wait for 3 sec
    Then quiz "111Maksym Demo Quiz - Automation" is displayed on the list of quizzes
    And I delete quiz "111Maksym Demo Quiz - Automation"


  @optionTesting4
  Scenario: [SEP22-421] Unable to create a Single choice question with an empty Option text field (Assertion Passed)
    Then I click "Create New Quiz" button
    And I wait for 1 sec
    Then I type "111Maksym Demo Quiz - Automation" as quiz title
    And I add a question
    Then I select "Single" question
    And I wait for 1 sec
    Then I type " This is a Question 1" into "Q1"
    Then I select "Option 1*" as correct option in "Q1"
    Then I click on "Save" button
    Then I wait for 2 sec
    Then warning message should appear
    And I wait for 1 sec


  @optionTesting5
  Scenario: [SEP22-423] Option text field accepts special characters (Passed)
    Then I click "Create New Quiz" button
    And I wait for 1 sec
    Then I type "111Maksym Demo Quiz - Automation" as quiz title
    And I add a question
    Then I select "Single" question
    And I wait for 1 sec
    Then I type "This is a Question 1" into "Q1"
    And I type "@" as "Option 1*" in "Q1"
    And I type "@" as "Option 2*" in "Q1"
    Then I select "Option 1*" as correct option in "Q1"
    Then I wait for 1 sec
    Then I click on "Save" button
    And I wait for 3 sec
    Then quiz "111Maksym Demo Quiz - Automation" is displayed on the list of quizzes
    And I delete quiz "111Maksym Demo Quiz - Automation"

  @optionTesting6
  Scenario: [SEP22-424] Options could be deleted (Assertion Passed)
    Then I click "Create New Quiz" button
    And I wait for 1 sec
    Then I type "111Maksym Demo Quiz - Automation" as quiz title
    And I add a question
    Then I select "Single" question
    And I wait for 1 sec
    Then I type "This is a Question 1" into "Q1"
    Then I type "#1" as "Option 1*" in "Q1"
    And I wait for 1 sec
    Then I type "#2" as "Option 2*" in "Q1"
    Then I select "Option 1*" as correct option in "Q1"
    And I click on "Add Option" button
    Then I wait for 1 sec
    And  I click on "Add Option" button
    And I wait for 1 sec
    Then number of options is equal to 4
    Then I delete input field for option "Option 4*"
    And I wait for 1 sec
    Then I delete input field for option "Option 3*"
    Then number of options is equal to 2
    And I wait for 1 sec
    Then I click on "Save" button
    And I wait for 3 sec
    Then quiz "111Maksym Demo Quiz - Automation" is displayed on the list of quizzes
    And I delete quiz "111Maksym Demo Quiz - Automation"


  @optionTesting7
  Scenario: [SEP22-431] >15  options can be added to question in Single Choice question (Assertion passed)
    Then I click "Create New Quiz" button
    And I wait for 1 sec
    Then I type "111Maksym Demo Quiz - Automation" as quiz title
    And I add a question
    Then I select "Single" question
    And I wait for 1 sec
    Then I type "This is a Question #1 " into "Q1"
    And I type "@" as "Option 1*" in "Q1"
    And I type "@" as "Option 2*" in "Q1"
    Then I wait for 1 sec
    And I add 15 options to question "Q1"
    Then I wait for 1 sec
    Then I select "Option 15*" as correct option in "Q1"
    Then I wait for 3 sec
    Then number of options is equal to 15
    Then I click on "Save" button
    And I wait for 3 sec
    Then quiz "111Maksym Demo Quiz - Automation" is displayed on the list of quizzes
    And I delete quiz "111Maksym Demo Quiz - Automation"


  @optionTesting8
  Scenario: [SEP22-427] Options could be moved up (Assertions passed)
    Then I click "Create New Quiz" button
    And I wait for 1 sec
    Then I type "111Maksym Demo Quiz - Automation" as quiz title
    And I add a question
    Then I select "Single" question
    And I wait for 1 sec
    Then I type "This is a Question #1 " into "Q1"
    Then I wait for 2 sec
    Then I type "#1" as "Option 1*" in "Q1"
    Then I wait for 1 sec
    Then I type "#2" as "Option 2*" in "Q1"
    Then I wait for 1 sec
    Then I select "Option 1*" as correct option in "Q1"
    Then I wait for 1 sec
    And I add 3 options to question "Q1"
    Then I wait for 2 sec
    Then number of options is equal to 3
    Then I clear "Q1" option "Option 3*" text field
    Then I wait for 1 sec
    Then I type "------ moving question #3------" as "Option 3*" in "Q1"
    Then I wait for 2 sec
    Then I move up option "Option 3*"
    Then I wait for 1 sec
    Then question "Q1" option "Option 2*" should contain "------ moving question #3------" Assertion
    Then I wait for 1 sec
    Then I click on "Save" button
    And I wait for 3 sec
    Then quiz "111Maksym Demo Quiz - Automation" is displayed on the list of quizzes
    And I delete quiz "111Maksym Demo Quiz - Automation"


  @optionTesting9
  Scenario: [SEP22-425] Options could be moved down (Assertion passed)
    Then I click "Create New Quiz" button
    And I wait for 1 sec
    Then I type "111Maksym Demo Quiz - Automation" as quiz title
    And I add a question
    Then I select "Single" question
    And I wait for 1 sec
    Then I type "This is a Question #1 " into "Q1"
    Then I wait for 1 sec
    Then I type "#1" as "Option 1*" in "Q1"
    Then I select "Option 1*" as correct option in "Q1"
    Then I wait for 1 sec
    Then I type "------ moving question #2------" as "Option 2*" in "Q1"
    Then I wait for 1 sec
    And I add 3 options to question "Q1"
    Then I wait for 2 sec
    Then number of options is equal to 3
    Then I wait for 2 sec
    Then I move down option "Option 2*"
    Then I wait for 2 sec
    Then question "Q1" option "Option 3*" should contain "------ moving question #2------" Assertion
    Then I wait for 2 sec
    Then I click on "Save" button
    And I wait for 3 sec
    Then quiz "111Maksym Demo Quiz - Automation" is displayed on the list of quizzes
    And I delete quiz "111Maksym Demo Quiz - Automation"


