@changeUserName

  Feature: Change User Name Scenarios
    Background:
      Given I navigate to "login" page
      Then I type "codyhyre@jobstoknow.com" into email input field
      And I type "12345" into password input field
      Then I click on "Sign In" button
      And I wait for 2 sec
      And I pick "Users Management" menu item
      Then I wait for 2 sec

    @changeUserNameStudent
    Scenario: Change student name
      And I click on "Students" tab
      And I wait for 2 sec
      Then I click on "Natallia Stud1" name
      And I wait for 1 sec
      And I click on "Options"
      And I wait for 5 sec
      Then I click on "Change User's Name" from settings menu
      And I wait for 5 sec
      Then I erase name field
      And I wait for 2 sec
      Then I type "Alena Natallia" in full name field
      And I click on "Change" button
      And I wait for 2 sec
      Then I verify that a new name "Alena Natallia" displays

    @changeNameMaxStud
    Scenario: Verify Max 100 Alphanumeric and Sp Characters input for student
     #Requerements: Max 256 characters including 1 space between two words; App: Max 100 characters????
      And I click on "Students" tab
      And I wait for 2 sec
      Then I click on " " name
      And I wait for 1 sec
      And I click on "Options"
      And I wait for 5 sec
      Then I click on "Change User's Name" from settings menu
      And I wait for 5 sec
      Then I erase name field
      And I wait for 2 sec
      Then I type "sdhgajfgadsjkhfj87364287*&*^&%^ %%&^*&FGFHFHGDRFJHG&^&%657656465vbvhvhghfhgfghfhgfhgfhgfghf56565@@#$" in full name field
      And I wait for 5 sec
      And I click on "Change" button
      And I wait for 2 sec
      Then I verify that a new name "sdhgajfgadsjkhfj87364287*&*^&%^ %%&^*&FGFHFHGDRFJHG&^&%657656465vbvhvhghfhgfghfhgfhgfhgfghf56565@@#$" displays

    @changeNameMaxPlusOneStud
    Scenario: Verify Max 100+1 Alphanumeric and Sp Characters is not acceptable for student name
      And I click on "Students" tab
      And I wait for 2 sec
      Then I click on "Alena Alena12" name
      And I wait for 1 sec
      And I click on "Options"
      And I wait for 5 sec
      Then I click on "Change User's Name" from settings menu
      And I wait for 5 sec
      Then I erase name field
      And I wait for 2 sec
      Then I type special string 50 characters before and 50 after space in full name field
      And I wait for 5 sec
      And I click on "Change" button
      And I wait for 2 sec
      Then I verify that the error message "Should no more than 100 characters" is displayed
      
    @changeNameMinStud
    Scenario: Verify Min 2 Characters And 1 space between input for student
      And I click on "Students" tab
      And I wait for 2 sec
      Then I click on "Natallia newStudent" name
      And I wait for 1 sec
      And I click on "Options"
      And I wait for 5 sec
      Then I click on "Change User's Name" from settings menu
      And I wait for 5 sec
      Then I erase name field
      And I wait for 2 sec
      Then I type "B A" in full name field
      And I wait for 5 sec
      And I click on "Change" button
      And I wait for 2 sec
      Then I verify that a new name "B A" displays

    @changeNameLessMinStud
    Scenario: Verify 1 Characters And 1 space between input is not allowed for student
      #Test fails the field is accepted less then 2 characters
      And I click on "Students" tab
      And I wait for 2 sec
      Then I click on "N " name
      And I wait for 1 sec
      And I click on "Options"
      And I wait for 5 sec
      Then I click on "Change User's Name" from settings menu
      And I wait for 5 sec
      Then I erase name field
      And I wait for 2 sec
      Then I type "A " in full name field
      And I wait for 5 sec
      And I click on "Change" button
      And I wait for 4 sec
      Then I verify that the error message is displayed

    @changeNameLeadingSpStud
    Scenario: Verify leading spaces are not allowed for student
      #Test fails the field is accepted leading spaces
      And I click on "Students" tab
      And I wait for 2 sec
      Then I click on "N " name
      And I wait for 1 sec
      And I click on "Options"
      And I wait for 5 sec
      Then I click on "Change User's Name" from settings menu
      And I wait for 5 sec
      Then I erase name field
      And I wait for 2 sec
      Then I type " non" in full name field
      And I wait for 5 sec
      And I click on "Change" button
      And I wait for 4 sec
      Then I verify that the error message is displayed

    @changeNameTrailingSpStud
    Scenario: Verify Trailing Spaces Are Not Allowed For Student
      And I click on "Students" tab
      And I wait for 2 sec
      Then I click on " non" name
      And I wait for 1 sec
      And I click on "Options"
      And I wait for 5 sec
      Then I click on "Change User's Name" from settings menu
      And I wait for 5 sec
      Then I erase name field
      And I wait for 2 sec
      Then I type "Mf g " in full name field
      And I wait for 5 sec
      And I click on "Change" button
      And I wait for 4 sec
      Then I verify that the error message is displayed

    @changeNameWhiteSpStud
    Scenario: Verify White Spaces Are Not Allowed For Student
      #Test fails the field is accepted white spaces erase the name FEB-304
      And I click on "Students" tab
      And I wait for 2 sec
      Then I click on " " name
      And I wait for 1 sec
      And I click on "Options"
      And I wait for 5 sec
      Then I click on "Change User's Name" from settings menu
      And I wait for 5 sec
      Then I erase name field
      And I wait for 2 sec
      Then I type " " in full name field
      And I wait for 5 sec
      And I click on "Change" button
      And I wait for 4 sec
      Then I verify that the error message is displayed

    @changeNameEmptyStud
    Scenario: Verify The Field Is Required Student
      #Doesn't show message but does from UI
      And I click on "Students" tab
      And I wait for 2 sec
      Then I click on "Svetka Svetka" name
      And I wait for 1 sec
      And I click on "Options"
      And I wait for 5 sec
      Then I click on "Change User's Name" from settings menu
      And I wait for 5 sec
      Then I erase name field
      And I wait for 2 sec
      Then I click on "Change" button
      And I wait for 5 sec
      Then I verify that the error message "This field is required" is displayed

