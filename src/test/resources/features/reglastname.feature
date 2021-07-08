@reglastname @regression

  Feature: Registration Last Name Scenarios

    @regression
    Scenario: Verify that Registration Last Name meets requirements.
      Given I go to "registration" page
      And I wait for 1 sec
      And I type "a" into First Name field
      And I type "" into Last Name field
      And I wait for 1 sec
      Then error message "This field is required" is displayed
      And I wait for 3 sec
      And I type "mmoaml.amin.76@btcmod.com" into email field
      And I type "xyz" into Group Code field
      And I type "12345" into password field
      And I type "12345" into confirm password field
      And I type "ABabc" into Last Name field
      And I wait for 3 sec






