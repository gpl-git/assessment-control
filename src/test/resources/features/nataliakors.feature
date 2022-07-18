@registrationNK
  Feature: Registration: Password And Confirm Password

    Background:
      Given I NK go to "registration" page

    @registrationNK1
    Scenario: Valid Password And Confirm Password allow to register
      When I NK enter "Eva" into First Name field
      And I NK enter "Tomas" into Last Name field
      And I NK enter "atomion@gmailpro.ml" into Email field
      And I NK enter "ABC" into Group Code
      When I NK type "12345" in the Password field
      And I NK click on the Confirm Password field
      And I NK type "12345" in the Confirm Password field
      And I wait for 2 sec
      Then I click button "Register Me"
      And I NK see verification message


    @RegistrationNK2
    Scenario: Verify Password And Confirm Password
      When I NK type "1234" in the Password field
      Then I NK click on the Confirm Password field
      Then NK error message "Should be at least 5 characters" is displayed
      And I wait for 2 sec
      When I NK clear Password field
      Then NLK error message "This field is required" is displayed
      And I wait for 2 sec
      And I NK refresh the "registration" page
      When I NK type "12345" into password field
      And I NK enter "natan" into confirm password field
      And I Nk submit the form
      Then NK Error message will be "Entered passwords should match"
      And I wait for 2 sec
      And I NK refresh the "registration" page
      And I wait for 2 sec

    @RegistrationNK3
    Scenario: Verify more than Max Characters in the Password And Confirm Password Fields are not allowed
      When I NK enter "Eva" into First Name field
      And I NK enter "Tomas" into Last Name field
      And I NK enter "atomion@gmailpro.ml" into Email field
      And I NK enter "ABC" into Group Code
      When I NK type "123456789012345678901234567890123" in the Password field
      And I NK click on the Confirm Password field
      And I NK type "123456789012345678901234567890123" in the Confirm Password field
      And I wait for 2 sec
      Then I click button "Register Me"
      Then NK verification message not displayed

    @RegistrationNK4
    Scenario: Verify that leading and trailing spaces in the Password And Confirm Password Fields are not allowed
      When I Nk type " 12345" in the Password Field
      And I NK click on the Confirm Password field
      Then Nk error message "Whitespaces are not allowed" will display
      And I Nk type " 12345" in the Confirm Password Field
      Then I click button "Register Me"
      Then Nk error message "Whitespaces are not allowed" will display
      And I wait for 2 sec
      And I NK refresh the "registration" page
      When I Nk type "12345 " in the Password Field
      And I NK click on the Confirm Password field
      Then Nk error message "Whitespaces are not allowed" will display
      And I Nk type "12345 " in the Confirm Password Field
      Then I click button "Register Me"
      Then Nk error message "Whitespaces are not allowed" will display
      And I wait for 2 sec












#      Then NK error message "This field is required" is not displayed





