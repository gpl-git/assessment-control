@cucumber
Feature: Practice Cucumber Scenarios

  Background:
    Given I open url "https://skryabin.com/market/quote.html"
    Then I should see page title contains "Get a Quote"

  @cucumber01
  Scenario: Verify responsive UI Behavior
    When I resize window to 900 and 1440
    Then element with xpath "//b[@id='currentDate']" should be displayed
    When I resize window to 375 and 667
    Then element with xpath "//b[@id='currentDate']" should not be displayed

  @cucumber02
  Scenario: Validate Username field
    When I type "A" into element with xpath "//*[@name='username']"
    And I click on element with xpath "//*[@id='formSubmit']"
    Then element with xpath "//*[@id='username-error']" should be displayed
    When I clear element with xpath "//input[@name='username']"
    Then element with xpath "//*[@id='username-error']" should be displayed
    When I type "AB" into element with xpath "//input[@name='username']"
    Then element with xpath "//*[@id='username-error']" should not be displayed

  @cucumber03
  Scenario: Valid Email field
    When I type "a" into element with xpath "//input[@name='email']"
    And I click on element with xpath "//input[@name='password']"
    Then element with xpath "//label[@id='email-error']" should be displayed
    And I clear element with xpath "//input[@name='email']"
    When I type "a@f" into element with xpath "//input[@name='email']"
    And I click on element with xpath "//input[@name='password']"
    Then element with xpath "//label[@id='email-error']" should not be displayed

  @cucumber04
  Scenario: Verify Password fields
    Then element with xpath "//input[@id='confirmPassword']" should have attribute "disabled" as "true"
    When I type "1234" into element with xpath "//input[@id='password']"
    And I click on element with xpath "//input[@name='confirmPassword']"
    Then element with xpath "//input[@id='confirmPassword']" should not have attribute "disabled" as "true"
    And element with xpath "//label[text()='Please enter at least 5 characters.']" should be displayed
    When I clear element with xpath "//input[@id='password']"
    Then element with xpath "//label[text()='This field is required.']" should be displayed
    When I click on element with xpath "//input[@name='phone']"
    Then element with xpath "//input[@id='confirmPassword']" should have attribute "disabled" as "true"
    When I type "12345" into element with xpath "//input[@id='password']"
    Then element with xpath "//label[text()='Please enter at least 5 characters.']" should not be present
    And element with xpath "//label[text()='This field is required.']" should not be present
    When I type "123456" into element with xpath "//input[@id='confirmPassword']"
    And I click on element with xpath "//input[@name='phone']"
    Then element with xpath "//label[text()='Passwords do not match!']" should be displayed
    When I clear element with xpath "//input[@id='confirmPassword']"
    Then element with xpath "//label[text()='This field is required.']" should be displayed
    When I type "12345" into element with xpath "//input[@id='confirmPassword']"
    Then element with xpath "//label[text()='This field is required.']" should not be present

  @cucumber05
  Scenario: Validate Name Dialog
    When I click on element with xpath "//input[@id='name']"
    Then element with xpath "//div[@id='nameDialog']" should be displayed
    When I type "a" into element with xpath "//input[@id='firstName']"
    And I type "b" into element with xpath "//input[@id='middleName']"
    And I type "c" into element with xpath "//input[@id='lastName']"
    And I click on element with xpath "//span[text()='Save']"
    Then element with xpath "//input[@id='name']" should have attribute "value" as "a b c"

  @cucumber06
  Scenario: Validate Privacy Policy
    Then element with xpath "//input[@name='agreedToPrivacyPolicy']/.." should have attribute "aria-required" as "true"
    Then I click on element with xpath "//input[@name='agreedToPrivacyPolicy']"

  @cucumber08
  Scenario: Submit the form and verify the data
    When I type "ab" into element with xpath "//input[@name='username']"
    And I type "a@f" into element with xpath "//input[@name='email']"
    And I type "12345" into element with xpath "//input[@id='password']"
    And I type "12345" into element with xpath "//input[@id='confirmPassword']"
    And I type "St st" into element with xpath "//input[@id='name']"
    And I click on element with xpath "//input[@name='agreedToPrivacyPolicy']"
    And I click on element with xpath "//button[@id='formSubmit']"
    Then element with xpath "//legend[@class='applicationResult']" should be displayed
    And element with xpath "//div[@class='row']" should contain text "entered"
    And element with xpath "//div[@class='row']" should contain text "ab"
    And element with xpath "//div[@class='row']" should contain text "St st"
    And element with xpath "//div[@class='row']" should contain text "a@f"
    And element with xpath "//div[@class='row']" should contain text "true"



