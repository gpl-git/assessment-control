package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import org.openqa.selenium.By;
import static org.assertj.core.api.Assertions.assertThat;

import static support.TestContext.getDriver;

public class annaBtQshowStopperAsteriskStepDefs {
    @Then("{string} should have asterisk")
    public void shouldHaveAsterisk(String questionNumber) {
         String qusName = getDriver().findElement(By.xpath("//mat-panel-title[contains(.,'" + questionNumber + "')]")).getText();
        assertThat(qusName.contains("*")).isTrue();
    }

    @When("I pick {string} question type")
    public void iSelectQuestionType(String questionType)  {
        getDriver().findElement(By.xpath("(//*[contains(text(),'"+questionType+"')])[last()]")).click();
    }

    @Then("{string} should not have the asterisk")
    public void shouldNotHaveTheAsterisk(String firstShowStopper) {
        String notAsterisk =  getDriver().findElement(By.xpath("//mat-panel-title[contains(.,'"+firstShowStopper+"')]")).getText();
        assertThat(notAsterisk.contains("*")).isFalse();
//        getDriver().findElement(By.xpath("//mat-panel-title[contains(.,'"+firstShowStopper+"')]"));
    }

    @And("I click on the quiz {string}")
    public void iClickOnTheQuiz(String quizName) throws InterruptedException{
        Thread.sleep(2000);
        getDriver().findElement(By.xpath("(//mat-panel-title[contains(text(),'"+ quizName +"')])[last()]")).click();
    }

    @And("{string} should have text {string}")
    public void shouldHaveText(String questName, String showStopper) {
        String showStopText = getDriver().findElement(By.xpath("//h5[contains(.,'"+questName+"')]/../p[contains(text(),'Show-Stopper Question')]")).getText();
        System.out.println("Found text: " + showStopText);
        System.out.println("Checking text: " + showStopper);
        assertThat(showStopText.contains(showStopper)).isTrue();
        System.out.println("Question number 2 is Show-Stopper Question");
    }

    @Then("I click {string} on quiz")
    public void iClickOnQuiz(String arg0) {
        getDriver().findElement(By.xpath("(//mat-panel-title[contains(text(),'Asterisk')])[last()]/../../..//span[contains(text(),'" + arg0 + "')]")).click();
    }

    @And("I confirm delete")
    public void iConfirmDelete() {
        getDriver().findElement(By.xpath("//ac-modal-confirmation//span[contains(text(),'Delete')]")).click();
    }
}
