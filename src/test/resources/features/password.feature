@registration
  Feature: Registration Password/Confirm Password Scenario

    @registration1
   Scenario: Password validation - User registered
      Given I open "registration" page
      When I type "QA" into first name field
      And I type "Automation" into last name field
      And I type "qa.automation1122@gmail.com" into registration email field
      And I type "ABC" into group code
      And I type "qwer1234!" into registration password field
      And I type "qwer1234!" into confirmation field
      And I click Register Me button
      And I wait for 2 sec
      Then I verify user registration message "You have been Registered."

    @registration2
    Scenario Outline: Password validation - User Password is required
      Given I open "registration" page
      When I type "QA" into first name field
      And I type "Automation" into last name field
      And I type "qa.automation1122@gmail.com" into registration email field
      And I type "ABC" into group code
      And I type <password> into registration password field
      And I click confirmation field
      And I wait for 2 sec
      Then password error message <errorMessage> is displayed
      Examples:
      | password |errorMessage|
      |          |"This field is required"|
      |123       |"Too short. Should be at lest 5  characters"|
      |1234567890dlwiuehlkjdfbhlksldjfh4 |"Too long. Should be no more than 32 characters"|


    @registration5
    Scenario: Password validation - white spaces are not allowed
      Given I open "registration" page
      When I type "QA" into first name field
      And I type "Automation" into last name field
      And I type "qa.automation1122@gmail.com" into registration email field
      And I type "ABC" into group code
      And I type "qwerty 1234" into registration password field
      And I click confirmation field
      And I wait for 2 sec
      Then password error message "White spaces are not allowed" is displayed

    @registration6
    Scenario: Password validation - Confirm Password error message
      Given I open "registration" page
      When I type "QA" into first name field
      And I type "Automation" into last name field
      And I type "qa.automation1122@gmail.com" into registration email field
      And I type "ABC" into group code
      And I type "qwer1234" into registration password field
      And I type "qwer1234!" into confirmation field
      And I click Register Me button
      And I wait for 2 sec
      Then password error message "Entered passwords should match" is displayed












      


