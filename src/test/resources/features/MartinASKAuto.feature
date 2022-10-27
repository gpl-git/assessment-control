@option
Feature: Automate test set - Multiple choice question: Options. SEP22-274 Reporter: Galina Garaba

  Background:
    Given I navigate to "login" page
    When I type email "2112319@cloudscredit.com" for teacher user
    And I type password "12345"
    When I click button "Sign In"
    And I wait for 1 Sec
    Then I should see the "home" page is displayed
    When I click on button "Quizzes" from left side menu items list
    And I wait for 1 Sec

  @option1
#  TC PASS
  Scenario: Test 1. Option text field accepts 1000 characters
    When I click on "Create new Quiz"
    And I wait for 1 Sec
    And I type string "Quiz Demo Martin - Automation" as quiz title
    And I click  "Add Question"
    And I wait for 1 Sec
    Then I select "Multiple-Choice"
    And I wait for 1 Sec
    Then I type "Option field accepts 1000 characters"
    Then I type text "Smoke1" into "Option 1*"
    Then I enter 1000 alphanumeric characters into "Option 2*"
    And I select "Option 1*" as the correct answer
    And I wait for 1 Sec
    And I click on "Save" button
    And I wait for 1 Sec
    And I verify saved "Quiz Demo Martin - Automation" in displayed in quizzes
    And I wait for 1 Sec
    Then I delete the quiz "Quiz Demo Martin - Automation"

  @option2
#    TC FAIL: NO ERROR MESSAGE IS DISPLAYED WHEN INPUT > 1000 CHARACTERS
  Scenario: Test 2. Option text field doesn't accept 1001 characters
    When I click on "Create new Quiz"
    And I wait for 1 Sec
    And I type string "Quiz Demo Martin - Automation" as quiz title
    And I click  "Add Question"
    And I wait for 1 Sec
    Then I select "Multiple-Choice"
    And I wait for 1 Sec
    Then I type "No more than 1000 characters is accepted in the option field"
    Then I type text "Smoke1" into "Option 1*"
    Then I enter 1001 alphanumeric characters into "Option 2*"
    And I wait for 2 Sec
    And I select "Option 1*" as the correct answer
    And I wait for 1 Sec
    Then the button "Save" is disabled


  @option3
#    TC PASS
  Scenario: Test 3. Option text field accepts 1 character
    When I click on "Create new Quiz"
    And I wait for 1 Sec
    And I type string "Quiz Demo Martin - Automation" as quiz title
    And I click  "Add Question"
    And I wait for 1 Sec
    Then I select "Multiple-Choice"
    And I wait for 1 Sec
    Then I type "Option field allows a single character"
    Then I type text "Smoke1" into "Option 1*"
    Then I type text "1" into "Option 2*"
    And I select "Option 1*" as the correct answer
    And I wait for 1 Sec
    And I click on "Save" button
    And I wait for 1 Sec
    Then I delete the quiz "Quiz Demo Martin - Automation"

  @option4
#    TC PASS
  Scenario: Test 4. Unable to create a Multiple choice question with an empty Option text field
    When I click on "Create new Quiz"
    And I wait for 1 Sec
    And I type string "Quiz Demo Martin - Automation" as quiz title
    And I click  "Add Question"
    And I wait for 1 Sec
    Then I select "Multiple-Choice"
    And I wait for 1 Sec
    Then I type "Error message is displayed when option field is empty"
    Then I type text "Smoke1" into "Option 1*"
    Then I type text "" into "Option 2*"
    And I select "Option 1*" as the correct answer
    And I click on "Save" button
    And I wait for 4 Sec
    And I should see error message
    And I wait for 2 Sec
    And I click on "Back To Quizzes List" button
    And I click on "Discard" option button


  @option5
#    TC PASS
  Scenario: Test 5. Option text field accepts special characters
    When I click on "Create new Quiz"
    And I wait for 1 Sec
    And I type string "Quiz Demo Martin - Automation" as quiz title
    And I click  "Add Question"
    And I wait for 1 Sec
    Then I select "Multiple-Choice"
    And I wait for 1 Sec
    Then I type "Option field allows special characters"
    Then I type text "Smoke1" into "Option 1*"
    Then I type text "!@#$%^)_+~" into "Option 2*"
    And I select "Option 1*" as the correct answer
    And I wait for 3 Sec
    And I click on "Save" button
    And I wait for 1 Sec
    And I verify saved "Quiz Demo Martin - Automation" in displayed in quizzes
    And I wait for 1 Sec
    Then I delete the quiz "Quiz Demo Martin - Automation"

  @option6
