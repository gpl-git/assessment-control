@quiz
Feature: Quiz Scenarios

  Background:
    Given I open "login" page [MKs]
    When I type "shamdag@24hinbox.com" for teacher user [MKs]
    And I type "qazwsxedc" as password [MKs]
    When I click "Sign In" button [MKs]
    And I wait for 1 sec [MKs]
    Then "home" page will be displayed [MKs]
    When I click on "Quizzes" menu item [MKs]
    And I wait for 1 sec [MKs]


#    @quiz1
#    Scenario: [SEP22-414] Option text field accepts 1000 characters [MKs]
#      When I click "Create New Quiz" button [MKs]
#      And I wait for 1 sec [MKs]
#      When I type "111 My demo automation Single Choise" as quiz title [MKs]
#      And I add a question [MKs]
#      When I select "Single" question [MKs]
#      And I wait for 1 sec [MKs]
#      When I type "Question 1 text" into "Q1" [MKs]
##            I type 1000 characters into quiz option fields
##     And I type "Option 1" as "asdasfgsfdhsfhasdasfgsfdhsfhasdasfgsfdhsfhasdasfgsfdhsfhasdasfgsfdhsfhasdasfgsfdhsfhasdasfgsfdhsfhasdasfgsfdhsfhasdasfgsfdhsfhasdasfgsfdhsfhasdasfgsfdhsfhasdasfgsfdhsfhasdasfgsfdhsfhasdasfgsfdhsfhasdasfgsfdhsfhasdasfgsfdhsfhasdasfgsfdhsfhasdasfgsfdhsfhasdasfgsfdhsfhasdasfgsfdhsfhasdasfgsfdhsfhasdasfgsfdhsfhasdasfgsfdhsfhasdasfgsfdhsfhasdasfgsfdhsfhasdasfgsfdhsfhasdasfgsfdhsfhasdasfgsfdhsfhasdasfgsfdhsfhasdasfgsfdhsfhasdasfgsfdhsfhasdasfgsfdhsfhasdasfgsfdhsfhasdasfgsfdhsfhasdasfgsfdhsfhasdasfgsfdhsfhasdasfgsfdhsfhasdasfgsfdhsfhasdasfgsfdhsfhasdasfgsfdhsfhasdasfgsfdhsfhasdasfgsfdhsfhasdasfgsfdhsfhasdasfgsfdhsfhasdasfgsfdhsfhasdasfgsfdhsfhasdasfgsfdhsfhasdasfgsfdhsfhasdasfgsfdhsfhasdasfgsfdhsfhasdasfgsfdhsfhasdasfgsfdhsfhasdasfgsfdhsfhasdasfgsfdhsfhasdasfgsfdhsfhasdasfgsfdhsfhasdasfgsfdhsfhasdasfgsfdhsfhasdasfgsfdhsfhasdasfgsfdhsfhasdasfgsfdhsfhasdasfgsfdhsfhasdasfgsfdhsfhasdasfgsfdhsfhasdasfgsfdhsfhasdasfgsfdhsfhasdasfgsfdhsfhasdasfgsfdhsfhasdasfgsfdhsfhasdasfgsfdhsfhasdasfgsfdhsfhtreuiu" in "Q1" [MKs]
##      And I type "Option 2" as "asdasfgsfdhsfhasdasfgsfdhsfhasdasfgsfdhsfhasdasfgsfdhsfhasdasfgsfdhsfhasdasfgsfdhsfhasdasfgsfdhsfhasdasfgsfdhsfhasdasfgsfdhsfhasdasfgsfdhsfhasdasfgsfdhsfhasdasfgsfdhsfhasdasfgsfdhsfhasdasfgsfdhsfhasdasfgsfdhsfhasdasfgsfdhsfhasdasfgsfdhsfhasdasfgsfdhsfhasdasfgsfdhsfhasdasfgsfdhsfhasdasfgsfdhsfhasdasfgsfdhsfhasdasfgsfdhsfhasdasfgsfdhsfhasdasfgsfdhsfhasdasfgsfdhsfhasdasfgsfdhsfhasdasfgsfdhsfhasdasfgsfdhsfhasdasfgsfdhsfhasdasfgsfdhsfhasdasfgsfdhsfhasdasfgsfdhsfhasdasfgsfdhsfhasdasfgsfdhsfhasdasfgsfdhsfhasdasfgsfdhsfhasdasfgsfdhsfhasdasfgsfdhsfhasdasfgsfdhsfhasdasfgsfdhsfhasdasfgsfdhsfhasdasfgsfdhsfhasdasfgsfdhsfhasdasfgsfdhsfhasdasfgsfdhsfhasdasfgsfdhsfhasdasfgsfdhsfhasdasfgsfdhsfhasdasfgsfdhsfhasdasfgsfdhsfhasdasfgsfdhsfhasdasfgsfdhsfhasdasfgsfdhsfhasdasfgsfdhsfhasdasfgsfdhsfhasdasfgsfdhsfhasdasfgsfdhsfhasdasfgsfdhsfhasdasfgsfdhsfhasdasfgsfdhsfhasdasfgsfdhsfhasdasfgsfdhsfhasdasfgsfdhsfhasdasfgsfdhsfhasdasfgsfdhsfhasdasfgsfdhsfhasdasfgsfdhsfhasdasfgsfdhsfhasdasfgsfdhsfhasdasfgsfdhsfhtreuiu" in "Q1" [MKs]
##      Then I select "Option 1*" as correct option in "Q1" [MKs]
##      And I click "Save" button [MKs]
##      And I wait for 1 sec [MKs]
##      Then quiz "Demo Quiz - Automation" is displayed on the list of quizzes [MKs]
##      And I delete quiz "Demo Quiz - Automation" [MKs]
#      Then I type "1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000ch" into FirstOption
#      Then I type "1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000ch" into SecondOption
#      Then I wait for 3 sec [MKs]
#      Then required quantity of characters "1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000characters1000ch" should be present in OptionField1
#      Then I wait for 3 sec [MKs]


