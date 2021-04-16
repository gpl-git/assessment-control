@options
Feature: Single Choice Question - Options
  Background:
    Given I open "login" page
    When  I type "qa@ask.com" into email filed
    And I type "12345" into password field
    When  I click "Sign In" button
    And I wait for 1 sec

#      Test scenarios:
#    1. Create Single Choice Question with valid information
#    2. Create Single Choice Question with Empty option fields
#    3. Create Single Choice Question with 15 + 1 choices
#    4. Create Single Choice Question with Other text area is included
#    5. Create Single Choice Question with 1000 +1 characters
#    6. Create Single Choice Question with Max 15 + 1 choices
#    7. Create Single Choice Question with Max 1000 + 1 characters

  @option1
  Scenario: Create Single Choice Question with valid information
    When I click on "Quizzes" link
    And I wait for 1 sec
    Then I click "Create New Quiz" button
    And I wait for 1 sec
    When I type "Test Quiz Single Choice13" into quiz title field
    And I add a question
    Then I select "Single" question
    When I wait for 1 sec
    When  I type "Single question text" into "Q1" input field "Question *"
    When  I type " Option1  text" into "Q1" input field "Option 1*"
    When  I type " Option2  text" into "Q1" input field "Option 2*"
    When I click "Add Option" button
    When  I type " Option3  text" into "Q1" input field "Option 3*"
    And I check "Option 2*" as correct in question "Q1"
    When I click "Save" button
    And I wait for 1 sec
    And I refresh the page
    And I wait for 1 sec
    Then "Test Quiz Single Choice13" is displayed on the list of quizzes
    When I wait for 2 sec
    When I click on "Test Quiz Single Choice13" quiz
    Then I wait for 2 sec
    And I click "Delete" button for the "Test Quiz Single Choice13" quiz
    And I wait for 2 sec
    And I confirm action
    And I wait for 1 sec
    And I refresh the page
    And I wait for 1 sec

  @option2
  Scenario: Empty option fields
    When I click on "Quizzes" link
    And I wait for 1 sec
    Then I click "Create New Quiz" button
    And I wait for 1 sec
    When I type "Test Quiz Single Choice13" into quiz title field
    And I add a question
    Then I select "Single" question
    When I wait for 1 sec
    When  I type "Single question text" into "Q1" input field "Question *"
    And I check "Option 2*" as correct in question "Q1"
    When I click "Save" button
    Then alert for empty field is displayed

  @option3
  Scenario: 15 + 1 choices
    When I click on "Quizzes" link
    And I wait for 1 sec
    Then I click "Create New Quiz" button
    And I wait for 1 sec
    When I type "Test Quiz Single Choice13" into quiz title field
    And I add a question
    Then I select "Single" question
    When I wait for 1 sec
    When  I type "Single question text" into "Q1" input field "Question *"
    When  I type "Test option1" into "Q1" input field "Option 1*"
    When  I type "Test option2" into "Q1" input field "Option 2*"
    When I click "Add Option" button
    When I type " Option3  text" into "Q1" input field "Option 3*"
    When I click "Add Option" button
    When I type " Option4  text" into "Q1" input field "Option 4*"
    When I click "Add Option" button
    When I type " Option5  text" into "Q1" input field "Option 5*"
    When I click "Add Option" button
    When I type " Option6  text" into "Q1" input field "Option 6*"
    When I click "Add Option" button
    When I type " Option7  text" into "Q1" input field "Option 7*"
    When I click "Add Option" button
    When I type " Option8  text" into "Q1" input field "Option 8*"
    When I click "Add Option" button
    When I type " Option9  text" into "Q1" input field "Option 9*"
    When I click "Add Option" button
    When I type " Option10  text" into "Q1" input field "Option 10*"
    When I click "Add Option" button
    When I type " Option11  text" into "Q1" input field "Option 11*"
    When I click "Add Option" button
    When I type " Option12  text" into "Q1" input field "Option 12*"
    When I click "Add Option" button
    When I type " Option13  text" into "Q1" input field "Option 13*"
    When I click "Add Option" button
    When I type " Option14  text" into "Q1" input field "Option 14*"
    When I click "Add Option" button
    When I type " Option15  text" into "Q1" input field "Option 15*"
    When I click "Add Option" button
    When I type " Option16  text" into "Q1" input field "Option 16*"
    And I check "Option 2*" as correct in question "Q1"
    When I click "Save" button
