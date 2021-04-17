@registration
  Feature: Registration Password/Confirm Password Scenario

    @registration1
    Scenario: Password validation - User registered
      Given I open "registration" page
      When I type "QA" into first name field
      And I type "Automation" into last name field
      And I type new email
      And I type "ABC" into group code
      And I type "qwer1234!" into password field
      And I type "qwer1234!" into confirmation field
      And I click Register Me button
      And I wait for 2 sec
      Then I verify user registration message "You have been Registered."

   @registration2
    Scenario Outline: Password validation - Password error messages
      Given I open "registration" page
      When I type "QA" into first name field
      And I type "Automation" into last name field
      And I type "qa.automation1@gmail.com" into email filed
      And I type "ABC" into group code
      And I type <password> into password field
      And I click confirmation field
      And I wait for 2 sec
      Then message <message> should be displayed
      Examples:
      | password                           |message|
      |""                                  |"This field is required"|
      |"123"                               |"Too short. Should be at least 5 characters"|
      |"1234567890dlwiuehlkjdfbhlksldjfh4" |"Too long. Should be no more than 32 characters"|
      |"qwer 1234"                         |"Whitespaces are not allowed"|


   @registration3
    Scenario: Password validation - Confirm Password error message
      Given I open "registration" page
      When I type "QA" into first name field
      And I type "Automation" into last name field
      And I type "qa.automation1@gmail.com" into email filed
      And I type "ABC" into group code
      And I type "qwer1234!" into password field
      And I type "qwer1234" into confirmation field
      And I click Register Me button
      And I wait for 2 sec
      Then message "Entered passwords should match" should be displayed

    @registration4
    Scenario: Password validation - Password/Confirm password fields are masked
      Given I open "registration" page
      When I type "QA" into first name field
      And I type "Automation" into last name field
      And I type new email
      And I type "ABC" into group code
      And I type "qwer1234!" into password field
      And I type "qwer1234!" into confirmation field
      Then password is masked and copy and cut disabled
      And confirm password is masked and copy and cut disabled













      


