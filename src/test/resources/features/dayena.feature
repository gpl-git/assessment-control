@test
  Feature: Test git
    @test1
    Scenario: Learning git commands
      Given I created account in git
      When I provide token
      Then it auth me as a User
