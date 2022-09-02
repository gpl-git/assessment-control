@registration_email
  Feature: Verify Registration Email field behavior

    Background:
      Given I go to "registration" page
      Then I type "snehal" in the field with xpath "//input[@formcontrolname='firstName']"
      Then I type "Shaha" in the field with xpath "//input[@formcontrolname='lastName']"
      Then I type "abc" in the field with xpath "//input[@formcontrolname='group']"
      Then I type "12345" in the field with xpath "//input[@formcontrolname='password']"
      Then I type "12345" in the field with xpath "//input[@formcontrolname='confirmPassword']"

    @registration_email1
    Scenario: Verify Registration-Email Field Behavior With Valid Email
      Then I type "abc@abc.com" in the field with xpath "//input[@formcontrolname='email']"
      Then I click on the "Register Me" button
      And I wait for 3 sec
      And I verify that the user has been registered
      And I wait for 2 sec

    @registration_email2
    Scenario: Invalid Email
      Then I type " 1uyt12345678yy!#$%^&*yyjjjjjjjydrftgyhYTRFVyyyyyrtrtrrtrtrtrtrtr@1uyt123456yjjjjjjjydrftgyhYTRFVyyyyyrtrtrrtrtrtrtrt.tyuiopppppi" in the field with xpath "//input[@formcontrolname='email']"
      And I click on the "Register Me" button
      And I verify that "Should be a valid email address" is displayed on the mat-form
      And I wait for 2 sec

    @registration_email3
    Scenario: Blank email field
      Then I clear the field with xpath "//input[@formcontrolname='email']"
      Then I click on the "Register Me" button
      And I wait for 2 sec
      And I verify that "This field is required" is displayed on the mat-form
      And I wait for 2 sec








