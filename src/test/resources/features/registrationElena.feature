@registration
  Feature: Registration
    @email
    Scenario: Registration email - happy path
      Given I open "registration"
      When I enter "elena" as first name
      And I enter "Kud" as last name
      And I enter "elkudriashova2@gmail.com" as email
      When I enter "abc" as group code
      And I enter "12345" as password
      And I confirm password as "12345"
      When I click "Register Me" button
      And I wait for 5 sec
      Then confirmation message "You have been Registered." should be displayed

    @email2
    Scenario Outline: Registration email - validation of error messages
      Given I open "registration"
      When I enter "elena" as first name
      And I enter "Kud" as last name
      And I enter <email> as email
      When I enter "abc" as group code
      And I enter "12345" as password
      And I confirm password as "12345"
      When I click "Register Me" button
      And I wait for 5 sec
      Then error message <error> should be displayed
      Examples:
         | email |  error                    |
         | ""    |  "This field is required" |
         | " "   |  "Should be a valid email address" |
         | "yya_15680@ma.ilb_ox@vip.com"    |  "Should be a valid email address" |
         | "tatiana.verovkina@gmail.co_m"    |  "Should be a valid email address" |
         | "ttatiana.-verovkina@gmail.co._m"    |  "Should be a valid email address" |
         | "I@64-characters-is-the-longest-possible-domain-name-for-a-websiteE.com"    |  "Should be a valid email address" |
         | "I@.com"    |  "Should be a valid email address" |
         | "users%example.com.123sertoginawi123.girnasorifjthnubgtfrderifnj45@example.org"    |  "Should be a valid email address" |
         | "@gmail.com"    |  "Should be a valid email address" |
         | "t@t.comcomcomcomcomcomcomcomcomcomcomcomcomcomcomcomcomcomcomcomcomc"    |  "Should be a valid email address" |
         | "ya_15680@mailboxvip"    |  "Should be a valid email address" |
         | "tatianagmail.com"    |  "Should be a valid email address" |


