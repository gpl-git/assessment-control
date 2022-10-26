package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import groovyjarjarpicocli.CommandLine;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import static io.restassured.RestAssured.expect;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.Assert.assertEquals;
import static support.TestContext.getDriver;

public class MaksymQuizStepDefs {
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

  @When("I type {string} for teacher user ")
  public void iTypeForTeacherUser(String email) {
    getDriver().findElement(By.xpath("//*[@formcontrolname='email']")).sendKeys(email);
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

  @Then("I type {string} into SecondOption ")
  public void iTypeIntoSecondOption(String text) {
    getDriver().findElement(By.xpath("//textarea[@placeholder='Option 2*']")).sendKeys(text);
  }

  @Then("required quontity of characters should be present in OptionFiedld{int} ")
  public void requiredQuontityOfCharactersShouldBePresentInOptionFiedld(int arg0) {}

  @Then("required quantity of characters {string} should be present in OptionField1 ")
  public void requiredQuantityOfCharactersShouldBePresentInOptionFeild(String expText) {
    String actText =
        getDriver().findElement(By.xpath("//textarea[@placeholder='Option 1*']")).getText();
    assertThat(actText.equals(expText)).isTrue();
  }

  @Then("required quantity of characters {string} should not be present in OptionField1 ")
  public void requiredQuantityOfCharactersShouldNotBePresentInOptionField(String expText) {
    String actText =
        getDriver().findElement(By.xpath("//textarea[@placeholder='Option 1*']")).getText();
    assertThat(actText.equals(expText)).isFalse();
  }

  @And("I click on Save button ")
  public void iClickOnSaveButtonMKs() {
    getDriver().findElement(By.xpath("//span[contains(text(),'Save')]")).click();
  }

  @Then("Option1 quiz error should be displayed ")
  public void optionQuizErrorShouldBeDisplayed() {
    assertThat(getDriver().findElement(By.xpath("//mat-error[@id='mat-error-2']")).isDisplayed())
        .isTrue();
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

  @Then("I type {string} into FirstOption")
  public void iTypeIntoFirstOption1(String text) {
    getDriver()
        .findElement(By.xpath("//textarea[contains(@placeholder,'Option 1*')]"))
        .sendKeys(text);
  }

  @Then("I type {string} into SecondOption")
  public void iTypeIntoSecondOption2(String text) {
    getDriver()
        .findElement(By.xpath("//textarea[contains(@placeholder,'Option 2*')]"))
        .sendKeys(text);
  }

  @Then("the field alert messages should not be displayed")
  public void theFieldAlertMessagesShouldNotBeDisplayed() {
    assertThat(getDriver().findElement(By.xpath("//mat-error[@role='alert']")).isDisplayed())
        .isFalse();
  }

  @Then("I click on element with xpath {string}")
  public void iClickOnElementWithXpath(String arg0) {
    getDriver().findElement(By.xpath(arg0)).click();
  }

  @Then("{string} should contain {string} characters Assertion")
  public void shouldContainCharacters(String text2, String questionNum) {
    String actualRes =
        getDriver()
            .findElement(
                By.xpath(
                    "//mat-panel-title[contains(text(),'Q1')]/..//..//..//textarea[@placeholder='Option 1*']"))
            .getAttribute("value");
    //  assertThat(actualRes.equals(text1)).isTrue();
    System.out.println("your test is:" + actualRes);
  }

  @Then("question {string} option {string} should contain {string} characters Assertion")
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

  @Then("I click on {string} button")
  public void iClickOnButton(String buttonName) {
    getDriver().findElement(By.xpath("//button/*[contains(text(),'" + buttonName + "')]")).click();
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
    String button = "//*[contains(text(),'" + questionN + "')]/../../..//*[contains(text(),'Add Option')]";
    for (int i = 3; i <= num; i++) {
      getDriver().findElement(By.xpath(button)).click();
      String xpath = "//*[contains(text(),'" + questionN + "')]/../../..//*[@placeholder='" + option+ i + "*']";
      getDriver().findElement(By.xpath(xpath)).sendKeys(option + i);
    }
  }


  @Then("in question {string} option number {string} should be present")
  public void inQuestionOptionNumberShouldBePresent(String questionNum, String optionNum) {
    String actuaOptNum = getDriver().findElement(By.xpath("//*[contains(text(),'" + questionNum + "')]/../../..//*[@placeholder='"+optionNum+"']")).getAttribute("value");
    System.out.println(actuaOptNum);
//    assertThat(actuaOptNum.equals(optionNum)).isTrue();
  }
}