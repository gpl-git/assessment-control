@quiz_purnima @text
  Feature: Quiz new scenarios
    Background:
      Given I go to "login" pages
      When I type "ttoone@btcmod.com" into email fields
      When I type "12345" into password fields
      When I click "Sign In" buttons
      Then I wait for 1 secs
      When I click "Quizzes" menu items
      Then I wait for 2 secs

@quiz_text_showstopper
Scenario: Create a quiz with textual showstopper
  When I click "Create New Quiz" buttons
  Then I wait for 2 secs
  Then I type "Purnima Textual Showstopper Automation" as title
  And  I add one question
  When I select "Textual" question types
  Then I wait for 2 secs
  #didnt quite understand this step so just copied from classwork.
  When I enter "question text" intextbox "Q1"
  #didint quite understand this step so just copied from classwork.
  When I select "Stopper" option "Q1"
  When I click "Save" buttons
  Then I wait for 2 secs
  Then I verify "Purnima Textual Showstopper" is displayed in the list
  Then I wait for 2 secs
 # And I delete "Purnima Textual Showstopper" from the list



  