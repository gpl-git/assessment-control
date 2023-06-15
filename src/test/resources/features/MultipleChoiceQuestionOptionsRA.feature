#@Test
#  Feature: Multiple Choice Question - Options
#    Background:
#      Given I go to "login" page
#      When I type "fatehpurkumar@24hinbox.com" into email field
#      And I type "kyleortegaday1" into password field
#      When I click "Sign In" button
#      And I wait for 1 sec
#      And I click "Quizzes" menu item
#      And I wait for 1 sec
#      When I click "Create New Quiz" button
#      And I wait for 2 sec
#
#    @Test1
#    Scenario: Multiple Choice Question - Add Option
#      When I type "Quiz Sample" as quiz title
#      And I add a question
#      And I select "Multiple" question type
##
#
#    @quiz_sample1
#    Scenario: Create a quiz
#      When I type "Quiz Sample" as quiz title
#      And I add a question
#      When I select "Single" question type
#      And I type "Question 1" into question field of "Q1"
#      When I type "Option 1" into "Option 1" option field of "Q1"
#      And I type "Option 2" into "Option 2" option field of "Q1"
#      When I select "Option 1" as a correct option in "Q1"
#      And I click "Save" button
#      And I wait for 1 sec
#      Then "Quiz Sample" is displayed on the list of quizzes
#      And I delete "Quiz Sample" from the list of quizzes


@Test
  Feature: Multiple Choice Question - Options
    Background:
      Given I go to "login" page!
      When I type "qa1@test.com" into element with xpath "//input[@formcontrolname='email']"!
      And I type "12345" into element with xpath "//input[@formcontrolname='password']"!
      And I click on element with xpath "//span[contains(text(),'Sign In')]"!
      And I wait for 5 sec!

  @Test1
  Scenario: I login to the page
    When I navigate to "http://ask-qa.portnov.com/#/quizzes"!
    And I wait for 2 sec!
    And I click on element with xpath "//button/span[text()='Create New Quiz']"!
    And I wait for 2 sec!
    And I type "Multiple Choice - Options" into element with xpath "//input[@placeholder='Title Of The Quiz *']"!
    And I click on element with xpath "//button/span/mat-icon"!
    And I click on element with xpath "//div[contains(text(),'Multiple')]"!
    And I click on element with xpath "//span[contains(text(),'Add Option')]"!
    Then element with xpath "//div[contains(text(),'Points per question *')]" should be displayed!
    