@Registration @regression @firstName
Feature: Registration - first name

  Background:
    Given I go to "registration" page

  @RegistrationFirstName
  Scenario: First Name field accepts Alpha Numeric characters
    When I type "Имя" into the First Name field
    And I click "Register Me" button
    Then first name error message should be displayed
    And error message should contain text "Should contain only latin characters"
    When I clear the First Name field
    When I type " " into the First Name field
    And I click "Register Me" button
    Then first name error message should be displayed
    And error message should contain text "Should contain only latin characters"
    When I clear the First Name field
    When I type "Fn" into the First Name field
    And I click "Register Me" button
    Then first name error message should not be displayed
    And I wait for 2 sec

  @RegistrationFirstName
  Scenario: First Name field is required
    When I clear the First Name field
    Then first name error message should be displayed
    And error message should contain text "This field is required"

  @RegistrationFirstName
  Scenario: First Name field accepts 254 characters
    When I type "ggfplngkyenilssdioohseigdovgxelqqnsblaiadcsyrdakqfjmemsehzekdirzhfaaivlbojggwxwxtwglmxaaxxjsizodoaaaxaykubulgbxizooqejdciheyhlrxhwastkopanxzfidgkvnletgpjhsbctsfohxqlkizffhizkmpjsujovszopsggqgntpzehlftblidtezwoeedxprwurowtspjawybvqduzvpjvmmknatrjtxdftabxx" into the First Name field
    And I click "Register Me" button
    Then first name error message should not be displayed

  @RegistrationFirstName
  Scenario: First Name field does not accept 254+1 characters
    When I type "ggfplngkyenilssdioohseigdovgxelqqnsblaiadcsyrdakqfjmemsehzekdirzhfaaivlbojggwxwxtwglmxaaxxjsizodoaaaxaykubulgbxizooqejdciheyhlrxhwastkopanxzfidgkvnletgpjhsbctsfohxqlkizffhizkmpjsujovszopsggqgntpzehlftblidtezwoeedxprwurowtspjawybvqduzvpjvmmknatrjtxdftabxxz" into the First Name field
    And I click "Register Me" button
    Then first name error message should be displayed
    And error message should contain text "Should not exceed 254 characters"
