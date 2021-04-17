@forgotPassword
Feature: Forgot Password Scenarios

  Scenario: Valid email / ACT-314
            Preconditions: account a.kaladzinski@aol.com / TestPSW_123 exists
    When I navigate to "http://ask-qa.portnov.com/#/login" page
    And I wait for 1 seconds
    And I click "I forgot my password" link
    And I enter "a.kaladzinski@aol.com" into the field with xpath "//input[@formcontrolname='email']"
    And I enter "a.kaladzinski@aol.com" into the Email field
    And I click button with text "Request Password Reset"
    And I navigate to "https://mail.aol.com/" page
    And I enter "a.kaladzinski@aol.com" into the field with xpath "//input[@id='login-username']"
    And I click element with xpath "//input[@id='login-signin']"
    And I wait for 1 seconds
    And I enter "TestPSW_123" into the field with xpath "//input[@id='login-passwd']"
    And I wait for 1 seconds
    And I click element with xpath "//button[@id='login-signin']"
    And I wait for 3 seconds
    And I click element with xpath "//*[@id='inboxNode']"
    And I wait for 1 seconds
    And I click element with xpath "//span[@title='Reset Your Password']"
    And I wait for 1 seconds
    And I click element with xpath "//a[contains(text(), 'Reset Password')]"
    And I switch to new opened window
    And I enter "123456" into the field with xpath "//input[@placeholder='New Password']"
    And I enter "123456" into the field with xpath "//input[@placeholder='Confirm New Password']"
    And I click button with text "Reset"
    And I wait for 1 seconds
    Then element with text "Your Password was Changed" is present
    And I navigate to "http://ask-qa.portnov.com/#/login" page
    And I enter "a.kaladzinski@aol.com" into the field with xpath "//input[@placeholder='Email *']"
    And I enter "123456" into the field with xpath "//input[@placeholder='Password *']"
    And I click button with text "Sign In"
    And I wait for 2 seconds
    Then user's credentials "TestFirstName TestLastName" are present at element with xpath "//header/div[2]/h3"


  Scenario: Non registered email / ACT-329
            Preconditions: account a.kaladzinski123@aol.com / TestPSW_123 exists
    When I navigate to "http://ask-qa.portnov.com/#/login" page
    And I wait for 1 seconds
    And I click element with xpath "//a[contains(text(), 'I forgot my password')]"
    And I enter "a.kaladzinski123@aol.com" into the field with xpath "//input[@formcontrolname='email']"
    And I click button with text "Request Password Reset"
    And I wait for 1 seconds
    Then warning message with text "Authentication failed. User not found or password does not match" is present at element with xpath "//body/div[1]"

  Scenario:  empty field / ACT-334
    When I navigate to "http://ask-qa.portnov.com/#/login" page
    And I wait for 1 seconds
    And I click element with xpath "//a[contains(text(), 'I forgot my password')]"
    And I click button with text "Request Password Reset"
    And I wait for 1 seconds
    Then warning message with text "This field is required" is present at element with xpath "//mat-error"

  Scenario:  not correct format of email / ACT-336
    This scenario fails as a proper message is not implemented
    When I navigate to "http://ask-qa.portnov.com/#/login" page
    And I wait for 1 seconds
    And I click element with xpath "//a[contains(text(), 'I forgot my password')]"
    And I enter "@@@@.com" into the field with xpath "//input[@formcontrolname='email']"
    And I click button with text "Request Password Reset"
    And I wait for 1 seconds
    Then warning message with text "Invalid email format" is present at element with xpath "//mat-error"

  Scenario: Valid email - password not matching in password request form / ACT-469
  Preconditions: account a.kaladzinski@aol.com / TestPSW_123 exists
    When I navigate to "http://ask-qa.portnov.com/#/login" page
    And I wait for 1 seconds
    And I click element with xpath "//a[contains(text(), 'I forgot my password')]"
    And I enter "a.kaladzinski@aol.com" into the field with xpath "//input[@formcontrolname='email']"
    And I click button with text "Request Password Reset"
    And I navigate to "https://mail.aol.com/" page
    And I enter "a.kaladzinski@aol.com" into the field with xpath "//input[@id='login-username']"
    And I click element with xpath "//input[@id='login-signin']"
    And I wait for 1 seconds
    And I enter "TestPSW_123" into the field with xpath "//input[@id='login-passwd']"
    And I wait for 1 seconds
    And I click element with xpath "//button[@id='login-signin']"
    And I wait for 3 seconds
    And I click element with xpath "//*[@id='inboxNode']"
    And I wait for 1 seconds
    And I click element with xpath "//span[@title='Reset Your Password']"
    And I wait for 1 seconds
    And I click element with xpath "//a[contains(text(), 'Reset Password')]"
    And I switch to new opened window
    And I enter "123456A" into the field with xpath "//input[@placeholder='New Password']"
    And I enter "123456" into the field with xpath "//input[@placeholder='Confirm New Password']"
    And I click button with text "Reset"
    And I wait for 1 seconds
    Then warning message with text "Entered passwords should match" is present at element with xpath "//mat-error"
    




