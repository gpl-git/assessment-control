@quiz_title
Feature: Quiz title scenarios

  Background:
    Given I navigate to "Login" page
    When I type "qa@ask.com" into email field
    When I type "12345" into password-field
    Then I push "Sign In" button
    Then I wait for 2 sec
    Then I click on "quizzes" on the side menu
    Then I wait for 2 sec
    Then I push "Create New Quiz" button
    Then I wait for 2 sec



#    Leading and trailing space characters to be eliminate when Quiz is saved in the List of Quizzes

  @quiz_title1
  Scenario Outline: Alphanumeric & Sp. characters are allowed
    When I type <quizName> into quizname field
    Then I click add question button
    Then I wait for 2 sec
    Then Error message should not be displayed
    Examples:
      | quizName          |
      | "go.veg.ru"       |
      | "123455787"       |
      | "rgruiikQp"       |
      | "!@#%^^&***(()_+" |
      | "JohnO'Grady"     |

  @quiz_title2
  Scenario: The field is required
    When I type "quizName" into quizname field
    Then I wait for 2 sec
    Then I clear the quizname field
    Then I click add question button
    Then I choose Question Type: Textual
    Then I type "?" in the Question field
    Then I clear the quizname field
    Then I push "Save" button
    Then I wait for 3 sec
    Then Error message should be displayed

  @quiz_title3
  Scenario: Min 1 Characters
    When I type "1" into quizname field
    Then I click add question button
    Then I wait for 2 sec
    Then Error message should not be displayed
    Then I choose Question Type: Textual
    Then I type "?" in the Question field
    Then I push "Save" button
    Then I find quiz with the name "1" in the quiz list
    Then I wait for 1 sec
    Then I click "1" quiz name
    Then I click "delete" button to delete the quiz

  @quiz_title4
  Scenario Outline: 1000 characters is acepted
    When I type <quizName> into quizname field
    Then I click add question button
    Then I wait for 2 sec
    Then Error message should not be displayed
    Then I choose Question Type: Textual
    Then I type "?" in the Question field
    Then I push "Save" button
    Then I wait for 1 sec
    Then I find quiz with the name <quizName> in the quiz list
    Then I click <quizName> quiz name
    Then I click "delete" button to delete the quiz
    Examples:
      | quizName                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                  |
      | "TvIVRoapUIf2qSYXFBv4qmxk7XADZfqRABq3D9zww5jzgoQPJaecdLjT6L0zF5diBWrr7J1qEHIoRvFo5v9nhErgurh4NJss1UVoU1rOGoEmJwpiuPOXy3FnZkb09U3K6Bv1Ro3AIERZIx0kjuyzGmLQjH3VS8e0AXXGD1aBqwSD1XBq5u3QkbRARqoSThoaz4wPQk4mpDrH8LDS5MemLEIYcFiCceXqUaORR7krm0mNNTCJNaNIWuLxuRXyL74ZeMgY1NbfiRERyqTn1N2nOO2Dx8pZrenUsuMuraxTBejYgOogrCrCMces9y7fsJa50rsZ9V1jSRM2zjyItEhTGRPWqdOEssKQqs6x5GEvKpwvYEQy0KbDemTQd5mSsiYg2Q97yKrDCU5wshCWMi7dQzjPaQtoI78sgulgrx6KOxPKJlAHPdJyyoNmF1i0Ov372K5Y4Gn7D0jDhefoMsfKYs7bNkDF0SgyZ0scJ3gnxHbNgt10P6jHWPCAgJTKgrjhNdrY3sVcTwECRqwDUtLLFRQaldh6CO26rqDnzArGpeM2wIgmr8rQ57lPr10L3wvzOeDMy0arCAhnnG7wDEp1v5xP08pdE1L2YTAyDOsKK3s6QRVwvbvSNvfZdZFWbHxytRWOeWSni4S9wiFWtQiE9t3JKMuvl7iPIYx2vU64lW2vJzYCqZoYxGZ3tGBKU6y0aNTVaJFKNHcTu6dw2TW3Gby1yl8RtzsN2LHHRanNhinVEOmFSgFtuajcvzrBOHPX0PLvjISXg0brI7EFFVCqH7VWxEnrv5XkEyfrUZqZ61l4UROzb1gQMbYv5rvL1LlC2L9ejZZlVE4fMjCwouoiqMyHIgOHNsN6mKaHndEgvYzMpIvATwS8DW8h91hi9GJ4Xvp45TWGYhNaKS0ibHLXYvE6Hs6fK15jaV40UeW7ryOiaEiUSJft2JKEFCYxhBASeYXasveW5Ke6vJdvUbxEVvq" |


  @quiz_title4
  Scenario Outline: 1001 characters is not accepted
    When I type <quizName> into quizname field
    Then I click add question button
    Then I wait for 2 sec
    Then I choose Question Type: Textual
    Then I type "?" in the Question field
    Then I push "Save" button
    Then Error message should be displayed
    Examples:
      | quizName                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                                    |
      | "rzG3Peiv31ZIHOKWLHX7Qi4m1zxNXWOVNYHw3xVZZP4HNNCqCnjDWRY27DfJaCUUdXxBSK9hRWWgQJXrp5gtvucXrKw01itKRQiexVbhRyKrYfUL601KTAQfgh1AvO0xrRFvIe4iEa6W4MjMgHUyim72RtzrMO6FIihrr5gaMCZwgvRmjG5GvtPWCsrSgF61G6bbJNPGhA67ZNJaE10tb5TomKH3f7VIJX6WWsKgsHisZalpgR9qiE8ax15EVfn3F7NEeChvEMUqvULMZKHYT9BFiB407hfrxSoDVjYdRwTtoFpN24mtUuOwJCBJFNToLifLvCq7rr0oc7sTlUkjAws25HXYjEXn4JObECXqOuLvh2MYrukrrwD0vjSXNN9KoH4zYTeamFGkY1nhwFNyr3oSUALFqeIniUvIS0ysC60gFKkv1Cnv83TrYRYIilM8Iwm7KNFDIFLqMqAVTE22zE1F6uNYeQ7mOhB1wbXIGjCXDkqy8ayr5ErlDuBjrSqLaZq9wmGmuqG4HxKCVaSy0EEgs3188aEhxXRuMmHGFsy3fi1z09vWyzKPwnaEsAXw2szxZSNZTQ1QUFYQEPXHeH5fBx502VJLFAFUGIQfg4249HcLDHiDNV82IfbSZgMKb5qmPPsuXaGs2hx1TeVTaaPhFj0MHA812F9hRI5MQI15U6A3eeh1YqTCOXoGJvFYtJsTTogKTo02s1hHY9w4l7ZDgEmKnkWqD8Zc2FsJPcYJ1hbCt29Qo0xqxOJi6AIiyMJsOQWmD10Qv7wYvDgKu91WjHgaZ5jLHIYHOrvYVqV7qE73PkYKrIIK1YQWzR6wSm7VQSEE4iCBs0Esywom3yvULNrv1WLsLT5PZz6P3fIOgdybUnnsTH5WHatpk32T7MPymrFLuII5uUf8hTsr1K6LOdcwaddw3b4i23Abe5vCLDvW2yWKq0Imx2Jbb7ohoYvighWCbqUt0xnbqysgmavV6wnVCFUoarsy0LvSp" |

  @quiz_title5
  Scenario: Leading space characters to be eliminate when Quiz is saved in the List of Quizzes
    When I type " quizName" into quizname field
    Then I click add question button
    Then I wait for 2 sec
    Then Error message should not be displayed
    Then I choose Question Type: Textual
    Then I type "?" in the Question field
    Then I push "Save" button
    Then I wait for 1 sec
    Then I find quiz with the name "quizName" in the quiz list
    Then I click "quizName" quiz name
    Then I click "delete" button to delete the quiz


    @quiz_title6
    Scenario: Trailing space characters to be eliminate when Quiz is saved in the List of Quizzes
      When I type "quizName " into quizname field
      Then I click add question button
      Then I wait for 2 sec
      Then Error message should not be displayed
      Then I choose Question Type: Textual
      Then I type "?" in the Question field
      Then I push "Save" button
      Then I wait for 1 sec
      Then I find quiz with the name "quizName" in the quiz list
      Then I click "quizName" quiz name
      Then I click "delete" button to delete the quiz

