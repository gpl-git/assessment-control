@LawShowStopper
Feature: Automate Single Choice Question - Showstopper
  Background:
    Given I go to "ASK Login"
    When I type "britters@colevillecapital.com" into e-input Law
    Then I type "abc123" into p-input Law
    Then I click "Sign In" btn Law
    And I wait for 3 sec
    And I click "Quizzes" menu item
    And I wait for 2 sec

  @lawshowstopper1
  Scenario: Test Set 1 Verify Question is a Showstopper (Create a quiz)
    When I click "Create New Quiz" button
    And I wait for 2 sec
    When I type "Law Showstopper" as title for Quiz
    Then I add the first question Law
    When I select "Single" question type
    And I wait for 2 sec
    And I type "q1" into qfield of "Q1"
    When I type "a1" into "Option 1" option field of "Q1"
    And I type "a2" into "Option 2" option field of "Q1"
    And I wait for 2 sec
    Then I click on "a1" as correct answer Law
    And I wait for 2 sec
    When I check "Show-stopper" in "Q1" Law
    And I wait for 2 sec
    #TestSet1 (Showstopper * should be required)
    Then "Q1" displays "*" as a showstopper
    And I wait for 2 sec
    And I click "Save" button
    And I wait for 2 sec
    Then "Law Showstopper" is displayed on the list of quizzes
    And I delete "Law Showstopper" from the list of quizzes

  @lawshowstopper2
  Scenario: Test Set 2 Verify only 1 Showstopper Question per Quiz
    When I click "Create New Quiz" button
    And I wait for 2 sec
    When I type "Law Showstopper" as title for Quiz
    Then I add the first question Law
    When I select "Single" question type
    And I wait for 2 sec
    And I type "q1" into qfield of "Q1"
    When I type "a1" into "Option 1" option field of "Q1"
    And I type "a2" into "Option 2" option field of "Q1"
    And I wait for 2 sec
    Then I click on "a1" as correct answer Law
    And I wait for 2 sec
    When I check "Show-stopper" in "Q1" Law
    And I wait for 2 sec
    Then "Q1" displays "*" as a showstopper
    And I wait for 2 sec
    Then I add the second question Law
    When I select "Single" question type
    And I wait for 12 sec
    And I type "q2" into question field of "Q2"
    When I type "a1" into "Option 1" option field of "Q2"
    And I type "a2" into "Option 2" option field of "Q2"
    And I wait for 4 sec
#    Then I click "a1" button as answer Law
#    And I wait for 2 sec
    Then I click "Show-stopper" in "Q2" Law
    And I wait for 2 sec
    Then "Q2" displays "*" as a showstopper
    And I wait for 2 sec
    And I click "Save" button
    And I wait for 2 sec
    Then "Law Showstopper" is displayed on the list of quizzes
    And I delete "Law Showstopper" from the list of quizzes

  @lawshowstopper3
  Scenario: Test Set 3 Verify Showstopper is shown in Preview
    When I click "Create New Quiz" button
    And I wait for 2 sec
    When I type "Law Showstopper" as title for Quiz
    Then I add the first question Law
    When I select "Single" question type
    And I wait for 2 sec
    And I type "q1" into qfield of "Q1"
    When I type "a1" into "Option 1" option field of "Q1"
    And I type "a2" into "Option 2" option field of "Q1"
    And I wait for 2 sec
    Then I click on "a1" as correct answer Law
    And I wait for 2 sec
    When I check "Show-stopper" in "Q1" Law
    And I wait for 2 sec
    Then "Q1" displays "*" as a showstopper
    And I wait for 2 sec
    And I click "Save" button
    And I wait for 2 sec
    Then "Law Showstopper" is displayed on the list of quizzes
    And I wait for 3 sec
    Then I preview "Law Showstopper" to verify Showstopper is displayed
    And I wait for 3 sec
    Then I verify "Show-Stopper Question" is showing Law
    And I wait for 2 sec
    Then I close the dialog box Law
    And I wait for 2 sec
    And I delete "Law Showstopper" from the list of quizzes Law

