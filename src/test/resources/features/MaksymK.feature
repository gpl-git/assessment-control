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

      @gitPractice2
      Scenario: Engeneering Power Conwerter
        Given I navigate to "https://www.unitconverters.net/" web site
        Then logo should be present
        Then I wait for 1 seconds
        Then I click "Common Converters" from ALL CONVERTERS LIST
        Then I wait for 1 seconds
        Then I click "Engineering Converters" from ALL CONVERTERS LIST
        Then I wait for 1 seconds
        Then I choose "Power" from convertres sub-list
        Then I wait for 1 seconds
        Then the converter header name contains "Power"
        Then I wait for 1 seconds
        Then I set "500" to From value
        Then I wait for 1 seconds
        Then I choose "watt [W]" from FROM collumn list
        Then I wait for 2 seconds
        Then I choose "kilowatt [kW]" from TO collumn list
        Then I verify expected calculation result is "0.5"

    @gitPractice3
    Scenario Outline: For Engeneering Power Conwerter ALL POSITIONS
      Given I navigate to "https://www.unitconverters.net/" web site
      Then logo should be present
      Then I click "Common Converters" from ALL CONVERTERS LIST
      Then I click "Engineering Converters" from ALL CONVERTERS LIST
      Then I choose <converterKind> from convertres sub-list
      Then the converter header name contains <expConvName>
      Then I set <setValue> to From value
      Then I choose <optionFrom> from FROM collumn list
      Then I choose <optionTo> from TO collumn list
      Then I verify expected calculation result is <expectedRes>
      Examples:
        | converterKind | expConvName    | setValue      | optionFrom           |   optionTo                    | expectedRes    |
        | "Power"       | "Power"        | "50"          | "watt [W]"           | "kilowatt [kW]"               | "0.05"         |
        | "Power"       | "Power"        | "500"         | "watt [mW]"          | "centiwatt [cW]"              | "50000"        |
        | "Power"       | "Power"        | "140"         | "milliwatt [W]"      | "kilowatt [kW]"               | "0.5"          |
        | "Power"       | "Power"        | "7850"        | "MBH"                | "kilowatt [kW]"               | "2300.607"     |
        | "Power"       | "Power"        | "4755"        | "dekawatt [daW]"     | "kilowatt [kW]"               | "47.55"        |