#    Then alert for maximum choices is displayed Bug# ACT-180
    And I wait for 2 sec
    And I refresh the page
    Then "Test Quiz Single Choice13" is displayed on the list of quizzes
    When I wait for 2 sec
    When I click on "Test Quiz Single Choice13" quiz
    And I wait for 1 sec
    And I click "Delete" button for the "Test Quiz Single Choice13" quiz
    And I confirm action
    When I wait for 2 sec
    And I refresh the page


  @option4
  Scenario: Other text area is included
    When I click on "Quizzes" link
    And I wait for 1 sec
    Then I click "Create New Quiz" button
    And I wait for 1 sec
    When I type "Test Quiz Single Choice13" into quiz title field
    And I add a question
    Then I select "Single" question
    When I wait for 1 sec
    When  I type "Single question text" into "Q1" input field "Question *"
    When  I type " Option1  text" into "Q1" input field "Option 1*"
    When  I type " Option2  text" into "Q1" input field "Option 2*"
    And I check "Option 2*" as correct in question "Q1"
    And I click "Other" button
    When I click "Save" button
    And I wait for 2 sec
    And I refresh the page
    Then "Test Quiz Single Choice13" is displayed on the list of quizzes
    When I wait for 2 sec
    When I open "Test Quiz Single Choice13" for preview
    Then I validate that Other text area is displayed
    When I wait for 1 sec
    When I click "Close" button
    When I wait for 2 sec
    And I click "Delete" button for the "Test Quiz Single Choice13" quiz
    And I wait for 2 sec
    And I confirm action
    When I wait for 2 sec
    And I refresh the page

  @option5
  Scenario: 1000 + 1 characters
    When I click on "Quizzes" link
    And I wait for 1 sec
    Then I click "Create New Quiz" button
    And I wait for 1 sec
    When I type "Test Quiz Single Choice13" into quiz title field
    And I add a question
    Then I select "Single" question
    When I wait for 1 sec
    When  I type "Single question text" into "Q1" input field "Question *"
    When  I type "Test execution. Single-Choice question with 1001 characters in Option text field^&%@*&)()_+_!`~<>?1:}{|\TTest execution. Single-Choice question with 1001 characters in Option text field^&%@*&)()_+_!`~<>?1:}{|\TTest execution. Single-Choice question with 1001 characters in Option text field^&%@*&)()_+_!`~<>?1:}{|\TTest execution. Single-Choice question with 1001 characters in Option text field^&%@*&)()_+_!`~<>?1:}{|\TTest execution. Single-Choice question with 1001 characters in Option text field^&%@*&)()_+_!`~<>?1:}{|\TTest execution. Single-Choice question with 1001 characters in Option text field^&%@*&)()_+_!`~<>?1:}{|\TTest execution. Single-Choice question with 1001 characters in Option text field^&%@*&)()_+_!`~<>?1:}{|\TTest execution. Single-Choice question with 1001 characters in Option text field^&%@*&)()_+_!`~<>?1:}{|\TTest execution. Single-Choice question with 1001 characters in Option text field^&%@*&)()_+_!`~<>?1:}{|\TTest execution. Single-Choice question with 1001 charact" into "Q1" input field "Option 1*"
    When  I type " Option2  text" into "Q1" input field "Option 2*"
    When I click "Add Option" button
    When  I type " Option3  text" into "Q1" input field "Option 3*"
    And I check "Option 2*" as correct in question "Q1"
    When I click "Save" button
