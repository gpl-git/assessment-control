@textualquestion

  Feature: Textual question - text
    Background:
      Given I open "login" website
      When I type "ask_instr@aol.com" into email field
      When  I type "12345" into password field
      And I click "Sign In" button
      And I wait for 1 sec
      When I click "Quizzes" menu item
      And I wait for 1 sec
      And I click "Create New Quiz" button
      And I wait for 1 sec

    @textualquestion1
    Scenario: Minimum 1 character
      Given I type "Anna Quiz Demo" as quiz title
      And I add question
      Then I select "Textual" question type
      And I type "a" into question field
      And I click "Save" button
      Then title "Anna Quiz Demo" should be displayed on the list of quizzes
      And I wait for 3 sec
      And I delete quiz  "Anna Quiz Demo"


      @textualquestion2
      Scenario: Max 1000 characters
        Given I type "Anna Quiz Demo thousand" as quiz title
        And I add question
        Then I select "Textual" question type
        And And I type 1000 characters into question field
        And I wait for 5 sec
        And I click "Save" button
        And I wait for 5 sec
        Then title "Anna Quiz Demo thousand" should be displayed on the list of quizzes
        And I wait for 3 sec
        And I delete quiz  "Anna Quiz Demo thousand"

        @textualquestion3
        Scenario: 1001 characters are not allowed
          Given I type "Anna Quiz Demo thousand one" as quiz title
          And I add question
          Then I select "Textual" question type
          And And I type 1001 characters into question field
          And I wait for 5 sec
          And I click "Save" button
          And I wait for 5 sec
          Then title "Anna Quiz Demo thousand one" should be displayed on the list of quizzes
          And I wait for 3 sec
          And I delete quiz  "Anna Quiz Demo thousand one"


          @textualquestion4
          Scenario: Allowable characters: Alphanumeric & Sp. characters
            Given I type "Anna Quiz Demo characters" as quiz title
            And I add question
            Then I select "Textual" question type
            And I type "as23!!??" into question field
            And I click "Save" button
            And I wait for 5 sec
            Then title "Anna Quiz Demo characters" should be displayed on the list of quizzes
            And I wait for 3 sec
            And I delete quiz  "Anna Quiz Demo characters"


            @textualquestion5
            Scenario: The field is required
              Given I type "Anna Quiz Demo required" as quiz title
              And I add question
              Then I select "Textual" question type
              And I type "" into question field
              And I wait for 3 sec
              And I click "Save" button
              Then "This field is required" error message should be displayed

              @textualquestion6
              Scenario: Show-stopper question
                Given I type "Anna Quiz Demo Show-Stopper" as quiz title
                And I add question
                Then I select "Textual" question type
                And I type "What's your name" into question field
                And I select "Is "Show-Stopper" question?" checkbox
                And I wait for 3 sec
                Then the Show-stopper checkbox is selected




