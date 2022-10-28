package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;


import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class QuizTotalStepDefs_NatalyaK {
    @Then("error message {string} should be displayed")
    public void errorMessageShouldBeDisplayed(String text) {
        assertThat(getDriver().findElement(By.xpath("//*[contains(text(), '" + text + "')]")).isDisplayed()).isTrue();
    }

    @When("I click on quiz name {string}")
    public void iClickOnQuizName(String quizName) {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(), '" + quizName + "')]")).click();
    }

    @When("I select {string} question in {string}")
    public void iSelectQuestionIn(String questionType, String questionNumber) {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+questionNumber+"')]/../../..//*[contains(text(), '"+questionType+"')]")).click();
    }

    @Then("Total Questions in quiz {string} should be equal to {int}")
    public void totalQuestionsInQuizShouldBeEqualTo(String quizName, int totalQuestions) {
        int actualTotal = Integer.parseInt(getDriver().findElement(By.xpath("//mat-panel-title[contains(text(), '"+quizName+"')]/../../..//tr[1]/td[2]")).getText());
        System.out.println(actualTotal);
        assertThat(totalQuestions == actualTotal).isTrue();
    }

    @And("I add {int} questions")
    public void iAddQuestions(int numbQuestions) throws InterruptedException {
        QuizStepDefs qsd = new QuizStepDefs();
        for (int i = 1; i <= numbQuestions; i++) {
            qsd.iAddAQuestion();
            Thread.sleep(1000);
            iSelectQuestionIn("Textual", "Q"+i);
            Thread.sleep(1000);
            qsd.iTypeInto("Question Q" + i + " text", "Q" + i);
            Thread.sleep(1000);
        }

    }
}
