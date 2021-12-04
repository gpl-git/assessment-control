@management
Feature: User's Management Scenarios

  Background:
    Given I go to "login" page
    When I type "ask_instr@aol.com" into email field
    And I type "12345" into password field
    When I click "Sign In" button
    And I wait for 1 sec

  @management @changeUserName
  Scenario: Change User Name - Happy Pass
    When I click on "Management" link
    And I wait for 1 sec
    Then I select "1st Student" on the "Students" tab
    And I wait for 1 sec
    When I click the Options button and select Change User's Name
    Then I remove the data in Full Name field
    Then I type "1st Student" in Full Name field
    Then Button "Change" is enabled
    And I click "Change" button
    And I wait for 1 sec
    Then Name "1st Student" should be displayed in the header of user details mat-card
    And Name "1st Student" should be displayed in the list of users on the "Students" tab
    And I wait for 1 sec
    And I change user name "1st Student" on the tab "Students" to the name "1st Student"
    And I wait for 1 sec

  @management @changeUserName @allowableCharacters
  Scenario: Allowable characters in Full Name field
    When I click on "Management" link
    And I wait for 1 sec
    Then I select "1st Student" on the "Students" tab
    And I wait for 1 sec
    When I click the Options button and select Change User's Name
    Then I remove the data in Full Name field
    Then I type "1%>V] [?;@a:~#$" in Full Name field
    Then Button "Change" is enabled
    And I click "Change" button
    And I wait for 1 sec
    Then Name "1%>V] [?;@a:~#$" should be displayed in the header of user details mat-card
    And Name "1%>V] [?;@a:~#$" should be displayed in the list of users on the "Students" tab
    And I wait for 1 sec
    And I change user name "1%>V] [?;@a:~#$" on the tab "Students" to the name "1st Student"
    And I wait for 1 sec

  @management @changeUserName @allowableCharacters
  Scenario: Allowable characters in Full Name field - short
    When I change user name "1st Student" on the tab "Students" to the name "1%>V] [?;@a:~#$"
    And I wait for 1 sec
    Then Name "1%>V] [?;@a:~#$" should be displayed in the header of user details mat-card
    And Name "1%>V] [?;@a:~#$" should be displayed in the list of users on the "Students" tab
    And I wait for 1 sec
    And I change user name "1%>V] [?;@a:~#$" on the tab "Students" to the name "1st Student"
    And I wait for 1 sec

  @management @changeUserName @minCharacters
  Scenario: Minimum required characters in Full Name field
    When I change user name "1st Student" on the tab "Students" to the name "1 S"
    And I wait for 1 sec
    Then Name "1 S" should be displayed in the header of user details mat-card
    And Name "1 S" should be displayed in the list of users on the "Students" tab
    And I wait for 1 sec
    And I change user name "1 S" on the tab "Students" to the name "1st Student"
    And I wait for 1 sec

  @management @changeUserName @minCharacters
  Scenario: Less than required characters in Full Name field
    When I click on "Management" link
    And I wait for 1 sec
    Then I select "1st Student" on the "Students" tab
    And I wait for 1 sec
    When I click the Options button and select Change User's Name
    Then I remove the data in Full Name field
    Then I type "A " in Full Name field
    Then Button "Change" is disabled
    And I wait for 1 sec
    #    Known issue Jira ticket OCT-736

  @management @changeUserName @maxCharacters
  Scenario: Maximum required characters in Full Name field - random
    When I click on "Management" link
    And I wait for 1 sec
    Then I select "1st Student" on the "Students" tab
    And I wait for 1 sec
    When I click the Options button and select Change User's Name
    Then I remove the data in Full Name field
    And I type First Name of 200 characters and Last Name of 155 characters with " " between them in Full Name field
    And Button "Change" is enabled
    And I wait for 1 sec
     #    Known issue Jira ticket OCT-572

  @management @changeUserName @maxCharacters
  Scenario: More than Maximum required characters in Full Name field - random
    When I click on "Management" link
    And I wait for 1 sec
    Then I select "1st Student" on the "Students" tab
    And I wait for 1 sec
    When I click the Options button and select Change User's Name
    Then I remove the data in Full Name field
    And I type First Name of 200 characters and Last Name of 156 characters with " " between them in Full Name field
    Then Button "Change" is disabled
    And Error message "Too long. Should be no more than 256 characters" should be displayed below the Full Name field
    #    Known issue Jira ticket OCT-572

  @management @changeUserName @whiteSpaces
  Scenario: White spaces in Full Name field are not allowed
    When I click on "Management" link
    And I wait for 1 sec
    Then I select "1st Student" on the "Students" tab
    And I wait for 1 sec
    When I click the Options button and select Change User's Name
    Then I remove the data in Full Name field
    Then I type " A" in Full Name field
    Then Button "Change" is disabled
    And Error message "White spaces are not allowed" should be displayed below the Full Name field
    And I wait for 1 sec
    #    Known issue - Jira ticket OCT-579

  @management @changeUserName @whiteSpaces
  Scenario Outline: White spaces in Full Name field are not allowed - outline
    When I click on "Management" link
    And I wait for 1 sec
    Then I select "1st Student" on the "Students" tab
    And I wait for 1 sec
    When I click the Options button and select Change User's Name
    Then I remove the data in Full Name field
    Then I type <name> in Full Name field
    Then Button "Change" is disabled
    And Error message <errorMessage> should be displayed below the Full Name field
    And I wait for 1 sec
    Examples:
      | name          | errorMessage                   |
      | " Name"       | "White spaces are not allowed" |
      | "Name  "      | "White spaces are not allowed" |
      | "Name  Name"  | "White spaces are not allowed" |
      | "Name Name "  | "White spaces are not allowed" |
      | " Name Name"  | "White spaces are not allowed" |
      | " Name Name " | "White spaces are not allowed" |
      | " "           | "White spaces are not allowed" |
      | "   "         | "White spaces are not allowed" |
    #    Known issue - Jira ticket OCT-579

  @management @changeUserName @fieldRequired
  Scenario: Full name field is required
    When I click on "Management" link
    And I wait for 1 sec
    Then I select "1st Student" on the "Students" tab
    And I wait for 1 sec
    When I click the Options button and select Change User's Name
    Then I remove the data in Full Name field
    Then I type "My Name" in Full Name field
    Then Button "Change" is enabled
    When I remove the data in Full Name field
#    And I click on dialog modal window
    Then Button "Change" is disabled
    And Error message "This field is required" should be displayed below the Full Name field
    And I wait for 1 sec

