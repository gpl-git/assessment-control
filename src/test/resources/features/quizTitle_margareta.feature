@quizTitle
  Feature: Quiz Title Behavior

    Background:
      Given I'm opening "Login" page
      When I type "bbd100@filevino.com" as an email
      And I type "Test1234" into password field
      When I click on "Sign In" button
      And I wait for 2 sec
      Then "home" page should be displayed
      When I click on "Quizzes" from menu item
      And I wait for 2 sec
      When I'm clicking on "Create New Quiz" button
      And I wait for 2 sec

@quizTitle1
Scenario: Whole workflow for a quiz
  When I'm typing "MargoB" as a quiz title
  And I add the question
  And I wait for 2 sec
  And I click outside from input field
  And I wait for 2 sec
  And I select the "Textual" question
  And I wait for 2 sec
  When I type "What is Quality Assurance?" in "Q1" question field
  And I wait for 2 sec
  Then I click on "Save" button
  And I wait for 3 sec
  Then the quiz "MargoB" is displaying on the list of quizzes
  And I wait for 2 sec
  Then I delete quiz with name "MargoB"

@quizTitle2
Scenario: Quiz Title Field Accepts Letters
  When I'm typing "apple" as a quiz title
  And I wait for 1 sec
  And I add a question
  And I wait for 2 sec
  Then No error message is displayed under the "Title of The Quiz*" field
  And I wait for 2 sec

@quizTitle3
Scenario: Quiz Title Field Accepts Numbers
  When I'm typing "12345" as a quiz title
  And I wait for 1 sec
  And I add a question
  And I wait for 2 sec
  Then No error message is displayed under the "Title of The Quiz*" field
  And I wait for 2 sec

    Scenario Outline: Quiz Title Field Positive Input
      When I'm typing <quizTitle> as a quiz title
      And I wait for 1 sec
      And I add a question
      And I wait for 1 sec
      Then No error message is displayed under the "Title of The Quiz*" field
      And I wait for 1 sec
      Examples:
        | quizTitle |
        | "apple"   |
        | "12345"   |
        | "!$?)&"   |
        | " "   |
        | "a"   |


    @quizTitle4
Scenario: Quiz Title Field Accepts Characters
  When I'm typing "!$?)&" as a quiz title
  And I wait for 2 sec
  And I add a question
  And I wait for 2 sec
  Then No error message is displayed under the "Title of The Quiz*" field
  And I wait for 2 sec

@quizTitle5
Scenario: Unable to create a quiz with empty "Title of the Quiz*" field
  When I type "" as quiz title
  And I wait for 2 sec
  And I click outside from input field
  And I wait for 2 sec
  Then error message should be displayed
  Then error message "This field is required" should be displayed

@quizTitle6
Scenario: Verify that "Title of The Quiz" field is marked with asterisk
  And "Title of The Quiz" field is marked with asterisk is displayed
  And I wait for 2 sec

@quizTitle7
Scenario: Quiz Title Field can have one character
  When I type "a" as quiz title
  And I add a question
  And I wait for 2 sec
  Then No error message is displayed under the "Title of the Quiz*" field
  And I wait for 2 sec

@quizTitle8
Scenario: Quiz Title field can have 1000 characters
  When I type "fhjbvjfdbvm,fbdvmn,fdbvjkfdlmvh,dfbvbfdhvbfdbvjdfnvmndfbvjfdbvjbdfjvbfdbvjfdbvjhfdsbvjdfbvjhdfsbvsbvhbsnvbmnscbvnsbvhjsfbvfsbvnsfbvnsfbkjdfbnvjfnvjkfnvjfdnvjkdfnvjkfnvkjfdnjkfngjksfnbgjkfsngkjfsnjkngjksgjksgfsjkbjskbgjkfsbgjksbgjksfbgjkfsbgfjsbgjkfsbgjksfbgjksbgjksfbgjksbfgjksbgjksbgjksbgjksbgjksbgjfksbgfjksbgjksfbgjkfsbgjkfsbgsjkbgjkfsgbjksfbgjksfbgjksfbgjkfsbgkjsbgjkdqtyujfhjbvjfdbvm,fbdvmn,fdbvjkfdlmvh,dfbvbfdhvbfdbvjdfnvmndfbvjfdbvjbdfjvbfdbvjfdbvjhfdsbvjdfbvjhdfsbvsbvhbsnvbmnscbvnsbvhjsfbvfsbvnsfbvnsfbkjdfbnvjfnvjkfnvjfdnvjkdfnvjkfnvkjfdnjkfngjksfnbgjkfsngkjfsnjkngjksgjksgfsjkbjskbgjkfsbgjksbgjksfbgjkfsbgfjsbgjkfsbgjksfbgjksbgjksfbgjksbfgjksbgjksbgjksbgjksbgjksbgjfksbgfjksbgjksfbgjkfsbgjkfsbgsjkbgjkfsgbjksfbgjksfbgjksfbgjkfsbgkjsbgjkdqtyujfhjbvjfdbvm,fbdvmn,fdbvjkfdlmvh,dfbvbfdhvbfdbvjdfnvmndfbvjfdbvjbdfjvbfdbvjfdbvjhfdsbvjdfbvjhdfsbvsbvhbsnvbmnscbvnsbvhjsfbvfsbvnsfbvnsfbkjdfbnvjfnvjkfnvjfdnvjkdfnvjkfnvkjfdnjkfngjksfnbgjkfsngkjfsnjkngjksgjksgfsjkbjskbgjkfsbgjksbgjksfbgjkfsbgfjsbgj" as quiz title
  And I add a question
  And I wait for 2 sec
  Then No error message is displayed under the "Title of the Quiz*" field
  And I wait for 2 sec


