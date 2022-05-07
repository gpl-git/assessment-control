@textualQuestion
Feature: Textual Question: Text

  Background:
    Given I navigate to URL "http://ask-qa.portnov.com/#/login"
    When I enter "lswsilkyboy@24hinbox.com" into the "email" filed
    And I enter "12345" into the "password" filed
    And I press "Sign In" button
    And I press "Quizzes" button
    And I press "Create New Quiz" button
    And I enter "!_Textual_Evgenii" into the "name" filed
    And I press Add Question button

  @text1
  Scenario Outline: The field is required & Max+1 & White space only
    When I press "Textual" question radio-button in "Q1"
    And I enter <text> in the Question Name filed of "Q1"
    And I press "Save" button
    And I wait for 2 seconds
    Then The snack-bar with error message is displayed
    Examples:
      | text |
      | "" |
      | " " |
      | "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis pellentesque mattis gravida. In hac habitasse platea dictumst. Sed sagittis leo id sem sagittis dapibus. Nulla a leo urna. Integer aliquet, libero sit amet malesuada imperdiet, mi elit posuere erat, eu accumsan velit orci id magna. Nullam consequat aliquet nisi a ultrices. Duis pellentesque diam in accumsan laoreet. Ut pulvinar neque vitae tempor ultrices. Mauris hendrerit arcu metus, iaculis sollicitudin turpis suscipit at. Integer interdum luctus pharetra. Donec nisl est, ornare ut scelerisque vel, volutpat vel dui. Suspendisse non quam ut lacus suscipit ultricies. Maecenas eget viverra dolor. Cras ac turpis id purus dapibus maximus sit amet ut dui. Aliquam sagittis consectetur augue ut iaculis. Cras erat metus, suscipit a turpis in, iperdiet tincidunt augue. Donec nisl est, ornare ut scelerisque vel, volutpat vel dui. Suspttendisse non quam ut lacus suscipit ultricies. Maecenas eget viverra dolor. Cras ac turpis id purusas"  |

  @text2
  Scenario Outline: Min/Max Characters & Special/Alphanumeric
    When I press "Textual" question radio-button in "Q1"
    And I enter <text> in the Question Name filed of "Q1"
    And I press "Save" button
    And I wait for 2 seconds
    Then The "!_Textual_Evgenii" quiz is saved and displayed in the list of quizzes
    When I delete the quiz "!_Textual_Evgenii" from the list of quizzes
    Examples:
      | text |
      | "A"  |
      | "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Duis pellentesque mattis gravida. In hac habitasse platea dictumst. Sed sagittis leo id sem sagittis dapibus. Nulla a leo urna. Integer aliquet, libero sit amet malesuada imperdiet, mi elit posuere erat, eu accumsan velit orci id magna. Nullam consequat aliquet nisi a ultrices. Duis pellentesque diam in accumsan laoreet. Ut pulvinar neque vitae tempor ultrices. Mauris hendrerit arcu metus, iaculis sollicitudin turpis suscipit at. Integer interdum luctus pharetra. Donec nisl est, ornare ut scelerisque vel, volutpat vel dui. Suspendisse non quam ut lacus suscipit ultricies. Maecenas eget viverra dolor. Cras ac turpis id purus dapibus maximus sit amet ut dui. Aliquam sagittis consectetur augue ut iaculis. Cras erat metus, suscipit a turpis in, imperdiet tincidunt augue. Donec nisl est, ornare ut scelerisque vel, volutpat vel dui. Suspendisse non quam ut lacus suscipit ultricies. Maecenas eget viverra dolor. Cras ac turpis id purusas"   |
      | "First question!@" |
      | "First question123" |
      | "First question123!@#" |