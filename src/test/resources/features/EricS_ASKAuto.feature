@option
  Feature: Automate test set - Textual Question - Text
    Background:
      Given I open "login" page
      When I type "iceworm@gungratemail.com" for teacher user
      And I type "QA12345!!" as password
      When I click "Sign In" button
      And I wait for 1 sec
      Then "home" page will be displayed
      When I click on "Quizzes" menu item
      And I wait for 1 sec
      
      @option1
      Scenario: Testing the first scenario
        When I click "Create New Quiz" button
        And I wait for 2 sec
        When I type "Demo Quiz Textual Question" as quiz title
        And I add a question
        When I select "Textual" question
        When I type "haffvbnamgftsgh5698@@@@!!!%" into "1"
        And I add a question
        Then I click on element with xpath "//mat-panel-title[contains(text(),'Q1')]"
        And I wait for 3 sec
        Then element with xpath "//textarea[@placeholder='Question *'][@id='mat-input-3']" should be present
        Then element with xpath "//mat-panel-title[@class='mat-expansion-panel-header-title']" should have text as "Q1: haffvbnamgftsgh5698@@@@!!!%"
        And I wait for 2 sec

    @option2
    Scenario: Verify that Question field is required and marked with asterisks
      When I click "Create New Quiz" button
      And I wait for 1 sec
      When I type "Demo Quiz Textual Question" as quiz title
      And I add a question
      When I select "Textual" question
      And I add a question
      Then I click on element with xpath "//mat-panel-title[contains(text(),'Q1')]"
      And I wait for 1 sec
      Then element with xpath "//mat-error[@id='mat-error-3'][contains(text(),'This field is required')]" should be present

    @option3
    Scenario: Testing the first scenario
      When I click "Create New Quiz" button
      And I wait for 2 sec
      When I type "Demo Quiz Textual Question" as quiz title
      And I add a question
      When I select "Textual" question
      When I type "h" into "1"
      And I add a question
      Then I click on element with xpath "//mat-panel-title[contains(text(),'Q1')]"
      And I wait for 2 sec
      Then element with xpath "//textarea[@placeholder='Question *'][@id='mat-input-3']" should be present
      Then element with xpath "//mat-panel-title[@class='mat-expansion-panel-header-title']" should have text as "h"
      And I wait for 2 sec

          
