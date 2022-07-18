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
  Scenario: Verify Firstname Field Behavior: Empty Field
  When I clear the firstname field
  When I type "Bozoklar" into last name field
  When I type "breenguyen@golviage.com" into email field
  When I type "123" into group code field
  And I enter "12346" as password
  And I enter "12346" as confirm password
  When I click button "Register Me"
  Then element with xpath "//label[@id='username-error']" should be displayed
  Then element with xpath "//label[@id='username-error']" should contain text "This field is required"
  And I wait for 1 sec


  @userName2
  Scenario: Verify FirstName Field Behavior: Max Characters
    When I type "Ajfjkfjlfjlkjvskdljvlkjkljvlkjdlkjiu9847847t9847t98478euidjhgkjdlkjkfjbkjri8t7897t8eruog8urkigjirejg3656+6-048774uyfhjhjyejyfgmjhkjghkhgkjdhgjgkjriuiurytyuwteutyroiutoiejglijrkjghrgruhgiurjogirogkokrgkrjhgkdj;k==$%^())___*mkfjjhkgjhfkkdvjndvjfjvjjjjnj)" into first name field
    When I type "B" into last name field
    When I type "breenguyen@golviage.com" into email field
    When I type "123" into group code field
    And I enter "12346" as password
    And I enter "12346" as confirm password
    When I click button "Register Me"
    Then element with xpath "//label[@id='firstname-error']" should be displayed
    Then element with xpath "//label[@id='firstname-error']" should contain text "Please enter max 20 characters"
    And I wait for 1 sec

  @userName3
  Scenario: Verify FirstName Field Behavior: Min Characters
    When I type "Q" into first name field
    When I type "Bozoklar" into last name field
    When I type "breenguyen@golviage.com" into email field
    When I type "123" into group code field
    And I enter "12346" as password
    And I enter "12346" as confirm password
    When I click button "Register Me"
    Then element with xpath "//label[@id='firstname-error']" should be displayed
    Then element with xpath "//label[@id='firstname-error']" should contain text "Please enter at least 1 character"
    And I wait for 1 sec

  @userName4
  Scenario: Verify Firstname Field Behavior: Trailing Characters
    When I type "Aylin" into first name field
    When I leave a space into first name field
    When I type "Bozoklar" into last name field
    When I type "breenguyen@golviage.com" into email field
    When I type "123" into group code field
    And I enter "12346" as password
    And I enter "12346" as confirm password
    When I click button "Register Me"
    Then element with xpath "//label[@id='username-error']" should be displayed
    Then element with xpath "//label[@id='username-error']" should contain text "Trailing characters are not allowed"
    And I wait for 1 sec


  @userName5
  Scenario: Verify Firstname Field Behavior: Leading Characters
    When I leave a space into first name field
    When I type "Aylin" into first name field
    When I type "Bozoklar" into last name field
    When I type "breenguyen@golviage.com" into email field
    When I type "123" into group code field
    And I enter "12346" as password
    And I enter "12346" as confirm password
    When I click button "Register Me"
    Then element with xpath "//label[@id='username-error']" should be displayed
    Then element with xpath "//label[@id='username-error']" should contain text "Leading characters are not allowed"
    And I wait for 1 sec

  @userName6
  Scenario: Verify FirstName Field Behavior: Letterlike/Emoji Characters
    When I type ":)" into first name field
    When I type "Bozoklar" into last name field
    When I type "breenguyen@golviage.com" into email field
    When I type "123" into group code field
    And I enter "12346" as password
    And I enter "12346" as confirm password
    When I click button "Register Me"
    Then element with xpath "//label[@id='firstname-error']" should be displayed
    Then element with xpath "//label[@id='firstname-error']" should contain text "Please enter valid characters"
    And I wait for 1 sec