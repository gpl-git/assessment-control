@LawShowStopper
Feature: Automate Single Choice Question - Showstopper
  @lawshowstopper1
  Scenario: Create a quiz with single choice showstopper question
    #Log In
    Given I go to "ASK Login"
    When I type "britters@colevillecapital.com" into e-input
    Then I type "abc123" into p-input
    Then I click "Sign In" btn
    And I wait for 3 sec
    And I click "Quizzes" menu item
    And I wait for 2 sec
    When I click "Create New Quiz" button
    And I wait for 2 sec
    #Create a quiz
    When I type "Law Showstopper" as title for Quiz
    Then I add the first question
    When I select "Single" question type
    And I wait for 2 sec
    And I type "q1" into qfield of "Q1"
    When I type "a1" into "Option 1" option field of "Q1"
    And I type "a2" into "Option 2" option field of "Q1"
    And I wait for 2 sec
    Then I click on element with xpath "//mat-radio-button[@id='mat-radio-6']"
    And I wait for 2 sec
    #TestSet1 (Showstopper option is displayed)
    Then element with xpath "//span[contains(text(),'Show-Stopper')]" should contain text "Show-Stopper"
    Then I click on element with xpath "//mat-checkbox[@id='mat-checkbox-2']"
    And I wait for 2 sec
    #TestSet2 (Showstopper * should be required)
    Then element with xpath "//span[@class='mat-content']" should contain text "Q1*: q1"
    And I wait for 2 sec
    And I click "Save" button
    And I wait for 2 sec
    #TestSet3 (Verify Showstopper is shown in Preview)
    Then "Law Showstopper" is displayed on the list of quizzes
    Then I click on element with xpath "//mat-panel-title[contains(text(),'Law Showstopper')]"
    And I wait for 5 sec
    Then I click on element with xpath "//mat-panel-title[contains(text(),'Law Showstopper')]/../../..//span[text()='Preview']"
    Then element with xpath "//p[contains(text(),'Show-Stopper Question')]" should contain text "Show-Stopper Question"
    Then I click on element with xpath "//button[@aria-label='Close dialog']"
    And I wait for 5 sec
    And I delete "Law Showstopper" from the list of quizzes



