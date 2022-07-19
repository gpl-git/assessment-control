@userName
Feature:Registration First Name Scenarios

  Background:
    Given I go to "registration" page

  @userName1
    Scenario: FirstName Field Behavior: Alphanumeric & Special Characters
    And I wait for 2 sec
    When I type "ab!!*123@$" into first name field
    When I type "Bozoklar" into last name field
    When I type "breenguyen@golviage.com" into email field
    When I type "123" into group code field
    And I enter "12346" as password
    And I enter "12346" as confirm password
    When I click button "Register Me"
    Then registration confirmation page "You have been registered" should be displayed
    And I wait for 2 sec

@userName2
  Scenario: Verify Firstname Field Behavior: Empty Field Not Allowed
  When I clear the firstname field
  When I type "Bozoklar" into last name field
  When I type "breenguyen@golviage.com" into email field
  When I type "123" into group code field
  And I enter "12346" as password
  And I enter "12346" as confirm password
  When I click button "Register Me"
  Then alert message should be displayed
  Then alert message should contain text "This field is required"
  And I wait for 1 sec


  @userName3
  Scenario: Verify FirstName Field Behavior: Max 254 Characters Allowed
    When I type "Ajfjkfjlfjlkjvskdljvlkjkljvlkjdlkjiu9847847t9847t98478euidjhgkjdlkjkfjbkjri8t7897t8eruog8urkigjirejg3656xduedbcbbcbybcrbcybrycbrubcurbccbbrucrhbrbcbbbrcbhcbrbcrhbrbhbcybcbhbrhcbubrhycbryhbcrbcybcurbcrburcbbrcbrucbrcburbcurbcbryhrbcbrcbryrbrburbcbrubrubrb" into first name field
    When I type "B" into last name field
    When I type "breenguyen@golviage.com" into email field
    When I type "123" into group code field
    And I enter "12346" as password
    And I enter "12346" as confirm password
    When I click button "Register Me"
    Then registration confirmation page "You have been registered" should be displayed
    And I wait for 1 sec


  @userName4
  Scenario: Verify FirstName Field Behavior: 255 Characters Not Allowed
    When I type "Ajfajkfjlfjlkjvskdljvlkjkljvlkjdlkjiu9847847t9847t98478euidjhgkjdlkjkfjbkjri8t7897t8eruog8urkigjirejg3656xduedbcbbcbybcrbcybrycbrubcurbccbbrucrhbrbcbbbrcbhcbrbcrhbrbhbcybcbhbrhcbubrhycbryhbcrbcybcurbcrburcbbrcbrucbrcburbcurbcbryhrbcbrcbryrbrburbcbrubrubrb" into first name field
    When I type "B" into last name field
    When I type "breenguyen@golviage.com" into email field
    When I type "123" into group code field
    And I enter "12346" as password
    And I enter "12346" as confirm password
    When I click button "Register Me"
    Then alert message should be displayed
    # This is a known issue Bug JUN22-119
    Then alert message should contain text "Please enter max 254 characters"
    And I wait for 1 sec


  @userName5
  Scenario: Verify FirstName Field Behavior: Min 1 Character Allowed
    When I type "Q" into first name field
    When I type "Bozoklar" into last name field
    When I type "breenguyen@golviage.com" into email field
    When I type "123" into group code field
    And I enter "12346" as password
    And I enter "12346" as confirm password
    When I click button "Register Me"
    Then registration confirmation page "You have been registered" should be displayed
    And I wait for 1 sec



  Scenario Outline: Scenario: Verify FirstName Field Behavior:Error messages
    When I type <firstName> into first name field
    When I type "Bozoklar" into last name field
    When I type "breenguyen@golviage.com" into email field
    When I type "123" into group code field
    And I enter "12346" as password
    And I enter "12346" as confirm password
    When I click button "Register Me"
    Then alert message should be displayed
    Then alert message should contain text <alert>
    And I wait for 1 sec
    Examples:
      | firstName |  alert                         |
      | "Ay lin"  |  "Whitespaces are not allowed" |
      | "  Aylin"  |  "Whitespaces are not allowed" |
      | "Aylin  "  |  "Whitespaces are not allowed" |
      | ""          |  "This field is required" |