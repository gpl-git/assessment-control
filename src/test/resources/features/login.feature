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






