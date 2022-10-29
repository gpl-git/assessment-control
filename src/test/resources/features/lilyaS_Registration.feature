@quizHW
Feature: Quiz Scenarios Registration Email



  @quizHW1
  Scenario: Register with valid credentials
    Given I open "login" page as a teacher
    When I click on "Register Now" button ls
    And I wait for 2 sec
    When I type "Li" as a first name
    And I type "Sag" as a last name
    And I type "redheadedok1e@mizii.eu" as email
    And I type "Sep" as a group code
    And I type "123456" as a password
    And I type "123456" as a password confirmation
    When I click on "Register Me" button ls
    And I wait for 2 sec
    Then "You have been Registered." message should be displayed ls
    And I wait for 2 sec

  @quizHW2
    Scenario: Register with empty email
    Given I open "login" page as a teacher
    When I click on "Register Now" button ls
    And I wait for 2 sec
    When I type "Li" as a first name
    And I type "Sag" as a last name
    And I type "Sep" as a group code
    And I type "123456" as a password
    And I type "123456" as a password confirmation
    And I wait for 2 sec
    When I click on "Register Me" button ls
    Then "This field is required" error should be displayed
    And I wait for 2 sec

  @quizHW3
  Scenario: Register with email more than 128 characteristics
    Given I open "login" page as a teacher
    When I click on "Register Now" button ls
    And I wait for 2 sec
    When I type "Li" as a first name
    And I type "Sag" as a last name
    And I type "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa@mizii.eu" as email
    And I type "Sep" as a group code
    And I type "123456" as a password
    And I type "123456" as a password confirmation
    And I wait for 2 sec
    When I click on "Register Me" button ls
    Then "Should be a valid email address" error should be displayed
    And I wait for 2 sec

  @quizHW4
  Scenario: Register with an empty spaces in email filed
    Given I open "login" page as a teacher
    When I click on "Register Now" button ls
    And I wait for 2 sec
    When I type "Li" as a first name
    And I type "Sag" as a last name
    And I type "aaa aaa@mizii.eu" as email
    And I type "Sep" as a group code
    And I type "123456" as a password
    And I type "123456" as a password confirmation
    And I wait for 2 sec
    When I click on "Register Me" button ls
    Then "Should be a valid email address" error should be displayed
    And I wait for 2 sec

  @quizHW5
  Scenario: Register without top level domain
    Given I open "login" page as a teacher
    When I click on "Register Now" button ls
    And I wait for 2 sec
    When I type "Li" as a first name
    And I type "Sag" as a last name
    And I type "aaaaa@gmail" as email
    And I type "Sep" as a group code
    And I type "654321" as a password
    And I type "654321" as a password confirmation
    And I wait for 2 sec
    When I click on "Register Me" button ls
    Then "Should be a valid email address" error should be displayed
    # Bug SEP22-281
    And I wait for 2 sec

   @quizHW6
   Scenario: Register with email without @ sign
     Given I open "login" page as a teacher
     When I click on "Register Now" button ls
     And I wait for 2 sec
     When I type "Rosa" as a first name
     And I type "Ros" as a last name
     And I type "aaaagmail" as email
     And I type "Dec" as a group code
     And I type "654321" as a password
     And I type "654321" as a password confirmation
     And I wait for 2 sec
     When I click on "Register Me" button ls
     Then "Should be a valid email address" error should be displayed
     And I wait for 2 sec














