@quiz
Feature: Quiz Scenarios

  Background:
    Given I open "login" page
    When I type "shamdag@24hinbox.com" for teacher user
    And I type "qazwsxedc" as password
    When I click "Sign In" button
    And I wait for 1 sec
    Then "home" page will be displayed
    When I click on "Quizzes" menu item
    And I wait for 1 sec


  @quiz1
  Scenario: [SEP22-414] Option text field accepts 1000 characters (Assertion Passed)
    When I click "Create New Quiz" button
    And I wait for 1 sec
    When I type "111Maksym Demo Quiz - Automation" as quiz title
    And I add a question
    When I select "Single" question
    And I wait for 1 sec
    When I type " This is a Question 1" into "Q1"
    And I type "1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000ch" as "Option 1*" in "Q1"
    And I type "1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000ch" as "Option 2*" in "Q1"
    Then I select "Option 1*" as correct option in "Q1"
    Then I wait for 2 sec
    Then question "Q1" option "Option 1*" should contain "1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000ch" characters Assertion
     And I click "Save" button
     And I wait for 1 sec
     Then quiz "Demo Quiz - Automation" is displayed on the list of quizzes
     And I delete quiz "Demo Quiz - Automation"


  @quiz2
  Scenario: [SEP22-416] Option text field doesn't accept 1001 characters (Assertion Failed)
    When I click "Create New Quiz" button
    And I wait for 1 sec
    When I type "111Maksym Demo Quiz - Automation" as quiz title
    And I add a question
    When I select "Single" question
    And I wait for 1 sec
    When I type " This is a Question 1" into "Q1"
    And I type "1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001cha" as "Option 1*" in "Q1"
    And I type "1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001cha" as "Option 2*" in "Q1"
    Then I select "Option 1*" as correct option in "Q1"
    Then I wait for 2 sec
    Then question "Q1" option "Option 1*" should not contain "1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001cha" characters Assertion
    And I click "Save" button
    And I wait for 1 sec
    Then quiz "Demo Quiz - Automation" is displayed on the list of quizzes
    And I delete quiz "Demo Quiz - Automation"




  @quiz3
  Scenario: [SEP22-419] Option text field accepts 1 character (Assertion Passed)
    When I click "Create New Quiz" button
    And I wait for 1 sec
    When I type "111Maksym Demo Quiz - Automation" as quiz title
    And I add a question
    When I select "Single" question
    And I wait for 1 sec
    When I type " This is a Question 1" into "Q1"
    And I type "1" as "Option 1*" in "Q1"
    And I type "1" as "Option 2*" in "Q1"
    Then I select "Option 1*" as correct option in "Q1"
    Then I wait for 2 sec
    Then question "Q1" option "Option 1*" should contain "1" characters Assertion
    And I click "Save" button
    And I wait for 1 sec
    Then quiz "Demo Quiz - Automation" is displayed on the list of quizzes
    And I delete quiz "Demo Quiz - Automation"



  @quiz4
  Scenario: [SEP22-421] Unable to create a Single choice question with an empty Option text field (Assertion Passed)
    When I click "Create New Quiz" button
    And I wait for 1 sec
    When I type "111Maksym Demo Quiz - Automation" as quiz title
    And I add a question
    When I select "Single" question
    And I wait for 1 sec
    When I type " This is a Question 1" into "Q1"
    Then I select "Option 1*" as correct option in "Q1"
   Then I click on "Save" button
    Then I wait for 2 sec
    Then warning message should appear
    And I wait for 1 sec


  @quiz5
  Scenario: [SEP22-423] Option text field accepts special characters (Passed)
    When I click "Create New Quiz" button
     And I wait for 1 sec
    When I type "111Maksym Demo Quiz - Automation" as quiz title
    And I add a question
    When I select "Single" question
    And I wait for 1 sec
    When I type "This is a Question 1" into "Q1"
    And I type "@" as "Option 1*" in "Q1"
    And I type "@" as "Option 2*" in "Q1"
    Then I select "Option 1*" as correct option in "Q1"
    Then I wait for 1 sec
    Then I click on "Save" button
    And I wait for 1 sec
    Then quiz "Demo Quiz - Automation" is displayed on the list of quizzes
    And I delete quiz "Demo Quiz - Automation"

  @quiz6
  Scenario: [SEP22-424] Options could be deleted (Passed)
    When I click "Create New Quiz" button
    And I wait for 1 sec
    When I type "111Maksym Demo Quiz - Automation" as quiz title
    And I add a question
    When I select "Single" question
    And I wait for 1 sec
    When I type "This is a Question 1" into "Q1"
    And I click on "Add Option" button
    Then I wait for 1 sec
    And  I click on "Add Option" button
    And I wait for 1 sec
    Then I click on element with xpath "//ac-question-body-form/div[1]/div[2]/div[1]/mat-radio-group[4]/button[1]/span[1]/mat-icon[1]"
    And I wait for 1 sec
    Then I click on element using JavaScript with xpath "//*[text()='Delete Option']"
    And I wait for 1 sec
    Then I click on element with xpath "//ac-question-body-form/div[1]/div[2]/div[1]/mat-radio-group[3]/button[1]/span[1]/mat-icon[1]"
    And I wait for 1 sec
    Then I click on element using JavaScript with xpath "//*[text()='Delete Option']"
    And I wait for 1 sec

@quiz7
Scenario: [SEP22-431] >15  options can be added to question in Single Choice question (Assertion passed)
  When I click "Create New Quiz" button
  And I wait for 1 sec
  When I type "111Maksym Demo Quiz - Automation" as quiz title
  And I add a question
  When I select "Single" question
  And I wait for 1 sec
  When I type "This is a Question #1 " into "Q1"
  Then I wait for 2 sec
  And I add 18 options to question "Q1"
  Then I wait for 1 sec
  Then in question "Q1" option number "Option 18*" should be present
  Then I wait for 3 sec