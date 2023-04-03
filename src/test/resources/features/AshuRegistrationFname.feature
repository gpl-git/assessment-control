@FirstName

  Feature: Registration First Name


    @Fname
    Scenario: Verify Registration First Name field
      Given I navigate  to "registration" page
      And I click register me button
      Then fname error message should be displayed
      And fname error message "This field is required" should be displayed
      And I wait for 2 sec
      When I type "    AA  " into fname field
      Then fname  white space error message  "Whitespaces are not allowed"should be displayed
      And I wait for 2 sec
      And I clear fname field
      When I type "A3!sdghfn" into the fname field
#      Then fname error message should not be displayed
      And I wait for 2 sec
      And I clear fname field
      When I type maxium character "gcjvcvcvcgdgcjdkhc86868eg3eegttdghgdsed67e78dwsdgsajgdc67ed8tdjhgdjsgdjsgsddtsudtusjgdajsdjasgd876d8w6diwydgasjdgdsjdd87686diolydsgjdgjsad2876e23oieegwedje876dywiuedgwjdgqwe7682eugwdjgdjkhe87623euygdegdjgqwe6271euwdgwjdgejkwfue8712eyiywgdjgdjefuyggwewgeg"into fname field
      And I wait for 2 sec
      And I clear fname field
      When I type more than maxium cha "gcjvcvcvcgdgcjdkhc86868eg3eegttdghgdsed67e78dwsdgsajgdc67ed8tdjhgdjsgdjsgsddtsudtusjgdajsdjasgd876d8w6diwydgasjdgdsjdd87686diolydsgjdgjsad2876e23oieegwedje876dywiuedgwjdgqwe7682eugwdjgdjkhe87623euygdegdjgqwe6271euwdgwjdgejkwfue8712eyiywgdjgdjefuyggwewgegddsd" into fname field
      Then NO more than maxium char error message"No more than 254 charaters is not allowed " should be diplayed
      And I wait for 2 sec







