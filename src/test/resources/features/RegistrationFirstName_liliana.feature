@FirstName

Feature: Registration First name scenarios

  @FirstName1
  Scenario: First name - Alphanumeric & Special characters
    Given I navigate to "registration" page
#    Given I go to "registration" page

    And I waiting for 2 sec
    When I type "Ben@" into first name field
    And I type "ROL" into last name field
    And I wait for 1 sec
    And I type "test@gmail.com" in email field
    And I wait for 1 sec
    And  I type "abc" into group field
    And I type "12345" into password field
    And I type "12345" into confirm password field
    When I click button "Register Me" button
    And I waiting for 2 sec
    Then confirmation message "You have been Registered." should be displayed

  @FirstName2
  Scenario: First name - Empty input
#    Given I go to "registration" page
    Given I navigate to "registration" page
    And I waiting for 2 sec
    When I type "" into first name field
    And I type "ROL" into last name field
    And I type "test@gmail.com" in email field
    And  I type "abc" into group field
    And I type "12345" into password field
    And I type "12345" into confirm password field
    When I click button "Register Me" button
    And I waiting for 2 sec
    Then error message "This field is required" should be displayed

@FirstName3
  Scenario: First name - Max+1
  Given I go to "registration" page
  And I wait for 2 sec
    When I type "255vbnmASDFGHsdfghjkldfghjklioioioiouiilikliolil/Jfghqwertyuiosdfghjkasdfgh34567812345123451234512345123452345123456890=-@@@@@@@@%^&*sdfghjdsfghjksdfghjkdfghjkxcvbnm,.kjhgfdsaertyuiop[25lllllllllliiiiiiii1111111111ccccssssyyytttttiiiiiiiiiiiiiijjjjjjjjjji" into first name field
  And I type "ROL" into last name field
    And I type "test@gmail.com" in email field
    And  I type "abc" into group field
    And I type "12345" into password field
    And I type "12345" into confirm password field
    When I click button "Register Me" button
    And I wait for 2 sec
    Then message "Data too long for column 'name' at row 1" should be displayed

  @FirstName4
  Scenario: First name - Min 1 character
#    Given I go to "registration" page
    Given I navigate to "registration" page
    And I waiting for 2 sec
    When I type "A" into first name field
    And I type "ROL" into last name field
    And I type "test@gmail.com" in email field
    And  I type "abc" into group field
    And I type "12345" into password field
    And I type "12345" into confirm password field
    When I click button "Register Me" button
    And I waiting for 2 sec
    Then confirmation message "You have been Registered." should be displayed

  @FirstName5
  Scenario: First name - Min 1 character
#    Given I go to "registration" page
    Given I navigate to "registration" page
    And I waiting for 2 sec
    When I type "A" into first name field
    And I type "ROL" into last name field
    And I type "test@gmail.com" in email field
    And  I type "abc" into group field
    And I type "12345" into password field
    And I type "12345" into confirm password field
    When I click button "Register Me" button
    And I waiting for 2 sec
    Then confirmation message "You have been Registered." should be displayed

  @FirstName6
  Scenario: First name - White spaces are not allowed

    Given I navigate to "registration" page
    And I waiting for 2 sec
    When I type "space " into first name field
    And I type "ROL" into last name field
    And I type "test@gmail.com" in email field
    And  I type "abc" into group field
    And I type "12345" into password field
    And I type "12345" into confirm password field
    When I click button "Register Me" button
    And I waiting for 2 sec
    Then error message "Whitespaces are not allowed" should be displayed

  @FirstName7
  Scenario: First name - Max 254 characters (When the Last name 1 char)
#    Given I go to "registration" page
    Given I navigate to "registration" page
    And I waiting for 2 sec
    When I type "254bnmASDFGHsdfghjkldfghjklioioioiouiilikliolil/Jfghqwertyuiosdfghjkasdfgh34567812345123451234512345123452345123456890=-@@@@@@@@%^&*sdfghjdsfghjksdfghjkdfghjkxcvbnm,.kjhgfdsaertyuiop[25lllllllllliiiiiiii1111111111ccccssssyyytttttiiiiiiiiiiiiiijjjjjjjjjji" into first name field
    And I type "R" into last name field
    And I type "test@gmail.com" in email field
    And  I type "abc" into group field
    And I type "12345" into password field
    And I type "12345" into confirm password field
    When I click button "Register Me" button
    And I waiting for 2 sec
    Then confirmation message "You have been Registered." should be displayed







