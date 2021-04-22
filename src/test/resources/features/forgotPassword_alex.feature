@forgotPassword
Feature: Forgot Password Scenarios

  Scenario: Valid email / ACT-314
            Preconditions: account a.kaladzinski@aol.com / TestPSW_123 exists
    When I navigate to "http://ask-qa.portnov.com/#/login" page
    And I wait for 1 seconds
    And I click "I forgot my password" link
    And I enter "a.kaladzinski@aol.com" into the Email field
    And I click button with text "Request Password Reset"
    And I navigate to "https://mail.aol.com/" page
    And I enter "a.kaladzinski@aol.com" into the Usermane field
    And I click Next button
    And I wait for 1 seconds
    And I enter "TestPSW_123" into Password Field
    And I wait for 1 seconds
    And I click Next button
    And I wait for 3 seconds
    And I click Inbox link
    And I wait for 2 seconds
    And I click to open Reset your password email
    And I wait for 2 seconds
    And I click "Reset Password" link
    And I switch to new opened window
    And I enter "123456" into New password field
    And I enter "123456" into Confirm New Password field
    And I click button with text "Reset"
    And I wait for 1 seconds
    Then element with text "Your Password was Changed" is present
    And I navigate to "http://ask-qa.portnov.com/#/login" page
    And I enter "a.kaladzinski@aol.com" into Email field at ask page
    And I enter "123456" into Password field at ask page
    And I click button with text "Sign In"
    And I wait for 2 seconds
    Then user's credentials "TestFirstName TestLastName" are present at the top left corner of the page

  Scenario: Non registered email / ACT-329
            Preconditions: account a.kaladzinski123@aol.com / TestPSW_123 exists
    When I navigate to "http://ask-qa.portnov.com/#/login" page
    And I wait for 1 seconds
    And I click "I forgot my password" link
    And I enter "a.kaladzinski123@aol.com" into the Email field
    And I click button with text "Request Password Reset"
    And I wait for 2 seconds
    Then snack-bar with text "Authentication failed. User not found or password does not match" is present

  Scenario:  empty field / ACT-334
    When I navigate to "http://ask-qa.portnov.com/#/login" page
    And I wait for 1 seconds
    And I click "I forgot my password" link
    And I click button with text "Request Password Reset"
    And I wait for 1 seconds
    Then warning message with text "This field is required" is present

  Scenario:  not correct format of email / ACT-336
    This scenario fails as a proper message is not implemented
    When I navigate to "http://ask-qa.portnov.com/#/login" page
    And I wait for 1 seconds
    And I click "I forgot my password" link
    And I enter "@@@@.com" into the Email field
    And I click button with text "Request Password Reset"
    And I wait for 1 seconds
    Then warning message with text "Invalid email format" is present

  Scenario: Valid email - password not matching in password request form / ACT-469
  Preconditions: account a.kaladzinski@aol.com / TestPSW_123 exists
    When I navigate to "http://ask-qa.portnov.com/#/login" page
    And I wait for 1 seconds
    And I click "I forgot my password" link
    And I enter "a.kaladzinski@aol.com" into the Email field
    And I click button with text "Request Password Reset"
    And I navigate to "https://mail.aol.com/" page
    And I enter "a.kaladzinski@aol.com" into the Usermane field
    And I click Next button
    And I wait for 1 seconds
    And I enter "TestPSW_123" into Password Field
    And I wait for 1 seconds
    And I click Next button
    And I wait for 3 seconds
    And I click Inbox link
    And I wait for 2 seconds
    And I click to open Reset your password email
    And I wait for 2 seconds
    And I click "Reset Password" link
    And I switch to new opened window
    And I enter "123456A" into New password field
    And I enter "123456" into Confirm New Password field
    And I click button with text "Reset"
    And I wait for 1 seconds
    Then warning message with text "Entered passwords should match" is present





