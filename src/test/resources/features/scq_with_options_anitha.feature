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

  @positive #Issue ID:MAY23-359
  Scenario:Option 1 and Option 2 are filled out, the radio button is checked
    When I type "Single Choice Question with two options" in the quiz title field
    And I add a question by clicking the button Add question
    And I select the question type as "Single-Choice"
    And I type the question as "What is BDD?" into question field of "Q1"
    And I type "Behavior Driven Development" into the "Option 1" of "Q1"
    And I type "Behavior Driven Deployment" into the "Option 2" of "Q1"
    And I select the "Option 1" from the list of options for question "Q1"
    And I click the "Save" button
    Then I should see the quiz name "Single Choice Question with two options" in the list of quizzes section
    And I "Delete" the quiz name "Single Choice Question with two options" from the list of quizzes

  @negative #Issue ID: MAY23-341
  Scenario:Options 1 and 2 are empty, the radio button is not checked
    When I type "Single Choice Question with empty options" in the quiz title field
    And I add a question by clicking the button Add question
    And I select the question type as "Single-Choice"
    And I type the question as "What is BDD?" into question field of "Q1"
    And I click the "Save" button
    Then I should see an error message on the snack-bar
    And I should an error message on the "Option 1" field
    And I should an error message on the "Option 2" field

  @negative #Issue ID: MAY23-349
  Scenario:Options 1 and 2 are empty, the radio button is checked
    When I type "Single Choice Question with options empty and radio button checked" in the quiz title field
    And I add a question by clicking the button Add question
    And I select the question type as "Single-Choice"
    And I type the question as "What is BDD?" into question field of "Q1"
    And I select the "Option 1" from the list of options for question "Q1"
    And I click the "Save" button
    Then I should see an error message on the snack-bar
    And I should an error message on the "Option 1" field
    And I should an error message on the "Option 2" field

  @negative #Issue ID: MAY23-354
  Scenario:Option 1 is filled out, Options 2 is empty, the radio button is checked
    When I type "Single Choice Question with option1 filled and option2 empty" in the quiz title field
    And I add a question by clicking the button Add question
    And I select the question type as "Single-Choice"
    And I type the question as "What is BDD?" into question field of "Q1"
    And I type "Behavior Driven Development" into the "Option 1" of "Q1"
    And I select the "Option 1" from the list of options for question "Q1"
    And I click the "Save" button
    Then I should see an error message on the snack-bar
    And I should an error message on the "Option 2" field

  @negative #Issue ID: MAY23-357
  Scenario: Option 1 and Option 2 are filled out, the radio button is not checked
    When I type "Single Choice Question with radio button unchecked" in the quiz title field
    And I add a question by clicking the button Add question
    And I select the question type as "Single-Choice"
    And I type the question as "What is BDD?" into question field of "Q1"
    And I type "Behavior Driven Development" into the "Option 1" of "Q1"
    And I type "Behavior Driven Deployment" into the "Option 2" of "Q1"
    And I click the "Save" button
    Then I should see an error message on the snack-bar
    And I should see an error message "*Choose correct answer"

  @positive #Issue ID: MAY23-365
  Scenario:Allowable characters on option field with Alphanumeric and Sp. characters
    When I type "Single Choice allowable characters" in the quiz title field
    And I add a question by clicking the button Add question
    And I select the question type as "Single-Choice"
    And I type the question as "What is BDD?" into question field of "Q1"
    And I type "sT8uKp2R9`~@#$%^&*()_+|={}[]:”;’<>?,./®©£¥¢¦§«»€" into the "Option 1" of "Q1"
    And I type "sT8uKp2R9`~@#$%^&*()_+|={}[]:”;’<>?,./®©£¥¢¦§«»€" into the "Option 2" of "Q1"
    And I select the "Option 1" from the list of options for question "Q1"
    And I click the "Save" button
    And I wait for 2 sec for the presence of all the elements on the page
    Then I should see the quiz name "Single Choice allowable characters" in the list of quizzes section
    And I "Preview" the quiz name "Single Choice allowable characters" from the list of quizzes section
    Then I verify the content displayed on the Preview mode is correct
    And I click "Close" in the confirmation window

   @positive #Issue ID: MAY23-367
   Scenario: Option 1 - 1 character Option 2 - 999 characters and the radio button is checked
     When I type "Single Choice Question" in the quiz title field
     And I add a question by clicking the button Add question
     And I select the question type as "Single-Choice"
     And I type the question as "What is BDD?" into question field of "Q1"
     And I enter 1 character into the "Option 1" of "Q1"
     And I enter 999 character into the "Option 2" of "Q1"
     And I select the "Option 1" from the list of options for question "Q1"
     And I click the "Save" button
     Then I should see the quiz name "Single Choice Question" in the list of quizzes section
     And I wait for 1 sec for the presence of all the elements on the page
     And I "Delete" the quiz name "Single Choice Question" from the list of quizzes





