package definitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.apache.commons.lang3.RandomStringUtils;
import org.openqa.selenium.By;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class QuizTotalQuestVitaliiStepDefs {
    String titleGenerator = RandomStringUtils.random(2, 1, 99, false, true);
    String quizTitle = "QuizTotalQuestion" + titleGenerator;

    @Given("I created a quiz with {int} total question")
    public void iCreatedAQuizWithTotalQuestion(int num) throws InterruptedException {
        if (num >= 1) {
            getDriver().findElement(By.xpath("//*[@formcontrolname='name']")).sendKeys(quizTitle);
            getDriver().findElement(By.xpath("//*[@class='mat-icon material-icons']")).click();
            for (int i = 1; i < num; ++i) {
                getDriver().findElement(By.xpath("//*[contains(text(),'Q" + i + "')]/../../..//*[contains(text(),'Textual')]")).click();
                getDriver().findElement(By.xpath("//*[contains(text(),'Q" + i + "')]/../../..//*[@placeholder='Question *']")).sendKeys("Question " + i + "");
                getDriver().findElement(By.xpath("//*[@class='mat-icon material-icons']")).click();
                Thread.sleep(200);
            }
            getDriver().findElement(By.xpath("//*[contains(text(),'Q" + num + "')]/../../..//*[contains(text(),'Textual')]")).click();
            getDriver().findElement(By.xpath("//*[contains(text(),'Q" + num + "')]/../../..//*[@placeholder='Question *']")).sendKeys("Question " + num + "");
            getDriver().findElement(By.xpath("//span[contains(text(),'Save')]")).click();
        } else {
            System.out.println("A quiz with " + num + " questions does not supported in this test");
        }
    }

    @When("I click on the quiz card")
    public void iClickOnTheQuizCard() {
        getDriver().findElement(By.xpath("//*[contains(text(),'" + quizTitle + "')]")).click();
    }

    @Then("I verify the quiz card has {string} in the title")
    public void iVerifyTheQuizCardHasInTheTitle(String expectedValue) {
        String actualValue = getDriver().findElement(By.xpath("//*[contains(text(),'" + quizTitle + "')]/../../..//*[@class='mat-expansion-panel-header-description']")).getText();
        assertThat(actualValue).containsIgnoringCase(expectedValue);
    }

    @Then("I verify the `Total Question` row has value {string}")
    public void iVerifyTheTotalQuestionRowHasValue(String expectedNumber) {
        getDriver().findElement(By.xpath("//*[contains(text(),'" + quizTitle + "')]/../../..//*[text()='Total Questions:']/../*[text()='" + expectedNumber + "']")).isDisplayed();
    }

    @When("I open the preview of the quiz")
    public void iOpenThePreviewOfTheQuiz() {
        getDriver().findElement(By.xpath("//*[contains(text(),'" + quizTitle + "')]/../../..//span[text()='Preview']")).click();
    }

    @Then("I verify the string {string} is displayed in the preview mode")
    public void iVerifyTheStringIsDisplayedInThePreviewMode(String expectedString) {
        getDriver().findElement(By.xpath("//*[contains(text(),'" + expectedString + "')]")).isDisplayed();
        getDriver().findElement(By.xpath("//button//*[text()='Close']")).click();
    }

    @When("I delete the quiz")
    public void iDeleteTheQuiz() throws InterruptedException {
        Thread.sleep(500);
        getDriver().findElement(By.xpath("//*[contains(text(),'" + quizTitle + "')]/../../..//span[text()='Delete']")).click();
        getDriver().findElement(By.xpath("//*[@aria-label='Close dialog']/*[text()='Delete']")).click();
        Thread.sleep(1000);
    }
}
