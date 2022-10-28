@quizTitle
  Feature: Quiz Title Behavior

    Background:
      Given I'm opening "Login" page
      When I type "bbd100@filevino.com" as an email
      And I type "Test1234" into password field
      When I click on "Sign In" button MB
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
  Then I click on "Save" button MB
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
  And I click on "Save" button MB
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
  Then  I click on "Save" button MB
  And I wait for 1 sec
#  This is a known issue Sep22-392
  Then error message "Quiz Title can not be empty" should be displayed
  And I wait for 1 sec

@quizTitle11
Scenario: Create a quiz- Leading characters
  When I type " Lead" as quiz title
  And I add a question
  When I select the "Single" question
  And I wait for 2 sec
  When I type "What is Gray box Testing" into "Q1"
  And I type "Black box testing plus utilizing partial knowledge of software internals" as "Option 1*" in "Q1" MB
  And I type "Testing done from user perspective" as "Option 2*" in "Q1"
  Then I select "Option 1*" as correct option in "Q1" MB
  And I click on "Save" button MB
  And I wait for 2 sec
  Then quiz "Lead" is displayed on the list of quizzes MB
  And I wait for 2 sec
  Then I verify that "Lead" quiz title has a leading white space MB
  And I wait for 2 sec
  And I click on "Save" button MB
  And I wait for 2 sec
  Then I delete quiz with name "Lead"
  And I wait for 2 sec


@quizTitle12
Scenario: Creat Quiz- Trailing characters
When I type "TrailMB " as quiz title
  And I add a question
  And I wait for 2 sec
  When I select the "Single-Choice" question
  And I wait for 2 sec
  When I type "What is purpose of software Testing?" into "Q1"
  And I type "Verification" as "Option 1*" in "Q1" MB
  And I type "Acceptance" as "Option 2*" in "Q1" MB
  Then I select "Option 1*" as correct option in "Q1" MB
  And I click on "Save" button MB
  And I wait for 2 sec
  Then quiz "TrailMB" is displayed on the list of quizzes
  And I wait for 2 sec
  Then I verify that "TrailMB" quiz title has a trailing white space MB
  And I wait for 2 sec
  And I click on "Edit" button MB
  And I wait for 2 sec
  And I delete quiz with name "TrailMB "
  And I wait for 2 sec





