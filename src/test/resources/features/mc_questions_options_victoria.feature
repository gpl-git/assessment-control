  @multiple_choice_question_options

  Feature: Multiple Choice Question - Options Scenarios
    Background:
      Given I go to "login" page
      When I type "qa@ask.com" into email field
      And I type "12345" into password field
      When  I click "Sign In" button
      And I wait for 1 sec
      When I click "Quizzes" link
      And I wait for 1 sec

    @multiple_choice_options_1
    Scenario: Multiple Choice Question - Options generated automatically
      # Related Jira Ticket: DEC-446 Options generated automatically
      When I click "Create New Quiz" button vk
      And I wait for 1 sec
      And I type "MC Question - Add Option (vica Jan 25)" as the quiz title vk
      And I add a question vk
      And I wait for 3 sec
      And I select "Multiple-Choice" question type vk
      And I wait for 2 sec
      Then I verify that "checkbox" element is present vk
      And I verify that option 1 is added vk
      And I verify that option 2 is added vk

    @multiple_choice_options_2
    Scenario: Multiple Choice Question - Add Options
      # Related Jira Ticket: DEC-447 Add Options
      When I click "Create New Quiz" button vk
      And I wait for 1 sec
      And I type "MC Question - Add Option (vica Jan 25)" as the quiz title vk
      And I add a question vk
      And I wait for 2 sec
      And I select "Multiple-Choice" question type vk
      And I wait for 2 sec
      Then I verify that "checkbox" element is present vk
      When I click "Add Option" button vk
      And I wait for 3 sec
      Then I verify that option 3 is added vk

    @multiple_choice_options_3
    Scenario: Multiple Choice Question - Unable to delete auto-generated options
      # Related Jira Ticket: DEC-447 Delete "Automatically Generated" option
      When I click "Create New Quiz" button vk
      And I wait for 1 sec
      And I type "MC Question - Add Option (vica Jan 25)" as the quiz title vk
      And I add a question vk
      And I wait for 3 sec
      And I select "Multiple-Choice" question type vk
      And I wait for 1 sec
      Then I verify that "checkbox" element is present vk
      When I click on settings next to option 1
      And I wait for 1 sec
      Then I verify that "Delete Option" is disabled
      And I wait for 2 sec
      When I click on settings next to option 2
      And I wait for 2 sec
      Then I verify that "Delete Option" is disabled
      And I wait for 2 sec

    @multiple_choice_options_4
    Scenario: Multiple Choice Question - Can delete added option
      # Related Jira Ticket: DEC-510 Delete "Added Options"
      When I click "Create New Quiz" button vk
      And I wait for 1 sec
      And I type "MC Question - Add Option (vica Jan 25)" as the quiz title vk
      And I add a question vk
      And I wait for 3 sec
      And I select "Multiple-Choice" question type vk
      Then I verify that "checkbox" element is present vk
      When I click "Add Option" button vk
      And I wait for 1 sec
      When I click on settings next to option 3
      And I wait for 1 sec
      When I click "Delete Option" button vk
      And I wait for 3 sec
      Then I verify that "checkbox" element is present vk
      And I verify that only 2 options left in a question










