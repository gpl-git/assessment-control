@showStopperAsterisk1
Feature: Textual Questions - Show - Stopper Asterisk, only one can be Show - Stopper

  Scenario: Textual Show-Stopper
    Given I go to "login" page
    When I type "qa.sofi@gmail.com" into email field
    And I type "12345" into password field
    When I click "Sign In" button
    And I wait for 1 sec
    When I click "Quizzes" menu item
    And I wait for 1 sec
    And I click "Create New Quiz" button
    And I wait for 1 sec
    When I type "Asterisk" in title field

    # Q1
    And I add question
    Then I pick "Textual" question type
    And I wait for 3 sec
    When I type "What is Software Quality Assurance?" into textarea of "Q1"
    And I check showstopper for "Q1"
    And I wait for 1 sec
    Then "Q1" should have asterisk

    # Q2
    And I add question
    And I wait for 2 sec
    Then I pick "Textual" question type
    And I wait for 3 sec
    When I type "Q2 Q2 What is Software Quality Assurance?" into textarea of "Q2"
    And I wait for 1 sec
    And I check showstopper for "Q2"
    And I wait for 1 sec
    Then "Q2" should have asterisk

    # Q3
    And I add question
    And I wait for 2 sec
    Then I pick "Textual" question type
    And I wait for 3 sec
    When I type "Q3 Question3 ?" into textarea of "Q3"
    And I wait for 1 sec
    And I check showstopper for "Q3"
    And I wait for 1 sec
    Then "Q3" should have asterisk

    # Make sure that only one questions is Show-Stopper  
    Then "Q1" should not have the asterisk
    Then "Q2" should not have the asterisk
    And I click "Save" button
    And I wait for 3 sec

    # The questions has text on the red background "Show-Stopper questions"
    Then title "Asterisk" is displayed on the list of quizzes
    And I wait for 2 sec
    And I click on the quiz "Asterisk"
    Then I click "Preview" on quiz
    And "Question 3 / 3" should have text "Show-Stopper Question"

    #delete the quiz
    And I click "Close" button
    And I wait for 2 sec
    And I click "Delete" on quiz
    And I wait for 2 sec
    And I confirm delete
    And I wait for 2 sec

#    And I delete "Asterisk" from the list of quizzes