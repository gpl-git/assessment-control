@registration @groupCode @regression
  Feature: Registration Group Code



    @regression
    Scenario Outline: Registration Group Code - Parameterized
      Given I navigate to "registration" page
      When I type "Mario" into first name field
      And I type "Nintendo" into last name field
      When I type "barafet@arcb.site" into email field
      And I type <groupCode> into group code field
      When I type "T0@ds" into password field
      And I type "T0@ds" into confirm password field
      Then I click on "Register Me" button
      And I wait for 2 sec
      Then I verify that element "You have been Registered." is present
      Examples:
        | groupCode | regMessage                  |
        | "NTDO"    | "You have been Registered." |
        | "@#9"     | "You have been Registered." |
        | "N"       | "You have been Registered." |
        | "ninTEN"  | "You have been Registered." |

    @regression1
    Scenario: Validation/Error Message - Registration Group Code Parameterized
      Given I navigate to "registration" page
      When I type "Mario" into first name field
      And I type "Nintendo" into last name field
      When I type "barafet@arcb.site" into email field
      And I type "ninTEND" into group code field
      When I type "T0@ds" into password field
      And I type "T0@ds" into confirm password field
      Then I click on "Register Me" button
      And I wait for 2 sec
      Then I confirm that error message "Too long. Should be no more than 6 characters" is displayed

    @regression2
    Scenario Outline: Validation/Error Message - Registration Group Code Parameterized
      Given I navigate to "registration" page
      When I type "Mario" into first name field
      And I type "Nintendo" into last name field
      When I type "barafet@arcb.site" into email field
      And I type <groupCode> into group code field
      When I type "T0@ds" into password field
      And I type "T0@ds" into confirm password field
      Then I click on "Register Me" button
      And I wait for 2 sec
      Then I confirm that error message <notification> is displayed
      Examples:
        | groupCode | notification                                    |
        | "ninTEND" | "Too long. Should be no more than 6 characters" |
        | ""        | "This field is required" |