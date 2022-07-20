@singleChoice
  Feature: Single-Choice Question: Options

    Background:
      Given I go to "login" page rv
      When I type "kriskiss@noisemails.com" into email field rv
      And I enter "54321" as password rv
      When I click button "Sign In" rv
      And I wait for 1 sec rv
      When I click "Quizzes" menu item rv
      And I wait for 2 sec rv

      @singleChoice1
      Scenario: Verify Single-Choice - Options: Default Options 2
        When I click button "Create New Quiz" rv
        And I wait for 1 sec rv
        When I type "Default Options 2" as quiz title rv
        And I add a question rv
        And I wait for 1 sec rv
        When I select "Single" question type rv
        And I type "Hello World" into "Q1" rv
        When I type "Good Evening" as "Option 1*" into "Q1" rv
        And I type "Good Morning" as "Option 2*" into "Q1" rv
        And I select "Option 2*" as correct option in "Q1" rv
        Then I click button "Save" rv
        And I wait for 1 sec rv
        Then quiz "Default Options 2" should be displayed on the list of quizzes rv
        And I wait for 2 sec rv
        Then I delete "Default Options 2" rv
        And I wait for 2 sec rv

        @singleChoice2
        Scenario: Verify Single-Choice-Options: with 1000 characters
          When I click button "Create New Quiz" rv
          And I wait for 2 sec rv
          When I type "1000 characters" as quiz title rv
          And I add a question rv
          And I wait for 2 sec rv
          When I select "Single" question type rv
          And I type "Hello World" into "Q1" rv
          When I enter 1000 alphanumeric characters as "Option 1*" into "Q1" rv
          And I type "Good Morning" as "Option 2*" into "Q1" rv
          And I select "Option 2*" as correct option in "Q1" rv
          Then I click button "Save" rv
          And I wait for 2 sec rv
          Then quiz "1000 characters" should be displayed on the list of quizzes rv
          And I wait for 5 sec rv
          Then I delete "1000 characters" rv
          And I wait for 5 sec rv

          @singleChoice3
          Scenario: Verify Single-Choice-Options: with 1001 characters
            When I click button "Create New Quiz" rv
            And I wait for 2 sec rv
            When I type "1001 characters" as quiz title rv
            And I add a question rv
            And I wait for 2 sec rv
            When I select "Single" question type rv
            And I type "Hello World" into "Q1" rv
            When I enter 1001 alphanumeric characters as "Option 1*" into "Q1" rv
            And I type "Good Morning" as "Option 2*" into "Q1" rv
            And I select "Option 2*" as correct option in "Q1" rv
            Then I click button "Save" rv
            And I wait for 2 sec rv
            Then quiz "1001 characters" should be displayed on the list of quizzes rv
            And I wait for 5 sec rv
            Then I delete "1001 characters" rv
            And I wait for 5 sec rv

            @singleChoice4
            Scenario: Verify Single-Choice-Options: with 15 options
              When I click button "Create New Quiz" rv
              And I wait for 1 sec rv
              When I type "15 options" as quiz title rv
              And I add a question rv
              And I wait for 1 sec rv
              When I select "Single" question type rv
              And I type "Hello World" into "Q1" rv
              When I type "Good Evening" as "Option 1*" into "Q1" rv
              And I type "Good Morning" as "Option 2*" into "Q1" rv
              When I add up to 15 options in "Q1"
              And I select "Option 2*" as correct option in "Q1" rv
              And I click button "Save" rv
              And I wait for 2 sec rv
              Then quiz "15 options" should be displayed on the list of quizzes rv
              And I wait for 2 sec rv
              Then I delete "15 options" rv
              And I wait for 5 sec rv


            @singleChoice5
              Scenario: Verify Single-Choice-Options: with 16 options
                When I click button "Create New Quiz" rv
                And I wait for 1 sec rv
                When I type "16 options" as quiz title rv
                And I add a question rv
                And I wait for 1 sec rv
                When I select "Single" question type rv
                And I type "Hello World" into "Q1" rv
                When I type "Good Evening" as "Option 1*" into "Q1" rv
                And I type "Good Morning" as "Option 2*" into "Q1" rv
                When I add up to 16 options in "Q1"
                And I select "Option 2*" as correct option in "Q1" rv
                And I click button "Save" rv
                And I wait for 2 sec rv
                Then quiz "16 options" should be displayed on the list of quizzes rv
                And I wait for 2 sec rv
                Then I delete "16 options" rv
                And I wait for 5 sec rv

                @singleChoice6
                Scenario: Verify Single Choice - Option: Empty Text Field
                  When I click button "Create New Quiz" rv
                  And I wait for 1 sec rv
                  When I type "Empty Text Field" as quiz title rv
                  And I add a question rv
                  And I wait for 1 sec rv
                  When I select "Single" question type rv
                  And I type "Hello World" into "Q1" rv
                  When I type "" as "Option 1*" into "Q1" rv
                  And I type "" as "Option 2*" into "Q1" rv
                  And I select "Option 2*" as correct option in "Q1" rv
                  And I click button "Save" rv
                  Then errors message "This field is required" should be displayed rv
                  And I wait for 2 sec rv

                  @singleChoice7
                   Scenario: Verify Single Choice - Option: with No Corrrect Answer
                    When I click button "Create New Quiz" rv
                    And I wait for 1 sec rv
                    When I type "No Correct Answer" as quiz title rv
                    And I add a question rv
                    And I wait for 1 sec rv
                    When I select "Single" question type rv
                    And I type "Hello World" into "Q1" rv
                    When I type "Good Evening" as "Option 1*" into "Q1" rv
                    And I type "Good Morning" as "Option 2*" into "Q1" rv
                    Then I click button "Save" rv
                    Then error message "*Choose correct answer" is displayed rv
                    And I wait for 2 sec rv

                   @singleChoice8
                   Scenario: Verify Single Choice - Option: with One Character
                     When I click button "Create New Quiz" rv
                     And I wait for 1 sec rv
                     When I type "One Character" as quiz title rv
                     And I add a question rv
                     And I wait for 1 sec rv
                     When I select "Single" question type rv
                     And I type "Hello World" into "Q1" rv
                     When I type "a" as "Option 1*" into "Q1" rv
                     And I type "b" as "Option 2*" into "Q1" rv
                     And I select "Option 2*" as correct option in "Q1" rv
                     Then I click button "Save" rv
                     And I wait for 1 sec rv
                     Then quiz "One Character" should be displayed on the list of quizzes rv
                     And I wait for 3 sec rv
                     Then I delete "One Character" rv
                     And I wait for 5 sec rv

                     @singleChoice9
                     Scenario: Verify Single Choice - Option: Delete Option
                       When I click button "Create New Quiz" rv
                       And I wait for 1 sec rv
                       When I type "Delete Option" as quiz title rv
                       And I add a question rv
                       And I wait for 1 sec rv
                       When I select "Single" question type rv
                       And I type "Hello World" into "Q1" rv
                       When I type "a" as "Option 1*" into "Q1" rv
                       And I type "b" as "Option 2*" into "Q1" rv
                       Then I press on Add Option
                       And I type "c" as "Option 3*" into "Q1" rv
                       Then I select "Option 2*" as correct option in "Q1" rv
                       And I wait for 1 sec rv
                       Then I click on settings icon "Option 3*" rv
                       And I wait for 1 sec rv
                       And I delete Option rv
                       And I wait for 1 sec rv
                       Then I verify that the number of options equals 2
                       And I wait for 1 sec rv








