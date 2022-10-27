@quizHW
Feature: Quiz Scenarios Registration Email



  @quizHW1
  Scenario: Register with valid credentials
    Given I open "login" page as a teacher
    When I click on "Register Now" button
    And I wait for 2 sec
    When I type "Li" as a name
    And I type "Sag" as a last name
    And I type "redheadedok1e@mizii.eu" as email
    And I type "Sep" as a group code
    And I type "123456" as a password
    And I type "123456" as a password confirmation
    And I wait for 2 sec
    When I click on "Register Me" button ls
    Then "registration-confirmation" page should be displayed ls
    And I wait for 2 sec

  @quizHW2
    Scenario: Register with empty email
    Given I open "login" page as the teacher
    When I click at "Register Now" button
    And I wait for 2 sec
    When I type "Ro" as the name
    And I type "QA" as the last name
    And I type "Dec" as the group code
    And I type "1234567" as the password
    And I type "1234567" as the password confirmation
    And I wait for 2 sec
    When I click on "Register Me" button l
    Then "This field is required" error should be displayed
    And I wait for 2 sec

  @quizHW3
  Scenario: Register with email more than 128 characteristics
    Given I open "login" page as a teacher ls
    When I click at "Register Now" button l
    And I wait for 2 sec
    When I type "Rosa" as the name l
    And I type "Ros" as the last name l
    And I type "aaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaaa@mizii.eu" as email l
    And I type "Dec" as the group code l
    And I type "654321" as a password l
    And I type "654321" as the password confirmation l
    And I wait for 2 sec
    When I click on the "Register Me" button
    Then "Should be a valid email address" error should be displayed l
    And I wait for 2 sec

  @quizHW4
  Scenario: Register with an empty spaces in email filed
    Given I open "login" page as a teacher lsl
    When I click at "Register Now" button ls
    And I wait for 2 sec
    When I type "Rosa" as the name ls
    And I type "Ros" as the last name ls
    And I type "aaa aaa@mizii.eu" as email ls
    And I type "Dec" as the group code ls
    And I type "654321" as a password ls
    And I type "654321" as the password confirmation ls
    And I wait for 2 sec
    When I click on the "Register Me" button l
    Then "Should be a valid email address" error should be displayed ls
    And I wait for 2 sec

  @quizHW5
  Scenario: Register without top level domain
    Given I open "login" page as a teacher ll
    When I click at "Register Now" button ll
    And I wait for 2 sec
    When I type "Rosa" as the name ll
    And I type "Ros" as the last name ll
    And I type "aaaaa@gmail" as email ll
    And I type "Dec" as the group code ll
    And I type "654321" as a password ll
    And I type "654321" as the password confirmation ll
    And I wait for 2 sec
    When I click on the "Register Me" button ll
    Then "Should be a valid email address" error should be displayed ll
    # Bug SEP22-281
    And I wait for 2 sec

   @quizHW6
   Scenario: Register with email without @ sign
     Given I open "login" page as a teacher ss
     When I click at "Register Now" button ss
     And I wait for 2 sec
     When I type "Rosa" as the name ss
     And I type "Ros" as the last name ss
     And I type "aaaagmail" as email ss
     And I type "Dec" as the group code ss
     And I type "654321" as a password ss
     And I type "654321" as the password confirmation ss
     And I wait for 2 sec
     When I click on the "Register Me" button ss
     Then "Should be a valid email address" error should be displayed ss
     And I wait for 2 sec












