@quiztitle @regression

Feature: Quiz Title Input Field Behavior
  Background:
    Given I go to "ask"
    When I enter "ask_instr@aol.com" into email field
    And I enter "12345" into password field
    When I click "Sign In" button
    And I wait for 1 sec

  @quiztitle1 @regression
  Scenario Outline: Positive/Alphanumeric & Special characters, min 1, max 1000, leading/trailing spaces eliminate
    When I click on "Quizzes" button
    And I wait for 1 sec
    When I click "Create New Quiz" button
    And I wait for 1 sec
    And I type <title> in the Title field
    Then I click "Add Question"
    And I wait for 1 sec
    Then quiz page should be displayed
    Then I select "Textual" question
    And I wait for 1 sec
    And I type "Question 1 Test" into "Q1" question input field
    And I wait for 1 sec
    When I click "Save" button
    Then title <title> is displayed on the list of quizzes
    And I wait for 4 sec
    And I delete <title1> quiz
    And I wait for 4 sec
    And you confirm delete action
    And I wait for 1 sec
    Examples:
      | title          | title1       |
      | "Aa12&{}*3"    | "Aa12&{}*3" |
      | "a"            | "a"          |
      | " abc "            | "abc"          |
      | "bcskajhcvd%&hikj123*$#okjnjbhvfg{}&56rgbcgg]>jkbvtydfg5879y8ouijknjbjbcskajhcvd%&hikj123*$#okjnjbhvfg{}&56rgbc12]>jkbvtydfg5879y8ouijknjbjbcskajhcvd%&hikj123*$#okjnjbhvfg{}&56rgbcgh]>jkbvtydfg5879y8ouijknjbjbcskajhcvd%&hikj123*$#okjnjbhvfg{}&56rgbcff]>jkbvtydfg5879y8ouijknjbjbcskajhcvd%&hikj123*$#okjnjbhvfg{}&56rgbcff]>jkbvtydfg5879y8ouijknjbjbcskajhcvd%&hikj123*$#okjnjbhvfg{}&56rgbcrr]>jkbvtydfg5879y8ouijknjbjbcskajhcvd%&hikj123*$#okjnjbhvfg{}&56rgbcgg]>jkbvtydfg5879y8ouijknjbjbcskajhcvd%&hikj123*$#okjnjbhvfg{}&56rgbcgg]>jkbvtydfg5879y8ouijknjbjbcskajhcvd%&hikj123*$#okjnjbhvfg{}&56rgbchh]>jkbvtydfg5879y8ouijknjbjbcskajhcvd%&hikj123*$#okjnjbhvfg{}&56rgbcjj]>jkbvtydfg5879y8ouijknjbjbcskajhcvd%&hikj123*$#okjnjbhvfg{}&56rgbchh]>jkbvtydfg5879y8ouijknjbjbcskajhcvd%&hikj123*$#okjnjbhvfg{}&56rgbc:[]>jkbvtydfg5879y8ouijknjbjbcskajhcvd%&hikj123*$#okjnjbhvfg{}&56rgbc:[]>jkbvtydfg5879y8ouijknjbjbcskajhcvd%&hikj123*$#okjnjbhvfg{}&56rgbc:[]>jkbvtydfg5879y8ouijknjbjbcskajhcvd%&hikj123*$#okjnjbhvfg{}"    | "bcskajhcvd%&hikj123*$#okjnjbhvfg{}&56rgbcgg]>jkbvtydfg5879y8ouijknjbjbcskajhcvd%&hikj123*$#okjnjbhvfg{}&56rgbc12]>jkbvtydfg5879y8ouijknjbjbcskajhcvd%&hikj123*$#okjnjbhvfg{}&56rgbcgh]>jkbvtydfg5879y8ouijknjbjbcskajhcvd%&hikj123*$#okjnjbhvfg{}&56rgbcff]>jkbvtydfg5879y8ouijknjbjbcskajhcvd%&hikj123*$#okjnjbhvfg{}&56rgbcff]>jkbvtydfg5879y8ouijknjbjbcskajhcvd%&hikj123*$#okjnjbhvfg{}&56rgbcrr]>jkbvtydfg5879y8ouijknjbjbcskajhcvd%&hikj123*$#okjnjbhvfg{}&56rgbcgg]>jkbvtydfg5879y8ouijknjbjbcskajhcvd%&hikj123*$#okjnjbhvfg{}&56rgbcgg]>jkbvtydfg5879y8ouijknjbjbcskajhcvd%&hikj123*$#okjnjbhvfg{}&56rgbchh]>jkbvtydfg5879y8ouijknjbjbcskajhcvd%&hikj123*$#okjnjbhvfg{}&56rgbcjj]>jkbvtydfg5879y8ouijknjbjbcskajhcvd%&hikj123*$#okjnjbhvfg{}&56rgbchh]>jkbvtydfg5879y8ouijknjbjbcskajhcvd%&hikj123*$#okjnjbhvfg{}&56rgbc:[]>jkbvtydfg5879y8ouijknjbjbcskajhcvd%&hikj123*$#okjnjbhvfg{}&56rgbc:[]>jkbvtydfg5879y8ouijknjbjbcskajhcvd%&hikj123*$#okjnjbhvfg{}&56rgbc:[]>jkbvtydfg5879y8ouijknjbjbcskajhcvd%&hikj123*$#okjnjbhvfg{}" |


    @quiztitle2 @regression
    Scenario: Negative: verify that Quiz Title does not accept more that 1000 characters
      When I click on "Quizzes" button
      And I wait for 1 sec
      When I click "Create New Quiz" button
      And I wait for 1 sec
      And I type "bcskajhcvd%&hikj123*$#okjnjbhvfg{}&56rgbcgg]>jkbvtydfg5879y8ouijknjbjbcskajhcvd%&hikj123*$#okjnjbhvfg{}&56rgbc12]>jkbvtydfg5879y8ouijknjbjbcskajhcvd%&hikj123*$#okjnjbhvfg{}&56rgbcgh]>jkbvtydfg5879y8ouijknjbjbcskajhcvd%&hikj123*$#okjnjbhvfg{}&56rgbcff]>jkbvtydfg5879y8ouijknjbjbcskajhcvd%&hikj123*$#okjnjbhvfg{}&56rgbcff]>jkbvtydfg5879y8ouijknjbjbcskajhcvd%&hikj123*$#okjnjbhvfg{}&56rgbcrr]>jkbvtydfg5879y8ouijknjbjbcskajhcvd%&hikj123*$#okjnjbhvfg{}&56rgbcgg]>jkbvtydfg5879y8ouijknjbjbcskajhcvd%&hikj123*$#okjnjbhvfg{}&56rgbcgg]>jkbvtydfg5879y8ouijknjbjbcskajhcvd%&hikj123*$#okjnjbhvfg{}&56rgbchh]>jkbvtydfg5879y8ouijknjbjbcskajhcvd%&hikj123*$#okjnjbhvfg{}&56rgbcjj]>jkbvtydfg5879y8ouijknjbjbcskajhcvd%&hikj123*$#okjnjbhvfg{}&56rgbchh]>jkbvtydfg5879y8ouijknjbjbcskajhcvd%&hikj123*$#okjnjbhvfg{}&56rgbc:[]>jkbvtydfg5879y8ouijknjbjbcskajhcvd%&hikj123*$#okjnjbhvfg{}&56rgbc:[]>jkbvtydfg5879y8ouijknjbjbcskajhcvd%&hikj123*$#okjnjbhvfg{}&56rgbc:[]>jkbvtydfg5879y8ouijknjbjbcskajhcvd%&hikj123*$#okjnjbhvfg{}" in the Title field
      Then I click "Add Question"
      And I wait for 1 sec
      Then quiz page should be displayed
      Then I select "Textual" question
      And I wait for 1 sec
      And I type "Question 1 Test" into "Q1" question input field
      And I wait for 1 sec
      When I click "Save" button
      Then error message "too many characters" is displayed
      And I delete "bcskajhcvd%&hikj123*$#okjnjbhvfg{}&56rgbcgg]>jkbvtydfg5879y8ouijknjbjbcskajhcvd%&hikj123*$#okjnjbhvfg{}&56rgbc12]>jkbvtydfg5879y8ouijknjbjbcskajhcvd%&hikj123*$#okjnjbhvfg{}&56rgbcgh]>jkbvtydfg5879y8ouijknjbjbcskajhcvd%&hikj123*$#okjnjbhvfg{}&56rgbcff]>jkbvtydfg5879y8ouijknjbjbcskajhcvd%&hikj123*$#okjnjbhvfg{}&56rgbcff]>jkbvtydfg5879y8ouijknjbjbcskajhcvd%&hikj123*$#okjnjbhvfg{}&56rgbcrr]>jkbvtydfg5879y8ouijknjbjbcskajhcvd%&hikj123*$#okjnjbhvfg{}&56rgbcgg]>jkbvtydfg5879y8ouijknjbjbcskajhcvd%&hikj123*$#okjnjbhvfg{}&56rgbcgg]>jkbvtydfg5879y8ouijknjbjbcskajhcvd%&hikj123*$#okjnjbhvfg{}&56rgbchh]>jkbvtydfg5879y8ouijknjbjbcskajhcvd%&hikj123*$#okjnjbhvfg{}&56rgbcjj]>jkbvtydfg5879y8ouijknjbjbcskajhcvd%&hikj123*$#okjnjbhvfg{}&56rgbchh]>jkbvtydfg5879y8ouijknjbjbcskajhcvd%&hikj123*$#okjnjbhvfg{}&56rgbc:[]>jkbvtydfg5879y8ouijknjbjbcskajhcvd%&hikj123*$#okjnjbhvfg{}&56rgbc:[]>jkbvtydfg5879y8ouijknjbjbcskajhcvd%&hikj123*$#okjnjbhvfg{}&56rgbc:[]>jkbvtydfg5879y8ouijknjbjbcskajhcvd%&hikj123*$#okjnjbhvfg{}h" quiz
      And I wait for 4 sec
      And you confirm delete action
      #//Test failed, no error message is displayed

@quiztitle3 @regression
      Scenario: Negative: Verify that Title field is required
       When I click on "Quizzes" button
       And I wait for 1 sec
       When I click "Create New Quiz" button
       And I wait for 1 sec
       And I type "abc" in the Title field
       Then I click "Add Question"
       And I wait for 1 sec
       Then quiz page should be displayed
       Then I select "Textual" question
       And I wait for 1 sec
       And I type "Question 1 Test" into "Q1" question input field
       And I wait for 1 sec
       When I click on "Title" field
       And I clear Title field
       And I click "Save" button
       Then error message "This field is required" is displayed
       And I delete "abc" quiz
       And I wait for 4 sec
       And you confirm delete action
       #Test failed, no error message is displayed


