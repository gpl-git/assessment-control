@sc_text
  Feature: Single_Question_Text

    Background:
      Given Person goes to "login" page
      When Person types "jf6jscoa5q@persatuanburuh.us" into email field
      And Person types "12345" into password field
      When Person clicks "Sign In" button
      And Person waits for 1 sec
      When Person clicks "Quizzes" menu item
      And Person waits for 1 sec
      And Person clicks "Create New Quiz" button
      And Person waits for 1 sec

    @quiz1
    Scenario: Create a quiz with sc_question
      When Person types "Quiz 040423" in title field
      And Person adds question
      And Person waits for 1 sec
      Then Person selects "Single-Choice" question type
      When Person types "Quiz 040423" into textarea field into "Q1"
      And Person types "Option 1" into "Option 1*" field in "Q1"
      And Person types "Option 2" into "Option 2*" field in "Q1"
      Then Person select "Option 1*" as correct option in "Q1"
      And Person clicks "Save" button
      And Person waits for 2 sec
      Then title "Quiz 040423" is displayed on list of quizzes
      And Person waits for 1 sec
      And Person deletes "Quiz 040423" from list of quizzes
      And Person waits for 2 sec


    @quiz2
    Scenario Outline: Create a quiz with sc_question Outline
      When Person types "Quiz 040423" in title field
      And Person adds question
      And Person waits for 1 sec
      Then Person selects "Single-Choice" question type
      When Person types <questionText> into textarea field into "Q1"
      And Person waits for 2 sec
      And Person types "Option 1" into "Option 1*" field in "Q1"
      And Person types "Option 2" into "Option 2*" field in "Q1"
      Then Person select "Option 1*" as correct option in "Q1"
      And Person clicks "Save" button
      And Person waits for 2 sec
      Then title "Quiz 040423" is displayed on list of quizzes
      And Person waits for 1 sec
      And Person deletes "Quiz 040423" from list of quizzes
      And Person waits for 2 sec
      Examples:
        | questionText  |
        | "Q"           |
        | "901"        |
        | "%$#()@"       |
        | "c10%^$?01"       |




    @quiz3
    Scenario: Create a quiz with sc_question text empty input
      When Person types "Quiz 040423" in title field
      And Person adds question
      And Person waits for 1 sec
      Then Person selects "Single-Choice" question type
      And Person types "Option 1" into "Option 1*" field in "Q1"
      And Person types "Option 2" into "Option 2*" field in "Q1"
      Then Person select "Option 1*" as correct option in "Q1"
      And Person clicks "Save" button
      And Person waits for 1 sec
      Then question text error message should be displayed "This field is required"

    @quiz4
    Scenario: Create a quiz with sc_question (999 and 1000 characters)
      When Person types "Quiz 040423" in title field
      And Person adds question
      And Person waits for 1 sec
      Then Person selects "Single-Choice" question type
      When Person types 1000 alphanumeric characters into textarea field into "Q1"
      And Person waits for 2 sec
      And Person types "Option 1" into "Option 1*" field in "Q1"
      And Person types "Option 2" into "Option 2*" field in "Q1"
      Then Person select "Option 1*" as correct option in "Q1"
      And Person clicks "Save" button
      And Person waits for 2 sec
      Then title "Quiz 040423" is displayed on list of quizzes
      And Person waits for 2 sec
      And Person deletes "Quiz 040423" from list of quizzes
      And Person waits for 2 sec


    @quiz5
#      bug report FEB23-149
    Scenario: Create a quiz with sc_question (more than 1000 characters)
      When Person types "Quiz 040423" in title field
      And Person adds question
      And Person waits for 1 sec
      Then Person selects "Single-Choice" question type
      When Person types 1001 alphanumeric characters into textarea field into "Q1"
      And Person waits for 2 sec
      And Person types "Option 1" into "Option 1*" field in "Q1"
      And Person types "Option 2" into "Option 2*" field in "Q1"
      Then Person select "Option 1*" as correct option in "Q1"
      And Person clicks "Save" button
      And Person waits for 2 sec
      Then  error message should be displayed "More than 1000 characters not accepted"




