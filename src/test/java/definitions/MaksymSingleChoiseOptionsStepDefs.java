package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import groovyjarjarpicocli.CommandLine;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

import static io.restassured.RestAssured.expect;
import static io.restassured.RestAssured.get;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.Assert.assertEquals;
import static support.TestContext.getDriver;

public class MaksymSingleChoiseOptionsStepDefs {
  @Given("I open {string} page ")
  public void iOpenPage(String url) {
    if (url.equals("login")) {
      getDriver().get("http://ask-qa.portnov.com/#/login");
    } else if (url.equals("registration")) {
      getDriver().get("http://ask-qa.portnov.com/#/registration");
    } else {
      System.out.println("This url is not supported: " + url);
    }
  }

  @And("I wait for {int} sec ")
  public void iWaitForSec(int sec) throws InterruptedException {
    Thread.sleep(sec * 1000);
  }

  @And("I type {string} as password ")
  public void iTypeAsPassword(String password) {
    getDriver().findElement(By.xpath("//*[@formcontrolname='password']")).sendKeys(password);
  }

  @When("I click {string} button ")
  public void iClickButton(String btnName) {
    getDriver().findElement(By.xpath("//span[contains(text(),'" + btnName + "')]")).click();
  }

  @Then("{string} page will be displayed ")
  public void pageWillBeDisplayed(String expectedUrl) {
    String curUrl = getDriver().getCurrentUrl();
    assertThat(curUrl.contains(expectedUrl)).isTrue();
  }

  @When("I click on {string} menu item ")
  public void iClickOnMenuItem(String menuItem) {
    getDriver().findElement(By.xpath("//h5[contains(text(),'" + menuItem + "')]")).click();
  }

  @When("I type {string} as quiz title ")
  public void iTypeAsQuizTitle(String title) {
    getDriver().findElement(By.xpath("//*[@formcontrolname='name']")).sendKeys(title);
  }

  @And("I add a question ")
  public void iAddAQuestion() {
    getDriver().findElement(By.xpath("//mat-icon[text()='add_circle']")).click();
  }

  @When("I select {string} question ")
  public void iSelectQuestion(String questionType) {
    getDriver().findElement(By.xpath("//*[contains(text(),'" + questionType + "')]")).click();
  }

  @When("I type {string} into {string} ")
  public void iTypeInto(String questionText, String questionNum) {
    getDriver()
        .findElement(
            By.xpath(
                "//mat-panel-title[contains(text(),'"
                    + questionNum
                    + "')]/../../..//textarea[@formcontrolname='question']"))
        .sendKeys(questionText);
  }

  @And("I type {string} as {string} in {string} ")
  public void iTypeAsIn(String optionText, String optionNum, String questionNum) {
    getDriver()
        .findElement(
            By.xpath(
                "//mat-panel-title[contains(text(),'"
                    + questionNum
                    + "')]/../../..//textarea[@placeholder='"
                    + optionNum
                    + "']"))
        .sendKeys(optionText);
  }

  @Then("I select {string} as correct option in {string} ")
  public void iSelectAsCorrectOptionIn(String optionNum, String questionNum) {
    getDriver()
        .findElement(
            By.xpath(
                "//mat-panel-title[contains(text(),'"
                    + questionNum
                    + "')]/../../..//textarea[@placeholder='"
                    + optionNum
                    + "']/../../../../../mat-radio-button"))
        .click();
  }

  @Then("quiz {string} is displayed on the list of quizzes ")
  public void quizIsDisplayedOnTheListOfQuizzes(String title) {
    assertThat(
            getDriver()
                .findElement(By.xpath("//mat-panel-title[contains(text(),'" + title + "')]"))
                .isDisplayed())
        .isTrue();
  }

  @And("I delete quiz {string} ")
  public void iDeleteQuiz(String title) throws InterruptedException {
    getDriver()
        .findElement(By.xpath("//mat-panel-title[contains(text(),'" + title + "')]"))
        .click();
    getDriver()
        .findElement(
            By.xpath(
                "//mat-panel-title[contains(text(),'"
                    + title
                    + "' )]/../../..//*[contains(text(),'Delete')]"))
        .click();
    getDriver()
        .findElement(By.xpath("//div[@class='mat-dialog-actions']//*[contains(text(),'Delete')]"))
        .click();
    Thread.sleep(1000);
  }

