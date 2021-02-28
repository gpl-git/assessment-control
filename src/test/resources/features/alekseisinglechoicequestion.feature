@loginSCQ
  Feature: Login SCQ

      Background: :Login as a teacher
      Given I go  to "http://ask-qa.portnov.com/#/login"
      And I login with "ask_instr@aol.com" email and "12345" password byAK
      And I click "Sign In" byAK
      And I wait for 1 sec to see what's on the page
      And I navigate to "Quizzes" page from main menu byAK
      And I wait for 1 sec to see what's on the page
      And I click "Create New Quiz" byAK
      And I wait for 1 sec to see what's on the page
      And I type "Test Quiz SCQ" in the form byAK
      And I wait for 1 sec to see what's on the page
      And I click "add_circle" plus sign byAK
      And I wait for 1 sec to see what's on the page
      And I select "Single-Choice" option byAK
      And I wait for 1 sec to see what's on the page

    @loginSCQ1
    Scenario: Verify that Question field allows max 1000 characters
    And I put 1000 characters in question field byAK
    And I wait for 1 sec to see what's on the page
    And I select "Option 1*" byAK
    And I type "answer1" to the question "Option 1*" byAK
    And I wait for 1 sec to see what's on the page
    And I type "answer2" to the question "Option 2*" byAK
    And I wait for 1 sec to see what's on the page
    And I click "text area option for this question?" byAK
    And I click "Save" byAK
    And I wait for 1 sec to see what's on the page
    Then I should see page displaying "Test Quiz SCQ" byAK


   @loginSCQ2
    Scenario: Verify that Question field allows max 1001 characters
    And I put 1001 characters in question field byAK
    And I wait for 1 sec to see what's on the page
    And I select "Option 1*" byAK
    And I type "answer1" to the question "Option 1*" byAK
    And I wait for 1 sec to see what's on the page
    And I type "answer2" to the question "Option 2*" byAK
    And I wait for 1 sec to see what's on the page
    And I click "text area option for this question?" byAK
    And I wait for 1 sec to see what's on the page
    And I click "Save" byAK
    And I wait for 3 sec to see what's on the page
    Then I should not see page displaying "Test Quiz SCQ" byAK
          # bug AS-249

    @loginSCQ3
    Scenario: Verify that Question field allows max 999 characters
      And I put 999 characters in question field byAK
      And I wait for 1 sec to see what's on the page
      And I select "Option 1*" byAK
      And I type "answer1" to the question "Option 1*" byAK
      And I wait for 1 sec to see what's on the page
      And I type "answer2" to the question "Option 2*" byAK
      And I wait for 1 sec to see what's on the page
      And I click "text area option for this question?" byAK
      And I wait for 1 sec to see what's on the page
      And I click "Save" byAK
      And I wait for 3 sec to see what's on the page
      Then I should see page displaying "Test Quiz SCQ" byAK

    @loginSCQ4
    Scenario: Verify that Single choice questions has maximum of 15 choices
      And I put 100 characters in question field byAK
      And I wait for 1 sec to see what's on the page
      And I select "Option 1*" byAK
      And I click "Add Option" 12 times byAK
      And I type "My answer" to the question "Option" 15 "*"times byAK
      And I wait for 3 sec to see what's on the page
      And I click "text area option for this question?" byAK
      And I wait for 1 sec to see what's on the page
      And I click "Save" byAK
      And I wait for 1 sec to see what's on the page
      Then I should see page displaying "Test Quiz SCQ" byAK

    @loginSCQ5
    Scenario: Verify that Single choice questions has maximum of 14 choices
      And I put 100 characters in question field byAK
      And I wait for 1 sec to see what's on the page
      And I select "Option 1*" byAK
      And I click "Add Option" 11 times byAK
      And I type "My answer" to the question "Option" 14 "*"times byAK
      And I wait for 3 sec to see what's on the page
      And I click "text area option for this question?" byAK
      And I wait for 1 sec to see what's on the page
      And I click "Save" byAK
      And I wait for 2 sec to see what's on the page
      Then I should see page displaying "Test Quiz SCQ" byAK

    @loginSCQ6
    Scenario: Verify that Single choice questions has maximum of 16 choices
      And I put 100 characters in question field byAK
      And I wait for 1 sec to see what's on the page
      And I select "Option 1*" byAK
      And I click "Add Option" 13 times byAK
      And I type "My answer" to the question "Option" 16 "*"times byAK
      And I wait for 3 sec to see what's on the page
      And I click "text area option for this question?" byAK
      And I wait for 1 sec to see what's on the page
      And I click "Save" byAK
      And I wait for 1 sec to see what's on the page
      Then I should not see page displaying "Test Quiz SCQ" byAK
      #bug AS-250

    @loginSCQ7
    Scenario: User unable to save Quiz without specifying correct option for the Question
      And I put 100 characters in question field byAK
      And I wait for 1 sec to see what's on the page
      And I type "answer1" to the question "Option 1*" byAK
      And I wait for 1 sec to see what's on the page
      And I type "answer2" to the question "Option 2*" byAK
      And I wait for 1 sec to see what's on the page
      And I click "text area option for this question?" byAK
      And I wait for 1 sec to see what's on the page
      And I click "Save" byAK
      And I wait for 3 sec to see what's on the page
      Then Verify that error message "*Choose correct answer" displayed byAK

    @loginSCQ8
    Scenario: User able to save Quiz when specifying correct option
      And I put 100 characters in question field byAK
      And I wait for 1 sec to see what's on the page
      And I select "Option 1*" byAK
      And I type "answer1" to the question "Option 1*" byAK
      And I wait for 1 sec to see what's on the page
      And I type "answer2" to the question "Option 2*" byAK
      And I wait for 1 sec to see what's on the page
      And I click "text area option for this question?" byAK
      And I wait for 1 sec to see what's on the page
      And I click "Save" byAK
      And I wait for 3 sec to see what's on the page
      Then I should see page displaying "Test Quiz SCQ" byAK

    @loginSCQ9
    Scenario: Single choice Questions includes "Others" text area option
      And I put 100 characters in question field byAK
      And I wait for 1 sec to see what's on the page
      And I select "Option 1*" byAK
      And I type "answer1" to the question "Option 1*" byAK
      And I wait for 1 sec to see what's on the page
      And I type "answer2" to the question "Option 2*" byAK
      And I wait for 1 sec to see what's on the page
      And I click "text area option for this question?" byAK
      And I click "Save" byAK
      And I wait for 3 sec to see what's on the page
      Then I should see page displaying "Test Quiz SCQ" byAK
      When I navigate to "Assignments" page from main menu byAK
      And I click "Create New Assignment" byAK
      And I click "Select Quiz To Assign" byAK
      And I wait for 1 sec to see what's on the page
      And I click "Test Quiz SCQ" byAK
      And I wait for 1 sec to see what's on the page
      And I click "qwerty" byAK
      And I click "Give Assignment" byAK
      And I wait for 1 sec to see what's on the page
      And I navigate to "Log Out" page from main menu byAK
      And I wait for 1 sec to see what's on the page
      And I click "Log Out" byAK
      And I wait for 1 sec to see what's on the page
      And I login with "kutsko500@gmail.com" email and "Test1234" password byAK
      And I wait for 1 sec to see what's on the page
      And I click "Sign In" byAK
      And I wait for 1 sec to see what's on the page
      And I navigate to "My Assignments" page from main menu byAK
      And I wait for 1 sec to see what's on the page
      And I click "Go To Assessment" byAK
      And I wait for 2 sec to see what's on the page
      Then I should see page input field  "Other" byAK
      And I wait for 5 sec to see what's on the page


    @loginSCQ10
    Scenario: Single-Choice Graded automatically
      And I put 100 characters in question field byAK
      And I wait for 1 sec to see what's on the page
      And I select "Option 1*" byAK
      And I type "answer1" to the question "Option 1*" byAK
      And I wait for 1 sec to see what's on the page
      And I type "answer2" to the question "Option 2*" byAK
      And I wait for 1 sec to see what's on the page
      And I click "text area option for this question?" byAK
      And I click "Save" byAK
      And I wait for 3 sec to see what's on the page
      Then I should see page displaying "Test Quiz SCQ" byAK
      When I navigate to "Assignments" page from main menu byAK
      And I click "Create New Assignment" byAK
      And I click "Select Quiz To Assign" byAK
      And I wait for 1 sec to see what's on the page
      And I click "Test Quiz SCQ" byAK
      And I wait for 1 sec to see what's on the page
      And I click "qwerty" byAK
      And I click "Give Assignment" byAK
      And I wait for 1 sec to see what's on the page
      And I navigate to "Log Out" page from main menu byAK
      And I wait for 1 sec to see what's on the page
      And I click "Log Out" byAK
      And I wait for 1 sec to see what's on the page
      And I login with "kutsko500@gmail.com" email and "Test1234" password byAK
      And I wait for 1 sec to see what's on the page
      And I click "Sign In" byAK
      And I wait for 1 sec to see what's on the page
      And I navigate to "My Assignments" page from main menu byAK
      And I wait for 1 sec to see what's on the page
      And I click "Go To Assessment" byAK
      And I wait for 1 sec to see what's on the page
      And I select "answer1" for assigned quiz byAK
      And I click "Submit My Answers" byAK
      And I wait for 1 sec to see what's on the page
      And I click "Ok" byAK
      And I wait for 1 sec to see what's on the page
      And I navigate to "My Grades" page from main menu byAK
      And I wait for 1 sec to see what's on the page
      Then I should see that test was graded at "Automatic"




