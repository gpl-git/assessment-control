@LogIn
  Feature: LogIn Scenarios

@LogIn1
  Scenario: LogIn Page with valid credentials
  Given I navigate to "login" page
  When I enter "lmislinski@nbobd.com" into email field
  And I type password "123456"
  When I hit button "Sign In"
  And I wait for 4 seconds
  When I click "Log Out"
  Then confirmation window should appear
  And I click "Log Out" button
  Then return to "login"page

    @LogIn2
    Scenario: LogIn Page Register Now with valid credentials
    Given I navigate to "login" page
    When I click button "Register Now"
    Then "Registration"page should be appear
    When I type "Milla" into first name field
    And I type "Nyaga" into last name field
    And I enter "milla.nyaga@gmail.com" in email field
    And I type "12345"into group code field
    And I enter "12345" into password field
    And I enter "12345" into confirm password field
    When I click on "Register Me" button
    Then confirmation page should appear
    When I click Back to Login Page
    Then I see "login" page

    @LogIn3
      Scenario: LogIn Page no login without password
      Given I navigate to "login" page
      And I wait for 4 seconds
      When I enter "lmislinski@nbobd.com" into email field
      And I hit button "Sign In"
      Then password field should contain error message

    @LogIn4
      Scenario: LogIn Page no login without email
        Given I navigate to "login" page
        And I wait for 4 seconds
        When I type password "123456"
        And I hit button "Sign In"
        Then email field should contain error message

    @LogIn5
        Scenario: Invalid email address no login
          Given I navigate to "login" page
          And I wait for 4 seconds
          When I type "lmislinski@nbobd.co" into email field
          And I type password "123456"
          And I hit button "Sign In"
          Then pop up window with error message text should show up

    @LogIn6
          Scenario: Invalid password no login
            Given I navigate to "login" page
            And I wait for 4 seconds
            When I enter "lmislinski@nbobd.com" into email field
            And I type password "12345"
            And I hit button "Sign In"
            Then pop up window with error message text should show up

    @LogIn7
            Scenario: Verification if masked password
              Given I navigate to "login" page
              And I wait for 4 seconds
              When I enter "lmislinski@nbobd.com" into email field
              And I type password "123456"
              Then password should be masked

    @LogIn8
                Scenario: Verify cut menu is disable
                Given I navigate to "login" page
                And I wait for 4 seconds
                When I enter "lmislinski@nbobd.com" into email field
                And I type password "123456"
                Then I do right click on password field to see a menu where cut is disable

    @LogIn9
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

    @LogIn10
                    Scenario: Verify that Password field is Case insensitive
                    Given I navigate to "login" page
                    When I enter "milla.nyaga@gmail.com" into email field
                    And I type "MILLA12345" into password field
                    When I hit button "Sign In"
                    Then pop up window with error message text should show up

    @LogIn11
                  Scenario: Trailing spaces are not allowed
                    Given I navigate to "login" page
                    And I wait for 4 seconds
                    When I enter "lmislinski@nbobd.com" into email field
                    And type enter
                    Then email field should contain error message

    @LogIn12
                    Scenario: User can NOT log in if email address is NOT entered java code
                      Given I navigate to "login" page
                      When I enter "lmislinski@nbobd.com" into email field
                      Then email field should contain error message

    @LogIn13
    Scenario: Leading space are NOT allowed in the "Email" field
      Given I navigate to "login" page
      And I wait for 4 seconds
      When I type enter into email field
      And I enter "lmislinski@nbobd.com" into email field
      Then email field should contain error message
      @LogIn14
      Scenario: Copy menu item on "Password" field is disabled
        Given I navigate to "login" page
        And I wait for 4 seconds
        When I enter "lmislinski@nbobd.com" into email field
        And I type password "123456"
        Then I do right click on password field to see a menu where copy is disable
