  @Then("I type {string} into FirstOption ")
  public void iTypeIntoFirstOption(String text) {
    getDriver().findElement(By.xpath("//textarea[@placeholder='Option 1*']")).sendKeys(text);
  }

  @And("I click on Save button ")
  public void iClickOnSaveButtonMKs() {
    getDriver().findElement(By.xpath("//span[contains(text(),'Save')]")).click();
  }

  @And("I click on element with xpath {string} ")
  public void iClickOnElementWithXpathMKs(String path) {
    getDriver().findElement(By.xpath(path)).click();
  }

  @Then("error messages should not be displayed ")
  public void errorMessagesShouldNotBeDisplayed() {
    assertThat(getDriver().findElement(By.xpath("//mat-error[@id='mat-error-5']")).isDisplayed())
        .isFalse();
  }

  @Then("the field alert messages should not be displayed")
  public void theFieldAlertMessagesShouldNotBeDisplayed() {
    assertThat(getDriver().findElement(By.xpath("//mat-error[@role='alert']")).isDisplayed())
        .isFalse();
  }


  @Then("question {string} option {string} should contain {string} Assertion")
  public void questionOptionShouldContainCharactersAssertion(
      String questionNum, String optionNum, String expectedText) {
    String actualText =
        getDriver()
            .findElement(
                By.xpath(
                    "//mat-panel-title[contains(text(),'"
                        + questionNum
                        + "')]/..//..//..//textarea[@placeholder='"
                        + optionNum
                        + "']"))
            .getAttribute("value");
    assertThat(actualText.equals(expectedText)).isTrue();
  }

  @Then("question {string} option {string} should not contain {string} characters Assertion")
  public void questionOptionShouldNotContainCharactersAssertion(
      String questionNum, String optionNum, String expectedText) {
    String actualText =
        getDriver()
            .findElement(
                By.xpath(
                    "//mat-panel-title[contains(text(),'"
                        + questionNum
                        + "')]/..//..//..//textarea[@placeholder='"
                        + optionNum
                        + "']"))
            .getAttribute("value");
    assertThat(actualText.equals(expectedText)).isFalse();
  }

  @Then("warning message should appear")
  public void popUpWarningMessageShouldAppear() {
    String pop_upMessage =
        getDriver()
            .findElement(
                By.xpath(
                    "//mat-panel-title[contains(text(),'Q1')]/..//..//..//textarea[@placeholder='Option 1*']//..//..//..//mat-error[@role='alert']"))
            .getText();
    assertThat(pop_upMessage.contains("This field is required")).isTrue();
  }

  @Then("warning message should not appear")
  public void warningMessageShouldNotAppear() {
    assertThat(
            getDriver()
                .findElement(
                    By.xpath(
                        "//mat-panel-title[contains(text(),'Q1')]/..//..//..//textarea[@placeholder='Option 1*']//..//..//..//mat-error[@role='alert']"))
                .isDisplayed())
        .isFalse();
  }

  @Then("I click on element using JavaScript with xpath {string}")
  public void iClickOnElementUsingJavaWithXpath(String xpath) {
    WebElement element = getDriver().findElement(By.xpath(xpath));
    JavascriptExecutor executor = (JavascriptExecutor) getDriver();
    executor.executeScript("arguments[0].click();", element);
  }

  @And("I add {int} options to question {string}")
  public void iAddOptionsToQuestion(int num, String questionN) {
    String option = "Option ";
    String button =
        "//*[contains(text(),'" + questionN + "')]/../../..//*[contains(text(),'Add Option')]";
    for (int i = 3; i <= num; i++) {
      getDriver().findElement(By.xpath(button)).click();
      String xpath =
          "//*[contains(text(),'"
              + questionN
              + "')]/../../..//*[@placeholder='"
              + option
              + i
              + "*']";
      getDriver().findElement(By.xpath(xpath)).sendKeys(option + i);
    }
  }

