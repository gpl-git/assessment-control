@Registration @regression @firstName
Feature: Registration - first name

  Background:
    Given I go to "registration" page
    When I type "X" into Last Name field
    And I type "derickson83@gumaygo.com" into email field
    And I type "123" into Group Code field
    And I type "12345" into password field
    And I type "12345" into confirm password field


  @RegistrationFirstName
  Scenario: Registration - First Name Happy Pass
    When I type "Fn" into the First Name field
    And I click "Register Me" button
    And I switch to a new window
    And I wait for 2 sec
    Then confirmation message "You have been Registered" should be displayed


  @RegistrationFirstName
  Scenario Outline: First Name field accepts ONLY Alpha Numeric and Special characters
    When I type <firstName> into the First Name field
    And I click "Register Me" button
    And I wait for 1 sec
    And an alert message "Incorrect string value: '\xD0\x98\xD0\xBC\xD1\x8F...' for column 'name' at row 1 " should be displayed

    Examples:
      | firstName |
      | "名前"     |
      | "Имя"     |
      | "ਨਾਮ"      |
      | "नाम"     |

  @RegistrationFirstName
  Scenario Outline: First Name field accepts Alpha Numeric and Special characters
    When I type <firstName> into the First Name field
    And I click "Register Me" button
    And I switch to a new window
    And I wait for 2 sec
    Then confirmation message "You have been Registered" should be displayed
    Examples:
      | firstName   |
      | "ABC"       |
      | "abc"       |
      | "123"       |
      | "!*^"       |

  @RegistrationFirstName
  Scenario: White spaces are not allowed in First Name field
    When I type " " into the First Name field
    And I click "Register Me" button
    Then first name error message should be displayed
    And error message should contain text "Whitespaces are not allowed"

  @RegistrationFirstName
  Scenario: First Name field is required
    When I clear the First Name field
    And I click "Register Me" button
    Then first name error message should be displayed
    And error message should contain text "This field is required"
    And I wait for 3 sec

  @RegistrationFirstName
  Scenario: First Name field accepts 254 characters
    When I type "ggfplngkyenilssdioohseigdovgxelqqnsblaiadcsyrdakqfjmemsehzekdirzhfaaivlbojggwxwxtwglmxaaxxjsizodoaaaxaykubulgbxizooqejdciheyhlrxhwastkopanxzfidgkvnletgpjhsbctsfohxqlkizffhizkmpjsujovszopsggqgntpzehlftblidtezwoeedxprwurowtspjawybvqduzvpjvmmknatrjtxdftabxx" into the First Name field
    And I click "Register Me" button
    And I switch to a new window
    And I wait for 2 sec
    Then confirmation message "You have been Registered" should be displayed


  @RegistrationFirstName
  Scenario: First Name field does not accept 254+1 characters
    When I type "ggfplngkyenilssdioohseigdovgxelqqnsblaiadcsyrdakqfjmemsehzekdirzhfaaivlbojggwxwxtwglmxaaxxjsizodoaaaxaykubulgbxizooqejdciheyhlrxhwastkopanxzfidgkvnletgpjhsbctsfohxqlkizffhizkmpjsujovszopsggqgntpzehlftblidtezwoeedxprwurowtspjawybvqduzvpjvmmknatrjtxdftabxxz" into the First Name field
    And I click "Register Me" button
    And I wait for 1 sec
    And an alert message "Data too long for column 'name' at row 1 " should be displayed
    And I wait for 2 sec