@quizTitle9
Scenario: Quiz Title field can have 1001 characters
  When I type "fhjbvjfdbvm,fbdvmn,fdbvjkfdlmvh,dfbvbfdhvbfdbvjdfnvmndfbvjfdbvjbdfjvbfdbvjfdbvjhfdsbvjdfbvjhdfsbvsbvhbsnvbmnscbvnsbvhjsfbvfsbvnsfbvnsfbkjdfbnvjfnvjkfnvjfdnvjkdfnvjkfnvkjfdnjkfngjksfnbgjkfsngkjfsnjkngjksgjksgfsjkbjskbgjkfsbgjksbgjksfbgjkfsbgfjsbgjkfsbgjksfbgjksbgjksfbgjksbfgjksbgjksbgjksbgjksbgjksbgjfksbgfjksbgjksfbgjkfsbgjkfsbgsjkbgjkfsgbjksfbgjksfbgjksfbgjkfsbgkjsbgjkdqtyujfhjbvjfdbvm,fbdvmn,fdbvjkfdlmvh,dfbvbfdhvbfdbvjdfnvmndfbvjfdbvjbdfjvbfdbvjfdbvjhfdsbvjdfbvjhdfsbvsbvhbsnvbmnscbvnsbvhjsfbvfsbvnsfbvnsfbkjdfbnvjfnvjkfnvjfdnvjkdfnvjkfnvkjfdnjkfngjksfnbgjkfsngkjfsnjkngjksgjksgfsjkbjskbgjkfsbgjksbgjksfbgjkfsbgfjsbgjkfsbgjksfbgjksbgjksfbgjksbfgjksbgjksbgjksbgjksbgjksbgjfksbgfjksbgjksfbgjkfsbgjkfsbgsjkbgjkfsgbjksfbgjksfbgjksfbgjkfsbgkjsbgjkdqtyujfhjbvjfdbvm,fbdvmn,fdbvjkfdlmvh,dfbvbfdhvbfdbvjdfnvmndfbvjfdbvjbdfjvbfdbvjfdbvjhfdsbvjdfbvjhdfsbvsbvhbsnvbmnscbvnsbvhjsfbvfsbvnsfbvnsfbkjdfbnvjfnvjkfnvjfdnvjkdfnvjkfnvkjfdnjkfngjksfnbgjkfsngkjfsnjkngjksgjksgfsjkbjskbgjkfsbgjksbgjksfbgjkfsbgfjsbgjm" as quiz title
  And I add a question
  And I wait for 2 sec
  And I select "Textual" question
  When I type "What is Exploratory Testing?" into "Q1"
  And I click on "Save" button
#  This is a known issue Sep22-331
  Then error message "No more than 1001 characters" should be displayed
  And I wait for 2 sec

@quizTitle10
Scenario: Quiz Title can not have only space characters
  When I type " " as quiz title
  And I add a question
  And I wait for 2 sec
  When I select the "Textual" question
  And I wait for 2 sec
  When I type "What is Quality?" into "Q1"
  And I wait for 2 sec
  Then  I click on "Save" button
  And I wait for 1 sec
#  This is a known issue Sep22-392
  Then error message "Quiz Title can not be empty" should be displayed
  And I wait for 1 sec

@quizTitle11
Scenario: Quiz Title must have at least one non space character
  When I type " +1 " as quiz title
  And I add a question
  And I wait for 2 sec
  When I'm selecting the "Single-Choice" question
  And I wait for 2 sec
  When I type "What is a bug?" into "Q1"
  And I wait for 2 sec
  Then I type "mismatch between actual and expected behavior" as "Option 1*" in "Q1" MB
  And I wait for 1 sec
  Then I type "defect into software" as "Option 2*" in "Q1" MB
  And I wait for 2 sec
  Then I select "Option 1*" as correct option in "Q1"
  And I wait for 2 sec
  And I click on "Save" button
  And I wait for 1 sec
  Then quiz " +1 " is displayed on the list of quizzes
  And I delete quiz with name " +1 "
  And I wait for 2 sec






