@smoke
  Feature: Registration - Last Name

    @smoke1
    Scenario: Happy Path
      Given I open "registration" page
      When I type "First" into firstName field
      And I type "Last" into lastName field
      And I type "test@test.com" into email field
      When I type "ABC" into group field
      And I type "12345" into password field
      When I type "12345" into confirmPassword field
      When I click "Register Me" button
      Then confirmation message "You have been Registered." is displayed

    @smoke2
    Scenario: Empty field is not allowed
      Given I open "registration" page
      When I type "First" into firstName field
      And I click "Register Me" button
      Then error message "This field is required" is displayed

    @smoke3
    Scenario: White spaces are not allowed
      Given I open "registration" page
      When I type "First" into firstName field
      And I type " " into lastName field
      And I click "Register Me" button
      Then error message "Whitespaces are not allowed" is displayed

    @smoke4
    Scenario: Last Name field accepts min 1 characters
      Given I open "registration" page
      When I type "First" into firstName field
      And I type "1" into lastName field
      And I type "test@test.com" into email field
      When I type "ABC" into group field
      And I type "12345" into password field
      When I type "12345" into confirmPassword field
      When I click "Register Me" button
      Then confirmation message "You have been Registered." is displayed

      @smoke5
      Scenario: Last Name field accepts max 254 characters (When the First name 1 char)
        Given I open "registration" page
        When I type "1" into firstName field
        And I type "jeghssbjsbd;kjasbdkjsdbvkj;abdkdagdklagldslkjzdblvjbljvblslasdlsblkbzljkvblzjfgb345-83065tsgjvb;kjzdbdzbkzbzbzkfvblfvsldfsdgsdglsdgflgsdgiufsdugsd;idbv;dsgiusrigsepigresgrgrpiusgerpisepigrpegrpiuesgpgihdges;gsiisgerugesriureosgpgusepgsgsiuepsghsepghrpisg" into lastName field
        And I type "test@test.com" into email field
        When I type "ABC" into group field
        And I type "12345" into password field
        When I type "12345" into confirmPassword field
        When I click "Register Me" button
        Then confirmation message "You have been Registered." is displayed


    @smoke7
    Scenario: Last Name field Allowable characters: Alphanumeric and Special characters
      Given I open "registration" page
      When I type "1" into firstName field
      And I type "Aa12#$%?>," into lastName field
      And I type "test@test.com" into email field
      When I type "ABC" into group field
      And I type "12345" into password field
      When I type "12345" into confirmPassword field
      When I click "Register Me" button
      Then confirmation message "You have been Registered." is displayed

    @smoke8
    Scenario: Last Name field does not accept more than 254 characters (When the First name 1 char)
      Given I open "registration" page
      When I type "1" into firstName field
      And I type "jeghssbjsbd;k9jasbdkjsdbvkj;abdkdagdklagldslkjzdblvjbljvblslasdlsblkbzljkvblzjfgb345-83065tsgjvb;kjzdbdzbkzbzbzkfvblfvsldfsdgsdglsdgflgsdgiufsdugsd;idbv;dsgiusrigsepigresgrgrpiusgerpisepigrpegrpiuesgpgihdges;gsiisgerugesriureosgpgusepgsgsiuepsghsepghrpisg" into lastName field
      And I type "test@test.com" into email field
      When I type "ABC" into group field
      And I type "12345" into password field
      When I type "12345" into confirmPassword field
      When I click "Register Me" button


