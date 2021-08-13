@quizTQ
Feature: Quiz - Total Questions Scenarios
# Automation Test Set JUL-128

  Background:
    Given I open "login" page
    When I type "ask_instr@aol.com" into email field
    And I type "12345" into password field
    When click on "Sign In" button
    And I wait for 1 sec
    Then I click "Quizzes" link
    And I wait for 1 sec
    And click on "Create New Quiz" button
    And I wait for 2 sec

  @quizTQ1
  Scenario Outline: JUL-129, JUL-132, JUL-133. Verify the Quiz with number of questions 5 can be created
    When I type <title> as a quiz title
    Then I am creating <questionNumbers> "Textual" questions
    And click on "Save" button
    And I wait for 2 sec
    Then <title> should be displayed on the list of quizzes
    And I delete <title> from the list of quizzes
    Examples:
      | title     | questionNumbers |
      | "! Quiz1" | 1               |
      | "! Quiz2" | 5               |
      | "! Quiz3" | 50              |

  @quizTQ2 @ignore
  Scenario: JUL-135. Verify the Quiz with number of questions 51 cannot be created
#    Opened bug JUL-180
    When I type "! Quiz4" as a quiz title
    Then I am creating 51 "Textual" questions
    And click on "Save" button
    And I wait for 2 sec
#    pass
    And I delete "! Quiz4" from the list of quizzes

  @quizTQ3
  Scenario Outline: JUL-138. Verify the total number of Questions is displayed on Preview Mode page while creating a new Quiz
    When I type <title> as a quiz title
    Then I am creating <totalQuestions> "Textual" questions
    And click on "Preview" button
    And I wait for 2 sec
    Then Question <totalQuestions> should be displayed on the list of preview mode
    And click on "Close" button
    And click on "Save" button
    And I wait for 2 sec
    And I delete <title> from the list of quizzes
    Examples:
      | title     | totalQuestions |
      | "! Quiz5" | 3              |

  @quizTQ4
  Scenario Outline: JUL-140, JUL-141. Verify the total number of Questions is displayed on the scroller of Quizzes next to the Quiz Title
    When I type <title> as a quiz title
    Then I am creating <totalQuestions> "Textual" questions
    And click on "Save" button
    And I wait for 1 sec
    Then <totalQuestions> total number of Questions for <title> should be displayed on the <scroller> of quizzes
    And I wait for 1 sec
    And I delete <title> from the list of quizzes
    Examples:
      | title     | totalQuestions | scroller   |
      | "! Quiz6" | 3              | "Quizzes"  |
      | "! Quiz7" | 4              | "Dropdown" |

  @quizTQ5
  Scenario Outline: JUL-150. Verify the total number of Questions is displayed in Preview Mode on "Quizzes" page
    When I type <title> as a quiz title
    Then I am creating <totalQuestions> "Textual" questions
    And click on "Save" button
    And I wait for 1 sec
    When Click the dropdown button next to the <title> title
    And I wait for 1 sec
    And I click "Preview" <title> from the list of quizzes
    Then Question <totalQuestions> should be displayed on the list of preview mode
    And click on "Close" button
    When Click the dropdown button next to the <title> title
    And I wait for 1 sec
    And I delete <title> from the list of quizzes
    Examples:
      | title     | totalQuestions |
      | "! Quiz8" | 3              |
