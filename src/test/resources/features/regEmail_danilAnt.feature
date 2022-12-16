@registration_Email_NOV-787
  Feature: Registration Email
    Background:
      Given I navigate to the "registration" page Assessment Control
      Then I observe the registration page within 2 sec.
      Then I fill out the registration form: FN as "Danil", LN as "Ant", Group Code as "ABC1", Password "qwerty", Confirm Password "qwerty"
      Then I observe the registration page within 2 sec.

    @NOV-255
    Scenario: Email field required - verification
      When I click on Register Button
      And I observe the registration page within 2 sec.
      Then I should see the message "This field is required" for the Email field

    @NOV-254&NOV-803&NOV-808
    Scenario: Allowable characters: Alphanumeric and Special characters: '@', '_', '.'” - verification & top-level domain is required
      When I fill the Email Field as "danil123_ant.dan@racoon.com"
      And I click on Register Button
      And I observe the registration page within 2 sec.
      Then I have been successfully registered
      Then I go to the previous Registration Page
      And I fill out the registration form: FN as "Danil", LN as "Ant", Group Code as "ABC1", Password "qwerty", Confirm Password "qwerty"
      When I fill the Email Field as "linad-'~]'-@mail.com" using other special characters
      And I click on Register Button
      Then I should see the message "Should be a valid email address" for the Email field

    Scenario Outline: Allowable characters: Alphanumeric and Special characters: '@', '_', '.'
    and top-level domain is required - verification Outline
      When I fill the Email Field as <email> using other special characters
      And I click on Register Button
      Then I should see the message <req> for the Email field
      Examples:
        | email                             | req                               |
        | "linad-'~]'-@mail.com"            | "Should be a valid email address" |
        | "linad-;;;;;;::::'~]'-@mail.com"  | "Should be a valid email address" |
        | "linad-====,,$$$~]'-@mail.com"    | "Should be a valid email address" |
        | "licnad@mail."                    | "Should be a valid email address" |
        | "licnad@mail"                     | "Should be a valid email address" |

    @NOV-276&NOV-277&NOV-288
    Scenario: White spaces are not allowed
      When I fill the Email Field as " danil@racoon.com"
      And I click on Register Button
      Then I should see the message "Should be a valid email address" for the Email field

    Scenario Outline: White spaces are not allowed Outline
      When I fill the Email Field as <email>
      And I click on Register Button
      Then I should see the message <req> for the Email field
      Examples:
        | email                 | req                               |
        | " danil@racoon.com"   | "Should be a valid email address" |
        | "danil@racoon.com "   | "Should be a valid email address" |
        | "da nil@racoon.com "  | "Should be a valid email address" |

    @NOV-179
    Scenario: Email field case insensitive - verification
      When I fill the Email Field as "danil123_ant.dan@racoon.com"
      And I click on Register Button
      And I observe the registration page within 2 sec.
      Then I have been successfully registered

    Scenario Outline: Email field case insensitive - verification
      When I fill the Email Field as <email>
      And I click on Register Button
      And I observe the registration page within 2 sec.
      Then I have been successfully registered
      Examples:
        | email                         |
        | "Danil123_ant.dan@racoon.com" |
        | "DANIL123_ant.dan@racoon.com" |
        | "Danil123_ant.dan@RACOON.com" |
        | "Danil123_ant.dan@racoon.cOm" |
        | "Danil123_ant.dan@racoon.COM" |

    @NOV-257&NOV-258&NOV-260-269
    Scenario: Max 128 characters:
#    with a local port with 64 characters on the left of an @ domain
#    on the right with 63 characters followed by (.)
#    with 63 characters in the last part of the domain - verification
      When I fill the Email Field as "danil123_ant.dan@racoon.com"
      And I click on Register Button
      And I observe the registration page within 2 sec.
      Then I have been successfully registered

    Scenario Outline: Max 128 characters:
      When I fill the Email Field as <email>
      And I click on Register Button
      And I observe the registration page within 2 sec.
      Then I have been successfully registered
      Examples:
        | email                         |
        #128 char!
        | "sgvffsgvhgshfgcdsjhfggadshfgakshjfgajhfgiugiuwgesifghskjfjhg@ghuehgiuewhiguvhgughhuhuhuehfguhughuighiuewh.iejguhghghiuwehghwgcom"  |
        #127 char!
        | "sgvffsgvhgshfgcdsjhfggadshfgakshjfgajhfgiugiuwgesifghskjfjhg@ghuehgiuewhiguvhgughhuhuhuehfguhughuighiuewh.iejguhghghiuwehghwgcm"   |
        #129 char!
        | "sgvffsgvhgshfgcdsjhfggadshfgakshjfgajhfgiugiuwgesifghskjfjhg@ghuehgiuewhiguvhgughhuhuhuehfguhughuighiuewh.iejguhghghiuwehghwgcomm" |
        #64 char left@
        | "dennamitquestdimerowelitecpseyrek9594questdimerowe95943455676789@unair.nl" |
        #63 char left@
        | "dennamitquestdimerowelitecpseyrek9594questdimerowe9594345567679@wer.com" |
        #65 char left@!
        | "dennamitquestdidcmerowelitecpseyrek9594questdimerowe9594345567679@wer.com" |
        #@62 before.
        | "den@comuniondennamitquestdimerowelitecpseyrekquestdimerowenwwrhdbg.com" |
        #@63 before.
        | "den@comuniondennamitquestdimerowelitecpseyrekquestdimerowenwwrhdbgd.com" |
        #@64 before.!
        | "den@comuniondennamitquestdimerowelitecpseyrekquestdimerowenwwrhdbgdf.com" |
        #@62 after.
        | "li@co.comuniondennamitquestdimerowelitecpseyrekquestdimerowenwwrhdbg" |
        #@63 after.
        | "li@co.comuniondennamitquestdimerowelitecpseyrekquestdimerowenwwrhdbgd" |
        #@64 after.!
        | "li@co.comuniondennamitquestdimerowelitecpseyrekquestdimerowenwwrhdbgdf" |










