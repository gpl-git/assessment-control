@trivia_shweta
  Feature: Trivia By Shweta Scenarios

  Background:
    Given I "login"
    When I enter login "email"
    Then I enter password "password"
    #And I wait for 2 sec
    When I click on "Sign In" button
    And I wait for 2 sec
    When I click "Quiz" link
    And I wait for 2 sec
    When I click on "Create New Quiz" button
    And I wait for 1 sec
    Then I type in quiz tile as "A Trivia By Shweta"
    And I wait for 1 sec

  @trivia_shweta1
  # Create a Quiz with multiple choice question and Delete it
  Scenario: Automate Quiz with Multiple Choice Questions
    Given I click add question
    Then I select question type as "Multiple-Choice"
    Then I type into Question field "Question here !"
    And I type "option ONE" in first option
    And I type "option TWO" in second option
    Then I click on "Add Option" button
    And I wait for 2 sec
    And I type "option Three" in third option
    Then I select "option TWO" and "option Three" correct choices
    Then I wait for 2 sec
    And I click on "Save" button Shweta
    Then I wait for 2 sec
    Then quiz with text "A Trivia By Shweta" should be displayed
    Then I wait for 2 sec
   # And I click on element with text "A Trivia By Shweta"
   # And I wait for 4 sec
    When I delete my "A Trivia By Shweta" quiz
    And I wait for 2 sec
  # Then quiz with text "A Trivia By Shweta" should not be displayed
   # And I wait for 2 sec

  @trivia_shweta2
  #Move Options Up and Down OCT-275,OCT-276, OCT-277
  Scenario: Move Up and Down Arrow keys in Question
    Given I click add question
    Then I select question type as "Multiple-Choice"
    Then I type into Question field "Question here !"
    And I type "option ONE" in first option
    And I type "option TWO" in second option
    Then I click on "Add Option" button
    And I wait for 2 sec
    And I type "option Three" in third option
    Then I select "option TWO" and "option Three" correct choices
    And I wait for 2 sec
    When I click on settings for "option ONE"
    And I wait for 5 sec
    Then I click on the "arrow"
    #Asserting that option one moved down by one position
    Then "option ONE" should be at second position
    When I click on settings for "option ONE"
    And I wait for 2 sec
    Then I click on the "arrow"
    And I wait for 2 sec
    #Asserting that option one was moved back to first option position
    Then "option ONE" should be at first position
    And I click on "Save" button Shweta
    And I wait for 2 sec
    Then quiz with text "A Trivia By Shweta" should be displayed
    Then I wait for 2 sec
  #  Then I click on element with text "A Trivia By Shweta"
    And I wait for 2 sec
    Then I delete my "A Trivia By Shweta" quiz
  # Then quiz with text "A Trivia By Shweta" should not be displayed

  @trivia_shweta3
  # Settings: Delete option OCT-281
  Scenario: Delete options from Multiple Choice Question
    Given I click add question
    Then I select question type as "Multiple-Choice"
    Then I type into Question field "Question here !"
    And I type "option ONE" in first option
    And I type "option TWO" in second option
    Then I click on "Add Option" button
    And I wait for 2 sec
    And I type "option Three" in third option
    Then I select "option TWO" and "option Three" correct choices
    And I wait for 2 sec
    When I click on settings for "option ONE"
    And I wait for 5 sec
    Then I click on "delete" option button
    Then total number of options should be 4
    And I click on "Save" button Shweta
    And I wait for 2 sec
    Then quiz with text "A Trivia By Shweta" should be displayed
    Then I wait for 2 sec
  #  Then I click on element with text "A Trivia By Shweta"
   # And I wait for 2 sec
    Then I delete my "A Trivia By Shweta" quiz


  @trivia_shweta4
  # OCT-257 Minimum 2 options
  Scenario: Minimum 2 options are required to save a Multiple Choice Question
    Given I click add question
    Then I select question type as "Multiple-Choice"
    Then I type into Question field "Question here !"
    And I type "option ONE" in first option
    And I type "option TWO" in second option
    Then I select "option TWO" as correct choices
    And I wait for 3 sec
    Then I should be able to "Save" the quiz with minimum two choices
    And I wait for 2 sec
    Then quiz with text "A Trivia By Shweta" should be displayed
    And I wait for 4 sec
    Then I delete my "A Trivia By Shweta" quiz
    And I wait for 1 sec

  @trivia_shweta5
    # OCT-140 Max 15 choices
  Scenario: Maximum 15 options are allowed to save a Multiple Choice Question
    Given I click add question
    Then I select question type as "Multiple-Choice"
    Then I type into Question field "Question here !"
    And I type "option ONE" in first option
    And I type "option TWO" in second option
    Then I add total 15 options in by clicking "Add Option" button
    And I wait for 2 sec
    Then I select "option TWO" and "option Three" correct choices
    Then I wait for 1 sec
  # Assert that there are 15 options in the multiple question
    Then I should be able to "Save" the quiz with multiple choice question with fifteen options
    And I wait for 2 sec
    Then quiz with text "A Trivia By Shweta" should be displayed
    Then I wait for 2 sec
    Then I delete my "A Trivia By Shweta" quiz

  @trivia_shweta6
  # Minimum options: Settings-Delete option OCT-282
  Scenario: Delete Option is disabled when there are only two options in a multiple choice question
    Given I click add question
    Then I select question type as "Multiple-Choice"
    Then I type into Question field "Question here !"
    When I click on settings for "option ONE"
    And I wait for 3 sec
    #Asserting that delete button is disabled when there are only two to ptions
    Then "delete" option button should be disabled
    And I wait for 1 sec

  @trivia_shweta7
  # Settings: Close Menu OCT-284
  Scenario: Settings option dialogue box behavior
    Given I click add question
    Then I select question type as "Multiple-Choice"
    Then I type into Question field "Question here !"
    When I click on settings for "option ONE"
    And I wait for 3 sec
    Then I close the settings dialogue
    And I wait for 2 sec
    Then setting dialogue box should have opacity zero

  @trivia_shweta8
    #Failing test case: app allows saving options with only a white space
  Scenario: Text field should not allow white space
  # Text field with white space not accepted OCT-361
    Given I click add question
    Then I select question type as "Multiple-Choice"
    Then I type into Question field "Question here !"
#    Then I add a space " space" at the beginning of question text
    And I type " " in first option
    And I type " " in second option
    Then I select " " as correct choices
    And I wait for 2 sec
    Then I click on "Save" button Shweta
    And I wait for 5 sec
    #Asserting that app doesn't allow saving question with empty options
    Then I should still be at "quiz-builder" page
  #  Then quiz should not get saved


