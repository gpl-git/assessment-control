@tqss
  Feature: Textual Question - Showstopper

    Background:
      Given I navigate to login page
      When I insert "klennickaya@huntubaseuh.sbs" into email field
      Then I insert "12345" into password field
      And I press "Sign In" button
      And I wait about 3 sec
      And I go to "Quizzes" menu option
      And I wait about 3 sec
      Then I press "Create New Quiz" button
      And I wait about 3 sec
      And I type "0 Textual Question- Showstopper PAUL"
      And I press - Add Question

    @tqss1
    Scenario: Showstopper score is available
      Then I select Textual question
      And I wait about 1 sec
      And I ask my question - "Question"
      Then I mark question like Showstopper
      And I press "Save" button
      And I wait about 2 sec
      Then I select "0 Textual Question- Showstopper PAUL" quiz
      And I wait about 1 sec
      Then I press Edit button for "0 Textual Question- Showstopper PAUL" quiz
      And I wait about 2 sec
      And I click on question name
      And I wait about 1 sec
      And I make sure that Showstopper score is available
      Then I go back
      And I wait about 2 sec
      Then I delete this quiz "0 Textual Question- Showstopper PAUL"

    @tqss2
    Scenario: Textual question with a showstopper in Preview displays a red label
      Then I select Textual question
      And I ask my question - "Question"
      Then I mark question like Showstopper
      And I press "Save" button
      And I wait about 2 sec
      Then I select "0 Textual Question- Showstopper PAUL" quiz
      And I wait about 1 sec
      Then I press Preview button for "0 Textual Question- Showstopper PAUL" quiz
      And I wait about 1 sec
      Then I make sure that Quiz with a showstopper in Preview displays a red label
      Then I delete this quiz "0 Textual Question- Showstopper PAUL"

    @tqss3
    Scenario: The question number is displayed with an asterisk – "Q1* once the show-stopper checkmark is selected
      Then I select Textual question
      And I wait about 1 sec
      And I ask my question - "Question"
      Then I mark question like Showstopper
      And I press "Save" button
      And I wait about 2 sec
      Then I select "0 Textual Question- Showstopper PAUL" quiz
      And I wait about 1 sec
      Then I press Edit button for "0 Textual Question- Showstopper PAUL" quiz
      And I wait about 2 sec
      Then I make sure that The question number is displayed with an asterisk – Q* once the show-stopper checkmark is selected
      Then I go back
      And I wait about 2 sec
      Then I delete this quiz "0 Textual Question- Showstopper PAUL"

    @tqss4
    Scenario: Textual Question: Maximum 1 Show-Stopper question in a quiz
      Then I select Textual question
      And I wait about 1 sec
      And I ask my question - "Question"
      Then I mark question like Showstopper
      Then I press - Add Question
      And I wait for 1 sec
      Then I select Textual new question
      And I wait about 1 sec
      And I ask my another question - "Question"
      And I wait about 1 sec
      Then I mark new question like Showstopper
      And I wait about 1 sec
      Then I make sure that Maximum one Show-Stopper question in a quiz










