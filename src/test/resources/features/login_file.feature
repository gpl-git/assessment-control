  @login1
  Feature: Login Scenarios

    Scenario: Valid email and valid password
      Given I go to "login" page
      When I type "romanovamasa@neaeo.com" into email field
      And I type "Ucheba22" into password field
      And I click button "Sign In"
      Then personal page should be displayed


  @login2
    Scenario: Valid email and invalid password
      Given I go to "login" page
      When I type "romanowamasa@neaeo.com" into email field
      And I type "Ucheba22" into password field
      When I click button "Sign In"
      Then error message "Authentication failed. User not found or password does not match" should be displayed
      And I wait for 2 sec


  @login3
    Scenario: Valid email and invalid password
      Given I go to "login" page
      When I type "romanovamasa@neaeo.com" into email field
      And I type "Ucheva22" into password field
      When I click button "Sign In"
      Then error message "Authentication failed. User not found or password does not match" should be displayed
      And I wait for 2 sec

  @login4
    Scenario: Password displays input in bullets
      Given I go to "login" page
      When I type "romanovamasa@neaeo.com" into email field
      And I type "Ucheba22" into password field
      Then password field should contain text "********"
      And I wait for 2 sec

  @login5
    Scenario: "Cut" menu item on password field is disable
      Given I go to "login" page
      When I type "romanovamasa@neaeo.com" into email field
      And I type "Ucheba22" into password field
      Then I verify that password field is masked

  @login6
    Scenario: "Copy" menu item on password field is disable
      Given I go to "login" page
      When I type "romanovamasa@neaeo.com" into email field
      And I type "Ucheba22" into password field
     Then I verify that password field is masked

  @login7
    Scenario: Leading characters in the field login is not allowed
      Given I go to "login" page
      When I type " romanovamasa@neaeo.com" into email field
      And I type "Ucheba22" into password field
      And email error message "Should be a valid email address" should be displayed
      And I wait for 2 sec

  @login8
    Scenario: Email field case insensetive
      Given I go to "login" page
      When I type "Romanovamasa@neaeo.com" into email field
      And I type "Ucheba22" into password field
      And I click button "Sign In"
      And I wait for 2 sec
      Then personal page should be displayed

    @login9
    Scenario: Password field case sensetive
      Given I go to "login" page
      When I type "romanovamasa@neaeo.com" into email field
      And I type "ucheba22" into password field
      When I click button "Sign In"
      Then error message "Authentication failed. User not found or password does not match" should be displayed
      And I wait for 2 sec