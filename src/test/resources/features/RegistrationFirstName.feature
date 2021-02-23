@RegistrationFirstName

  Feature: Registration - first name field behavior

    @RegistrationFirstName1
    Scenario: First name field happy path
      Given I navigate to "registration page"
      When I complete registration form
      And I wait for 2 sec
      And I push "Register me" button
      And I wait for 2 sec
      Then I verify that message "You have been Registered." is displayed

    @RegistrationFirstName2
    Scenario: First Name field Not allow Special characters
      Given I navigate to "registration page"
      When I type "John12" in first name field
      And I push "Register me" button
      Then I should see error message "Should contain only latin characters"
      And I wait for 3 sec

    @RegistrationFirstName3
    Scenario: Firs name field min 1 character
      Given I navigate to "registration page"
      When I type "J" in first name field
      And I fill out the rest of the fields
      And I push "Register me" button
      And I wait for 2 sec
      Then I verify that message "You have been Registered." is displayed

    @RegistrationFirstName4
    Scenario: First name field accepts Max 254 char
      Given I navigate to "registration page"
      When I type Max allowable char in First Name field
      And I fill out the rest of the fields
      And I push "Register me" button
      And I wait for 2 sec
      Then I verify that message "You have been Registered." is displayed
#      BUG it only accepts 251 char

    @RegistrationFirstName5
    Scenario: First name field does not accepts MAX+One char
      Given I navigate to "registration page"
      When I type Max+One allowable char in First Name field
      And I fill out the rest of the fields
      And I push "Register me" button
      And I wait for 3 sec
      Then I verify that error message "Data too long" will be displayed
      And I wait for 2 sec

    @RegistrationFirstName6
    Scenario: First Name field required, can’t be empty
      Given I navigate to "registration page"
      When I fill out registration form except First Name Field
      And I push "Register me" button
      And I wait for 2 sec
      Then I should see error message "This field is required"
      And I wait for 2 sec

    @RegistrationFirstName7
    Scenario: White spaces are not allowed
      Given I navigate to "registration page"
      When I type "John Wick1234" in first name field
      And I push "Register me" button
      Then I should see error message "Should contain only latin characters"
      And I wait for 2 sec