  @Then("I click on settings button in option {string}")
  public void iClickOnSettingsButtonInOption(String optionNum) {
    getDriver()
        .findElement(
            By.xpath(
                "//mat-panel-title[contains(text(),'Q1')]/..//..//.//mat-panel-title[contains(text(),'Q1')]/..//..//..//textarea[@placeholder='"
                    + optionNum
                    + "']/..//..//..//..//..//../mat-icon[@role='img']"))
        .click();
  }

  @Then("I clear {string} option {string} text field")
  public void iClearOptionTextField(String questionNum, String optionNum) {
    getDriver()
        .findElement(
            By.xpath(
                "//*[contains(text(),'"
                    + questionNum
                    + "')]/../../..//*[@placeholder='"
                    + optionNum
                    + "']"))
        .clear();
  }

  @Then("no error messages like {string}")
  public void noErrorMessagesLikeRed(String arg0, String arg1) {}

  @Then("number of options is equal to {int}")
  public void numberOfOptionsIsEqualTo(int numOfOptions) {
    List<WebElement> options = new ArrayList();
    options = getDriver().findElements(By.xpath("//textarea[contains(@placeholder, 'Option')]"));
    int size = options.size();
    System.out.println("the number of options: " + size);
    assertThat(size == numOfOptions).isTrue();
  }

  @Then("I delete input field for option {string}")
  public void iDeleteInputField(String optionNum) throws InterruptedException {
    getDriver()
        .findElement(
            By.xpath("//textarea[@placeholder='" + optionNum + "']/../../../../..//mat-icon"))
        .click();
    Thread.sleep(1000);
    getDriver().findElement(By.xpath("//*[text()='Delete Option']")).click();
  }

  @Then("I move down option {string}")
  public void iMoveDownOption(String optionNum) throws InterruptedException {
    getDriver()
        .findElement(
            By.xpath("//textarea[@placeholder='" + optionNum + "']/../../../../..//mat-icon"))
        .click();
    Thread.sleep(1000);
    getDriver().findElement(By.xpath("//*[text()='Move option down']")).click();
  }

  @Then("I move up option {string}")
  public void iMoveUpOption(String optionNum) throws InterruptedException {
    getDriver()
        .findElement(
            By.xpath("//textarea[@placeholder='" + optionNum + "']/../../../../..//mat-icon"))
        .click();
    Thread.sleep(1000);
    getDriver().findElement(By.xpath("//*[text()='Move option up']")).click();
  }

  @Then("I enter {int} alphanumeric characters to option {string}")
  public void iEnterAlphanumericCharactersToOption(int number, String optionNum) {
    boolean useLetters = true;
    boolean useNumbers = true;
    String generatedString = RandomStringUtils.random(number, useLetters, useNumbers);
    // System.out.println(generatedString);
    getDriver()
        .findElement(By.xpath("//textarea[@placeholder='" + optionNum + "']"))
        .sendKeys(generatedString);
  }

  @When("I enter {int} alphanumeric characters to {string} in {string}")
  public void iEnterAlphanumericCharacters(int number, String optionNum, String questionNum) {
    boolean useLetters = true;
    boolean useNumbers = true;
    String generatedString = RandomStringUtils.random(number, useLetters, useNumbers);
    // System.out.println(generatedString);
    getDriver()
        .findElement(
            By.xpath(
                "//*[contains(text(),'"
                    + questionNum
                    + "')]/../../..//*[@placeholder='"
                    + optionNum
                    + "']"))
        .sendKeys(generatedString);
  }

  @Then("question {string} option {string} should contain {int} characters ASSERTION")
  public void questionOptionShouldContainCharacters(
      String questionNum, String optionNum, int quontityOfCharacters) {
    int actulLength =
        getDriver()
            .findElement(
                By.xpath(
                    "//*[contains(text(),'"
                        + questionNum
                        + "')]/../../..//*[@placeholder='"
                        + optionNum
                        + "']"))
            .getAttribute("value")
            .length();
    System.out.println("actual length of characters is: " + actulLength);
    assertThat(actulLength == quontityOfCharacters).isTrue();
  }
}
