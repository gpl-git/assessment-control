@RegistrationLastname1
  Feature: Registration Last Name
    Scenario: Registration Last name validation
      Given I navigate to registration page
      When I type first name "Super"
      And I type last name "Women"
      And I type email "student200@test.com"
      And I type group code "ABC"
      And I type password "12345"
      And I type confirm password "12345"
      And I click Register Me
      Then  message "You have been Registered." appears


    @RegistrationLastname2
    Scenario: Registration Last name required cannot be empty
      Given I navigate to registration page
      When I type first name "Super"
      And I type email "student20@test.com"
      And I type group code "ABC"
      And I type password "12345"
      And I type confirm password "12345"
      And I click Register Me
      Then message "This field is required" appears

    @RegistrationLastname3
    Scenario: Registration Last name white spaces are not allowed
      Given I navigate to registration page
      When I type first name "Super"
      And I type last name "W  omen"
      And I type email "student20@test.com"
      And I type group code "ABC"
      And I type password "12345"
      And I type confirm password "12345"
      And I click Register Me
      Then message "Should contain only latin characters" appears

    @RegistrationLastname4
    Scenario: Registration Last name- Minimum character
      Given I navigate to registration page
      When I type first name "Super"
      And I type last name "W"
      And I type email "student20@test.com"
      And I type group code "ABC"
      And I type password "12345"
      And I type confirm password "12345"
      And I click Register Me
      Then message "You have been Registered." appears

    @RegistrationLastname5
    Scenario: Registration Last name- Maximum character
      Given I navigate to registration page
      When I type first name "Super"
      And I type last name "testtesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttestte"
      And I type email "student20@test.com"
      And I type group code "ABC"
      And I type password "12345"
      And I type confirm password "12345"
      And I click Register Me
      Then message "Data too long " appears
      # AS-281 Bug report (It should accepts 254 characters it accepts only 250characters)

    @RegistrationLastname6
    Scenario: Registration Last name- Maximum + 1 character
      Given I navigate to registration page
      When I type first name "Super"
      And I type last name "ttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttesttestte"
      And I type email "student20@test.com"
      And I type group code "ABC"
      And I type password "12345"
      And I type confirm password "12345"
      And I click Register Me
      Then message "Data too " appears


    @RegistrationLastname7
    Scenario: Registration Last name special characters
      Given I navigate to registration page
      When I type first name "Super"
      And I type last name "@#$%^&"
      And I type email "student20@test.com"
      And I type group code "ABC"
      And I type password "12345"
      And I type confirm password "12345"
      And I click Register Me
      Then message "Should contain only latin characters" appears

    @RegistrationLastname8
    Scenario: Registration Last name - Alphanumeric characters
      Given I navigate to registration page
      When I type first name "Super"
      And I type last name "123Women"
      And I type email "student20@test.com"
      And I type group code "ABC"
      And I type password "12345"
      And I type confirm password "12345"
      And I click Register Me
      Then message "Should contain only latin characters" appears














