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
      And I type "Banana Quiz" as quiz title
      When I add a question
      And I select "Textual" question type
      When I type question text "Banana Question1" into "Q1"
      And I wait for 3 sec
      When I click on "Save" button
      And I wait for 3 sec
      Then quiz "Banana Quiz" should be displayed on the list of quizzes
      And I wait for 2 sec
      And I delete "Banana Quiz" from the list of quizzes
      And I wait for 1 sec

    @textual
    Scenario Outline: Create a Textual Question - parameterized
      When I click on "Create New Quiz" button
      And I wait for 2 sec
      And I type "Banana Quiz" as quiz title
      When I add a question
      And I select "Textual" question type
      When I type question text <questionText> into <qestionNum>
      And I wait for 2 sec
      When I click on <btnName1> button
      And I wait for 3 sec
      Then quiz "Banana Quiz" should be displayed on the list of quizzes
      And I wait for 2 sec
      And I delete "Banana Quiz" from the list of quizzes
      And I wait for 1 sec
      Examples:
       | questionText                       | qestionNum | btnName1 |
       | "Banana Question1"                 | "Q1"       | "Save"   |
       | "a"                                | "Q1"       | "Save"   |
       | "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc aliquam ante id magna dictum, volutpat suscipit odio blandit. Donec dictum diam dolor, non sagittis mi rutrum ut. Mauris accumsan massa eget tellus viverra, sed porta magna cursus. Maecenas laoreet diam tellus, at aliquam ante lobortis ac. Nulla vel elit vel erat accumsan feugiat. Curabitur pharetra bibendum eleifend. Donec ac laoreet metus, vitae pharetra magna. Phasellus condimentum ligula tortor, a dictum risus eleifend quis. Etiam sit amet suscipit lacus. Nunc a tincidunt lectus, eu aliquet mauris. Praesent efficitur mollis velit, vel finibus nunc sagittis a. Duis massa turpis, laoreet eu vulputate nec, sollicitudin quis tortor. Duis mollis imperdiet lectus eu posuere. Cras eu ultricies massa. Phasellus mollis pharetra pulvinar. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Nullam elit nulla, luctus in est vel, maximus volutpat orci. Vestibulum molestie urna vitae consectet" | "Q1"       | "Save"   |
       | "ADFvhu&)%@oN;]350/Qgk Wq@&^.mnb"  | "Q1"       | "Save"   |


    @textual2
    Scenario: Verify error messages for Textual question - text
      When I click on "Create New Quiz" button
      And I wait for 2 sec
      And I type "Banana Quiz" as quiz title
      When I add a question
      And I select "Textual" question type
      When I type question text "" into "Q1"
      And I wait for 1 sec
      When I click on "Save" button
      And I wait for 1 sec
      Then error message "This field is required" should be displayed

    @textual3
    Scenario Outline: Verify error messages for Textual question - text parameterized
      When I click on "Create New Quiz" button
      And I wait for 2 sec
      And I type "Banana Quiz" as quiz title
      When I add a question
      And I select "Textual" question type
      When I type question text <questionText> into <qestionNum>
      And I wait for 1 sec
      When I click on "Save" button
      And I wait for 1 sec
      Then error message <errorMess> should be displayed
      Examples:
       | questionText | qestionNum | errorMess                |
       | ""           | "Q1"       | "This field is required" |

   # Known issue max + 1 characters ASKJ-324
       | "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Nunc aliquam ante id magna dictum, volutpat suscipit odio blandit. Donec dictum diam dolor, non sagittis mi rutrum ut. Mauris accumsan massa eget tellus viverra, sed porta magna cursus. Maecenas laoreet diam tellus, at aliquam ante lobortis ac. Nulla vel elit vel erat accumsan feugiat. Curabitur pharetra bibendum eleifend. Donec ac laoreet metus, vitae pharetra magna. Phasellus condimentum ligula tortor, a dictum risus eleifend quis. Etiam sit amet suscipit lacus. Nunc a tincidunt lectus, eu aliquet mauris. Praesent efficitur mollis velit, vel finibus nunc sagittis a. Duis massa turpis, laoreet eu vulputate nec, sollicitudin quis tortor. Duis mollis imperdiet lectus eu posuere. Cras eu ultricies massa. Phasellus mollis pharetra pulvinar. Pellentesque habitant morbi tristique senectus et netus et malesuada fames ac turpis egestas. Nullam elit nulla, luctus in est vel, maximus volutpat orci. Vestibulum molestie urna vitae consectetd"           | "Q1"       | "Should not accept more than 1000 characters" |

   # Known issues Allows empty input by using space character ASKJ-327
       | "  "           | "Q1"       | "This field is required" |



