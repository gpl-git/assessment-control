@quiz
  Feature: Change password

  Background:
    Given I open home page to "login"
    And I input credentials at login page "rerjkrf2@mailpluss.com" and "123456"
    And sleep 1 sec
    And I click "Sign In" button
    And sleep 2 sec

      @ChangePass5
    Scenario Outline: Change short and spaces password outline
      Given I select in left menu "Settings"
      And sleep 1 sec
      And I click "Change Your Password" button
      And sleep 1 sec
      When I input old password <oldPass>
      When I input new password and confirm <newPass> <confpass>
      Examples:
        | oldPass  | newPass | confpass |
        | "123456" | "1234"  | ""  |
        | "123456" | "12 34"  | "12 34 "  |
        | "123456" | "1234"  | "12345"  |
        | "123456" | "12 34"  | "1234567"  |
        | "123456" | "1235674"  | "12 34"  |


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