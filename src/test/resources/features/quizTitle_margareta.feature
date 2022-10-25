@quizTitle
Feature: Quiz Title Behavior

  Background:
    Given I'm opening "login" page
    When I type "qa.sofi@gmail.com" as an email
    And I type "12345" as password
    When I click "Sign In" button
    And I wait for 1 sec
    Then "home" page will be displayed
    When I click on "Quizzes" from menu item
    And I wait for 1 sec

  @quizTitle1
    Scenario: Create a quiz
    When I click "Create New Quiz" button
    And I wait for 2 sec
    When I type "Internship" as a quiz title
    And I add a question
    And I wait for 1 sec
    Then I clear element with xpath "Title Of The Quiz"

  @quizTitle2
    Scenario: Quiz Title Field Accepts Numbers
    When I click "Create New Quiz" button
    And I wait for 2 sec
    When I type "25102022" as a quiz title
    And I add a question
    And I wait for 1 sec
    Then I clear element with xpath "Title Of The Quiz"

  @quizTitle3
    Scenario: Quiz Title Field Accepts Special Characters
    When I click "Create New Quiz" button
    And I wait for 2 sec
    When I type "!@#$%" as a quiz title
    And I add a question
    And I wait for 1 sec
    Then I clear element with xpath "Title Of The Quiz"

  @quizTitle4
  Scenario: Unable to create a quiz with empty "Title Of the Quiz*" field
    When I click "Create New Quiz" button
    And I wait for 2 sec
    When I type "" as a quiz title
    And I wait for 2 sec
    And I click outside input field
    And I wait for 2 sec
    Then error message should be displayed
    Then error message "This field is required" should be displayed

   @quizTitle5
   Scenario: Quiz Title field is marked as required with asterisk (*)
     When I click "Create New Quiz" button
     And I wait for 2 sec
     Then element "Title Of The Quiz *" should be present
     And I wait for 1 sec

     @quizTitle6
     Scenario: Quiz Title field can have one character
       When I click "Create New Quiz" button
       And I wait for 2 sec
       When I type "m" as a quiz title
       And I add a question
       And I wait for 1 sec
       Then I clear element with xpath "m"

     @quizTitle7
     Scenario: Quiz Title field can have 1000 character
       When I click "Create New Quiz" button
       And I wait for 2 sec
       When I type "kjdngjkdnbgjkdnbgkjfbgkjdf" as a quiz title
       And I add a question
       And I wait for 1 sec
       Then I clear element with xpath "kjdngjkdnbgjkdnbgkjfbgkjdf"

     @quizTitle8
     Scenario: Quiz Title can not have 1001 character
       When I click "Create New Quiz" button
       And I wait for 2 sec
       When I type "jfhgvjshgshgvsfhgjshvghvghjvjghvjhgvjhg" as a quiz title
       And I add a question
       And I wait for 1 sec
       Then I clear element with xpath "jfhgvjshgshgvsfhgjs..."

      @quizTitle9
      Scenario: Quiz Title can not have only space characters
        When I click "Create New Quiz" button
        And I wait for 2 sec
        When I type " " as a quiz title
        And I add a question
        And I wait for 1 sec
        When I select "Textual" question
        And I wait for 2 sec
        When I type "What is Quality Assurance?" into "Q1"
        And I wait for 2 sec
        Then I click "Save" button
        And I wait for 2 sec

      @quizTitle10
        Scenario: Quiz Title must have at least one non space character
        When I click "Create New Quiz" button
        And I wait for 2 sec
        When I type " +1 " as a quiz title
        And I add a question
        And I wait for 1 sec
        When I select "Textual" question
        And I wait for 2 sec
        When I type "What is Quality?" into "Q1"
        And I wait for 2 sec
        Then I click "Save" button
        And I wait for 2 sec
