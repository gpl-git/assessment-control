@quizTitle
  Feature: Quiz Title

    Background:
      Given I go to "login" page
      When I type "gmedo201596c@mymailcr.com" into email field
      And I type "12345" into password field
      When I click on "Sign in" button
      And I wait for 1 sec
      And I click on "Quizzes" link
      And I wait for 1 sec

    @quizTitle1
    Scenario: Quiz Title allows characters: Alphanumeric & Sp. characters
      When I click "Create New Quiz" button
      And I wait for 1 sec
      And I type "Quiz 123@#$%!" as quiz title
      And quiz title "Quiz 123@#$%!" should be displayed at the top
      And I wait for 1 sec

@quizTitle2
Scenario: Quiz title field is required
  When I click "Create New Quiz" button
  And I wait for 1 sec
  And I click on the field
  And I click outside the title field
  And error message "This field is required" should be displayed
  And I wait for 1 sec

    @quizTitle3
    Scenario: Min 1 character in title field
      When I click "Create New Quiz" button
      And I wait for 1 sec
      And I type "Q" as quiz title
      And quiz title "Q" should be displayed at the top
      And no error message should be displayed
      And I wait for 1 sec

      @quizTitle4
      Scenario: Max characters +1 in title field
        When I click "Create New Quiz" button
        And I wait for 1 sec
        And I type "1001" symbols as quiz title
        And error message "1000 characters is maximum" should be displayed
        And I wait for 2 sec
         #Known issue Jira ticket OKT-588

    @quizTitle5
    Scenario: Max 1000 characters in title field
      When I click "Create New Quiz" button
      And I wait for 1 sec
      And I type "1000" symbols as quiz title
      And quiz title should be displayed
      And I wait for 2 sec

        @quizTitle6
        Scenario: Leading and trailing space characters to be eliminate when Quiz is saved in the List of Quizzes
          When I click "Create New Quiz" button
          And I wait for 1 sec
          And I type " Quiz " as quiz title
          And quiz title " Quiz " should be displayed at the top
          And error message "No leading or trailing space characters" should be displayed
          And I wait for 1 sec
          #Known issue Jira ticket OCT-590, OCT-591

