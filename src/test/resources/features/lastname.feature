@lastname
Feature: Registration

  @smoke
  Scenario: Last Name - Alphanumeric & Special characters
    Given I open "registration" page
    When I type "Anna" in first name field
    When I type "Abfh123((;}[%$%" in last name field
    When I type "rr@aol.com" into email field
    When I type "ABC" in group code field
    When I type "12345" into password field
    When I type "12345" into confirm password field
    When click on "Register Me" button
    And I wait for 1 sec
    Then I verify that current url contains "registration-confirmation"
    Then I verify that I revive a "You have been Registered." message
    And I wait for 2 sec

  @smoke1
  Scenario: Last Name - Required
    Given I open "registration" page
    When I type "Anna" in first name field
    When I type "Abfh123((;}[%$%" in last name field
#    When I type "rr@aol.com" into email field
    When I type "ABC" in group code field
    When I type "12345" into password field
    When I type "12345" into confirm password field
    When click on "Register Me" button
    And I wait for 1 sec
    Then I verify that I revive a "This field is required" message
    And I wait for 2 sec

  @smoke2
  Scenario: Last Name - 254 Charecters
    Given I open "registration" page
    When I type "Ato" in first name field
    When I type "poepoirpoi3ioip4ir3poi4ptoifdkspogiepoigrpoiposergiposiepigproeiposipogjsjgpoepogjpreosjgporpogjrpojpogrkpopgorkprokrporpoiepipipgjoih4oiegoiu94ujgio4o4u89u98u948y49ihgighoeoipw49pwjjogu0e9uug4u4uu4ughg489uiwpowp9u0933ih98t83u89th47tofhff777yugf" in last name field
    And I wait for 2 sec
    When I type "rtiiikk@aol.com" into email field
    When I type "ABC" in group code field
    When I type "123467" into password field
    When I type "123467" into confirm password field
    When click on "Register Me" button
    And I wait for 1 sec
    Then I verify that current url contains "registration-confirmation"
    And I wait for 2 sec
    Then I verify that I revive a "You have been Registered." message
    And I wait for 2 sec

#  | last |
#  |  "poepoirpoi3ioip4ir3poi4ptoifdkspogiepoigrpoiposergiposiepigproeiposipogjsjgpoepogjpreosjgporpogjrpojpogrkpopgorkprokrporpoiepipipgjoih4oiegoiu94ujgio4o4u89u98u948y49ihgighoeoipw49pwjjogu0e9uug4u4uu4ughg489uiwpowp9u0933ih98t83u89th47tofhff777yugf"|
#  | "poepoirpoi3ioip4ir3poi4ptoifdkspogiepoigrpoiposergiposiepigproeiposipogjsjgpoepogjpreosjgporpogjrpojpogrkpopgorkprokrporpoiepipipgjoih4oiegoiu94ujgio4o4u89u98u948y49ihgighoeoipw49pwjjogu0e9uug4u4uu4ughg489uiwpowp9u0933ih98t83u89th47tofhff777yug"  |

  @smoke3
  Scenario: Last Name - Happy less than 254 Charecters
    Given I open "registration" page
    When I type "Ato" in first name field
    When I type "poepoirpoi3ioip4ir3poi4ptoifdkspogiepoigrpoiposergiposiepigproeiposipogjsjgpoepogjpreosjgporpogjrpojpogrkpopgorkprokrporpoiepipipgjoih4oiegoiu94ujgio4o4u89u98u948y49ihgighoeoipw49pwjjogu0e9uug4u4uu4ughg489uiwpowp9u0933ih98t83u89th47tofhff777yug" in last name field
    And I wait for 2 sec
    When I type "rtiiikk@aol.com" into email field
    When I type "ABC" in group code field
    When I type "123467" into password field
    When I type "123467" into confirm password field
    When click on "Register Me" button
    And I wait for 1 sec
    Then I verify that current url contains "registration-confirmation"
    And I wait for 2 sec
    Then I verify that I revive a "You have been Registered." message
    And I wait for 2 sec

  @smoke4
  Scenario Outline: Last Name - happy path
    Given I open "registration" page
    When I type "Ato" in first name field
    When I type <lastName> in last name field
    When I type "rtiiikk@aol.com" into email field
    When I type "ABC" in group code field
    When I type "123467" into password field
    When I type "123467" into confirm password field
    When click on "Register Me" button
    And I wait for 1 sec
    Then I verify that current url contains "registration-confirmation"
    And I wait for 2 sec
    Then I verify that I revive a "You have been Registered." message
    And I wait for 2 sec
    Examples:
       | lastName          |
       | "Abfh123((;}[%$%" |
       |   "A"                |
       |    "poepoirpoi3ioip4ir3poi4ptoifdkspogiepoigrpoiposergiposiepigproeiposipogjsjgpoepogjpreosjgporpogjrpojpogrkpopgorkprokrporpoiepipipgjoih4oiegoiu94ujgio4o4u89u98u948y49ihgighoeoipw49pwjjogu0e9uug4u4uu4ughg489uiwpowp9u0933ih98t83u89th47tofhff777yug"             |
       | "poepoirpoi3ioip4ir3poi4ptoifdkspogiepoigrpoiposergiposiepigproeiposipogjsjgpoepogjpreosjgporpogjrpojpogrkpopgorkprokrporpoiepipipgjoih4oiegoiu94ujgio4o4u89u98u948y49ihgighoeoipw49pwjjogu0e9uug4u4uu4ughg489uiwpowp9u0933ih98t83u89th47tofhff777yu" |

   @smoke5
  Scenario: Last Name - White space are not allowed _ At first of line
    Given I open "registration" page
    When I type "Anna" in first name field
    When I type " A" in last name field
    When I type "rrrr@aol.com" into email field
    When I type "ABC" in group code field
    When I type "123456" into password field
    When I type "123456" into confirm password field
    When click on "Register Me" button
    And I wait for 1 sec
    Then I verify that I revive a "This field is required" message
    And I wait for 2 sec
