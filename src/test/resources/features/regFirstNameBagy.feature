@regfirstname
  Feature: Registration First Name
    Background:
      Given navigate to "registration"
      Then LN as "D", Email as "abc@test.com", GroupCode as "xyz", Password as "abcde", Confirm Password as "abcde";
      And I look at the page for 2 sec

  @firstName
     Scenario: Verify First Name Field required and at least one character is required
        When you click on Register me
        Then error message should be displayed "This field is required"
        When I type "b" on the First Name field
        Then you click on Register me
        And I look at the page for 2 sec
        And Registration page is confirmed
        And I look at the page for 2 sec
  @whitespace
   Scenario: Verify First Name Field accepts white space
        When I type "Lakme " on the First Name field
        And you click on Register me
        Then "Whitespaces are not allowed" error message is displayed

    Scenario Outline: Verify First Name Field accepts white space Outline
      When I type <onechar> on the First Name field
      And you click on Register me
      Then <erwht> error message is displayed
      Examples:
        | onechar  | erwht                         |
        | "Lakme " | "Whitespaces are not allowed" |
        | "Lak me" | "Whitespaces are not allowed" |
        | " Lakme" | "Whitespaces are not allowed" |
        | "Lakme"  | "Whitespaces are not allowed" |
        | "Lakme d"  | "Whitespace are not allowed" |

    @numofchar
    Scenario: Verify First Name Field accepts 254 Latin characters
      When I enter first name containing 253 Latin characters
      And you click on Register me
      And I look at the page for 3 sec
      Then Registration page is confirmed

    Scenario Outline: Verify First Name Field accepts 254 Latin characters outline
      When I enter first name containing <num> Latin characters
      And you click on Register me
      And I look at the page for 2 sec
      Then Registration page is confirmed
      Examples:
        | num |
        | 253 |
        | 2 |
        | 1 |
        | 254|
        | 0 |





