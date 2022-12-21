@multiChoiceQuText
  Feature: Verify "Multiple Choice Question - Text" Nov-126

    Background:
      Given I go to "login" page KS
        When I type "schrist830@gmail.com" into email input field KS
      And I type "11111" into password field
        When I click "Sign In" button KS
      And I wait for 1 sec

    @multiChoiceQuText1
    Scenario: Minimum character limit Nov-129
      When I click "Quizzes" menu item KS
      And I wait for 1 sec
      When I click "Create New Quiz" button KS
      And I wait for 1 sec
      When I enter " HW Kristine" as quiz title KS
      And I add a question
      When I select "Multiple-Choice" question KS
      When I type "Question 1" into "Q1" textarea KS
        And I type "Option 1" into "Option 1*" field in "Q1" KS
        And I type "Option 2" into "Option 2*" field in "Q1" KS
        And I wait for 1 sec
        When I select "Option 1*" as correct option in "Q1" KS
        And I wait for 1 sec
        When I click "Save" button KS
        And I wait for 3 sec
        Then Quiz "HW Kristine" is displayed in the the list of quizzes KS

    @multiChoiceQuText2
    Scenario: Allowable characters NOV-349
      When I click "Quizzes" menu item KS
      And I wait for 1 sec
      When I click "Create New Quiz" button KS
      And I wait for 1 sec
      When I enter "Allowable characters" as quiz title KS
      And I add a question
      When I select "Multiple-Choice" question KS
      When I type "Allowable characters! 1" into "Q1" textarea KS
      And I type "Special! 1 %" into "Option 1*" field in "Q1" KS
      And I type "Special! 2 #" into "Option 2*" field in "Q1" KS
      When I select "Option 1*" as correct option in "Q1" KS
      And I wait for 1 sec
      When I click "Save" button KS
      And I wait for 3 sec
      Then Quiz "Allowable characters" is displayed in the the list of quizzes KS

    @multiChoiceQuText3
    Scenario:Required Fields NOV-126
      When I click "Quizzes" menu item KS
      And I wait for 1 sec
      When I click "Create New Quiz" button KS
      And I wait for 1 sec
      When I enter "Required Fields" as quiz title KS
      And I add a question
      When I select "Multiple-Choice" question KS
      When I select "Option 1*" as correct option in "Q1" KS
      And I wait for 1 sec
      When I click "Save" button KS
      And I wait for 3 sec
      Then error message is displayed and contains text "Quiz is not completed. Check highlighted with red areas"


    @multiChoiceQuText3
      Scenario: Maximum character limit NOV-350
      When I click "Quizzes" menu item KS
      And I wait for 1 sec
      When I click "Create New Quiz" button KS
      And I wait for 1 sec
      When I enter "Maximum character limit" as quiz title KS
      And I add a question
      And I select "Multiple" question
      And I type 1001 characters  into question  field in "Q1" KS
    And I type "Special! 1 %" into "Option 1*" field in "Q1" KS
      And I type "Special! 2 #" into "Option 2*" field in "Q1" KS
      When I select "Option 1*" as correct option in "Q1" KS
      And I wait for 1 sec
      When I click "Save" button KS
#      THis is a known issue
      Then error message should be displayed KS
      Then I delete quiz "Maximum character limit"







