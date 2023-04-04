@emailRegistration

#Rita Kaminski's manual test set ASK_Online_02/27/2023FEB23-163


  Feature: Registration Email Field

    Background:
      Given I navigate to the "registration" page Assessment Control
      Then I fill out the registration form: FN as "Charlie", LN as "Polda", Group Code as "FEB23", Password "12345", Confirm Password "12345"
      And I wait for 1 sec

    @FEB23-168
    Scenario: Allowable characters: Alphanumeric
      When I fill the Email Field as "3Y56592277136a5bc@scurmail.com"
      And I click on Register Button
      And I wait for 1 sec
      Then registration confirmation page should be displayed


    @FEB23-169
    Scenario: Allowable characters: Special characters
      When I fill the Email Field as "#!*z!*y*%@scurmail.com"
      And I click on Register Button
      And I wait for 1 sec
      Then registration confirmation page should be displayed

    @FEB23-170
    Scenario: Email field required, can’t be empty
      When I fill the Email Field as ""
      And I click on Register Button
      And I wait for 1 sec
      Then I should get message "this field is required"

    @FEB23-323
    Scenario: Local port with 0 characters on the Left of an @ domain
      When I fill the Email Field as "@scurmail.com"
      And I click on Register Button
      Then I should get message "Should be a valid email address"

    @FEB23-172
    Scenario: Local port with 63 characters on the Left of an @ domain
      When I fill the Email Field as "Rd8vfnnXd1oVVgt7B9JAmh8qIzfQnNbuxPfj5rd7yYguJiqAdX7rCJgkOQVxity@scurmail.com"
      And I click on Register Button
      And I wait for 1 sec
      Then I have been successfully registered

    @FEB23-171
    Scenario: Local port with 64 characters on the Left of an @ domain
      When I fill the Email Field as "4odzk8b9IPvy0FgSSmbXPn3h7pe8VNh4tw93mQCjkCG32yVGXNXu1Wz2nuL8nBkS@scurmail.com"
      And I click on Register Button
      And I wait for 1 sec
      Then I have been successfully registered

    @FEB23-173
    Scenario: Local port with 65 characters on the Left of an @ domain
      When I fill the Email Field as "5BGi4jBsPMzJWx24Xn2OdjV7YVFiJTMP26lrLv7Zy8hoV7SM9ViFWPFJxIQ2HthOm@scurmail.com"
      And I click on Register Button
      Then I should get message "Should be a valid email address"

    @FEB23-321
    Scenario: Local port with 0 characters Right of @ domain
      When I fill the Email Field as "123abc@.com"
      And I click on Register Button
      And I wait for 1 sec
      Then I should get message "Should be a valid email address"

    @FEB23-175
    Scenario: Local port with 62 characters Right of @ domain
      When I fill the Email Field as "827abc@d2cKobLvzwK3m0S677jdGrYgL4Cxj8ZAp099urwLVfbYNamH1vyRmj4Wsp2G3F.com"
      And I click on Register Button
      And I wait for 1 sec
      Then I have been successfully registered

    @FEB23-174
    Scenario: Local port with 63 characters Right of @ domain
      When I fill the Email Field as "133abc@3bFo9ft7xtt7SiRivgDddQqFdEpFAkke2svNd8POcFsjP2noHeRaB0d3YRGzWlm.com"
      And I click on Register Button
      And I wait for 1 sec
      Then I have been successfully registered

    @FEB23-176
    Scenario: Local port with 64 characters Right of @ domain
      When I fill the Email Field as "123abc@QWlfsfhWdt98tOgouuXsb59MNjZkkkLKaUJx3YjkORWMqCGz2QvdjvLhN1m8NYr9.com"
      And I click on Register Button
      And I wait for 1 sec
      Then I should get message "Should be a valid email address"

    @FEB23-279

    #bug reported by Rita FEB23-460

    Scenario: Local port with 0 characters Right of (.) -no top level domain
      When I fill the Email Field as "abc123@scurmail"
      And I click on Register Button
      And I wait for 1 sec
      Then I should get message "Should be a valid email address"

    @FEB23-178
    Scenario: Local port with 62 characters right of (.) -last part of the domain
      When I fill the Email Field as "123abc@scurmail.9WPo2lkSxlj4EvnnHWhnyVlSlKB756c3WgAJMLqofHnKxvgF5DS3qOBK1gWVMm"
      And I click on Register Button
      And I wait for 1 sec
      Then I have been successfully registered

    @FEB23-177
    Scenario: Local port with 63 characters right of (.) -last part of the domain
      When I fill the Email Field as "123abc@scurmail.Wj16PVLVrhmkIlTnJFvgn5K5IjtK0j2dH12yivoPuIXDIf7OSkSmg5fPgDhOLKW"
      And I click on Register Button
      And I wait for 1 sec
      Then I have been successfully registered

    @FEB23-180
    Scenario: Local port with 64 characters right of (.) -last part of the domain
      When I fill the Email Field as "223abc@scurmail.Wj16PVLVBrhqgIlTnJFvgR5K5IjtKmj2dH12yivoPuIXDIf7OSkSmg5fPgDhOLKW"
      And I click on Register Button
      Then I should get message "Should be a valid email address"

    @FEB23-181
    Scenario: White spaces are not allowed -leading
      When I fill the Email Field as " 123abc@scurmail.com"
      And I click on Register Button
      Then I should get message "Should be a valid email address"

    @FEB23-317
    Scenario: White spaces are not allowed -trailing
      When I fill the Email Field as "123abc @scurmail.com"
      And I click on Register Button
      Then I should get message "Should be a valid email address"

    @FEB23-318
    Scenario: White spaces are not allowed -middle
      When I fill the Email Field as "123 abc@scurmail.com"
      And I click on Register Button
      Then I should get message "Should be a valid email address"

    @FEB23-183
    Scenario: Email 127 characters
      When I fill the Email Field as "92Wv5d8xW1rD3DlH177Sfgufl16qPpBMHQJs3JcOXhfnmTlFwJi7C2d92rKVqtEx@Oeac2vo5pBQYjuVbmB2QT2GdztADqWeF6jCcSKj81PJjmWwdumsQq3SvlE.yy5"
      And I click on Register Button
      And I wait for 1 sec
      Then I have been successfully registered

    @FEB23-182
    Scenario: Email 128 characters
      When I fill the Email Field as "79UQwerJsnQtkm67d8xfAmAhqOw4AbrrbBCj5TmtYEs4GM5e33rWrxSgWh3nODTS@pXRWDTarv4nXzIMxjdDYfi3za6coMC3QCwdji95ltTKnknixnktq9s8jHrn.eg8"
      And I click on Register Button
      And I wait for 1 sec
      Then I have been successfully registered

    @FEB23-183
    Scenario: Email 129 characters
      When I fill the Email Field as "T2bUQwerJsnQtkmw8d8xfAmAhqOw4AbrrbBCj5TmtYEs4GM5e33rWrxSgWh3nODTS@pXRWDTarv4nXzIMxjdDYfi3za6coMC3QCwdji95ltTKnknixnktq9s8jHrn.eg8"
      And I click on Register Button
      And I wait for 1 sec
      Then I should get message "Should be a valid email address"





























      
      





