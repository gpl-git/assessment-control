@quizTitle
  Feature: Quiz Title Scenarios
    Background:
      Given I open "login" website
      When I type "gnwjdu@gotcertify.com" into email field
      When  I type "12345" into password field
      And I click "Sign In" button
      And I wait for 1 sec
      When I click "Quizzes" menu item
      And I wait for 1 sec
      And I click "Create New Quiz" button
      And I wait for 1 sec

    @quizTitle1 @regression
    Scenario: Quiz Title: Happy Path
      When I type "What is SQL?" as quiz title
      Then I add question
      When I select "Single" question type
      When I type "Question 1" into "Q1"
      And I type "Option 1" into "Q1" as "Option 1*"
      And I type "Option 2" into "Q1" as "Option 2*"
      When I select "Option 1*" as correct option in "Q1"
      When I click "Save" button
      And I wait for 2 sec
      Then title "What is SQL?" should be displayed on the list of quizzes
      And I wait for 2 sec
      And I delete quiz  "What is SQL?"
      And I wait for 2 sec

    @quizTitle2
    Scenario: Quiz Title: Allowable characters: Alphanumeric & Sp. characters
      When I type "123qwe!@#" as quiz title
      Then I add question
      When I select "Single" question type
      When I type "Question 1" into "Q1"
      And I type "Option 1" into "Q1" as "Option 1*"
      And I type "Option 2" into "Q1" as "Option 2*"
      When I select "Option 1*" as correct option in "Q1"
      When I click "Save" button
      And I wait for 2 sec
      Then title "123qwe!@#" should be displayed on the list of quizzes
      And I wait for 2 sec
      And I delete quiz  "123qwe!@#"
      And I wait for 2 sec

  @quizTitle3
  Scenario: Quiz Title: Error Message "The field is required"
    When I click Title Of The Quiz field
    And I click outside of the title field
    And I wait for 1 sec
    Then error-message "This field is required" should be displayed
    And I wait for 1 sec
    When I type "123" as quiz title
    Then I clear quiz title
    And I wait for 1 sec
    Then error-message "This field is required" should be displayed
    And I wait for 1 sec

  @quizTitle4
  Scenario: Quiz Title: Min 1 Character
    When I type "A" as quiz title
    Then I add question
    When I select "Single" question type
    When I type "Question 1" into "Q1"
    And I type "Option 1" into "Q1" as "Option 1*"
    And I type "Option 2" into "Q1" as "Option 2*"
    When I select "Option 1*" as correct option in "Q1"
    When I click "Save" button
    And I wait for 2 sec
    Then title "A" should be displayed on the list of quizzes
    And I wait for 2 sec
    And I delete quiz  "A"
    And I wait for 2 sec

  @quizTitle5
  Scenario: Quiz Title: text field accepts space as a MIN 1 character
    When I type " " as quiz title
    And I wait for 1 sec
    Then error-message "Min 1 Characters" should be displayed
    And I wait for 1 sec
#  Known issue JAN23-530 (duplicated JAN23-415)

  @quizTitle6
    Scenario: Quiz Title: Accepts space as min 1 characters on List of Quizzes
    When I type " " as quiz title
    Then I add question
    When I select "Single" question type
    When I type "Question 1" into "Q1"
    And I type "Option 1" into "Q1" as "Option 1*"
    And I type "Option 2" into "Q1" as "Option 2*"
    When I select "Option 1*" as correct option in "Q1"
    When I click "Save" button
    And I wait for 2 sec
    Then title " " should be displayed on the list of quizzes
    And I wait for 2 sec
    And I delete quiz  " "
    And I wait for 2 sec
