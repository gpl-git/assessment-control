@AS653Liliya

Feature: Registration Email

  Background:
    Given I navigate to "website"

  @AS653Liliya1
  Scenario: Registration EMAIL valid data test

    When I type "Liliya" into First Name field
    And I type "Pumpkin" into Last Name field
    And I input "" into email field
    And I type "XYZ" into Group Code field
    And I type "Portnov123*" into the password field
    And I type "Portnov123*" into the Confirm  password field
    When I click "Register Me" button
    Then mat-card with "You have been Registered." displayed
 #   And I wait for 5 sec

  @AS653Liliya2
  Scenario: Registration EMAIL empty field error message
    When I type "Liliya" into First Name field
    And I type "Pumpkin" into Last Name field
    And I leave email field empty
    And I type "XYZ" into Group Code field
    And I type "Portnov123*" into the password field
    And I type "Portnov123*" into the Confirm  password field
    When I click "Register Me" button
    Then mat-error "This field is required" displayed
 #   And I wait for 5 sec

  @AS653Liliya3
  Scenario: Registration EMAIL white space are not allowed
    When I type "Liliya" into First Name field
    And I type "Pumpkin" into Last Name field
    And I type email with white space "gold lili@gmail.com" into email field
    When I click on Group field
    Then error message "Should be a valid email address" displayed
 #   And I wait for 5 sec

  @AS653Liliya4
  Scenario: Registration EMAIL 128 characters

    When I type "Liliya" into First Name field
    And I type "Pumpkin" into Last Name field
    And I print "sdjfsdhgjdsghsjdghdjjjjjjjjjjghjdghddgjghdfjghghghghghghghghghgh@jcvkcxvcvhjcvhvhvhvhvhvhcvvvv.vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv" into email field
    And I type "XYZ" into Group Code field
    And I type "Portnov123*" into the password field
    And I type "Portnov123*" into the Confirm  password field
    When I click "Register Me" button
    Then mat-card with "You have been Registered." displayed
 #   And I wait for 5 sec


  @AS653Liliya5
  Scenario: Registration EMAIL 128+1 characters

    When I type "Liliya" into First Name field
    And I type "Pumpkin" into Last Name field
    And I print "sdjfsdhgjdsghsjdghdjjjjjjjjjjghjdghddgjghdfjghghghghghghghghghghb@jcvkcxvcvhjcvhvhvhvhvhvhcvvvv.vvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvvv" into email field
    When I click on Group field
    Then error message "Should be a valid email address" displayed
 #   And I wait for 5 sec





