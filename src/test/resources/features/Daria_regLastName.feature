@regLastName

  Feature: Registration Last Name Scenarios

    Background:
      Given I open "registration" website
      When I type "T" into firstname field
      And I type "tok@mail.com" into email field
      Then I type "111" into group code field
      When I type "12345" into password field
      Then I type "12345" into confirmPassword field

    @regLastName1
    Scenario: Min 1 character
      When I type "J" into lastname field
      When I click "Register Me" button
      Then I wait for 3 sec
#      Then "You have been Registered." confirmation message should be displayed
      Then "You have been Registered." message should be present -DV
      And I wait for 3 sec

    @regLastName2
    Scenario: White spaces are not allowed
      When I type "J Z " into lastname field
      Then I click "Register Me" button
      Then "Whitespaces are not allowed" error message should be displayed

    @regLastName3
    Scenario: Last Name field required, can’t be empty
      Then I click "Register Me" button
      And "This field is required" error message should be displayed

    @regLastName4
    Scenario: Max 254 characters (When the First name 1 char)
      When I type "jkjddfjkfddjjgdhjkjhjchjkjvcvbjkvcvbnmbvcvkkjhghjhgfxghjkjhgfdfghjvcdyujdyhvfyujfyjvcfhbvfghbvcfhjhkhyujbghjbvghbvghnbvghnbvghnbvghbvghbgftyhgfdrgfcdrfxsdfcdfrgcdfgbvghjbghjnhjkhjmnjkjkilkolkjkjnhjhbghbvfgvcdfgvfgvcfgvcfgbvfgvfgbvfgvfgvcfgvcfgfghbvfgbvcf" into lastname field
      Then I wait for 4 sec
      Then I click "Register Me" button
      And I wait for 4 sec
#      And "You have been Registered." confirmation message should be displayed
      Then "You have been Registered." message should be present -DV

    @regLastName5
    Scenario: Max +1 characters (When the First name 1 char)
      When I type "jkjddfjkfddjjgdhjkjhjchjkjvcvbjkvcvbnmbvcvkkjhghjhgfxghjkjhgfdfghjvcdyujdyhvfyujfyjvcfhbvfghbvcfhjhkhyujbghjbvghbvghbvghnbvghnbvghbvghbgftyhgfdrgfcdrfxsdfcdfrgcdfgbvghjbghjnhjkhjmnjkjkilkolkjkjnhjhbghbvfgvcdfgvfgvcfgvcfgbvfgvfgbvfgvfgvcfgvcfgfghbvfgbvcghj" into lastname field
      Then I wait for 3 sec
      Then I click "Register Me" button
      And I wait for 3 sec
#      Then "Data too long for column 'name' at row 1" error message should be displayed
      Then "Data too long for column 'name' at row 1" error message should be present -DV

    @regLastName6
    Scenario: Allowable characters: Alphanumeric & Special characters
      When I type "Abcd123@#$+=" into lastname field
      Then I wait for 3 sec
      Then I click "Register Me" button
      Then I wait for 3 sec
#      Then "You have been Registered." confirmation message should be displayed
      Then "You have been Registered." message should be present -DV

   




      

      