#Need bug report


  @quizTitle7
  Scenario: Quiz Title: Max 1000 Characters
    When I type 1000 characters as "Quiz title"
    And I wait for 2 sec


  @quizTitle8
    Scenario: Quiz Title: Verify Max 1000 Characters is exist on quiz title
    When I type "4oSpvdIJUYq1p9AsfxKBoHRJqU7vHOj0zZM586e3zDynBQYq8pupcUCTR7c8TlKQqpyiGSLT2gghoDZXDJbs6nFfAqqFJE1KgVL7D8LLE87YQoSZkcODpCnQbboanVpbDuw3uJ4peqwp1Npu6kmGnYsLtmkoc8oPtnRGU5oCDfuv7NJoWJya2nya9xdwR3keGxVLi2iBpwTOYLERglQQjJmZ4fgn7hBV1X9taZ8qEVenCGzchs24a1wGCAWSJXM4uSBAYqyJGVMeFlfzHqXv9MHUnnVUKGy4U0JPhO410cmvOVcSYKxIIRjUHzeFdyVcsSMDcsTJZrqNieuvxGGOTL4gALnoRW2pq1KHCV4H1NsO4hxiEukq62RgtEox96jxSo70uy04Z82hKZqpxt4KCLMIlwbcWtqOTzGe2JFsW8NLk47ubvoM8ftJOLn2VwMbCQHcMKmmbM9uGtCJOrBKpMadveBIPKj4sGWKk7PxZz6M7Na6wjefYRgGlosikSQqE5a3Bm2wJOPlwvFLRHLMN6vyedxlHseyJXXGThNdzCD64TcmCSFuoFUCkufuDAjxkcHiq6Ar45Mb1a9whAhqf1EJiM2FUWpgztqsKNNcVHjudRlGXMvR9ItIDRTySPdwsHWBVhYzUSw8p4R7b2JW296imJGTEsROU4NgigwlRvbKxGYZjoqEIzEmQs9cmv7g5dvgbQEs75YjxiIoETYXXIpJptql2Ch2U5kZ5QtzLNaHFZCDD9DdVQrGNvgV0nDK7PjrsVhp1sw5bL8v2Zqk9FLY8zXw5FbRZcTsp7pOuOGNndztUvV3udBPA0V9gNJWxe6O5zgd7FF8INdLmupfofdk1OSyKYZzdvL2kf9uK12CAIsgfQEZiM6QlzCvfmwP4kkyb7afV5A9VogbcCZkSPzkiq7YFs5b8IntUHOYB0ZSwat2ZQtr9IMOYbN4KYtD57wrOqcrNbg5wvDPIivGnx3F4WEWGdgVEK0qx2DZ" as quiz title
    Then I add question
    When I select "Single" question type
    When I type "Question 1" into "Q1"
    And I type "Option 1" into "Q1" as "Option 1*"
    And I type "Option 2" into "Q1" as "Option 2*"
    When I select "Option 1*" as correct option in "Q1"
    When I click "Save" button
    And I wait for 2 sec
    Then title "4oSpvdIJUYq1p9AsfxKBoHRJqU7vHOj0zZM586e3zDynBQYq8pupcUCTR7c8TlKQqpyiGSLT2gghoDZXDJbs6nFfAqqFJE1KgVL7D8LLE87YQoSZkcODpCnQbboanVpbDuw3uJ4peqwp1Npu6kmGnYsLtmkoc8oPtnRGU5oCDfuv7NJoWJya2nya9xdwR3keGxVLi2iBpwTOYLERglQQjJmZ4fgn7hBV1X9taZ8qEVenCGzchs24a1wGCAWSJXM4uSBAYqyJGVMeFlfzHqXv9MHUnnVUKGy4U0JPhO410cmvOVcSYKxIIRjUHzeFdyVcsSMDcsTJZrqNieuvxGGOTL4gALnoRW2pq1KHCV4H1NsO4hxiEukq62RgtEox96jxSo70uy04Z82hKZqpxt4KCLMIlwbcWtqOTzGe2JFsW8NLk47ubvoM8ftJOLn2VwMbCQHcMKmmbM9uGtCJOrBKpMadveBIPKj4sGWKk7PxZz6M7Na6wjefYRgGlosikSQqE5a3Bm2wJOPlwvFLRHLMN6vyedxlHseyJXXGThNdzCD64TcmCSFuoFUCkufuDAjxkcHiq6Ar45Mb1a9whAhqf1EJiM2FUWpgztqsKNNcVHjudRlGXMvR9ItIDRTySPdwsHWBVhYzUSw8p4R7b2JW296imJGTEsROU4NgigwlRvbKxGYZjoqEIzEmQs9cmv7g5dvgbQEs75YjxiIoETYXXIpJptql2Ch2U5kZ5QtzLNaHFZCDD9DdVQrGNvgV0nDK7PjrsVhp1sw5bL8v2Zqk9FLY8zXw5FbRZcTsp7pOuOGNndztUvV3udBPA0V9gNJWxe6O5zgd7FF8INdLmupfofdk1OSyKYZzdvL2kf9uK12CAIsgfQEZiM6QlzCvfmwP4kkyb7afV5A9VogbcCZkSPzkiq7YFs5b8IntUHOYB0ZSwat2ZQtr9IMOYbN4KYtD57wrOqcrNbg5wvDPIivGnx3F4WEWGdgVEK0qx2DZ" should be displayed on the list of quizzes
    And I wait for 2 sec
    And I delete quiz  "4oSpvdIJUYq1p9AsfxKBoHRJqU7vHOj0zZM586e3zDynBQYq8pupcUCTR7c8TlKQqpyiGSLT2gghoDZXDJbs6nFfAqqFJE1KgVL7D8LLE87YQoSZkcODpCnQbboanVpbDuw3uJ4peqwp1Npu6kmGnYsLtmkoc8oPtnRGU5oCDfuv7NJoWJya2nya9xdwR3keGxVLi2iBpwTOYLERglQQjJmZ4fgn7hBV1X9taZ8qEVenCGzchs24a1wGCAWSJXM4uSBAYqyJGVMeFlfzHqXv9MHUnnVUKGy4U0JPhO410cmvOVcSYKxIIRjUHzeFdyVcsSMDcsTJZrqNieuvxGGOTL4gALnoRW2pq1KHCV4H1NsO4hxiEukq62RgtEox96jxSo70uy04Z82hKZqpxt4KCLMIlwbcWtqOTzGe2JFsW8NLk47ubvoM8ftJOLn2VwMbCQHcMKmmbM9uGtCJOrBKpMadveBIPKj4sGWKk7PxZz6M7Na6wjefYRgGlosikSQqE5a3Bm2wJOPlwvFLRHLMN6vyedxlHseyJXXGThNdzCD64TcmCSFuoFUCkufuDAjxkcHiq6Ar45Mb1a9whAhqf1EJiM2FUWpgztqsKNNcVHjudRlGXMvR9ItIDRTySPdwsHWBVhYzUSw8p4R7b2JW296imJGTEsROU4NgigwlRvbKxGYZjoqEIzEmQs9cmv7g5dvgbQEs75YjxiIoETYXXIpJptql2Ch2U5kZ5QtzLNaHFZCDD9DdVQrGNvgV0nDK7PjrsVhp1sw5bL8v2Zqk9FLY8zXw5FbRZcTsp7pOuOGNndztUvV3udBPA0V9gNJWxe6O5zgd7FF8INdLmupfofdk1OSyKYZzdvL2kf9uK12CAIsgfQEZiM6QlzCvfmwP4kkyb7afV5A9VogbcCZkSPzkiq7YFs5b8IntUHOYB0ZSwat2ZQtr9IMOYbN4KYtD57wrOqcrNbg5wvDPIivGnx3F4WEWGdgVEK0qx2DZ"
    And I wait for 2 sec


  @quizTitle9
  Scenario: Quiz Title: Max 1000+1 characters
    When I type 1001 characters as "Quiz Title"
    Then error-message "Max 1000 characters" should be displayed
    And I wait for 2 sec
