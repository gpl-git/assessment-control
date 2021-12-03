Feature: Quiz Home page link

  Background:
    Given I go to "login" page

    Scenario: Verify home page links working for teacher
      When I type "ask_instr@aol.com" into email field
      And I type "12345" into password field
      When I click "Sign In" button
      And I wait for 1 sec
      Then I element with xpath "//div[@class='info']/p" should contain text "TEACHER"
      And I click on "Submissions" link
      Then url should be "http://ask-qa.portnov.com/#/submissions/0"
      Then element with xpath "//div[@role='tablist']/../../../../.." should be displayed
      When I click on "Assignments" link
      Then url should be "http://ask-qa.portnov.com/#/assignments"
      Then element with xpath "//span[contains(text(),'Create New')]/../../../../.." should be displayed
      When I click on "Quizzes" link
      And I wait for 2 sec
      Then url should be "http://ask-qa.portnov.com/#/quizzes"
      Then element with xpath "//span[contains(text(),'Create New Quiz')]/../../../../.." should be displayed
      When I click on "Users Management" link
      Then url should be "http://ask-qa.portnov.com/#/users-management"
      Then element with xpath "//div[@role='tablist']/../../.." should be displayed
      When I click on "Settings" link
      Then url should be "http://ask-qa.portnov.com/#/settings"
      Then element with xpath "//span[contains(text(),'Change Your Password')]/../../../.." should be displayed
      When I click on "Home" link
      Then url should be "http://ask-qa.portnov.com/#/home"
      Then element with xpath "//span[contains(text(),'Go To Users')]/../../../../.." should be displayed
      When I click on element with xpath "//span[contains(text(),'Submissions')]"
      Then url should be "http://ask-qa.portnov.com/#/submissions"
      When I click on "Home" link
      Then url should be "http://ask-qa.portnov.com/#/home"
      When I click on element with xpath "//span[contains(text(),'Assignments')]"
      Then url should be "http://ask-qa.portnov.com/#/assignments"
      When I click on "Home" link
      And I click on element with xpath "//span[contains(text(),'Management')]"
      Then url should be "http://ask-qa.portnov.com/#/users-management"
      When I click on "Log Out" link
      Then element with xpath "//span[contains(text(),'Log')]/../../../.." should be displayed

      Scenario: Verify home page links working for student

        When I type "9mesteryou12l@emailaing.com" into email field
        And I type "test123" into password field
        When I click "Sign In" button
        And I wait for 1 sec
        Then I element with xpath "//div[@class='info']/p" should contain text "STUDENT"
        And I click on "My Assignments" link
        Then url should be "http://ask-qa.portnov.com/#/my-assignments"
        When I click on "My Grades" link
        Then url should be "http://ask-qa.portnov.com/#/my-grades"
        When I click on "Settings" link
        And I wait for 2 sec
        Then url should be "http://ask-qa.portnov.com/#/settings"
        When I click on "Home" link
        Then url should be "http://ask-qa.portnov.com/#/home"
        When I click on element with xpath "//span[contains(text(),'Assignments')]"
        Then url should be "http://ask-qa.portnov.com/#/my-assignments"
        When I click on "Home" link
        Then url should be "http://ask-qa.portnov.com/#/home"
        When I click on element with xpath "//span[contains(text(),'Grades')]"
        Then url should be "http://ask-qa.portnov.com/#/my-grades"
        When I click on "Log Out" link
        Then element with xpath "//span[contains(text(),'Log')]/../../../.." should be displayed



      