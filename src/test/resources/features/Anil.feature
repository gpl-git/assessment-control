@ASK-WebApp
  Feature: ASK Web App

    @LoginTest
    Scenario: Login Test
      Given I open the url "http://ask-qa.portnov.com/#/login"
      Then I should see the page title as "Assessment Control @ Portnov"
      When I click on the element with xpath "//input[@formcontrolname='email']"
      And I click on the element with xpath "//input[@formcontrolname='password']"
      Then I should see the message that "This field is required" into the element with xpath "//mat-error[contains(text(),'This field')]"
      When I type "abc" into the element with xpath "//input[@formcontrolname='email']"
      Then I should see the message that "Should be a valid email address" into the element with xpath "//mat-error[contains(text(),'Should be')]"
      When I clear the element with xpath "//input[@formcontrolname='email']"
      And I type "ask_instr@aol.com" into the element with xpath "//input[@formcontrolname='email']"
      And I click on the element with xpath "//span[contains(text(),'Sign In')]"
      Then I should see the message that "This field is required" into the element with xpath "//mat-error[contains(text(),'This field')]"
      When I type "12345" into the element with xpath "//input[@formcontrolname='password']"
      And I click on the element with xpath "//span[contains(text(),'Sign In')]"
      And I wait 2 sec
      Then I should see the message that "Galina Teacher" into the element with xpath "//header/div[1]"
      Then I print the text on the element with xpath "//ac-home-teacher[@class='ng-star-inserted']"






