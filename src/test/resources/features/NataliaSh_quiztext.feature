@quiz_text
  Feature: Quiz text scenarios
    Background:
      Given I navigate to url "login"
      When I type "iceworm@gungratemail.com" for teacher credentials
      And I wait for 1 sec NS
      Then I type "QA12345!!" into password field
      And I wait for 1 sec NS
      Then I click button "Sign In"
      And I wait for 2 sec
      Then I click on "Quizzes" item
      And I wait for 1 sec NS

    @quiz_text1
    Scenario: [MC] Question Text: Allowable characters: Alphanumeric & Sp. characters
      When I click button "Create New Quiz" NS
      And I wait for 1 sec NS
      Then I type "API TEST" as a Quiz title
      And I wait for 1 sec NS
      Then I click "Add Question"
      And I click on "Multiple-Choice" type of question
      And I wait for 1 sec NS
      When I enter "What are the components of a bug report?" into "Q1" NS
      And I type "text 1" as "Option 1*" in "Q1" NS
      And I type "text 2" as "Option 2*" in "Q1" NS
      And I wait for 1 sec NS
      Then I select "Option 1*" as correct option in "Q1" NS
      And I wait for 1 sec NS
      And I click "Save" button
      And I wait for 1 sec NS
      Then "API TEST" is displayed on the list of quizzes NS
      And I wait for 1 sec NS
      And I delete "API TEST" quiz NS

    @quiz_text2
    Scenario: [MC] Text: Min 1 character
      When I click button "Create New Quiz" NS
      And I wait for 1 sec NS
      Then I type "Enter quiz name" as a Quiz title
      And I wait for 1 sec NS
      Then I click "Add Question"
      And I click on "Multiple-Choice" type of question
      And I wait for 1 sec NS
      When I enter "A" into "Q1" NS
      And I type "option 1 text" as "Option 1*" in "Q1" NS
      And I type "option 1 text" as "Option 2*" in "Q1" NS
      Then I select "Option 1*" as correct option in "Q1" NS
      And I click "Save" button
      And I wait for 1 sec NS
      Then "Enter quiz name" is displayed on the list of quizzes NS
      And I wait for 1 sec NS
      And I delete "Enter quiz name" quiz NS

    @quiz_text3
    Scenario: [MC] Question text Max 1000 characters
      When I click button "Create New Quiz" NS
      And I wait for 1 sec NS
      Then I type "The name of the quiz" as a Quiz title
      And I wait for 1 sec NS
      Then I click "Add Question"
      And I click on "Multiple-Choice" type of question
      And I wait for 1 sec NS
      When I enter 1000 alphanumeric characters into "Q1" NS
      When I enter "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim. Donec pede justo, fringilla vel, aliquet nec, vulputate eget, arcu. In enim justo, rhoncus ut, imperdiet a, venenatis vitae, justo. Nullam dictum felis eu pede mollis pretium. Integer tincidunt. Cras dapibus. Vivamus elementum semper nisi. Aenean vulputate eleifend tellus. Aenean leo ligula, porttitor eu, consequat vitae, eleifend ac, enim. Aliquam lorem ante, dapibus in, viverra quis, feugiat a, tellus. Phasellus viverra nulla ut metus varius laoreet. Quisque rutrum. Aenean imperdiet. Etiam ultricies nisi vel augue. Curabitur ullamcorper ultricies nisi. Nam eget dui. Etiam rhoncus. Maecenas tempus, tellus eget condimentum rhoncus, sem quam semper libero, sit amet adipiscing sem neque sed ipsum. N" into "Q1" NS
      And I type "option 1 text" as "Option 1*" in "Q1" NS
      And I type "option 1 text" as "Option 2*" in "Q1" NS
      Then I select "Option 1*" as correct option in "Q1" NS
      And I click "Save" button
      And I wait for 1 sec NS
      Then "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim. Donec pede justo, fringilla vel, aliquet nec, vulputate eget, arcu. In enim justo, rhoncus ut, imperdiet a, venenatis vitae, justo. Nullam dictum felis eu pede mollis pretium. Integer tincidunt. Cras dapibus. Vivamus elementum semper nisi. Aenean vulputate eleifend tellus. Aenean leo ligula, porttitor eu, consequat vitae, eleifend ac, enim. Aliquam lorem ante, dapibus in, viverra quis, feugiat a, tellus. Phasellus viverra nulla ut metus varius laoreet. Quisque rutrum. Aenean imperdiet. Etiam ultricies nisi vel augue. Curabitur ullamcorper ultricies nisi. Nam eget dui. Etiam rhoncus. Maecenas tempus, tellus eget condimentum rhoncus, sem quam semper libero, sit amet adipiscing sem neque sed ipsum. N" is displayed on the list of quizzes NS
      And I wait for 1 sec NS
      And I delete "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim. Donec pede justo, fringilla vel, aliquet nec, vulputate eget, arcu. In enim justo, rhoncus ut, imperdiet a, venenatis vitae, justo. Nullam dictum felis eu pede mollis pretium. Integer tincidunt. Cras dapibus. Vivamus elementum semper nisi. Aenean vulputate eleifend tellus. Aenean leo ligula, porttitor eu, consequat vitae, eleifend ac, enim. Aliquam lorem ante, dapibus in, viverra quis, feugiat a, tellus. Phasellus viverra nulla ut metus varius laoreet. Quisque rutrum. Aenean imperdiet. Etiam ultricies nisi vel augue. Curabitur ullamcorper ultricies nisi. Nam eget dui. Etiam rhoncus. Maecenas tempus, tellus eget condimentum rhoncus, sem quam semper libero, sit amet adipiscing sem neque sed ipsum. N" quiz NS

    @quiz_text4
    Scenario: [MC] Question text more than1000 characters
      When I click button "Create New Quiz" NS
      And I wait for 1 sec NS
      Then I type "The name of the quiz" as a Quiz title
      And I wait for 1 sec NS
      Then I click "Add Question"
      And I click on "Multiple-Choice" type of question
      And I wait for 1 sec NS
      When I enter "Lorem ipsum dolor sit amet, consectetuer adipiscing elit. Aenean commodo ligula eget dolor. Aenean massa. Cum sociis natoque penatibus et magnis dis parturient montes, nascetur ridiculus mus. Donec quam felis, ultricies nec, pellentesque eu, pretium quis, sem. Nulla consequat massa quis enim. Donec pede justo, fringilla vel, aliquet nec, vulputate eget, arcu. In enim justo, rhoncus ut, imperdiet a, venenatis vitae, justo. Nullam dictum felis eu pede mollis pretium. Integer tincidunt. Cras dapibus. Vivamus elementum semper nisi. Aenean vulputate eleifend tellus. Aenean leo ligula, porttitor eu, consequat vitae, eleifend ac, enim. Aliquam lorem ante, dapibus in, viverra quis, feugiat a, tellus. Phasellus viverra nulla ut metus varius laoreet. Quisque rutrum. Aenean imperdiet. Etiam ultricies nisi vel augue. Curabitur ullamcorper ultricies nisi. Nam eget dui. Etiam rhoncus. Maecenas tempus, tellus eget condimentum rhoncus, sem quam semper libero, sit amet adipiscing sem neque sed ipsum. Nw" into "Q1" NS
      And I type "option 1 text" as "Option 1*" in "Q1" NS
      And I type "option 1 text" as "Option 2*" in "Q1" NS
      Then I select "Option 1*" as correct option in "Q1" NS
      And I click "Save" button
      Then error message "More than 1000 characters is not accepted" should be displayed NS
#      No error message, user able to save the quiz with more than 1000 char

    @quiz_text5
    Scenario: [MC] Question Text: the field is required
      When I click button "Create New Quiz" NS
      And I wait for 1 sec NS
      Then I type "The name of the quiz" as a Quiz title
      And I wait for 1 sec NS
      Then I click "Add Question"
      And I click on "Multiple-Choice" type of question
      And I wait for 1 sec NS
      And I type "option 1 text" as "Option 1*" in "Q1" NS
      And I type "option 1 text" as "Option 2*" in "Q1" NS
      Then I select "Option 1*" as correct option in "Q1" NS
      And I click "Save" button
      Then error message "This field is required" should be displayed NS
      










      
     








