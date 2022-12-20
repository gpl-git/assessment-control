@multiChoiceQuOptions
Feature: Verifying "Multiple Choice Question - Options" Behavior : NOV-210

  Background: login, NOV-565
#  NOV-565, the whole test is more suitable for the Background
    Given I go to "login" page EF
    When I enter valid credentials as a teacher -EF
    And I click on "Sign In" button -EF
    And I wait for 1 sec -EF
    When I click "Quizzes" menu item -EF
    And I wait for 1 sec -EF
    And I click "Create New Quiz" button -EF
    And I wait for 1 sec -EF
    When I enter "Demo Quiz Elena December 22" as quiz title -EF
    And I add a new question -EF
    When I select "Multiple-Choice" question -EF
    And I wait for 1 sec -EF


  @multiChoiceQuOptions1
  Scenario: Verifying all required fields : NOV-569
    #    do we verify 3 fields only as it written in test?
    When I click on "Q1" question textarea -EF
    And I click on "Option 1*" field in "Q1" -EF
    Then error message is displayed under question input field and contains text: "This field is required" -EF
    When I click on "Option 2*" field in "Q1" -EF
    Then error message is displayed under "Option 1*" input field and contains text: "This field is required" -EF
    When I click on "Option 1*" field in "Q1" -EF
    Then error message is displayed under "Option 2*" input field and contains text: "This field is required" -EF


  @multiChoiceQuOptions2
  Scenario: Verify indelible options : NOV-570
    When I click on Settings button at "Option 1*" field in "Q1" -EF
    And I wait for 2 sec -EF
    Then the Delete element will be inactive -EF
    And I click on Close button
    When I add a new option -EF
    And I click on Settings button at "Option 1*" field in "Q1" -EF
    Then the Delete element will be active -EF
    When I click on the Delete button  -EF
    And I click on Settings button at "Option 1*" field in "Q1" -EF
    Then the Delete element will be inactive -EF

  @multiChoiceQuOptions3
  Scenario: Verify that only Max. 15 options can be created : NOV-571
    When I add 16 new options
      #  bug NOV-527
    Then too many error message is displayed and contains text: "Max. 15 options are possible"


  @multiChoiceQuOptions4
  Scenario: Verify Preview/Save functionality after creating a new question : Nov-574
#    why is this a separate test though
    When I type "Question 1" into "Q1" textarea -EF
    And I type "Option 1" into "Option 1*" field in "Q1" -EF
    And I type "Option 2" into "Option 2*" field in "Q1" -EF
    When I select "Option 1*" as correct option in "Q1" -EF
    And I click "Preview" button -EF
    Then preview window should be displayed and contain "Demo Quiz Elena December 22" title
    When I close the preview window
    And I click "Save" button -EF
    And I wait for 2 sec -EF
    Then quiz "Demo Quiz Elena December 22" is displayed on the list of quizzes -EF
    And I wait for 2 sec -EF
    And I delete quiz "Demo Quiz Elena December 22" -EF
    And I wait for 2 sec -EF

  @multiChoiceQuOptions5
  Scenario Outline: Verifying boundary conditions for a number of characters within new option (positive): NOV-575
    When I type "Question 1" into "Q1" textarea -EF
    And I type <count> symbol(s) into "Option 1*" field in "Q1" -EF
    And I type "12" into "Option 2*" field in "Q1" -EF
    And I select "Option 1*" as correct option in "Q1" -EF
    And I click "Preview" button -EF
    And I wait for 1 sec -EF
    Then preview window should be displayed and contain "Demo Quiz Elena December 22" title
    When I close the preview window
    And I click "Save" button -EF
    And I wait for 2 sec -EF
    Then quiz "Demo Quiz Elena December 22" is displayed on the list of quizzes -EF
    And I wait for 1 sec -EF
    And I delete quiz "Demo Quiz Elena December 22" -EF
    And I wait for 2 sec -EF
    Examples:
      | count |
      | 1     |
      | 2     |
      | 999   |
      | 1000  |

  @multiChoiceQuOptions6
  Scenario: Verifying max allowed number of characters is no more than 1000 : NOV-575
    When I type "Question 1" into "Q1" textarea -EF
    And I type "12" into "Option 2*" field in "Q1" -EF
    And I type 1001 symbol(s) into "Option 1*" field in "Q1" -EF
    And I select "Option 1*" as correct option in "Q1" -EF
#   bug #NOV-534
    Then error message is displayed under "Option 1*" input field and contains text: "The Error Message max.1000 characters" -EF
