@registrationPassword
  Feature: Password Validation
    
    Background: 
      Given I go to "ask"

    @happyPath
    Scenario: Registration Password Happy Path
      When I click register now link
      And I wait for 1 sec
      When I enter "John" into first name field
      When I enter "Doe" into last name field
      And I enter "joe.doe@test.com" into email field
      And I enter "123" into group field
      And I enter "12345" into password field
      And I enter "12345" into confirm password password field
      And click register me button
      Then I verify that "You have been Registered." message is displayed


    @passDoNotMatch
    Scenario: Registration Failed When Pass and ConfPass are not matching
      When I click register now link
      And I wait for 1 sec
      When I enter "John" into first name field
      When I enter "Doe" into last name field
      And I enter "joe.doe@test.com" into email field
      And I enter "123" into group field
      And I enter "12345" into password field
      And I enter "12344" into confirm password password field
      And click register me button
      Then I verify that "Entered passwords should match" alert message is displayed

    @PassEmpty
    Scenario: Confirm Password Field Left Empty
      When I click register now link
      And I wait for 1 sec
      When I enter "John" into first name field
      When I enter "Doe" into last name field
      And I enter "joe.doe@test.com" into email field
      And I enter "123" into group field
      And I enter "12345" into password field
      And click register me button
      Then I verify that "This field is required" alert message is displayed

    @PassBothFieldsEmpty
    Scenario: Password and Confirm Password Fields Left Empty
      When I click register now link
      And I wait for 1 sec
      When I enter "John" into first name field
      When I enter "Doe" into last name field
      And I enter "joe.doe@test.com" into email field
      And I enter "123" into group field
      And click register me button
      Then I verify that "This field is required" alert message is displayed


    Scenario Outline: Password Validation -outline
      When I click register now link
      And I wait for <sec> sec
      When I enter <firstName> into first name field
      When I enter <lastName> into last name field
      And I enter <email> into email field
      And I enter <number> into group field
      And I enter <password> into password field
      And I enter <confirmPassword> into confirm password password field
      And click register me button
      Then I verify that <message> message is displayed
      Examples:
        | sec | firstName | lastName | email              | number | password | confirmPassword | message                     |
        | 1   | "John"    | "Doe"    | "joe.doe@test.com" | "123"  | "12345"  | "12345"         | "You have been Registered." |
        | 1   | "John"    | "Doe"    | "joe.doe@test.com" | "123"  | "12345"  | "12344"         | "Entered passwords should match" |
        | 1   | "John"    | "Doe"    | "joe.doe@test.com" | "123"  | "12345"  | " "             | "This field is required" |
        | 1   | "John"    | "Doe"    | "joe.doe@test.com" | "123"  | " "      | " "             | "This field is required" |


