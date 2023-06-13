@reg_group
  Feature: Registration Group Code Verification
    Background:
      Given I go to "registration" page
#      And I wait for 2 sec
      When I type "Diana" into first name field  DD
      When I type "Janoyeva" into last name field  DD
      And I type "dinajahna123@gmail.com" into email field
      And I type "abc123" into password field
      And I type "abc123" into confirm password field DD


    @reg_group1
    Scenario: Alphanumerical and special characters and 10 characters
      And I type "hal123#$as" into group code field DD
      When I click "Register Me" button
      And I wait for 1 sec
      Then confirmation message "You have been Registered." should be displayed DD

      @reg_group2
      Scenario: Empty input field
        When I type "" into group code field DD
        When I click "Register Me" button
        Then error message "This field is required" should be displayed DD

      @reg_group3
      Scenario: 11 characters in Group code field
        When I type "12#45,15679" into group code field DD
        When I click "Register Me" button
        Then error message "Should no more than 10 characters" should be displayed DD
        
      @reg_group4
      Scenario: 1 character in Group code field
        When I type "a" into group code field DD
        When I click "Register Me" button
        And I wait for 1 sec
        Then confirmation message "You have been Registered." should be displayed DD

      @reg_group5
      Scenario: White spaces in Group code field
        When I type "  " into group code field DD
        When I click "Register Me" button
        And I wait for 1 sec
        Then confirmation message "You have been Registered." should be displayed DD



        





      
      
      


