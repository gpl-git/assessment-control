@settings

  Feature: Change name

    Scenario Outline: login and change your name
      Given I navigate to <url> page
      Then I type <email> in email field
      Then I type <password> as password
      And I wait for <sec> sec
      And I click <signIn> bttn
      And I wait for <sec> sec
      Then I click on <settings>
      And I wait for <sec> sec
      Then element with <settings> should be displayed
      And I wait for <sec> sec
      Then I click on <changeYourName> button
      And I wait for <sec> sec
      Then I clear the element with <xpath> New name
      Then I type <newName> in the New name field
      Then I click on <Change> buttn
      And I wait for <sec> sec
      And I verify the name change
      And I wait for <sec> sec
      Examples:
        | url   | email   | password   | sec | signIn   | settings   | changeYourName   | xpath   | newName   | Change   |
        | "http://ask-qa.portnov.com/#/login" | "assessment.portnov@gmail.com" | "12345" | 2   | "signIn" | "settings" | "changeYourName" | "xpath" | "Jane Doe" | "Change" |

    @changeStudentName
    Scenario Outline: login and change your name
      Given I navigate to <url> page
      Then I type <email> in email field
      Then I type <password> as password
      And I wait for <sec> sec
      And I click <signIn> bttn
      And I wait for <sec> sec
      Then I click on <settings>
      And I wait for <sec> sec
      Then element with <settings> should be displayed
      And I wait for <sec> sec
      Then I click on <changeYourName> button
      And I wait for <sec> sec
      Then I clear the element with <xpath> New name
      Then I type <newName> in the New name field
      Then I click on <Change> buttn
      And I wait for <sec> sec
      And I verify the name name for student
      And I wait for <sec> sec
      Examples:
        | url   | email   | password   | sec | signIn   | settings   | changeYourName   | xpath   | newName   | Change   |
        | "http://ask-qa.portnov.com/#/login" | "test1@test.com" | "12345" | 2   | "signIn" | "settings" | "changeYourName" | "xpath" | "Test QA" | "Change" |











