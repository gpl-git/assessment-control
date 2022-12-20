@logIn
  Feature: LogIn
    Background: 
      Given I open "login" page VT

    @logIn1
    Scenario: LogIn as Student
      When I type "jon.sql@gameofthrones.com" into email text field VT
      And I type "GameOfThrones" into password text field VT
      And I click "Sign In" button VT
      And I wait for 2 sec VT
      Then user role "STUDENT" is displayed VT
    @login2
      Scenario: LogIn as Teacher
      When I type "mcbuff@hotmail.red" into email text field VT
      And I type "12345" into password text field VT
      And I click "Sign In" button VT
      And I wait for 2 sec VT
      Then user role "TEACHER" is displayed VT

    @login3
    Scenario: Entering password instead of email and email instead of password
      When I type "GameOfThrones" into email text field VT
      And I type "jon.sql@gameofthrones.com" into password text field VT
      And I click "Sign In" button VT
      Then email error message "Should be a valid email address" is displayed VT
      And I wait for 2 sec VT

    @login4
    Scenario: Verying behavior of email and password fields when entering white spaces
      When I type email with a whitespace in from of it " jon.sql@gameofthrones.com" into email text field VT
      And I click "Sign In" button VT
#      Probably email error-messsage that whitespaces are not allowed should be displayed instead of actual one.
      Then email error message "Should be a valid email address" is displayed VT
      When I type password with a whitespace in front of it " 12345" into password text field VT
      And I click "Sign In" button VT
      Then password error message "Whitespaces are not allowed" should be displayed VT

    @login5
    Scenario: Verifying that Email field is case insensitive
      When I type "JON.SQL@GAMEOFTHRONES.COM" into email text field VT
      And I type "GameOfThrones" into password text field VT
      And I click "Sign In" button VT
      Then Menu with items is displayed VT
      And I wait for 2 sec

    @login6
    Scenario: Verifying that Password field is case sensitive
      When I type "jon.sql@gameofthrones.com" into email text field VT
      And I type "GAMEOFTHRONES" into password text field VT
      And I click "Sign In" button VT
      And I wait for 2 sec
      Then password Authentication error message should be displayed VT

    @login7
    Scenario: Verifying that password is masked
      When I type "jon.sql@gameofthrones.com" into email text field VT
      Then I verify that password field has type "password" VT