#    Then alert for maximum characters in Option field is displayed Bug# ACT-228
    And I wait for 2 sec
    And I refresh the page
    Then "Test Quiz Single Choice13" is displayed on the list of quizzes
    When I wait for 2 sec
    When I click on "Test Quiz Single Choice13" quiz
    And I wait for 1 sec
    And I click "Delete" button for the "Test Quiz Single Choice13" quiz
    And I wait for 1 sec
    And I confirm action
    When I wait for 2 sec
    And I refresh the page

  @option6
  Scenario: Max 15 choices
    When I click on "Quizzes" link
    And I wait for 1 sec
    Then I click "Create New Quiz" button
    And I wait for 1 sec
    When I type "Test Quiz Single Choice13" into quiz title field
    And I add a question
    Then I select "Single" question
    When I wait for 1 sec
    When  I type "Single question text" into "Q1" input field "Question *"
    When  I type "Test option1" into "Q1" input field "Option 1*"
    When  I type "Test option2" into "Q1" input field "Option 2*"
    When I click "Add Option" button
    When I type " Option3  text" into "Q1" input field "Option 3*"
    When I click "Add Option" button
    When I type " Option4  text" into "Q1" input field "Option 4*"
    When I click "Add Option" button
    When I type " Option5  text" into "Q1" input field "Option 5*"
    When I click "Add Option" button
    When I type " Option6  text" into "Q1" input field "Option 6*"
    When I click "Add Option" button
    When I type " Option7  text" into "Q1" input field "Option 7*"
    When I click "Add Option" button
    When I type " Option8  text" into "Q1" input field "Option 8*"
    When I click "Add Option" button
    When I type " Option9  text" into "Q1" input field "Option 9*"
    When I click "Add Option" button
    When I type " Option10  text" into "Q1" input field "Option 10*"
    When I click "Add Option" button
    When I type " Option11  text" into "Q1" input field "Option 11*"
    When I click "Add Option" button
    When I type " Option12  text" into "Q1" input field "Option 12*"
    When I click "Add Option" button
    When I type " Option13  text" into "Q1" input field "Option 13*"
    When I click "Add Option" button
    When I type " Option14  text" into "Q1" input field "Option 14*"
    When I click "Add Option" button
    When I type " Option15  text" into "Q1" input field "Option 15*"
    And I check "Option 2*" as correct in question "Q1"
    When I click "Save" button
    And I wait for 2 sec
    And I refresh the page
    Then "Test Quiz Single Choice13" is displayed on the list of quizzes
    When I wait for 2 sec
    When I click on "Test Quiz Single Choice13" quiz
    And I wait for 1 sec
    And I click "Delete" button for the "Test Quiz Single Choice13" quiz
    And I confirm action
    When I wait for 2 sec
    And I refresh the page

  @option7
  Scenario: 1000 + 1 characters
    When I click on "Quizzes" link
    And I wait for 1 sec
    Then I click "Create New Quiz" button
    And I wait for 1 sec
    When I type "Test Quiz Single Choice13" into quiz title field
    And I add a question
    Then I select "Single" question
    When I wait for 1 sec
    When  I type "Single question text" into "Q1" input field "Question *"
    When  I type "Test execution. Single-Choice question with 1001 characters in Option text field^&%@*&)()_+_!`~<>?1:}{|\TTest execution. Single-Choice question with 1001 characters in Option text field^&%@*&)()_+_!`~<>?1:}{|\TTest execution. Single-Choice question with 1001 characters in Option text field^&%@*&)()_+_!`~<>?1:}{|\TTest execution. Single-Choice question with 1001 characters in Option text field^&%@*&)()_+_!`~<>?1:}{|\TTest execution. Single-Choice question with 1001 characters in Option text field^&%@*&)()_+_!`~<>?1:}{|\TTest execution. Single-Choice question with 1001 characters in Option text field^&%@*&)()_+_!`~<>?1:}{|\TTest execution. Single-Choice question with 1001 characters in Option text field^&%@*&)()_+_!`~<>?1:}{|\TTest execution. Single-Choice question with 1001 characters in Option text field^&%@*&)()_+_!`~<>?1:}{|\TTest execution. Single-Choice question with 1001 characters in Option text field^&%@*&)()_+_!`~<>?1:}{|\TTest execution. Single-Choice question with 1001 charac" into "Q1" input field "Option 1*"
    When  I type " Option2  text" into "Q1" input field "Option 2*"
    When I click "Add Option" button
    When  I type " Option3  text" into "Q1" input field "Option 3*"
    And I check "Option 2*" as correct in question "Q1"
    When I click "Save" button
    And I wait for 2 sec
    And I refresh the page
    Then "Test Quiz Single Choice13" is displayed on the list of quizzes
    When I wait for 2 sec
    When I click on "Test Quiz Single Choice13" quiz
    And I wait for 1 sec
    And I click "Delete" button for the "Test Quiz Single Choice13" quiz
    And I wait for 1 sec
    And I confirm action
    When I wait for 2 sec
    And I refresh the page








