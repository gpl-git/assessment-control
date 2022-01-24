@quote

  Feature: Multiple Choice Question
    Background:
      Given I go to "login" page
      When I type "haimi.piter@gmail.com" into email field
      And I type "123456" into password field
      And I click "Sign In" button
      And I wait for 1 sec
      And I click "Quizzes" link
      And I wait for 1 sec

    @guote @multiple_choice_question1
      Scenario: Creating a Quiz with Multiple Choice Question
#      select 2 options
      When I click "Create New Quiz" button
      And I wait for 1 sec
      And I type "Quiz with Multiple Choice Question" as the quiz title
      When I add a question
      And I select "Multiple" question type
      And I wait for 1 sec
      When I type "Question 1" into "Q1"
      And I type"Option 1" as "Option 1*" into "Q1"
      And I type"Option 2" as "Option 2*" into "Q1"
      And I select "Option 1*" checkbox as correct option in "Q1"
      And I select "Option 2*" checkbox as correct option in "Q1"
      When I click "Save" button
      And I wait for 1 sec
      Then quiz "Quiz with Multiple Choice Question" should be displayed on the list of quizzes
      And I delete "Quiz with Multiple Choice Question"
      And I wait for 1 sec
#      select 1 option
      When I click "Create New Quiz" button
      And I wait for 1 sec
      And I type "Quiz with Multiple Choice Question" as the quiz title
      When I add a question
      And I select "Multiple" question type
      And I wait for 1 sec
      When I type "Question 1" into "Q1"
      And I type"Option 1" as "Option 1*" into "Q1"
      And I type"Option 2" as "Option 2*" into "Q1"
      And I select "Option 1*" checkbox as correct option in "Q1"
      When I click "Save" button
      And I wait for 1 sec
      Then quiz "Quiz with Multiple Choice Question" should be displayed on the list of quizzes
      And I delete "Quiz with Multiple Choice Question"
      And I wait for 1 sec
#      Empty fields Error messages
      When I click "Create New Quiz" button
      And I wait for 1 sec
      And I type "Quiz with Multiple Choice Question" as the quiz title
      When I add a question
      And I select "Multiple" question type
      When I click "Save" button
      And I wait for 1 sec
      Then Error message "This field is required" should be displayed in Question field in "Q1"
      Then Error message "This field is required" should be displayed in "Option 1*" field in "Q1"
      Then Error message "This field is required" should be displayed in "Option 2*" field in "Q1"
      Then Error message "Choose at least one correct answer" should be displayed in "Q1"
      And I wait for 1 sec
#      Quiz with "Other" text area
      When I type "Question 1" into "Q1"
      And I type"Option 1" as "Option 1*" into "Q1"
      And I type"Option 2" as "Option 2*" into "Q1"
      And I select "Option 1*" checkbox as correct option in "Q1"
      When I select Include Other text area option in "Q1"
      When I click "Save" button
      And I wait for 1 sec
      Then quiz "Quiz with Multiple Choice Question" should be displayed on the list of quizzes
      And I delete "Quiz with Multiple Choice Question"
      And I wait for 1 sec

    @quote @multiple_choice_question2
      Scenario: preview window verification
      When I click "Create New Quiz" button
      And I wait for 1 sec
      And I type "Quiz with Multiple Choice Question" as the quiz title
      When I add a question
      And I select "Multiple" question type
      When I type "Question 1" into "Q1"
      And I type"Option 1" as "Option 1*" into "Q1"
      And I type"Option 2" as "Option 2*" into "Q1"
      And I select "Option 1*" checkbox as correct option in "Q1"
      When I click "Preview" button
      Then The PREVIEW MODE window should be displayed
      And I wait for 2 sec
