@assessment
  Feature: Assessment Scenario

    @assessment1
    Scenario: Password and Confirm Password Field Verification
      Given I navigate to registration page
      When I type "Abc" into first name field
      And I type "Student" into last name field
      And I type "denisxdenis@filerr.site" into email field
      And I type "123" into group code field
      And I click on register me button
      Then "This field is required" error text should be displayed
      And I type "Student 123" into password field
      Then "Whitespaces are not allowed" error message should pop up
      When I clear password field
      And I type "12" into password field
      And I click on register me button
      Then "Should be at least 5 characters" error message should be displayed
      And I wait for 2 sec
      When I clear password field
      And I type "Student123" into password field
      And I wait for 2 sec
      When I type "Student12" into confirm password field
      Then "Entered passwords should match" error text should pop up
      And I wait for 2 sec
      When I clear confirm password field
      And I type "Student123" into confirm password field
      And I click on register me button
      And I wait for 2 sec
      Then registration confirmation page should be displayed
