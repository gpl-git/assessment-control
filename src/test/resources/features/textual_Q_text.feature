@textual
  Feature: Textual Question - Text

    Background:
      Given I go to "login" page
      When I type "ask_instr@aol.com" into email field
      And I type "12345" into password field
      When I click on "Sign In" button
      And I wait for 1 sec
      Then I verify current url as "home"
      When I click on "Quizzes" tab
      And I wait for 1 sec

    @textual1
    Scenario: Create a Textual Question
      When I click on "Create New Quiz" button
      And I wait for 2 sec
      And I type "Elvira Quiz" as quiz title
      When I add a question
      And I select "Textual" question type
      When I type question text "Elvira's Question1" into "Q1"
      And I wait for 3 sec
      And I click on save button
      And I wait for 1 sec


    @textual2
    Scenario: Verify that field is required
      When I click on "Create New Quiz" button
      And I wait for 2 sec
      And I type "Elvira Quiz" as quiz title
      When I add a question
      And I select "Textual" question type
      And I click on save button
      And I wait for 1 sec
      Then error message "This field is required" should be displayed

    @textual3
    Scenario: Verify min 1 character
      When I click on "Create New Quiz" button
      And I wait for 2 sec
      And I type "Elvira Quiz" as quiz title
      When I add a question
      And I select "Textual" question type
      When I type question text "a" into "Q1"
      And I wait for 3 sec
      And I click on save button
      And I wait for 1 sec

    @textual4
    Scenario: Verify max 1000 characters
      When I click on "Create New Quiz" button
      And I wait for 2 sec
      And I type "Elvira Quiz" as quiz title
      When I add a question
      And I select "Textual" question type
      When I type question text "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc aliquam ante id magna dictum, volutpat suscipit odio blandit. Donec dictum diam dolor, non sagittis mi rutrum ut. Mauris accumsan massa eget tellus viverra, sed porta magna cursus. Maecenas laoreet diam tellus, at aliquam ante lobortis ac. Nulla vel elit vel erat accumsan feugiat. Curabitur pharetra bibendum eleifend. Donec ac laoreet metus, vitae pharetra magna. Phasellus condimentum ligula tortor, a dictum risus eleifend quis. Etiam sit amet suscipit lacus. Nunc a tincidunt lectus, eu aliquet mauris. Praesent efficitur mollis velit, vel finibus nunc sagittis a. Duis massa turpis, laoreet eu vulputate nec, sollicitudin quis tortor. Duis mollis imperdiet lectus eu posuere. Cras eu ultricies massa. Phasellus mollis pharetra pulvinar. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Nullam elit nulla, luctus in est vel, maximus volutpat orci. Vestibulum molestie urna vitae consectet" into "Q1"
      And I wait for 3 sec
      And I click on save button
      And I wait for 1 sec

    @textual5
    Scenario: Verify allowable characters: Alphanumeric & Sp. characters
      When I click on "Create New Quiz" button
      And I wait for 2 sec
      And I type "Elvira Quiz" as quiz title
      When I add a question
      And I select "Textual" question type
      When I type question text "ADFvhu&)%@oN;]350/Qgk Wq@&^.mnb" into "Q1"
      And I wait for 3 sec
      And I click on save button
      And I wait for 1 sec