@logIn
  Feature: LogIn

    @logIn1
    Scenario: LogIn as Student
      Given I open "login" page VT
      When I type "jon.sql@gameofthrones.com" into email text field VT
      And I type "GameOfThrones" into password text field VT
      And I click "Sign In" button VT
      And I wait for 2 sec VT
      Then Menu with items is displayed VT
      And I logout VT
      And I wait for 2 sec

    @login2
    Scenario: Entering password instead of email and email instead of password
      Given I open "login" page VT
      When I type "GameOfThrones" into email text field VT
      And I type "jon.sql@gameofthrones.com" into password text field VT
      And I click "Sign In" button VT
      Then email error message "Should be a valid email address" is displayed VT
      And I wait for 2 sec

    @login3
    Scenario: Verying behavior of email and password fields when entering white spaces
      Given I open "login" page VT
      When I type email with a whitespace in from of it " jon.sql@gameofthrones.com" into email text field VT
      And I click "Sign In" button VT
#      Probably email error-messsage that whitespaces are not allowed should be displayed instead of actual one.
      Then email error message "Should be a valid email address" is displayed VT
      When I type password with a whitespace in front of it " 12345" into password text field VT
      And I click "Sign In" button VT
      Then password error message "Whitespaces are not allowed" should be displayed VT

    @login4
    Scenario: Verifying that Email field is case insensitive
      Given I open "login" page VT
      When I type "JON.SQL@GAMEOFTHRONES.COM" into email text field VT
      And I type "GameOfThrones" into password text field VT
      And I click "Sign In" button VT
      Then Menu with items is displayed VT
      And I wait for 2 sec

    @login5
    Scenario: Verify that Password field is case sensitive
      Given I open "login" page VT
      When I type "jon.sql@gameofthrones.com" into email text field VT
      And I type "GAMEOFTHRONES" into password text field VT
      And I click "Sign In" button VT
      And I wait for 2 sec
      Then password Authentication error message should be displayed VT
#      Wasn't sure how to check Authentication error message properly
