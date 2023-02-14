@registration_GroupCode

  Feature: Registration_Group Code Scenarios
    Background:
      Given I open "registration" website
      When I type "Russo" into firstname field
      And I type "Smith" into lastname field
      When I type "abc@efg.com" into email field
      And I type "12345" into password field
      When I type "12345" into confirmPassword field
      

    @registration_GroupCode1 @regression
    Scenario: Registration Group code allowable characters: Alphanumeric & Special characters
      When I type "@AB" into group code field
      And I click "Register Me" button
      And I wait for 2 sec
      Then "You have been Registered." confirmation message should be displayed RA

    @registration_GroupCode2
    Scenario: Group code field required, can’t be empty (Negative)
      When I type "" into group code field
      And I click "Register Me" button
      And I wait for 2 sec
      Then "This field is required" error message should be displayed


    @registration_GroupCode3
    Scenario: Group code field requires min 1 character
      When I type "B" into group code field
      And I click "Register Me" button
      And I wait for 2 sec
      Then "You have been Registered." confirmation message should be displayed RA

    @registration_GroupCode4
    Scenario: Group code does not accept more than 10 charactetrs(Max 10 characters- 10 characters+1)
      When I type "1@3$56&8(12" into group code field
      And I click "Register Me" button
      And I wait for 2 sec
      Then "should no more than 10 characters" error message should be displayed

    @registration_GroupCode5
    Scenario: Group code accepts max 10 characters- 10 characters even
      When I type "12dse2agfe" into group code field
      And I click "Register Me" button
      And I wait for 2 sec
      Then "You have been Registered." confirmation message should be displayed RA

    @registration_GroupCode6
    Scenario: White spaces are not allowed in Group code
      When I type "AB C" into group code field
      And I click "Register Me" button
      And I wait for 2 sec
#      Known issue JAN23-275
      Then "Whitespaces are not allowed" error message should be displayed

    Scenario Outline: Group code field error messages - Outline
      When I type <group> into group code field
      And I click "Register Me" button
      And I wait for 2 sec
      Then <expectedError> error message should be displayed
      Examples:
        | group  | expectedError                  |
        | "" | "this field cannot be empty" |
        | "1@3$56&8(12" | "should no more than 10 characters" |
        | "AB C" | "Whitespaces are not allowed" |

    Scenario Outline: Registration confirmation message - Outline
      When I type <group> into group code field
      And I click "Register Me" button
      And I wait for 2 sec
      Then <expectedMessage> confirmation message should be displayed RA
      Examples:
        | group | expectedMessage            |
        | "@AB" | "You have been Registered." |
        | "B" | "You have been Registered." |
        | "12dse2agfe" | "You have been Registered." |












