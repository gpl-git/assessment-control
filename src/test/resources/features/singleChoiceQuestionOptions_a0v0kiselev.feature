Feature: Single Choice Question - Options

  Background:
    * I go to "login" page
    * I type "qa@ask.com" into email field
    * I type "12345" into password field
    * I click element titled "Sign In"
    * I wait for page update
    * I click element titled "Quizzes"
    * I wait for page update
    * I remove all quizzes named "a0v0kiselev-DEC-736"

  Scenario Outline: Valid symbols
    * I click element titled "Create New Quiz"
    * I wait for 1 sec
    * I type "a0v0kiselev-DEC-736" as the quiz title
    * I click element titled "Add Question"
    * I wait 500 ms
    * I click radio button titled "Single-Choice"
    * I wait 500 ms
    * I type "Q1" into "question" field
    * I type <text> into #1 "option" field
    * I type <text> into #2 "option" field
    * I mark #1 "option" field
    * check #1 "option" field match <text>
    * check #2 "option" field match <text>
    * I click element titled "Save"
    * I wait for page update
    * I click element titled "a0v0kiselev-DEC-736"
    * I click element titled "Preview"
    * in dialog
    * radio button #1 titled <brief_text> is visible
    * radio button #2 titled <brief_text> is visible
    Examples:
      | text           | brief_text     |
      | "a\nb"         | "a b"          |
      | "[:ascii-nc:]" | "[:ascii-nc:]" |
      | "[:Ax1000:]"   | "[:Ax1000:]"   |

  Scenario: Moving options
    * I click element titled "Create New Quiz"
    * I wait for 1 sec
    * I type "a0v0kiselev-DEC-736" as the quiz title
    * I click element titled "Add Question"
    * I click radio button titled "Single-Choice"
    * I type "Q1" into "question" field
    * I type "A1" into #1 "option" field
    * I type "A2" into #2 "option" field
    * I click #1 "option" field "settings" icon
    * I wait for 1 sec
    * in menu
    * I click element titled "Move option down"
    * on page
    * check #1 "option" field match "A2"
    * check #2 "option" field match "A1"
