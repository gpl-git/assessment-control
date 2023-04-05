@FirstName

  Feature: Registration First Name

#    Background:
#      Given I navigate  to "registration" page
#      And I type "ABC" into last Name field
#      And I type "123@gmail.com"into email field
#      And I type "AAA" into group code field
#      And I type"12345" into password field
#      And I type"12345"into Confirm password field



    @Fname
    Scenario: Verify Registration First Name field
      Given I navigate  to "registration" page
      When I type "Ashu" into the fname field
      And I type "ABC" into last Name field
      And I type "123@gmail.com"into email field
      And I type "AAA" into group code field
      And I type"12345" into password field
      And I type"12345"into Confirm password field
#      When I type "Ashu" into the fname field
      When I click "register me"button
      Then "You have been Registered." Confirmation message should be display
      And I wait for 3 sec

    @firstName
    Scenario Outline: Verify Registration First Name field -outline
      When I type <fname> into the fname field
      When I click <registerMe>button
      Examples:
        | fname  | registerMe    |
        | "A!" | "register me" |
        | "A!@@" | "register me" |
        | "12345" | "register me" |
        | "!asd_#" | "register me" |
        | "@#$%^" | "register me" |

      @fnameError
      Scenario: Verify "Fields is required" error message
        And I click "register me"button
        Then "This field is required" error message should be displayed
        And I wait for 3 sec

      @fnameWhitespacesErrorMessage
      Scenario: Verify "White Spaces are not allowed " error message
        When I type "    Ashu    " into fname field
        And I click "register me"button
        Then "Whitespaces are not allowed" error message shouls be dispalyed
        And I wait for 3 sec

       @fNameMaxiumChar
       Scenario: Verify Maximum Character are accepted
         When I type 254 alphanumaric charater into fname field
         And I wait for 3 sec
         And I click "register me"button

         @fnameMoreThanMaximumChar
         Scenario: Verify 255 characters are not allowed
           When I type 255 character into fname field
           Then Error message one"No more than 254 character"should be displayed
           # It's a known bug .Application accepts 254 character and doesn'tthrow an error message"More than 254 character is not allowed"





