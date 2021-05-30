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
      And I click on "reset" button

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
    Scenario: Forgot password and give invalid email
      And I click on element forgot password
      When I type invalid "email" in the element "field"
      And I click request password reset
      And I wait for 2 sec
      Then pop-up message should be displayed "Authentication failed. User not found or password does not match"
