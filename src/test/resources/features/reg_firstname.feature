@registration @regression
  Feature: Registration FirstName
    Background:
      Given I go to "registration" page

      @regression
      Scenario: Registration First Name verification of confirmation
        When I type "OksanaS" into first name field
        And I type "Stefanyshyn" into last name field
        And I type "oksiest2@yahoo.com" into email field
        And I type "SOM" into group field
        And I type "12345" into password field
        And I type "12345" into confirm password field
        And I click on "Register Me" button
        And I wait for 1 sec
        Then I verify that element "You have been Registered." is present


    @regression1
    Scenario Outline: Registration First Name verification of confirmation parameterized
      When I type <fname> into first name field
      And I type "Stefanyshyn" into last name field
      And I type "oksiest2@yahoo.com" into email field
      And I type "SOM" into group field
      And I type "12345" into password field
      And I type "12345" into confirm password field
      And I click on "Register Me" button
      And I wait for 1 sec
      Then I verify that element <confMessage> is present
      Examples:
        | fname     | confMessage  |
        | "OksanaS" | "You have been Registered."|
        | "O"| "You have been Registered."|
#         Known issue ASKJ-
        | "dakjhsgdkawygekfuygkauwyegfkuygakehgfkauygekfugakweuyfgkauyegfkuagekfuyagjehfgkauywegfkugsekfygkugefkgksgerjhgsuegrseurgifusgerfkjhfgamsdhgfagkdgahjgefkhjagejmhgfkajhgfhagkdgkajhegfahjgsdkjhfgakejhfgajhgeffgkajhgfkjhgfhkjhghghghghghghghghghghghghghghghh" | "You have been Registered."|
        | "dakjhsgdkawygekfuygkauwyegfkuygakehgfkauygekfugakweuyfgkauyegfkuagekfuyagjehfgkauywegfkugsekfygkugefkgksgerjhgsuegrseurgifusgerfkjhfgamsdhgfagkdgahjgefkhjagejmhgfkajhgfhagkdgkajhegfahjgsdkjhfgakejhfgajhgeffgkajhgfkjhgfhkjhghghghghghghghghghghghghghghghhk" | "You have been Registered."|

    @regression2
    Scenario: Verify error messages for first name field
      When I type "13579" into first name field
      And I type "Stefanyshyn" into last name field
      And I type "oksiest2@yahoo.com" into email field
      And I type "SOM" into group field
      And I type "12345" into password field
      And I type "12345" into confirm password field
      And I click on "Register Me" button
      And I wait for 1 sec
      Then I verify that error message contains "Should contain only latin characters"


    @regression3
    Scenario Outline: Verify error messages for first name field parameterized
      When I type <fname> into first name field
      And I type "Stefanyshyn" into last name field
      And I type "oksiest2@yahoo.com" into email field
      And I type "SOM" into group field
      And I type "12345" into password field
      And I type "12345" into confirm password field
      And I click on "Register Me" button
      And I wait for 1 sec
      Then I verify that error message contains <errorMessage>
      Examples:
        | fname   | errorMessage                           |
        | "13579" | "Should contain only latin characters" |
        | "@#$%%^" | "Should contain only latin characters" |
        | "асддфг" | "Should contain only latin characters" |
        | "a d" | "Should contain only latin characters" |
        | "" | "This field is required" |
#      Known issue max+1 characters ASKJ-
        | "dakjhsgdkawygekfuygkauwyegfkuygakehgfkauygekfugakweuyfgkauyegfkuagekfuyagjehfgkauywegfkugsekfygkugefkgksgerjhgsuegrseurgifusgerfkjhfgamsdhgfagkdgahjgefkhjagejmhgfkajhgfhagkdgkajhegfahjgsdkjhfgakejhfgajhgeffgkajhgfkjhgfhkjhghghghghghghghghghghghghghghghhhf" | "Too many characters" |


