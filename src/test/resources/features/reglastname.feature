@reglastname @regression

  Feature: Registration Last Name Scenarios
      Background: Fill Form

        Given I go to "registration" page
    @regression1
    Scenario: Registration Last Name verification of confirmation

      Given I go to "registration" page
      When I type "a" into first name field
      And I type "abc" into last name field
      And I type "emoka52@packiu.com" into email field
      And I type "XYZ" into group field
      And I type "12345" into password field
      And I type "12345" into confirm password field
      And I click on "Register Me" button
      And I wait for 2 sec
      Then I verify that element "You have been Registered." is present
      And I wait for 2 sec
    @regression2
    Scenario: Verify Registration Last Name confirmation message

      Given I go to "registration" page
      When I type "a" into first name field
      And I type "abc" into last name field
      And I type "emoka52@packiu.com" into email field
      And I type "XYZ" into group field
      And I type "12345" into password field
      And I type "12345" into confirm password field
      And I wait for 2 sec
      # This method "VERIFY" works only for last name field into registration form
      Then I verify that error message contains "" ns
      And I type "12345" into last name field
      And I wait for 2 sec
      Then I verify that error message contains "Should contain only latin characters" ns
      And I clear last name field ns
      And I wait for 2 sec
      And I type "можн" into last name field
      And I wait for 2 sec
      Then I verify that error message contains "Should contain only latin characters" ns
      And I wait for 2 sec

    @regression3
    Scenario Outline: Verify Registration Last Name confirmation message - Parametrize

      When I type "a" into first name field
      And I type <lname> into last name field
      And I type "student10@test.com" into email field
      And I type "XYZ" into group field
      And I type "12345" into password field
      And I type "12345" into confirm password field
      And I wait for 2 sec
      And I click on "Register Me" button
      Then I verify that error message contains <errMassege> ns
      And I wait for 3 sec

      Examples:
        | lname          | errMassege                             |
        | "ABCabc"       | ""                                     |
        | "123456"       | "Should contain only latin characters" |
        | "@@##$%&!"     | "Should contain only latin characters" |
        | ""             | "This field is required"               |
        | "A BC"         |"Should contain only latin characters"  |
        | " "            |"Should contain only latin characters"  |
        | "asdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklas"             |""                    |

        #      Known issue max+1 characters ASKJ-110
        | "asdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklasdfghjklast"            |"Too many characters" |

