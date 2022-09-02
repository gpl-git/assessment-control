@login
  Feature: login page

    Scenario: Log In with valid email and valid password combination
      Given I go to "login" page
      Then I type "send@gmailni.com" into email field
      Then I type "ilove2QA" into password field
      And I click "Sign In" button
      And I wait for 2 sec
      Then I verify that homepage is opened

