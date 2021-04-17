package definitions;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;

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
    String actErMess = getDriver().findElement(By.xpath("//simple-snack-bar")).getText();


  @Then("Error message should not be displayed")
  public void errorMessageShouldNotBeDisplayed() {
      assertThat(getDriver().findElement(By.xpath("//input[contains(@class,'mat-input')]/../../..//mat-error[@role='alert'])")).isDisplayed()).isFalse();
    }
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




