@quiz_title
  Feature: Quiz title scenarios

    Background:
    Given I navigate to "Login" page
    When I type "qa@ask.com" into email field
    When I type "12345" into password-field
    Then I push "Sign In" button
    Then I wait for 2 sec
    Then I click on "quizzes" on the side menu
    Then I wait for 2 sec
    Then I push "Create New Quiz" button
    Then I wait for 2 sec



#    Title of Quiz
#
#    The field is required
#    Min 1 Characters
#    Max 1000 characters
#    Leading and trailing space characters to be eliminate when Quiz is saved in the List of Quizzes
#
    @quiz_title1
    Scenario Outline: Alphanumeric & Sp. characters are allowed
      When I type "quiz name" into quizname field
      Then I click add question button
      Then  element with xpath "//input[contains(@class,'mat-input')]/../../..//mat-error[@role='alert'])" should not be displayed

      Examples:
        | quiz name |
        | GoVeg.com |
#        | 123455787 |
#        | rgruiikQp |
#        | !@#%^^&***(()_+  |
#        |JohnO'Grady|


