
Feature: Password/Confirm Password Scenarios


Background:
Given Navigate to "registration" page h

@registrationPasswordAndConfirmPassword1
Scenario: Password/Confirm password match
When I click on FirstName field and type "QA" h
And I click on LastName field and type "test" h
And I click on email field and type "aalib@emvil.com" h
Then I click on Group Code field and type "1" h
And I click on password field and type "12345" h
When I type on Confirm Password field "12345" h
Then click on button 'Register Me' h
And I wait for 3 sec
Then confirmation message should be displayed and contains text "You have been Registered." h

@registrationPasswordAndConfirmPassword2
Scenario: Password/Confirm password cannot be submit if not match
When I click on FirstName field and type "qwer" h
And I click on LastName field and type "rewq" h
And I click on email field and type "aalibekov@emvil.com" h
Then I click on Group Code field and type "1" h
And I click on password field and type "12345" h
When I type on Confirm Password field "54321" h
Then click on button 'Register Me' h
And error message should be displayed and contain text "Entered passwords should match" h

@registrationPasswordAndConfirmPassword3
Scenario: Verify if Password/ Confirm field can't be empty
When I click on FirstName field and type "*test" h
And I click on LastName field and type "*test" h
And I click on email field and type "*student1@gmail.com" h
Then I click on Group Code field and type "*123" h
And I click on password field and type "" h
When I type on Confirm Password field "" h
Then click on button 'Register Me' h
And errors messages should be displayed and contain text "This field is required" h

@registrationPasswordAndConfirmPassword4
Scenario:  Password / Confirm Password field minimum (5) characters
When I click on FirstName field and type "*test" h
And I click on LastName field and type "*test" h
And I click on email field and type "*student1@gmail.com" h
Then I click on Group Code field and type "*123" h
And I click on password field and type "123" h
When I type on Confirm Password field "123" h
And click on button 'Register Me' h
And I wait for 1 sec
Then errors messages should be displayed and contain text "Should be at least 5 characters" h

@registrationPasswordAndConfirmPassword5
Scenario: Password / Confirm Password maximum (32) characters
When I click on FirstName field and type "*test" h
And I click on LastName field and type "*test" h
And I click on email field and type "*student1@gmail.com" h
Then I click on Group Code field and type "*123" h
And I click on password field and type "vewvfwefwefefefefefef67uyhg4565t" h
When I type on Confirm Password field "vewvfwefwefefefefefef67uyhg4565t" h
And click on button 'Register Me' h
And I wait for 2 sec
Then confirmation message should be displayed and contains text "You have been Registered." h

@registrationPasswordAndConfirmPassword6
Scenario: Password/ Confirm Password - White spaces are not allowed
When I click on FirstName field and type "*test" h
And I click on LastName field and type "*test" h
And I click on email field and type "*student1@gmail.com" h
Then I click on Group Code field and type "*123" h
And I click on password field and type " " h
When I type on Confirm Password field " " h
And click on button 'Register Me' h
Then errors messages should be displayed and contain text "Whitespaces are not allowed" h

@registrationPasswordAndConfirmPassword7
Scenario: Password/ Confirm Password CAN'T be submitted with more than 32 characters
When I click on FirstName field and type "*test" h
And I click on LastName field and type "*test" h
And I click on email field and type "*student1@gmail.com" h
Then I click on Group Code field and type "*123" h
And I click on password field and type "vewvfwefwefefefefefef67uyhg4565t11" h
When I type on Confirm Password field "vewvfwefwefefefefefef67uyhg4565t11" h
And click on button 'Register Me' h
      #Then errors messages should be displayed and contain text "Must be maximum 32 characters" h //bug found

@registrationPasswordAndConfirmPassword8
Scenario Outline: Password/Confirm Password -Error messages - outline
When I click on FirstName field and type "*test" h
And I click on LastName field and type "*test" h
And I click on email field and type "*student1@gmail.com" h
Then I click on Group Code field and type "*123" h
And I click on password field and type <password> h
When I type on Confirm Password field <confPassword> h
And click on button 'Register Me' h
Then errors messages should be displayed and contain text <message> h
Examples:
|password  | confPassword | message                          |
| " "      | " "          |"Whitespaces are not allowed"     |
|"123"     | "123"        | "Should be at least 5 characters"|
|""        | ""           | "This field is required"         |
|"12345"   | "54321"      | "Entered passwords should match" |




