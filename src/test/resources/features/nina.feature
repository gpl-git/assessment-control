@test
  Feature: Working with Git commands

    @test1
    Scenario: My first Git project
      Given I navigate to "google"
      Then I should see title "google"
      When I type "git" in component with xpath ""
      And click component with xpath