@single_choice_question_options
Feature:Single Choice Question - Options

  Background:
    Given I navigate to "login" page
    When I enter the teachers email "suteneko@rapidbeos.net" into email field
    And I enter the password "test123" into password field
    And I click the "Sign In" button
    And I wait for 1 sec for the presence of all the elements on the page
    Then I should see the text "TEACHER" present in the home page
    When I click the "Quizzes" menu item from the home page
    And I click "Create New Quiz" button under the list of quizzes section

  @positive @positive_1 #Issue ID:MAY23-359
  Scenario:Option 1 and Option 2 are filled out, the radio button is checked
    When I type "SCQ quiz with two options" in the quiz title field
    And I add a question by clicking the button Add question
    And I select the question type as "Single-Choice"
    And I type the question as "What is BDD?" into question field of "Q1"
    And I type "Behavior Driven Development" into the "Option 1" of "Q1"
    And I type "Behavior Driven Deployment" into the "Option 2" of "Q1"
    And I choose the answer as "Option 1" for question "Q1"
    And I click the "Save" button
    Then I should see the quiz name "SCQ quiz with two options" in the list of quizzes section
    And I "Delete" the quiz name "SCQ quiz with two options" from the list of quizzes

  @positive @positive_2 #Issue ID: MAY23-365 MAY23-370
  Scenario:Allowable characters on option field with Alphanumeric and Sp. characters
    When I type "Options text with allowable characters" in the quiz title field
    And I add a question by clicking the button Add question
    And I select the question type as "Single-Choice"
    And I type the question as "What is BDD?" into question field of "Q1"
    And I type "sT8uKp2R9`~@#$%^&*()_+|={}[]:”;’<>?,./®©£¥¢¦§«»€" into the "Option 1" of "Q1"
    And I type "sT8uKp2R9`~@#$%^&*()_+|={}[]:”;’<>?,./®©£¥¢¦§«»€" into the "Option 2" of "Q1"
    And I choose the answer as "Option 1" for question "Q1"
    And I click the "Save" button
    Then I should see the quiz name "Options text with allowable characters" in the list of quizzes section
    And I "Delete" the quiz name "Options text with allowable characters" from the list of quizzes

  @positive @positive_3 #Issue ID: MAY23-367
  Scenario: Option 1 has 1 character Option 2 has 999 characters and the radio button is checked
    When I type "SCQ with 999 characters in option fields" in the quiz title field
    And I add a question by clicking the button Add question
    And I select the question type as "Single-Choice"
    And I type the question as "What is BDD?" into question field of "Q1"
    And I enter 1 character into the "Option 1" of "Q1"
    And I enter 999 character into the "Option 2" of "Q1"
    And I choose the answer as "Option 1" for question "Q1"
    And I click the "Save" button
    Then I should see the quiz name "SCQ with 999 characters in option fields" in the list of quizzes section
    And I "Delete" the quiz name "SCQ with 999 characters in option fields" from the list of quizzes

  @positive @positive_4 #Issue ID: MAY23-422
  Scenario: 14 Options for 1 Question
    When I type "SCQ with 14 options" in the quiz title field
    And I add a question by clicking the button Add question
    And I select the question type as "Single-Choice"
    And I type the question as "What is BDD?" into question field of "Q1"
    And I add 12 new options to "Q1"
    And I enter 10 character into the option text fields of "Q1"
    And I choose the answer as "Option 1" for question "Q1"
    And I click the "Save" button
    Then I should see the quiz name "SCQ with 14 options" in the list of quizzes section
    And I "Delete" the quiz name "SCQ with 14 options" from the list of quizzes

  @positive @positive_5 #Issue ID: MAY23-429
  Scenario: Toggle the radio button
    When I type "SCQ toggling the option radio button" in the quiz title field
    And I add a question by clicking the button Add question
    And I select the question type as "Single-Choice"
    And I type the question as "What is BDD?" into question field of "Q1"
    And I type "Behavior Driven Development" into the "Option 1" of "Q1"
    And I type "Behavior Driven Deployment" into the "Option 2" of "Q1"
    And I choose the answer as "Option 1" for question "Q1"
    And I choose the answer as "Option 2" for question "Q1"
    And verify that the "Option 2" is selected
    And I click the "Save" button
    Then I should see the quiz name "SCQ toggling the option radio button" in the list of quizzes section
    And I "Delete" the quiz name "SCQ toggling the option radio button" from the list of quizzes

  @positive @positive_6 #Issue ID: MAY23-430
  Scenario: Removing Options
    When I type "SCQ deleting options" in the quiz title field
    And I add a question by clicking the button Add question
    And I select the question type as "Single-Choice"
    And I type the question as "What is BDD?" into question field of "Q1"
    And I add 1 new options to "Q1"
    And I enter 10 character into the option text fields of "Q1"
    And I choose the answer as "Option 1" for question "Q1"
    And I click the "Preview" button
    Then I verify the content displayed on the Preview mode is correct
    And I click "Close" in the confirmation window
    And I click the settings icon present next to "Option 2" from "Q1"
    And I click the "Delete Option" from the menu panel
    Then I verify the "Option 2" gets deleted successfully


  @negative @negative_1 #Issue ID: MAY23-341
  Scenario:Options 1 and 2 are empty, the radio button is not checked
    When I type "SCQ with empty options" in the quiz title field
    And I add a question by clicking the button Add question
    And I select the question type as "Single-Choice"
    And I type the question as "What is BDD?" into question field of "Q1"
    And I click the "Save" button
    Then I should see an error message "Quiz is not completed." on the snack-bar
    And I should an error message "This field is required" on the "Option 1" field
    And I should an error message "This field is required" on the "Option 2" field

  @negative @negative_2 #Issue ID: MAY23-349
  Scenario:Options 1 and 2 are empty, the radio button is checked
    When I type "SCQ with empty options and radio button checked" in the quiz title field
    And I add a question by clicking the button Add question
    And I select the question type as "Single-Choice"
    And I type the question as "What is BDD?" into question field of "Q1"
    And I choose the answer as "Option 1" for question "Q1"
    And I click the "Save" button
    Then I should see an error message "Quiz is not completed." on the snack-bar
    And I should an error message "This field is required" on the "Option 1" field
    And I should an error message "This field is required" on the "Option 2" field

  @negative @negative_3 #Issue ID: MAY23-354
  Scenario:Option 1 is filled out, Options 2 is empty, the radio button is checked
    When I type "SCQ with option1 filled and option2 empty" in the quiz title field
    And I add a question by clicking the button Add question
    And I select the question type as "Single-Choice"
    And I type the question as "What is BDD?" into question field of "Q1"
    And I type "Behavior Driven Development" into the "Option 1" of "Q1"
    And I choose the answer as "Option 1" for question "Q1"
    And I click the "Save" button
    Then I should see an error message "Quiz is not completed." on the snack-bar
    And I should an error message "This field is required" on the "Option 2" field

  @negative @negative_4 #Issue ID: MAY23-357
  Scenario: Option 1 and Option 2 are filled out, the radio button is not checked
    When I type "SCQ with options are filled out and radio button unchecked" in the quiz title field
    And I add a question by clicking the button Add question
    And I select the question type as "Single-Choice"
    And I type the question as "What is BDD?" into question field of "Q1"
    And I type "Behavior Driven Development" into the "Option 1" of "Q1"
    And I type "Behavior Driven Deployment" into the "Option 2" of "Q1"
    And I click the "Save" button
    Then I should see an error message "Quiz is not completed." on the snack-bar
    And I should see an error message "*Choose correct answer"

  @negative @negative_5 #Issue ID: MAY23-368
  Scenario: Option 1 - 1000 characters, Option 2 - 1001 characters, the radio button is checked
    When I type "Single Choice Question with 1001 characters in option fields" in the quiz title field
    And I add a question by clicking the button Add question
    And I select the question type as "Single-Choice"
    And I type the question as "What is BDD?" into question field of "Q1"
    And I enter 1000 character into the "Option 1" of "Q1"
    And I enter 1001 character into the "Option 2" of "Q1"
    And I choose the answer as "Option 1" for question "Q1"
    And I click the "Save" button
       #known issue please refer the Bug_ID:MAY23-369
    Then I should see an error message "User can't insert more than 1000 characters into the text field"


  @negative @negative_6 #Issue ID: MAY23-422
  Scenario: More than 15 Options for 1 Question
    When I type "SCQ with more than 15 options" in the quiz title field
    And I add a question by clicking the button Add question
    And I select the question type as "Single-Choice"
    And I type the question as "What is BDD?" into question field of "Q1"
    And I add 14 new options to "Q1"
    And I enter 10 character into the option text fields of "Q1"
    And I choose the answer as "Option 1" for question "Q1"
    And I click the "Save" button
    #known issue
    Then I should see an error message "Not more than 15 options are allowed"

  @negative @negative_7 #Issue ID: MAY23-418
  Scenario: White space in Option field
    When I type "SCQ with white space in Option fields" in the quiz title field
    And I add a question by clicking the button Add question
    And I select the question type as "Single-Choice"
    And I type the question as "What is BDD?" into question field of "Q1"
    And I type "   " into the "Option 1" of "Q1"
    And I type "   " into the "Option 2" of "Q1"
    And I choose the answer as "Option 1" for question "Q1"
    And I click the "Save" button
    #known issue please refer the Bug ID:MAY23-419
    Then I should see an error message "White spaces are not allowed"

  @positive @positive_7
  Scenario: Responsive UI
    When I type "SCQ with white space in Option fields" in the quiz title field
    And I add a question by clicking the button Add question
    And I select the question type as "Single-Choice"
    And I type the question as "What is BDD?" into question field of "Q1"
    And I type "Behavior Driven Development" into the "Option 1" of "Q1"
    And I type "Behavior Driven Deployment" into the "Option 2" of "Q1"
    And I resize the browser window to the mobile Dimension 800 by 600
    And I wait for 1 sec for the presence of all the elements on the page
















