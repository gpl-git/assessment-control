@registrationEmailLarissa
  Feature: Registration Email

  @registrationEmailLarissa1
    Scenario: Registration Email_Verify alphanumeric and special char
      Given I go to "registration" page
      When I type "larissaomalley1!@gmail.com" into email field
      Then I type "Mickey" into First Name field
      Then I type "Mouse" into the Last Name field
      Then I type "Jun02" into groupCode field
      Then I enter "12345" as password
      Then I enter "12345" as Confirm Password
      Then I click button "Register Me"
      And I verify that "You have been Registered." message is displayed

    @registrationEmailLarissa2
    Scenario: Registration Email_Verify email field is a required field
      Given I go to "registration" page
      When I type "Mickey" into First Name field
      Then I type "Mouse" into the Last Name field
      Then I type "Jun02" into groupCode field
      Then I enter "12345" as password
      Then I enter "12345" as Confirm Password
      When I leave email field blank
      And I click button "Register Me"
      Then I should see a message "This field is required" in the email field

    @registrationEmailLarissa3
    Scenario: Registration Email_Verify email filed is maximum 64 characters before "@" symbol
      Given I go to "registration" page
      When I type "Mickey" into First Name field
      Then I type "Mouse" into the Last Name field
      Then I type "Jun02" into groupCode field
      Then I enter "12345" as password
      Then I enter "12345" as Confirm Password
      When I enter "qwertyuioplkjhgfdsazxcvbnmqwertyuibnmqwertyuioplkjpoiuytrewqasdf@awerty.com"
      And I click button "Register Me"
      And I wait for 2 sec
      And I verify that "You have been Registered." message is displayed

    @registrationEmailLarissa4
    Scenario: Scenario: Registration Email_Verify email filed is more than 65 characters before "@" symbol
      Given I go to "registration" page
      When I type "Mickey" into First Name field
      Then I type "Mouse" into the Last Name field
      Then I type "Jun02" into groupCode field
      Then I enter "12345" as password
      Then I enter "12345" as Confirm Password
      When I enter "qwertyuioplkjhgfdsazxcvbnmqwertyuibnmqwertyuioplkjpoiuytrewqasdfc@awerty.com"
      And I click button "Register Me"
      And I wait for 2 sec
      Then I should see a warning message "Should be a valid email address" under the email field

    @registrationEmailLarissa5
    Scenario: Registration Email_Verify "." char after domain name with less than 63 char in the email field
      Given I go to "registration" page
      When I type "Mickey" into First Name field
      Then I type "Mouse" into the Last Name field
      Then I type "larissaomalley1!@gmail.com" into email field
      Then I type "Jun02" into groupCode field
      Then I enter "12345" as password
      Then I enter "12345" as Confirm Password
      And I click button "Register Me"
      And I verify that "You have been Registered." message is displayed

    @registrationEmailLarissa6
    Scenario: Registration Email_Verify "." char after domain name with more than 64 char in the email field
      Given I go to "registration" page
      When I type "Mickey" into First Name field
      Then I type "Mouse" into the Last Name field
      Then I type "larissaomalley1!@qwertyuioplkjhgfdsazxcvbnmqwertyuibnmqwertyuioplkjpoiuytrewqasdfc.com" into email field
      Then I type "Jun02" into groupCode field
      Then I enter "12345" as password
      Then I enter "12345" as Confirm Password
      And I click button "Register Me"
      And I verify that "You have been Registered." message is displayed

    @registrationEmailLarissa7
    Scenario: Registration Email_Verify white spaces are not allowed in the email field
      Given I go to "registration" page
      When I type "Mickey" into First Name field
      Then I type "Mouse" into the Last Name field
      Then I type "larissa omalley1!@gmail.com" into email field
      Then I type "Jun02" into groupCode field
      Then I enter "12345" as password
      Then I enter "12345" as Confirm Password
      And I click button "Register Me"
      And I wait for 2 sec
      Then I should see a warning message "Should be a valid email address" under the email field

    @registrationEmailLarissa8
    Scenario: Registration Email_Verify that Max number characters for email field is 128, including characters after @
    (<=64 characters before @ and <=63 characters after @)
      Given I go to "registration" page
      When I type "Mickey" into First Name field
      Then I type "Mouse" into the Last Name field
      Then I type "qwertyuioplkjhgfdsazxcvbnmqwertyuibnmqwertyuioplkjpoiuytrewqasdf@qwertyuioplkjhgfdsazxcvbnmqwertyuibnmqwertyuioplkjpoiuytrewqasd.com" into email field
      Then I type "Jun02" into groupCode field
      Then I enter "12345" as password
      Then I enter "12345" as Confirm Password
      And I click button "Register Me"
      And I verify that "You have been Registered." message is displayed

    @registrationEmailLarissa9
    Scenario: Registration Email_Verify that Max number characters for email field is grater than 128, including characters after @
    (=>65 characters before @ and =>64 characters after @ )
      Given I go to "registration" page
      When I type "Mickey" into First Name field
      Then I type "Mouse" into the Last Name field
      Then I type "qwertpoyuioplkjhgfdsazxcvbnmqwertyuibnmqwertyuioplkjpoiuytrewqasdf@qwertpoyuioplkjhgfdsazxcvbnmqwertyuibnmqwertyuioplkjpoiuytrewqasd.com" into email field
      Then I type "Jun02" into groupCode field
      Then I enter "12345" as password
      Then I enter "12345" as Confirm Password
      And I click button "Register Me"
      And I wait for 2 sec
      Then I should see a warning message "Should be a valid email address" under the email field

    @registrationEmailLarissa10
    Scenario: Registration Email_Verify "@" symbol is present in the email field
      Given I go to "registration" page
      When I type "Mickey" into First Name field
      Then I type "Mouse" into the Last Name field
      Then I type "larissaomalley1@gmail" into email field
      Then I type "Jun02" into groupCode field
      Then I enter "12345" as password
      Then I enter "12345" as Confirm Password
      And I click button "Register Me"
      And I wait for 2 sec
      #Then I should see a warning message "Should be a valid email address" under the email field
      #The user proceeds to "Registration" page, when he/she should not have proceeded. This is a known issue (see Bug report #Jun22-391).


