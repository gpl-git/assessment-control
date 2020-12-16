@stacyquiz
Feature: Title of Quiz Scenarios

  @stacytitleofquiz1
  Scenario: Title of Quiz - Negative input
    Given I open "login"
    When I enter "qa.sofi@gmail.com" as email
    And I enter "12345" as password
    When I click "Sign In" button
    And I wait for 1 sec
    Then I verify that user role is equal to "TEACHER"
    And I click "Quizzes" link
    And I wait for 2 sec
    When I click "Create New Quiz" button
    And I wait for 1 sec
    When I click on Title Of The Quiz field
    And I click anywhere else on the screen
    And I wait for 3 sec
    Then error message "This field is required" appears
    When I type "A while back I needed to count the amount of letters that a piece of text in an email template had (to avoid passing any character limits). Unfortunately, I could not think of a quick way to do so on my macbook and I therefore turned to the Internet.There were a couple of tools out there, but none of them met my standards and since I am a web designer I thought: why not do it myself and help others along the way? And... here is the result, hope it helps out!A while back I needed to count the amount of letters that a piece of text in an email template had (to avoid passing any character limits). Unfortunately, I could not think of a quick way to do so on my macbook and I therefore turned to the Internet.There were a couple of tools out there, but none of them met my standards and since I am a web designer I thought: why not do it myself and help others along the way? And... here is the result, hope it helps out!A while back I needed to count the amount of letters that a piece of text in an e" as title
    And I wait for 3 sec
    And I add a question
    Then error message "Quiz Title cannot contain more than 1000 characters" appears


  @stacytitleofquiz2
  Scenario: Title of Quiz - Happy path
    Given I open "login"
    When I enter "qa.sofi@gmail.com" as email
    And I enter "12345" as password
    When I click "Sign In" button
    And I wait for 1 sec
    Then I verify that user role is equal to "TEACHER"
    And I click "Quizzes" link
    And I wait for 2 sec
    When I click "Create New Quiz" button
    And I wait for 1 sec
    When I type "a" as title
    And I wait for 2 sec
    And I add a question
    Then error message "This field is required" does not appear

  @stacytitleofquiz3
  Scenario Outline: Title of Quiz - Allowable characters and Boundary value
    Given I open "login"
    When I enter "qa.sofi@gmail.com" as email
    And I enter "12345" as password
    When I click "Sign In" button
    And I wait for 1 sec
    Then I verify that user role is equal to "TEACHER"
    And I click "Quizzes" link
    And I wait for 1 sec
    When I click "Create New Quiz" button
    And I wait for 2 sec
    When I type <title> as title
    And I wait for 4 sec
    And I add a question
    Then error message <error> does not appear
    Examples:
      | title                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                      | error                    |
      | "abc123!@#$%^&*"                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                           | "This field is required" |
      | "A while back I needed to count the amount of letters that a piece of text in an email template had (to avoid passing any character limits). Unfortunately, I could not think of a quick way to do so on my macbook and I therefore turned to the Internet.There were a couple of tools out there, but none of them met my standards and since I am a web designer I thought: why not do it myself and help others along the way? And... here is the result, hope it helps out!A while back I needed to count the amount of letters that a piece of text in an email template had (to avoid passing any character limits). Unfortunately, I could not think of a quick way to do so on my macbook and I therefore turned to the Internet.There were a couple of tools out there, but none of them met my standards and since I am a web designer I thought: why not do it myself and help others along the way? And... here is the result, hope it helps out!A while back I needed to count the amount of letters that a piece of text in" | "This field is required" |
      | "A while back I needed to count the amount of letters that a piece of text in an email template had (to avoid passing any character limits). Unfortunately, I could not think of a quick way to do so on my macbook and I therefore turned to the Internet.There were a couple of tools out there, but none of them met my standards and since I am a web designer I thought: why not do it myself and help others along the way? And... here is the result, hope it helps out!A while back I needed to count the amount of letters that a piece of text in an email template had (to avoid passing any character limits). Unfortunately, I could not think of a quick way to do so on my macbook and I therefore turned to the Internet.There were a couple of tools out there, but none of them met my standards and since I am a web designer I thought: why not do it myself and help others along the way? And... here is the result, hope it helps out!A while back I needed to count the amount of letters that a piece of text i"  | "This field is required" |
      | "           Test Quiz       "  | "This field is required" |



