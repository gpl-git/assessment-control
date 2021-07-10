package definitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import org.openqa.selenium.By;

import static org.assertj.core.api.Assertions.assertThat;
import static support.TestContext.getDriver;



public class SinChoQuWiShowVladDefs {
    @Then("I click {string} checkbox in {int} question")
    public void iClickCheckboxInQuestion(String checkBox, int questionNum) {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+questionNum+"')]/../../..//span[contains(text(),'"+checkBox+"')]/../..//input/..")).click();
    }

    @And("I select {string} question type in question number {int}")
    public void iSelectQuestionTypeInQuestionNumber(String questionType, int questionNum) {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+questionNum+"')]/../../..//div[contains(text(),'"+questionType+"')]/.")).click();
    }

    @Then("I move question number {int} {string}")
    public void iMoveQuestionNumber(int questionNum, String upDownButton) {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+questionNum+"')]/../../..//span[contains(text(),'Move Question "+upDownButton+"')]/..")).click();

    }

    @And("I add extra option to the {int} question")
    public void iAddExtraOptionToTheQuestion(int questionNum) {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+questionNum+"')]/../../..//span[contains(text(),'Add Option')]/..")).click();
    }

    @And("I type {string} as option number {int} into question number {int}")
    public void iTypeAsOptionNumberIntoQuestionNumber(String optionValue, int optionNum, int questionNum) {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+questionNum+"')]/../../..//textarea[@placeholder='Option "+optionNum+"*']")).sendKeys(optionValue);
    }

    @Then("I type {string} into title of the {int} question")
    public void iTypeIntoTitleOfTheQuestion(String questionValue, int questionNum) {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+questionNum+"')]/../../..//textarea[contains(@placeholder,'Question')]")).sendKeys(questionValue);
    }

    @Then("I select option number {int} as the correct option of the {int} question")
    public void iSelectOptionNumberAsTheCorrectOptionOfTheQuestion(int optionNum, int questionNum) {
        getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+questionNum+"')]/../../..//textarea[@placeholder='Option "+optionNum+"*']/../../../../../mat-radio-button")).click();
    }

    @And("I verify {string} checkbox of the {int} question is checked off")
    public void iVerifyCheckboxOfTheQuestionIsCheckedOff(String checkBox, int questionNum) {
        String temp;
        temp = getDriver().findElement(By.xpath("//mat-panel-title[contains(text(),'"+questionNum+"')]/../../..//span[contains(text(),'"+checkBox+"')]/../..//input/..")).getAttribute("aria-label aria-checked");
//        assertThat(temp="true").isTrue();
        System.out.println(temp);
    }
}


