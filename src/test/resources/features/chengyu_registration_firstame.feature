@registration_firstname @smoke
Feature: Verify Registration FirstName Field Behavior

  Background:
    Given I open "registration" page
    When I type "x" into last name field
    And I type "1@gmail.com" into email field
    And I type "q" into group code field
    And I type "12345" into password field
    And I type "12345" into confirm password field
    When I click the "register me" button
    And I wait for 1 sec

  @registration_firstname1
  Scenario: Verify Allowable characters: Alphanumeric & Special characters
    When I type "Qwerty12345!@#$%.,/" into first name field
    Then I click the "register me" button
    And I wait for 1 sec
    And I see message "You have been Registered." is displayed



  @registration_firstname2
  Scenario: Verify First Name field  be empty
    When I type "" into first name field
    Then I click the "register me" button
    And I wait for 1 sec
    And error message "This field is required" is displayed


  @registration_firstname3
  Scenario: Verify Max 254 characters in First Name field (When the Last name 1 char)
    When I type "Name:uhklhkjfjkfjkfjkjdqwekjflsllsnbcfslzldjfru12049857udmnchhklhkjfjkfjkfjkjdqwekjflsllsnbcfslzldjfru12049857udmnchhklhkjfjkfjkfjkjdqwekjflsllsnbcfslzldjfru12049857udmnchhklhkjfjkfjkfjkjdqwekjflsllsnbcfslzldjfru1fgsr4564w3gfrfevds2213r&^*&*^&)(lkncninla" into first name field
    Then I click the "register me" button
    And I wait for 1 sec
    And I see message "You have been Registered." is displayed


  @registration_firstname4
  Scenario: Verify 255 Characters in First Name field
    When I type "Name:2uhklhkjfjkfjkfjkjdqwekjflsllsnbcfslzldjfru12049857udmnchhklhkjfjkfjkfjkjdqwekjflsllsnbcfslzldjfru12049857udmnchhklhkjfjkfjkfjkjdqwekjflsllsnbcfslzldjfru12049857udmnchhklhkjfjkfjkfjkjdqwekjflsllsnbcfslzldjfru1fgsr4564w3gfrfevds2213r&^*&*^&)(lkncninla" into first name field
    Then I click the "register me" button
    And I wait for 1 sec
    And a error message "Data too long for column 'name' at row 1" should be present


  @registration_firstname5
  Scenario: Verify Min 1 Characters in First Name field
    When I type "a" into first name field
    Then I click the "register me" button
    And I wait for 1 sec
    And I see message "You have been Registered." is displayed

  @registration_firstname6
  Scenario: Verify  White spaces in First Name field
    When I type "Q iuhv6523" into first name field
    Then I click the "register me" button
    And I wait for 1 sec
    And another error message "Whitespaces are not allowed" is displayed


    