#    TC PASS
  Scenario: Test 6. Options could be deleted
    When I click on "Create new Quiz"
    And I wait for 1 Sec
    And I type string "Quiz Demo Martin - Automation" as quiz title
    And I click  "Add Question"
    And I wait for 1 Sec
    Then I select "Multiple-Choice"
    And I wait for 1 Sec
    Then I type "Options can be deleted"
    Then I type text "Smoke Test # 1" into "Option 1*"
    Then I type text "Smoke Test # 2" into "Option 2*"
    And I add up to 15 additional options
    And I select "Option 10*" as the correct answer
    And I wait for 2 Sec
    And I delete "Option 15*"
    And I delete "Option 14*"
    And I delete "Option 13*"
    And I delete "Option 12*"
    And I delete "Option 11*"
    And I wait for 2 Sec
    And I click on "Back To Quizzes List" button
    And I wait for 1 Sec
    And I click on "Discard" option button
    And I wait for 1 Sec

  @option7
#    PASS
  Scenario: Test 7. Options could be moved down
    When I click on "Create new Quiz"
    And I wait for 1 Sec
    And I type string "Quiz Demo Martin - Automation" as quiz title
    And I click  "Add Question"
    And I wait for 1 Sec
    Then I select "Multiple-Choice"
    And I wait for 1 Sec
    Then I type "Options could be moved down"
    Then I type text "Correct Option # 11111 This line will go down 11111" into "Option 1*"
    Then I type text "Incorrect Option # 222222" into "Option 2*"
    And I add up to 15 additional options
    And I select "Option 1*" as the correct answer
    And I click on settings icon for "Option 1*"
    And I move selected option by clicking on "Move option down"
    And I wait for 10 Sec
    And I click on "Back To Quizzes List" button
    And I wait for 1 Sec
    And I click on "Discard" option button
    And I wait for 1 Sec

  @option8
#    PASS
  Scenario: Test 8. Options could be moved up
    When I click on "Create new Quiz"
    And I wait for 1 Sec
    And I type string "Quiz Demo Martin - Automation" as quiz title
    And I click  "Add Question"
    And I wait for 1 Sec
    Then I select "Multiple-Choice"
    And I wait for 1 Sec
    Then I type "Options could be moved up"
    Then I type text "Correct Option # 1" into "Option 1*"
    Then I type text "Incorrect Option # 2222222 This line will move up 2222222" into "Option 2*"
    And I add up to 15 additional options
    And I select "Option 1*" as the correct answer
    And I click on settings icon for "Option 2*"
    And I move selected option by clicking on "Move option up"
    And I wait for 10 Sec
    And I click on "Back To Quizzes List" button
    And I wait for 1 Sec
    And I click on "Discard" option button
    And I wait for 1 Sec

  @option9
#  PASS
  Scenario: Test 9. The error message is displayed when non of the options is selected while saving.
    When I click on "Create new Quiz"
    And I wait for 1 Sec
    And I type string "Quiz Demo Martin - Automation" as quiz title
    And I click  "Add Question"
    And I wait for 1 Sec
    Then I select "Multiple-Choice"
    And I click on "Save" button
    Then I should see the error message Choose at least one correct answer
    And I wait for 5 Sec
    And I click on "Back To Quizzes List" button
    And I wait for 1 Sec
    And I click on "Discard" option button
    And I wait for 1 Sec

  @option10
#    PASS
  Scenario: Test 10. Max 15 options: User is able to save the Quiz
    When I click on "Create new Quiz"
    And I wait for 1 Sec
    And I type string "Quiz Demo Martin - Automation" as quiz title
    And I click  "Add Question"
    And I wait for 1 Sec
    Then I select "Multiple-Choice"
    And I wait for 1 Sec
    Then I type "User can add up to 15 options"
    Then I type text "Correct Option # 1" into "Option 1*"
    Then I type text "Incorrect Option # 2" into "Option 2*"
    And I add up to 15 additional options
    And I select "Option 15*" as the correct answer
    And I click on "Save" button
    And I wait for 1 Sec
    And I verify saved "Quiz Demo Martin - Automation" in displayed in quizzes
    And I wait for 1 Sec
    Then I delete the quiz "Quiz Demo Martin - Automation"


  @option11
  Scenario: Test 11. No more than 15 options could be selected in Multiple-choice question type
#      TC FAIL: QUIZ ALLOWS MORE THAN 15 OPTIONS
    When I click on "Create new Quiz"
    And I wait for 1 Sec
    And I type string "Quiz Demo Martin - Automation" as quiz title
    And I click  "Add Question"
    And I wait for 1 Sec
    Then I select "Multiple-Choice"
    And I wait for 1 Sec
    Then I type "User cannot add more than 15 options"
    Then I type text "Correct Option # 1" into "Option 1*"
    Then I type text "Incorrect Option # 2" into "Option 2*"
    And I add up to 17 additional options
    And I select "Option 16*" as the correct answer
    And I select "Option 17*" as the correct answer
    And I wait for 5 Sec
    And I click on "Back To Quizzes List" button
    And I wait for 1 Sec
    And I click on "Discard" option button
    And I wait for 1 Sec





