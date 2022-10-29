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
    public void iClickOnQuizName(String title) {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(), '" + title + "')]")).click();
    }

    @When("I select {string} question in {string}")
    public void iSelectQuestionIn(String questionType, String questionNumber) {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'" + questionNumber + "')]/../../..//*[contains(text(), '" + questionType + "')]")).click();
    }

    @Then("Total Questions in quiz {string} should be equal to {int}")
    public void totalQuestionsInQuizShouldBeEqualTo(String title, int totalQuestions) {
        int actualTotal = Integer.parseInt(getDriver().findElement(By.xpath("//mat-panel-title[contains(text(), '" + title + "')]/../../..//tr[1]/td[2]")).getText());
        System.out.println(actualTotal);
        assertThat(totalQuestions == actualTotal).isTrue();
    }

    @And("I add {int} questions")
    public void iAddQuestions(int numbQuestions) throws InterruptedException {
        QuizStepDefs qsd = new QuizStepDefs();
        for (int i = 1; i <= numbQuestions; i++) {
            qsd.iAddAQuestion();
            Thread.sleep(1000);
            iSelectQuestionIn("Textual", "Q" + i);
            Thread.sleep(1000);
            qsd.iTypeInto("Question Q" + i + " text", "Q" + i);
            Thread.sleep(1000);
        }

    }

    @And("I add {int} single-choice questions")
    public void iAddSingleChoiceQuestions(int numbQuestions) throws InterruptedException {
        QuizStepDefs sd = new QuizStepDefs();
        for (int i = 1; i <= numbQuestions; i++) {
            sd.iAddAQuestion();
            Thread.sleep(1000);
            iSelectQuestionIn("Single-Choice", "Q" + i);
            Thread.sleep(1000);
            sd.iTypeInto("Question Q" + i + " single option text", "Q" + i);
            sd.iTypeAsIn("Option 1 in Q" + i, "Option 1*", "Q" + i);
            sd.iTypeAsIn("Option 2 in Q" + i, "Option 2*", "Q" + i);
            sd.iSelectAsCorrectOptionIn("Option 1*", "Q" + i);
            Thread.sleep(1000);

        }
    }

    @And("I select {string} as correct multi-choice option in {string}")
    public void iSelectAsCorrectMultiChoiceOptionIn(String optionNum, String questionNum) {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(), '" + questionNum + "')]/../../..//textarea[@placeholder='" + optionNum + "']/../../../../../mat-checkbox")).click();
    }

    @And("I include Other text area option for {string} question")
    public void iIncludeOtherTextAreaOptionForQuestion(String questionNum) {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(), '" + questionNum + "')]/../../..//span[contains(text(), 'Include \"Other\" text area option')]")).click();
    }

    @And("I click {string} button on {string}")
    public void iClickButtonOn(String buttonName, String questionNumber) {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(), '" + questionNumber + "')]/../../..//span[contains(text(), '" + buttonName + "')]")).click();
    }

    @And("I add {int} multiple-choice questions")
    public void iAddMultipleChoiceQuestions(int numbQuestions) throws InterruptedException {
        QuizStepDefs sd = new QuizStepDefs();
        for (int i = 1; i <= numbQuestions; i++) {
            sd.iAddAQuestion();
            Thread.sleep(1000);
            iSelectQuestionIn("Multiple-Choice", "Q" + i);
            Thread.sleep(1000);
            sd.iTypeInto("Question " + i + " multiple option text", "Q" + i);
            sd.iTypeAsIn("Option 1 in Q" + i, "Option 1*", "Q" + i);
            sd.iTypeAsIn("Option 2 in Q" + i, "Option 2*", "Q" + i);
            iClickButtonOn("Add Option", "Q" + i);
            sd.iTypeAsIn("Option 3 in Q" + i, "Option 3*", "Q" + i);
            iSelectAsCorrectMultiChoiceOptionIn("Option 1*", "Q" + i);
            iSelectAsCorrectMultiChoiceOptionIn("Option 3*", "Q" + i);
            iIncludeOtherTextAreaOptionForQuestion("Q" + i);
            Thread.sleep(1000);
        }
    }


}
