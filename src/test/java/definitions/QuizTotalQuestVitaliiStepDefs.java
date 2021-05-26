package definitions;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class QuizTotalQuestVitaliiStepDefs {
    String quizTitle = "QuizTotalQuestion";

    @Given("I created a quiz with {int} total question")
    public void iCreatedAQuizWithTotalQuestion(int questNumber) throws InterruptedException {
        if (questNumber == 1) {
            getDriver().findElement(By.xpath("//*[@formcontrolname='name']")).sendKeys(quizTitle);
            getDriver().findElement(By.xpath("//*[@class='mat-icon material-icons']")).click();
            getDriver().findElement(By.xpath("//*[contains(text(),'Q1')]/../../..//*[contains(text(),'Textual')]")).click();
            getDriver().findElement(By.xpath("//*[contains(text(),'Q1')]/../../..//*[@placeholder='Question *']")).sendKeys("Question Example");
            getDriver().findElement(By.xpath("//span[contains(text(),'Save')]")).click();
        } else if (questNumber == 50) {
            getDriver().findElement(By.xpath("//*[@formcontrolname='name']")).sendKeys(quizTitle);
            getDriver().findElement(By.xpath("//*[@class='mat-icon material-icons']")).click();
            for (int i = 1; i < 50; ++i) {
                getDriver().findElement(By.xpath("//*[contains(text(),'Q" + i + "')]/../../..//*[contains(text(),'Textual')]")).click();
                getDriver().findElement(By.xpath("//*[contains(text(),'Q" + i + "')]/../../..//*[@placeholder='Question *']")).sendKeys("Question Example");
                getDriver().findElement(By.xpath("//*[@class='mat-icon material-icons']")).click();
                Thread.sleep(100);
            }
            getDriver().findElement(By.xpath("//*[contains(text(),'Q50')]/../../..//*[contains(text(),'Textual')]")).click();
            getDriver().findElement(By.xpath("//*[contains(text(),'Q50')]/../../..//*[@placeholder='Question *']")).sendKeys("Question Example");
            getDriver().findElement(By.xpath("//span[contains(text(),'Save')]")).click();
        } else {
            System.out.println("A quiz with " + questNumber + " questions does not supported in this test");
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
        getDriver().findElement(By.xpath("//*[contains(text(),'" + quizTitle + "')]/../../..//span[text()='Delete']")).click();
        getDriver().findElement(By.xpath("//*[@aria-label='Close dialog']/*[text()='Delete']")).click();
        Thread.sleep(1000);
    }
}
