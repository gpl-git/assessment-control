@textualQuestion

  Feature: Textual question - text

    Background:
      Given I open "login" page
      When I type "xhmidou.ch@daiuiae.com" into email field
      And I type "12345" into password field
      When click on "Sign In" button
      And I wait for 1 sec
      Then I click "Quizzes" link
      And I wait for 1 sec
      And click on "Create New Quiz" button
      And I wait for 2 sec

      @textualQuestion1
      Scenario: Alphanumeric and special characters
        Given I type "Alexander quiz" as a quiz title
        When I add a question
        And I select "Textual" question in question "Q1"
        When I type "some text" into textual question text field of "Q1"
        When click on "Save" button
        And I wait for 1 sec
        Then "Alexander quiz" should be displayed on the list of quizzes
        And I delete "Alexander quiz" from the list of quizzes
        And I wait for 2 sec


    @textualQuestion1
    Scenario Outline: Alphanumeric and special characters parameterized
      Given I type "Alexander quiz" as a quiz title
      When I add a question
      And I select "Textual" question in question "Q1"
      When I type <text> into textual question text field of "Q1"
      When click on "Save" button
      And I wait for 1 sec
      Then "Alexander quiz" should be displayed on the list of quizzes
      And I delete "Alexander quiz" from the list of quizzes
      And I wait for 1 sec
      Examples:
        | text        |
        | "ABCDabcd12345 !@#$%^&*()_+~" |
        | "Which of the following is not part of performance testing?wvvdvddfvvddffdfvvvdfvdvvvdvdvfdvfdvfvfddfddvfdddvdfvdfvdfvdvvvvfvgfgffjfjfjfjffjfjfjfjfjfjfjfjfjfjfjfjfjfjfjfjfjfjfjfjfjfjfjfjjfjfjfjfjfjfjfjffjfjfjfjjfjfjfjfjfjfjfjfjfjfjfjfjfjfjfjfjfjfjfjfjffjfjjjfjffjfjffjjfjfjffjfjfjfjfjffjjfjffjjfjfjfjfjfjfjfjfjfjfjfjjfjfjfjfjffjfjfjfjfjfjfjffjfjfjfjfjfjffjjfjffjffjfjfjfjfjfjfjfjfjffjfjfjfjfjffjfjfjfjfjfjfjfjfjffjfjfjfjfjffjfjfjfjfjffjfjfjfjfjffjfjfjfjfjfjfjfjffjfjfjfjfjffjjfjfjfjfjfjfjfjfjfjffjfjfjjffjfjfjjfjfjffjjfjfjffjfjfjffjfjfjfjfbgfggfffggfffgfgfgffgfgffgfggffgfgffgfgfffggfgfgfgfgfgfgfgffgfjfjfjfjfjfjjfjfjfjfjfjfjfjffjfjfjfjjfjfjfjfjfjfjfjfjfjfjfjfjfjfjfjfjfjfjfjfjffjfjjjfjffjfjffjjfjfjffjfjfjfjfjffjjfjffjjfjfjfjfjfjfjfjfjfjfjfjjfjfjfjfjffjfjfjfjfjfjfjffjfjfjfjfjfjffjjfjffjffjfjfjfjfjfjfjfjfjffjfjfjfjfjffjfjfjfjfjfjfjfjfjffjfjfjfjfjffjfjfjfjfjffjfjfjfjfjffjfjfjfjfjfjfjfjffjfjfjfjfjffjjfjfjfjfjfjfjfjfjfjffjfjfjjffjfjfjjfjfjffjjfjfjffjfjfjffjfjfjfjfbgfggfffggfffgfgfgffgfgffgfggffgfgf" |
        | "Which of the following is not part of performance testing?wvvdvddfvvddffdfvvvdfvdvvvdvdvfdvfdvfvfddfddvfdddvdfvdfvdfvdvvvvfvgfgffjfjfjfjffjfjfjfjfjfjfjfjfjfjfjfjfjfjfjfjfjfjfjfjfjfjfjfjjfjfjfjfjfjfjfjffjfjfjfjjfjfjfjfjfjfjfjfjfjfjfjfjfjfjfjfjfjfjfjfjffjfjjjfjffjfjffjjfjfjffjfjfjfjfjffjjfjffjjfjfjfjfjfjfjfjfjfjfjfjjfjfjfjfjffjfjfjfjfjfjfjffjfjfjfjfjfjffjjfjffjffjfjfjfjfjfjfjfjfjffjfjfjfjfjffjfjfjfjfjfjfjfjfjffjfjfjfjfjffjfjfjfjfjffjfjfjfjfjffjfjfjfjfjfjfjfjffjfjfjfjfjffjjfjfjfjfjfjfjfjfjfjffjfjfjjffjfjfjjfjfjffjjfjfjffjfjfjffjfjfjfjfbgfggfffggfffgfgfgffgfgffgfggffgfgffgfgfffggfgfgfgfgfgfgfgffgfjfjfjfjfjfjjfjfjfjfjfjfjfjffjfjfjfjjfjfjfjfjfjfjfjfjfjfjfjfjfjfjfjfjfjfjfjfjffjfjjjfjffjfjffjjfjfjffjfjfjfjfjffjjfjffjjfjfjfjfjfjfjfjfjfjfjfjjfjfjfjfjffjfjfjfjfjfjfjffjfjfjfjfjfjffjjfjffjffjfjfjfjfjfjfjfjfjffjfjfjfjfjffjfjfjfjfjfjfjfjfjffjfjfjfjfjffjfjfjfjfjffjfjfjfjfjffjfjfjfjfjfjfjfjffjfjfjfjfjffjjfjfjfjfjfjfjfjfjfjffjfjfjjffjfjfjjfjfjffjjfjfjffjfjfjffjfjfjfjfbgfggfffggfffgfgfgffgfgffgfggffgfgf1" |

      @textualQuestion2
      Scenario Outline: Textual question text field error messages
        Given I type "Alexander quiz" as a quiz title
        When I add a question
        And I select "Textual" question in question "Q1"
        When I type <text> into textual question text field of "Q1"
        When click on "Save" button
        Then error message <error> should be displayed
        And I wait for 1 sec
        Examples:
          | text        | error                         |
          | ""          |   "This field is required"    |
