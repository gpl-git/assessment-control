  @Show-shopper works with half of wrong answers
  Feature:  Show-shopper works with half of wrong answers
  Backround:
  Scenario: Show-shopper works with half of wrong answers
    Given I navigate to the "http://ask-qa.portnov.com"
    Then I login as a Student
    And I wait for 1 sec
    Then I go to My Assignments
    And I wait for 2 sec
    Then I click on "Anna Hurska Test 22" button
    And I wait for 2 sec
    Then I choose the answer "testing for a business perspective"
    Then I choose the answer "To plan when to stop testing"
    Then I choose the answer "Module testing"
    Then I choose the answer "Recovery testing"
    Then I choose the answer "Initiating   corrective   actions"
    Then I choose the answer "An increment of Done software"
    Then I choose the answer "The complexity of the items being delivered"
    Then I choose the answer "At the end of each Sprint"
    #And I click on the Submit My Answers button


  @Show-shopper works with all correct answers
    Scenario: Show-shopper works with half of wrong answers
      Given I navigate to the "http://ask-qa.portnov.com"
      Then I login as a Student
      And I wait for 1 sec
      Then I go to My Assignments
      And I wait for 2 sec
      Then I click on "Anna Hurska Test 22" button
      And I wait for 2 sec
