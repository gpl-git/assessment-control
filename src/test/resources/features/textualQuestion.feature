@textualquestion
Feature: Textual questions scenarios
  Background:
    Given I go to "login" page
    When I type "ogureckostya@howti.site" into email field
    And I enter "12345" as password
    When I click button "Sign In"
    And I wait for 2 sec
    When I click "Quizzes" menu item
    And I wait for 1 sec
    When I click button "Create New Quiz"
    And I wait for 1 sec
    When I type "00Test Quiz - Anastasiia" as quiz title
    And I add a question
    And I wait for 1 sec
    When I select "Textual" question type

  @textualquestion1
  Scenario: textual question doesn't accept 1000 characters
    When I type "mmkkkkkkkkkkklfdkfjgkfdjgkjdfklgjkldfjgkldfjgkjdlgkjslkdjlkjkljlkjiopjpoijiopjojopijiojljlkjkjljljljiojlojlkjlojljljlijlijlijiljlijljlijlijiljlijkljlijlijiljiljiljlikjlijlijlijlijlijlijijiljlijijijiljlijijiljiljilhlijhkjhjuhvhhjghjgjghjghjhfhfhgfhjfhfhfhgfghfghfgfhgfhgfhgfhgfghfghfhgfthfghfhgfghfghfghfhgfhgfgffghfghghfgfhgfhgfhgfgfghkgjfdlkjgkmklmslzmflc;skm;lfmdslkfmkldsmfklmdlkgmdkljglkdfjglkjfkdjglkfdkmkmmklmkmkmkmmmkkkkkkkkkkklfdkfjgkfdjgkjdfklgjkldfjgkldfjgkjdlgkjslkdjlkjkljlkjiopjpoijiopjojopijiojljlkjkjljljljiojlojlkjlojljljlijlijlijiljlijljlijlijiljlijkljlijlijiljiljiljlikjlijlijlijlijlijlijijiljlijijijiljlijijiljiljilhlijhkjhjuhvhhjghjgjghjghjhfhfhgfhjfhfhfhgfghfghfgfhgfhgfhgfhgfghfghfhgfthfghfhgfghfghfghfhgfhgfgffghfghghfgfhgfhgfhgfgfghkgjfdlkjgkmklmslzmflc;skm;lfmdslkfmkldsmfklmdlkgmdkljglkdfjglkjfkdjglkfdkmkmmklmkmkmkmmmkkkkkkkkkkklfdkfjgkfdjgkjdfklgjkldfjgkldfjgkjdlgkjslkdjlkjkljlkjiopjpoijiopjojopijiojljlkjewrsfesfleflklesfklekflejlkjflkekejglkesjgklesjklgjeslkjgkljglksgk"  into "Q1"
    When I click button "Save"
    And I wait for 3 sec
    Then quiz "00Test Quiz - Anastasiia" should be displayed on the list of quizzes
    And I wait for 1 sec
    And I delete "00Test Quiz - Anastasiia"

  @textualquestion2
  Scenario: textual question accepts 1001 characters
    When I type "nmmkkkkkkkkkkklfdkfjgkfdjgkjdfklgjkldfjgkldfjgkjdlgkjslkdjlkjkljlkjiopjpoijiopjojopijiojljlkjkjljljljiojlojlkjlojljljlijlijlijiljlijljlijlijiljlijkljlijlijiljiljiljlikjlijlijlijlijlijlijijiljlijijijiljlijijiljiljilhlijhkjhjuhvhhjghjgjghjghjhfhfhgfhjfhfhfhgfghfghfgfhgfhgfhgfhgfghfghfhgfthfghfhgfghfghfghfhgfhgfgffghfghghfgfhgfhgfhgfgfghkgjfdlkjgkmklmslzmflc;skm;lfmdslkfmkldsmfklmdlkgmdkljglkdfjglkjfkdjglkfdkmkmmklmkmkmkmmmkkkkkkkkkkklfdkfjgkfdjgkjdfklgjkldfjgkldfjgkjdlgkjslkdjlkjkljlkjiopjpoijiopjojopijiojljlkjkjljljljiojlojlkjlojljljlijlijlijiljlijljlijlijiljlijkljlijlijiljiljiljlikjlijlijlijlijlijlijijiljlijijijiljlijijiljiljilhlijhkjhjuhvhhjghjgjghjghjhfhfhgfhjfhfhfhgfghfghfgfhgfhgfhgfhgfghfghfhgfthfghfhgfghfghfghfhgfhgfgffghfghghfgfhgfhgfhgfgfghkgjfdlkjgkmklmslzmflc;skm;lfmdslkfmkldsmfklmdlkgmdkljglkdfjglkjfkdjglkfdkmkmmklmkmkmkmmmkkkkkkkkkkklfdkfjgkfdjgkjdfklgjkldfjgkldfjgkjdlgkjslkdjlkjkljlkjiopjpoijiopjojopijiojljlkjewrsfesfleflklesfklekflejlkjflkekejglkesjgklesjklgjeslkjgkljglksgk"  into "Q1"
    When I click button "Save"
    And I wait for 3 sec
    Then quiz "00Test Quiz - Anastasiia" should not be displayed on the list of quizzes
    And I wait for 1 sec

  @text3alquestion3
  Scenario: Textual Questions Quiz text field allows Alphanumeric & Sp characters
    When I enter "Happy2022!" into "Q1"
    When I click button "Save"
    And I wait for 2 sec
    Then quiz "00Test Quiz - Anastasiia" should be displayed on the list of quizzes
    And I wait for 1 sec
    And I delete "00Test Quiz - Anastasiia"

  @textualquestion4
  Scenario: Textual Questions Quiz text field cannot be blank
    When I enter "" into "Q1"
    When I click button "Save"
    And I wait for 2 sec
    Then "This field is required" error message should be displayed
    And I wait for 1 sec

  @textualquestion5
  Scenario: Textual Questions Quiz text field accepts min 1 character
    When I enter "H" into "Q1"
    When I click button "Save"
    And I wait for 2 sec
    Then quiz "00Test Quiz - Anastasiia" should be displayed on the list of quizzes
    And I wait for 1 sec
    And I delete "00Test Quiz - Anastasiia"