#          BugNo JUL-cccc
          | "Which of the following is not part of performance testing?wvvdvddfvvddffdfvvvdfvdvvvdvdvfdvfdvfvfddfddvfdddvdfvdfvdfvdvvvvfvgfgffjfjfjfjffjfjfjfjfjfjfjfjfjfjfjfjfjfjfjfjfjfjfjfjfjfjfjfjjfjfjfjfjfjfjfjffjfjfjfjjfjfjfjfjfjfjfjfjfjfjfjfjfjfjfjfjfjfjfjfjffjfjjjfjffjfjffjjfjfjffjfjfjfjfjffjjfjffjjfjfjfjfjfjfjfjfjfjfjfjjfjfjfjfjffjfjfjfjfjfjfjffjfjfjfjfjfjffjjfjffjffjfjfjfjfjfjfjfjfjffjfjfjfjfjffjfjfjfjfjfjfjfjfjffjfjfjfjfjffjfjfjfjfjffjfjfjfjfjffjfjfjfjfjfjfjfjffjfjfjfjfjffjjfjfjfjfjfjfjfjfjfjffjfjfjjffjfjfjjfjfjffjjfjfjffjfjfjffjfjfjfjfbgfggfffggfffgfgfgffgfgffgfggffgfgffgfgfffggfgfgfgfgfgfgfgffgfjfjfjfjfjfjjfjfjfjfjfjfjfjffjfjfjfjjfjfjfjfjfjfjfjfjfjfjfjfjfjfjfjfjfjfjfjfjffjfjjjfjffjfjffjjfjfjffjfjfjfjfjffjjfjffjjfjfjfjfjfjfjfjfjfjfjfjjfjfjfjfjffjfjfjfjfjfjfjffjfjfjfjfjfjffjjfjffjffjfjfjfjfjfjfjfjfjffjfjfjfjfjffjfjfjfjfjfjfjfjfjffjfjfjfjfjffjfjfjfjfjffjfjfjfjfjffjfjfjfjfjfjfjfjffjfjfjfjfjffjjfjfjfjfjfjfjfjfjfjffjfjfjjffjfjfjjfjfjffjjfjfjffjfjfjffjfjfjfjfbgfggfffggfffgfgfgffgfgffgfggffgfgf11"          |   "No more than 1000 characters"    |










