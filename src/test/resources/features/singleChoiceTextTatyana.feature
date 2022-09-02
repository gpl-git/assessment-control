@scqtext
Feature: Questions Scenarios tt
  Background:
    Given I open "login" page tt
    When I type "joealliegro@playfuny.com" into email field tt
    And I type "12345" into password field tt
    When I click "Sign In" button tt
    And I wait for 2 sec tt
    When I click "Quizzes" menu item tt
    And I wait for 2 sec tt

  @scqtext1
  Scenario: Question field allows alphanumeric & sp.characters
    When I click "Create New Quiz" button tt
    And I wait for 2 sec tt
    When I type "Single Choice Question Quiz1" as quiz title tt
    And I add question tt
    And I wait for 2 sec tt
    When I select "Single" question type tt
    When I enter "What do the special characters $, %, & mean?" into "Q1" tt
    And I type "dollar, hashtag, asterisk" as "Option 1*" into "Q1" tt
    And I type "dollar, percent, and" as "Option 2*" into "Q1" tt
    When I select "Option 2*" as correct option in "Q1" tt
    When I click "Save" button tt
    And I wait for 2 sec tt
    Then I verify that "Single Choice Question Quiz1" is displayed on the list of quizzes tt
    And I wait for 3 sec tt
    And I delete "Single Choice Question Quiz1" from the list of quizzes tt

  @scqtext2
  Scenario: Question field allows min 1 character
    When I click "Create New Quiz" button tt
    And I wait for 2 sec tt
    When I type "Single Choice Question Quiz2" as quiz title tt
    And I add question tt
    And I wait for 2 sec tt
    When I select "Single" question type tt
    And I wait for 2 sec tt
    When I enter "a" into "Q1" tt
    And I wait for 2 sec tt
    And I type "1" as "Option 1*" into "Q1" tt
    And I type "2" as "Option 2*" into "Q1" tt
    When I select "Option 1*" as correct option in "Q1" tt
    Then I click "Save" button tt
    And I wait for 2 sec tt
    Then I verify that "Single Choice Question Quiz2" is displayed on the list of quizzes tt
    And I wait for 3 sec tt
    And I delete "Single Choice Question Quiz2" from the list of quizzes tt

  @scqtext3
  Scenario: The field is required and doesn't allow space as 1 character question
    When I click "Create New Quiz" button tt
    And I wait for 2 sec tt
    When I type "Single Choice Question Quiz3" as quiz title tt
    And I add question tt
    And I wait for 2 sec tt
    When I select "Single" question type tt
    And I wait for 2 sec tt
    When I enter "" into "Q1" tt
    And I wait for 2 sec tt
    And I type "1" as "Option 1*" into "Q1" tt
    Then error message "This field is required" is displayed tt
    And I wait for 2 sec tt
    When I enter " " into "Q1" tt
    And I wait for 2 sec tt
    And I type "1" as "Option 1*" into "Q1" tt
    And I type "2" as "Option 2*" into "Q1" tt
    When I select "Option 1*" as correct option in "Q1" tt
    Then I click "Save" button tt
    And I wait for 2 sec tt
    Then error message "Enter a valid question" is displayed tt

  @scqtext4
  Scenario: Question field allows max 1000 character
    When I click "Create New Quiz" button tt
    And I wait for 2 sec tt
    When I type "Single Choice Question Quiz4" as quiz title tt
    And I add question tt
    And I wait for 2 sec tt
    When I select "Single" question type tt
    And I wait for 2 sec tt
    When I enter "M@ng1234567890poiuytrewqasdfghjklmnbvcxzaM@ng1234567890poiuytrewqasdfghjklmnbvcxzaM@ng1234567890poiuytrewqasdfghjklmnbvcxzaM@ng1234567890poiuytrewqasdfghjklmnbvcxzaM@ng1234567890poiuytrewqasdfghjklmnbvcxzaM@ng1234567890poiuytrewqasdfghjklmnbvcxzaM@ng1234567890poiuytrewqasdfghjklmnbvcxzaM@ng1234567890poiuytrewqasdfghjklmnbvcxzaM@ng1234567890poiuytrewqasdfghjklmnbvcxzaM@ng1234567890poiuytrewqasdfghjklmnbvcxzaM@ng1234567890poiuytrewqasdfghjklmnbvcxzaM@ng1234567890poiuytrewqasdfghjklmnbvcxzaM@ng1234567890poiuytrewqasdfghjklmnbvcxzaM@ng1234567890poiuytrewqasdfghjklmnbvcxzaM@ng1234567890poiuytrewqasdfghjklmnbvcxzaM@ng1234567890poiuytrewqasdfghjklmnbvcxzaM@ng1234567890poiuytrewqasdfghjklmnbvcxzaM@ng1234567890poiuytrewqasdfghjklmnbvcxzaM@ng1234567890poiuytrewqasdfghjklmnbvcxzaM@ng1234567890poiuytrewqasdfghjklmnbvcxzaM@ng1234567890poiuytrewqasdfghjklmnbvcxzaM@ng1234567890poiuytrewqasdfghjklmnbvcxzaM@ng1234567890poiuytrewqasdfghjklmnbvcxzaM@ng1234567890poiuytrewqasdfghjklmnbvcxzaM@ng1234567890po" into "Q1" tt
    And I wait for 2 sec tt
    And I type "1" as "Option 1*" into "Q1" tt
    And I type "2" as "Option 2*" into "Q1" tt
    When I select "Option 1*" as correct option in "Q1" tt
    Then I click "Save" button tt
    And I wait for 2 sec tt
    Then I verify that "Single Choice Question Quiz4" is displayed on the list of quizzes tt
    And I wait for 3 sec tt
    And I delete "Single Choice Question Quiz4" from the list of quizzes tt

  @scqtext5
  Scenario: Question field doesn't allow more than 1000 character
    When I click "Create New Quiz" button tt
    And I wait for 2 sec tt
    When I type "Single Choice Question Quiz5" as quiz title tt
    And I add question tt
    And I wait for 2 sec tt
    When I select "Single" question type tt
    And I wait for 2 sec tt
    When I enter "M@ng1234567890poiu5ytrewqasdfghjklmnbvcxzaM@ng1234567890poiuytrewqasdfghjklmnbvcxzaM@ng1234567890poiuytrewqasdfghjklmnbvcxzaM@ng1234567890poiuytrewqasdfghjklmnbvcxzaM@ng1234567890poiuytrewqasdfghjklmnbvcxzaM@ng1234567890poiuytrewqasdfghjklmnbvcxzaM@ng1234567890poiuytrewqasdfghjklmnbvcxzaM@ng1234567890poiuytrewqasdfghjklmnbvcxzaM@ng1234567890poiuytrewqasdfghjklmnbvcxzaM@ng1234567890poiuytrewqasdfghjklmnbvcxzaM@ng1234567890poiuytrewqasdfghjklmnbvcxzaM@ng1234567890poiuytrewqasdfghjklmnbvcxzaM@ng1234567890poiuytrewqasdfghjklmnbvcxzaM@ng1234567890poiuytrewqasdfghjklmnbvcxzaM@ng1234567890poiuytrewqasdfghjklmnbvcxzaM@ng1234567890poiuytrewqasdfghjklmnbvcxzaM@ng1234567890poiuytrewqasdfghjklmnbvcxzaM@ng1234567890poiuytrewqasdfghjklmnbvcxzaM@ng1234567890poiuytrewqasdfghjklmnbvcxzaM@ng1234567890poiuytrewqasdfghjklmnbvcxzaM@ng1234567890poiuytrewqasdfghjklmnbvcxzaM@ng1234567890poiuytrewqasdfghjklmnbvcxzaM@ng1234567890poiuytrewqasdfghjklmnbvcxzaM@ng1234567890poiuytrewqasdfghjklmnbvcxzaM@ng1234567890po" into "Q1" tt
    And I wait for 2 sec tt
    And I type "1" as "Option 1*" into "Q1" tt
    Then error message "Max 1000 characters" is displayed tt
    And I wait for 3 sec tt

