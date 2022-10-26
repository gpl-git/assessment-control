@option
Feature: Automate test set - Multiple choice question: Options. SEP22-274 Reporter: Galina Garaba

  Background:
    Given I open "login" page
    When I type "2112319@cloudscredit.com" for teacher user
    And I type "12345" as password
    When I click "Sign In" button
    And I wait for 1 sec
    Then "home" page will be displayed
    When I click on "Quizzes" menu item
    And I wait for 1 sec

  @option1
  Scenario: Test 1 Option text field accepts 1000 characters
    When I click on "Create new Quiz"
    And I wait for 1 sec
    And I type "Quiz Demo Martin - Automation" as quiz title
    And I click  "Add Question"
    And I wait for 1 sec
    Then I select "Multiple-Choice"
    And I wait for 1 sec
    Then I type "Option field accepts 1000 characters"
    Then I type text "Smoke1" into "Option 1*"
    Then I type text "Smoke2" into "Option 2*"
    And I select "Checkbox" as the correct answer
    And I click on "Save" button
    And I wait for 1 sec
    And I verify saved "Quiz Demo Martin - Automation" in displayed in quizzes
    Then I edit the quiz
    And I wait for 2 sec
    Then I clear text field of "Option 2*"
    Then I type text "1123djjjjbbnbnbjdhjkdkdkhdjshdjhdjdkn jdkdjkjkljkljfkjfkjkmnsdkd jksjdksjdlkjdsjdksjdkjksjdkjkkdjkdjks kdjskjkjdkjksjdkjshgddjjhdhhjjjjdhdhdhdhdhhdhdhdiuye87838748jjknndmmkleelk';erp[ep[rperkjeddhgjdjjjjbbnbnbjdhjkdkdkhdjshdjhdjdkn jdkdjkjkljkljfkjfkjkmnsdkd jksjdksjdlkjdsjdksjdkjksjdkjkkdjkdjks kdjskjkjdkjksjdkjshgddjjhdhhjjjjdhdhdhhdhdhdiuye87838748jjknndmmkleelk';erp[ep[rperkjeddhgjdjjjjbbnbnbjdhjkdkdkhdjshdjhdjdkn jdkdjkjkljkljfkjfkjkmnsdkd jksjdksjdlkjdsjdksjdkjksjdkjkkdjkdjks kdjskjkjdkjksjdkjshgddjjhdhhjjjjdhdhdhdhdhhdhdhdiuye87838748jjknndmmkleelk';erp[ep[rperkjeddhgjdjjjjbbnbnbjdhjkdkdkhdjshdjhdjdkn jdkdjkjkljkljfkjfkjkmnsdkd jksjdksjdlkjdsjdksjdkjksjdkjkkdjkdjks kdjskjkjdkjksjdkjshgddjjhdhhjjjjdhdhdhdhdhhdhdhdiuye87838748jjknndmmkleelk';erp[ep[rperkjeddhgjdjjjjbbnbnbjdhjkdkdkhdjshdjhdjdkn jdkdjkjkljkljfkjfkjkmnsdkd jksjdksjdlkjdsjdksjdkjksjdkjkkdjkdjks kdjskjkjdkjksjdkjshgddjjhdhhjjjjdhdhdhdhdhhdhdhdiuye87838748jjknndmmkleelk';erp[ep[rperkjeddnnnnnnnnnnnnnnnnnnlkjjghgjjjj" into "Option 2*"
    And I click on "Save" button
    And I wait for 1 sec
    And I verify saved "Quiz Demo Martin - Automation" in displayed in quizzes
    Then I delete the quiz

  @option2
  Scenario: Test 2 Option text field doesn't accept 1001 characters
    When I click on "Create new Quiz"
    And I wait for 1 sec
    And I type "Quiz Demo Martin - Automation" as quiz title
    And I click  "Add Question"
    And I wait for 1 sec
    Then I select "Multiple-Choice"
    And I wait for 1 sec
    Then I type "No more than 1000 characters is accepted in the option field"
    Then I type text "Smoke1" into "Option 1*"
    Then I type text "Smoke2" into "Option 2*"
    And I select "Checkbox" as the correct answer
    And I click on "Save" button
    And I wait for 1 sec
    And I verify saved "Quiz Demo Martin - Automation" in displayed in quizzes
    Then I edit the quiz
    And I wait for 2 sec
    Then I clear text field of "Option 2*"
    Then I type text "1111111111123djjjjbbnbnbjdhjkdkdkhdjshdjhdjdkn jdkdjkjkljkljfkjfkjkmnsdkd jksjdksjdlkjdsjdksjdkjksjdkjkkdjkdjks kdjskjkjdkjksjdkjshgddjjhdhhjjjjdhdhdhdhdhhdhdhdiuye87838748jjknndmmkleelk';erp[ep[rperkjeddhgjdjjjjbbnbnbjdhjkdkdkhdjshdjhdjdkn jdkdjkjkljkljfkjfkjkmnsdkd jksjdksjdlkjdsjdksjdkjksjdkjkkdjkdjks kdjskjkjdkjksjdkjshgddjjhdhhjjjjdhdhdhhdhdhdiuye87838748jjknndmmkleelk';erp[ep[rperkjeddhgjdjjjjbbnbnbjdhjkdkdkhdjshdjhdjdkn jdkdjkjkljkljfkjfkjkmnsdkd jksjdksjdlkjdsjdksjdkjksjdkjkkdjkdjks kdjskjkjdkjksjdkjshgddjjhdhhjjjjdhdhdhdhdhhdhdhdiuye87838748jjknndmmkleelk';erp[ep[rperkjeddhgjdjjjjbbnbnbjdhjkdkdkhdjshdjhdjdkn jdkdjkjkljkljfkjfkjkmnsdkd jksjdksjdlkjdsjdksjdkjksjdkjkkdjkdjks kdjskjkjdkjksjdkjshgddjjhdhhjjjjdhdhdhdhdhhdhdhdiuye87838748jjknndmmkleelk';erp[ep[rperkjeddhgjdjjjjbbnbnbjdhjkdkdkhdjshdjhdjdkn jdkdjkjkljkljfkjfkjkmnsdkd jksjdksjdlkjdsjdksjdkjksjdkjkkdjkdjks kdjskjkjdkjksjdkjshgddjjhdhhjjjjdhdhdhdhdhhdhdhdiuye87838748jjknndmmkleelk';erp[ep[rperkjeddnnnnnnnnnnnnnnnnnnlkjjghgjjjj" into "Option 2*"
    Then the button "Save" is disabled

  @option3
  Scenario: Test 3 Option text field accepts 1 character
    When I click on "Create new Quiz"
    And I wait for 1 sec
    And I type "Quiz Demo Martin - Automation" as quiz title
    And I click  "Add Question"
    And I wait for 1 sec
    Then I select "Multiple-Choice"
    And I wait for 1 sec
    Then I type "Option field allows a single character"
    Then I type text "Smoke1" into "Option 1*"
    Then I type text "Smoke2" into "Option 2*"
    And I select "Checkbox" as the correct answer
    And I click on "Save" button
    And I wait for 1 sec
    And I verify saved "Quiz Demo Martin - Automation" in displayed in quizzes
    Then I edit the quiz
    And I wait for 2 sec
    Then I clear text field of "Option 2*"
    Then I type text "1" into "Option 2*"
    Then the button "Save" is enabled
    And I wait for 1 sec
    And I click on "Save" button
    And I wait for 1 sec
    Then I delete the quiz

  @option4
  Scenario: Test 4 Unable to create a Multiple choice question with an empty Option text field
    When I click on "Create new Quiz"
    And I wait for 1 sec
    And I type "Quiz Demo Martin - Automation" as quiz title
    And I click  "Add Question"
    And I wait for 1 sec
    Then I select "Multiple-Choice"
    And I wait for 1 sec
    Then I type "Option does not allow empty option field"
    Then I type text "Smoke1" into "Option 1*"
    Then I type text "Smoke2" into "Option 2*"
    And I select "Checkbox" as the correct answer
    And I click on "Save" button
    And I wait for 1 sec
    And I verify saved "Quiz Demo Martin - Automation" in displayed in quizzes
    Then I edit the quiz
    And I wait for 2 sec
    Then I clear text field of "Option 2*"
    And I wait for 5 sec
    And I click on "Save" button
    And I wait for 3 sec
    And I should see error message


  @option5
  Scenario: Test 5 Option text field accepts special characters
    When I click on "Create new Quiz"
    And I wait for 1 sec
    And I type "Quiz Demo Martin - Automation" as quiz title
    And I click  "Add Question"
    And I wait for 1 sec
    Then I select "Multiple-Choice"
    And I wait for 1 sec
    Then I type "Option field allows a single character"
    Then I type text "Smoke1" into "Option 1*"
    Then I type text "Smoke2" into "Option 2*"
    And I select "Checkbox" as the correct answer
    And I click on "Save" button
    And I wait for 1 sec
    And I verify saved "Quiz Demo Martin - Automation" in displayed in quizzes
    Then I edit the quiz
    And I wait for 2 sec
    Then I clear text field of "Option 2*"
    Then I type text "!" into "Option 2*"
    Then the button "Save" is enabled
    And I click on "Save" button
    And I wait for 1 sec
    Then I delete the quiz

  @option6
  Scenario: Test 6 Options could be deleted
    When I click on "Create new Quiz"
    And I wait for 1 sec
    And I type "Quiz Demo Martin - Automation" as quiz title
    And I click  "Add Question"
    And I wait for 1 sec
    Then I select "Multiple-Choice"
    And I wait for 1 sec
    Then I type "One of 3 options can be deleted"
    Then I type text "Smoke1" into "Option 1*"
    Then I type text "Smoke2" into "Option 2*"
    And I select "Checkbox" as the correct answer