#same checks for teacher's name field

    @changeUserNameTeacher
    Scenario: Change teacher name
      And I click on "Teachers" tab
      And I wait for 2 sec
      Then I click on "Natallia Teach4" name
      And I wait for 1 sec
      And I click on "Options"
      And I wait for 5 sec
      Then I click on "Change User's Name" from settings menu
      And I wait for 5 sec
      Then I erase name field
      And I wait for 2 sec
      Then I type "Alena Natallia12" in full name field
      And I click on "Change" button
      And I wait for 2 sec
      Then I verify that a new name "Alena Natallia12" displays

    @changeNameMaxTeacher
    Scenario: Verify Max 100 Alphanumeric and Sp Characters Input For Teacher
      And I click on "Teachers" tab
      And I wait for 2 sec
      Then I click on "Alena Natallia12" name
      And I wait for 1 sec
      And I click on "Options"
      And I wait for 5 sec
      Then I click on "Change User's Name" from settings menu
      And I wait for 5 sec
      Then I erase name field
      And I wait for 2 sec
      Then I type "sdhgajfgadsjkhfj87364287*&*^&%^ %%&^*&FGFHFHGDRFJHG&^&%657656465vbvhvhghfhgfghfhgfhgfhgfghf56565@@#$" in full name field
      And I wait for 5 sec
      And I click on "Change" button
      And I wait for 2 sec
      Then I verify that a new name "sdhgajfgadsjkhfj87364287*&*^&%^ %%&^*&FGFHFHGDRFJHG&^&%657656465vbvhvhghfhgfghfhgfhgfhgfghf56565@@#$" displays

    @changeNameMaxPlusOneTeacher
    Scenario: Verify Max 100+1 Alphanumeric And Sp Characters Is Not Acceptable For Student Name
      And I click on "Teachers" tab
      And I wait for 2 sec
      Then I click on "Alena Natallia12" name
      And I wait for 1 sec
      And I click on "Options"
      And I wait for 5 sec
      Then I click on "Change User's Name" from settings menu
      And I wait for 5 sec
      Then I erase name field
      And I wait for 2 sec
      Then I type special string 50 characters before and 50 after space in full name field
      And I wait for 5 sec
      And I click on "Change" button
      And I wait for 2 sec
      Then I verify that the error message "Should no more than 100 characters" is displayed

    @changeNameMinTeacher
    Scenario: Verify Min 2 Characters And 1 Space Between Input For Student
      And I click on "Teachers" tab
      And I wait for 2 sec
      Then I click on "Change-Name" name
      And I wait for 1 sec
      And I click on "Options"
      And I wait for 5 sec
      Then I click on "Change User's Name" from settings menu
      And I wait for 5 sec
      Then I erase name field
      And I wait for 2 sec
      Then I type "S A" in full name field
      And I wait for 5 sec
      And I click on "Change" button
      And I wait for 2 sec
      Then I verify that a new name "S A" displays

    @changeNameLessMinTeacher
    Scenario: Verify 1 Characters And 1 Space Between Input Is Not Allowed For Student
      #Test fails the field is accepted less then 2 characters
      And I click on "Teachers" tab
      And I wait for 2 sec
      Then I click on "sdhgajfgadsjkhfj87364287*&*^&%^ %%&^*&FGFHFHGDRFJHG&^&%657656465vbvhvhghfhgfghfhgfhgfhgfghf56565@@#$" name
      And I wait for 1 sec
      And I click on "Options"
      And I wait for 5 sec
      Then I click on "Change User's Name" from settings menu
      And I wait for 5 sec
      Then I erase name field
      And I wait for 2 sec
      Then I type "B " in full name field
      And I wait for 5 sec
      And I click on "Change" button
      And I wait for 4 sec
      Then I verify that the error message is displayed

    @changeNameLeadingSpTeachers
    Scenario: Verify Leading Spaces Are Not Allowed For Teacher
      #Test fails the field is accepted leading spaces
      And I click on "Teachers" tab
      And I wait for 2 sec
      Then I click on "S A" name
      And I wait for 1 sec
      And I click on "Options"
      And I wait for 5 sec
      Then I click on "Change User's Name" from settings menu
      And I wait for 5 sec
      Then I erase name field
      And I wait for 2 sec
      Then I type " Leading" in full name field
      And I wait for 5 sec
      And I click on "Change" button
      And I wait for 4 sec
      Then I verify that the error message is displayed

    @changeNameTrailingSpTeacher
    Scenario: Verify Trailing Spaces Are Not Allowed For Teacher
      And I click on "Teachers" tab
      And I wait for 2 sec
      Then I click on " Leading" name
      And I wait for 1 sec
      And I click on "Options"
      And I wait for 5 sec
      Then I click on "Change User's Name" from settings menu
      And I wait for 5 sec
      Then I erase name field
      And I wait for 2 sec
      Then I type "Trailing T " in full name field
      And I wait for 5 sec
      And I click on "Change" button
      And I wait for 4 sec
      Then I verify that the error message is displayed

    @changeNameWhiteSpTeacher
    Scenario: Verify White Spaces Are Not Allowed For Teachers
      #Test fails the field is accepted white spaces erase the name FEB-304
      And I click on "Teachers" tab
      And I wait for 2 sec
      Then I click on " Leading" name
      And I wait for 1 sec
      And I click on "Options"
      And I wait for 5 sec
      Then I click on "Change User's Name" from settings menu
      And I wait for 5 sec
      Then I erase name field
      And I wait for 2 sec
      Then I type " " in full name field
      And I wait for 5 sec
      And I click on "Change" button
      And I wait for 4 sec
      Then I verify that the error message is displayed

    @changeNameEmptyTeacher
    Scenario: Verify The Field Is Required Teacher
      #Doesn't show message but does from UI
      And I click on "Teachers" tab
      And I wait for 2 sec
      Then I click on "Svetka Svetka" name
      And I wait for 1 sec
      And I click on "Options"
      And I wait for 5 sec
      Then I click on "Change User's Name" from settings menu
      And I wait for 5 sec
      Then I erase name field
      And I wait for 2 sec
      Then I click on "Change" button
      And I wait for 5 sec
      Then I verify that the error message "This field is required" is displayed


 


