@forgotpasswd

  Feature: Forgot Password Scenarios

@forgotpassword1
    Scenario: Forgot password - valid data
      Given I go the webpage "ask"
      When I click on "I forgot my password"
      And I enter a valid email
      And click on the button "Request Password Reset"
      And I wait for 3 sec

@forgotpassword2
    Scenario: Forgot password - invalid data.
      Given I go the webpage "ask"
      When I click on "I forgot my password"
      And I enter an invalid email
      And click on the button "Request Password Reset"
      And I wait for 2 sec
      Then the error message "Authentication failed. User not found or password does not match" is displayed.
      And I wait for 2 sec


@forgotpassword3
    Scenario: Forgot Password - Empty email field
       Given I go the webpage "ask"
       When I click on "I forgot my password"
       And I leave the email field empty
       And click on the button "Request Password Reset"
       And I wait for 2 sec
       Then I verify the error message "This field is required" will be displayed
       And I wait for 2 sec

@forgotpassword4
     Scenario:Forgot Password - Accepts old password
     Given I go to url "reset password" page
     Then "Reset Password" window is displayed
     And I  enter old password  in  New Password field
     And I enter same old password in Confirm New Password
     And I press "reset" button
     And I wait for 2 sec
     Then Your Password was Changed message is displayed

@forgotpassword5
     Scenario: Forgot Password: Password and Confirm Password do not match
     Given I go to url "reset password" page
     Then "Reset Password" window is displayed
     And I type "12345" in the New Password field
     And I type "56789" in the Confirm New Password field
     And I wait for 3 sec
     And I press "reset" button
     Then error message "Entered passwords should match" is displayed
