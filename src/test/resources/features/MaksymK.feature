@gitPractice
  Feature: Learning Git

    @gitPractice1
    Scenario: Testing Something
      Given I navigate to "https://www.bing.com/" web site
      Then I type "Cucumber" into search field
      Then I wait for 2 seconds
      Then I click on find button
      Then I wait for 2 seconds
      Then search result "Cucumber" should be present
      Then I wait for 3 seconds
      Then I navigate to back
      Then I refresh the current page
      Then I click on Images link
      Then I wait for 3 seconds


