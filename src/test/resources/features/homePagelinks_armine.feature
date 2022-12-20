@homepage

  Feature: Home Page Links

    @homepageTeacher1
   Scenario: Verify Home Page links for TEACHER
      Given I navigate to "login" page AH
      When I type "ask_instr@aol.com" into email input field AH
      And I type "12345" into password field AH
      When I click "Sign In" button AH
      And I wait for 2 sec AH
      When I click "Quizzes" current url contains "quizzes"


    @homepageTeacherOutline2
    Scenario Outline: Verify Hoime Page links for TEACHER - Outline
      Given I navigate to "login" page AH
      When I type "ask_instr@aol.com" into email input field AH
      And I type "12345" into password field AH
      When I click "Sign In" button AH
      And I wait for 2 sec AH
      When I click <menuItems> current url contains <curUrl>
      Examples:
        | menuItems | curUrl    |
        | "Home" | "home" |
        | "Submissions" | "submissions" |
        | "Assignments" | "assignments" |
        | "Quizzes" | "quizzes" |
        | "Users" | "users" |
        | "Settings" | "settings" |

     @homepageStudentOutline3
     Scenario Outline: Verify Home Page links for STUDENT
       Given I navigate to "login" page AH
       When I type "cdbell81@bemersky.com" into email input field AH
       And I type "123456" into password field AH
       When I click "Sign In" button AH
       And I wait for 2 sec AH
       When I click <menuItems> current url contains <curUrl>
       Examples:
         | menuItems | curUrl    |
         | "Home" | "home" |
         | "My Assignments" | "assignments" |
         | "My Grades" | "grades" |
         | "Settings" | "settings" |


    @homepageTeacher4
    Scenario: Verify that clicking log out button opens confirmation window
    Given I navigate to "login" page AH
      When I type "ask_instr@aol.com" into email input field AH
      And I type "12345" into password field AH
      When I click "Sign In" button AH
      And I click "Log Out" menu item
      And I click "Log Out" button in Confirmation

     @homepageStudent5
     Scenario: Verify that clicking log out button opens confirmation window
       Given I navigate to "login" page AH
       When I type "cdbell81@bemersky.com" into email input field
       And I type "123456" into password field AH
       When I click "Sign In" button AH

       And I click "Log Out" menu item              
       And I click "Log Out" button in Confirmation


