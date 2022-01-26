@mcq_text

  Feature: Multiple Choice question Text
    Background:
      Given I go to "login" page
      When I type "haimi.piter@gmail.com" into email field
      And I type "123456" into password field
      And I click "Sign In" button
      And I wait for 1 sec
      And I click "Quizzes" link
      And I wait for 1 sec
      And I click "Create New Quiz" button
      And I wait for 1 sec
      And I type "Quiz with Multiple Choice Question" as the quiz title
      And I add a question
      And I select "Multiple" question type
      And I wait for 1 sec

      @mcg_text1
      Scenario Outline: Allowable characters: Alphanumeric & Sp. characters - Outline
        When I type <message> into required fields in "Q1"
        And I select "Option 1*" checkbox as correct option in "Q1"
        When I click "Save" button
        And I wait for 1 sec
        Then quiz "Quiz with Multiple Choice Question" should be displayed on the list of quizzes
        And I delete "Quiz with Multiple Choice Question"
        And I wait for 1 sec
        Examples:
          | message                  |
          | "EC112345gjyAA@!#$$^%&*" |
          | "1234567890"             |
          | "ASDFghjkl"              |
          | "!@#$%^&*()"             |
#     Spaces only !
          | " "                      |

      @mcq_text2
      Scenario: The field is required - not entering any field
        When I click "Save" button
        And I wait for 1 sec
        Then Error message "This field is required" should be displayed in Question field in "Q1"
        Then Error message "This field is required" should be displayed in "Option 1*" field in "Q1"
        Then Error message "This field is required" should be displayed in "Option 2*" field in "Q1"
        Then Error message "Choose at least one correct answer" should be displayed in "Q1"
        And I wait for 1 sec

    @mcq_text3
    Scenario Outline: Verify min/max characters in Question and Option text areas - Outline
      When I type <numChars> characters into "Q1"
      And I select "Option 1*" checkbox as correct option in "Q1"
      When I click "Save" button
      And I wait for 2 sec
      Then quiz "Quiz with Multiple Choice Question" should be displayed on the list of quizzes
      And I delete "Quiz with Multiple Choice Question"
      And I wait for 1 sec
      Examples:
        | numChars |
        | 1000     |
        | 1        |
#        Bug DEC-201 (more 1000 characters):
        | 1001     |




    