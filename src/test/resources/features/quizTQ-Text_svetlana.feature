@quiz @smoke
Feature:  Textual Question - Text

  Background:
    Given I go to "login" page
    When I type "ask_instr@aol.com" into email field
    And I type "12345" into password field
    When I click "Sign In" button
    And I wait for 1 sec
    When I click "Quizzes" menu item
    And I wait for 1 sec

  @quiz1
  Scenario: Create a Quiz (Happy Path)
    When I click "Create New Quiz" button
    And I wait for 1 sec
    When I type "000 UI Automation - Svetlana" as quiz title
    And I add a question
    When I select "Textual" question type
    When I enter "Question 1 Text" into "Q1"
    When I click "Save" button
    And I wait for 1 sec
    Then I verify that "000 UI Automation - Svetlana" is displayed on the list of quizzes
    And I wait for 3 sec
    And I delete "000 UI Automation - Svetlana" from the list of quizzes

    @quiz2
    Scenario: Verify TQ field accepts alphanumeric & special characters
      When I click "Create New Quiz" button
      And I wait for 1 sec
      When I type "000 UI Automation - Svetlana" as quiz title
      And I add a question
      When I select "Textual" question type
      When I enter "DRA2@#$*_gasani()]}`" into "Q1"
      When I click "Save" button
      And I wait for 1 sec
      Then I verify that "000 UI Automation - Svetlana" is displayed on the list of quizzes
      And I wait for 3 sec
      And I delete "000 UI Automation - Svetlana" from the list of quizzes

    @quiz3

    Scenario: Verify TQ field is required and can not be empty
      When I click "Create New Quiz" button
      And I wait for 1 sec
      When I type "000 UI Automation - Svetlana" as quiz title
      And I add a question
      When I select "Textual" question type
#      When I enter " " into "Q1"
      When I click "Save" button
      And I wait for 1 sec
      Then error message "This field is required" is displayed



  @quiz4
  Scenario: Verify TQ field allows minimum 1 character
    When I click "Create New Quiz" button
    And I wait for 1 sec
    When I type "000 UI Automation - Svetlana" as quiz title
    And I add a question
    When I select "Textual" question type
    When I enter "Q" into "Q1"
    When I click "Save" button
    And I wait for 1 sec
    Then I verify that "000 UI Automation - Svetlana" is displayed on the list of quizzes
    And I wait for 3 sec
    And I delete "000 UI Automation - Svetlana" from the list of quizzes

  @quiz5
