@registrationPassword

  Feature: Registration - Password/Confirm password Scenarios

    @registrationPassword1
    Scenario: Allowable characters: Alphanumeric & Special characters
      Given I navigate to "registration" page
      Then I type "Fname" into First Name field
      And I type "Lname" into Last Name field
      And I type "runohiiri@filevino.com" into Email field
      And I type "FEB" into Group Code field
      And I type "Pass10(){!}?$@#&-" into Password field
      And I type "Pass10(){!}?$@#&-" into Confirm Password field
      Then I click "Register Me" button
      And I wait for 5 sec
      Then element with xpath "//*[contains(text(),'Registered')]" should be displayed

    @registrationPassword2
    Scenario: Password field is required
      Given I navigate to "registration" page
      Then I type "Fname" into First Name field
      And I type "Lname" into Last Name field
      And I type "runohiiri@filevino.com" into Email field
      And I type "FEB" into Group Code field
      Then I click "Register Me" button
      And I wait for 2 sec
      Then message "This field is required" should be displayed

    @registrationPassword3
    Scenario: White spaces are not allowed
      Given I navigate to "registration" page
      Then I type "Fname" into First Name field
      And I type "Lname" into Last Name field
      And I type "runohiiri@filevino.com" into Email field
      And I type "FEB" into Group Code field
      And I type "Pass 10" into Password field
      And I type "Pass 10" into Confirm Password field
      Then I click "Register Me" button
      And I wait for 2 sec
      Then message "Whitespaces are not allowed" should be displayed

    @registrationPassword4
    Scenario: Minimum (5) characters
      Given I navigate to "registration" page
      Then I type "Fname" into First Name field
      And I type "Lname" into Last Name field
      And I type "runohiiri@filevino.com" into Email field
      And I type "FEB" into Group Code field
      And I type "Pas4" into Password field
      And I type "Pas4" into Confirm Password field
      Then I click "Register Me" button
      And I wait for 2 sec
      Then message "Should be at least 5 characters" should be displayed

    @registrationPassword5
    Scenario: Maximum (32)+1 characters
      Given I navigate to "registration" page
      Then I type "Fname" into First Name field
      And I type "Lname" into Last Name field
      And I type "runohiiri@filevino.com" into Email field
      And I type "FEB" into Group Code field
      And I type "abcdeabcdeabcdeabcdeabcdeabcde033" into Password field
      And I type "abcdeabcdeabcdeabcdeabcdeabcde033" into Confirm Password field
      Then I click "Register Me" button
      And I wait for 5 sec
      Then element with xpath "//*[contains(text(),'Registered')]" should be displayed


    @registrationPassword6
    Scenario: Password must match Confirm Password
      Given I navigate to "registration" page
      Then I type "Fname" into First Name field
      And I type "Lname" into Last Name field
      And I type "runohiiri@filevino.com" into Email field
      And I type "FEB" into Group Code field
      And I type "Pass10" into Password field
      And I type "Pass11" into Confirm Password field
      Then I click "Register Me" button
      And I wait for 2 sec
      Then message "Entered passwords should match" should be displayed




