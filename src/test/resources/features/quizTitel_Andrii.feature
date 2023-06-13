@quizTitel
  Feature: Change User`s name
    @quiz_TC1
    Scenario: TC_1 Max 256 characters including 1 space between two words
      Given I open page "login"
      When I provide login "celinefenaux@tubidu.com" for user
      When I provide password "abc123" for user
      When I klick on button "Sign In"
      When I click on menu "Settings"
      And I wait 2 sec
      When I click on button "Change Your Name" and put new name "styuergfhdtryetxxlggdggfgtrgdtegdtgetdgsjsjjhzcvcvbcbnvhuhfrhfgehfbsjbhdjshgedvscbsvcnxbcvgsdvcsdgyegsyegyjdsbhcjvgvcgdsvchkhcegfuwiu egfuywegfywegfyegfyegfyegfyegfyegfyehdncjsjidjwshsjbxhsbcghdvgcvdcgdhcbjhduehudhehcbsjawhhdkuahbschbdcdgjfjdjdjdjdjdjkkkkk"
      And I wait 3 sec

