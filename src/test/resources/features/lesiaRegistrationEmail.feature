@registrationEmail @regression

  Feature: Registration Email
    Background:
      Given I navigate to "registration" page
      When I type "Lesia" into First Name field
      And I type "Vinichenko" into Last Name field
      When I type "123" into group field
      Then I type "12345" into password field
      And I type "12345" into confirm password field
      And I click on "Register Me" button


    @registrationEmail1
    Scenario: Email field is required
      Then I validate Email field displays the error message "This field is required"
      And I wait for 1 sec


    @registrationEmail2
    Scenario Outline: Validate possible inputs into Email field
      Given I navigate to "registration" page
      When I type "Lesia" into First Name field
      And I type "Vinichenko" into Last Name field
      Then I type <email> into Email field
      Then I type "123" into group field
      Then I type "12345" into password field
      Then I type "12345" into confirm password field
      And I click on "Register Me" button
      Then confirmation message <confirmationMessage> should be displayed

      Examples:
        | email                                                                            | confirmationMessage          |
        | "lesia.vinichen@gmail.com"                                                       | " You have been Registered." |
        | "7lesia-@gmail.com"                                                              | " You have been Registered." |
        | "qwqqwqwqwqwqwqwqwqwqwqwqwqwqwqwqwqwqwqwqwqwqwqwqwqwqwqwqwqqwqwqw@gmail.com"     | " You have been Registered." |
        | "q@gmail.com"                                                                    | " You have been Registered." |
        | "lesia@qwqqwqwqwqwqwqwqwqwqwqwqwqwqwqwqwqwqwqwqwqwqwqwqwqwqwqwqwqqwqwq.com"      | " You have been Registered." |
        | "lesia@q.com"                                                                    | " You have been Registered." |
        | "lesia@qmail.qwqqwqwqwqwqwqwqwqwqwqwqwqwqwqwqwqwqwqwqwqwqwqwqwqwqwqwqwqqwqwq"    | " You have been Registered." |
        | "lesia@qmail.q"                                                                  | " You have been Registered." |


    @registrationEmail3
    Scenario: Validate Email field can except max characters (total 128)
      When I type 64 characters before "@" and 59 characters after
      And confirmation message " You have been Registered." should be displayed
      And I wait for 1 sec


    @registrationEmail4
    Scenario Outline: Validate possible inputs into email field Negative TCs
      Then I type <email> into Email field
      Then I validate Email field displays the error message <emailError>

      Examples:
        | email                                                                          | emailError                        |
        | " lesia@gmail.com"                                                             | "Should be a valid email address" |
        | "lesia@gmail.com "                                                             | "Should be a valid email address" |
        | "@gmail.com"                                                                   | "Should be a valid email address" |
        | "lesia@.com"                                                                   | "Should be a valid email address" |
        | "lesiagmail.com"                                                               | "Should be a valid email address" |
        | "lesia@."                                                                      | "Should be a valid email address" |
        | "lesia @gm ail.com"                                                            | "Should be a valid email address" |
        | ""                                                                             | "Should be a valid email address" |
        | "lesia@qqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqq111111111111111111111111.com"   | "Should be a valid email address" |
        | "qqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqqq1111111111111111111111111@gmail.com"  | "Should be a valid email address" |
        | "lesia@gmail.comcomcomcomcomcomcomcomcomcomcomcomcomcomcomcomcomcomcomcomcomm" | "Should be a valid email address" |


    @registrationEmail5
    Scenario: Validate Email field doesn't except 128+1 characters
      When I type 64 characters before "@" and 60 characters after
      #known issue in Jira OCT-776
      And I validate Email field displays the error message "Should be a valid email address"
      And I wait for 1 sec