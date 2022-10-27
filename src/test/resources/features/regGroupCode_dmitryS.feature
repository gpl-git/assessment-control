@regGroupCode
  Feature: Registration Group Code Scenario

    Background:
      Given  I need open "ask-qa" page
      Then I need click on "Register Now" button
      Then I need type "DmitryS" into First Name field
      And I also type "Student" into Last Name field
      Then I input "youngned@gmailni.com" into Email field
      And I need input "qwerty" into Password field
      And I also need input "qwerty" into Confirm Password field

    @regGroupCode1
    Scenario: Group code field allows alphanumeric characters
      Given  I will type "abc123" into Group Code input field
      And I push on "Register Me" button DS
      Then success message "You have been Registered." should be displayed DS


    @regGroupCode2
    Scenario: Group code field allows special characters
      Given  I will type "#$%" into Group Code input field
      And I push on "Register Me" button DS
      Then success message "You have been Registered." should be displayed DS

    @regGroupCode3
    Scenario: Group code field allows alphanumeric and special characters
      Given  I will type "abc#$%" into Group Code input field
      And I push on "Register Me" button DS
      Then success message "You have been Registered." should be displayed DS

    @regGroupCode4
    Scenario: Group code allows min 1 alpha character
      Given  I will type 1 alpha character into Group Code input field
      And I push on "Register Me" button DS
      Then success message "You have been Registered." should be displayed DS

    @regGroupCode5
    Scenario: Group code allows min 1 numeric character
      Given  I will type 1 numeric character into Group Code input field
      And I push on "Register Me" button DS
      Then success message "You have been Registered." should be displayed DS

    @regGroupCode6
    Scenario: Group code allows min 1 special character
      Given  I will type "%" into Group Code input field
      And I push on "Register Me" button DS
      Then success message "You have been Registered." should be displayed DS

    @regGroupCode7
    Scenario: Group code allows max 10 alpha characters
      Given  I will type 10 alpha character into Group Code input field
      And I push on "Register Me" button DS
      Then success message "You have been Registered." should be displayed DS

    @regGroupCode8
    Scenario: Group code allows max 10 numeric characters
      Given  I will type 10 numeric character into Group Code input field
      And I push on "Register Me" button DS
      Then success message "You have been Registered." should be displayed DS

    @regGroupCode9
    Scenario: Group code allows max 10 special characters
      Given  I will type "%$#@&^%$#@" into Group Code input field
      And I push on "Register Me" button DS
      Then success message "You have been Registered." should be displayed DS

    @regGroupCode10
    Scenario: Validate that group code field required, can’t be empty
      Given  I will type "" into Group Code input field
      And I push on "Register Me" button DS
      And I wait for 1 sec DS
      And error message "This field is required" should be displayed DS

    @regGroupCode11
    Scenario: Verify if group code field allows 11 alphanumeric characters
      Given  I will type 11 alphanumeric character into Group Code input field DS
      And I push on "Register Me" button DS
      And I wait for 0 sec DS
      And error message "Should no more than 10 characters" should be displayed DS

    @regGroupCode12
    Scenario: Verify if group code field allows 11 special characters
      Given  I will type "%$#@&^%$#@#" into Group Code input field
      And I push on "Register Me" button DS
      And I wait for 0 sec DS
      And error message "Should no more than 10 characters" should be displayed DS

    @regGroupCode13
    Scenario: Verify if group code field allows 10 white spaces
      Given  I will type "          " into Group Code input field
      And I push on "Register Me" button DS
      And I wait for 0 sec DS
      And error message "White spaces are not allowed" should be displayed DS
      # Bug report  https://jira.portnov.com/browse/SEP22-373
      And I wait for 2 sec DS











#    @regGroupCode5
#    Scenario: Group code allows min 1 numeric character
#      Given  I will type "5" into "Group Code" input field
#      And I push on "Register Me" button
#      And element with xpath "//h4[contains(text(),'You have been Registered.')]" is displayed
#
#    @regGroupCode6
#    Scenario: Group code allows min 1 special character
#      Given  I will type "%" into "Group Code" input field
#      And I push on "Register Me" button
#      And element with xpath "//h4[contains(text(),'You have been Registered.')]" is displayed
#
#    @regGroupCode7
#    Scenario: Group code allows max 10 alpha characters
#      Given  I will type "a" into "Group Code" input field
#      And I push on "Register Me" button
#      And element with xpath "//h4[contains(text(),'You have been Registered.')]" is displayed