#    @quiz2
#    Scenario: [SEP22-416] Option text field doesn't accept 1001 characters [MKs]
#      When I click "Create New Quiz" button [MKs]
#      And I wait for 1 sec [MKs]
#      When I type "111 My demo automation Single Choise" as quiz title [MKs]
#      And I add a question [MKs]
#      When I select "Single" question [MKs]
#      And I wait for 1 sec [MKs]
#      When I type "Question 1 text" into "Q1" [MKs]
##     I type 1001 characters into quiz option fields
#      Then I type "1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001cha" into FirstOption
#      Then I type "1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001cha" into SecondOption
#      Then I wait for 3 sec [MKs]
#      Then required quantity of characters "1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001characters1001cha" should not be present in OptionField1
#      Then I wait for 3 sec [MKs]

#      @quiz3
#      Scenario: [SEP22-419] Option text field accepts 1 character [MKs]
#        When I click "Create New Quiz" button [MKs]
#        And I wait for 1 sec [MKs]
#        When I type "111 My demo automation Single Choise" as quiz title [MKs]
#        And I add a question [MKs]
#        When I select "Single" question [MKs]
#        And I wait for 1 sec [MKs]
#        When I type "Question 1 text" into "Q1" [MKs]
##     I type 1001 characters into quiz option fields
#       Then I type "1" into FirstOption
#        Then I type "1" into SecondOption
#        Then required quantity of characters "1" should be present in OptionField1
#        Then I wait for 3 sec [MKs]

#  @quiz4
#  Scenario: [SEP22-421] Unable to create a Single choice question with an empty Option text field [MKs]
#    When I click "Create New Quiz" button [MKs]
#    And I wait for 1 sec [MKs]
#    When I type "111 My demo automation Single Choise" as quiz title [MKs]
#    And I add a question [MKs]
#    When I select "Single" question [MKs]
#    And I wait for 1 sec [MKs]
#    When I type "Question 1 text" into "Q1" [MKs]
#    And I click on Save button [MKs]
#    Then I wait for 2 sec [MKs]
#    Then Option1 quiz error should be displayed

  @quiz5
  Scenario: [SEP22-423] Option text field accepts special characters [MKs]
        When I click "Create New Quiz" button [MKs]
        And I wait for 1 sec [MKs]
        When I type "111 My demo automation Single Choise" as quiz title [MKs]
        And I add a question [MKs]
        When I select "Single" question [MKs]
        And I wait for 1 sec [MKs]
        When I type "Question 1 text" into "Q1" [MKs]
#     I type @ characters into quiz option fields
       Then I type "@" into FirstOption
      Then I type "@" into SecondOption
    And I click on element with xpath "//ac-question-body-form/div[1]/div[2]/div[1]/mat-radio-group[1]/mat-radio-button[1]/label[1]/div[1]" [MKs]
    Then I wait for 3 sec [MKs]
  Then  error messages should not be displayed


