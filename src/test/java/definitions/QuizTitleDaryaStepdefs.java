package definitions;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.assertj.core.api.Assertions;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import support.TestContext;

public class QuizTitleDaryaStepdefs {

  @Given("I navigate to {string} page")
  public void iNavigateToPage(String url) {
    switch (url) {
      case "Login":
        getDriver().get("http://ask-qa.portnov.com/#/login");
        break;
      case "Registration":
        getDriver().get("http://ask-qa.portnov.com/#/registration");
        break;
      default:
        System.out.println("Link is not supported");
    }
  }

  @When("I type {string} into email field")
  public void iTypeIntoEmailField(String email) {
    getDriver().findElement(By.xpath("//input[@formcontrolname=\"email\"]")).sendKeys(email);
  }

  @When("I type {string} into password-field")
  public void iTypeIntoPasswordField(String password) {
    getDriver().findElement(By.xpath("//input[@formcontrolname=\"password\"]")).sendKeys(password);
  }

  @Then("I push {string} button")
  public void iPushButton(String buttontext) {
    getDriver().findElement(By.xpath("//span[contains(text(),'" + buttontext + "')]")).click();
  }

  @Then("I click on {string} on the side menu")
  public void iClickOnOnTheSideMenu(String menuitem) {
    getDriver().findElement(By.xpath("//a[contains(@href,'" + menuitem + "')]")).click();
  }

  @When("I type {string} into quizname field")
  public void iTypeIntoQuiznameField(String quizName) {
    getDriver().findElement(By.xpath("//input[contains(@class,'mat-input')]")).sendKeys(quizName);
  }

  @Then("I click add question button")
  public void iClickAddQuestionButton() {
    getDriver().findElement(By.xpath("//mat-icon[text()='add_circle']")).click();
  }

//  @Then("^element with xpath \"([^\"]*)\" should not be displayed$")
//  public void elementWithXpathShouldNotBeDisplayed(String xpath) {
//    assertThat(getDriver().findElement(By.xpath(xpath)).isDisplayed()).isFalse();
//  }
//}

//  @Then("message {string} is displayed")
//  public void messageIsDisplayed(String message) {
//    String actMessage = getDriver().findElement(By.xpath("//simple-snack-bar")).getText();
//    System.out.println(actMessage);
//    assertThat(actMessage.contains(message)).isTrue();

//    List<WebElement> elements = getDriver().findElement(By.xpath("//input[contains(@class,'mat-input')]/../../..//mat-error[@role='alert'])")).getText();
//    if (elements.isEmpty())
//    {
//      // element doesn't exist
//      return false;
//    }
//    else
//    {
//      // element exists, check for visibility
//      return elements.get(0).isDisplayed();
//    }
//  }
//  }
//}

  //
//  @Then("Error message should not be displayed")
//  public void errorMessageShouldNotBeDisplayed() {
//    Assertions.assertThat(TestContext.getDriver()
//        .findElement(By.xpath("//input[contains(@class,'mat-input')]/../../../div/div/mat-error"))
//        .isDisplayed()).isFalse();
//  }
//
//    @Then("{string} should not be displayed")
//    public void shouldNotBeDisplayed(String error_message) {
//      Assertions.assertThat(TestContext.getDriver().findElement(By.id("mat-error-2")).isDisplayed()).isFalse();

  @Then("Error message should not be displayed")
  public void errorMessageShouldNotBeDisplayed() {
    Assertions.assertThat(getDriver()
        .findElements(By.xpath("//input[contains(@class,'mat-input')]/../../../div/div/mat-error"))
        .size() == 0).isTrue();
  }

  @Then("Error message should be displayed")
  public void errorMessageShouldBeDisplayed() {
    getDriver()
        .findElement(By.xpath("//input[contains(@class,'mat-input')]/../../../div/div/mat-error"))
        .isDisplayed();
  }

  @Then("I clear the quizname field")
  public void iClearTheQuiznameField() {
    getDriver().findElement(By.xpath("//input[contains(@class,'mat-input')]")).clear();
  }

  @Then("I choose Question Type: Textual")
  public void iChooseQuestionTypeTextual() {
    getDriver().findElement(By.xpath("//mat-radio-button[contains(@class,'radio')][1]")).click();
  }

  @Then("I type {string} in the Question field")
  public void iTypeInTheQuestionField(String text) {
    getDriver().findElement(By.xpath("//textarea[contains(@class,'input')]")).sendKeys(text);
  }

  @Then("I find quiz with the name {string} in the quiz list")
  public void iFindQuizWithTheNameInTheQuizList(String quizName) {
      WebElement expectedText = getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'" + quizName + "')]"));
      assertThat(expectedText.isDisplayed()).isTrue();
  }
//
//  @Then("I click {string} quiz name and {string} quiz")
//  public void iClickQuizNameAndQuiz(String quizname, String buttonName) {
//      getDriver().findElement(By.xpath("//mat-panel-title[contains(text(), '" + quizname + "')]")).click();
//      getDriver().findElement(By.xpath("//mat-panel-title[contains(text(), '" + quizname + "')]/../../..//*[contains(text(),'delete')]")).click();


  @Then("I click {string} quiz name")
  public void iClickQuizNameQuizName(String quizName) {
    getDriver().findElement(By.xpath("//mat-panel-title[contains(text(), '" + quizName + "')]")).click();
  }

  @Then("I click {string} button to delete the quiz")
  public void iClickButtonToDeleteTheQuiz(String quizName) {
    getDriver().findElement(By.xpath("//mat-panel-title[contains(text(), '" + quizName + "')]/../../..//*[contains(text(),'delete')]")).click();
  }
}
