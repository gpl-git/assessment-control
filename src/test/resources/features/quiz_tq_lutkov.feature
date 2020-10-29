@quiz
Feature: Quiz-Total Questions Scenarios

  @quiz1
  Scenario: 1 Textual Question Submitted
    Given I navigate to "Sign In" page
    When I "Sign In" with email: "ask_instr@aol.com" and password: "12345"
    #And I wait for 2 sec
    Then I check user role as "Teacher"




    And I wait for 5 sec