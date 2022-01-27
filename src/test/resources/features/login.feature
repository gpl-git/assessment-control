@login
  Feature: test set log in
    @scenario1
    Scenario: Verify that users can Log In with an already registered account
      Given I open login page Assessment Control Portnov Computer School
      Then I verify that page title is "Assessment Control @ Portnov"
      When I enter email "student2@test.com"
      And I enter password "12345"
      And I click on button "Sign In"
      And I wait for 5 sec
      Then I will be redirected to my profile

    @scenario2
    Scenario: Verify that user can't login with invalid email & password
      Given I open login page Assessment Control Portnov Computer School
      Then I verify that page title is "Assessment Control @ Portnov"
      When I enter email "student2@test.com1"
      And I enter password "123451"
      And I click on button "Sign In"
      And I wait for 5 sec
      Then I should receive error Authentication failed. User not found or password does not match

    @scenario3
    Scenario: Verify that password is masked
      Given I open login page Assessment Control Portnov Computer School
      Then I verify that page title is "Assessment Control @ Portnov"
      And I enter password "123451"
      Then password should be masked

    @scenario5
    Scenario: Verify that masked password can't be copy by any user
      Given I open login page Assessment Control Portnov Computer School
      Then I verify that page title is "Assessment Control @ Portnov"
      And I enter password "123451"
      Then user try copy password

    @scenario6
    Scenario: Verify that user not allowed entering any white spaces in password field
      Given I open login page Assessment Control Portnov Computer School
      Then I verify that page title is "Assessment Control @ Portnov"
      And I enter password " 123451 "
      And I click on button "Sign In"
      Then I should receive error Whitespaces are not allowed

    @scenario7
    Scenario: Verify email field Case insensitive
      Given I open login page Assessment Control Portnov Computer School
      Then I verify that page title is "Assessment Control @ Portnov"
      When I enter email "STUDENT2@TEST.COM"
      And I enter password "12345"
      And I click on button "Sign In"
      And I wait for 5 sec
      Then I will be redirected to my profile

    @scenario8
    Scenario: Verify that user cannot log in if use password in incorrect case
      Given I open login page Assessment Control Portnov Computer School
      Then I verify that page title is "Assessment Control @ Portnov"
      When I enter email "yuriiloziak1994@gmail.com"
      And I enter password "yuriiloziak123"
      And I click on button "Sign In"
      And I wait for 5 sec
      Then I will be redirected to my profile
      Then I click on log out
      Then I click on element log out
      Then I verify that page title is "Assessment Control @ Portnov"
      And I wait for 5 sec
      When I enter email "yuriiloziak1994@gmail.com"
      And I enter password "Yuriiloziak123"
      And I click on button "Sign In"
      And I wait for 5 sec
      Then I should receive error Authentication failed. User not found or password does not match

    @scenario4
    Scenario: Verify that the user cannot "cut" anything from password field
      Given I open login page Assessment Control Portnov Computer School
      Then I verify that page title is "Assessment Control @ Portnov"
      And I enter password "yuriiloziak123"
      Then I try to cut password field
      And I wait for 10 sec

    @scenario9
    Scenario: Verify that user cannot login with invalid password valid email
      Given I open login page Assessment Control Portnov Computer School
      Then I verify that page title is "Assessment Control @ Portnov"
      When I enter email "student2@test.com"
      And I enter password "invalid"
      And I click on button "Sign In"
      And I wait for 5 sec
      Then I should receive error Authentication failed. User not found or password does not match

    @scenario10
    Scenario: Verify that user cannot login with invalid email valid email password
      Given I open login page Assessment Control Portnov Computer School
      Then I verify that page title is "Assessment Control @ Portnov"
      When I enter email "student2@test.com1"
      And I enter password "12345"
      And I click on button "Sign In"
      And I wait for 5 sec
      Then I should receive error Authentication failed. User not found or password does not match

    @scenario11
    Scenario: Verify that user get notification if try to login with empty field password & login
      Given I open login page Assessment Control Portnov Computer School
      Then I verify that page title is "Assessment Control @ Portnov"
      And I click on button "Sign In"
      And I wait for 5 sec
      Then I should receive error on bottom email field This field is required
      Then I should receive error on bottom password field This field is required

    @scenario12
    Scenario: Verify that user can copy email field
      Given I open login page Assessment Control Portnov Computer School
      Then I verify that page title is "Assessment Control @ Portnov"
      When I enter email "student2@test.com1"
      Then I try to copy email field

    @scenario13
    Scenario: Verify that user can copy password field
      Given I open login page Assessment Control Portnov Computer School
      Then I verify that page title is "Assessment Control @ Portnov"
      And I enter password "12345"
      Then I try to copy password field

    @scenario14
    Scenario: Verify that Sigh in button does not block or set a delay even after
    10 failed attempts to log in with invalid credentials for the last 1 min.
      Given I open login page Assessment Control Portnov Computer School
      Then I verify that page title is "Assessment Control @ Portnov"
      When I enter email "student2@test.com1"
      And I enter password "12345"
      Then I click sign in 10 times
      When I clear email field
      When I enter email "student2@test.com"
      And I click on button "Sign In"
      And I wait for 5 sec
      Then I will be redirected to my profile
























