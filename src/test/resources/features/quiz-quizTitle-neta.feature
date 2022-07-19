@quiz
Feature:  Quiz - Quiz Title - Neta

  Background:
    Given I go to "login" page
    When I type "ask_instr@aol.com" into email field
    And I enter "12345" as password
    When I click button "Sign In"
    And I wait for 1 sec
    When I click "Quizzes" menu item
    And I wait for 2 sec

  @quiz1
  Scenario: Quiz - Quiz Title Alpha characters
    When I click button "Create New Quiz"
    And I wait for 1 sec
    When I type "Test quiz alpha characters only" as quiz title
    And I add a question
    And I wait for 1 sec
    When I select "Single" question type
    And I type "Question 1 name" into "Q1"
    When I type "Option 1" as "Option 1*" into "Q1"
    And I type "Option 2" as "Option 2*" into "Q1"
    And I select "Option 1*" as correct option in "Q1"
    When I click button "Save"
    And I wait for 2 sec
    Then quiz "Test quiz alpha characters only" should be displayed on the list of quizzes
    And I wait for 2 sec
    And I delete "Test quiz alpha characters only"

  @guiz2
  Scenario: Quiz - Quiz Title Numeric characters
    When I click button "Create New Quiz"
    And I wait for 1 sec
    When I type "122132133545121320" as quiz title
    And I add a question
    And I wait for 1 sec
    When I select "Single" question type
    And I type "Question 1 name" into "Q1"
    When I type "Option 1" as "Option 1*" into "Q1"
    And I type "Option 2" as "Option 2*" into "Q1"
    And I select "Option 1*" as correct option in "Q1"
    When I click button "Save"
    And I wait for 2 sec
    Then quiz "122132133545121320" should be displayed on the list of quizzes
    And I wait for 2 sec
    And I delete "122132133545121320"

  @quiz3
  Scenario: Quiz - Quiz Title Special characters
    When I click button "Create New Quiz"
    And I wait for 1 sec
    When I type "#$%^&*@" as quiz title
    And I add a question
    And I wait for 1 sec
    When I select "Single" question type
    And I type "Question 1 name" into "Q1"
    When I type "Option 1" as "Option 1*" into "Q1"
    And I type "Option 2" as "Option 2*" into "Q1"
    And I select "Option 1*" as correct option in "Q1"
    When I click button "Save"
    And I wait for 2 sec
    Then quiz "#$%^&*@" should be displayed on the list of quizzes
    And I wait for 2 sec
    And I delete "#$%^&*@"

  @quiz4
  Scenario: Quiz - Quiz Title 1 character
    When I click button "Create New Quiz"
    And I wait for 1 sec
    When I type "A" as quiz title
    And I add a question
    And I wait for 1 sec
    When I select "Single" question type
    And I type "Question 1 name" into "Q1"
    When I type "Option 1" as "Option 1*" into "Q1"
    And I type "Option 2" as "Option 2*" into "Q1"
    And I select "Option 1*" as correct option in "Q1"
    When I click button "Save"
    And I wait for 2 sec
    Then quiz "A" should be displayed on the list of quizzes
    And I wait for 2 sec
    And I delete "A"

  @quiz5
  Scenario: Quiz - Quiz Title 1000 character
    When I click button "Create New Quiz"
    And I wait for 1 sec
    When I type "gjhgjhgjhgjhgjghjhgjhgjhgjhfhgfhfhfgjhgjgjhgjhgjgjhgjjjjh@jhkjjhkjhkhgjhgjhgjhgjhgjhgjhgjhgjhgjhgjhgjhgjhgjhgjhgjhgjfhgjhgjh.comfhgfjhfjhgfhgfhgfhgfhgfhgfhgfhjgfkjfkjhgjhgkjhgkjhgkjhgkhgkhjgkjhgjhgkjhgkjhgkjhgkjhgjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh" as quiz title
    And I add a question
    And I wait for 1 sec
    When I select "Single" question type
    And I type "Question 1 name" into "Q1"
    When I type "Option 1" as "Option 1*" into "Q1"
    And I type "Option 2" as "Option 2*" into "Q1"
    And I select "Option 1*" as correct option in "Q1"
    When I click button "Save"
    And I wait for 2 sec
    Then quiz "gjhgjhgjhgjhgjghjhgjhgjhgjhfhgfhfhfgjhgjgjhgjhgjgjhgjjjjh@jhkjjhkjhkhgjhgjhgjhgjhgjhgjhgjhgjhgjhgjhgjhgjhgjhgjhgjhgjfhgjhgjh.comfhgfjhfjhgfhgfhgfhgfhgfhgfhgfhjgfkjfkjhgjhgkjhgkjhgkjhgkhgkhjgkjhgjhgkjhgkjhgkjhgkjhgjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh" should be displayed on the list of quizzes
    And I wait for 2 sec
    And I delete "gjhgjhgjhgjhgjghjhgjhgjhgjhfhgfhfhfgjhgjgjhgjhgjgjhgjjjjh@jhkjjhkjhkhgjhgjhgjhgjhgjhgjhgjhgjhgjhgjhgjhgjhgjhgjhgjhgjfhgjhgjh.comfhgfjhfjhgfhgfhgfhgfhgfhgfhgfhjgfkjfkjhgjhgkjhgkjhgkjhgkhgkhjgkjhgjhgkjhgkjhgkjhgkjhgjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh"

  @quiz6
  Scenario: Quiz - Quiz Title 0 character - Negative
    When I click button "Create New Quiz"
    And I wait for 1 sec
    When I type "" as quiz title
    And I click outside
    Then I get error "This field is required"

  @quiz7
  Scenario: Quiz - Quiz Title 1001 character -Negative
    When I click button "Create New Quiz"
    And I wait for 1 sec
    When I type "gjhgjhgjhgjhgjghjhgjhgjhgjhfhgfhfhfgjhgjgjhgjhgjgjhgjjjjh@jhkjjhkjhkhgjhgjhgjhgjhgjhgjhgjhgjhgjhgjhgjhgjhgjhgjhgjhgjfhgjhgjh.comfhgfjhfjhgfhgfhgfhgfhgfhgfhgfhjgfkjfkjhgjhgkjhgkjhgkjhgkhgkhjgkjhgjhgkjhgkjhgkjhgkjhgjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh1" as quiz title
    And I add a question
    And I wait for 1 sec
    When I select "Single" question type
    And I type "Question 1 name" into "Q1"
    When I type "Option 1" as "Option 1*" into "Q1"
    And I type "Option 2" as "Option 2*" into "Q1"
    And I select "Option 1*" as correct option in "Q1"
    When I click button "Save"
    And I wait for 2 sec
    Then quiz "gjhgjhgjhgjhgjghjhgjhgjhgjhfhgfhfhfgjhgjgjhgjhgjgjhgjjjjh@jhkjjhkjhkhgjhgjhgjhgjhgjhgjhgjhgjhgjhgjhgjhgjhgjhgjhgjhgjfhgjhgjh.comfhgfjhfjhgfhgfhgfhgfhgfhgfhgfhjgfkjfkjhgjhgkjhgkjhgkjhgkhgkhjgkjhgjhgkjhgkjhgkjhgkjhgjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjjhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhhh1" should not be displayed on the list of quizzes
    And I wait for 2 sec

  @quiz8
  Scenario: Quiz - Quiz Title with spaces character - Negative
    When I click button "Create New Quiz"
    And I wait for 1 sec
    When I type "bn  bn" as quiz title
    And I add a question
    And I wait for 1 sec
    When I select "Single" question type
    And I type "Question 1 name" into "Q1"
    When I type "Option 1" as "Option 1*" into "Q1"
    And I type "Option 2" as "Option 2*" into "Q1"
    And I select "Option 1*" as correct option in "Q1"
    When I click button "Save"
    And I wait for 2 sec
    Then quiz "bn  bn" should not be displayed on the list of quizzes
