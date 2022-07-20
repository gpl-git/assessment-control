@quiz
  Feature: Multiple-Choice Question: Options

    Background:
      Given I go to "login" page OK
      When I type "jon.snow@gfthrones.com" into email field OK
      And I type "12345" for password OK
      Then I click button "Sign In" OK
      And I wait for 1 sec OK
      When I click "Quizzes" menu item OK
      Then I wait for 2 sec OK
      And I click button "Create New Quiz" OK
      And I wait for 1 sec OK
      Then I type "*Quiz- Olga" as quiz title OK
      And I add a question OK
      And I wait for 1 sec OK
      When I select "Multiple-Choice" question type OK
      And I type "Question name" into "Q1" OK

    @quiz1
      Scenario: Max <=1000 characters
      When I enter 1000 alphanumeric characters as "Option 1*" into "Q1" OK
      And I enter 1000 alphanumeric characters as "Option 2*" into "Q1" OK
      And I select "Option 1*" as correct option in "Q1" OK
      And I select "Option 2*" as correct option in "Q1" OK
      And I click button "Save" OK
      And I wait for 2 sec OK
      Then quiz "*Quiz- Olga" should be displayed on the list of quizzes OK
      And I wait for 2 sec OK
      And I delete "*Quiz- Olga" OK

    @quiz2
      Scenario: Max >=1000 characters
      When I enter 1001 alphanumeric characters as "Option 1*" into "Q1" OK
      And I enter 1001 alphanumeric characters as "Option 2*" into "Q1" OK
      And I select "Option 1*" as correct option in "Q1" OK
      And I select "Option 2*" as correct option in "Q1" OK
      And I click button "Save" OK
      Then error message should be displayed
      And I wait for 2 sec OK
      Then quiz "*Quiz- Olga" should be displayed on the list of quizzes OK
      And I wait for 2 sec OK
      And I delete "*Quiz- Olga" OK

    @quiz3
    Scenario: Max <=15 choices
      When I type "Option 1" as "Option 1*" into "Q1" OK
      And I type "Option 2" as "Option 2*" into "Q1" OK
      And I select "Option 1*" as correct option in "Q1" OK
      When I add up to 15 options to "Q1"
      When I click button "Save" OK
      And I wait for 2 sec OK
      Then quiz "*Quiz- Olga" should be displayed on the list of quizzes OK
      And I wait for 2 sec OK
      And I delete "*Quiz- Olga" OK
# failing on my machine, but passing on Galina's

    @quiz4
    Scenario: Max >=16 choices
      When I type "Option 1" as "Option 1*" into "Q1" OK
      And I type "Option 2" as "Option 2*" into "Q1" OK
      And I select "Option 1*" as correct option in "Q1" OK
      When I add up to 16 options to "Q1"
      When I click button "Save" OK
      Then error message should be displayed
      And I wait for 2 sec OK
      Then quiz "*Quiz- Olga" should be displayed on the list of quizzes OK
      And I wait for 2 sec OK
      And I delete "*Quiz- Olga" OK
# failing as @quiz3

    @quiz5
    Scenario: Verify the teacher unable to add <2 'Options' for the question
      When I click on gear icon near "Option 1*" OK
      And I wait for 1 sec OK
      And I click button "Delete Option" OK
      And button "Delete Option" is disabled OK
      And I wait for 2 sec OK
      Then I verify that number of options equals 2
      And I wait for 2 sec OK

    @quiz6
    Scenario: Verify teacher chose at least one correct answer
      When I type "Option 1" as "Option 1*" into "Q1" OK
      And I type "Option 2" as "Option 2*" into "Q1" OK
      And I select "Option 1*" as correct option in "Q1" OK
      And I click button "Save" OK
      And I wait for 2 sec OK
      Then quiz "*Quiz- Olga" should be displayed on the list of quizzes OK
      And I wait for 2 sec OK
      And I delete "*Quiz- Olga" OK

   @quiz7
   Scenario: Verify teacher can not save quiz with at least one correct answer
     When I type "Option 1" as "Option 1*" into "Q1" OK
     And I type "Option 2" as "Option 2*" into "Q1" OK
     And I click button "Save" OK
     Then error message should be displayed
     And I wait for 2 sec OK

    @quiz8
    Scenario: Verify the teacher able to select all the options as correct answers
      When I type "Option 1" as "Option 1*" into "Q1" OK
      And I type "Option 2" as "Option 2*" into "Q1" OK
      And I select "Option 1*" as correct option in "Q1" OK
      And I select "Option 2*" as correct option in "Q1" OK
      And I click button "Save" OK
      And I wait for 2 sec OK
      Then quiz "*Quiz- Olga" should be displayed on the list of quizzes OK
      And I wait for 2 sec OK
      And I delete "*Quiz- Olga" OK

    @quiz9
    Scenario: Verify the 'Move Option Up' button is functioning and that correct 'option's text moved
      When I type "Option 1" as "Option 1*" into "Q1" OK
      And I type "Option 2" as "Option 2*" into "Q1" OK
      When I click on gear icon near "Option 2*" OK
      Then a pop up menu should be displayed
      And I click button with an up arrow "Move option up" OK
      And I verify that text of "Option 2*" moved to "Option 1*"
      And I wait for 2 sec OK

    @quiz10
    Scenario: Verify the 'Move Option Down' button is functioning and that correct 'option's text moved
      When I type "Option 1" as "Option 1*" into "Q1" OK
      And I type "Option 2" as "Option 2*" into "Q1" OK
      When I click gear icon near "Option 1*" OK
      Then a pop up menu should be displayed
      And I click button with a down arrow "Move option down" OK
      And I verify that text of "Option 1*" moved to the "Option 2*"
      And I wait for 2 sec OK

    @quiz11
    Scenario: Verify that teacher able to Use delete Option only for questions with =>3 correct answers
      When I type "Option 1" as "Option 1*" into "Q1" OK
      And I type "Option 2" as "Option 2*" into "Q1" OK
      Then I click button "Add Option" OK
      And I type "Option 3" as "Option 3*" into "Q1" OK
      And I select "Option 1*" as correct option in "Q1" OK
      And I select "Option 2*" as correct option in "Q1" OK
      When I click on gear image near "Option 3*" OK
      And I click menu button "Delete Option" OK
      And I wait for 2 sec OK