#   Known issue JAN23-432


    @quizTitle10
  Scenario: Quiz Title: Trailing space characters to be eliminated when Quiz is saved in the List of Quizzes
    When I type " A" as quiz title with trailing space
    Then I add question
    When I select "Single" question type
    When I type "Question 1" into "Q1"
    And I type "Option 1" into "Q1" as "Option 1*"
    And I type "Option 2" into "Q1" as "Option 2*"
    When I select "Option 1*" as correct option in "Q1"
    When I click "Save" button
    And I wait for 1 sec
    Then title "A" should be displayed on the list of quizzes
#    Verify that trailing space characters is eliminated
    And I wait for 2 sec
    And I delete quiz  "A"
    And I wait for 2 sec
#    Known Issues JAN23-433

  @quizTitle11
  Scenario: Quiz Title: Leading space characters to be eliminated when Quiz is saved in the List of Quizzes
    When I type "A " as quiz title with leading space
    Then I add question
    When I select "Single" question type
    When I type "Question 1" into "Q1"
    And I type "Option 1" into "Q1" as "Option 1*"
    And I type "Option 2" into "Q1" as "Option 2*"
    When I select "Option 1*" as correct option in "Q1"
    When I click "Save" button
    And I wait for 1 sec
    Then title "A" should be displayed on the list of quizzes
#    Verify that leading space characters is eliminated
    And I wait for 2 sec
    And I delete quiz  "A"
    And I wait for 2 sec
#    Known Issues JAN23-433



