package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import cucumber.api.java8.Th;
import org.openqa.selenium.By;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class QuestionEvgeniiStepDefs {
    @Given("I navigate to URL {string}")
    public void iNavigateToURL(String url) {
        getDriver().navigate().to(url);
    }

    @And("I wait for {int} seconds")
    public void iWaitForSecondS(int sec) throws InterruptedException {
        Thread.sleep(sec * 1000);
    }

    @When("I enter {string} into the {string} filed")
    public void iEnterIntoTheFiled(String text, String fieldName) {
        getDriver().findElement(By.xpath("//*[contains(@formcontrolname, '"+ fieldName +"')]")).sendKeys(text);
    }

    @And("I press {string} button")
    public void iPressButton(String btnName) throws InterruptedException {
        getDriver().findElement(By.xpath("//*[contains(text(),'"+ btnName +"')]/..")).click();
        Thread.sleep(1000);
    }

    @And("I press Add Question button")
    public void iPressAddQuestionButton() throws InterruptedException {
        getDriver().findElement(By.xpath("//*[contains(text(),'add_circle')]/..")).click();
        Thread.sleep(500);
    }

    @When("I press {string} question radio-button in {string}")
    public void iPressQuestionRadioButtonIn(String qTypeName, String qNum) {
        getDriver().findElement(By.xpath("//*[contains(text(),'"+qNum+"')]/../../..//*[contains(text(),'"+qTypeName+"')]/..")).click();
    }

    @When("I enter {string} in the Question Name filed of {string}")
    public void iEnterInTheQuestionNameFiledOf(String text, String qNum) {
        getDriver().findElement(By.xpath("//*[contains(text(),'"+ qNum +"')]/../../..//*[@placeholder='Question *']")).sendKeys(text);
    }

    @Then("The snack-bar with error message is displayed")
    public void theSnackBarWithErrorMessageIsDisplayed() {
        assertThat(getDriver().findElement(By.xpath("//simple-snack-bar[contains(text(), 'Quiz is not completed')]")).isDisplayed()).isTrue();
    }

    @Then("The {string} quiz is saved and displayed in the list of quizzes")
    public void theQuizIsSavedAndDisplayedInTheListOfQuizzes(String quizName) {
        assertThat(getDriver().findElement(By.xpath("//*[contains(text(), '"+quizName+"')]")).isDisplayed()).isTrue();
    }

    @When("I delete the quiz {string} from the list of quizzes")
    public void iDeleteTheQuizFromTheListOfQuizzes(String quizName) throws InterruptedException {
        getDriver().findElement(By.xpath("//*[contains(text(), '"+quizName+"')]")).click();
        getDriver().findElement(By.xpath("//*[contains(text(), '!_Textual')]/../../..//*[contains(text(), 'Delete')]")).click();
        getDriver().findElement(By.xpath("//div[@mat-dialog-actions]//span[text()='Delete']/..")).click();
        Thread.sleep(1000);
    }
}
