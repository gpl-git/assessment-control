@LogIn
Feature: LogIn Scenarios

@LogIn1
Scenario: User can log in with valid credentials entered in the all required fields
Given I navigate to "login" page
When I enter "lmislinski@nbobd.com" into email field
And I type password "123456"
When I hit button "Sign In"
#And I wait for 4 seconds
#When I click "Quizzes" menu item
And I wait for 2 sec
Then I click "Log Out" menu item
And I wait for 2 sec
And I click confirm "Log Out"

@LogIn2
Scenario: User can NOT log in if password is NOT entered
Given I navigate to "login" page
And I wait for 4 seconds
When I enter "lmislinski@nbobd.com" into email field
And I hit button "Sign In"
Then message "This field is required" is displayed in password field

@LogIn3
Scenario: User can NOT log in if email address is NOT entered
Given I navigate to "login" page
And I wait for 4 seconds
When I type password "123456"
And I hit button "Sign In"
Then message "This field is required" is displayed in email field

@LogIn4
Scenario: User can NOT log in if invalid email address is entered
Given I navigate to "login" page
And I wait for 4 seconds
When I type "invalid" email into email field
And I type password "123456"
And I hit button "Sign In"
Then message "Should be a valid email address" is displayed
And I clear email field
Then message "This field is required" is displayed
When I type "lmislinski@nbobd.com" email into email field
When I hit button "Sign In"
And I wait for 4 seconds
When I click "Quizzes" menu item
And I wait for 2 sec
Then I click "Log Out"
And confirmation window should appear


@LogIn5
Scenario: Invalid password no login
Given I navigate to "login" page
And I wait for 4 seconds
When I enter "lmislinski@nbobd.com" into email field
And I type password "12345"
And I hit button "Sign In"
Then pop up window with error message text should show up

@LogIn6
Scenario: Verification if masked password
Given I navigate to "login" page
And I wait for 4 seconds
When I enter "lmislinski@nbobd.com" into email field
And I type password "123456"
Then password should be masked

@LogIn7
Scenario: Verify cut menu is disable
Given I navigate to "login" page
And I wait for 4 seconds
When I enter "lmislinski@nbobd.com" into email field
And I type password "123456"
Then I do right click on password field to see a menu where cut is disable

@LogIn8
Scenario: Email is case sensitive
Given I navigate to "login" page
When I enter "LMISLINSKI@NBOBD.COM" into email field
And I type password "123456"
When I hit button "Sign In"
And I wait for 4 seconds
When I click "Log Out"
Then confirmation window should appear
And I click "Log Out" button
Then return to "login"page

@LogIn9
Scenario: Verify that Password field is Case insensitive
Given I navigate to "login" page
When I enter "milla.nyaga@gmail.com" into email field
And I type "MILLA12345" into password field
When I hit button "Sign In"
Then pop up window with error message text should show up

@LogIn10
Scenario: Trailing spaces are not allowed
Given I navigate to "login" page
And I wait for 4 seconds
When I enter "lmislinski@nbobd.com" into email field
And type enter
Then email field should contain error message

@LogIn11
Scenario: Leading space are NOT allowed in the "Email" field
Given I navigate to "login" page
And I wait for 4 seconds
When I type enter into email field
And I enter "lmislinski@nbobd.com" into email field
Then email field should contain error message

@LogIn12
Scenario: Copy menu item on "Password" field is disabled
Given I navigate to "login" page
And I wait for 4 seconds
When I enter "lmislinski@nbobd.com" into email field
And I type password "123456"
Then I do right click on password field to see a menu where copy is disable





























