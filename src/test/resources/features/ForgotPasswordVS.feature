@FP
Feature: Automate test set "Forgot Password"
  Background:
    Given I navigate to the "login" page
#    When I enter "ask_instr@aol.com" into email input
#    And I enter"12345" into password
#    When I click "Sign In"
#    And I wait for 1 second

@forgotPass
  Scenario: Forgot Password
    Then I click on "I forgot my password"
    And I should see the header as "Reset Password Request"
    When I click on "required" email field
    Then I submit my request by clicking "Request password request"
    And I wait for 4 second
    And I should see the page with "Your request is confirmed"
    #email received, go to my email, click on the link and
    Then I redirecting myself to the "reset password" link via my email
    And I enter new "password123"
    And confirm my new "password123" one more time
    Then I click "Reset" to change my password
    And I wait for 8 second
    When I should be redirected to the page with "Your Password was Changed"