@predefined
  Feature: ASK Demo
    @perdefined1
    Scenario: Registration
      Given I open "http://ask-qa.portnov.com/#/registration" page site
      When I type "1" into pass word field
      Then error message "Should be at least 5 characters" should be display SJ
      When I clear "password" field
      Then error message "This field is required" should be display SJ
      When I type "12 " into password field SJ
      Then error message "Whitespaces are not allowed" should be display I
      When I type "12345" into password field
      Then I type "1" into confirm password field
      Then error message "Should be at least 5 characters" should be displayed
      When I clear "confirm password" field I
      Then  error message "This field is required" should be display.
      When I type "12 " into password field I
      Then  error message "Whitespaces are not allowed" should be display III
      When I type "12456" into confirm password field Ir
      #Then error message "Entered passwords should match" should be displayed for miss match
      When I type "12345" into confirm password field Iri
      Then I click "Register" button for register
