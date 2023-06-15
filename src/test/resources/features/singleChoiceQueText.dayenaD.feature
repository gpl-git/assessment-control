@scQueText
Feature:Single choice question-text

  Background:
    Given I go to "Login" page dp
    When I type "dagciom@ebarg.net" in the email field
    And I type "test123" in the password field dp
    And I click on "Sign In" button dp
    And I delay for 2 sec dp
    When I click on "Quizzes" dp
    And I wait for 2 sec dp
    And I click on "Create New Quiz"
    And I delay for 2 sec dp
    When I type "Dayena's test quiz" as quiz title dp
    And I click on "Add Question" button
    And I delay for 2 sec dp
    And I select "Single-Choice" option dp
    And I delay for 2 sec dp

  @scQueText1
    Scenario: Verify the Question text field accepts maximum of 1000 characters

    When I type 1000 characters in question field of "Q1"
    And I delay for 2 sec dp
    And I type "opt1" into "Option1" field of"Q1"
    And I delay for 2 sec dp
    And I enter "opt2" in "Option2" field of "Q1"
    And I delay for 2 sec dp
    When I select "opt1" as a correct answer in "Q1"
    And I click on "Save" butten
    And I delay for 2 sec dp
    Then "Dayena's test quiz" is dispalyed on the Quizzes list
    And I delay for 3 sec dp

  @scQueText2
    Scenario: Verify the Question text field accepts minimum of 1 character
    When I type "e" in the question text field area
    And I delay for 2 sec dp
    And I type "opt1" into "Option1" field of"Q1"
    And I delay for 2 sec dp
    And I enter "opt2" in "Option2" field of "Q1"
    And I delay for 2 sec dp
    When I select "opt1" as a correct answer in "Q1"
    And I click on "Save" butten
    And I delay for 2 sec dp
    Then "Dayena's test quiz" is dispalyed on the Quizzes list
    And I delay for 3 sec dp


  @scQueText3
  Scenario:Verify the question text field with 1001 characters.
    When I type 1001 characters in question field of "Q1"
    And I delay for 2 sec dp
    #known Error [MAY23-275]
    Then Error message of exceeded limit should be displayed



  @scQueText4
  Scenario: Verify the Question text field with a blank value/Verify Question text field is mandatory
    When I click in the text field of "Q1"
    And I click on option1 button
    Then error message of required field should be displayed
    And I delay for 2 sec dp

  @scQueText5
  Scenario:Verify the Question text field accepts both Alphanumeric & Sp. characters
    When I type "a5ou6jt7gm@#!&*ydxc7tijq3avd67 78999@!!" in the question text field
    And I delay for 2 sec dp
    And I type "opt1" into "Option1" field of"Q1"
    And I delay for 2 sec dp
    And I enter "opt2" in "Option2" field of "Q1"
    And I delay for 2 sec dp
    When I select "opt1" as a correct answer in "Q1"
    And I click on "Save" butten
    And I delay for 2 sec dp
    Then "Dayena's test quiz" is dispalyed on the Quizzes list
    And I delay for 3 sec dp

  @scQueText6
  Scenario: Verify the Question text field with only special characters
    When I type "@#@%&%$#@!)(&" in the question text field
    And I delay for 2 sec dp
    And I type "opt1" into "Option1" field of"Q1"
    And I delay for 2 sec dp
    And I enter "opt2" in "Option2" field of "Q1"
    And I delay for 2 sec dp
    When I select "opt1" as a correct answer in "Q1"
    And I click on "Save" butten
    And I delay for 2 sec dp
    Then "Dayena's test quiz" is dispalyed on the Quizzes list
    And I delay for 3 sec dp







