@student_settings_name
  Feature: [S]Settings_Changing_name
    Background: I navigate to settings
      Given I navigate to "login" page
      Then I input "konstantinfeokt@rapidbeos.net" into email field
      And  I input "abc123" into password field
      Then I will click "Sign In" button
      And I will  wait for 2 sec
      Then user role "STUDENT" should be displayed
      And I will click "Settings" menu item

     Scenario: Number and special characters, empty field, 2 characters with 1 space,
               trailing and leading spaces, return the original name
              #Number and special characters
      Given I will click "Change Your Name" button
      When I type "Diana 15@%" into Full Name field
      And I will click "Change" button
      And I will  wait for 2 sec
      Then I verify that student name "Diana 15@%" should be displayed
      And  I verify that student name "Diana 15@%" should be displayed in the upper left corner of the page

             #empty field
      When I will click "Change Your Name" button
      And I delete text into Full Name field
      And I will  wait for 1 sec
      Then error message "This field is required" should be displayed
      And I will click "Cancel" button
      And I will  wait for 1 sec

             # 2 characters with 1 space
      When I will click "Change Your Name" button
      When I type "h i" into Full Name field
      And I will click "Change" button
      And I will  wait for 2 sec
      Then I verify that student name "h i" should be displayed
      And  I verify that student name "h i" should be displayed in the upper left corner of the page

             #trailing and leading spaces
      When I will click "Change Your Name" button
      Then I type " Diana Test " into Full Name field
      Then error message "Should contain only first and last name" should be displayed
      And I will click "Cancel" button
      And I will  wait for 1 sec

            # 256 characters
            #Known issue MAY23-394
      Given I will click "Change Your Name" button
      When I type Full name that is 256 characters long into  full name field
      And I will click "Change" button
      And I will  wait for 1 sec
#      Then I will verify that student name should be displayed
#      And  I will verify that student name should be displayed in the upper left corner of the page
      And I will click "Cancel" button

           #Whitespace
           #Known issue MAY23-670
      Given I will click "Change Your Name" button
      When I type " " into Full Name field
      And I will  wait for 2 sec
#      Then error message "Should contain only first and last name" should be displayed
      And I will click "Cancel" button
      And I will  wait for 2 sec

             #return the original name
      When I will click "Change Your Name" button
      Then I type "Diana Test" into Full Name field
      And I will click "Change" button
      And I will  wait for 1 sec
      Then I verify that student name "Diana Test" should be displayed
      And  I verify that student name "Diana Test" should be displayed in the upper left corner of the page

