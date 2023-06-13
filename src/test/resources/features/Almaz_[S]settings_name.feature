@student_settings_name
  Feature: [S]Settings_Changing_name
    Background: I navigate to settings
      Given I navigate to "login" page
      Then I input "konstantinfeokt@rapidbeos.net" into email field
      And  I input "abc123" into password field
      Then I will click "Sign In" button
      And I will  wait for 2 sec
      And I will click "Settings" menu item


      Scenario: Number and special characters,  empty field
        #Number and special characters
      Given I will click "Change Your Name" button
      And I will  wait for 2 sec
      When I type "Diana 15@%" into Full Name field
      And I will  wait for 2 sec
      And I clicked "Change" button
      And I will  wait for 2 sec
      Then element with xpath "//td[contains(text(),'Diana 15@%')]" should contain text "Diana 15@%"
      And element with xpath "//h3[contains(text(),'Diana 15@%')]" should contain text "Diana 15@%"
        #empty field
      When I will click "Change Your Name" button
      And I delete text into Full Name field
#     And I will click to element with xpath "//span[text()='Change']"
#     And I will click to element with xpath "//h1[@class='mat-dialog-title']"
#     And I type "" into Full Name field
      And I will  wait for 2 sec
      Then element with xpath "//mat-error[contains(text(), 'This field is required')]" should contain text "This field is required"
      And I will click "Cancel" button
      And I will  wait for 3 sec
        #2 characters with 1 space
      When I will click "Change Your Name" button
      And I will  wait for 2 sec
      When I type "h i" into Full Name field
      And I will  wait for 2 sec
      And I clicked "Change" button
      And I will  wait for 2 sec
      Then element with xpath "//td[contains(text(),'h i')]" should contain text "h i"
      And element with xpath "//h3[contains(text(),'h i')]" should contain text "h i"

        #trailing and leading spaces
      When I will click "Change Your Name" button
      And I will  wait for 2 sec
      Then I type " Diana Test " into Full Name field
      And I will  wait for 2 sec
      Then element with xpath "//mat-error[contains(text(), 'Should contain only first and last name')]" should contain text "Should contain only first and last name"
      And I will click "Cancel" button
      And I will  wait for 3 sec




        #return the original name
      When I will click "Change Your Name" button
      And I will  wait for 2 sec
      Then I type "Diana Test" into Full Name field
      And I clicked "Change" button
      And I will  wait for 2 sec
      Then element with xpath "//td[contains(text(),'Diana Test')]" should contain text "Diana Test"
      And element with xpath "//h3[contains(text(),'Diana Test')]" should contain text "Diana Test"



    Scenario: 256 characters
        Given I will click "Change Your Name" button
        And I will  wait for 2 sec
        When I type "Helloooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo Hellooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo" into Full Name field
        And I will  wait for 2 sec
        And I clicked "Change" button
        And I will  wait for 2 sec
        Then element with xpath "//td[contains(text(),'Hello')]" should contain text "Helloooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo Hellooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo"
        And element with xpath "//h3[contains(text(),'Hello')]" should contain text "Helloooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo Hellooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooooo"

    Scenario: Whitespace
      Given I will click "Change Your Name" button
      And I will  wait for 2 sec
      When I type " " into Full Name field
      And I will  wait for 2 sec
      Then element with xpath "//mat-error[contains(text(), 'This field is required')]" should contain text "This field is required"
      And I will click "Cancel" button
      And I will  wait for 3 sec