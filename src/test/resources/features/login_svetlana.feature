@login
  Feature: Login Scenarios

@login1
  Scenario: Login with valid credentials as a teacher
    Given I navigate to "login" page SM
    When I type "shamdag@24hinbox.com" into email field
    And I type "qazwsxedc" into password field
    When I click button "Sign In" SM
    And I wait for 1 sec
    Then "home" page should be displayed
    And I verify user role is "TEACHER"
    And I wait for 2 sec
@login2
   Scenario: Login with invalid credentials as a teacher
     Given I navigate to "login" page SM
     When I type "sdfsdf2321@kfdg.com" into email field
     And I type "1111wwwweee" into password field
     When I click button "Sign In" SM
     And I wait for 1 sec
     Then "Authentication failed" error message should be displayed
     And I wait for 2 sec

@login3
    Scenario: Login with invalid password and valid email as a teacher
      Given I navigate to "login" page SM
      When I type "shamdag@24hinbox.com" into email field
      And I type "qqqqqqqqq1111111" into password field
      When I click button "Sign In" SM
      And I wait for 1 sec
      Then "Authentication failed" error message should be displayed
      And I wait for 2 sec
@login4
    Scenario: Login with invalid email and valid password as a teacher
       Given I navigate to "login" page SM
       When I type "rewrwerewr@retertert.com" into email field
       And I type "qazwsxedc" into password field
       When I click button "Sign In" SM
       And I wait for 1 sec
       Then "Authentication failed" error message should be displayed
       And I wait for 2 sec

@login5
    Scenario: Login with empty password field and valid email as a teacher
       Given I navigate to "login" page SM
       When I type "shamdag@24hinbox.com" into email field
       When I click button "Sign In" SM
       And I wait for 1 sec
       Then password error message "This field is required" is displayed
       And I wait for 2 sec
@login6
    Scenario: Login with empty email and valid password as a teacher
        Given I navigate to "login" page SM
        When I type "qazwsxedc" into password field
        When I click button "Sign In" SM
        And I wait for 1 sec
        Then email error message "This field is required" is displayed
        And I wait for 2 sec
@login7
     Scenario: Login with empty email and password fields
        Given I navigate to "login" page SM
        When I click button "Sign In" SM
        And I wait for 1 sec
        Then email error message "This field is required" is displayed
        Then password error message "This field is required" is displayed
        And I wait for 2 sec
@login8
     Scenario: Login with valid credentials as a student
       Given I navigate to "login" page SM
       When I type "joeqblow@mailcuk.com" into email field
       And I type "qazwsxedc" into password field
       When I click button "Sign In" SM
       And I wait for 1 sec
       Then "home" page should be displayed
       And I verify user role is "student"
       And I wait for 2 sec
@login9
     Scenario: Login with invalid credentials as a student
        Given I navigate to "login" page SM
        When I type "joeqblow@m213123ailcuk.com" into email field
        And I type "asdasqwewqe21" into password field
        When I click button "Sign In" SM
        And I wait for 1 sec
        Then "Authentication failed" error message should be displayed
        And I wait for 2 sec
@login10
     Scenario: Password field is masked
       Given I navigate to "login" page SM
       When I type "111somedefault@email.com" into email field
       And I type "asdarwefsdf324" into password field
       Then I verify that password field is masked
       And I wait for 2 sec
@login11
    Scenario: Leading spaces for email field are not allowed
       Given I navigate to "login" page SM
       When I type " some-email@aol.com" into email field
       And I click into password field
       And I wait for 1 sec
       Then email error message "Should be a valid email address" is displayed
       And I wait for 2 sec

@login12
    Scenario: Trailing spaces for email field are not allowed
       Given I navigate to "login" page SM
       When I type "someeamail@ajol.com " into email field
       And I click into password field
       And I wait for 1 sec
       Then email error message "Should be a valid email address" is displayed
       And I wait for 2 sec

@login13
   Scenario: Leading spaces for password field are not allowed
     Given I navigate to "login" page SM
     When I type " defaultpassword" into password field
     And I click into email field
     And I wait for 1 sec
     Then password error message "Whitespaces are not allowed" is displayed
     And I wait for 2 sec
@login14
   Scenario: Trailing spaces for password field are not allowed
      Given I navigate to "login" page SM
      When I type "sadsadsadasd " into password field
      And I click into email field
      And I wait for 1 sec
      Then password error message "Whitespaces are not allowed" is displayed
      And I wait for 2 sec

@login15
   Scenario: Login with uppercase email and valid password as a teacher
      Given I navigate to "login" page SM
      When I type "SHAMDAG@24HINBOX.COM" into email field
      And I type "qazwsxedc" into password field
      When I click button "Sign In" SM
      And I wait for 1 sec
      Then "home" page should be displayed
      And I verify user role is "teacher"
      And I wait for 2 sec
@login16
   Scenario: Login with uppercase password and valid email as a teacher
     Given I navigate to "login" page SM
     When I type "shamdag@24hinbox.com" into email field
     And I type "QAZWSXEDC" into password field
     When I click button "Sign In" SM
     And I wait for 1 sec
     Then "Authentication failed" error message should be displayed
     And I wait for 1 sec
@login17
   Scenario: Password field type verification ( "cut" and "copy" should be disabled)
     Given I navigate to "login" page SM
     When I type "shamdag@24hinbox.com" into email field
     And I type "qazwsxedc" into password field
     Then I verify that password field has attribute type=password
     And I wait for 2 sec