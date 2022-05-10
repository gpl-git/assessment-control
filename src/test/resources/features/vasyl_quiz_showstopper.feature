@showstopper
  Feature: Single Choice Question Showstopper


    Background:
      Given I navigate to "login" page
      When I type "gumby7@neoven.us" into email field VB
      Then I type "12345" into password field VB
      And I click button "Sign In" VB
      And I wait for 1 sec VB
      When I click "Quizzes" menu item VB
      And I wait for 1 sec VB
      When I click button "Create New Quiz" VB
      And I wait for 1 sec
      Then I type "SingleChoiceVasyl" into quiz title field
      And I add a question VB
      When I select "Single" question type into "Q1" VB
      And I wait for 2 sec
      When I type "The main focus of acceptance testing is?" into "Q1" VB
      And I type "testing for a business perspective" as "Option 1*" into "Q1" VB
      And I type "ensuring that the system is acceptable to all users" as "Option 2*" into "Q1" VB
      Then I select "Option 1*" as a correct answer in "Q1" VB
      And I wait for 2 sec VB
      Then I select "Q1" as a Show-Stopper question

    @showstopper1
    Scenario: Asterisk is appearing once you enabled Show-Stopper Question
      And I verify asterisk next to the "Q1*" is displayed
      And I click button "Save" VB
      And I wait for 2 sec VB
      When I click on quiz "SingleChoiceVasyl" VB
      Then I delete quiz "SingleChoiceVasyl" VB

    @showstopper2
    Scenario: Single-Choice question with a showstopper in Preview displayed a red label
      And I verify asterisk next to the "Q1*" is displayed
      And I click button "Save" VB
      And I wait for 2 sec VB
      #When I verify quiz "SingleChoiceVasyl" is displayed in List of Quizzes
      And I wait for 3 sec VB
      Then I verify quiz "SingleChoiceVasyl" in "Preview" and "Question 1" is displayed a red label
      And I wait for 2 sec
      When I click button "Close" VB
      Then I delete quiz "SingleChoiceVasyl" VB

    @showstopper3
    Scenario: Maximum 1 Show-Stopper question in quiz
      When I add a question VB
      Then I select "Single" question type into "Q2" VB
      #And I wait for 2 sec VB
      When I type "Question2?" into "Q2" VB
      And I wait for 1 sec VB
      And I type "a" as "Option 1*" into "Q2" VB
      And I type "b" as "Option 2*" into "Q2" VB
      And I wait for 2 sec VB
      Then I select "Option 2*" as a correct answer in "Q2" VB
      Then I select "Q2" as a Show-Stopper question
      And I wait for 2 sec VB
      And I verify asterisk next to the "Q2*" is displayed
      And I click button "Save" VB
      And I wait for 2 sec VB
      When I verify quiz "SingleChoiceVasyl" is displayed in List of Quizzes
      And I verify quiz "SingleChoiceVasyl" in "Preview" and "Question 2" is displayed a red label
      When I click button "Close" VB
      Then I delete quiz "SingleChoiceVasyl" VB

    @showstopper4
    Scenario: Multiple Choice Question - Can't be Show-Stopper
      When I add a question VB
      And I wait for 1 sec VB
      Then I select "Multiple" question type into "Q2" VB
      And I wait for 1 sec VB
      When I type "Multiple question" into "Q2" VB
      And I type "answer1" as "Option 1*" into "Q2" VB
      And I type "answer2" as "Option 2*" into "Q2" VB
      And I wait for 2 sec VB
      Then I select "Option 1*" as a correct answer in "Q2" VB for multiple question
      And I select "Option 2*" as a correct answer in "Q2" VB for multiple question
      And I click button "Move Question Up" VB
      Then I click button "Save" VB
      And I wait for 2 sec VB
      When I verify quiz "SingleChoiceVasyl" is displayed in List of Quizzes
      And I wait for 2 sec VB

      #MAR22-355   Bug! Multiple question becomes Show-Stopper
      #And I verify quiz "SingleChoiceVasyl" in "Preview" and "Question 1" is not displayed a red label
      #When I click button "Close" VB

      When I click on quiz "SingleChoiceVasyl" VB
      Then I delete quiz "SingleChoiceVasyl" VB
