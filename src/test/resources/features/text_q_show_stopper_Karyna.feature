@show-stopper
  Feature: Test set "Textual Question - Show-stopper"

    @show-stopper1
    Scenario: "Show-stopper" textual question marked by asterisk for Teacher-user
      Given I navigate to "log in" page
      And I wait for 1 sec
      When I type "qa@ask.com" in the "email" input field
      And I type "12345" in the "password" input field
      And I click on "Sign In" button
      And I wait for 2 sec while page is uploading
      When I navigate to "Quizzes" link and click on it
      Then I wait for 1 sec while page is uploading
      When I click on "Create New Quiz" button
      And I wait for 1 sec while page is uploading
      When I type "Karyna Show-Stopper" in the "name" input field
      And I click on add question
      Then I wait for 1 sec
      When I choose "Textual" question for question number "1"
      And I wait for 1 sec
      When I type in question field text "hi" for question "1"
      When I mark "Show-Stopper" question for question number "1"
      Then question should be indicated with an "*"
      And I wait for 2 sec
      When I click on "Save" button
      And I wait for 2 sec while page is uploading
      Then I should see quiz title "Karyna Show-Stopper" in the list of quizzes

    @show-stopper2
    Scenario: "Show-stopper" question displayed in "Preview mode"
      Given I navigate to "log in" page
      And I wait for 1 sec
      When I type "qa@ask.com" in the "email" input field
      And I type "12345" in the "password" input field
      And I click on "Sign In" button
      And I wait for 2 sec while page is uploading
      When I navigate to "Quizzes" link and click on it
      Then I wait for 1 sec while page is uploading
      When I click on preview of the quiz "Karyna Show-Stopper"
      And I wait for 1 sec
      Then I should see a "Show-Stopper Question" text
      When I click on "Close" button
      And I wait for 1 sec

    @show-stopper3
    Scenario: Creating an assignment
      Given I navigate to "log in" page
      And I wait for 1 sec
      When I type "qa@ask.com" in the "email" input field
      And I type "12345" in the "password" input field
      And I click on "Sign In" button
      And I wait for 2 sec while page is uploading
      When I navigate to "Assignments" link and click on it
      Then I wait for 1 sec while page is uploading
      When I click on "Create New Assignment" button
      And I wait for 1 sec while page is uploading
      When I click on "AUT" group code
      Then student with a name "Karyna Student" should be chosen
      When I click on "Select Quiz To Assign" drop-down list
      And I wait for 1 sec
      When I choose quiz title as "Karyna Show-Stopper"
      And I wait for 1 sec
      When I click on "Give Assignment" button
      And I wait for 2 sec while page is uploading

    @show-stopper4
    Scenario: "Show-stopper" question marked for Student-user and Submitting an assignment
      Given I navigate to "log in" page
      And I wait for 1 sec
      When I type "karyna.qa@gmail.com" in the "email" input field
      And I type "12345" in the "password" input field
      And I click on "Sign In" button
      And I wait for 2 sec while page is uploading
      When I navigate to "Go To My Assignments" link and click on it
      And I wait for 1 sec while page is uploading
      When I click on "Go To Assessment" button
      Then I should see a "Show-Stopper Question" text
      When I navigate back 
      And I wait for 1 sec
      When I click on "Go To Assessment" button
      And I wait for 1 sec while page is uploading
      When I type "0" in the "textAnswer" input field
      And I click on "Submit My Answers" button
      And I wait for 1 sec
      When I click on "Ok" button
      And I wait for 1 sec
      When I navigate to "Log Out" link and click on it
      And I wait for 1 sec
      When I confirm Log Out

    @show-stopper5
      Scenario: Grading an assignment and Deleting a quiz
      Given I navigate to "log in" page
      And I wait for 1 sec
      When I type "qa@ask.com" in the "email" input field
      And I type "12345" in the "password" input field
      And I click on "Sign In" button
      Then I wait for 2 sec while page is uploading
      When I navigate to "Submissions" link and click on it
      And I wait for 1 sec while page is uploading
      When I click on Grade button for the quiz name "Karyna Show-Stopper"
      And I wait for 1 sec while page is uploading
      Then I should see a "Show-Stopper Question" text
      And I should see a result of a submitted assignment as "failed show-stopper"
      When I add points to 5
      Then I should not see a result of submitted assignment as "failed show-stopper"
      And I wait for 2 sec
      When I click on "Save" button
      And I wait for 2 sec while page is uploading
      When I navigate to "Quizzes" link and click on it
      Then I wait for 1 sec while page is uploading
      When I delete quiz "Karyna Show-Stopper" from the list
      And I wait for 1 sec
      When I confirm Deleting a quiz
      And I wait for 2 sec
      Then I should not see a "Karyna Show-Stopper" quiz


    @@show-stopper6
      Scenario: Only one "Show-stopper" question can exist per quiz
      Given I navigate to "log in" page
      And I wait for 1 sec
      When I type "qa@ask.com" in the "email" input field
      And I type "12345" in the "password" input field
      And I click on "Sign In" button
      And I wait for 2 sec while page is uploading
      When I navigate to "Quizzes" link and click on it
      Then I wait for 1 sec while page is uploading
      When I click on "Create New Quiz" button
      And I wait for 1 sec while page is uploading
      When I type "Karyna Show-Stopper2" in the "name" input field
      And I click on add question
      Then I wait for 1 sec
      When I choose "Textual" question for question number "1"
      And I wait for 1 sec
      When I type in question field text "hi" for question "1"
      When I mark "Show-Stopper" question for question number "1"
      Then question should be indicated with an "*"
      And I wait for 1 sec
      When I click on add question
      Then I wait for 1 sec
      When I choose "Textual" question for question number "2"
      And I wait for 1 sec
      When I type in question field text "hello" for question "2"
      And I mark "Show-Stopper" question for question number "2"
      And I wait for 1 sec
      Then question number "1" should not be indicated with an "*"
      And question number "2" should be indicated with an "*"
      When I click on "Save" button
      And I wait for 2 sec while page is uploading
      Then I should see quiz title "Karyna Show-Stopper2" in the list of quizzes
      When I delete quiz "Karyna Show-Stopper2" from the list
      And I wait for 1 sec
      When I confirm Deleting a quiz
      And I wait for 2 sec
      Then I should not see a "Karyna Show-Stopper2" quiz

    @show-stopper7
    Scenario: Failing A Show-Stopper Question Fails The Entire Quiz With An Achieved Passing Rate
      Given I navigate to "log in" page
      And I wait for 1 sec
      When I type "qa@ask.com" in the "email" input field
      And I type "12345" in the "password" input field
      And I click on "Sign In" button
      And I wait for 2 sec while page is uploading
      When I navigate to "Quizzes" link and click on it
      Then I wait for 1 sec while page is uploading
      When I click on "Create New Quiz" button
      And I wait for 1 sec while page is uploading
      When I type "Karyna Failed" in the "name" input field
      And I click on add question
      Then I wait for 1 sec
      When I choose "Textual" question for question number "1"
      And I wait for 1 sec
      When I type in question field text "first question" for question "1"
      When I mark "Show-Stopper" question for question number "1"
      Then question should be indicated with an "*"
      And I wait for 1 sec
      When I click on add question
      Then I wait for 1 sec
      When I choose "Single-Choice" question for question number "2"
      And I wait for 1 sec
      When I type in question field text "second question" for question "2"
      When I type text "correct" for option 1 for question number 2
      And I type text "wrong" for option 2 for question number 2
      And I choose correct option 1 for question number 2
      And I wait for 1 sec
      When I click on add question
      Then I wait for 1 sec
      When I choose "Single-Choice" question for question number "3"
      And I wait for 1 sec
      When I type in question field text "third question" for question "3"
      When I type text "correct" for option 1 for question number 3
      And I type text "wrong" for option 2 for question number 3
      And I choose correct option 1 for question number 3
      And I wait for 1 sec
      When I decrease passing rate from 75 percent to 50 percent
      And I wait for 2 sec
      And I click on "Save" button
      And I wait for 2 sec while page is uploading
      When I navigate to "Assignments" link and click on it
      Then I wait for 1 sec while page is uploading
      When I click on "Create New Assignment" button
      And I wait for 1 sec while page is uploading
      When I click on "AUT" group code
      Then student with a name "Karyna Student" should be chosen
      When I click on "Select Quiz To Assign" drop-down list
      And I wait for 1 sec
      When I choose quiz title as "Karyna Failed"
      And I wait for 1 sec
      When I click on "Give Assignment" button
      And I wait for 2 sec while page is uploading
      When I navigate to "Log Out" link and click on it
      And I wait for 1 sec
      When I confirm Log Out
      And I wait for 1 sec
      When I type "karyna.qa@gmail.com" in the "email" input field
      And I type "12345" in the "password" input field
      And I click on "Sign In" button
      And I wait for 2 sec while page is uploading
      When I navigate to "Go To My Assignments" link and click on it
      And I wait for 1 sec while page is uploading
      When I click on "Go To Assessment" button
      And I wait for 1 sec while page is uploading
      When I type "0" in the "textAnswer" input field
      And I choose correct option "correct" for question number 2
      And I choose correct option "correct" for question number 3
      And I wait for 1 sec
      And I click on "Submit My Answers" button
      And I wait for 1 sec
      When I click on "Ok" button
      And I wait for 1 sec
      When I navigate to "Log Out" link and click on it
      And I wait for 1 sec
      When I confirm Log Out
      And I wait for 1 sec
      When I type "qa@ask.com" in the "email" input field
      And I type "12345" in the "password" input field
      And I click on "Sign In" button
      Then I wait for 2 sec while page is uploading
      When I navigate to "Submissions" link and click on it
      And I wait for 1 sec while page is uploading
      When I click on Grade button for the quiz name "Karyna Failed"
      And I wait for 1 sec while page is uploading
      Then I should see a "Show-Stopper Question" text
      And I should see a result of a submitted assignment as "failed show-stopper"
      When I wait for 1 sec
      And I click on "Save" button
      And I wait for 2 sec
      When I navigate to "Quizzes" link and click on it
      And I wait for 2 sec while page is uploading
      When I delete quiz "Karyna Failed" from the list
      And I wait for 1 sec
      When I confirm Deleting a quiz
      And I wait for 1 sec
      When I navigate to "Log Out" link and click on it
      And I wait for 1 sec
      When I confirm Log Out
      And I wait for 1 sec
      When I type "karyna.qa@gmail.com" in the "email" input field
      And I type "12345" in the "password" input field
      And I click on "Sign In" button
      And I wait for 2 sec while page is uploading
      When I navigate to "My Grades" link and click on it
      And I wait for 1 sec while page is uploading
      Then I should see result "failed" for assignment "Karyna Failed"
      And I wait for 2 sec







      








      
      
      


      






      