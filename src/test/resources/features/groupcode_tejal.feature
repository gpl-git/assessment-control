@registration_GroupCode
  Feature: Registration Scenario


Background:
Given I OPEN  "registration" page
 And I type "Kavya" into firstName field
  Then I type "Shah" into lastName field
  Then I type "tss@gmail.com" into email input field
  Then I type "JUL22" into groupCode field
  Then I type "1981" into password field field
  Then I type "1981" into  Confirm password field

  @registration_GroupCode2
  Scenario: invalid GroupCode
    Given I clear on groupCode field
    Then I type "1234567891011" into groupCode
   Then I click on "Register me" button
    And I wait for more  1 sec
    Then Error message should be appeared
    Then Error Message "Should no more than 10 characters" should be displayed

    @registration_GroupCode3
    Scenario: GroupCode Allows min 1 char
      Given I again clear on groupCode field
      Then I type "s" into  groupCode space
      Then  I clear on groupCode field again
      Then I click Register-me button
      And I get an error message
#      Then Error Message "This field is required" should be there
   @@registration_GroupCode4
   Scenario: GroupCode Allows white space between the words
     Given I click on groupCode field
     Then I type "JUl     27" on groupCode field
     Then submit the form
     Then error message "Should no more than 10 characters" should be appeared








