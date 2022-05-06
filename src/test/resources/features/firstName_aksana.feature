@firstname
  Feature: First Name Registration


      @smoke
      Scenario: Registration First Name
        Given I go to "registration" page
        When I type "Aksana" into first name field
        And I type "Test" into last name field
        And I type "hornylou@gasss.us" into email field
        And I type "1234" into group code field
        And I type "12345" into password field
        And I type "12345" into confirm password field
        Then I click button "Register Me"
        And I wait for 2 sec
