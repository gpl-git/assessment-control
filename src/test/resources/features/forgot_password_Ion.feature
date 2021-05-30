@forgotpassword
Feature: Testing Forgot Password page

  Background:
    Given I open page "login"

  @forgotpassword1
  Scenario: Click forgot password button
    And I click on element forgot password
    When I type valid "email" in the element "field"
    And I click request password reset
    And I wait for 2 sec
    Then message should be displayed "Your request is confirmed"
    And I wait for 2 sec
    Then I navigate to my email
    Then I type my "test123456789123456712@gmail.com" to sign in page
    And I click on first next button
    And I wait for 3 sec
    Then I type "Ab123456789!@Cd" into password field on sign in page
    And  I click on second next button
    And I wait for 3 sec
    And I click on new email in inbox field
    And I wait for 2 sec
    Then I click on last email message from "assessment.portnov@gmail.com"
    And I click the "reset" button
    And I wait for 3 sec
    And I type "12345" into New Password field
    And I wait for 3 sec
    And I type "12345" into Confirm New Password field
    And I click reset button on page reset password
    And I wait for 2 sec
    Then message is displayed "Your Password was Changed"
    And I click Back To Login Page button
    And I wait for 2 sec
    Then I type "test123456789123456712@gmail.com" into email field on page login
    Then I type "12345" into password field on page login
    Then I click Sign In button on login page
    Then I should see page title as "Assessment Control @ Portnov"

  @forgotpassword2
  Scenario: Forgot password and invalid email
    And I click on element forgot password
    When I type invalid "email" in the element "field"
    And I click request password reset
    And I wait for 1 sec
    Then pop-up message should display Authentication failed.

  @forgotpassword3
  Scenario: Forgot password text message
    And I click on element forgot password
    Then I see message "Warning!"
    And I wait for 5 sec

  @forgotpassword4
  Scenario: Verify if the link to change the password is sent to the user’s email
    And I click on element forgot password
    When I type valid "email" in the element "field"
    And I click request password reset
    And I wait for 2 sec
    Then message should be displayed "Your request is confirmed"
    And I wait for 2 sec
    Then I navigate to my email
    Then I type my "test123456789123456712@gmail.com" to sign in page
    And I click on first next button
    And I wait for 3 sec
    Then I type "Ab123456789!@Cd" into password field on sign in page
    And  I click on second next button
    And I wait for 3 sec
    And I click on new email in inbox field
    And I wait for 2 sec
    Then I click on last email message from "assessment.portnov@gmail.com"
    And I click the "reset" button
    And I wait for 3 sec

  @forgotpassword5
  Scenario: Verify if the new password field can be empty
    And I click on element forgot password
    When I type valid "email" in the element "field"
    And I click request password reset
    And I wait for 2 sec
    Then message should be displayed "Your request is confirmed"
    And I wait for 2 sec
    Then I navigate to my email
    Then I type my "test123456789123456712@gmail.com" to sign in page
    And I click on first next button
    And I wait for 3 sec
    Then I type "Ab123456789!@Cd" into password field on sign in page
    And  I click on second next button
    And I wait for 3 sec
    And I click on new email in inbox field
    And I wait for 2 sec
    Then I click on last email message from "assessment.portnov@gmail.com"
    And I click the "reset" button
    And I wait for 3 sec
    And I click reset button on page reset password
    Then error message is displayed "This field is required" under new password field
    Then error message is displayed "This field is required" under confirm new password field

  @forgotpassword6
  Scenario: less than 5 characters
    And I click on element forgot password
    When I type valid "email" in the element "field"
    And I click request password reset
    And I wait for 2 sec
    Then message should be displayed "Your request is confirmed"
    And I wait for 2 sec
    Then I navigate to my email
    Then I type my "test123456789123456712@gmail.com" to sign in page
    And I click on first next button
    And I wait for 3 sec
    Then I type "Ab123456789!@Cd" into password field on sign in page
    And  I click on second next button
    And I wait for 3 sec
    And I click on new email in inbox field
    And I wait for 2 sec
    Then I click on last email message from "assessment.portnov@gmail.com"
    And I click the "reset" button
    And I wait for 3 sec
    And I type "12" into New Password field
    And I wait for 3 sec
    And I type "12" into Confirm New Password field
    And I click reset button on page reset password
    Then error message is displayed "Too short. Should be at least 5 characters" under new password field
    Then error message is displayed "Too short. Should be at least 5 characters" under confirm new password field
    And I wait for 2 sec

  @forgotpassword7
  Scenario: Whitespaces character
    And I click on element forgot password
    When I type valid "email" in the element "field"
    And I click request password reset
    And I wait for 2 sec
    Then message should be displayed "Your request is confirmed"
    And I wait for 2 sec
    Then I navigate to my email
    Then I type my "test123456789123456712@gmail.com" to sign in page
    And I click on first next button
    And I wait for 3 sec
    Then I type "Ab123456789!@Cd" into password field on sign in page
    And  I click on second next button
    And I wait for 3 sec
    And I click on new email in inbox field
    And I wait for 2 sec
    Then I click on last email message from "assessment.portnov@gmail.com"
    And I click the "reset" button
    And I wait for 3 sec
    And I type "1234 5" into New Password field
    And I wait for 3 sec
    And I type "1234 5" into Confirm New Password field
    And I click reset button on page reset password
    Then error message is displayed "Whitespaces are not allowed" under new password field
    Then error message is displayed "Whitespaces are not allowed" under confirm new password field
    And I wait for 2 sec

  @forgotpassword8
  Scenario: Provide wrong password in confirm new password field
    And I click on element forgot password
    When I type valid "email" in the element "field"
    And I click request password reset
    And I wait for 2 sec
    Then message should be displayed "Your request is confirmed"
    And I wait for 2 sec
    Then I navigate to my email
    Then I type my "test123456789123456712@gmail.com" to sign in page
    And I click on first next button
    And I wait for 3 sec
    Then I type "Ab123456789!@Cd" into password field on sign in page
    And  I click on second next button
    And I wait for 3 sec
    And I click on new email in inbox field
    And I wait for 2 sec
    Then I click on last email message from "assessment.portnov@gmail.com"
    And I click the "reset" button
    And I wait for 3 sec
    And I type "12345" into New Password field
    And I wait for 3 sec
    And I type "54321" into Confirm New Password field
    And I click reset button on page reset password
    Then error message is displayed "Entered passwords should match" under confirm new password field
    And I wait for 2 sec

  @forgotpassword9
  Scenario: Double activated reset forgot password
    And I click on element forgot password
    When I type valid "email" in the element "field"
    And I click request password reset
    And I wait for 2 sec
    Then message should be displayed "Your request is confirmed"
    And I wait for 2 sec
    Then I navigate to my email
    Then I type my "test123456789123456712@gmail.com" to sign in page
    And I click on first next button
    And I wait for 3 sec
    Then I type "Ab123456789!@Cd" into password field on sign in page
    And  I click on second next button
    And I wait for 3 sec
    And I click on new email in inbox field
    And I wait for 2 sec
    Then I click on last email message from "assessment.portnov@gmail.com"
    And I click the "reset" button
    And I wait for 3 sec
    And I type "12345" into New Password field
    And I wait for 3 sec
    And I type "12345" into Confirm New Password field
    And I click reset button on page reset password
    And I wait for 2 sec
    Then message is displayed "Your Password was Changed"
    Then I navigate to my email
    And I wait for 1 sec
    And I click on new email in inbox field
    And I wait for 2 sec
    Then I click on last email message from "assessment.portnov@gmail.com"
    And I click the "reset" button second time
    And I wait for 2 sec
    And I type "12345" into New Password field
    And I wait for 1 sec
    And I type "12345" into Confirm New Password field
    And I click reset button on page reset password
    And I wait for 2 sec
    Then pop-up message should be displayed "Error. Reset was not requested"