#       Bug because accepts 1001 characters
  Scenario: Verify TQ field allows max 1000  characters
    When I click "Create New Quiz" button
    And I wait for 1 sec
    When I type "000 UI Automation - Svetlana" as quiz title
    And I add a question
    When I select "Textual" question type
    When I enter "rhlkrphkmhbkdfmbkdsfkbipdfjbijdigjisdfjgbksdfmbvkdmksdgpijriogjeriojgkdsfmbksdfjbpidjgpioeragjipbmkpdsfjbpidfj ifmikmdfbmidpfjbidfmbdkbmkdfmbipdfjbiodfjbikdfmbkdfmbikdfmbipodfbmikfdmbkdfmbkdfmbkfdmblf rhlkrphkmhbkdfmbkdsfkbipdfjbijdigjisdfjgbksdfmbvkdmksdgpijriogjeriojgkdsfmbksdfjbpidjgpioeragjipbmkpdsfjbpidfj ifmikmdfbmidpfjbidfmbdk bmkdfmbipdfjbiodfjbikdfmbkdfmbikdfmbipodfbmikfdmbkdfmbkdfmbkfdmblf rhlkrphkmhbkdfmbkdsfkbipdfjbijdigjisdfjgbksdfmbvkdmksdgpijriogjeriojgkdsfmbksdfjbpidjgpioeragjipbmkpdsfjbpidfj ifmikmdfbmidpfjbidfmbdkbmkdfmbipdfjbi odfjbikdfmbkdfmbikdfmbipodfbmikfdmbkdfmbkdfmbkfdmblf rhlkrphkmhbkdfmbkdsfkbipdfjbijdigjisdfjgbksdfmbvkdmksdgpijriogjeriojgkdsfmbksdfjbpidjgpioeragjipbmkpdsfjbpidfj ifmikmdfbmidpfjbidfmbdkbmkdfmbipdfjbiodfjbikdfmbkdfmbikdfmbipodfbmikfdmbkdfmbkdfmbkfdmblfrhlkrphkmhbkdfmbkdsfkbipdfjbijdigjisdfjgbksdfmbvkdmksdgpijriogjeriojgkdsfmbksdfjbpidjgpioeragjipbmkpdsfjbpidfj ifmikmdfbmidpfjbidfmbdkb  cvx bv bv vhn nb b hgmyhuyluyuujjnmn,jykuyyk,yuityhkjuhggg" into "Q1"
    When I click "Save" button
    And I wait for 1 sec
    Then I verify that "000 UI Automation - Svetlana" is displayed on the list of quizzes
    And I wait for 3 sec
    And I delete "000 UI Automation - Svetlana" from the list of quizzes

    When I click "Create New Quiz" button
    And I wait for 1 sec
    When I type "000 UI Automation - Svetlana" as quiz title
    And I add a question
    When I select "Textual" question type
    When I enter "trhlkrphkmhbkdfmbkdsfkbipdfjbijdigjisdfjgbksdfmbvkdmksdgpijriogjeriojgkdsfmbksdfjbpidjgpioeragjipbmkpdsfjbpidfj ifmikmdfbmidpfjbidfmbdkbmkdfmbipdfjbiodfjbikdfmbkdfmbikdfmbipodfbmikfdmbkdfmbkdfmbkfdmblf rhlkrphkmhbkdfmbkdsfkbipdfjbijdigjisdfjgbksdfmbvkdmksdgpijriogjeriojgkdsfmbksdfjbpidjgpioeragjipbmkpdsfjbpidfj ifmikmdfbmidpfjbidfmbdk bmkdfmbipdfjbiodfjbikdfmbkdfmbikdfmbipodfbmikfdmbkdfmbkdfmbkfdmblf rhlkrphkmhbkdfmbkdsfkbipdfjbijdigjisdfjgbksdfmbvkdmksdgpijriogjeriojgkdsfmbksdfjbpidjgpioeragjipbmkpdsfjbpidfj ifmikmdfbmidpfjbidfmbdkbmkdfmbipdfjbi odfjbikdfmbkdfmbikdfmbipodfbmikfdmbkdfmbkdfmbkfdmblf rhlkrphkmhbkdfmbkdsfkbipdfjbijdigjisdfjgbksdfmbvkdmksdgpijriogjeriojgkdsfmbksdfjbpidjgpioeragjipbmkpdsfjbpidfj ifmikmdfbmidpfjbidfmbdkbmkdfmbipdfjbiodfjbikdfmbkdfmbikdfmbipodfbmikfdmbkdfmbkdfmbkfdmblfrhlkrphkmhbkdfmbkdsfkbipdfjbijdigjisdfjgbksdfmbvkdmksdgpijriogjeriojgkdsfmbksdfjbpidjgpioeragjipbmkpdsfjbpidfj ifmikmdfbmidpfjbidfmbdkb  cvx bv bv vhn nb b hgmyhuyluyuujjnmn,jykuyyk,yuityhkjuhggg" into "Q1"
    When I click "Save" button
    And I wait for 1 sec
    Then I verify that "000 UI Automation - Svetlana" is not displayed on the list of quizzes
    And I wait for 3 sec
    And I delete "000 UI Automation - Svetlana" from the list of quizzes

  @quiz6

  Scenario: Create a Quiz (Happy Path)
    When I click "Create New Quiz" button
    And I wait for 1 sec
    When I type "000 UI Automation - Svetlana" as quiz title
    And I add a question
    When I select "Textual" question type
    When I enter "Question 1 Text" into "Q1"
    When I click "Save" button
    And I wait for 1 sec
    Then I verify that "000 UI Automation - Svetlana" is displayed on the list of quizzes
    And I wait for 3 sec
    And I delete "000 UI Automation - Svetlana" from the list of quizzes


