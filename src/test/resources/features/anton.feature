@regestration
Feature: Registration email scenarios


  Scenario: Registration with valid email
    Given I open "registration" page
    And I wait for 1 sec
    When I type "Antonio" into First Name filed
    Then I type "Banderas" into Last Name field
    Then I type new email into email field
    And I wait for 1 sec
    Then I type "BOX" into Group Code filed
    Then I type "12345" into password filed
    Then I type "12345" into Confirm Password filed
    When I click "Register Me" button
    And I wait for 1 sec


  Scenario: Registration field can not be empty
    Given I open "registration" page
    And I wait for 1 sec
    When I type "Antonio" into First Name filed
    Then I type "Banderas" into Last Name field
    And I wait for 1 sec
    Then I type "BOX" into Group Code filed
    Then I type "12345" into password filed
    Then I type "12345" into Confirm Password filed
    When I click "Register Me" button
    And I wait for 1 sec
    Then Message "This field is required" should be displayed


  Scenario: Registration email: Alphanumeric & Special characters
    Given I open "registration" page
    And I wait for 1 sec
    When I type "Antonio" into First Name filed
    Then I type "Banderas" into Last Name field
    Then I type "123asd{}[]()@abc.com" into email filed
    And I wait for 1 sec
    Then I type "BOX" into Group Code filed
    Then I type "12345" into password filed
    Then I type "12345" into Confirm Password filed
    When I click "Register Me" button
    And I wait for 1 sec
    Then Message "Should be a valid email address" should be displayed


  Scenario: Registration email: White spaces are not allowed
    Given I open "registration" page
    And I wait for 1 sec
    When I type "Antonio" into First Name filed
    Then I type "Banderas" into Last Name field
    Then I type "asdzzxc s@abc.com" into email filed
    And I wait for 1 sec
    Then I type "BOX" into Group Code filed
    Then I type "12345" into password filed
    Then I type "12345" into Confirm Password filed
    When I click "Register Me" button
    And I wait for 1 sec
    Then Message "Should be a valid email address" should be displayed



  Scenario: Registration email: Required email format
    Given I open "registration" page
    And I wait for 1 sec
    When I type "Antonio" into First Name filed
    Then I type "Banderas" into Last Name field
    Then I type "asdzzxcs@abc.com@" into email filed
    And I wait for 1 sec
    Then I type "BOX" into Group Code filed
    Then I type "12345" into password filed
    Then I type "12345" into Confirm Password filed
    When I click "Register Me" button
    And I wait for 1 sec
    Then Message "Should be a valid email address" should be displayed


  Scenario: Registration with already registered email
    Given I open "registration" page
    And I wait for 1 sec
    When I type "Antonio" into First Name filed
    Then I type "Banderas" into Last Name field
    Then I type "antonshalapuda@gmail.com" into email filed
    And I wait for 1 sec
    Then I type "BOX" into Group Code filed
    Then I type "12345" into password filed
    Then I type "12345" into Confirm Password filed
    When I click "Register Me" button
    And I wait for 1 sec
    Then Message "User already exists and activated" should be displayed


