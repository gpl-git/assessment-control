@registrationLastNameOksana
  Feature: Registration-Last Name
      Background:
        Given I navigate to the registration page

    @registrationLastNameOksana1
    Scenario: Verify that input field "Last Name" accepts Alphanumeric & Special characters
      Then I fill out input field "First Name" with "A"
      And I fill out input field "Last Name" with "ACBC,vde123:!@#$%"
      And I fill out input field "Email" with "zsaidsad22l@betofis2.com"
      And I fill out input field "Group Code" with "FGHJ12"
      And I fill out input field "Password" with "12345"
      And I am waiting for 1 sec
      And I fill out input field "Confirm Password" with "12345"
      And I am waiting for 1 sec
      And I push "Register Me" button
      And I am waiting for 3 sec
      Then message "You have been Registered." should be displayed on the page.

    @registrationLastNameOksana2
    Scenario: Verify that input filed "Last Name" can not be empty
      Then I fill out input field "First Name" with "A"
      And I fill out input field "Last Name" with ""
      And I fill out input field "Email" with "mzetrymw@bookiw.site"
      And I fill out input field "Group Code" with "FGHJ12"
      And I fill out input field "Password" with "12345"
      And I am waiting for 1 sec
      And I fill out input field "Confirm Password" with "12345"
      And I am waiting for 1 sec
      And I push "Register Me" button
      Then alert message "This field is required" should be displayed under input field "Last Name"

    @registrationLastNameOksana3
    Scenario: Verify that input field "Last Name" can accept 254 characters when the input field  First Name contain 1 char
      Then I fill out input field "First Name" with "A"
      And I fill out input field "Last Name" with "ksdfhskdfhsueryteuirtherhkjdvnhkjnksjdfhsudfhieurtyeriuhdkfjhskjfhskjdfhskdfhskfhuertyeiutyeiutyeirutyeiruhkhfsfhsdfhskdfhskdfhsdfhkjsjdhfksjdfhskdjfhskdjfhksdjfhskdjfhskdjfhskjdfhskdjfhskdjfhskdjfhsdkjfhskdjfhskdjfhskdjfhskdjfh,ksdfjhsdjkhskdjfhsskdfjhh"
      And I fill out input field "Email" with "rikhwan.fa@isueir.com"
      And I fill out input field "Group Code" with "FGHJ12"
      And I fill out input field "Password" with "12345"
      And I am waiting for 1 sec
      And I fill out input field "Confirm Password" with "12345"
      And I am waiting for 1 sec
      And I push "Register Me" button
      And I am waiting for 3 sec
      Then message "You have been Registered." should be displayed on the page.

    @registrationLastNameOksana4
    Scenario: Verify that input field "Last Name" doesn't accept 255 characters when the input field  First Name contain 1 char
      Then I fill out input field "First Name" with "A"
      And I fill out input field "Last Name" with "ksdfhskdfhsueryteuirtherhkjdvnhkjnksjdfhsudfhieurtyeriuhdkfjhskjfhskjdfhskdfhskfhuertyeiutyeiutyeirutyeiruhkhfsfhsdfhskdfhskdfhsdfhkjsjdhfksjdfhskdjfhskdjfhksdjfhskdjfhskdjfhskjdfhskdjfhskdjfhskdjfhsdkjfhskdjfhskdjfhskdjfhskdjfh,ksdfjhsdjkhskdjfhsskdfjhhg"
      And I fill out input field "Email" with "mlucasvogtvieira1@colevillecapital.com"
      And I fill out input field "Group Code" with "FGHJ12"
      And I fill out input field "Password" with "12345"
      And I am waiting for 1 sec
      And I fill out input field "Confirm Password" with "12345"
      And I am waiting for 1 sec
      And I push "Register Me" button
      Then alert message "No more than 254 characters allowed" should be displayed under input field "Last Name"
      #Known issue jira ticket AS-355

    @registrationLastNameOksana5
    Scenario: Verify that input field "Last Name" accept 1 character
      Then I fill out input field "First Name" with "A"
      And I fill out input field "Last Name" with "B"
      And I fill out input field "Email" with "oshanellen@rwgfeis.com"
      And I fill out input field "Group Code" with "FGHJ12"
      And I fill out input field "Password" with "12345"
      And I am waiting for 1 sec
      And I fill out input field "Confirm Password" with "12345"
      And I am waiting for 1 sec
      And I push "Register Me" button
      And I am waiting for 3 sec
      Then message "You have been Registered." should be displayed on the page.

    @registrationLastNameOksana6
    Scenario: Verify that input field "Last Name" doesn't accept text including white space
      Then I fill out input field "First Name" with "A"
      And I fill out input field "Last Name" with "B oro"
      And I fill out input field "Email" with "mlucasvogtvieira1@colevillecapital.com"
      And I fill out input field "Group Code" with "FGHJ12"
      And I fill out input field "Password" with "12345"
      And I am waiting for 1 sec
      And I fill out input field "Confirm Password" with "12345"
      And I am waiting for 1 sec
      And I push "Register Me" button
      Then alert message "Whitespaces are not allowed" should be displayed under input field "Last Name"














