@registration
  Feature: Registration

    @firstName
    Scenario Outline: Registration first name - happy path
      Given I open "registration"
      When I enter <firstName> as first name
      And I enter <lastName> as last name
      And I enter <email> as email
      When I enter "abc" as group code
      And I enter "12345" as password
      And I confirm password as "12345"
      When I click "Register Me" button
      And I wait for 3 sec
      Then confirmation message <message> should be displayed
      Examples:
        | firstName | lastName   | email                  | message                     |
        | "Natalia" | "v" | "vatanina09@gmail.com" | "You have been Registered." |
        | "NATALIA" | "v" | "vatanina10@gmail.com" | "You have been Registered." |
        | "N" | "v" | "vatanina11@gmail.com" | "You have been Registered." |
        | "n" | "v" | "vatanina12@gmail.com" | "You have been Registered." |
        | "Nataliafffgfgffffdfdfdfdfdfdfddffdfdfdfdffdfdfdfdfdfdfdfdffdfdfdfdfdfdfdfdfdfddffdfdfdfdfdfdfdfdfdfdfdfdfdffdfdfdfdfdfdffdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfdfddgdgdgdgdgdgdgdggdgdgdgdgdgdgdgdgddgdggdgdgdgdggdgdgdgdgggdggdgdgdgdggdggdgdggddgdgdgdgdgdgdgdf" | "v" | "vatanina13@gmail.com" | "You have been Registered." |


    @firstName2
    Scenario Outline: Registration first name - validation error messages
      Given I open "registration"
      When I enter <firstName> as first name
      And I enter "vatanina" as last name
      And I enter "vatanina01@gmail.com" as email
      When I enter "abc" as group code
      And I enter "12345" as password
      And I confirm password as "12345"
      When I click "Register Me" button
      And I wait for 3 sec
      Then error message <error> should be displayed
      Examples:
        | firstName | error                    |
        | ""        | "This field is required" |
        | " "       | "Should contain only latin characters" |
        | " Natalia"        | "Should contain only latin characters" |
        | "Natalia "        | "Should contain only latin characters" |
        | "Natalia1"        | "Should contain only latin characters" |
        | "Natalia!"        | "Should contain only latin characters" |
        | "123456"        | "Should contain only latin characters" |
        | "!@#$"        | "Should contain only latin characters" |
        | "123456!@#$"        | "Should contain only latin characters" |






