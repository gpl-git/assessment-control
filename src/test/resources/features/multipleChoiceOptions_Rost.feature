@MultOptions
Feature:Multiple Choice Question - Options

  Background:
    Given I navigate to "login" page
    When I enter the teachers email "fatehpurkumar@24hinbox.com" into email field
    And I enter the password "kyleortegaday1" into password field
    And I click the "Sign In" button
    And I wait for 1 sec for the presence of all the elements on the page
    Then I should see the text "TEACHER" present in the home page
    When I click the "Quizzes" menu item from the home page
    And I click "Create New Quiz" button under the list of quizzes section


  @MultOptions1
  Scenario: Add option
    When I type "Add Option" in the quiz title field
    And I add a question by clicking the button Add question
    And I select the question type as "Multiple-Choice"
    And I wait for 1 sec
    And I add an option
    Then I verify that textarea "Option 3" is displayed
    And I wait for 1 sec
    When I add an option
    Then I verify that textarea "Option 4" is displayed
    And I wait for 1 sec
    When I add an option
    Then I verify that textarea "Option 5" is displayed
    And I wait for 5 sec

  @MultOptions2
  Scenario: The Option field is required, can not be empty
    When I type "Field is required" in the quiz title field
    And I add a question by clicking the button Add question
    And I select the question type as "Multiple-Choice"
    And I wait for 1 sec
    And I click the "Save" button
    Then error message with text "This field is required" should be displayed under the "Option 1" field
    And error message with text "This field is required" should be displayed under the "Option 2" field




