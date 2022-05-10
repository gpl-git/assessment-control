@quiz
  Feature: Change password

  Background:
    Given I open home page to "login"
    And I input credentials at login page "rerjkrf2@mailpluss.com" and "123456"
    And sleep 1 sec
    And I click "Sign In" button
    And sleep 1 sec



      @ChangePass6
      Scenario: Verify long pass
        Given I select in left menu "Settings"
        And sleep 1 sec
        And I click "Change Your Password" button
        And sleep 1 sec
        When I input old password "123456"
        Then I input long new password 55 from symbols
        And sleep 1 sec
        And I clicking "Change" button
        And sleep 1 sec
        Then I select in left menu "Log Out"
        And sleep 1 sec
        And I click "Log Out" button
        And sleep 1 sec
        And I open home page to "login"
        And sleep 1 sec
        And I input credentials with email "rerjkrf2@mailpluss.com" longPSWD
        And I click "Sign In" button
        And sleep 1 sec
        And title of the page with xpath "Assessment Control @ Portnov" is displayed
        Then I select in left menu "Settings"
        And sleep 1 sec
        And I click "Change Your Password" button
        And sleep 1 sec
        When I input old longpassword
        And I input new password "123456"
        And I confirm new password "123456"
        And sleep 1 sec
        And I clicking "Change" button
        Then I select in left menu "Log Out"
        And I click "Log Out" button
        And sleep 1 sec


    @ChangePass7
    Scenario Outline: Change short and spaces password outline2
      Given I select in left menu "Settings"
      And sleep 1 sec
      And I click "Change Your Password" button
      And sleep 1 sec
      When I input old password <oldPass>
      When I input new password and confirm <newPass> <confpass> and see error messages <errorMessage1> <errorMessage2>
      And sleep 1 sec
      Examples:
       | oldPass     | newPass    | confpass     | errorMessage1     | errorMessage2     |
       | "123456"      | "1234"     | "" | "Should be at least 5 characters" | "This field is required" |
       | "123456"      | "12 34"     | "12 34" | "Whitespaces are not allowed" | "Whitespaces are not allowed" |
       | "123456"      | "1234"     | "12345" | "Should be at least 5 characters" | "Entered passwords should match" |
       | "123456"      | "12 34"     | "1234567" | "Whitespaces are not allowed" | "Entered passwords should match" |
       | "123456"      | "1234567"     | "12 34" | "no message" | "Whitespaces are not allowed" |
