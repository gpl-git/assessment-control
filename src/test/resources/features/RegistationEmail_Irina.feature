@registrationEmail

  Feature: Registration Email Field
    Background:
      Given I open "registration" website

    @registrationEmail1
    Scenario:Email field does not accept special chars other than "@", "_" and "." (Positive)
      When I type "a.b_c@efg.com" into email field
      And I click "Register Me" button
      And I wait for 2 sec

      @registrationEmail2
      Scenario: Email field does not accept special chars other than "@", "_" and "." (Negative "!")
        When I type "!bc@efg.com" into email field
        And I click on group code field
        Then  "Should be a valid email address" error message should be displayed
        And I wait for 2 sec

        @registrationEmail3
        Scenario: Email field required, can’t be empty
          When I type "" into email field
          And I click on group code field
          Then  "This field is required" error message should be displayed
          And I wait for 2 sec

          @registrationEmail4
          Scenario: Email Field allows Max 128 characters
            When I type "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa@aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa.aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" into email field
            And I click on group code field
            And I wait for 2 sec

    @registrationEmail5
    Scenario: Email Field allows Max 128 characters(129,negative)
      When I type "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa@aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa.aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa" into email field
      And I click on group code field
      Then  "Should be a valid email address" error message should be displayed
      And I wait for 2 sec

    @registrationEmail6
    Scenario: Email Field does not allow White spaces(local port)
      When I type "student11 @gmail.com" into email field
      And I click on group code field
      Then  "Should be a valid email address" error message should be displayed
      And I wait for 2 sec

    @registrationEmail7
    Scenario: Email Field does not allow White spaces(domain)
      When I type "student11@ gmail.com" into email field
      And I click on group code field
      Then  "Should be a valid email address" error message should be displayed
      And I wait for 2 sec

    @registrationEmail8
    Scenario: Email Field does not allow White spaces(last part of the domain)
      When I type "student11@gmail. com" into email field
      And I click on group code field
      Then  "Should be a valid email address" error message should be displayed
      And I wait for 2 sec

    @registrationEmail9
    Scenario: Email field does not accept special chars other than "@", "_" and "." (Negative "+")
      When I type "+bc@efg.com" into email field
      And I click on group code field
      Then  "Should be a valid email address" error message should be displayed
      And I wait for 2 sec

    @registrationEmail10
    Scenario: Email field does not accept special chars other than "@", "_" and "." (Negative "$")
      When I type "$bc@efg.com" into email field
      And I click on group code field
      Then  "Should be a valid email address" error message should be displayed
      And I wait for 2 sec