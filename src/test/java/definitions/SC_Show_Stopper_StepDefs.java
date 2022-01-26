package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;

public class SC_Show_Stopper_StepDefs {
    @And("I check a Show-Stopper question checkbox in {string}")
    public void iCheckAShowStopperQuestionCheckboxIn(String questionNumber) {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+questionNumber+"')]/../../..//span[contains(text(),'Show-Stopper')]")).click();
    }

    @And("I click on Preview of {string}")
    public void iClickOnPreviewOf(String quizTitle) throws InterruptedException {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(), '"+quizTitle+"')]")).click();
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(), '"+quizTitle+"')]/../../..//span[text()='Preview']")).click();
        Thread.sleep(1000);
    }
    @Then("Show-Stopper Question should be displayed in preview")
    public void showStopperQuestionShouldBeDisplayedInPreview() {
        assertThat(getDriver().findElement(By.xpath("//p[contains(text(),'Show-Stopper Question')]")).isDisplayed()).isTrue();
    }

    @And("I click close")
    public void iClickClose() {
        getDriver().findElement(By.xpath("//span[contains(text(),'Close')]")).click();
    }

    @And("I select checkbox {string} as correct option in {string}")
    public void iSelectCheckboxAsCorrectOptionIn(String optionNumber, String questionNumber) {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'" + questionNumber + "')]/../../..//textarea[@placeholder='" + optionNumber + "']/../../../../..//label[@class='mat-checkbox-layout']")).click();
    }

    @And("I delete my {string}")
    public void iDeleteMy(String quizTitle) throws InterruptedException {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(), '"+quizTitle+"')]/../../..//span[text()='Delete']")).click();
        getDriver().findElement(By.xpath("//div[@class ='mat-dialog-actions']//span[text()='Delete']")).click();
        Thread.sleep(1000);
    }
}
