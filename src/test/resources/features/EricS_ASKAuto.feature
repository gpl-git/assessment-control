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
        When I wait for 4 sec